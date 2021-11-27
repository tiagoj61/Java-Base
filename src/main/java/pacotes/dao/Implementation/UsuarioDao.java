package main.java.pacotes.dao.Implementation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import main.java.pacotes.bean.Telefone;
import main.java.pacotes.bean.Usuario;
import main.java.pacotes.common.AbstractDao;
import main.java.pacotes.dao.IUsuarioDao;

/**
 *
 * @author Tiago M
 */
public class UsuarioDao extends AbstractDao implements IUsuarioDao {
	public UsuarioDao() {
		super();
	}

	@Override
	public void persist(Usuario usuario, List<Telefone> telefones) {
		try {
			Long idUsuario = null;
			StringBuilder sql = new StringBuilder();

			sql.append("INSERT INTO public.usuario( nome, email,senha) ");
			sql.append("VALUES ( ?, ?,?); ");
			PreparedStatement preparedStatement = getConnection().prepareStatement(sql.toString());

			preparedStatement = getConnection().prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, usuario.getNome());
			preparedStatement.setString(2, usuario.getEmail());
			preparedStatement.setString(3, usuario.getSenha());

			preparedStatement.execute();
			ResultSet result = preparedStatement.getGeneratedKeys();
			if (result.next()) {
				System.out.println(result.getInt(1));
				idUsuario = Long.valueOf(String.valueOf(result.getInt(1)));
			}
			System.out.println(idUsuario);

			for (Telefone telefone : telefones) {
				sql = new StringBuilder();

				sql.append("INSERT INTO public.telefone(usuario_id, ddd, numero, tipo) ");
				sql.append("VALUES (?, ?, ?,?); ");

				preparedStatement = getConnection().prepareStatement(sql.toString());

				preparedStatement.setLong(1, idUsuario);
				preparedStatement.setInt(2, telefone.getDdd());
				preparedStatement.setString(3, telefone.getNumero());
				preparedStatement.setString(4, telefone.getTipo());

				preparedStatement.execute();

				preparedStatement.close();
			}

		} catch (

		SQLException e) {
			e.printStackTrace();
		}
	}

	public Usuario byEmail(String email) {
		Usuario usuario = null;
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT u.id from usuario u where u.email=? ");

		try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql.toString())) {
			preparedStatement.setString(1, email);
			try (ResultSet result = preparedStatement.executeQuery()) {
				while (result.next()) {
					usuario = new Usuario();
					usuario.setId(result.getLong("id"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return usuario;
	}

	@Override
	public void delete(Long idUsuario) {
		try {
			StringBuilder sql = new StringBuilder();

			sql.append("DELETE FROM telefone ");
			sql.append("WHERE usuario_id= ?");
			PreparedStatement preparedStatement;
			preparedStatement = getConnection().prepareStatement(sql.toString());
			preparedStatement.setLong(1, idUsuario);
			preparedStatement.execute();
			preparedStatement.close();

			sql = new StringBuilder();
			sql.append("DELETE FROM usuario ");
			sql.append("WHERE id= ?");
			preparedStatement = getConnection().prepareStatement(sql.toString());
			preparedStatement.setLong(1, idUsuario);
			preparedStatement.execute();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean login(String email, String senha) {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT u.id from usuario u where u.email=? and u.senha=?");

		try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql.toString())) {
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, senha);
			try (ResultSet result = preparedStatement.executeQuery()) {

				while (result.next()) {
					Usuario usuario = new Usuario();
					usuario.setId(result.getLong("id"));
					return true;
				}

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Usuario> listAll() {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT u.id,u.nome as nome, u.email as email from usuario u ");

		try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql.toString())) {
			try (ResultSet result = preparedStatement.executeQuery()) {
				while (result.next()) {
					Usuario usuario = new Usuario();
					usuario.setId(result.getLong("id"));
					usuario.setNome(result.getString("nome"));
					usuario.setEmail(result.getString("email"));
					usuarios.add(usuario);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return usuarios;
	}

	@Override
	public List<Telefone> load(Long id) {
		Usuario usuario = null;
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT u.id,u.nome as nome, u.email as email from usuario u where u.id=?");

		try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql.toString())) {
			preparedStatement.setLong(1, id);
			try (ResultSet result = preparedStatement.executeQuery()) {
				while (result.next()) {
					usuario = new Usuario();
					usuario.setId(result.getLong("id"));
					usuario.setNome(result.getString("nome"));
					usuario.setEmail(result.getString("email"));
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (usuario != null) {
			List<Telefone> telefones = null;
			sql = new StringBuilder();
			sql.append("SELECT t.ddd,t.numero,t.tipo from telefone t where t.usuario_id=?");
			try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql.toString())) {
				preparedStatement.setLong(1, id);
				try (ResultSet result = preparedStatement.executeQuery()) {
					telefones = new ArrayList<Telefone>();
					while (result.next()) {
						Telefone telefone = new Telefone();
						telefone.setDdd(result.getInt("ddd"));
						telefone.setNumero(result.getString("numero"));
						telefone.setTipo(result.getString("tipo"));
						telefone.setUsuario(usuario);
						telefones.add(telefone);
					}

				}
				if (telefones.size() < 1) {
					telefones = new ArrayList<Telefone>();
					telefones.add(new Telefone());
					telefones.get(0).setUsuario(usuario);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return telefones;

		}
		return null;

	}

}

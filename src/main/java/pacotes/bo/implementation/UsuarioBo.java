package main.java.pacotes.bo.implementation;

import java.util.List;

import main.java.pacotes.bean.Telefone;
import main.java.pacotes.bean.Usuario;
import main.java.pacotes.bo.IUsuarioBo;
import main.java.pacotes.dao.IUsuarioDao;
import main.java.pacotes.dao.Implementation.UsuarioDao;

/**
 *
 * @author Tiago M
 */
public class UsuarioBo implements IUsuarioBo {
	private IUsuarioDao dao;

	public UsuarioBo() {
		dao = new UsuarioDao();
	}

	@Override
	public Usuario load(Long id) {
		return null;
	}

	@Override
	public List<Telefone> loadAll(Long id) {
		return dao.load(id);
	}

	@Override
	public List<Usuario> listall() {
		return dao.listAll();
	}

	@Override
	public void persist(Usuario entity, List<Telefone> telefones) {
		dao.persist(entity, telefones);
	}

	@Override
	public void delete(long entityId) {
		dao.delete(entityId);
	}

	@Override
	public boolean login(String email, String senha) {
		return dao.login(email, senha);

	}

	@Override
	public void persist(Usuario entity) {
	}


}

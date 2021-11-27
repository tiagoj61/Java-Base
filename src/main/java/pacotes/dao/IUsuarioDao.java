package main.java.pacotes.dao;

import java.util.List;

import main.java.pacotes.bean.Telefone;
import main.java.pacotes.bean.Usuario;
/**
*
* @author Tiago M
*/
public interface IUsuarioDao {

	void persist(Usuario usuario, List<Telefone> telefones);

	void delete(Long idUsuario);

	boolean login(String email, String senha);

	List<Usuario> listAll();

	List<Telefone> load(Long id);

}

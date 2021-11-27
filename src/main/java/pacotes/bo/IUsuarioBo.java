package main.java.pacotes.bo;

import java.util.List;

import main.java.pacotes.bean.Telefone;
import main.java.pacotes.bean.Usuario;
import main.java.pacotes.common.IOperacoesComuns;

/**
 *
 * @author Tiago M
 */
public interface IUsuarioBo extends IOperacoesComuns<Usuario> {
	public boolean login(String email, String senha);

	List<Telefone> loadAll(Long id);

	public void persist(Usuario usuario, List<Telefone> telefones);
}

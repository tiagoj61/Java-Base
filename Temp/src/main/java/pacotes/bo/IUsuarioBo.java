package pacotes.bo;

import java.util.List;

import pacotes.bean.Telefone;
import pacotes.bean.Usuario;
import pacotes.common.IOperacoesComuns;

/**
 *
 * @author Tiago M
 */
public interface IUsuarioBo extends IOperacoesComuns<Usuario> {
	public boolean login(String email, String senha);

	List<Telefone> loadAll(Long id);

	public void persist(Usuario usuario, List<Telefone> telefones);
}

package pacotes.common;

import javax.servlet.http.HttpServlet;

import pacotes.bo.IUsuarioBo;
import pacotes.bo.implementation.UsuarioBo;
/**
*
* @author Tiago M
*/
public abstract class GenericUsuarioServelet extends HttpServlet {
	private IUsuarioBo usuarioBo = new UsuarioBo();

	public IUsuarioBo getUsuarioBo() {
		return usuarioBo;
	}

}

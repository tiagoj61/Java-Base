package main.java.pacotes.common;

import javax.servlet.http.HttpServlet;

import main.java.pacotes.bo.IUsuarioBo;
import main.java.pacotes.bo.implementation.UsuarioBo;
/**
*
* @author Tiago M
*/
public abstract class GenericUsuarioServelet extends HttpServlet {
	private IUsuarioBo usuarioBo = (IUsuarioBo) new UsuarioBo();

	public IUsuarioBo getUsuarioBo() {
		return usuarioBo;
	}

}

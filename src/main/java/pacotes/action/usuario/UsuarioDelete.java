package main.java.pacotes.action.usuario;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import main.java.pacotes.common.GenericUsuarioServelet;

/**
 *
 * @author Tiago M
 */
@WebServlet(urlPatterns = { "/app/usuario/usuarioDelete" })
public class UsuarioDelete extends GenericUsuarioServelet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			getUsuarioBo().delete(Long.valueOf(request.getParameter("usuario.id")));
			JSONObject resp = new JSONObject();
			resp.put("notify", true);
			response.setContentType("application/json");
			response.getWriter().write(resp.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

package pacotes.action.usuario;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import pacotes.common.GenericUsuarioServelet;

/**
 *
 * @author Tiago M
 */
@WebServlet(urlPatterns = { "/app/home/usuarioLogin" })
public class UsuarioLogin extends GenericUsuarioServelet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("asdasd");
		if(request.getSession().getAttribute("login")!=null) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/app/usuario");
			requestDispatcher.forward(request, response);
		}else {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/app/home");
			requestDispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		JSONObject resp = new JSONObject();
		if (getUsuarioBo().login(request.getParameter("emailUsuario"), request.getParameter("senhaUsuario"))) {
			resp.put("ok", true);
		} else {
			resp.put("ok", false);
		}
		request.getSession().setAttribute("msgErro", "Email ou Senha incorretos!");
		response.setContentType("application/json");
		response.getWriter().write(resp.toString());
		request.getSession().setAttribute("login", "logged");
	}

}

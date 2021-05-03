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
@WebServlet( urlPatterns = { "/app/home/usuarioList" })
public class UsuarioList extends GenericUsuarioServelet {


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		JSONObject resp = new JSONObject();
		String option = request.getParameter("option");
		request.getSession().setAttribute("msgErro", "Email ou Senha incorretos!");
		resp.put("ok", false);
		response.setContentType("application/json");
		response.getWriter().write(resp.toString());
	}

}

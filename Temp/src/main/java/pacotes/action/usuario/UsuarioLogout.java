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

import org.json.JSONArray;
import org.json.JSONObject;

import pacotes.bean.Telefone;
import pacotes.bean.Usuario;
import pacotes.bo.IUsuarioBo;
import pacotes.common.GenericUsuarioServelet;
/**
 *
 * @author Tiago M
 */
@WebServlet(urlPatterns = { "/app/usuario/usuarioLogout" })
public class UsuarioLogout extends GenericUsuarioServelet {
	JSONObject resposta;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.getSession().removeAttribute("login");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/app/home");
			requestDispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	

}

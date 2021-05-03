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

import pacotes.bean.Usuario;
import pacotes.common.GenericUsuarioServelet;

/**
 *
 * @author Tiago M
 */
@WebServlet(urlPatterns = { "/app/usuario/usuarioListAll" })
public class UsuarioListAll extends GenericUsuarioServelet {
	JSONObject usuario;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			List<Usuario> usuarios = getUsuarioBo().listall();
			JSONArray usuariosRetorno = new JSONArray();
			usuarios.forEach(usu -> {
				usuario = new JSONObject();
				usuario.put("id", usu.getId());
				usuario.put("nome", usu.getNome());
				usuario.put("email", usu.getEmail());
				usuariosRetorno.put(usuario);
			});
			response.setContentType("application/json");
			response.getWriter().write(usuariosRetorno.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}



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
@WebServlet(urlPatterns = { "/app/usuario/usuarioEditar" })
public class UsuarioEditar extends GenericUsuarioServelet {
	JSONObject resposta;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.getSession().setAttribute("usuario", request.getParameter("usuario.id"));
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/app/usuario/formulario.jsp");
			requestDispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.getSession().removeAttribute("usuario");
			List<Telefone> telefones = getUsuarioBo().loadAll(Long.valueOf(request.getParameter("idUsuario")));
			JSONArray retorno = new JSONArray();
			telefones.forEach(telefone->{
				resposta= new JSONObject();
				resposta.put("nome",telefone.getUsuario().getNome());
				resposta.put("email",telefone.getUsuario().getEmail());
				resposta.put("ddd",telefone.getDdd());
				resposta.put("numero",telefone.getNumero());
				resposta.put("tipo",telefone.getTipo());
				retorno.put(resposta);
			});
			response.setContentType("application/json");
			response.getWriter().write(retorno.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

		

	}

}

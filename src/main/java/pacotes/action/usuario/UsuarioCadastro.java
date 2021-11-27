package main.java.pacotes.action.usuario;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import main.java.pacotes.bean.Telefone;
import main.java.pacotes.bean.Usuario;
import main.java.pacotes.common.GenericUsuarioServelet;

/**
 *
 * @author Tiago M
 */
@WebServlet(urlPatterns = { "/app/home/usuarioCadastro" })
public class UsuarioCadastro extends GenericUsuarioServelet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Usuario usuario = new Usuario();
			List<Telefone> telefones = new ArrayList<Telefone>();
			usuario.setNome(request.getParameter("nomeUsuario"));
			usuario.setEmail(request.getParameter("emailUsuario"));
			usuario.setSenha(request.getParameter("senhaUsuario"));
			if (request.getParameterValues("telefonesUsuario[]") != null) {
				for (int i = 0; i < request.getParameterValues("telefonesUsuario[]").length; i++) {
					Telefone telefone = new Telefone();
					telefone.setDdd(Integer.valueOf(request.getParameterValues("ddds[]")[i]));
					telefone.setNumero(request.getParameterValues("telefonesUsuario[]")[i]);
					telefone.setTipo(request.getParameterValues("tipos[]")[i]);
					telefones.add(telefone);
				}
			}
			getUsuarioBo().persist(usuario,telefones);
			request.getSession().setAttribute("login", "logged");
			JSONObject resp = new JSONObject();
			resp.put("notify", true);
			response.setContentType("application/json");
			response.getWriter().write(resp.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

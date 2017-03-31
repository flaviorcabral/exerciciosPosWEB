package br.unipe.posweb.visao;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

/**
 * Servlet implementation class TarefaServlet
 */
@WebServlet("/tarefaservlet.do")
public class TarefaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TarefaServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		Random gerador = new Random();
		Integer numeroGerado = (Integer) session.getAttribute("numGerado");

		if (numeroGerado == null) {
			numeroGerado = new Integer(gerador.nextInt(1000) + 1);
			session.setAttribute("numGerado", numeroGerado);
		}

		if (request.getParameter("numero") != "") {
			String numeroUsuario = request.getParameter("numero");
			int numeroInt = Integer.parseInt(numeroUsuario);

			String teste = checarNumero(numeroInt, numeroGerado, session);

			request.setAttribute("numGerado", numeroGerado);
			request.setAttribute("teste", teste);
			RequestDispatcher rd = request.getRequestDispatcher("/paginas/index.jsp");
			rd.forward(request, response);

		}
	}

	public String checarNumero(int numeroUsuario, int numeroGerado, HttpSession session) {

		if (numeroUsuario == numeroGerado) {

			session.removeAttribute("numGerado");
			return "Parabéns, você acertou o numero!";
		} else {
			if (numeroUsuario > numeroGerado) {
				return "Ainda não acertou, o numero " + numeroUsuario + " é maior que o fornecido. Tente outro numero.";
			} else {
				if (numeroUsuario < numeroGerado) {
					return "Ainda não acertou, o numero " + numeroUsuario
							+ " é menor que o fornecido. Tente outro numero.";
				}
			}
		}

		return null;

	}

}

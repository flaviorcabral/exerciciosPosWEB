package br.unipe.posweb.visao;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.unipe.posweb.modelo.Usuarios;
import br.unipe.posweb.service.usuarioService;

/**
 * Servlet implementation class usuarioServelet
 */
@WebServlet("/usuarioServlet.do")
public class usuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private usuarioService service = new usuarioService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public usuarioServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();
		String opcao = request.getParameter("acao");

		if (opcao.equalsIgnoreCase("salvar")) {
			try {

				boolean busca = buscar(request);
				
				if (!busca) {
					salvar(request);
					String status = "cadOK";
					request.setAttribute("status", status);
					RequestDispatcher rd = request.getRequestDispatcher("/paginas/confUsers.jsp");
					rd.forward(request, response);
					// System.out.println("Incluido com sucesso");
				} else {
					String status = "erroCad";
					request.setAttribute("status", status);
					RequestDispatcher rd = request.getRequestDispatcher("/paginas/confUsers.jsp");
					rd.forward(request, response);
				}

			} catch (SQLException | ClassNotFoundException e) {
				//System.out.println("Erro na inclusao do registro");
				e.printStackTrace();
			}
		} else {
			if (opcao.equalsIgnoreCase("logar")) {
				try {
					if (logar(request)) {
						String login = (String) session.getAttribute("login");

						if (login == null) {
							login = request.getParameter("usuario");
							session.setAttribute("login", login);
						}

						RequestDispatcher rd = request.getRequestDispatcher("/paginas/check.jsp");
						rd.forward(request, response);
						// System.out.println("Login efetuado com sucesso!");
					} else {
						String status = "erroLogin";
						request.setAttribute("status", status);
						RequestDispatcher rd = request.getRequestDispatcher("/paginas/confUsers.jsp");
						rd.forward(request, response);
					}
				} catch (SQLException | ClassNotFoundException e) {
					//System.out.println("Erro na tentativa de acesso!");
					e.printStackTrace();
				}
			} else {
				if (opcao.equals("cadastrar")) {
					try {
						response.setContentType("text/html");
						response.sendRedirect("paginas/cadastro.jsp");
						// System.out.println("Redirecionando pra tela de
						// cadastro!");
					} catch (Exception e) {
						// System.out.println("Erro ao direcionar para tela de
						// cadastro!");
						e.printStackTrace();
					}
				} else {
					if (opcao.equals("sair")) {
						try {
							session.removeAttribute("login");
							response.setContentType("text/html");
							response.sendRedirect("paginas/index.jsp");
						} catch (Exception e) {
							// System.out.println("Erro ao encerrar sessao do
							// usuario!");
							e.printStackTrace();
						}
					}
				}
			}
		}
	}

	private void salvar(HttpServletRequest request) throws SQLException, ClassNotFoundException {
		Usuarios usuario = new Usuarios();

		String nome = request.getParameter("nome");
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		usuario.setNome(nome);
		usuario.setUsername(username);
		usuario.setPassword(password);

		service.salvarUsuario(usuario);
	}

	private boolean buscar(HttpServletRequest request) throws ClassNotFoundException, SQLException {
		boolean teste = false;

		String username = request.getParameter("username");

		teste = service.buscar(username);

		return teste;
	}

	private boolean logar(HttpServletRequest request) throws ClassNotFoundException, SQLException {
		boolean teste;

		String username = request.getParameter("usuario");
		String password = request.getParameter("senha");

		teste = service.logar(username, password);

		if (teste) {
			return true;
		}

		return false;
	}

}

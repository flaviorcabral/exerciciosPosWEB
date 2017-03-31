package br.unipe.posweb.visao;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.unipe.posweb.modelo.Assentos;
import br.unipe.posweb.service.reservaService;

@WebServlet("/reservaServlet.do")
public class reservaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private reservaService service = new reservaService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public reservaServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String opcao = request.getParameter("acao");
		String fila = request.getParameter("fila");
		String poltrona = request.getParameter("poltrona");

		if (opcao.equalsIgnoreCase("reservar")) {
			try {
				if (request.getParameter("fila") != "") {
					if (!checkLotacao(request)) {
						if (!buscar(request)) {
							salvar(request);
							String status = "ok";
							request.setAttribute("status", status);
							request.setAttribute("fila", fila);
							request.setAttribute("poltrona", poltrona);

							RequestDispatcher rd = request.getRequestDispatcher("/paginas/confReserva.jsp");
							rd.forward(request, response);
							System.out.println("Incluido com sucesso");
						} else {
							String status = "reservado";
							request.setAttribute("status", status);
							request.setAttribute("fila", fila);
							request.setAttribute("poltrona", poltrona);
							RequestDispatcher rd = request.getRequestDispatcher("/paginas/confReserva.jsp");
							rd.forward(request, response);
						}
					} else {
						String status = "lotado";
						request.setAttribute("status", status);
						request.setAttribute("fila", fila);
						request.setAttribute("poltrona", poltrona);
						RequestDispatcher rd = request.getRequestDispatcher("/paginas/confReserva.jsp");
						rd.forward(request, response);
					}
				}
			} catch (SQLException | ClassNotFoundException e) {
				System.out.println("Erro na inclusao do registro");
				e.printStackTrace();
			}
		}
	}

	private void salvar(HttpServletRequest request) throws SQLException, ClassNotFoundException {
		Assentos assento = new Assentos();

		String poltrona = request.getParameter("poltrona");
		String fila = request.getParameter("fila");

		assento.setPoltrona(poltrona);
		assento.setFila(fila);

		service.salvarReserva(assento);
	}

	private boolean buscar(HttpServletRequest request) throws ClassNotFoundException, SQLException {
		boolean busca;

		String poltrona = request.getParameter("poltrona");
		String fila = request.getParameter("fila");
		busca = service.buscar(poltrona, fila);

		return busca;
	}

	private boolean checkLotacao(HttpServletRequest request) throws ClassNotFoundException, SQLException {
		boolean busca;

		busca = service.buscaCheks();

		return busca;
	}

}

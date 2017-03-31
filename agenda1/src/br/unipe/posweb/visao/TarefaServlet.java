package br.unipe.posweb.visao;

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

import br.unipe.posweb.modelo.Tarefa;
import br.unipe.posweb.service.TarefaService;

/**
 * Servlet implementation class TarefaServlet
 */
@WebServlet("/tarefaservlet.do")
public class TarefaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TarefaService service = new TarefaService();
	private Tarefa tarefa;
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

		String opcao = request.getParameter("acao");

		if (opcao.equalsIgnoreCase("incluir")) {
			try {
				if(request.getParameter("nome") != ""){
				salvar(request);
				//response.setContentType("text/html");
				//response.sendRedirect("confSalva.html");
				RequestDispatcher rd = request.getRequestDispatcher("/paginas/confSalva.jsp");
				rd.forward(request, response);
				//System.out.println("Incluido com sucesso");
				}else{
					RequestDispatcher rd = request.getRequestDispatcher("/paginas/confSalva.jsp");
					rd.forward(request, response);
				}
			} catch (SQLException | ClassNotFoundException e) {
				//System.out.println("Erro na inclusao do registro");
				e.printStackTrace();
			}
		}else{
			if(opcao.equalsIgnoreCase("listar")){
				List<Tarefa> lista = new ArrayList<>();
				 try {
					lista = service.listarTodas();
					request.setAttribute("lista", lista);
					RequestDispatcher rd = request.getRequestDispatcher("/paginas/listarTarefas.jsp");
					rd.forward(request, response);
					//System.out.println("Lista enviada a pagina");
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
					//System.out.println("Erro ao enviar a lista");
				}
			}else{
				if(opcao.equalsIgnoreCase("excluir")){
					try {
						excluir(request);
						//response.sendRedirect("/paginas/confDelete.jsp");
						RequestDispatcher rd = request.getRequestDispatcher("/paginas/confDelete.jsp");
						rd.forward(request, response);
						//System.out.println("Registro excluido com sucesso!");
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}else{
					if(opcao.equalsIgnoreCase("buscaTarefa")){
		
						try {
							this.tarefa = buscar(request);
							request.setAttribute("tarefa", tarefa);
							RequestDispatcher rd = request.getRequestDispatcher("/paginas/editarTarefa.jsp");
							rd.forward(request, response);
							System.out.println("Objeto tarefa enviado");
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}else{
						if(opcao.equalsIgnoreCase("editar")){
							try {
								editar(request);//Erro no metodo de editar (Não Atualiza), busca e exibe na tela os dados para atualizar.
								RequestDispatcher rd = request.getRequestDispatcher("/paginas/confUpdate.jsp");
								rd.forward(request, response);
								System.out.println("Registro ediatado com sucesso");
							} catch (ClassNotFoundException e) {
								e.printStackTrace();
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
		}

	}
	
	private void salvar(HttpServletRequest request) throws SQLException, ClassNotFoundException{
		Tarefa tarefa = new Tarefa();
		
		String nome = request.getParameter("nome");
		String descricao = request.getParameter("descricao");
		String data = request.getParameter("data");
		
		tarefa.setNome(nome);
		tarefa.setDescricao(descricao);
		tarefa.setData(data);
		
		service.salvarTarefa(tarefa);
	}
	
	private void excluir(HttpServletRequest request) throws ClassNotFoundException, SQLException{
		
		String nome =request.getParameter("nome");
		
		service.excluiTarefa(nome);
	}
	
	private void editar(HttpServletRequest request) throws ClassNotFoundException, SQLException{
		Tarefa tarefa = new Tarefa();
		String nome = request.getParameter("nome");
		String descricao = request.getParameter("descricao");
		String data = request.getParameter("data");
		
		tarefa.setNome(nome);
		tarefa.setDescricao(descricao);
		tarefa.setData(data);
		
		service.editarTarefa(tarefa);

	}
	
	private Tarefa buscar(HttpServletRequest request) throws ClassNotFoundException, SQLException{
		Tarefa tarefa = new Tarefa();
		
		String nome = request.getParameter("nome");
		tarefa = service.buscarTarefa(nome);
		
		return tarefa;
	}
	
	

}

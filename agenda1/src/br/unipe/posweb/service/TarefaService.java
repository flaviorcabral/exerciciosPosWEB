package br.unipe.posweb.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.unipe.posweb.integracao.TarefaDAO;
import br.unipe.posweb.modelo.Tarefa;

public class TarefaService {
	
TarefaDAO dao = new TarefaDAO();
	
	public void salvarTarefa(Tarefa tarefa) throws SQLException, ClassNotFoundException{
		dao.salvar(tarefa);
	}
	
	public List<Tarefa> listarTodas() throws ClassNotFoundException, SQLException{
		List<Tarefa> lista = new ArrayList<>();
		
		lista = dao.listar();
		
		return lista;
	}
	
	public void excluiTarefa(String nome) throws ClassNotFoundException, SQLException{
		dao.delete(nome);
	}
	
	public void editarTarefa(Tarefa tarefa) throws ClassNotFoundException, SQLException{
		dao.editar(tarefa);
	}
	
	public Tarefa buscarTarefa(String nome) throws ClassNotFoundException, SQLException{
		Tarefa tarefa = new Tarefa();
		tarefa = dao.busca(nome);
		
		return tarefa;
	}
}

package br.unipe.posweb.integracao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.unipe.posweb.conexao.Conexao;
import br.unipe.posweb.modelo.Tarefa;

public class TarefaDAO {
	
	Conexao con = new Conexao();
	
	private String sqlIncluir = "INSERT INTO tarefa (nome, descricao, data) VALUES (?,?,?)";
	private String sqlListar = "SELECT * FROM tarefa";
	private String sqlExcluir = "DELETE FROM tarefa WHERE nome = ?";
	private String sqlUpdate = "UPDATE tarefa SET nome = ?, descricao = ?, data = ? WHERE nome = ?";
	private String sqlBusca = "SELECT * FROM tarefa WHERE nome = ?";
	
	/**
	 * Metodo salvar tarefas na base de dados
	 * @param tarefa Tarefa tarefa
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void salvar(Tarefa tarefa) throws SQLException, ClassNotFoundException {

		Connection conexao = con.getConexao();
		PreparedStatement stmt = null;
		try {
			stmt = conexao.prepareStatement(sqlIncluir);
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("conexao.prepareStatement(sqlIncluir)...Erro!!!");
		}
		

		stmt.setString(1, tarefa.getNome());
		stmt.setString(2, tarefa.getDescricao());
		stmt.setString(3, tarefa.getData());
		stmt.execute();

	}
	
	/**
	 * Metodo listar tarefas na base de dados
	 * @return List de Tarefas
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<Tarefa> listar() throws ClassNotFoundException, SQLException{
		Tarefa tarefa;
		List<Tarefa> lista = new ArrayList<>();
		
		Connection conexao = con.getConexao();
		java.sql.Statement stmt = conexao.createStatement();
		
		ResultSet rs = stmt.executeQuery(sqlListar);
		
		while (rs.next()) {
			tarefa = new Tarefa();
			String nome = rs.getString("nome");
			String descricao = rs.getString("descricao");
			String data = rs.getString("data");
			
			tarefa.setNome(nome);
			tarefa.setDescricao(descricao);
			tarefa.setData(data);
			
			lista.add(tarefa);
		}
		
		return lista;
	}
	
	/**
	 * Metodo deletar tarefas da base de dados
	 * @param  String nome
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void delete(String nome) throws ClassNotFoundException, SQLException{
		Connection conexao = con.getConexao();
		
		PreparedStatement stmt = conexao.prepareStatement(sqlExcluir);
		stmt.setString(1,nome);
		if(stmt.execute()){
			System.out.println("Registro excluido com sucesso");
		}
	}
	
	/**
	 * Metodo editar ou atualizar dados da tarefa na base de dados
	 * @param tarefa Tarefa tarefa
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void editar(Tarefa tarefa) throws ClassNotFoundException, SQLException{//Está dando erro !!!!
		Connection conexao = con.getConexao();
		String nome = tarefa.getNome();
		String descricao = tarefa.getDescricao(); 
		String data = tarefa.getData();
		
		PreparedStatement stmt = conexao.prepareStatement(sqlUpdate);
		stmt.setString(1, nome);
		stmt.setString(2, descricao);
		stmt.setString(3, data);
		stmt.setString(4, nome);
		
		stmt.executeUpdate(); //Está dando erro na execuçaõ desse metodo
	}
	
	/**
	 * Metodo buscar tarefa especifica na base de dados
	 * @param nome String nome
	 * @return Tarefa tarefa
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Tarefa busca(String nome) throws ClassNotFoundException, SQLException{
		Tarefa tarefa = null;
		Connection conexao = con.getConexao();
		
		PreparedStatement stmt = conexao.prepareStatement(sqlBusca);
		stmt.setString(1, nome);
		
		ResultSet rs = stmt.executeQuery();
		
		while (rs.next()) {
			tarefa = new Tarefa();
			
			String dado = rs.getString("nome");
			String descricao = rs.getString("descricao");
			String data = rs.getString("data");
			
			tarefa.setNome(dado);
			tarefa.setDescricao(descricao);
			tarefa.setData(data);
		}
		
		return tarefa;
	}
}

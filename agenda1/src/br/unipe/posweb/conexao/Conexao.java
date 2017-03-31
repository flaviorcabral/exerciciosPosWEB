package br.unipe.posweb.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	private String usuario = "root";
	private String senha = "";
	private String server = "jdbc:mysql://localhost/tarefas";
	
	/**
	 * Metodo de conexao ao banco
	 * @return 
	 * @throws ClassNotFoundException
	 Teste github
	 */
	public Connection getConexao() throws ClassNotFoundException{
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(server,usuario, senha);
			System.out.println("Conexao bem sucedida!!");
		} catch (SQLException e) {
			System.out.println("Erro de conexao");
			e.printStackTrace();
		}
		
		return con;
	}
}

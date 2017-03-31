package br.unipe.posweb.integracao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.unipe.posweb.conexao.Conexao;
import br.unipe.posweb.modelo.Usuarios;

public class UsuariosDAO {
	
Conexao con = new Conexao();
	
	private String sqlIncluir = "INSERT INTO usuario (nome, username, password) VALUES (?,?,?)";
	private String sqlListar = "SELECT * FROM usuario";
	private String sqlBusca = "SELECT * FROM usuario WHERE username = ?";
	private String sqlLogar = "SELECT * FROM usuario WHERE username = ? AND password = ?";
	
	public void salvar(Usuarios usuario) throws SQLException, ClassNotFoundException {

		Connection conexao = con.getConexao();
		PreparedStatement stmt = null;
		try {
			stmt = conexao.prepareStatement(sqlIncluir);
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("conexao.prepareStatement(sqlIncluir)...Erro!!!");
		}
		
		stmt.setString(1, usuario.getNome());
		stmt.setString(2, usuario.getUsername());
		stmt.setString(3, usuario.getPassword());
		
		stmt.execute();

	}
	
	
	public List<Usuarios> listar() throws ClassNotFoundException, SQLException{
		Usuarios usuario;
		List<Usuarios> lista = new ArrayList<>();
		
		Connection conexao = con.getConexao();
		java.sql.Statement stmt = conexao.createStatement();
		
		ResultSet rs = stmt.executeQuery(sqlListar);
		
		while (rs.next()) {
			usuario = new Usuarios();
			String nome = rs.getString("nome");
			String username = rs.getString("username");
			String password = rs.getString("password");
			
			usuario.setNome(nome);
			usuario.setUsername(username);
			usuario.setPassword(password);;
			
			lista.add(usuario);
		}
		
		return lista;
	}
	
	
	public Usuarios busca(String username) throws ClassNotFoundException, SQLException{
		Usuarios usuario = null;
		Connection conexao = con.getConexao();
		
		PreparedStatement stmt = conexao.prepareStatement(sqlBusca);
		stmt.setString(1, username);
		
		
		ResultSet rs = stmt.executeQuery();
		
		while (rs.next()) {
			usuario = new Usuarios();
			
			String user = rs.getString("username");
			
		
			usuario.setUsername(user);
			
		}
		
		return usuario;
	}
	
	public Usuarios logar(String username, String password) throws ClassNotFoundException, SQLException{
		Usuarios usuario = null;
		Connection conexao = con.getConexao();
		
		PreparedStatement stmt = conexao.prepareStatement(sqlLogar);
		stmt.setString(1, username);
		stmt.setString(2, password);
		
		
		ResultSet rs = stmt.executeQuery();
		
		while (rs.next()) {
			usuario = new Usuarios();
			
			String user = rs.getString("username");
			String passw = rs.getString("password");
			
		
			usuario.setUsername(user);
			usuario.setPassword(passw);
			
		}
		
		return usuario;
	}
	
	}

package br.unipe.posweb.modelo;

public class Usuarios {
	
	private int id;
	private String nome;
	private String username;
	private String password;
	

	public int getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}

	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

}

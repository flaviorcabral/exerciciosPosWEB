package br.unipe.posweb.integracao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.unipe.posweb.conexao.Conexao;
import br.unipe.posweb.modelo.Assentos;

public class ReservaDAO {

	Conexao con = new Conexao();

	private String sqlIncluir = "INSERT INTO assentos (poltrona, fila) VALUES (?,?)";
	private String sqlListar = "SELECT * FROM assentos";
	private String sqlBusca = "SELECT * FROM assentos WHERE poltrona = ? AND fila = ?";
	private String sqlBuscaPoltronas = "SELECT poltrona FROM assentos";
	private String sqlBuscaFilas = "SELECT fila FROM assentos";

	public void salvar(Assentos assento) throws SQLException, ClassNotFoundException {

		Connection conexao = con.getConexao();
		PreparedStatement stmt = null;
		try {
			stmt = conexao.prepareStatement(sqlIncluir);
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("conexao.prepareStatement(sqlIncluir)...Erro!!!");
		}

		stmt.setString(1, assento.getPoltrona());
		stmt.setString(2, assento.getFila());

		stmt.execute();

	}

	public List<Assentos> listar() throws ClassNotFoundException, SQLException {
		Assentos assento;
		List<Assentos> lista = new ArrayList<>();

		Connection conexao = con.getConexao();
		java.sql.Statement stmt = conexao.createStatement();

		ResultSet rs = stmt.executeQuery(sqlListar);

		while (rs.next()) {
			assento = new Assentos();
			String poltrona = rs.getString("poltrona");
			String fila = rs.getString("fila");

			assento.setPoltrona(poltrona);
			assento.setFila(fila);

			lista.add(assento);
		}

		return lista;
	}

	public Assentos busca(String poltrona, String fila) throws ClassNotFoundException, SQLException {
		Assentos assento = null;
		Connection conexao = con.getConexao();

		PreparedStatement stmt = conexao.prepareStatement(sqlBusca);
		stmt.setString(1, poltrona);
		stmt.setString(2, fila);

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			assento = new Assentos();

			String poltron = rs.getString("poltrona");
			String fil = rs.getString("fila");

			assento.setPoltrona(poltron);
			assento.setFila(fil);
		}

		return assento;
	}

	public Assentos buscaPoltronas() throws ClassNotFoundException, SQLException {
		Assentos poltronas = null;
		Connection conexao = con.getConexao();

		PreparedStatement stmt = conexao.prepareStatement(sqlBuscaPoltronas);

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			poltronas = new Assentos();

			String poltron = rs.getString("poltrona");

			poltronas.setPoltrona(poltron);

		}

		return poltronas;
	}

}

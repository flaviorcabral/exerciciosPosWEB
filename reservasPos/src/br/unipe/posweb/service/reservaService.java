package br.unipe.posweb.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.unipe.posweb.integracao.ReservaDAO;
import br.unipe.posweb.modelo.Assentos;

public class reservaService {

	ReservaDAO dao = new ReservaDAO();

	public void salvarReserva(Assentos assento) throws SQLException, ClassNotFoundException {
		dao.salvar(assento);
	}

	public List<Assentos> listarTodas() throws ClassNotFoundException, SQLException {
		List<Assentos> lista = new ArrayList<>();

		lista = dao.listar();

		return lista;
	}

	public boolean buscar(String poltrona, String fila) throws ClassNotFoundException, SQLException {
		Assentos assento = new Assentos();
		assento = dao.busca(poltrona, fila);

		if (assento != null) {
			return true;
		}

		return false;
	}

	public boolean buscaCheks() throws ClassNotFoundException, SQLException {
		boolean busca = false;

		List<String> filas = new ArrayList<>();
		List<String> poltronas = new ArrayList<>();
		filas.add("1");
		filas.add("2");
		filas.add("3");
		filas.add("4");
		poltronas.add("A");
		poltronas.add("B");
		poltronas.add("C");
		poltronas.add("D");

		for (int i = 0; i < filas.size(); i++) {
			for (int j = 0; j < poltronas.size(); j++) {
				String poltrona = poltronas.get(j);
				String fila = filas.get(i);
				busca = buscar(poltrona, fila);

				if (!busca) {
					return false;
				}
			}
		}

		return true;
	}

}

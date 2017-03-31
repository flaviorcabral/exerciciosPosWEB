package br.unipe.posweb.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.unipe.posweb.integracao.UsuariosDAO;
import br.unipe.posweb.modelo.Usuarios;

public class usuarioService {

	UsuariosDAO dao = new UsuariosDAO();

	public void salvarUsuario(Usuarios usuario) throws SQLException, ClassNotFoundException {
		dao.salvar(usuario);
	}

	public List<Usuarios> listarTodas() throws ClassNotFoundException, SQLException {
		List<Usuarios> lista = new ArrayList<>();

		lista = dao.listar();

		return lista;
	}

	public boolean buscar(String username) throws ClassNotFoundException, SQLException {
		Usuarios usuario = new Usuarios();
		usuario = dao.busca(username);

		if (usuario != null) {
			return true;
		}
		return false;
	}

	public boolean logar(String username, String password) throws ClassNotFoundException, SQLException {
		Usuarios usuario = new Usuarios();
		usuario = dao.logar(username, password);

		if (usuario != null) {
			return true;
		}
		return false;
	}

}

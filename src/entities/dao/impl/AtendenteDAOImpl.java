package entities.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Atendente;

public class AtendenteDAOImpl {
	private static final String URL = "jdbc:mariadb://localhost:3306/clinica";
	private static final String USER = "admin";
	private static final String PASSWORD = "1234";

	public AtendenteDAOImpl() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Atendente> encontrarTodos() {
		List<Atendente> lista = new ArrayList<>();
		try {
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement ps = conn
					.prepareStatement("SELECT atendente.* FROM atendente");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Atendente p = instanciarAtendente(rs);
				lista.add(p);
			}
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Atendente instanciarAtendente(ResultSet rs) throws SQLException {
		Atendente p = new Atendente();
		p.setLogin(rs.getString("login"));
		p.setSenha(rs.getString("senha"));
		return p;
	}
}

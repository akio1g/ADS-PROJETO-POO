package entities.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import application.Principal;
import entities.Consulta;
import entities.Medico;
import entities.Paciente;
import entities.dao.ConsultaDAO;

public class ConsultaDAOImpl implements ConsultaDAO {
	private static final String URL = "jdbc:mariadb://localhost:3306/clinica";
	private static final String USER = "admin";
	private static final String PASSWORD = "1234";

	public ConsultaDAOImpl() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void inserir(Consulta consulta) {
		try {
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement ps = conn.prepareStatement("INSERT INTO consultas VALUES " + "(null,?,?,?,?);");
			ps.setInt(1, pegarIdCpf(consulta.getCpf()));
			ps.setInt(2, pegarIdNomeMedico(consulta.getNome()));
			ps.setDate(3, java.sql.Date.valueOf(consulta.getConsultaDia()));
			ps.setTime(4, java.sql.Time.valueOf(consulta.getConsultaHora()));
			ps.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Integer devolverId(String nomeMedico,String cpf) {
		Connection conn;
		Integer i;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement ps = conn.prepareStatement("SELECT c.Id FROM consultas AS c\r\n"
					+ "INNER JOIN pacientes AS p\r\n"
					+ "ON c.CpfPaciente = p.Id\r\n"
					+ "INNER JOIN medico AS m\r\n"
					+ "ON c.NomeMedico = m.Id\r\n"
					+ "WHERE p.Cpf = ? AND m.Nome = ?");
			ps.setString(1, cpf);
			ps.setString(2, nomeMedico);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				i = rs.getInt("Id");
				return i;
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void atualizar(Consulta consulta) {
		try {
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement ps = conn.prepareStatement(
					"UPDATE consultas SET CpfPaciente = ?, NomeMedico = ?, DiaConsulta = ?, HoraConsulta = ?"
							+ " WHERE Id = ?");
			ps.setInt(1, pegarIdCpf(consulta.getCpf()));
			ps.setInt(2, pegarIdNomeMedico(consulta.getNome()));
			ps.setDate(3, java.sql.Date.valueOf(consulta.getConsultaDia()));
			ps.setTime(4, java.sql.Time.valueOf(consulta.getConsultaHora()));
			ps.setInt(5, consulta.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void apagarPorId(Integer id) {
		try {
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement ps = conn.prepareStatement("DELETE FROM consultas WHERE Id = ?");
			ps.setInt(1, id);
			ps.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Consulta encontrarPorId(Integer id) {
		Consulta c = new Consulta();
		try {
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement ps = conn.prepareStatement(
					"SELECT C.Id, P.Cpf, M.Nome, C.DiaConsulta, C.HoraConsulta \r\n" + "FROM consultas AS C\r\n"
							+ "INNER JOIN pacientes AS P\r\n" + "ON C.CpfPaciente = P.Id\r\n"
							+ "INNER JOIN medico AS M\r\n" + "ON C.NomeMedico = M.Id\r\n" + "WHERE C.Id = ?;");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				c = instanciarConsulta(rs);
				return c;
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Consulta> encontrarTodos() {
		List<Consulta> lista = new ArrayList<>();
		try {
			Connection conn = DriverManager.getConnection(URL,USER,PASSWORD);
			PreparedStatement ps = conn.prepareStatement("SELECT C.Id, P.Cpf, M.Nome, C.DiaConsulta, C.HoraConsulta \r\n"
					+ "FROM consultas AS C\r\n"
					+ "INNER JOIN pacientes AS P\r\n"
					+ "ON C.CpfPaciente = P.Id\r\n"
					+ "INNER JOIN medico AS M\r\n"
					+ "ON C.NomeMedico = M.Id");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Consulta c = instanciarConsulta(rs);
				lista.add(c);
			}
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Consulta instanciarConsulta(ResultSet rs) throws SQLException {
		Consulta c = new Consulta();
		c.setId(rs.getInt("Id"));
		c.setCpf(rs.getString("Cpf"));
		c.setNome(rs.getString("Nome"));
		c.setConsultaDia(rs.getDate("DiaConsulta").toLocalDate());
		c.setConsultaHora(rs.getTime("HoraConsulta").toLocalTime());
		return c;
	}

	private Integer pegarIdCpf(String cpf) {
		for (Paciente p : Principal.getPacientesRegistrados()) {
			if (p.getCpf().equals(cpf)) {
				return p.getId();
			}
		}
		return null;
	}

	private Integer pegarIdNomeMedico(String nome) {
		for (Medico m : Principal.getMedicosRegistrados()) {
			if (m.getNome().equals(nome)) {
				return m.getId();
			}
		}
		return null;
	}
}

package entities.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Paciente;
import entities.TipoConvenio;
import entities.dao.pacienteDAO;

public class PacienteDAOImpl implements pacienteDAO {
	private static final String URL = "jdbc:mariadb://localhost:3306/clinica";
	private static final String USER = "admin";
	private static final String PASSWORD = "1234";
	
	 public PacienteDAOImpl() {
	        try {
	            Class.forName("org.mariadb.jdbc.Driver");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	@Override
	public void inserir(Paciente paciente) {
		try {
			
			Connection conn = DriverManager.getConnection(URL,USER,PASSWORD);
			PreparedStatement ps = conn.prepareStatement("INSERT INTO pacientes VALUES "
					+ "(null,?,?,?,?,?,?);");
			ps.setString(1, paciente.getNome());
			ps.setDate(2, java.sql.Date.valueOf(paciente.getDataNascimento()));
			ps.setString(3, paciente.getCpf());
			ps.setString(4, paciente.getTelefone());
			ps.setString(5, paciente.getEndereco());
			ps.setInt(6, paciente.getConvenio().getValor());
			ps.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void atualizar(Paciente paciente) {
		try {
			Connection conn = DriverManager.getConnection(URL,USER,PASSWORD);
			PreparedStatement ps = conn.prepareStatement("UPDATE pacientes SET Nome = ?, DataAniversario = ?, Cpf = ?, Telefone = ?, Endereco = ?, pacientes.TipoConvenio = ?\r\n"
					+ "WHERE Id = ?");
			ps.setString(1, paciente.getNome());
			ps.setDate(2, java.sql.Date.valueOf(paciente.getDataNascimento()));
			ps.setString(3, paciente.getCpf());
			ps.setString(4, paciente.getTelefone());
			ps.setString(5, paciente.getEndereco());
			ps.setInt(6, paciente.getConvenio().getValor());
			ps.setInt(7, paciente.getId());
			ps.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void apagarPorId(Integer id) {
		try {
			Connection conn = DriverManager.getConnection(URL,USER,PASSWORD);
			PreparedStatement ps = conn.prepareStatement("DELETE FROM pacientes WHERE Id = ?");
			ps.setInt(1, id);
			ps.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Paciente encontrarPorId(Integer id) {
		Paciente p = new Paciente();
		try {
			Connection conn = DriverManager.getConnection(URL,USER,PASSWORD);
			PreparedStatement ps = conn.prepareStatement("SELECT P.Id,P.Nome,P.DataAniversario,P.Cpf,P.Telefone,P.Endereco, TC.Nome AS TipoDeConvenio\r\n"
					+ "FROM pacientes AS P\r\n"
					+ "INNER JOIN tipoconvenio AS TC\r\n"
					+ "ON P.TipoConvenio = TC.Id\r\n"
					+ "WHERE P.Id = ?;");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				p = instanciarPaciente(rs);
				return p;
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	

	@Override
	public List<Paciente> encontrarTodos() {
		List<Paciente> lista = new ArrayList<>();
		try {
			Connection conn = DriverManager.getConnection(URL,USER,PASSWORD);
			PreparedStatement ps = conn.prepareStatement("SELECT pacientes.*, tipoconvenio.Nome AS TipoDeConvenio FROM pacientes\r\n"
					+ "INNER JOIN tipoconvenio ON pacientes.TipoConvenio = tipoconvenio.Id;");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Paciente p = instanciarPaciente(rs);
				lista.add(p);
			}
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Paciente instanciarPaciente(ResultSet rs) throws SQLException {
		Paciente p = new Paciente();
		p.setId(rs.getInt("Id"));
		p.setNome(rs.getString("Nome"));
		p.setDataNascimento(rs.getDate("DataAniversario").toLocalDate());
		p.setCpf(rs.getString("Cpf"));
		p.setTelefone(rs.getString("Telefone"));
		p.setEndereco(rs.getString("Endereco"));
		p.setConvenio(TipoConvenio.valueOf(rs.getString("TipoDeConvenio")));
		return p;
	}
	
	public Integer devolverId(String cpf) {
		Connection conn;
		Integer i;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement ps = conn.prepareStatement("SELECT Id FROM pacientes\r\n"
					+ "WHERE Cpf = ?");
			ps.setString(1, cpf);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				i = rs.getInt("Id");
				return i;
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}

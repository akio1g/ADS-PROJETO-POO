package entities.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Medico;
import entities.TipoEspecialidade;
import entities.dao.MedicoDAO;

public class MedicoDAOImpl implements MedicoDAO {
	private static final String URL = "jdbc:mariadb://localhost:3306/clinica";
	private static final String USER = "admin";
	private static final String PASSWORD = "1234";
	public MedicoDAOImpl() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void inserir(Medico medico) {
		try {
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement ps = conn.prepareStatement("INSERT INTO medico VALUES " + "(null,?,?,?,?,?,?);");
			ps.setString(1, medico.getNome());
			ps.setDate(2, java.sql.Date.valueOf(medico.getDataNascimento()));
			ps.setString(3, medico.getCpf());
			ps.setString(4, medico.getTelefone());
			ps.setString(5, medico.getEndereco());
			ps.setInt(6, medico.getEspecialidade().getValor());
			ps.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void atualizar(Medico medico) {
		try {
			Connection conn = DriverManager.getConnection(URL,USER,PASSWORD);
			PreparedStatement ps = conn.prepareStatement("UPDATE medico SET Nome = ?, DataNascimento = ?, Cpf = ?, Telefone = ?, Endereco = ?, medico.TipoEspecialidade = ?\r\n"
					+ "WHERE Id = ?");
			ps.setString(1, medico.getNome());
			ps.setDate(2, java.sql.Date.valueOf(medico.getDataNascimento()));
			ps.setString(3, medico.getCpf());
			ps.setString(4, medico.getTelefone());
			ps.setString(5, medico.getEndereco());
			ps.setInt(6, medico.getEspecialidade().getValor());
			ps.setInt(7, medico.getId());
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
			PreparedStatement ps = conn.prepareStatement("DELETE FROM medico WHERE Id = ?");
			ps.setInt(1, id);
			ps.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Medico encontrarPorId(Integer id) {
		Medico p = new Medico();
		try {
			Connection conn = DriverManager.getConnection(URL,USER,PASSWORD);
			PreparedStatement ps = conn.prepareStatement("SELECT M.Id,M.Nome,M.DataNascimento,M.Cpf,M.Telefone,M.Endereco, TE.Nome AS TipoDeEspecialidade\r\n"
					+ "FROM medico AS M\r\n"
					+ "INNER JOIN tipoespecialidade AS TE\r\n"
					+ "ON M.TipoEspecialidade = TE.Id\r\n"
					+ "WHERE M.Id = ?;");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				p = instanciarMedico(rs);
				return p;
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Medico> encontrarTodos() {
		List<Medico> lista = new ArrayList<>();
		try {
			Connection conn = DriverManager.getConnection(URL,USER,PASSWORD);
			PreparedStatement ps = conn.prepareStatement("SELECT medico.*, tipoespecialidade.Nome AS TipoDeEspecialidade FROM medico\r\n"
					+ "INNER JOIN tipoespecialidade ON medico.TipoEspecialidade = tipoespecialidade.Id;");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Medico p = instanciarMedico(rs);
				lista.add(p);
			}
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	private Medico instanciarMedico(ResultSet rs) throws SQLException {
		Medico p = new Medico();
		p.setId(rs.getInt("Id"));
		p.setNome(rs.getString("Nome"));
		p.setDataNascimento(rs.getDate("DataNascimento").toLocalDate());
		p.setCpf(rs.getString("Cpf"));
		p.setTelefone(rs.getString("Telefone"));
		p.setEndereco(rs.getString("Endereco"));
		p.setEspecialidade(TipoEspecialidade.valueOf(rs.getString("TipoDeEspecialidade")));
		return p;
	}
	
	public Integer devolverId(String cpf) {
		Connection conn;
		Integer i;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement ps = conn.prepareStatement("SELECT Id FROM medico\r\n"
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

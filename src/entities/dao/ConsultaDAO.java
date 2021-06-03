package entities.dao;

import java.util.List;

import entities.Consulta;

public interface ConsultaDAO {
	void inserir(Consulta consulta);
	void atualizar(Consulta consulta);
	void apagarPorId(Integer id);
	Consulta encontrarPorId(Integer id);
	List<Consulta> encontrarTodos();
}

package entities.dao;

import java.util.List;

import entities.Medico;

public interface MedicoDAO {
	void inserir(Medico medico);
	void atualizar(Medico medico);
	void apagarPorId(Integer id);
	Medico encontrarPorId(Integer id);
	List<Medico> encontrarTodos();
}

package entities.dao;

import java.util.List;

import entities.Paciente;


public interface pacienteDAO {
	void inserir(Paciente paciente);
	void atualizar(Paciente paciente);
	void apagarPorId(Integer id);
	Paciente encontrarPorId(Integer id);
	List<Paciente> encontrarTodos();
}

package entities.dao;

import java.util.List;

import entities.Atendente;

public interface AtendenteDAO {
	void inserir(Atendente atendente);
	void atualizar(Atendente atendente);
	void apagarPorId(Integer id);
	Atendente encontrarPorId(Integer id);
	List<Atendente> encontrarTodos();
}

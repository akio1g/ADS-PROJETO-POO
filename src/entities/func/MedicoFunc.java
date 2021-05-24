package entities.func;

import entities.Medico;

public interface MedicoFunc {

	public void adicionar();

	public void alterarPorId(Integer id);

	public void excluirPorId(Integer id);

	public Medico pesquisarPorId(Integer id);
}

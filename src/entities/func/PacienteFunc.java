package entities.func;


import entities.Paciente;

public interface PacienteFunc {
	public void adicionar();

	public void alterarPorId(Integer id);

	public void excluirPorId(Integer id);

	public Paciente pesquisarPorId(Integer id);
}

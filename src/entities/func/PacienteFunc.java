package entities.func;

import java.util.ArrayList;
import java.util.List;

import entities.Paciente;

public class PacienteFunc {
	private List<Paciente> pacientes = new ArrayList<>();

	public List<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

	public void cadastrar(Paciente paciente) {
		pacientes.add(paciente);
	}

	public void atualizar(Paciente paciente) {
		for (Paciente pac : pacientes) {
			if (pac.getId() == paciente.getId()) {
				pac.setCpf(paciente.getCpf());
				pac.setDataNascimento(paciente.getDataNascimento());
				pac.setEndereco(paciente.getEndereco());
				pac.setConvenio(paciente.convenio);
				pac.setNome(paciente.getNome());
				pac.setTelefone(paciente.getTelefone());
			}
		}
	}

	public void deletarPorId(Integer id) {
		for (Paciente paciente : pacientes) {
			if (paciente.getId() == id) {
				pacientes.remove(paciente);
			}
		}
	}

	public Paciente encontrarPorId(Integer id) {
		for (Paciente paciente : pacientes) {
			if (paciente.getId() == id) {
				return paciente;
			}
		}
		return null;

	}
}

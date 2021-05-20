package entities.func;

import java.util.ArrayList;
import java.util.List;

import entities.Medico;

public class MedicoFunc {
	private List<Medico> medicos = new ArrayList<>();

	public List<Medico> getMedicos() {
		return medicos;
	}

	public void setMedicos(List<Medico> medicos) {
		this.medicos = medicos;
	}

	public void cadastrar(Medico medico) {
		medicos.add(medico);
	}

	public void atualizar(Medico medico) {
		for(Medico med: medicos) {
			if(med.getId()==medico.getId()) {
				med.setCpf(medico.getCpf());
				med.setDataNascimento(medico.getDataNascimento());
				med.setEndereco(medico.getEndereco());
				med.setEspecialidade(medico.getEspecialidade());
				med.setNome(medico.getNome());
				med.setTelefone(medico.getTelefone());
			}
		}
	}

	public void deletarPorId(Integer id) {
		for(Medico medico: medicos) {
			if(medico.getId()==id) {
				medicos.remove(medico);
			}
		}
	}

	public Medico encontrarPorId(Integer id) {
		for(Medico medico: medicos) {
			if(medico.getId()==id) {
				return medico;
			}
		}
		return null;
		
	}
}

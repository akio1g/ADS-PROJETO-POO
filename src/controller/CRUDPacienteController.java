package controller;

import application.Principal;
import entities.Paciente;
import entities.dao.impl.PacienteDAOImpl;
import entities.func.Func;

public class CRUDPacienteController implements Func {
	PacienteDAOImpl pDao = new PacienteDAOImpl();

	@Override
	public void adicionar() {
		Paciente a = new Paciente();

		a.setNome(Principal.cpBoundary.tfNome.getText());
		a.setDataNascimento(Principal.cpBoundary.tfData.getValue());
		a.setCpf(Principal.cpBoundary.tfCpf.getText());
		a.setTelefone(Principal.cpBoundary.tfTelefone.getText());
		a.setEndereco(Principal.cpBoundary.tfEndereco.getText());
		a.setConvenio(Principal.cpBoundary.cbConvenio.getValue());
		pDao.inserir(a);
		a.setId(pDao.devolverId(a.getCpf()));
		Principal.cpBoundary.message.setText("Paciente ID: " + a.getId() + " adicionado!");
		Principal.getPacientesRegistrados().add(a);
		
	}

	@Override
	public void alterarPorId(Integer id) {
		boolean opc = false;
		for (Paciente p : Principal.getPacientesRegistrados()) {
			if (p.getId() == id) {
				opc = true;
				p.setNome(Principal.cpBoundary.tfNome.getText());
				p.setDataNascimento(Principal.cpBoundary.tfData.getValue());
				p.setCpf(Principal.cpBoundary.tfCpf.getText());
				p.setTelefone(Principal.cpBoundary.tfTelefone.getText());
				p.setEndereco(Principal.cpBoundary.tfEndereco.getText());
				p.setConvenio(Principal.cpBoundary.cbConvenio.getValue());
				Principal.cpBoundary.message.setText("Paciente ID: " + p.getId() + " alterado!");
				pDao.atualizar(p);
			}
		}
		if (opc == false) {
			Principal.cpBoundary.message.setText("Paciente ID: " + id + " não encontrado!");
		}
	}

	@Override
	public void excluirPorId(Integer id) {
		boolean opc = false;
		for (Paciente p : Principal.getPacientesRegistrados()) {
			if (p.getId() == id) {
				opc = true;
				Principal.getPacientesRegistrados().remove(p);
				Principal.cpBoundary.message.setText("Paciente ID: " + id + " removido!");
				pDao.apagarPorId(id);
				break;
			}
		}
		if (opc == false) {
			Principal.cpBoundary.message.setText("Paciente ID: " + id + " não encontrado!");
		}
	}

	@Override
	public void pesquisarPorId(Integer id) {
		Paciente p = pDao.encontrarPorId(id);
		if(p!= null) {
			Principal.cpBoundary.tfNome.setText(p.getNome());
			Principal.cpBoundary.tfData.setValue(p.getDataNascimento());
			Principal.cpBoundary.tfCpf.setText(p.getCpf());
			Principal.cpBoundary.tfTelefone.setText(p.getTelefone());
			Principal.cpBoundary.tfEndereco.setText(p.getEndereco());
			Principal.cpBoundary.cbConvenio.setValue(p.getConvenio());
		} else {
			Principal.cpBoundary.message.setText("Paciente ID: " + id + " não encontrado!");
		}
	}

	public void limpar() {
		Principal.cpBoundary.tfId.setText("");
		Principal.cpBoundary.cbConvenio.getSelectionModel().clearSelection();
		Principal.cpBoundary.tfNome.setText("");
		Principal.cpBoundary.tfData.setValue(null);
		Principal.cpBoundary.tfCpf.setText("");
		Principal.cpBoundary.tfTelefone.setText("");
		Principal.cpBoundary.tfEndereco.setText("");
	}

}

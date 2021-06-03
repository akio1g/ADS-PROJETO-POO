package controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import application.Principal;
import entities.Consulta;
import entities.Medico;
import entities.Paciente;
import entities.func.Func;

public class ConsultaController implements Func {

	public String pesquisarCpf() {
		String nome = null;
		try {
			if (!Principal.consultaBoundary.cbCpfPaciente.getValue().isEmpty()) {
				for (Paciente p : Principal.getPacientesRegistrados()) {
					if (Principal.consultaBoundary.cbCpfPaciente.getValue().equals(p.getCpf())) {
						nome = p.getNome();
					}
				}
			} else {
				nome = null;
			}

		} catch (NullPointerException e) {
			Principal.consultaBoundary.message.setText(e.getMessage());
		}
		return nome;
	}

	@Override
	public void adicionar() {
		Consulta c = new Consulta();
		try {
			c.setId(Principal.getConsultaRegistrados().size() + 1);
			c.setCpf(Principal.consultaBoundary.cbCpfPaciente.getValue());
			c.setNome(Principal.consultaBoundary.cbNomeMedico.getValue());
			c.setConsultaDia(Principal.consultaBoundary.tfData.getValue());
			c.setConsultaHora(Principal.sdf1.parse(Principal.consultaBoundary.tfHora.getText()));
			Principal.consultaBoundary.message.setText("Consulta ID: " + c.getId() + " adicionado!");
		} catch (ParseException e) {
			Principal.consultaBoundary.message.setText(e.getMessage());
		}
		Principal.getConsultaRegistrados().add(c);
	}

	@Override
	public void alterarPorId(Integer id) {
		boolean opc = false;
		for (Consulta c : Principal.getConsultaRegistrados()) {
			if (c.getId() == id) {
				try {
					opc = true;
					c.setCpf(Principal.consultaBoundary.cbCpfPaciente.getValue());
					c.setNome(Principal.consultaBoundary.cbNomeMedico.getValue());
					c.setConsultaDia(Principal.consultaBoundary.tfData.getValue());
					c.setConsultaHora(Principal.sdf1.parse(Principal.consultaBoundary.tfHora.getText()));
					Principal.consultaBoundary.message.setText("Consulta ID: " + c.getId() + " alterada!");
				} catch (ParseException e) {
					Principal.consultaBoundary.message.setText(e.getMessage());
				}
			}
		}
		if (opc == false) {
			Principal.consultaBoundary.message.setText("Consulta ID: " + id + " não encontrada!");
		}
	}

	@Override
	public void excluirPorId(Integer id) {
		boolean opc = false;
		for (Consulta c : Principal.getConsultaRegistrados()) {
			if (c.getId() == id) {
				opc = true;
				Principal.getConsultaRegistrados().remove(c);
				Principal.consultaBoundary.message.setText("Consulta ID: " + id + " excluída!");
				break;
			}
		}
		if (opc == false) {
			Principal.consultaBoundary.message.setText("Consulta ID: " + id + " não encontrada!");
		}
	}

	@Override
	public void pesquisarPorId(Integer id) {
		boolean opc = false;
		for (Consulta c : Principal.getConsultaRegistrados()) {
			if (c.getId() == id) {
				opc = true;
				Principal.consultaBoundary.cbCpfPaciente.setValue(c.getCpf());
				Principal.consultaBoundary.cbNomeMedico.setValue(c.getNome());
				Principal.consultaBoundary.tfData.setValue(c.getConsultaDia());
				Principal.consultaBoundary.tfHora.setText(Principal.sdf1.format(c.getConsultaHora()));
			}
		}
		if (opc == false) {
			Principal.consultaBoundary.message.setText("Consulta ID: " + id + " não encontrada!");
		}
	}

	public void limpar() {
		Principal.consultaBoundary.tfId.setText("");
		Principal.consultaBoundary.lblNomePaciente.setText("");
		Principal.consultaBoundary.cbCpfPaciente.getSelectionModel().clearSelection();
		Principal.consultaBoundary.cbNomeMedico.getSelectionModel().clearSelection();
		Principal.consultaBoundary.tfData.setValue(null);
		Principal.consultaBoundary.tfHora.setText("");
	}

}

package controller;

import java.time.LocalTime;
import application.Principal;
import entities.Consulta;
import entities.Paciente;
import entities.dao.impl.ConsultaDAOImpl;
import entities.func.Func;

public class ConsultaController implements Func {
	ConsultaDAOImpl cDao = new ConsultaDAOImpl();
	
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
		c.setCpf(Principal.consultaBoundary.cbCpfPaciente.getValue());
		c.setNome(Principal.consultaBoundary.cbNomeMedico.getValue());
		c.setConsultaDia(Principal.consultaBoundary.tfData.getValue());
		c.setConsultaHora(LocalTime.parse(Principal.consultaBoundary.tfHora.getText(), Principal.dtf1));
		cDao.inserir(c);
		c.setId(cDao.devolverId(c.getNome(), c.getCpf()));
		Principal.consultaBoundary.message.setText("Consulta ID: " + c.getId() + " adicionado!");
		Principal.getConsultaRegistrados().add(c);
	}

	@Override
	public void alterarPorId(Integer id) {
		boolean opc = false;
		for (Consulta c : Principal.getConsultaRegistrados()) {
			if (c.getId() == id) {
				opc = true;
				c.setCpf(Principal.consultaBoundary.cbCpfPaciente.getValue());
				c.setNome(Principal.consultaBoundary.cbNomeMedico.getValue());
				c.setConsultaDia(Principal.consultaBoundary.tfData.getValue());
				c.setConsultaHora(LocalTime.parse(Principal.consultaBoundary.tfHora.getText(), Principal.dtf1));
				Principal.consultaBoundary.message.setText("Consulta ID: " + c.getId() + " alterada!");
				cDao.atualizar(c);
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
				cDao.apagarPorId(id);
				break;
			}
		}
		if (opc == false) {
			Principal.consultaBoundary.message.setText("Consulta ID: " + id + " não encontrada!");
		}
	}

	@Override
	public void pesquisarPorId(Integer id) {
		Consulta c = cDao.encontrarPorId(id);
		if(c!=null) {
				Principal.consultaBoundary.cbCpfPaciente.setValue(c.getCpf());
				Principal.consultaBoundary.cbNomeMedico.setValue(c.getNome());
				Principal.consultaBoundary.tfData.setValue(c.getConsultaDia());
				Principal.consultaBoundary.tfHora.setText(Principal.dtf1.format(c.getConsultaHora()));
			} else {
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

package controller;


import application.Principal;
import entities.Medico;
import entities.dao.impl.MedicoDAOImpl;
import entities.func.Func;

public class CRUDMedicoController implements Func{
	MedicoDAOImpl mDao = new MedicoDAOImpl();
	@Override
	public void adicionar() {
		Medico a = new Medico();
		a.setNome(Principal.cmBoundary.tfNome.getText());
		a.setDataNascimento(Principal.cmBoundary.tfData.getValue());
		a.setCpf(Principal.cmBoundary.tfCpf.getText());
		a.setTelefone(Principal.cmBoundary.tfTelefone.getText());
		a.setEndereco(Principal.cmBoundary.tfEndereco.getText());
		a.setEspecialidade(Principal.cmBoundary.cbEspecialidade.getValue());
		mDao.inserir(a);
		a.setId(mDao.devolverId(a.getCpf()));
		Principal.cmBoundary.message.setText("Médico ID: " + a.getId() + " adicionado!");
		Principal.getMedicosRegistrados().add(a);
		
	}

	@Override
	public void alterarPorId(Integer id) {
		boolean opc = false;
		for (Medico p : Principal.getMedicosRegistrados()) {
			if (p.getId() == id) {
				opc = true;
				p.setNome(Principal.cmBoundary.tfNome.getText());
				p.setDataNascimento(Principal.cmBoundary.tfData.getValue());
				p.setCpf(Principal.cmBoundary.tfCpf.getText());
				p.setTelefone(Principal.cmBoundary.tfTelefone.getText());
				p.setEndereco(Principal.cmBoundary.tfEndereco.getText());
				p.setEspecialidade(Principal.cmBoundary.cbEspecialidade.getValue());
				Principal.cmBoundary.message.setText("Médico ID: " + p.getId() + " alterado!");
				mDao.atualizar(p);
			}
		}
		if (opc == false) {
			Principal.cmBoundary.message.setText("Médico ID: " + id + " não encontrado!");
		}
	}

	@Override
	public void excluirPorId(Integer id) {
		boolean opc = false;
		for (Medico p : Principal.getMedicosRegistrados()) {
			if (p.getId() == id) {
				opc = true;
				Principal.getMedicosRegistrados().remove(p);
				Principal.cmBoundary.message.setText("Médico ID: " + id + " removido!");
				mDao.apagarPorId(id);
				break;
			}
		}
		if (opc == false) {
			Principal.cmBoundary.message.setText("Médico ID: " + id + " não encontrado!");
		}
	}

	@Override
	public void pesquisarPorId(Integer id) {
		Medico p = mDao.encontrarPorId(id);
		if(p!= null) {
			Principal.cmBoundary.tfNome.setText(p.getNome());
			Principal.cmBoundary.tfData.setValue(p.getDataNascimento());
			Principal.cmBoundary.tfCpf.setText(p.getCpf());
			Principal.cmBoundary.tfTelefone.setText(p.getTelefone());
			Principal.cmBoundary.tfEndereco.setText(p.getEndereco());
			Principal.cmBoundary.cbEspecialidade.setValue(p.getEspecialidade());
		} else {
			Principal.cmBoundary.message.setText("Medico ID: " + id + " não encontrado!");
		}
	}

	public void limpar() {
		Principal.cmBoundary.tfId.setText("");
		Principal.cmBoundary.tfNome.setText("");
		Principal.cmBoundary.tfData.setValue(null);
		Principal.cmBoundary.cbEspecialidade.getSelectionModel().clearSelection();
		Principal.cmBoundary.tfCpf.setText("");
		Principal.cmBoundary.tfTelefone.setText("");
		Principal.cmBoundary.tfEndereco.setText("");
	}
}

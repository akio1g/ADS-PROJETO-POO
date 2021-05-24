package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import application.Principal;
import entities.Paciente;
import entities.TipoConvenio;
import entities.func.Func;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CRUDPacienteController implements Func {
	Label lblId = new Label("ID Paciente");
	TextField tfId = new TextField();
	Button btPesquisar = new Button("Pesquisar");
	Button btAlterar = new Button("Alterar");
	Button btAdicionar = new Button("Adicionar");
	Button btExcluir = new Button("Excluir");
	Label message = new Label("");
	Label lblNome = new Label("Nome");
	Label lblData = new Label("Data de Nascimento");
	Label lblCpf = new Label("Cpf");
	Label lblTelefone = new Label("Telefone");
	Label lblEndereco = new Label("Endereço");
	Label lblConvenio = new Label("Convênio");
	TextField tfNome = new TextField();
	TextField tfData = new TextField();
	TextField tfCpf = new TextField();
	TextField tfTelefone = new TextField();
	TextField tfEndereco = new TextField();
	ComboBox<TipoConvenio> cbConvenio = new ComboBox<>();
	Button btLimpar = new Button("Limpar");
	Button btVoltar = new Button("Voltar");

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private List<Paciente> pacientesRegistrados = new ArrayList<>();


	public List<Paciente> getPacientesRegistrados() {
		return pacientesRegistrados;
	}

	public void setPacientesRegistrados(List<Paciente> pacientesRegistrados) {
		this.pacientesRegistrados = pacientesRegistrados;
	}

	public Scene telaPaciente() {
		HBox pane1 = new HBox(10);
		pane1.setPadding(new Insets(0, 0, 0, 10));
		pane1.getChildren().addAll(lblId, tfId, btPesquisar, btAlterar, btExcluir);

		GridPane pane2 = new GridPane();
		pane2.setHgap(10.0);
		pane2.setPadding(new Insets(0, 0, 0, 10));
		pane2.add(lblNome, 0, 0);
		pane2.add(tfNome, 1, 0);
		pane2.add(message, 2, 0);
		pane2.add(lblData, 0, 1);
		pane2.add(tfData, 1, 1);
		pane2.add(lblCpf, 0, 2);
		pane2.add(tfCpf, 1, 2);
		pane2.add(lblTelefone, 0, 3);
		pane2.add(tfTelefone, 1, 3);
		pane2.add(lblConvenio, 0, 4);
		pane2.add(cbConvenio, 1, 4);
		pane2.add(btAdicionar, 2, 4);
		pane2.add(btLimpar, 3, 4);
		pane2.add(btVoltar, 4, 4);

		cbConvenio.getItems().addAll(TipoConvenio.values());

		btPesquisar.setOnAction((e) -> pesquisarPorId(Integer.parseInt(tfId.getText())));
		btAdicionar.setOnAction((e) -> adicionar());
		btAlterar.setOnAction((e) -> alterarPorId(Integer.parseInt(tfId.getText())));
		btExcluir.setOnAction((e) -> excluirPorId(Integer.parseInt(tfId.getText())));
		btLimpar.setOnAction((e) -> limpar());
		btVoltar.setOnAction((e) -> Principal.mudarScene(1));

		VBox panePrincipal = new VBox(20);
		panePrincipal.getChildren().addAll(pane1, pane2);
		panePrincipal.setPadding(new Insets(10, 0, 0, 0));
		Scene scn = new Scene(panePrincipal, 600, 200);
		return scn;
	}

	@Override
	public void adicionar() {
		Paciente a = new Paciente();
		try {
			a.setId(pacientesRegistrados.size() + 1);
			a.setNome(tfNome.getText());
			a.setDataNascimento(sdf.parse(tfData.getText()));
			a.setCpf(tfCpf.getText());
			a.setTelefone(tfTelefone.getText());
			a.setEndereco(tfEndereco.getText());
			a.setConvenio(cbConvenio.getValue());
			message.setText("Paciente ID: " + a.getId() + " adicionado!");
		} catch (ParseException e) {
			message.setText(e.getMessage());
		}
		pacientesRegistrados.add(a);
	}

	@Override
	public void alterarPorId(Integer id) {
		boolean opc = false;
		for (Paciente p : pacientesRegistrados) {
			if (p.getId() == id) {
				try {
					opc = true;
					p.setNome(tfNome.getText());
					p.setDataNascimento(sdf.parse(tfData.getText()));
					p.setCpf(tfCpf.getText());
					p.setTelefone(tfTelefone.getText());
					p.setEndereco(tfEndereco.getText());
					p.setConvenio(cbConvenio.getValue());
					message.setText("Paciente ID: " + p.getId() + " alterado!");
				} catch (ParseException e) {
					message.setText(e.getMessage());
				}
			}
		}
		if (opc == false) {
			message.setText("Paciente ID: " + id + " não encontrado!");
		}
	}

	@Override
	public void excluirPorId(Integer id) {
		boolean opc = false;
		for (Paciente p : pacientesRegistrados) {
			if (p.getId() == id) {
				opc = true;
				pacientesRegistrados.remove(p);
				message.setText("Paciente ID: " + id + " removido!");
				break;
			}
		}
		if(opc==false) {
			message.setText("Paciente ID: "+id+ " não encontrado!");
		}
	}

	@Override
	public void pesquisarPorId(Integer id) {
		boolean opc = false;
		for (Paciente p : pacientesRegistrados) {
			if (p.getId() == id) {
				opc = true;
				tfNome.setText(p.getNome());
				tfData.setText(sdf.format(p.getDataNascimento()));
				tfCpf.setText(p.getCpf());
				tfTelefone.setText(p.getTelefone());
				tfEndereco.setText(p.getEndereco());
				cbConvenio.setValue(p.getConvenio());
			}
		}
		if (opc == false) {
			message.setText("Paciente ID: " + id + " não encontrado!");
		}
	}
	
	public void limpar() {
		tfId.setText("");
		tfNome.setText("");
		tfData.setText("");
		tfCpf.setText("");
		tfTelefone.setText("");
		tfEndereco.setText("");
	}

}

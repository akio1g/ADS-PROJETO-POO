package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import application.Principal;
import entities.Consulta;
import entities.Medico;
import entities.Paciente;
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

public class ConsultaController implements Func {
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	CRUDMedicoController cmControl = new CRUDMedicoController();
	Label lblId = new Label("ID Consulta");
	TextField tfId = new TextField();
	Button btPesquisar = new Button("Pesquisar");
	Button btAlterar = new Button("Alterar");
	Button btAdicionar = new Button("Adicionar");
	Button btExcluir = new Button("Excluir");
	Button btLimpar = new Button("Limpar");
	Button btVoltar = new Button("Voltar");
	Label lblCpf = new Label("CPF Paciente");
	ComboBox<String> cbCpfPaciente = new ComboBox<>();
	Label lblNomePaciente = new Label("");
	Label lblNomeMedico = new Label("Nome Médico");
	Label message = new Label("");
	Label lblData = new Label("Data Consulta");
	TextField tfData = new TextField();
	Label lblHora = new Label("Hora Consulta");
	TextField tfHora = new TextField();
	ComboBox<String> cbNomeMedico = new ComboBox<>();

	public List<String> ListaNomes() {
		List<String> listanomes = new ArrayList<>();
		for (Medico m : Principal.getMedicosRegistrados()) {
			listanomes.add(m.getNome());
		}
		return listanomes;
	}

	public List<String> ListaCpfs() {
		List<String> listacpf = new ArrayList<>();
		for (Paciente p : Principal.getPacientesRegistrados()) {
			listacpf.add(p.getCpf());
		}
		return listacpf;
	}

	public Scene telaConsulta() {
		HBox pane1 = new HBox(10);
		pane1.setPadding(new Insets(0, 0, 0, 10));
		pane1.getChildren().addAll(lblId, tfId, btPesquisar, btAlterar, btExcluir);

		GridPane pane2 = new GridPane();
		pane2.setHgap(10);
		pane2.setPadding(new Insets(0, 0, 0, 10));
		pane2.add(lblCpf, 0, 0);
		pane2.add(cbCpfPaciente, 1, 0);
		pane2.add(lblNomePaciente, 2, 0);
		pane2.add(lblNomeMedico, 0, 1);
		pane2.add(cbNomeMedico, 1, 1);
		pane2.add(message, 2, 1);
		pane2.add(lblData, 0, 2);
		pane2.add(tfData, 1, 2);
		pane2.add(lblHora, 0, 3);
		pane2.add(tfHora, 1, 3);
		pane2.add(btAdicionar, 2, 3);
		pane2.add(btLimpar, 3, 3);
		pane2.add(btVoltar, 4, 3);

		cbCpfPaciente.getItems().addAll(ListaCpfs());
		cbNomeMedico.getItems().addAll(ListaNomes());

		cbCpfPaciente.setOnAction((e) -> lblNomePaciente.setText(pesquisarCpf()));
		btPesquisar.setOnAction((e) -> pesquisarPorId(Integer.parseInt(tfId.getText())));
		btAlterar.setOnAction((e) -> alterarPorId(Integer.parseInt(tfId.getText())));
		btExcluir.setOnAction((e) -> excluirPorId(Integer.parseInt(tfId.getText())));
		btAdicionar.setOnAction((e) -> adicionar());
		btLimpar.setOnAction((e) -> limpar());

		VBox panePrincipal = new VBox(20);
		panePrincipal.getChildren().addAll(pane1, pane2);
		panePrincipal.setPadding(new Insets(10, 0, 0, 0));
		Scene scn = new Scene(panePrincipal, 600, 200);
		return scn;
	}

	public String pesquisarCpf() {
		try {
		
		if (cbCpfPaciente.getValue().isEmpty()) {
			for (Paciente p : Principal.getPacientesRegistrados()) {
				if (cbCpfPaciente.getValue().equals(p.getCpf())) {
					return p.getNome();
				}
			}
		}

		} catch (NullPointerException e) {
			message.setText(e.getMessage());
		}
		return null;
	}

	@Override
	public void adicionar() {
		Consulta c = new Consulta();
		try {
			c.setId(Principal.getPacientesRegistrados().size() + 1);
			c.setCpf(cbCpfPaciente.getValue());
			c.setNome(cbNomeMedico.getValue());
			c.setConsultaDia(Principal.sdf.parse(tfData.getText()));
			c.setConsultaHora(Principal.sdf1.parse(tfHora.getText()));
			message.setText("Consulta ID: " + c.getId() + " adicionado!");
		} catch (ParseException e) {
			message.setText(e.getMessage());
		}
		Principal.getConsultaRegistrados().add(c);
	}

	@Override
	public void alterarPorId(Integer id) {
	}

	@Override
	public void excluirPorId(Integer id) {
	}

	@Override
	public void pesquisarPorId(Integer id) {
	}

	public void limpar() {
		tfId.setText("");
		lblNomePaciente.setText("");
		cbCpfPaciente.getSelectionModel().clearSelection();
		cbNomeMedico.getSelectionModel().clearSelection();
		tfData.setText("");
		tfHora.setText("");
	}

}

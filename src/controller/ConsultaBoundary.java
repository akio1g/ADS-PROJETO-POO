package controller;

import application.Principal;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ConsultaBoundary {
	
	ConsultaController cControl = new ConsultaController();
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
	DatePicker tfData = new DatePicker();
	Label lblHora = new Label("Hora Consulta");
	TextField tfHora = new TextField("");
	ComboBox<String> cbNomeMedico = new ComboBox<>();
	
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

		HBox pane3 = new HBox(10);
		pane3.getChildren().addAll(btAdicionar, btLimpar, btVoltar);

		cbCpfPaciente.getItems().addAll(cControl.ListaCpfs());
		cbNomeMedico.getItems().addAll(cControl.ListaNomes());

		cbCpfPaciente.setOnAction((e) -> lblNomePaciente.setText(cControl.pesquisarCpf()));
		btPesquisar.setOnAction((e) -> cControl.pesquisarPorId(Integer.parseInt(tfId.getText())));
		btAlterar.setOnAction((e) -> cControl.alterarPorId(Integer.parseInt(tfId.getText())));
		btExcluir.setOnAction((e) -> cControl.excluirPorId(Integer.parseInt(tfId.getText())));
		btAdicionar.setOnAction((e) -> cControl.adicionar());
		btLimpar.setOnAction((e) -> cControl.limpar());
		btVoltar.setOnAction((e) -> Principal.mudarScene(1));

		VBox panePrincipal = new VBox(10);
		panePrincipal.getChildren().addAll(pane1, pane2, pane3);
		panePrincipal.setPadding(new Insets(10, 10, 10, 10));
		Scene scn = new Scene(panePrincipal, 620, 200);
		return scn;
	}
}

package controller;

import application.Principal;
import entities.TipoConvenio;
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

public class CRUDPacienteBoundary {
	CRUDPacienteController cpController = new CRUDPacienteController();

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
	DatePicker tfData = new DatePicker();
	TextField tfCpf = new TextField();
	TextField tfTelefone = new TextField();
	TextField tfEndereco = new TextField();
	ComboBox<TipoConvenio> cbConvenio = new ComboBox<>();
	Button btLimpar = new Button("Limpar");
	Button btVoltar = new Button("Voltar");

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

		adicionarComboBox();
		addAcoesBotoes();

		VBox panePrincipal = new VBox(20);
		panePrincipal.getChildren().addAll(pane1, pane2);
		panePrincipal.setPadding(new Insets(10, 0, 0, 0));
		Scene scn = new Scene(panePrincipal, 600, 200);
		return scn;
	}

	private void addAcoesBotoes() {
		btPesquisar.setOnAction((e) -> cpController.pesquisarPorId(Integer.parseInt(tfId.getText())));
		btAdicionar.setOnAction((e) -> cpController.adicionar());
		btAlterar.setOnAction((e) -> cpController.alterarPorId(Integer.parseInt(tfId.getText())));
		btExcluir.setOnAction((e) -> cpController.excluirPorId(Integer.parseInt(tfId.getText())));
		btLimpar.setOnAction((e) -> cpController.limpar());
		btVoltar.setOnAction((e) -> Principal.mudarScene(1));
	}

	private void adicionarComboBox() {
		if (cbConvenio.getItems().isEmpty()) {
			cbConvenio.getItems().addAll(TipoConvenio.values());
		} else {
			cbConvenio.getItems().clear();
			cbConvenio.getItems().addAll(TipoConvenio.values());
		}

	}
}

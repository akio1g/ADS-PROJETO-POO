package controller;

import java.awt.TextField;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class ConsultaPaciente {
	Label lblId = new Label("ID Paciente");
	TextField tfId = new TextField();
	Button btPesquisar = new Button("Pesquisar");
	Button btAlterar = new Button("Alterar");
	Button btAdicionar = new Button("Alterar");
	Button btExcluir = new Button("Excluir");
	Label lblNome = new Label();
	Label lblData = new Label();
	Label lblCpf = new Label();
	Label lblTelefone = new Label();
	Label lblEndereco = new Label();
	Label lblConvenio = new Label();	
	
	public Scene telaPaciente() {
		HBox pane1 = new HBox(20);
		pane1.getChildren().addAll(lblId,tfId,btPesquisar,btAlterar,btExcluir);	
	}
}

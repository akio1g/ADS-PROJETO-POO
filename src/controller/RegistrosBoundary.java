package controller;


import application.Principal;
import controller.registros.tabelaConsulta;
import controller.registros.tabelaMedico;
import controller.registros.tabelaPaciente;
import controller.registros.telaStrategy;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class RegistrosBoundary {
	Button btConsulta = new Button("Consulta");
	Button btPaciente = new Button("Paciente");
	Button btMedico = new Button("Médico");
	Button btVoltar = new Button("Voltar");
	Label tabelas = new Label("Tabelas");
	
	public Scene telaRegistro() {
		BorderPane bp = new BorderPane();
		Scene scn = new Scene(bp,700,500);
		bp.setPadding(new Insets(10,10,10,10));
		HBox telabotoes = new HBox(10);
		telabotoes.setPadding(new Insets(10,10,10,10));
		telabotoes.getChildren().addAll(tabelas,btConsulta,btPaciente,btMedico);
		
		telaStrategy tela = new tabelaConsulta();
		btConsulta.setOnAction(e -> bp.setCenter(new tabelaConsulta().gerarTabela()));
		btPaciente.setOnAction(e -> bp.setCenter(new tabelaPaciente().gerarTabela()));
		btMedico.setOnAction(e -> bp.setCenter(new tabelaMedico().gerarTabela()));
		btVoltar.setOnAction(e -> Principal.mudarScene(1));
		
		bp.setCenter(tela.gerarTabela());
		bp.setTop(telabotoes);
		bp.setBottom(btVoltar);
		return scn;
	}
}

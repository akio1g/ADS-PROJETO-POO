package controller;

import application.Principal;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class EscolhaController {
	public Scene telaEscolha() {
		BorderPane pane = new BorderPane();
		BorderPane pane2 = new BorderPane();
		Button btManipularPacientes = new Button("Manipular Pacientes");
		Button btManipularMedicos = new Button("Manipular Médicos");
		Button btGerarConsulta = new Button("Gerar Consulta");
		
		BorderPane.setMargin(btManipularPacientes, new Insets(40,0,0,15));
		BorderPane.setMargin(btManipularMedicos, new Insets(40,15,0,0));
		BorderPane.setMargin(btGerarConsulta, new Insets(10,10,10,10));
		
		pane2.setCenter(btGerarConsulta);
		pane.setLeft(btManipularPacientes);
		pane.setRight(btManipularMedicos);
		pane.setBottom(pane2);

		btManipularPacientes.setOnMouseClicked((e) -> Principal.mudarScene(2));
		btManipularMedicos.setOnMouseClicked((e) -> Principal.mudarScene(3));
		btGerarConsulta.setOnMouseClicked((e) -> Principal.mudarScene(4));
		Scene scn = new Scene(pane, 400, 150);
		return scn;
	}
}

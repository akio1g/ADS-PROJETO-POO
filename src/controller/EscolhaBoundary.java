package controller;

import application.Principal;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class EscolhaBoundary {
	public Scene telaEscolha() {
		GridPane pane = new GridPane();
		pane.setPadding(new Insets(20,20,20,20));
		pane.setHgap(20.0);
		pane.setVgap(20.0);
		
		Button btManipularPacientes = new Button("Manipular Pacientes");
		Button btManipularMedicos = new Button("Manipular Médicos");
		Button btGerarConsulta = new Button("Gerar Consulta");
		Button btMostrarLogs = new Button("Mostrar Logs");
		
		pane.add(btManipularPacientes,0,0);
		pane.add(btManipularMedicos,1,0);
		pane.add(btGerarConsulta,0,1);
		pane.add(btMostrarLogs,1,1);
		

		btManipularPacientes.setOnMouseClicked((e) -> Principal.mudarScene(2));
		btManipularMedicos.setOnMouseClicked((e) -> Principal.mudarScene(3));
		btGerarConsulta.setOnMouseClicked((e) -> Principal.mudarScene(4));
		btMostrarLogs.setOnAction((e) -> Principal.mudarScene(5));
		Scene scn = new Scene(pane, 400, 150);
		return scn;
	}
}

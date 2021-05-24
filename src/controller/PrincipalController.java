package controller;

import java.util.List;

import application.Principal;
import entities.Atendente;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import utils.Alerts;

public class PrincipalController {

	List<Atendente> logs = List.of(new Atendente("root", "123"), new Atendente("admin", "123"));// lista dos logins ja
																								// criados

	public Scene telaLogin() {
		Label title = new Label("Login");
		TextField tfUsuario = new TextField("Usuario");
		TextField tfSenha = new TextField("Senha");
		Button btEntrar = new Button("Entrar");
		VBox pane = new VBox(20);

		VBox.setMargin(tfUsuario, new Insets(0, 40, 0, 40));
		VBox.setMargin(tfSenha, new Insets(0, 40, 0, 40));
		VBox.setMargin(btEntrar, new Insets(0, 40, 0, 40));
		pane.setAlignment(Pos.CENTER);
		pane.getChildren().addAll(title, tfUsuario, tfSenha, btEntrar);
		btEntrar.setOnMouseClicked((e) -> login(tfUsuario.getText(), tfSenha.getText()));
		Scene scn = new Scene(pane, 300, 300);
		return scn;
	}

	public void login(String login, String senha) {
		int funcionou = 0;
		for (Atendente x : logs) {
			if (x.getLogin().equals(login) && x.getSenha().equals(senha)) {
				Principal.mudarScene(1);
				funcionou = 1;
				break;
			}
		}
		if (funcionou == 0) {
			Alerts.showAlert("Error login", null, "Usuário ou Senha incorreta", AlertType.ERROR);
			Principal.mudarScene(0);
		}
	}

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

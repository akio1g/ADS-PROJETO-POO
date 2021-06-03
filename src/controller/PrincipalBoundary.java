package controller;

import application.Principal;
import entities.Atendente;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import utils.Alerts;

public class PrincipalBoundary {

	public Scene telaLogin() {
		Label title = new Label("Login");
		TextField tfUsuario = new TextField("Usuario");
		TextField tfSenha = new TextField("Senha");
		Button btEntrar = new Button("Entrar");
		btEntrar.setDefaultButton(true);
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
		for (Atendente x : Principal.getAtendentesRegistrados()) {
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
}

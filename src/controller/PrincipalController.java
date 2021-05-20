package controller;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class PrincipalController {
	private Label title = new Label("Login");
	private TextField tfUsuario = new TextField("Usuario");
	private TextField tfSenha = new TextField("Senha");
	private Button btEntrar = new Button("Entrar");

	public Label getTitle() {
		return title;
	}

	public void setTitle(Label title) {
		this.title = title;
	}

	public TextField getTfUsuario() {
		return tfUsuario;
	}

	public void setTfUsuario(TextField tfUsuario) {
		this.tfUsuario = tfUsuario;
	}

	public TextField getTfSenha() {
		return tfSenha;
	}

	public void setTfSenha(TextField tfSenha) {
		this.tfSenha = tfSenha;
	}

	public Button getBtEntrar() {
		return btEntrar;
	}

	public void setBtEntrar(Button btEntrar) {
		this.btEntrar = btEntrar;
	}

	public Scene telaLogin(Label title, TextField tfUsuario, TextField tfSenha, Button btEntrar) {
		VBox pane = new VBox(20);

		VBox.setMargin(tfUsuario, new Insets(0, 40, 0, 40));
		VBox.setMargin(tfSenha, new Insets(0, 40, 0, 40));
		VBox.setMargin(btEntrar, new Insets(0, 40, 0, 40));
		pane.setAlignment(Pos.CENTER);
		pane.getChildren().addAll(title, tfUsuario, tfSenha, btEntrar);
		btEntrar.setOnMouseClicked((MouseEvent e) -> login(tfUsuario.getText(), tfSenha.getText()));
		Scene scn = new Scene(pane, 300, 300);
		return scn;
	}


}

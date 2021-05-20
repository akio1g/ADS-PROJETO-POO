package application;

import controller.PrincipalController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Principal extends Application {
	private static Stage stg;
	private Label title = new Label("Login");
	private TextField tfUsuario = new TextField("Usuario");
	private TextField tfSenha = new TextField("Senha");
	private Button btEntrar = new Button("Entrar");
	
	PrincipalController pControl = new PrincipalController();
	
	public static Stage getStg() {
		return stg;
	}

	public static void setStg(Stage stg) {
		Principal.stg = stg;
	}

	
	@Override
	public void start(Stage stg) throws Exception {
		stg.setTitle("Clínica Médica");
		Scene scn = pControl.telaLogin(title, tfUsuario, tfSenha, btEntrar);
		stg.setScene(scn);
		stg.show();
	}


	public static void main(String[] args) {
		Application.launch(Principal.class, args);
	}
}
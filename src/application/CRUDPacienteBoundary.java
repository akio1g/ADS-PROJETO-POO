package application;

import controller.CRUDPacienteController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CRUDPacienteBoundary extends Application{
	CRUDPacienteController cpControl = new CRUDPacienteController();
	public static void main(String[] args) {
		Application.launch(CRUDPacienteBoundary.class, args);
	}

	@Override
	public void start(Stage stg) throws Exception {
		stg.setTitle("Paciente");
		Scene scn = cpControl.telaPaciente();
		stg.setScene(scn);
		stg.show();
	}

}

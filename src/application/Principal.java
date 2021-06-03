package application;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import controller.CRUDMedicoBoundary;
import controller.CRUDPacienteBoundary;
import controller.ConsultaBoundary;
import controller.EscolhaBoundary;
import controller.PrincipalBoundary;
import controller.RegistrosBoundary;
import entities.Atendente;
import entities.Consulta;
import entities.Medico;
import entities.Paciente;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utils.LogsIniciais;

public class Principal extends Application {
	public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	public static SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm");
	public static Stage stage;
	public static Scene scn = null;
	public static PrincipalBoundary pBoundary = new PrincipalBoundary();
	public static CRUDPacienteBoundary cpBoundary = new CRUDPacienteBoundary();
	public static CRUDMedicoBoundary cmBoundary = new CRUDMedicoBoundary();
	public static EscolhaBoundary eBoundary = new EscolhaBoundary();
	public static ConsultaBoundary consultaBoundary = new ConsultaBoundary();
	public static RegistrosBoundary rBoundary = new RegistrosBoundary();
	private static LogsIniciais logs = new LogsIniciais();
	private static List<Medico> medicosRegistrados = new ArrayList<>();
	private static List<Paciente> pacientesRegistrados = new ArrayList<>();
	private static List<Consulta> consultaRegistrados = new ArrayList<>();
	private static List<Atendente> atendentesRegistrados = new ArrayList<>();

	@Override
	public void start(Stage stg) throws Exception {
		stage = stg;
		stg.setTitle("Clínica Médica");
		mudarScene(0);
		stg.show();
	}

	public static void mudarScene(int index) {
		switch (index) {
		case 0: // tela login
			stage.setTitle("Login");
			scn = pBoundary.telaLogin();
			break;
		case 1: // tela escolha
			stage.setTitle("Escolha");
			scn = eBoundary.telaEscolha();
			break;
		case 2: // tela crud paciente
			stage.setTitle("Paciente");
			scn = cpBoundary.telaPaciente();
			break;
		case 3: // tela crud medico
			stage.setTitle("Médico");
			scn = cmBoundary.telaMedico();
			break;
		case 4: // tela crud consulta
			stage.setTitle("Consulta");
			scn = consultaBoundary.telaConsulta();
			break;
		case 5: // tela registros
			stage.setTitle("Registros");
			scn = rBoundary.telaRegistro();
		}
		stage.setScene(scn);
	}

	public static void main(String[] args) {
		logs.inicializar();
		Application.launch(Principal.class, args);
	}

	public static List<Medico> getMedicosRegistrados() {
		return medicosRegistrados;
	}

	public static List<Paciente> getPacientesRegistrados() {
		return pacientesRegistrados;
	}

	public static List<Consulta> getConsultaRegistrados() {
		return consultaRegistrados;
	}

	public static List<Atendente> getAtendentesRegistrados() {
		return atendentesRegistrados;
	}
}
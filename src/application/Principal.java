package application;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import controller.CRUDMedicoController;
import controller.CRUDPacienteController;
import controller.ConsultaController;
import controller.EscolhaController;
import controller.PrincipalController;
import entities.Consulta;
import entities.Medico;
import entities.Paciente;
import entities.TipoConvenio;
import entities.TipoEspecialidade;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

// COLOCAR ENTITIES CONSULTA E CRIAR CRUD CONSULTA
public class Principal extends Application {
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	public static SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm");
	public static Stage stage;
	public static Scene scn = null;
	static PrincipalController pController = new PrincipalController();
	static CRUDPacienteController cpController = new CRUDPacienteController();
	static CRUDMedicoController cmController = new CRUDMedicoController();
	static EscolhaController eController = new EscolhaController();
	static ConsultaController cController = new ConsultaController();
	private static List<Medico> medicosRegistrados = new ArrayList<>();
	private static List<Paciente> pacientesRegistrados = new ArrayList<>();
	private static List<Consulta> consultaRegistrados = new ArrayList<>();
	
	@Override
	public void start(Stage stg) throws Exception {
		stage = stg;
		stg.setTitle("Clínica Médica");
		mudarScene(0);
		stg.show();
	}

	public static void iniciarPessoas() {
		pacientesRegistrados.add(new Paciente(1, "Gabriel", new Date(),"5403909346", "11998143671",
				"rua das arvores", TipoConvenio.Vivest));
		pacientesRegistrados.add(new Paciente(2, "Marcos", new Date(), "5472457754", "11984758764",
				"rua das pedras", TipoConvenio.Amil));
		pacientesRegistrados.add(new Paciente(3, "Marcelo", new Date(), "7807806456", "1199814421",
				"rua das palhaças", TipoConvenio.NotreDame));
		pacientesRegistrados.add(new Paciente(4, "Joao", new Date(), "4326235476", "11998187645",
				"rua das tortas", TipoConvenio.Unimed));
		medicosRegistrados.add(new Medico(1, "dr Fernando", new Date(), "6431261346", "3161616134",
				"rua maracuta", TipoEspecialidade.Cardiologia));
		medicosRegistrados.add(new Medico(2, "dr Frederico", new Date(), "89678079057", "625472457",
				"rua maça", TipoEspecialidade.Dermatologia));
		medicosRegistrados.add(new Medico(3, "dr Alan", new Date(), "6431261346", "3161616134",
				"rua dos copos", TipoEspecialidade.Ortopedia));
		medicosRegistrados.add(new Medico(4, "dra Camila", new Date(), "7850780587", "4572548248",
				"rua dos bambus", TipoEspecialidade.Psiquiatria));
	}

	public static void mudarScene(int index) {
		switch (index) {
		case 0:
			stage.setTitle("Login");
			scn = pController.telaLogin();
			break;
		case 1:
			stage.setTitle("Escolha");
			scn = eController.telaEscolha();
			break;
		case 2:
			stage.setTitle("Paciente");
			scn = cpController.telaPaciente();
			break;
		case 3:
			stage.setTitle("Médico");
			scn = cmController.telaMedico();
			break;
		case 4:
			stage.setTitle("Consulta");
			scn = cController.telaConsulta();
			break;
		}
		stage.setScene(scn);
	}

	public static void main(String[] args) {
		iniciarPessoas();
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
}
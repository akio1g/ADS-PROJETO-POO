package application;

import java.util.Date;

import controller.CRUDMedicoController;
import controller.CRUDPacienteController;
import controller.EscolhaController;
import controller.PrincipalController;
import entities.Medico;
import entities.Paciente;
import entities.TipoConvenio;
import entities.TipoEspecialidade;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

// COLOCAR ENTITIES CONSULTA E CRIAR CRUD CONSULTA
public class Principal extends Application {
	public static Stage stage;
	public static Scene scn = null;
	static PrincipalController pControl = new PrincipalController();
	static CRUDPacienteController cpController = new CRUDPacienteController();
	static CRUDMedicoController cmController = new CRUDMedicoController();
	static EscolhaController eControl = new EscolhaController();

	@Override
	public void start(Stage stg) throws Exception {
		stage = stg;
		stg.setTitle("Clínica Médica");
		mudarScene(0);
		stg.show();
	}

	public static void iniciarPessoas() {
		cpController.getPacientesRegistrados().add(new Paciente(1, "Gabriel", new Date(), "5403909346", "11998143671",
				"rua das arvores", TipoConvenio.Vivest));
		cpController.getPacientesRegistrados().add(new Paciente(2, "Marcos", new Date(), "5472457754", "11984758764",
				"rua das pedras", TipoConvenio.Amil));
		cpController.getPacientesRegistrados().add(new Paciente(3, "Marcelo", new Date(), "7807806456", "1199814421",
				"rua das palhaças", TipoConvenio.NotreDame));
		cpController.getPacientesRegistrados().add(new Paciente(4, "Joao", new Date(), "4326235476", "11998187645",
				"rua das tortas", TipoConvenio.Unimed));
		cmController.getMedicosRegistrados().add(new Medico(1, "dr Fernando", new Date(), "6431261346", "3161616134",
				"rua maracuta", TipoEspecialidade.Cardiologia));
		cmController.getMedicosRegistrados().add(new Medico(2, "dr Frederico", new Date(), "89678079057", "625472457",
				"rua maça", TipoEspecialidade.Dermatologia));
		cmController.getMedicosRegistrados().add(new Medico(3, "dr Alan", new Date(), "6431261346", "3161616134",
				"rua dos copos", TipoEspecialidade.Ortopedia));
		cmController.getMedicosRegistrados().add(new Medico(4, "dra Camila", new Date(), "7850780587", "4572548248",
				"rua dos bambus", TipoEspecialidade.Psiquiatria));
	}

	public static void mudarScene(int index) {
		switch (index) {
		case 0:
			stage.setTitle("Login");
			scn = pControl.telaLogin();
			break;
		case 1:
			stage.setTitle("Escolha");
			scn = eControl.telaEscolha();
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
		}
		stage.setScene(scn);
	}

	public static void main(String[] args) {
		iniciarPessoas();
		Application.launch(Principal.class, args);
	}
}
package utils;

import java.text.ParseException;
import java.time.LocalDate;

import application.Principal;
import entities.Atendente;
import entities.Medico;
import entities.Paciente;
import entities.TipoConvenio;
import entities.TipoEspecialidade;

public class LogsIniciais {
	public void pacientesRegistrados() throws ParseException {
		Principal.getPacientesRegistrados().add(new Paciente(1, "Gabriel", LocalDate.parse("14/11/2000",Principal.dtf), "40921048309", "11998143671",
				"Rua Das Arvores", TipoConvenio.Vivest));
		Principal.getPacientesRegistrados().add(new Paciente(2, "Emanuel Vicente Lima", LocalDate.parse("13/03/1992",Principal.dtf), "53313542387", "83994448878",
				"Rua Treze de Maio", TipoConvenio.Amil));
		Principal.getPacientesRegistrados().add(new Paciente(3, "Heloise Allana da Mata", LocalDate.parse("04/11/2001",Principal.dtf), "30974352047", "31985063093",
				"Rua Davi", TipoConvenio.NotreDame));
		Principal.getPacientesRegistrados().add(new Paciente(4, "Olivia Gabriela Mirella da Costa", LocalDate.parse("26/03/1963",Principal.dtf), "75026757790", "82996175065",
				"Rua das Tortas", TipoConvenio.Unimed));
		Principal.getPacientesRegistrados().add(new Paciente(5, "Cláudio Theo Luís Nunes", LocalDate.parse("02/05/1993",Principal.dtf), "48100860467", "47999160161",
				"Rua Maricá", TipoConvenio.PortoSeguro));
		Principal.getPacientesRegistrados().add(new Paciente(6, "Caio Manuel Hugo Figueiredo", LocalDate.parse("21/06/1997",Principal.dtf), "87178770406", "43981803443",
				"Rua Das Pedras", TipoConvenio.NotreDame));
		Principal.getPacientesRegistrados().add(new Paciente(7, "Marcelo Dias", LocalDate.parse("01/01/2000",Principal.dtf), "93492427880", "67985672691",
				"Rua Das Palhaças", TipoConvenio.NotreDame));
		Principal.getPacientesRegistrados().add(new Paciente(8, "Mirella Teresinha", LocalDate.parse("05/01/2002",Principal.dtf), "86422149107", "24993897672",
				"Rua Das Cerejas", TipoConvenio.PortoSeguro));
		Principal.getPacientesRegistrados().add(new Paciente(9, "Miguel Raimundo", LocalDate.parse("08/06/2002",Principal.dtf), "08422202913", "95995856255",
				"Rua João VI", TipoConvenio.Vivest));
		Principal.getPacientesRegistrados().add(new Paciente(10, "Marcos Feliciano", LocalDate.parse("25/01/2001",Principal.dtf), "5472457754", "2135840305",
				"Rua Antonio Fagundes", TipoConvenio.Amil));
	}
	
	public void medicosRegistrados() throws ParseException {
		Principal.getMedicosRegistrados().add(new Medico(1, "Dr Fernando Pires", LocalDate.parse("07/12/1975",Principal.dtf), "73402388162", "3161616134",
				"rua maracuta", TipoEspecialidade.Cardiologia));
		Principal.getMedicosRegistrados().add(new Medico(2, "Dr Frederico Fonseca", LocalDate.parse("07/11/1975",Principal.dtf), "89678079057", "625472457",
				"rua maça", TipoEspecialidade.Dermatologia));
		Principal.getMedicosRegistrados().add(new Medico(3, "Dr Alan Marcelo", LocalDate.parse("03/11/1974",Principal.dtf), "6431261346", "3161616134",
				"rua dos copos", TipoEspecialidade.Ortopedia));
		Principal.getMedicosRegistrados().add(new Medico(4, "Dra Camila Lópes", LocalDate.parse("17/10/1978",Principal.dtf), "7850780587", "4572548248",
				"rua dos bambus", TipoEspecialidade.Psiquiatria));
	}
	
	public void atendentesRegistrados() {
		Principal.getAtendentesRegistrados().add(new Atendente("admin","123"));
		Principal.getAtendentesRegistrados().add(new Atendente("root","123"));
	}
	public void inicializar() {
		try {
			pacientesRegistrados();
			medicosRegistrados();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		atendentesRegistrados();
	}
}

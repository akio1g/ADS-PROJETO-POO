package utils;

import java.text.ParseException;

import application.Principal;
import entities.dao.impl.AtendenteDAOImpl;
import entities.dao.impl.ConsultaDAOImpl;
import entities.dao.impl.MedicoDAOImpl;
import entities.dao.impl.PacienteDAOImpl;

public class LogsIniciais {
	PacienteDAOImpl pDao = new PacienteDAOImpl();
	MedicoDAOImpl mDao = new MedicoDAOImpl();
	AtendenteDAOImpl aDao = new AtendenteDAOImpl();
	ConsultaDAOImpl cDao = new ConsultaDAOImpl();
	public void pacientesRegistrados() throws ParseException {
		Principal.setPacientesRegistrados(pDao.encontrarTodos());
	}
	
	public void medicosRegistrados() throws ParseException {
		Principal.setMedicosRegistrados(mDao.encontrarTodos());
	}
	
	public void atendentesRegistrados() {
		Principal.setAtendentesRegistrados(aDao.encontrarTodos());
	}
	
	public void consultasRegistradas() {
		Principal.setConsultaRegistrados(cDao.encontrarTodos());
	}
	public void inicializar() {
		try {
			pacientesRegistrados();
			medicosRegistrados();
			atendentesRegistrados();
			consultasRegistradas();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}

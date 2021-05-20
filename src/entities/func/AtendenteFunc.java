package entities.func;

import entities.Atendente;

public class AtendenteFunc {
	public void registrarLogin(Atendente atendente) {
		atendente.setLogin("root");
		atendente.setSenha("123");
	}
}

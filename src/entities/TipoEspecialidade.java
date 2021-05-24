package entities;

public enum TipoEspecialidade {
	Cardiologia(1), Dermatologia(2), Ortopedia(3), Anestesiologia(4), Pediatria(5), Oftalmologia(6), Psiquiatria(7), Cirurgia_Plastica(8);

	private final int valor;

	TipoEspecialidade(int valorOpcao){
		valor = valorOpcao;
	}

	public int getValor() {
		return valor;
	}
}

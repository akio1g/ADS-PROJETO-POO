package entities;

public enum TipoConvenio {
	Amil(1),Vivest(2),NotreDame(3),Unimed(4),PortoSeguro(5);
	
	private int valor;
	
	TipoConvenio(int i) {
		this.valor = i;
	}

	public void setValor(int valorOpcao){
		valor = valorOpcao;
	}

	public int getValor() {
		return valor;
	}
}

package entities;

import java.time.LocalDate;

public class Medico {
	private int id;
	private String nome;
	private LocalDate dataNascimento;
	private String cpf;
	private String telefone;
	private String endereco;
	private TipoEspecialidade especialidade;

	public Medico(int id, String nome, LocalDate dataNascimento, String cpf, String telefone, String endereco,
			TipoEspecialidade especialidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.telefone = telefone;
		this.endereco = endereco;
		this.especialidade = especialidade;

	}

	public Medico() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;	
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public TipoEspecialidade getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(TipoEspecialidade especialidade) {
		this.especialidade = especialidade;
	}

}

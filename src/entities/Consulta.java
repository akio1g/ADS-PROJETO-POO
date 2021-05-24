package entities;

import java.util.Date;

public class Consulta {
	private Integer id;
	private String cpf;
	private String nome;
	private Date ConsultaDia;
	private Date ConsultaHora;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}



	public Date getConsultaDia() {
		return ConsultaDia;
	}

	public void setConsultaDia(Date consultaDia) {
		ConsultaDia = consultaDia;
	}

	public Date getConsultaHora() {
		return ConsultaHora;
	}

	public void setConsultaHora(Date consultaHora) {
		ConsultaHora = consultaHora;
	}

	public Consulta() {
	}

	public Consulta(Integer id, String cpf, String nome, Date consultaDia, Date consultaHora) {
		this.id = id;
		this.cpf = cpf;
		this.nome = nome;
		ConsultaDia = consultaDia;
		ConsultaHora = consultaHora;
	}

	

}

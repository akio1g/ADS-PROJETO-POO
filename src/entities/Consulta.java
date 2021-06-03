package entities;

import java.time.LocalDate;
import java.util.Date;

public class Consulta {
	private Integer id;
	private String cpf;
	private String nome;
	private LocalDate ConsultaDia;
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



	public LocalDate getConsultaDia() {
		return ConsultaDia;
	}

	public void setConsultaDia(LocalDate consultaDia) {
		ConsultaDia = consultaDia;
	}

	public Date getConsultaHora() {
		return ConsultaHora;
	}

	public void setConsultaHora(Date date) {
		ConsultaHora = date;
	}

	public Consulta() {
	}

	public Consulta(Integer id, String cpf, String nome, LocalDate consultaDia, Date consultaHora) {
		this.id = id;
		this.cpf = cpf;
		this.nome = nome;
		ConsultaDia = consultaDia;
		ConsultaHora = consultaHora;
	}

	

}

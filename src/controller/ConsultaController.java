package controller;

import java.awt.TextField;

import entities.Medico;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class ConsultaController {
	Label lblId = new Label("ID Consulta");
	TextField tfId = new TextField();
	Button btPesquisar = new Button("Pesquisar");
	Button btAlterar = new Button("Alterar");
	Button btAdicionar = new Button("Adicionar");
	Button btExcluir = new Button("Excluir");
	Button btLimpar = new Button("Limpar");
	Button btVoltar = new Button("Voltar");
	Label lblCpf = new Label("CPF Paciente");
	TextField tfCpf = new TextField();
	Label lblNomePaciente = new Label("");
	Label lblNomeMedico = new Label("Nome Médico");
	ComboBox<Medico> cbNomeMedico = new ComboBox<>();
	Label message = new Label("");
	Label lblData = new Label("Data Consulta");
	TextField tfData = new TextField();
	Label lblHora = new Label("Hora Consulta");
	TextField tfHora = new TextField();
	
			
}

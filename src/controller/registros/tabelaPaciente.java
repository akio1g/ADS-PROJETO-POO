package controller.registros;

import java.time.LocalDate;

import application.Principal;
import entities.Paciente;
import entities.TipoConvenio;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

public class tabelaPaciente implements telaStrategy {
	TableView<Paciente> tPaciente = new TableView<>();

	@Override
	public Pane gerarTabela() {
		Pane p = new Pane();
		p.setPadding(new Insets(10, 10, 10, 10));
		p.getChildren().add(tPaciente);
		generateTablePaciente(tPaciente);
		return p;
	}

	private void generateTablePaciente(TableView<Paciente> tabela) {
		TableColumn<Paciente, Integer> colunaId = new TableColumn<>("Id");
		TableColumn<Paciente, String> colunaNome = new TableColumn<>("Nome");
		TableColumn<Paciente, LocalDate> colunaNascimento = new TableColumn<>("Data de Nascimento");
		TableColumn<Paciente, String> colunaCpf = new TableColumn<>("CPF");
		TableColumn<Paciente, String> colunaTelefone = new TableColumn<>("Telefone");
		TableColumn<Paciente, String> colunaEndereco = new TableColumn<>("Endereço");
		TableColumn<Paciente, TipoConvenio> colunaConvenio = new TableColumn<>("Convênio");

		colunaId.setCellValueFactory(new PropertyValueFactory<Paciente, Integer>("id"));
		colunaNome.setCellValueFactory(new PropertyValueFactory<Paciente, String>("nome"));
		colunaNascimento.setCellValueFactory(new PropertyValueFactory<Paciente, LocalDate>("dataNascimento"));
		colunaCpf.setCellValueFactory(new PropertyValueFactory<Paciente, String>("cpf"));
		colunaTelefone.setCellValueFactory(new PropertyValueFactory<Paciente, String>("telefone"));
		colunaEndereco.setCellValueFactory(new PropertyValueFactory<Paciente, String>("endereco"));
		colunaConvenio.setCellValueFactory(new PropertyValueFactory<Paciente, TipoConvenio>("convenio"));

		colunaNascimento.setCellFactory(cell -> {
			return new TableCell<Paciente, LocalDate>() {
				@Override
				protected void updateItem(LocalDate item, boolean empty) {
					super.updateItem(item, empty);
					if (!empty) {
						setText(Principal.dtf.format(item));
					} else {
						setText("");
						setGraphic(null);
					}
				}
			};
		});

		tabela.getColumns().addAll(colunaId, colunaNome, colunaNascimento, colunaCpf, colunaTelefone, colunaConvenio);
		tabela.setItems(FXCollections.observableArrayList(Principal.getPacientesRegistrados()));
	}

}

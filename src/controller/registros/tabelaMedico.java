package controller.registros;

import java.time.LocalDate;

import application.Principal;
import entities.Medico;
import entities.TipoEspecialidade;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

public class tabelaMedico implements telaStrategy {
	TableView<Medico> tMedico = new TableView<>();

	@Override
	public Pane gerarTabela() {
		Pane p = new Pane();
		p.setPadding(new Insets(10, 10, 10, 10));
		p.getChildren().add(tMedico);
		generateTableMedico(tMedico);
		return p;
	}

	private void generateTableMedico(TableView<Medico> tabela) {
		TableColumn<Medico, Integer> colunaId = new TableColumn<>("Id");
		TableColumn<Medico, String> colunaNome = new TableColumn<>("Nome");
		TableColumn<Medico, LocalDate> colunaNascimento = new TableColumn<>("Data de Nascimento");
		TableColumn<Medico, String> colunaCpf = new TableColumn<>("CPF");
		TableColumn<Medico, String> colunaTelefone = new TableColumn<>("Telefone");
		TableColumn<Medico, String> colunaEndereco = new TableColumn<>("Endereço");
		TableColumn<Medico, TipoEspecialidade> colunaEspecialidade = new TableColumn<>("Especialidade");

		colunaId.setCellValueFactory(new PropertyValueFactory<Medico, Integer>("id"));
		colunaNome.setCellValueFactory(new PropertyValueFactory<Medico, String>("nome"));
		colunaNascimento.setCellValueFactory(new PropertyValueFactory<Medico, LocalDate>("dataNascimento"));
		colunaCpf.setCellValueFactory(new PropertyValueFactory<Medico, String>("cpf"));
		colunaTelefone.setCellValueFactory(new PropertyValueFactory<Medico, String>("telefone"));
		colunaEndereco.setCellValueFactory(new PropertyValueFactory<Medico, String>("endereco"));
		colunaEspecialidade.setCellValueFactory(new PropertyValueFactory<Medico, TipoEspecialidade>("especialidade"));

		colunaNascimento.setCellFactory(cell -> {
			return new TableCell<Medico, LocalDate>() {
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

		tabela.getColumns().addAll(colunaId, colunaNome, colunaNascimento, colunaCpf, colunaTelefone,
				colunaEspecialidade);
		tabela.setItems(FXCollections.observableArrayList(Principal.getMedicosRegistrados()));
	}

}

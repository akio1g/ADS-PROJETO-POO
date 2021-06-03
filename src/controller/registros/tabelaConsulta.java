package controller.registros;

import java.time.LocalDate;
import java.util.Date;

import application.Principal;
import entities.Consulta;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

public class tabelaConsulta implements telaStrategy{
	TableView<Consulta> tConsulta = new TableView<>();
	@Override
	public Pane gerarTabela() {
		Pane p = new Pane();
		p.setPadding(new Insets(10,10,10,10));
		p.getChildren().add(tConsulta);
		generateTableConsulta(tConsulta);
		p.setMaxHeight(500);
		return p;
	}
	
	private void generateTableConsulta(TableView<Consulta> tabela) {

		TableColumn<Consulta, Integer> colunaId = new TableColumn<>("Id");
		TableColumn<Consulta, String> colunaCpfPaciente = new TableColumn<>("Cpf do Paciente");
		TableColumn<Consulta, String> colunaNomeDoMedico = new TableColumn<>("Nome do Medico");
		TableColumn<Consulta, LocalDate> colunaDiaConsulta = new TableColumn<>("Dia da Consulta");
		TableColumn<Consulta, Date> colunaHoraConsulta = new TableColumn<>("Horario da Consulta");

		colunaId.setCellValueFactory(new PropertyValueFactory<Consulta, Integer>("id"));
		colunaCpfPaciente.setCellValueFactory(new PropertyValueFactory<Consulta, String>("cpf"));
		colunaNomeDoMedico.setCellValueFactory(new PropertyValueFactory<Consulta, String>("nome"));
		colunaDiaConsulta.setCellValueFactory(new PropertyValueFactory<Consulta, LocalDate>("consultaDia"));
		colunaHoraConsulta.setCellValueFactory(new PropertyValueFactory<Consulta, Date>("consultaHora"));

		colunaDiaConsulta.setCellFactory(cell -> {
			return new TableCell<Consulta, LocalDate>() {
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
		colunaHoraConsulta.setCellFactory(cell -> {
			return new TableCell<Consulta, Date>() {
				@Override
				protected void updateItem(Date item, boolean empty) {
					super.updateItem(item, empty);
					if (!empty) {
						setText(Principal.sdf1.format(item));
					} else {
						setText("");
						setGraphic(null);
					}
				}
			};
		});

		tabela.getColumns().addAll(colunaId, colunaCpfPaciente, colunaNomeDoMedico, colunaDiaConsulta,
				colunaHoraConsulta);
		tabela.setItems(FXCollections.observableArrayList(Principal.getConsultaRegistrados()));
	}

}

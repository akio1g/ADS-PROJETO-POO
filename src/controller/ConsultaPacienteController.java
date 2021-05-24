package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import entities.Paciente;
import entities.TipoConvenio;
import entities.func.PacienteFunc;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ConsultaPacienteController implements PacienteFunc {
	Label lblId = new Label("ID Paciente");
	TextField tfId = new TextField();
	Button btPesquisar = new Button("Pesquisar");
	Button btAlterar = new Button("Alterar");
	Button btAdicionar = new Button("Adicionar");
	Button btExcluir = new Button("Excluir");
	Label lblNome = new Label("Nome");
	Label lblData = new Label("Data de Nascimento");
	Label lblCpf = new Label("Cpf");
	Label lblTelefone = new Label("Telefone");
	Label lblEndereco = new Label("Endereço");
	Label lblConvenio = new Label("Convênio");
	TextField tfNome = new TextField();
	TextField tfData = new TextField();
	TextField tfCpf = new TextField();
	TextField tfTelefone = new TextField();
	TextField tfEndereco = new TextField();
	ComboBox<TipoConvenio> cbConvenio = new ComboBox<>();

	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	List<Paciente> pacientesRegistrados = List.of(
			new Paciente(1,"Gabriel",new Date(),"5403909346","11998143671","rua das arvores",TipoConvenio.Vivest),
			new Paciente(2,"Marcos",new Date(),"5472457754","11984758764","rua das pedras",TipoConvenio.Amil),
			new Paciente(3,"Marcelo",new Date(),"7807806456","1199814421","rua das palhaças",TipoConvenio.NotreDame),
			new Paciente(4,"Joao",new Date(),"4326235476","11998187645","rua das tortas",TipoConvenio.Unimed));
	
	
	public Scene telaPaciente() {
		HBox pane1 = new HBox(10);
		pane1.setPadding(new Insets(0, 0, 0, 10));
		pane1.getChildren().addAll(lblId, tfId, btPesquisar, btAlterar, btExcluir);

		GridPane pane2 = new GridPane();
		pane2.setHgap(20.0);
		pane2.setPadding(new Insets(0, 0, 0, 10));
		pane2.add(lblNome, 0, 0);
		pane2.add(tfNome, 1, 0);
		pane2.add(lblData, 0, 1);
		pane2.add(tfData, 1, 1);
		pane2.add(lblCpf, 0, 2);
		pane2.add(tfCpf, 1, 2);
		pane2.add(lblTelefone, 0, 3);
		pane2.add(tfTelefone, 1, 3);
		pane2.add(lblConvenio, 0, 4);
		pane2.add(cbConvenio, 1, 4);
		pane2.add(btAdicionar, 2, 4);

		cbConvenio.getItems().addAll(TipoConvenio.values());

		btPesquisar.setOnAction((e) -> pesquisarPorId(Integer.parseInt(tfId.getText())));
		btAdicionar.setOnAction((e) -> adicionar());
		btAlterar.setOnAction((e) -> alterarPorId(Integer.parseInt(tfId.getText())));
		btExcluir.setOnAction((e) -> excluirPorId(Integer.parseInt(tfId.getText())));

		VBox panePrincipal = new VBox(20);
		panePrincipal.getChildren().addAll(pane1, pane2);
		panePrincipal.setPadding(new Insets(10, 0, 0, 0));
		Scene scn = new Scene(panePrincipal, 500, 200);
		return scn;
	}

	@Override
	public void adicionar() {
		Paciente a = new Paciente();
		try {
			a.setId(pacientesRegistrados.size()+1);
			a.setNome(tfNome.getText());
			a.setDataNascimento(sdf.parse(tfData.getText()));
			a.setCpf(tfCpf.getText());
			a.setTelefone(tfTelefone.getText());
			a.setEndereco(tfEndereco.getText());
			a.setConvenio(cbConvenio.getValue());
		} catch (ParseException e) {
			e.printStackTrace();
		}		
		pacientesRegistrados.add(a);
	}

	@Override
	public void alterarPorId(Integer id) {
		
	}

	@Override
	public void excluirPorId(Integer id) {
	}

	@Override
	public Paciente pesquisarPorId(Integer id) {
		return null;
	}

}

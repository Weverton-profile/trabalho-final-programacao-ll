package gui;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.entities.Carro;

public class CarroViewController implements Initializable{
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
	
	@FXML
	private TableView<Carro> tableViewCarro;
	
	@FXML
	private TableColumn<Carro, String> tableColumnPlaca;
	
	@FXML
	private TableColumn<Carro, Integer> tableColumnAno;
	
	@FXML
	private TableColumn<Carro, String> tableColumnCor;
	
	@FXML
	private TableColumn<Carro, String> tableColumnMarca;
	
	@FXML
	private TableColumn<Carro, String> tableColumnModelo;
	
	@FXML
	private TableColumn<Carro, String> tableColumnChassi;
	
	@FXML
	private TableColumn<Carro, String> tableColumnProprietario;
	
	@FXML
	private TableColumn<Carro, String> tableColumnDataDeCompra;
	
	@FXML
	private Button btVoltar;
	
	static ObservableList<Carro> dados = FXCollections.observableArrayList();
	
	public void table(String placa, Integer ano, String cor, String marca, String modelo, String chassi, String proprietario,
            String dataCompra) {
		dados.add(new Carro(placa, ano, cor, marca, modelo, chassi, proprietario, dataCompra));
	}
	
	public void thrid(String placa, Integer ano, String cor, String marca, String modelo, String chassi, String proprietario,
            String dataCompra) {
			dados.add(2, new Carro(placa, ano, cor, marca, modelo, chassi, proprietario, dataCompra));
	}
	
	public void removeLast() {
		dados.remove(dados.size()-1);
	}
	public void onBtVoltarAction() {
		Main.changeScreen("main");
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		TableColumn<Carro,String> tableColumnPlaca = new TableColumn<>("Placa");
        TableColumn<Carro,Integer> tableColumnAno = new TableColumn<>("Ano");
        TableColumn<Carro,String> tableColumnCor = new TableColumn<>("Cor");
        TableColumn<Carro,String> tableColumnMarca = new TableColumn<>("Marca");
        TableColumn<Carro,String> tableColumnModelo = new TableColumn<>("Modelo");
        TableColumn<Carro,String> tableColumnChassi = new TableColumn<>("Chassi");
        TableColumn<Carro,String> tableColumnProprietario = new TableColumn<>("Proprietario");
        TableColumn<Carro,String> tableColumnDataDeCompra = new TableColumn<>("Data Compra");
        tableViewCarro.getColumns().addAll(tableColumnPlaca, tableColumnAno, tableColumnCor, tableColumnMarca, tableColumnModelo,
        		tableColumnChassi, tableColumnProprietario, tableColumnDataDeCompra);
		tableColumnPlaca.setCellValueFactory(new PropertyValueFactory<>("placa"));
		tableColumnAno.setCellValueFactory(new PropertyValueFactory<>("ano"));
		tableColumnCor.setCellValueFactory(new PropertyValueFactory<>("cor"));
		tableColumnMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
		tableColumnModelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));
		tableColumnChassi.setCellValueFactory(new PropertyValueFactory<>("chassi"));
		tableColumnProprietario.setCellValueFactory(new PropertyValueFactory<>("proprietario"));
		tableColumnDataDeCompra.setCellValueFactory(new PropertyValueFactory<>("dataCompra"));
		tableViewCarro.setItems(dados);
	}
}

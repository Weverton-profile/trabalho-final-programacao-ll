package gui;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import gui.util.Alerts;
import gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.entities.Carro;



public class ViewController implements Initializable{
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");	
	
	CarroViewController c = new CarroViewController();
	
	List<Carro> list = new ArrayList<>();

	@FXML
	private Button btAddNew;
	
	@FXML
	private Button btThirdElement;
	
	@FXML 
	private Button btFirstLast;
	
	@FXML
	private Button btRemoveLast;
	
	@FXML
	private Button btShowAll;
	
	@FXML
	private TextField txtPlaca;
	
	@FXML
	private TextField txtAno;
	
	@FXML
	private TextField txtCor;
	
	@FXML
	private TextField txtMarca;
	
	@FXML
	private TextField txtModelo;
	
	@FXML
	private TextField txtChassi;
	
	@FXML
	private TextField txtProprietario;
	
	@FXML
	private TextField txtDataDeCompra;
	


	public void onBtAddNew() {	
		
		try {
				list.add(new Carro(txtPlaca.getText(), Integer.parseInt(txtAno.getText()), txtCor.getText(), 
						txtMarca.getText(), txtModelo.getText(), txtChassi.getText(), txtProprietario.getText(), 
						String.valueOf(sdf.parse(txtDataDeCompra.getText()))));
		
				c.table(txtPlaca.getText(), Integer.parseInt(txtAno.getText()), txtCor.getText(), 
						txtMarca.getText(), txtModelo.getText(), txtChassi.getText(), txtProprietario.getText(), 
						String.valueOf(sdf.parse(txtDataDeCompra.getText())));
			    
		}
		catch(ParseException e) {
			Alerts.showAlert("ParseException Erorr", null, e.getMessage(), AlertType.ERROR);		
		}
		catch(NumberFormatException n) {
			Alerts.showAlert("NumberFormatException Erorr", null, "Todos os campos estão em branco", AlertType.ERROR);
		}
		
	}
	
	public void onBtThirdElement() {
		try {
			if(list.size() == 0 || list.size() <2) {
				Alerts.showAlert("Erro", null, "A lista esta vazia ou não tem 2 ou mais elementos!", AlertType.ERROR);
			}
			else {
				list.add(2, new Carro(txtPlaca.getText(), Integer.parseInt(txtAno.getText()), txtCor.getText(), 
						txtMarca.getText(), txtModelo.getText(), txtChassi.getText(), txtProprietario.getText(), 
						String.valueOf(sdf.parse(txtDataDeCompra.getText()))));
				c.thrid(txtPlaca.getText(), Integer.parseInt(txtAno.getText()), txtCor.getText(), 
						txtMarca.getText(), txtModelo.getText(), txtChassi.getText(), txtProprietario.getText(), 
						String.valueOf(sdf.parse(txtDataDeCompra.getText())));
			}
		}
		catch(ParseException e) {
			Alerts.showAlert("ParseException Erorr", null, e.getMessage(), AlertType.ERROR);
		}
	}
	
	public void onBtFirstLast() {
		if(list.size() != 0 && list.size() >= 2){
			Alerts.showAlert("Placas 1º e Ultimo", null, "Placa 1º :"+ list.get(0).getPlaca() +"\n Placa ultimo : "+ list.get(list.size() - 1).getPlaca(), AlertType.INFORMATION);
		}
		else {
			Alerts.showAlert("Erro", null, "A lista esta vazia ou so possui 1 elemento!", AlertType.ERROR);
		}
	}
	
	public void onBtRemoveLast() {
		if(list.size() == 0) {
			Alerts.showAlert("Erro", null, "A lista esta vazia", AlertType.ERROR);
		}
		else {
			Alerts.showAlert("Remover", null, "O veiculo "+ list.get(list.size()-1).getPlaca() +" foi removido !", AlertType.INFORMATION);
			c.removeLast();
			list.remove(list.size()-1);
		}
	}
		
    	private static final String path = "C:\\Users\\Raul\\Documents\\NetBeansProjects\\Loja\\teste.csv";
	
		public void addArquivo(){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(path))){
                for (Carro e : list) {
                    bw.write(e.toString());
                    bw.newLine();
            }
        }
        catch(IOException e){
            e.getMessage();
        }
    }
	
	public void onBtShowAll() {
		System.out.println("Deu");
		addArquivo();
		Main.changeScreen("detail");
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {	
		Constraints.setTextFieldInteger(txtAno);
		Constraints.setTextFieldMaxLength(txtAno, 4);
		Constraints.setTextFieldMaxLength(txtChassi, 17);
		Constraints.setTextFieldPlaca(txtPlaca);
	}
	public List<Carro> findAll(){
		return list;
	}
}

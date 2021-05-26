package model.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;


import javafx.beans.property.SimpleStringProperty;

/**
 * Essa classe contem todos os gets e set usados para atribuir os valores
 * 
 * 
 * @author Weverton
 *
 */

public class Carro implements Serializable{
	
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private static final long serialVersionUID = 1L;
	
	private SimpleStringProperty proprietario = new SimpleStringProperty();
    private SimpleStringProperty placa = new SimpleStringProperty();
    private SimpleStringProperty cor = new SimpleStringProperty();
    private SimpleStringProperty marca = new SimpleStringProperty();
    private SimpleStringProperty modelo = new SimpleStringProperty();
    private SimpleStringProperty chassi = new SimpleStringProperty();
    private SimpleStringProperty ano = new SimpleStringProperty();
    private SimpleStringProperty dataCompra = new SimpleStringProperty();

    
    /**
     * construtor da lista
     * 
     * 
     * @param placa 
     * @param ano 
     * @param cor 
     * @param marca
     * @param modelo
     * @param chassi
     * @param proprietario
     * @param dataCompra
     */
    public Carro(String placa, Integer ano, String cor, String marca, String modelo, String chassi, String proprietario,
            String dataCompra) {
        this.placa.set(placa);
        this.ano.set(String.valueOf(ano));
        this.cor.set(cor);
        this.marca.set(marca);;
        this.modelo.set(modelo);
        this.chassi.set(chassi);
        this.proprietario.set(proprietario);
        this.dataCompra.set(dataCompra);
    }

	public String getProprietario() {
        return proprietario.get();
    }

    public void setProprietario(String proprietario) {
        this.proprietario.set(proprietario);
    }

    public String getPlaca() {
        return placa.get();
    }

    public void setPlaca(String placa) {
        this.placa.set(placa);
    }

    public String getCor() {
        return cor.get();
    }

    public void setCor(String cor) {
        this.cor.set(cor);
    }

    public String getMarca() {
        return marca.get();
    }

    public void setMarca(String marca) {
        this.marca.set(marca);
    }

    public String getModelo() {
        return modelo.get();
    }

    public void setModelo(String modelo) {
        this.modelo.set(modelo);
    }

    public String getChassi() {
        return chassi.get();
    }

    public void setChassi(String chassi) {
        this.chassi.set(chassi);
    }

    public int getAno() {
        return Integer.parseInt(ano.get());
    }

    public void setAno(int ano) {
        this.ano.set(String.valueOf(ano));
    }

    public String getDataCompra() {
    	String[] vet;
    	vet = dataCompra.get().split(" ");
        return vet[2] +"/"+ vet[1] +"/"+ vet[5];
    }

    public void setDataCompra(String dataCompra) {
        this.dataCompra.set(dataCompra);
    }
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((placa == null) ? 0 : placa.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carro other = (Carro) obj;
		if (placa == null) {
			if (other.placa != null)
				return false;
		} else if (!placa.equals(other.placa))
			return false;
		return true;
	}
	/**
	 * Retorna oque vai aparecer no arquivos csv
	 */
	@Override
	public String toString() {
		return this.getPlaca() +", "+ this.getAno() +", "+ this.getCor() +", "+ this.getMarca() 
				+", "+ this.getModelo() +", "+ this.getChassi() +", "+ this.getProprietario() 
				+", "+ this.getDataCompra();
	}	

}

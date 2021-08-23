package dto;

import java.sql.ResultSet;

public class Tupla {
	private int id;
	private String valor;
	
	
	public Tupla(int id, String valor) {
		this.setId(id);
		this.setValor(valor);
	}

	public String getValor() {
		return valor;
	}


	public void setValor(String valor) {
		this.valor = valor;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	
	public String getString() {
		return this.id + " - " + this.valor;
	}
	
	
}

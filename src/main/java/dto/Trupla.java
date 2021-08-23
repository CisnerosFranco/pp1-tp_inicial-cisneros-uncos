package dto;

public class Trupla {
	
	private int id;
	private int id_2;
	private String valor;
	
	
	public Trupla(int id, int id_2, String valor) {
		this.id = id;
		this.id_2 = id_2;
		this.valor = valor;
	}


	@Override
	public String toString() {
		return "Trupla [id=" + id + ", id_2=" + id_2 + ", valor=" + valor + "]";
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getId_2() {
		return id_2;
	}


	public void setId_2(int id_2) {
		this.id_2 = id_2;
	}


	public String getValor() {
		return valor;
	}


	public void setValor(String valor) {
		this.valor = valor;
	}
	
	

}

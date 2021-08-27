package dto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import persistencia.conexion.Conexion;

public class Tipo_Contacto {
	
	private static Tipo_Contacto instancia;
	private static String readTipoContacto = "select * from tipo_contacto";
	private static List<Tupla> tipo_contacto = new ArrayList<Tupla>();
	
	private Tipo_Contacto() {}
	
	public static Tipo_Contacto contructor() {
		if( instancia == null) {
			instancia = new Tipo_Contacto();
		}
		
		readTipoContacto();
		return  instancia;
	}
	

	private static void readTipoContacto() {
		tipo_contacto.clear();
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		Conexion conexion = Conexion.getConexion();
		try  {
			statement = conexion.getSQLConexion().prepareStatement(readTipoContacto);
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				tipo_contacto.add(new Tupla(resultSet.getInt("id"), resultSet.getString("tipo")));
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Tupla> getTipoContactos() {
		return this.tipo_contacto;
	}
	
	public String getTipoContacto(int id_contacto) {
		System.out.println("*"+id_contacto);
		String ret = "";
		int index = 0;
		if(id_contacto != 0) {
			while(ret == "") {
				if(tipo_contacto.get(index).getId() == id_contacto) {
					ret = tipo_contacto.get(index).getValor();
				}
				index++;
			}
			
		}
		return ret;
	}

}

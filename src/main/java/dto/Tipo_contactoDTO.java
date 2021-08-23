package dto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import persistencia.conexion.Conexion;

public class Tipo_contactoDTO {

	private static String readAll = "select * from tipo_contacto;";
	private static List<Tupla> tipo_contacto = new ArrayList<Tupla>();
	
	private static void readElements() {
		tipo_contacto.clear();
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		Conexion conexion = Conexion.getConexion();
		try  {
			statement = conexion.getSQLConexion().prepareStatement(readAll);
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				tipo_contacto.add(new Tupla(resultSet.getInt("id"), resultSet.getString("tipo")));
				//System.out.println(new Tupla(resultSet.getInt("id"), resultSet.getString("localidad")).getString());
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		//return personas;
	}

	public static List<Tupla> readAll() {
		readElements(); // realizamos la consulta y llenamos la lista de localidades.
		return tipo_contacto;
	}
	
}

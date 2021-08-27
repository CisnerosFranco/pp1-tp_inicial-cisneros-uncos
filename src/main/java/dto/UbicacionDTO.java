package dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import persistencia.conexion.Conexion;


// esta clase implementa la metodologia SINGLETON.
public class UbicacionDTO {
	
	private static String readLocalidad = "select * from localidad";
	private static String readProv = "select * from provincia";
	private static String readPais = "select * from pais";
	
	private static List<Trupla> localidades = new ArrayList<Trupla>();
	private static List<Trupla> provincias = new ArrayList<Trupla>();
	private static List<Tupla> paises = new ArrayList<Tupla>();
	private static UbicacionDTO instancia = null;
	
	private UbicacionDTO () {} // El tio Sam privatizo el constructor de la clase.
	
	public static UbicacionDTO constructor() {
		if( instancia == null) {
			instancia = new UbicacionDTO();
		}
		
		readLocalidades();
		readProvincias();
		readPaises();
		return instancia;
	}
	
	private static void readLocalidades() {
		localidades.clear();
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		Conexion conexion = Conexion.getConexion();
		try  {
			statement = conexion.getSQLConexion().prepareStatement(readLocalidad);
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				localidades.add(new Trupla(resultSet.getInt("id"), resultSet.getInt("id_provincia"), resultSet.getString("localidad")));
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	private static void readProvincias() {
		provincias.clear();
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		Conexion conexion = Conexion.getConexion();
		try  {
			statement = conexion.getSQLConexion().prepareStatement(readProv);
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				provincias.add(new Trupla(resultSet.getInt("id"), resultSet.getInt("id_pais"), resultSet.getString("provincia")));
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void readPaises() {
		paises.clear();
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		Conexion conexion = Conexion.getConexion();
		try  {
			statement = conexion.getSQLConexion().prepareStatement(readPais);
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				paises.add(new Tupla(resultSet.getInt("id"), resultSet.getString("pais")));
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	

	public List<Trupla> getLocalidades(int id_prov) {
		List<Trupla> ret = new ArrayList<Trupla>();
		for(Trupla I: localidades) {
			if(I.getId_2() == id_prov) {
				ret.add(I);
			}
		}
		return ret;
	}
	
	public List<Trupla> getProvincias(int id_pais) {
		List<Trupla> ret = new ArrayList<Trupla>();
		for(Trupla I: provincias) {
			if(I.getId_2() == id_pais) {
				ret.add(I);
			}
		}
		return ret;
	}
	
	public List<Tupla> getPaises() {
		return paises;
	}
	
	public Trupla getLocalidad(int id_loc) {
		Trupla ret = null;
		int index = 0;
		while(ret == null) {
			if(localidades.get(index).getId() == id_loc) {
				ret = localidades.get(index);
			}
			index++;
		}
		return ret;
	}
	
	public Trupla getProvincia(int id_prov) {
		Trupla ret = null;
		int index = 0;
		while(ret == null) {
			if(provincias.get(index).getId() == id_prov) {
				ret = provincias.get(index);
			}
			index++;
		}
		return ret;
	}
	
	public Tupla getPais(int id_pais) {
		Tupla ret = null;
		int index = 0;
		while(ret == null) {
			if(paises.get(index).getId() == id_pais) {
				ret = paises.get(index);
			}
			index++;
		}
		return ret;
	}
	
	
	
	
	
}

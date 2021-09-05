package persistencia.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.PersonaDAO;
import dto.PersonaDTO;
import dto.Tipo_Contacto;

public class PersonaDAOSQL implements PersonaDAO {
	private static final String insert = "INSERT INTO personas(idPersona, nombre, telefono) VALUES(?, ?, ?)";
	private static final String delete = "DELETE FROM personas WHERE idPersona = ?";
	private static final String update = "UPDATE personas SET Nombre=?, Telefono=?, Tipo_Contacto_id=?, localidad_id=?, calle=?, altura=?, piso=?, depto=?, email=?, cumpleanio=?, mascota_preferida=? WHERE idPersona=?";
	private static final String update_2 = "UPDATE personas SET Nombre=?, Telefono=?, Tipo_Contacto_id=?, calle=?, altura=?, piso=?, depto=?, email=?, cumpleanio=?, mascota_preferida=? WHERE idPersona=?";
	private static final String readall = "select * from personas as P left join tipo_contacto as T ON P.tipo_contacto_id = T.id left join localidad as L ON P.localidad_id = L.id \r\n"
										+ "left join provincia as Prov ON L.id_provincia= Prov.id left join pais on prov.id_pais = pais.id order by L.localidad;";
	Tipo_Contacto TC = Tipo_Contacto.contructor();
		
	
	public boolean insert(PersonaDTO persona) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try {
			statement = conexion.prepareStatement(insert);
			statement.setInt(1, persona.getIdPersona());
			statement.setString(2, persona.getNombre());
			statement.setString(3, persona.getTelefono());
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isInsertExitoso = true;
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		return isInsertExitoso;
	}
	
	public boolean delete(PersonaDTO persona_a_eliminar) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try {
			statement = conexion.prepareStatement(delete);
			statement.setString(1, Integer.toString(persona_a_eliminar.getIdPersona()));
			if(statement.executeUpdate() > 0) {
				conexion.commit();
				isdeleteExitoso = true;
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return isdeleteExitoso;
	}
	
	
	
	
	public boolean update(PersonaDTO P) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isupdateExitoso = false;
		try {
			if(P.getLocalidad_id() == -1) {
				statement = conexion.prepareStatement(update_2);
				
				statement.setString(1, P.getNombre());
				statement.setString(2, P.getTelefono());
				statement.setString(3, Integer.toString(P.getTipo_contacto_id()));
				statement.setString(4, P.getCalle());
				statement.setString(5, P.getAltura());
				statement.setString(6, P.getPiso());
				statement.setString(7, P.getDepto());
				statement.setString(8, P.getEmail());
				statement.setString(9, P.getCumple());
				statement.setString(10, P.getMascota_preferida());
				statement.setString(11, Integer.toString(P.getIdPersona()));
				
				if(statement.executeUpdate() > 0) {
					conexion.commit();
					isupdateExitoso = true;
				}
			} else {
				statement = conexion.prepareStatement(update);
				
				statement.setString(1, P.getNombre());
				statement.setString(2, P.getTelefono());
				statement.setString(3, Integer.toString(P.getTipo_contacto_id()));
				statement.setString(4, Integer.toString(P.getLocalidad_id()));
				statement.setString(5, P.getCalle());
				statement.setString(6, P.getAltura());
				statement.setString(7, P.getPiso());
				statement.setString(8, P.getDepto());
				statement.setString(9, P.getEmail());
				statement.setString(10, P.getCumple());
				statement.setString(11, P.getMascota_preferida());
				statement.setString(12, Integer.toString(P.getIdPersona()));
				
				if(statement.executeUpdate() > 0) {
					conexion.commit();
					isupdateExitoso = true;
				}
			}
				
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return isupdateExitoso;
	}
	
	public List<PersonaDTO> readAll() {
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<PersonaDTO> personas = new ArrayList<PersonaDTO>();
		Conexion conexion = Conexion.getConexion();
		try  {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				personas.add(getPersonaDTO(resultSet));
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return personas;
	}
	
	
	
	private PersonaDTO getPersonaDTO(ResultSet r) throws SQLException {
		int id = r.getInt("idPersona");
		String nombre = r.getString("Nombre");
		String tel = r.getString("Telefono");
		
		PersonaDTO p = new PersonaDTO(id, nombre, tel);
		p.setEmail(r.getString("Email"));
		p.setCalle(r.getString("Calle"));
		p.setAltura(r.getString("Altura"));
		p.setPiso(r.getString("piso"));
		p.setdepto(r.getString("depto"));
		p.setLocalidad_id(r.getInt("localidad_id"));
		p.setCumpleanio(r.getString("cumpleanio"));
		p.setTipo_contacto_id(r.getInt("tipo_contacto_id"));
		p.setMascota_preferida(r.getString("mascota_preferida"));
		p.setPais(r.getString("pais"));
		p.setProvincia(r.getString("provincia"));
		p.setLocalidad(r.getString("localidad"));
		p.setTipo_contacto(TC.getTipoContacto(r.getInt("tipo_contacto_id")));
		return p;
	}
	
	
}

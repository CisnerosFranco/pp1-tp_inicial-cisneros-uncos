package modelo;

import java.util.List;
import dto.PersonaDTO;
import persistencia.dao.interfaz.DAOAbstractFactory;
import persistencia.dao.interfaz.PersonaDAO;


public class Agenda {
	
	private PersonaDAO persona;	
	
	public Agenda(DAOAbstractFactory metodo_persistencia){
		this.persona = metodo_persistencia.createPersonaDAO();
	}
	
	public void agregarPersona(PersonaDTO nuevaPersona){
		this.persona.insert(nuevaPersona);
	}

	public void borrarPersona(PersonaDTO persona_a_eliminar) {
		this.persona.delete(persona_a_eliminar);
	}
	
	public List<PersonaDTO> obtenerPersonas(){
		return this.persona.readAll();		
	}
	
	public void update(PersonaDTO P) {
		System.out.println("Llegamos");
		this.persona.update(P);
	}
	
}

// hacemos uso de la Clase Interfaz PersonaDAO, e implementamos sus 3 metodos.
// en estos 3 metodos hacemos uso de los metodos que contiene Persona que pertenece a la clase PersonaDAOSQL
// que es donde realmente se interactua con la DB.
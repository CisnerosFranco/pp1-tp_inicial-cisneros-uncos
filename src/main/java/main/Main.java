package main;

import modelo.Agenda;
import persistencia.conexion.Conexion;
import persistencia.dao.mysql.DAOSQLFactory;
import presentacion.controlador.Controlador;
import presentacion.vista.Vista;
import dto.Tipo_Contacto;
import dto.UbicacionDTO;


public class Main {

	public static void main(String[] args) {	
		//Vista vista = new Vista();
		//Agenda modelo = new Agenda(new DAOSQLFactory());
		Controlador controlador = new Controlador();
		//UbicacionDTO ubicacion = UbicacionDTO.constructor();
		controlador.inicializar();
		//System.out.println(Conexion.testConection("mysql", "root", "1234"));
		
	}
}



	










package main;

import modelo.Agenda;

import persistencia.dao.mysql.DAOSQLFactory;
import presentacion.controlador.Controlador;
import presentacion.vista.Vista;
import dto.UbicacionDTO;
import dto.Tipo_contactoDTO;


public class Main {

	public static void main(String[] args) {
		Vista vista = new Vista();
		Agenda modelo = new Agenda(new DAOSQLFactory());
		Controlador controlador = new Controlador(vista, modelo);
		UbicacionDTO ubicacion = UbicacionDTO.constructor();
		controlador.inicializar();
		
	}
}














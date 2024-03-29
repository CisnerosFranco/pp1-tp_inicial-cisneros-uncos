package persistencia.dao.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.PersonaDTO;
import persistencia.conexion.Conexion;

public class gestionUser {
	

	private static String createDB = "drop database if exists agenda;"
			+ "CREATE DATABASE `agenda`;"
			+ "USE agenda;"
			+ "CREATE TABLE PAIS ("
			+ "	id integer primary key,"
			+ "    pais text"
			+ ");"
			+ "CREATE TABLE PROVINCIA ("
			+ "	id integer primary key,"
			+ "    id_pais integer,"
			+ "    provincia text,"
			+ "    foreign key (id_pais) references pais(id)"
			+ ");"
			+ "create table localidad ("
			+ "	id integer primary key auto_increment,"
			+ "    id_provincia integer,"
			+ "    localidad text,"
			+ "    foreign key (id_provincia) references provincia(id)"
			+ ");"
			+ "create table tipo_contacto ("
			+ "	id integer primary key auto_increment,"
			+ "    tipo text"
			+ ");"
			+ "CREATE TABLE `personas` ("
			+ "  `idPersona` int(11) NOT NULL AUTO_INCREMENT,"
			+ "  `Nombre` varchar(45) NOT NULL,"
			+ "  `Telefono` varchar(20) NOT NULL,"
			+ "  tipo_contacto_id integer,"
			+ "  localidad_id integer,"
			+ "  calle text,"
			+ "  altura text,"
			+ "  piso text,"
			+ "  depto text,"
			+ "  email text,"
			+ "  cumpleanio text,"
			+ "  mascota_preferida text,"
			+ "  PRIMARY KEY (`idPersona`),"
			+ "  foreign key (localidad_id) references localidad(id),"
			+ "  foreign key (tipo_contacto_id) references tipo_contacto(id)"
			+ ");"
			+ "insert into pais values (100, 'Argentina');"
			+ "insert into provincia values (1, 100, 'Buenos Aires');"
			+ "insert into provincia values (2, 100, 'Cordoba');"
			+ "insert into provincia values (3, 100, 'Jujuy');"
			+ "insert into provincia values (4, 100, 'Tucuman');"
			+ "insert into localidad (id_provincia, localidad) values ( 1, 'Malvinas Argentinas');"
			+ "insert into localidad (id_provincia, localidad) values ( 1, 'Moreno');"
			+ "insert into localidad (id_provincia, localidad) values (1, 'San Miguel');"
			+ "insert into localidad (id_provincia, localidad) values (2, 'Carlos Paz');"
			+ "insert into localidad (id_provincia, localidad) values (2, 'Cordoba');"
			+ "insert into localidad (id_provincia, localidad) values (3, 'La QUIACA');"
			+ "insert into localidad (id_provincia, localidad) values (4, 'San Miguel de Tucuman');"
			+ "insert into tipo_contacto (tipo) values('Otros');"
			+ "insert into tipo_contacto (tipo) values('pap�');"
			+ "insert into tipo_contacto (tipo) values('mam�');"
			+ "insert into tipo_contacto (tipo) values('hermano/a');"
			+ "insert into tipo_contacto (tipo) values('hijo/a');"
			+ "insert into tipo_contacto (tipo) values('compa�ero/a de oficina');"
			+ "insert into tipo_contacto (tipo) values('comp. del gym');"
			+ "insert into tipo_contacto (tipo) values('conocido');";
	/*private static Connection connection;
	
	private void getConexion(String db, String user, String pass) {
		if(connection == null) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver"); // quitar si no es necesario
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + db, user, pass);
				connection.setAutoCommit(false);
			}
			catch(Exception e) {
				 //log.error("Conexion fallida", e);
			}
		}
	}
    */
	
	public static boolean CreateDBAgenda(String db, String user, String pass, Connection conexion) {
		PreparedStatement statement;
		try  {
			statement = conexion.prepareStatement(createDB);
			statement.executeQuery();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public static boolean CreateAgendaUser(String user, String pass, Connection conexion) {
		PreparedStatement statement;
		try  {
			statement = conexion.prepareStatement(
					"use mysql;"
					+ "delete from mysql.user where user="+user+";"
					+ "create user "+user+" identified by "+pass+";"
					+ "grant all privileges on agenda to "+user+" with grant option;"
					+ "grant update, select on mysql.user to "+user+" with grant option;"
					);
			 statement.executeQuery();	
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	
	
	
}

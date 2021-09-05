package persistencia.conexion;

import java.sql.Connection;
import persistencia.dao.mysql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import dto.PersonaDTO;

public class Conexion {
	
	public static Conexion instancia;
	private Connection connection;
	private Logger log = Logger.getLogger(Conexion.class);	
	private String mysqlDB = "mysql";
	private String rootUs = "root";
	private String rootPas = "1234";
	private static String userDB = "agenda";
	private static String userName = "user";
	private static String userPass = "1234";
	
/*
	private Conexion() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // quitar si no es necesario
			this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda","root","1234");
			this.connection.setAutoCommit(false);
			 log.info("Conexion exitosa");
		}
		catch(Exception e) {
			 log.error("Conexion fallida", e);
		}
	}*/
	
	
	
	private Conexion() {
		this.connection = initConnection("agenda", this.userName, this.userPass);
	} 
	
	public static boolean testConection(String user, String pass) {
		return initConnection(userDB, user, pass) == null ? false : true;
	}
	
	private static Connection initConnection(String db, String user, String pass) {
		Connection ret = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // quitar si no es necesario
			ret = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + db, user, pass);
			ret.setAutoCommit(false);
		}
		catch(Exception e) {
			 //log.error("Conexion fallida", e);
		}
		return ret;
	}
	
	
	
	public static Conexion getConexion() {								
		if(instancia == null) {
			instancia = new Conexion();
		}
		return instancia;
	}

	public Connection getSQLConexion() {
		return this.connection;
	}
	
	public void cerrarConexion() {
		try {
			this.connection.close();
			log.info("Conexion cerrada");
		}
		catch (SQLException e) 
		{
			log.error("Error al cerrar la conexión!", e);
		}
		instancia = null;
	}
	
	public static void setUserName(String user) {
		userName = user;
	}
	
	public static void setUserPass(String pass) {
		userPass = pass;
	}
}




package mof.mof;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Conexion {
	private static Connection con = null;
	private static Properties props = new Properties();
	private static Statement st;
	private static ResultSet rs;
	
	public static void conectar() {
		
		props.put("user", "ismael");
		props.put("password", "Perro20");
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://192.168.1.41:3306/mof", props);
			st = con.createStatement();
		} catch (SQLException e){
			System.out.println("Erro al conectar con la base de datos mof");
		}
	}
	
	public static Connection getCon() {
		return con;
	}



	public static void setCon(Connection con) {
		Conexion.con = con;
	}



	public static Properties getProps() {
		return props;
	}



	public static void setProps(Properties props) {
		Conexion.props = props;
	}



	public static Statement getSt() {
		return st;
	}



	public static void setSt(Statement st) {
		Conexion.st = st;
	}



	public static ResultSet getRs() {
		return rs;
	}



	public static void setRs(ResultSet rs) {
		Conexion.rs = rs;
	}
}

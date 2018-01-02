package mof.mof;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class Comentario {
	Scanner sc = new Scanner(System.in);
	/*private Statement st;
	private ResultSet rs;
	
	Connection con = null;
	Properties props = new Properties();
	Statement st;
	
	public void conectar(){
		props.put("user", "ismael");
		props.put("password", "Perro20");
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://192.168.1.41:3306/mof", props);
			st = con.createStatement();
		} catch (SQLException e){
			System.out.println("Erro al conectar con la base de datos mof");
		}
	}*/
	
	public void comentar(){
		conexion.conectar();
		
		try {
			conexion.getSt().execute("INSERT INTO comentarios ( idRest, idUsuario, comentairo ) VALUES (" + "idRest" + ", " + "idUsuario" + ", " + "comentario" + " )");
			
		/*	conexion.setRs(conexion.getSt().executeQuery("SHOW TABLES"));
			
			rs = st.executeQuery("SHOW TABLES");*/
			
		} catch (SQLException e){
			System.out.println("Erro al conectar con la base de datos mof");
		}
		try {
			while (conexion.getRs().next()) {
				System.out.println(conexion.getRs().getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
	public void valorar(){
		//conectar();
		
		/*try {
			st.execute("INSERT INTO comentarios ( valoracion ) VALUES (" + "valoracion" + " )");
		} catch (SQLException e){
			System.out.println("Erro al conectar con la base de datos mof");
		}*/
	}
	
	public void contestar(){
		
	}
	
	public void modificarComent(){
		
	}
	
	public void modificarValor(){
		
	}
	
	public void borrar(){
		
	}
	
}

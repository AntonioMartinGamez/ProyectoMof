package mof.mof;

import java.sql.SQLException;
import java.util.Scanner;

public class Restaurante {
	Scanner sc = new Scanner(System.in);
	
	
	
	private String nombre, email, descripcion, propietario, comida, url, localizacion, foto;
	private int fijo, movil, precMedio;
	
	
	//Metodo Registrar Restaurante
	public void registro(){
		
		Conexion.conectar();
		
		try {
			//Conexion.getSt().execute("INSERT INTO comentarios ( idRest, idUsuario, comentairo ) VALUES (" + "idRest" + ", " + "idUsuario" + ", " + "comentario" + " )");
			
			Conexion.setRs(Conexion.getSt().executeQuery("SHOW TABLES"));
			
			//rs = st.executeQuery("SHOW TABLES");
			
		} catch (SQLException e){
			System.out.println("Erro al conectar con la base de datos mof");
		}
		try {
			while (Conexion.getRs().next()) {
				System.out.println(Conexion.getRs().getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	//Metodo Modificar Restaurante
	public void modificar(){
		
		Conexion.conectar();
		
		try {
			//Conexion.getSt().execute("INSERT INTO comentarios ( idRest, idUsuario, comentairo ) VALUES (" + "idRest" + ", " + "idUsuario" + ", " + "comentario" + " )");
			
			Conexion.setRs(Conexion.getSt().executeQuery("SHOW TABLES"));
			
			//rs = st.executeQuery("SHOW TABLES");
			
		} catch (SQLException e){
			System.out.println("Erro al conectar con la base de datos mof");
		}
		try {
			while (Conexion.getRs().next()) {
				System.out.println(Conexion.getRs().getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	//Metodo Borrar Restaurante
	public void borrar(){
		
		Conexion.conectar();
		
		try {
			//Conexion.getSt().execute("INSERT INTO comentarios ( idRest, idUsuario, comentairo ) VALUES (" + "idRest" + ", " + "idUsuario" + ", " + "comentario" + " )");
			
			Conexion.setRs(Conexion.getSt().executeQuery("SHOW TABLES"));
			
			//rs = st.executeQuery("SHOW TABLES");
			
		} catch (SQLException e){
			System.out.println("Erro al conectar con la base de datos mof");
		}
		try {
			while (Conexion.getRs().next()) {
				System.out.println(Conexion.getRs().getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	//Metodo Mostrar Restaurantes (fotos, 10 ultimas valoraciones, etc)
	public void mostRest(){
		
		Conexion.conectar();
		
		try {
			//Conexion.getSt().execute("INSERT INTO comentarios ( idRest, idUsuario, comentairo ) VALUES (" + "idRest" + ", " + "idUsuario" + ", " + "comentario" + " )");
			
			Conexion.setRs(Conexion.getSt().executeQuery("SHOW TABLES"));
			
			//rs = st.executeQuery("SHOW TABLES");
			
		} catch (SQLException e){
			System.out.println("Erro al conectar con la base de datos mof");
		}
		try {
			while (Conexion.getRs().next()) {
				System.out.println(Conexion.getRs().getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	//Metodo Responder a un comentario
	public void responder(){
		
		Conexion.conectar();
		
		try {
			//Conexion.getSt().execute("INSERT INTO comentarios ( idRest, idUsuario, comentairo ) VALUES (" + "idRest" + ", " + "idUsuario" + ", " + "comentario" + " )");
			
			Conexion.setRs(Conexion.getSt().executeQuery("SHOW TABLES"));
			
			//rs = st.executeQuery("SHOW TABLES");
			
		} catch (SQLException e){
			System.out.println("Erro al conectar con la base de datos mof");
		}
		try {
			while (Conexion.getRs().next()) {
				System.out.println(Conexion.getRs().getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

package mof.mof;

import java.sql.SQLException;


public class Restaurante {
	
	
	private String nombre, email, descripcion, propietario, comida, url, localizacion, foto;
	private int fijo, movil, precMedio;
	
	
	//Metodo Registrar Restaurante
	public void registro() throws SQLException{
		
		Conexion.getSt().execute("INSERT INTO restaurante "
				+ "(nombre, fijo, movil, email, descripcion, propietario, comida, url, localizacion, precMedio, foto) "
				+ "VALUES ('" + nombre + "', '" + fijo + "', '" + movil + "', '"+ email + "', '" + descripcion + "', '" + propietario + "', '" + comida + "', '" + url + "', '" + localizacion + "', '" + precMedio + "', '" + foto + "')");
		
	}
	
	
	//Metodo Modificar Restaurante
	public void modificar(){
		
		/*Conexion.conectar();
		
		try {
		
			Conexion.setRs(Conexion.getSt().executeQuery("SHOW TABLES"));
			

			
		} catch (SQLException e){
			
			System.out.println("Erro al conectar con la base de datos mof");
			
		}
		try {
			
			while (Conexion.getRs().next()) {
				
				System.out.println(Conexion.getRs().getString(1));
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		Conexion.cerrar();
		*/
	}
	
	
	//Metodo Borrar Restaurante
	public void borrar(){
		
		/*Conexion.conectar();
		
		try {
		
			Conexion.setRs(Conexion.getSt().executeQuery("SHOW TABLES"));
			

			
		} catch (SQLException e){
			
			System.out.println("Erro al conectar con la base de datos mof");
			
		}
		try {
			
			while (Conexion.getRs().next()) {
				
				System.out.println(Conexion.getRs().getString(1));
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		Conexion.cerrar();
		*/
		
	}
	
	
	//Metodo Mostrar Restaurantes (fotos, 10 ultimas valoraciones, etc)
	public void mostRest(){
		
		/*Conexion.conectar();
		
		try {
		
			Conexion.setRs(Conexion.getSt().executeQuery("SHOW TABLES"));
			

			
		} catch (SQLException e){
			
			System.out.println("Erro al conectar con la base de datos mof");
			
		}
		try {
			
			while (Conexion.getRs().next()) {
				
				System.out.println(Conexion.getRs().getString(1));
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		Conexion.cerrar();
		*/
		
	}
	
	
	//Metodo Responder a un comentario
	public void responder(){
		
		/*Conexion.conectar();
		
		try {
		
			Conexion.setRs(Conexion.getSt().executeQuery("SHOW TABLES"));
			

			
		} catch (SQLException e){
			
			System.out.println("Erro al conectar con la base de datos mof");
			
		}
		try {
			
			while (Conexion.getRs().next()) {
				
				System.out.println(Conexion.getRs().getString(1));
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		Conexion.cerrar();
		*/
		
	}
}

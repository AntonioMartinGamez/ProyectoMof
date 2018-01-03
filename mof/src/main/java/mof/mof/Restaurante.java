package mof.mof;

import java.sql.ResultSet;
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
	public void modificar() throws SQLException{
		
	/*	ResultSet nombre = Conexion.getSt().executeQuery("Select nombre from usuario where nombreUsuario = '" + nombreUsuario + "'");
		ResultSet fijo = Conexion.getSt().executeQuery("Select fijo from usuario where nombreUsuario = '" + nombreUsuario + "'");
		ResultSet movil = Conexion.getSt().executeQuery("Select movil from usuario where nombreUsuario = '" + nombreUsuario + "'");
		ResultSet email = Conexion.getSt().executeQuery("Select email from usuario where nombreUsuario = '" + nombreUsuario + "'");
		ResultSet descripcion = Conexion.getSt().executeQuery("Select descripcion from usuario where nombreUsuario = '" + nombreUsuario + "'");
		ResultSet propietario = Conexion.getSt().executeQuery("Select sexo from usuario where nombreUsuario = '" + nombreUsuario + "'");
		ResultSet comida = Conexion.getSt().executeQuery("Select password from usuario where nombreUsuario = '" + nombreUsuario + "'");
		ResultSet url = Conexion.getSt().executeQuery("Select fechaNac from usuario where nombreUsuario = '" + nombreUsuario + "'");
		ResultSet localizacion = Conexion.getSt().executeQuery("Select comAuton from usuario where nombreUsuario = '" + nombreUsuario + "'");
		ResultSet precMedio = Conexion.getSt().executeQuery("Select provincia from usuario where nombreUsuario = '" + nombreUsuario + "'");
		ResultSet foto = Conexion.getSt().executeQuery("Select localidad from usuario where nombreUsuario = '" + nombreUsuario + "'");
		
				
		Conexion.getSt().execute("UPDATE SET "
				+ "nombre= '" + nom + "', apellidos = '" + app + "', telefono = '" + tlf + "', email = '" + eml + "' , edad = '" + ed + "', sexo = '" + sex + "', password =  '" + pas + "', fechaNac =  '" + fec + "', comAuton = '" + com + "', provincia = '" + pro + "', localidad = '" + loc + "', foto = '" + img + "' "
						+ "WHERE nombreUsuario =  '" + nombreUsuario + "'");
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

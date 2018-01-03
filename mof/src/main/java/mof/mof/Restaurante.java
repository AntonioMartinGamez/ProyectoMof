package mof.mof;

import java.sql.ResultSet;
import java.sql.SQLException;


public class Restaurante {
	
	
	private String idRest, nombre, email, descripcion, propietario, comida, url, localizacion, foto;
	private int fijo, movil, precMedio;
	
	
	//Metodo Registrar Restaurante
	public void registro() throws SQLException{
		
		Conexion.getSt().execute("INSERT INTO restaurante "
				+ "(nombre, fijo, movil, email, descripcion, propietario, comida, url, localizacion, precMedio, foto) "
				+ "VALUES ('" + nombre + "', '" + fijo + "', '" + movil + "', '"+ email + "', '" + descripcion + "', '" + propietario + "', '" + comida + "', '" + url + "', '" + localizacion + "', '" + precMedio + "', '" + foto + "')");
		
	}
	
	
	//Metodo Modificar Restaurante
	public void modificar() throws SQLException{
		
		ResultSet nombre = Conexion.getSt().executeQuery("Select nombre from restaurante where idRest = '" + idRest + "'");
		ResultSet fijo = Conexion.getSt().executeQuery("Select fijo from restaurante where idRest = '" + idRest + "'");
		ResultSet movil = Conexion.getSt().executeQuery("Select movil from restaurante where idRest = '" + idRest + "'");
		ResultSet email = Conexion.getSt().executeQuery("Select email from restaurante where idRest = '" + idRest + "'");
		ResultSet descripcion = Conexion.getSt().executeQuery("Select descripcion from restaurante where idRest = '" + idRest + "'");
		ResultSet propietario = Conexion.getSt().executeQuery("Select propietario from restaurante where idRest = '" + idRest + "'");
		ResultSet comida = Conexion.getSt().executeQuery("Select comida from restaurante where idRest = '" + idRest + "'");
		ResultSet url = Conexion.getSt().executeQuery("Select url from restaurante where idRest = '" + idRest + "'");
		ResultSet localizacion = Conexion.getSt().executeQuery("Select localizacion from restaurante where idRest = '" + idRest + "'");
		ResultSet precMedio = Conexion.getSt().executeQuery("Select precMedio from restaurante where idRest = '" + idRest + "'");
		ResultSet foto = Conexion.getSt().executeQuery("Select foto from restaurante where idRest = '" + idRest + "'");
		
				
		Conexion.getSt().execute("UPDATE SET "
				+ "nombre= '" + nombre + "', fijo = '" + fijo + "', movil = '" + movil + "', email = '" + email + "' , descripcion = '" + descripcion + "', propietario = '" + propietario + "', comida =  '" + comida + "', url =  '" + url + "', localizacion = '" + localizacion + "', precMedio = '" + precMedio + "', foto = '" + foto + "' "
						+ "WHERE idRest =  '" + idRest + "'");
						
	}
	
	
	//Metodo Borrar Restaurante
	public void borrar() throws SQLException{
		
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

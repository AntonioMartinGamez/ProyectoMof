package mof.mof;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;


public class Busqueda {
	
	
	
	public void buscar(){
		/* Por nombre
		 * localizacion
		 * valoracion
		 * comida
		 * servicios
		 * premios
		 */
	}
	
	/*Conexion.conectar();
	
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
	}*/
	
	public static ArrayList<Usuario> getUsuarios() {
		
			String sql      = "SELECT * FROM usuario ORDER BY edad ASC";
			 String nombreUsuario   = "";
			 String nombre = "";
			 String apellidos   = "";
			 int telefono     = 0;
			 String email     = "";
			 int edad     = 0;
			 String sexo = "";
			 String password = "";
			 LocalDate fechaNac = null;
			 Date fechaNacDate = null;
			 String comAuton = "";
			 String provincia = "";
			 String localidad = "";
			 String foto = "";
			 
			 ArrayList <Usuario> listausuarios = new ArrayList<Usuario>();
			 try {
				 Conexion.conectar();
				 Conexion.setRs(Conexion.getSt().executeQuery(sql));

		            while (Conexion.getRs().next()) {
			               
		            	nombreUsuario = Conexion.getRs().getString("nombreUsuario");
		            	nombre = Conexion.getRs().getString("nombre");
		            	apellidos = Conexion.getRs().getString("apellidos");
		            	telefono = Conexion.getRs().getInt("telefono");
		            	email = Conexion.getRs().getString("email");
		            	edad = Conexion.getRs().getInt("edad");
		            	sexo = Conexion.getRs().getString("sexo");
		            	fechaNacDate = Conexion.getRs().getDate("fechaNac");
		            	fechaNac = fechaNacDate.toLocalDate();
		            	comAuton = Conexion.getRs().getString("comAuton");
		            	provincia = Conexion.getRs().getString("provincia");
		            	localidad = Conexion.getRs().getString("localidad");
		            	foto = Conexion.getRs().getString("foto");  
		            	
		            	
			      		Usuario usuario = new Usuario(nombreUsuario, nombre, apellidos, email, password, comAuton, provincia, localidad, foto, sexo, telefono, edad, fechaNacDate);
			      		listausuarios.add(usuario);
		            }
			 	

					
		return listausuarios;
		 
		} catch (SQLException e) {
			System.out.println(e.getMessage());
       }finally {
    	   Conexion.cerrar();
       } 
			 }

	
	public void ordenar(){
		
	}
	
	public void filtar(){
		
	}
}

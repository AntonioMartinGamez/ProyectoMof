package mof.mof;

import java.sql.ResultSet;
import java.sql.SQLException;


public class Restaurante {
	
	
	private String idRest, nombre, email, descripcion, propietario, comida, url, localizacion, foto;
	private int fijo, movil, precMedio;
	
	
	//Metodo Registrar Restaurante
	public void registro() throws SQLException{
		
		Conexion.conectar();
		
		Conexion.getSt().execute("INSERT INTO restaurante "
				+ "(nombre, fijo, movil, email, descripcion, propietario, comida, url, localizacion, precMedio, foto) "
				+ "VALUES ('" + nombre + "', '" + fijo + "', '" + movil + "', '"+ email + "', '" + descripcion + "', '" + propietario + "', '" + comida + "', '" + url + "', '" + localizacion + "', '" + precMedio + "', '" + foto + "')");
		
		Conexion.cerrar();	
	}
	
	
	//Metodo Modificar Restaurante
	public void modificar() throws SQLException{
		
		Conexion.conectar();
		
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
				
		Conexion.cerrar();	
	}
	
	
	//Metodo Borrar Restaurante
	public void borrar() throws SQLException{
		
		Conexion.conectar();
		
		Conexion.getSt().execute("DELETE * FROM restaurante WHERE idRest = '" + idRest + "'");

		Conexion.cerrar();
		
	}
	
	
	//Metodo Mostrar Restaurantes (fotos, 10 ultimas valoraciones, etc)
	public void mostRest() throws SQLException{
		
		Conexion.conectar();

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
		
		Conexion.getSt().execute("SELECT "
				+ "nombre= '" + nombre + "', fijo = '" + fijo + "', movil = '" + movil + "', email = '" + email + "' , descripcion = '" + descripcion + "', propietario = '" + propietario + "', comida =  '" + comida + "', url =  '" + url + "', localizacion = '" + localizacion + "', precMedio = '" + precMedio + "', foto = '" + foto + "' "
						+ "WHERE idRest =  '" + idRest + "'");

		Conexion.cerrar();
		
		
	}
	
	
	//Metodo Responder a un comentario
	public void responder(){
		
		Comentario.contestar();
		
	}
}

package mof.mof;

import java.sql.ResultSet;
import java.sql.SQLException;


public class Restaurante {
	
	
	private String idRest, nombre, email, descripcion, propietario, comida, url, localizacion, foto;
	private int fijo, movil, precMedio;
	
	ResultSet consulta;
	
	
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
		
		
		consulta = Conexion.getSt().executeQuery("SELECT nombre, fijo, movil, email, descripcion, propietario, comida, url, localizacion, precMedio, foto FROM restaurante WHERE email = '" + email + "'");
		

		consulta.next();
				
		Conexion.getSt().execute("UPDATE SET "
				+ "nombre= '" + consulta.getString(1) + "', fijo = '" + consulta.getInt(2) + "', movil = '" + consulta.getInt(3) + "', email = '" + consulta.getString(4) + "' , descripcion = '" + consulta.getString(5) + "', propietario = '" + consulta.getString(6) + "', comida =  '" + consulta.getString(7) + "', url =  '" + consulta.getString(8) + "', localizacion = '" + consulta.getString(9) + "', precMedio = '" + consulta.getInt(10) + "', foto = '" + consulta.getString(11) + "' "
						+ "WHERE email =  '" + email + "'");
				
		Conexion.cerrar();	
	}
	
	
	//Metodo Borrar Restaurante
	public void borrar() throws SQLException{
		
		Conexion.conectar();
		
		Conexion.getSt().execute("DELETE * FROM restaurante WHERE email = '" + email + "'");

		Conexion.cerrar();
		
	}
	
	
	//Metodo Mostrar Restaurantes (fotos, 10 ultimos comentarios, media valoraciones, etc)
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
		
		ResultSet mediavalor = Conexion.getSt().executeQuery("SELECT AVG(comentarios.valoracion) from comentarios inner join restaurante on comentarios.idRest = restaurante.idRest; ");
		
		ResultSet ultcomen_usuario = Conexion.getSt().executeQuery("SELECT usuario.nombreUsuario from ((comentarios inner join restaurante on comentarios.idRest = restaurante.idRest) inner join usuario on comentarios.idUsuario = usuario.idUsuario) GROUP BY comentarios.fechaComent DESC LIMIT 10;");
		
		ResultSet ultcomen_comentario = Conexion.getSt().executeQuery("SELECT comentarios.comentario from ((comentarios inner join restaurante on comentarios.idRest = restaurante.idRest) inner join usuario on comentarios.idUsuario = usuario.idUsuario) GROUP BY comentarios.fechaComent DESC LIMIT 10;");
		
		Conexion.getSt().execute("SELECT "
				+ "nombre= '" + nombre + "', fijo = '" + fijo + "', movil = '" + movil + "', email = '" + email + "' , descripcion = '" + descripcion + "', propietario = '" + propietario + "', comida =  '" + comida + "', url =  '" + url + "', localizacion = '" + localizacion + "', precMedio = '" + precMedio + "', foto = '" + foto + "' "
						+ "WHERE email =  '" + email + "'");
		

		Conexion.cerrar();
		
		
	}
	
	
	//Metodo Responder a un comentario
	public void responder(){
		
		Comentario.contestar();
		
	}

	//Constructor
	public Restaurante(String nombre, String email, String descripcion, String propietario, String comida, String url,
			String localizacion, String foto, int fijo, int movil, int precMedio) {
		this.nombre = nombre;
		this.email = email;
		this.descripcion = descripcion;
		this.propietario = propietario;
		this.comida = comida;
		this.url = url;
		this.localizacion = localizacion;
		this.foto = foto;
		this.fijo = fijo;
		this.movil = movil;
		this.precMedio = precMedio;
	}


	public Restaurante() {
		
	}
	
}

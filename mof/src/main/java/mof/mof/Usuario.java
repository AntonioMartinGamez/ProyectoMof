package mof.mof;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;



public class Usuario {
	
	private String nombreUsuario = "usuarioChorra",nombre, apellidos, email, password, comAuton, provincia, localidad, foto, sexo;
	private int telefono, edad;
	LocalDate fechaNac;
	
	ResultSet consulta;
	
	public void registrar() throws SQLException {
		Conexion.conectar();
		
		Conexion.getSt().execute("INSERT INTO usuario (nombreUsuario, nombre, apellidos, telefono, email, edad, sexo, password, fechaNac, comAuton, provincia, localidad, foto) VALUES ('" + nombreUsuario + "', '" + nombre + "', '" + apellidos + "', '" + telefono + "', '" + email + "', '"+ edad + "', '" + sexo + "', '" + password + "', '" + fechaNac + "', '" + comAuton + "', '" + provincia + "', '" + localidad + "', '" + foto + "')");
	
		Conexion.cerrar();
		
	}






	public void modificar() throws SQLException {
		Conexion.conectar();
		
		consulta = Conexion.getSt().executeQuery("SELECT nombreUsuario, nombre, apellidos, telefono, email, edad, sexo, password, fechaNac, comAuton, provincia, localidad, foto FROM usuario WHERE nombreUsuario = '" + nombreUsuario + "'");
		consulta.next();
		
				
		Conexion.getSt().execute("UPDATE SET nombre= '" + consulta.getString(2) + "', apellidos = '" + consulta.getString(3) + "', telefono = '" + consulta.getInt(4) + "', email = '" + consulta.getString(5) + "' , edad = '" + consulta.getInt(6) + "', sexo = '" + consulta.getString(7) + "', password =  '" + consulta.getString(8) + "', fechaNac =  '" + consulta.getDate(9) + "', comAuton = '" + consulta.getString(10) + "', provincia = '" + consulta.getString(11) + "', localidad = '" + consulta.getString(12) + "', foto = '" + consulta.getString(13) + "' WHERE nombreUsuario =  '" + nombreUsuario + "'");
		
		Conexion.cerrar();
		
	}
	
	
	public Usuario() {
	
	}

	public Usuario(String nombreUsuario, String nombre, String apellidos, String email, String password,
			String comAuton, String provincia, String localidad, String foto, String sexo, int telefono, int edad,
			LocalDate fechaNac) {
	
		this.nombreUsuario = nombreUsuario;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.password = password;
		this.comAuton = comAuton;
		this.provincia = provincia;
		this.localidad = localidad;
		this.foto = foto;
		this.sexo = sexo;
		this.telefono = telefono;
		this.edad = edad;
		this.fechaNac = fechaNac;
	}






	public void borrar() throws SQLException{
		Conexion.conectar();
		
		Conexion.getSt().execute("DELETE * FROM usuario WHERE nombreUsuario = '" + nombreUsuario + "'");
		
		Conexion.cerrar();
	}
	
	public void comentar() throws SQLException{
		
		Comentario.comentar();
		
	}
	
	public void valorar(){
		
		Comentario.valorar();
		
	}
	
	public ResultSet mostUsuario() throws SQLException{
		Conexion.conectar();
		
		consulta = Conexion.getSt().executeQuery("SELECT nombreUsuario, nombre, apellidos, telefono, email, edad, sexo, password, fechaNac, comAuton, provincia, localidad, foto, (SELECT valoracion FROM comentarios INNER JOIN usuario ON usuario.idUsuario = comentarios.idUsuario LIMIT 0,10) AS comments FROM usuario WHERE nombreUsuario = '" + nombreUsuario + "'");

		return consulta ;

	}

}

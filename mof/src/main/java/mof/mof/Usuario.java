package mof.mof;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Properties;


public class Usuario {
	
	private String nombreUsuario, nombre, apellidos, email, password, comAuton, provincia, localidad, foto;
	private char sexo;
	private int telefono, edad;
	LocalDate fechaNac;
	

	
	public void registrar() throws SQLException {
		Conexion.getSt().execute("INSERT INTO usuario (nombreUsuario, nombre, apellidos, telefono, edad, sexo, password, fechaNac, comAuton, provincia, localidad, foto) VALUES ('" + nombreUsuario + "', '" + nombre + "', '" + apellidos + "', '" + telefono + "', '" + edad + "', '" + sexo + "', '" + password + "', '" + fechaNac + "', '" + comAuton + "', '" + provincia + "', '" + localidad + "', '" + foto + "')");
	}
	
	public void modificar() throws SQLException {
				
		ResultSet nom = Conexion.getSt().executeQuery("Select nombre from usuario where nombreUsuario = '" + nombreUsuario + "'");
		ResultSet app = Conexion.getSt().executeQuery("Select apellido from usuario where nombreUsuario = '" + nombreUsuario + "'");
		ResultSet tlf = Conexion.getSt().executeQuery("Select telefono from usuario where nombreUsuario = '" + nombreUsuario + "'");
		ResultSet ed = Conexion.getSt().executeQuery("Select edad from usuario where nombreUsuario = '" + nombreUsuario + "'");
		ResultSet sex = Conexion.getSt().executeQuery("Select sexo from usuario where nombreUsuario = '" + nombreUsuario + "'");
		ResultSet pas = Conexion.getSt().executeQuery("Select password from usuario where nombreUsuario = '" + nombreUsuario + "'");
		ResultSet fec = Conexion.getSt().executeQuery("Select fechaNac from usuario where nombreUsuario = '" + nombreUsuario + "'");
		ResultSet com = Conexion.getSt().executeQuery("Select comAuton from usuario where nombreUsuario = '" + nombreUsuario + "'");
		ResultSet pro = Conexion.getSt().executeQuery("Select provincia from usuario where nombreUsuario = '" + nombreUsuario + "'");
		ResultSet loc = Conexion.getSt().executeQuery("Select localidad from usuario where nombreUsuario = '" + nombreUsuario + "'");
		ResultSet img = Conexion.getSt().executeQuery("Select foto from usuario where nombreUsuario = '" + nombreUsuario + "'");
		
				
		Conexion.getSt().execute("UPDATE SET nombre= '" + nom + "', apellidos = '" + app + "', telefono = '" + tlf + "', edad = '" + ed + "', sexo = '" + sex + "', password =  '" + pas + "', fechaNac =  '" + fec + "', comAuton = '" + com + "', provincia = '" + pro + "', localidad = '" + loc + "', foto = '" + img + "' WHERE nombreUsuario =  '" + nombreUsuario + "'");
				
	}
	
	public void borrar() throws SQLException{
		Conexion.getSt().execute("DELETE * FROM usuario WHERE nombreUsuario = '" + nombreUsuario + "'");
	}
	
	public void comentar() throws SQLException{
		
	}
	
	public void valorar(){
		
	}
	
	public void mostUsuario() throws SQLException{
		Conexion.setRs(Conexion.getSt().executeQuery("SELECT nombreUsuario, nombre, apellidos, telefono, edad, sexo, password, fechaNac, comAuton, provincia, localidad, foto, (SELECT valoracion FROM comentarios INNER JOIN usuario ON usuario.idUsuario = comentarios.idUsuario LIMIT 0,10) AS comments FROM usuario WHERE nombreUsuario = '" + nombreUsuario + "'"));
	
	}
}

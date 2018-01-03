package mof.mof;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;



public class Usuario {
	
	private String nombreUsuario, nombre, apellidos, email, password, comAuton, provincia, localidad, foto, sexo;
	private int telefono, edad;
	LocalDate fechaNac;
	
	ResultSet nomUser;
	ResultSet nom;
	ResultSet app;
	ResultSet tlf;
	ResultSet eml;
	ResultSet ed;
	ResultSet sex;
	ResultSet pas;
	ResultSet fec;
	ResultSet com;
	ResultSet pro;
	ResultSet loc;
	ResultSet img;
	ResultSet comment;

	
	public void registrar() throws SQLException {
		Conexion.conectar();
		
		Conexion.getSt().execute("INSERT INTO usuario (nombreUsuario, nombre, apellidos, telefono, email, edad, sexo, password, fechaNac, comAuton, provincia, localidad, foto) VALUES ('" + nombreUsuario + "', '" + nombre + "', '" + apellidos + "', '" + telefono + "', '" + email + "', '"+ edad + "', '" + sexo + "', '" + password + "', '" + fechaNac + "', '" + comAuton + "', '" + provincia + "', '" + localidad + "', '" + foto + "')");
	
		Conexion.cerrar();
		
	}
	
	public void modificar() throws SQLException {
		Conexion.conectar();
		
		nom = Conexion.getSt().executeQuery("Select nombre from usuario where nombreUsuario = '" + nombreUsuario + "'");
		app = Conexion.getSt().executeQuery("Select apellido from usuario where nombreUsuario = '" + nombreUsuario + "'");
		tlf = Conexion.getSt().executeQuery("Select telefono from usuario where nombreUsuario = '" + nombreUsuario + "'");
		eml = Conexion.getSt().executeQuery("Select email from usuario where nombreUsuario = '" + nombreUsuario + "'");
		ed = Conexion.getSt().executeQuery("Select edad from usuario where nombreUsuario = '" + nombreUsuario + "'");
		sex = Conexion.getSt().executeQuery("Select sexo from usuario where nombreUsuario = '" + nombreUsuario + "'");
		pas = Conexion.getSt().executeQuery("Select password from usuario where nombreUsuario = '" + nombreUsuario + "'");
		fec = Conexion.getSt().executeQuery("Select fechaNac from usuario where nombreUsuario = '" + nombreUsuario + "'");
		com = Conexion.getSt().executeQuery("Select comAuton from usuario where nombreUsuario = '" + nombreUsuario + "'");
		pro = Conexion.getSt().executeQuery("Select provincia from usuario where nombreUsuario = '" + nombreUsuario + "'");
		loc = Conexion.getSt().executeQuery("Select localidad from usuario where nombreUsuario = '" + nombreUsuario + "'");
		img = Conexion.getSt().executeQuery("Select foto from usuario where nombreUsuario = '" + nombreUsuario + "'");
		
				
		Conexion.getSt().execute("UPDATE SET nombre= '" + nom + "', apellidos = '" + app + "', telefono = '" + tlf + "', email = '" + eml + "' , edad = '" + ed + "', sexo = '" + sex + "', password =  '" + pas + "', fechaNac =  '" + fec + "', comAuton = '" + com + "', provincia = '" + pro + "', localidad = '" + loc + "', foto = '" + img + "' WHERE nombreUsuario =  '" + nombreUsuario + "'");
		
		Conexion.cerrar();
		
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
	
	public void mostUsuario() throws SQLException{
		Conexion.conectar();
		
		nomUser = Conexion.getSt().executeQuery("Select nombre from usuario where nombreUsuario = '" + nombreUsuario + "'");
		nom = Conexion.getSt().executeQuery("Select nombre from usuario where nombreUsuario = '" + nombreUsuario + "'");
		app = Conexion.getSt().executeQuery("Select apellido from usuario where nombreUsuario = '" + nombreUsuario + "'");
		tlf = Conexion.getSt().executeQuery("Select telefono from usuario where nombreUsuario = '" + nombreUsuario + "'");
		eml = Conexion.getSt().executeQuery("Select email from usuario where nombreUsuario = '" + nombreUsuario + "'");
		ed = Conexion.getSt().executeQuery("Select edad from usuario where nombreUsuario = '" + nombreUsuario + "'");
		sex = Conexion.getSt().executeQuery("Select sexo from usuario where nombreUsuario = '" + nombreUsuario + "'");
		pas = Conexion.getSt().executeQuery("Select password from usuario where nombreUsuario = '" + nombreUsuario + "'");
		fec = Conexion.getSt().executeQuery("Select fechaNac from usuario where nombreUsuario = '" + nombreUsuario + "'");
		com = Conexion.getSt().executeQuery("Select comAuton from usuario where nombreUsuario = '" + nombreUsuario + "'");
		pro = Conexion.getSt().executeQuery("Select provincia from usuario where nombreUsuario = '" + nombreUsuario + "'");
		loc = Conexion.getSt().executeQuery("Select localidad from usuario where nombreUsuario = '" + nombreUsuario + "'");
		img = Conexion.getSt().executeQuery("Select foto from usuario where nombreUsuario = '" + nombreUsuario + "'");
		comment = Conexion.getSt().executeQuery("SELECT restaurante.nombre, comentarios.valoracion FROM usuario INNER JOIN comentarios ON comentarios.idUsuario = usuario.idUsuario INNER JOIN restaurante ON comentarios.idRest = restaurante.idRest WHERE nombreUsuario = '" + nombreUsuario + "' ORDER BY fechaValor DESC LIMIT 0,10" );
		
		//Conexion.setRs(Conexion.getSt().executeQuery("SELECT nombreUsuario, nombre, apellidos, telefono, email, edad, sexo, password, fechaNac, comAuton, provincia, localidad, foto, (SELECT valoracion FROM comentarios INNER JOIN usuario ON usuario.idUsuario = comentarios.idUsuario LIMIT 0,10) AS comments FROM usuario WHERE nombreUsuario = '" + nombreUsuario + "'"));
		Conexion.cerrar();
		
	}

}

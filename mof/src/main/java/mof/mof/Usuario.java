package mof.mof;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;



public class Usuario {
	
	private String nombreUsuario,nombre, apellidos, email, password, comAuton, provincia, localidad, foto, sexo;
	private int telefono, edad;
	Date fechaNac;
	
	ResultSet consulta;
	
	public Usuario() {
		
	}

	public Usuario(String nombreUsuario, String nombre, String apellidos, String email, String password,
			String comAuton, String provincia, String localidad, String foto, String sexo, int telefono, int edad,
			Date fechaNac) {
	
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
	
	public void registrar(String nombreUsuario, String nombre, String apellidos, int telefono, String email, int edad, String sexo, String password, Date fechaNac, String comAuton, String provincia, String localidad, String foto) throws SQLException {
		Conexion.conectar();
		
		Conexion.getSt().execute("INSERT INTO usuario (nombreUsuario, nombre, apellidos, telefono, email, edad, sexo, password, fechaNac, comAuton, provincia, localidad, foto) VALUES ('" + nombreUsuario + "', '" + nombre + "', '" + apellidos + "', '" + telefono + "', '" + email + "', '"+ edad + "', '" + sexo + "', '" + password + "', '" + fechaNac + "', '" + comAuton + "', '" + provincia + "', '" + localidad + "', '" + foto + "')");
	
		Conexion.cerrar();
		
	}

	public void modificar() throws SQLException {
		Conexion.conectar();
		
		consulta = Conexion.getSt().executeQuery("SELECT nombreUsuario, nombre, apellidos, telefono, email, edad, sexo, password, fechaNac, comAuton, provincia, localidad, foto FROM usuario WHERE nombreUsuario = '" + nombreUsuario + "'");
		consulta.next();
		
		nombre = consulta.getString(2);
		apellidos = consulta.getString(3);
		telefono = consulta.getInt(4);
		email = consulta.getString(5);
		edad = consulta.getInt(6);
		sexo = consulta.getString(7);
		password = consulta.getString(8);
		fechaNac = consulta.getDate(9);
		comAuton = consulta.getString(10);
		provincia = consulta.getString(11);
		localidad = consulta.getString(12);
		foto = consulta.getString(13);
		
		Conexion.getSt().execute("UPDATE SET nombre= '" + nombre + "', apellidos = '" + apellidos + "', telefono = '" + telefono + "', email = '" + email + "' , edad = '" + edad + "', sexo = '" + sexo + "', password =  '" + password + "', fechaNac =  '" + fechaNac + "', comAuton = '" + comAuton + "', provincia = '" + provincia + "', localidad = '" + localidad + "', foto = '" + foto + "' WHERE nombreUsuario =  '" + nombreUsuario + "'");
		
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
	
	public ResultSet mostUsuario(String userName) throws SQLException{
		Conexion.conectar();
		
		consulta = Conexion.getSt().executeQuery("SELECT nombreUsuario, nombre, apellidos, telefono, email, edad, sexo, password, fechaNac, comAuton, provincia, localidad, foto, (SELECT valoracion FROM comentarios INNER JOIN usuario ON usuario.idUsuario = comentarios.idUsuario LIMIT 0,10) AS comments FROM usuario WHERE nombreUsuario = '" + userName + "'");

		return consulta ;

	}

	public static boolean login(String nombreUsuario, String pass){
		String sql = "SELECT password FROM usuario WHERE nombreUsuario = '" + nombreUsuario + "'";
		boolean login_correcto = false;
		String password = "";
		
		
		/*    Connection conn = bd.getConnection();
	          Statement stmt  = conn.createStatement();
			  PreparedStatement pstmt = conn.prepareStatement(sql)*/
		
		 try{
			 Conexion.conectar();
			 Conexion.setRs(Conexion.getSt().executeQuery(sql));
			 	 Conexion.getRs().next();
				 password = Conexion.getRs().getString("password");
				 if(pass.equals(password)){
					 login_correcto = true;
			 }
			 
		 } catch (SQLException e) {
			 
		 } finally {
			// Conexion.cerrar();	        }
		return login_correcto;
	}
	}
	

}

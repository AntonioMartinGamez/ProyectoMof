package mof.mof;

import java.sql.ResultSet;
import java.sql.SQLException;


public class Restaurante {
	
	
	private String nombre, email, emailN, descripcion, propietario, comida, url, localizacion, foto;
	private int fijo, movil, precMedio;
	
	ResultSet consulta;
	
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
	
	//Metodo Registrar Restaurante
	public void registro(String nombre, int fijo, int movil, String email, String descripcion, String propietario, String comida, String url, String localizacion, int precMedio, String foto) throws SQLException{
		
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

		nombre = consulta.getString(1);
		fijo = consulta.getInt(2);
		movil = consulta.getInt(3);
		emailN = consulta.getString(4);
		descripcion = consulta.getString(5);
		propietario = consulta.getString(6);
		comida = consulta.getString(7);
		url = consulta.getString(8);
		localizacion = consulta.getString(9);
		precMedio = consulta.getInt(10);
		foto = consulta.getString(11);
		
		Conexion.getSt().execute("UPDATE SET "
				+ "nombre= '" + nombre + "', fijo = '" + fijo + "', movil = '" + movil + "', email = '" + emailN + "' , descripcion = '" + descripcion + "', propietario = '" + propietario + "', comida =  '" + comida + "', url =  '" + url + "', localizacion = '" + localizacion + "', precMedio = '" + precMedio + "', foto = '" + foto + "' "
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
	public ResultSet mostRest(String eRest) throws SQLException{
		
		
		Conexion.conectar();
		
		consulta = Conexion.getSt().executeQuery("SELECT nombre, fijo, movil, email, descripcion, propietario, comida, url, localizacion, precMedio, foto, (SELECT AVG(comentarios.valoracion) from comentarios inner join restaurante on comentarios.idRest = restaurante.idRest) as MedValor, (SELECT usuario.nombreUsuario from ((comentarios inner join restaurante on comentarios.idRest = restaurante.idRest) inner join usuario on comentarios.idUsuario = usuario.idUsuario) GROUP BY comentarios.fechaComent DESC LIMIT 10) as Users, (SELECT comentarios.comentario from ((comentarios inner join restaurante on comentarios.idRest = restaurante.idRest) inner join usuario on comentarios.idUsuario = usuario.idUsuario) GROUP BY comentarios.fechaComent DESC LIMIT 10) as Comentario FROM restaurante WHERE email = '" + eRest + "'");		

		return consulta;
		
	}
	
	
	//Metodo Responder a un comentario
	public void responder(){
		
		Comentario.contestar();
		
	}
	
	public static boolean login(String emailRestaurante, String pass){
		String sql = "SELECT password FROM restaurante WHERE email = '" + emailRestaurante + "'";
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
			 
		 }
		return login_correcto;
	}
	}
	


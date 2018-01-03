package mof.mof;

import java.sql.SQLException;
import java.util.Scanner;

public class Comentario {
	Scanner sc = new Scanner(System.in);
	
	public void comentar(){
		Conexion.conectar();
		
		try {
			Conexion.getSt().execute("INSERT INTO comentarios ( idRest, idUsuario, idComentario, comentairo ) VALUES (" + "idRest" + ", " + "idUsuario" + ", " + "idComentario" + ", " + "comentario" + " )");
		} catch (SQLException e){
			System.out.println("Error al insertar el comentario");
		}
		
		Conexion.cerrar();

	}
	
	public void valorar(){
		Conexion.conectar();
		
		try {
			Conexion.setRs(Conexion.getSt().executeQuery("SELECT idComentario FROM comentarios WHERE comentario = " + "comentario"));
			Conexion.getSt().execute("UPDATE comentarios SET valoracion = " + "valoracion" + " WHERE idComentario = " + "idComentario");
		} catch (SQLException e){
			System.out.println("Error al valorar");
		}
		
		Conexion.cerrar();
	}
	
	public void contestar(){
		Conexion.conectar();
		
		try {
			Conexion.setRs(Conexion.getSt().executeQuery("SELECT idComentario FROM comentarios WHERE comentario = " + "comentario"));
			Conexion.getSt().execute("INSERT INTO respuesta ( idComentario, texto ) VALUES (" + "idComentario" + ", " + "texto" + " )");
		} catch (SQLException e){
			System.out.println("Error al contestar");
		}
		
		Conexion.cerrar();
	}
	
	public void modificarComent(){
		Conexion.conectar();
		
		try {
			Conexion.setRs(Conexion.getSt().executeQuery("SELECT idComentario FROM comentarios WHERE comentario = " + "comentario"));
			Conexion.getSt().execute("UPDATE comentarios SET comentario = " + "comentario" + " WHERE idComentario = " + "idComentario");
		} catch (SQLException e){
			System.out.println("Error al modificar el comentario");
		}
		
		
		
		Conexion.cerrar();
	}
	
	public void modificarValor(){
		Conexion.conectar();
		
		try {
			Conexion.setRs(Conexion.getSt().executeQuery("SELECT idComentario FROM comentarios WHERE comentario = " + "comentario"));
			Conexion.getSt().execute("UPDATE comentarios SET valoracion = " + "valoracion" + " WHERE idComentario = " + "idComentario");
		} catch (SQLException e){
			System.out.println("Error al modificar la valoracion");
		}
		
		Conexion.cerrar();
	}
	
	public void borrar(){
		Conexion.conectar();
		
		try {
			Conexion.setRs(Conexion.getSt().executeQuery("SELECT idComentario FROM comentarios WHERE comentario = " + "comentario"));
			Conexion.getSt().execute("DELETE * FROM comentarios WHERE idComentario = " + "idComentario");
		} catch (SQLException e){
			System.out.println("Error al borrar todo");
		}
		
		Conexion.cerrar();
	}
	
	public void borrarComentario(){
		Conexion.conectar();
		
		try {
			Conexion.setRs(Conexion.getSt().executeQuery("SELECT idComentario FROM comentarios WHERE comentario = " + "comentario"));
			Conexion.getSt().execute("DELETE comentario FROM comentarios WHERE idComentario = " + "idComentario");
		} catch (SQLException e){
			System.out.println("Error al borrar el comentario");
		}
		
		Conexion.cerrar();
	}
	
	public void borrarValoracion(){
		Conexion.conectar();
		
		try {
			Conexion.setRs(Conexion.getSt().executeQuery("SELECT idComentario FROM comentarios WHERE comentario = " + "comentario"));
			Conexion.getSt().execute("DELETE valoracion FROM comentarios WHERE idComentario = " + "idComentario");
		} catch (SQLException e){
			System.out.println("Error al borrar la valoracion");
		}
		
		Conexion.cerrar();
	}
	
}

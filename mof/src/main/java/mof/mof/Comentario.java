package mof.mof;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class Comentario {
	Scanner sc = new Scanner(System.in);
	static LocalDate ahora = LocalDate.now();
	
	public static void comentar(){
		Conexion.conectar();
		try {
			Conexion.getSt().execute("INSERT INTO comentarios ( idRest, idUsuario, idComentario, comentairo, fechaComent ) VALUES (" + "idRest" + ", " + "idUsuario" + ", " + "idComentario" + ", " + "comentario" + ", " + ahora + " )");
		} catch (SQLException e){
			System.out.println("Error al insertar el comentario");
		}
		
		Conexion.cerrar();

	}
	
	public static void valorar(){
		Conexion.conectar();
		
		try {
			Conexion.setRs(Conexion.getSt().executeQuery("SELECT idComentario FROM comentarios WHERE comentario = " + "comentario"));
			Conexion.getSt().execute("UPDATE comentarios SET valoracion = " + "valoracion" + ", fechaValor = " + ahora + " WHERE idComentario = " + Conexion.getRs().getString(1));
		} catch (SQLException e){
			System.out.println("Error al valorar");
		}
		
		Conexion.cerrar();
	}
	
	public static void contestar(){
		Conexion.conectar();
		
		try {
			Conexion.setRs(Conexion.getSt().executeQuery("SELECT idComentario FROM comentarios WHERE comentario = " + "comentario"));
			Conexion.getSt().execute("INSERT INTO respuesta ( idComentario, texto, fechaRespuesta ) VALUES (" + Conexion.getRs().getString(1) + ", " + "texto" + ", " + ahora + " )");
		} catch (SQLException e){
			System.out.println("Error al contestar");
		}
		
		Conexion.cerrar();
	}
	
	public static void modificarComent(){
		Conexion.conectar();
		
		try {
			Conexion.setRs(Conexion.getSt().executeQuery("SELECT idComentario FROM comentarios WHERE comentario = " + "comentario"));
			Conexion.getSt().execute("UPDATE comentarios SET comentario = " + "comentario" + ", fechaComent = " + ahora + " WHERE idComentario = " + Conexion.getRs().getString(1));
		} catch (SQLException e){
			System.out.println("Error al modificar el comentario");
		}
		
		Conexion.cerrar();
	}
	
	public static void modificarValor(){
		Conexion.conectar();
		
		try {
			Conexion.setRs(Conexion.getSt().executeQuery("SELECT idComentario FROM comentarios WHERE comentario = " + "comentario"));
			Conexion.getSt().execute("UPDATE comentarios SET valoracion = " + "valoracion" + ", fechaValor = " + ahora + "  WHERE idComentario = " + Conexion.getRs().getString(1));
		} catch (SQLException e){
			System.out.println("Error al modificar la valoracion");
		}
		
		Conexion.cerrar();
	}
	
	public static void modificarRespuesta(){
		Conexion.conectar();
		
		try {
			Conexion.setRs(Conexion.getSt().executeQuery("SELECT idComentario FROM comentarios WHERE comentario = " + "comentario"));
			Conexion.getSt().execute("UPDATE comentarios SET texto = " + "texto" + ", fechaRespuesta = " + ahora + "  WHERE idComentario = " + Conexion.getRs().getString(1));
		} catch (SQLException e){
			System.out.println("Error al modificar la respuesta");
		}
		
		Conexion.cerrar();
	}
	
	public static void borrar(){
		Conexion.conectar();
		
		try {
			Conexion.setRs(Conexion.getSt().executeQuery("SELECT idComentario FROM comentarios WHERE comentario = " + "comentario"));
			Conexion.getSt().execute("DELETE * FROM comentarios WHERE idComentario = " + Conexion.getRs().getString(1));
		} catch (SQLException e){
			System.out.println("Error al borrar todo");
		}
		
		Conexion.cerrar();
	}
	
	public static void borrarComentario(){
		Conexion.conectar();
		
		try {
			Conexion.setRs(Conexion.getSt().executeQuery("SELECT idComentario FROM comentarios WHERE comentario = " + "comentario"));
			Conexion.getSt().execute("DELETE comentario FROM comentarios WHERE idComentario = " + Conexion.getRs().getString(1));
		} catch (SQLException e){
			System.out.println("Error al borrar el comentario");
		}
		
		Conexion.cerrar();
	}
	
	public static void borrarValoracion(){
		Conexion.conectar();
		
		try {
			Conexion.setRs(Conexion.getSt().executeQuery("SELECT idComentario FROM comentarios WHERE comentario = " + "comentario"));
			Conexion.getSt().execute("DELETE valoracion FROM comentarios WHERE idComentario = " + Conexion.getRs().getString(1));
		} catch (SQLException e){
			System.out.println("Error al borrar la valoracion");
		}
		
		Conexion.cerrar();
	}
	
	public static void borrarRespuesta(){
		Conexion.conectar();
		
		try {
			Conexion.setRs(Conexion.getSt().executeQuery("SELECT idComentario FROM respuesta WHERE texto = " + "texto"));
			Conexion.getSt().execute("DELETE * FROM respuesta WHERE idComentario = " + Conexion.getRs().getString(1));
		} catch (SQLException e){
			System.out.println("Error al borrar la respuesta");
		}
		
		Conexion.cerrar();
	}
	
}

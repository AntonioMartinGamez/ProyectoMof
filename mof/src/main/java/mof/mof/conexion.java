package mof.mof;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class prueba {

	public static void main(String[] args) {
		
		Connection con = null;
		// Usamos un objeto de properties para pasar
		// de una manera m�s c�moda el user, password
		Properties props = new Properties();		
		props.put("user", "pablo");
		props.put("password", "Perro20");
		
		try {
			// Si trabajaramos con JDBC < 4.0 tendr�amos que indicar esta l�nea
			// para indicar el tipo de driver que tiene que cargar DriverManager.
			// Class.forName("com.mysql.jdbc.Driver");
			
			// Obtenemos la conexi�n a partir de la URL jdbc correspondiente
			con = DriverManager.getConnection("jdbc:mysql://192.168.1.41:3306/", props);
			
			// Estas pr�ximas l�neas las trabajaremos ampliamente 
			// en el siguiente cap�tulo
			
			// Creamos el objeto para enviar sentencias 
			Statement st = con.createStatement();
			// Enviamos una sentencia especial, para listar
			// las tablas disponibles en la base de datos
			// Almacenamos el resultado para recorrerlo despu�s
			Scanner sc = new Scanner(System.in);
			System.out.println("Introduce el nombre de la base de datos a crear o exit para salir");
			String nBsql = sc.nextLine();
			ResultSet rs;
			//st.executeQuery("CREATE DATABASE " +  nBsql);
			if(nBsql.equals("exit")){
				System.out.println("Bases de datos existentes");
				rs = st.executeQuery("SHOW DATABASES");
				boolean hayFilas = false;
				while(rs.next()) {
					hayFilas = true;
					System.out.println(rs.getString(1));
				}
				if (!hayFilas) {
					System.out.println("No hay resultados que mostrar");
				}
			}else{
				st.execute("CREATE DATABASE " +  nBsql);
				System.out.println("Bases de datos existentes");
				rs = st.executeQuery("SHOW DATABASES");
				boolean hayFilas = false;
				while(rs.next()) {
					hayFilas = true;
					System.out.println(rs.getString(1));
				}
				if (!hayFilas) {
					System.out.println("No hay resultados que mostrar");
				}
			}
			/*
			System.out.println("Seleciona una base de datos a modificar");
			String BD = sc.next();
			String BDT = "USE " + BD;
			st.execute(BDT);
			System.out.println("**************");
			System.out.println("Tablas de " + BD);
			System.out.println("**************");
			rs = st.executeQuery("SHOW TABLES");
			
			
			System.out.println("modificar o borrar tablas");
			String select = sc.next();
			switch(select){
			default:
				System.out.println("Error");
				break;
			case "borrar":
				System.out.println("Nombre de la tabla a borrar");
				String DBD = sc.nextLine();
				st.execute("DROP TABLE " +  DBD);
				break;
			case "modificar":
				System.out.println("Nombre de la tabla a modificar");
				String tableN = sc.next();
				System.out.println("Tipo varchar o int, exit para continuar");
				String var = sc.next();
				if ( var.equals("varchar")){
					System.out.println("Nombre de las columnas a crear");
					String CCBD = sc.next();
					String asd = "ALTER TABLE " + tableN + " ADD COLUMN " + CCBD + " VARCHAR(10)";
					st.execute(asd);
					rs = st.executeQuery("SHOW TABLES");
				}else if( var.equals("int")){
					System.out.println("Nombre de las columnas a crear");
					String CCBD = sc.next();
					st.execute("ALTER TABLE " + tableN + " ADD COLUMN " + CCBD + " int(10)");
					rs = st.executeQuery("SHOW TABLES");
				}else {
					rs = st.executeQuery("SHOW TABLES");
				}
				break;
			case "a�adir":
				String tem = "empleado";
				System.out.println("Apellido del empleado");
				String ape = sc.next();
				System.out.println("Direccion del empleado");
				String dir = sc.next();
				System.out.println("DNI del empleado");
				String dni = sc.next();
				System.out.println("Nombre del empleado");
				String nom = sc.next();
				System.out.println("Telefono del empleado");
				int tlf = Integer.parseInt(sc.next());
				st.execute("INSERT INTO " + tem + " (DNI, NOMBRE, Apellido, Direccion, Telefono) VALUES ('" + dni + "', '" + nom + "', '" + ape + "', '" + dir + "', '" + tlf + "')");
				break;
			};
*/
			//System.out.println("Bases de datos existentes");
			//ResultSet rs = st.executeQuery("SHOW DATABASES");

			// De esta forma vamos a saber si hay tablas o no
			/*boolean hayFilas = false;
			while(rs.next()) {
				hayFilas = true;
				System.out.println(rs.getString(1));
			}
			if (!hayFilas) {
				System.out.println("No hay resultados que mostrar");
			}*/
			
			//Cerramos ResultSet y Statement
			sc.close();
			rs.close();
			st.close();
			
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {					
					e.printStackTrace();
				}
		}
	
		
		

	}

}
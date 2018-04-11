package daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public abstract class GenericDAO {

	protected Connection miConnection = null;

	
	static {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			System.out.println("no encuentro el driver-libreria de mysql");

		}

	}

	protected void conectar() {
		try {
			miConnection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/proyecto_web", "root",
					"jeveris");
		} catch (SQLException e) {
			System.out.println("no pude conectarme a la base de datos");
			System.out.println("comprobar ruta de la base de datos");
			System.out.println("comprobar nombre de usuario y contraseña");
		}

	}

	protected void desconectar() {

		try {
			miConnection.close();
		} catch (SQLException e) {
			System.out.println("no pude realizar la desconexion");
		}

	}
}

package org.lapaloma.aadd.mapamundi.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GestorConexionSGDB {

	public static Connection getConexionSGDB(){
		Connection conexionSGDB = null;

		// Datos URL
		String servidorHost = GestorFicheroConfiguracion.getValorConfiguracion("servidor.sgdb");
		String puerto = GestorFicheroConfiguracion.getValorConfiguracion("puerto.sgdb");
		String nombreBBDD =GestorFicheroConfiguracion.getValorConfiguracion("nombre.bbdd");
		String urlBBDD = "jdbc:mysql://" + servidorHost + ":" + puerto + "/" + nombreBBDD;

		String usuario = GestorFicheroConfiguracion.getValorConfiguracion("usuario.sgdb");
		String contrasenya =GestorFicheroConfiguracion.getValorConfiguracion("clave.sgdb");

		try {
			String claseDriver= GestorFicheroConfiguracion.getValorConfiguracion("driver.sgdb");
			Class.forName(claseDriver);

			conexionSGDB = DriverManager.getConnection(urlBBDD, usuario, contrasenya);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return conexionSGDB;
	}

}

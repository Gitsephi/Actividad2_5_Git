package org.lapaloma.aadd.mapamundi.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GestorFicheroConfiguracion {
	private static Properties propiedadesConfiguracion;
	public static String getValorConfiguracion(String clave){
		String valor = null;
		// La primera vez carga el fichero de configuración en el objeto Properties
		if (propiedadesConfiguracion==null) {
			propiedadesConfiguracion= new Properties();
			
			File fichero = new File("./conf/conf.properties");
			BufferedInputStream bis = null;
			try {
				FileInputStream streamEntrada= new FileInputStream(fichero);
				bis= new BufferedInputStream(streamEntrada);
				propiedadesConfiguracion.load(bis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if(bis!=null){
					try {
						bis.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		// Se trabaja con el objeto properties
		valor=propiedadesConfiguracion.getProperty(clave);
		
		return valor; 
	}

}

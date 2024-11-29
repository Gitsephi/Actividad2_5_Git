package org.lapaloma.aadd.mapamundi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.lapaloma.aadd.mapamundi.dao.IOrganismoDAO;
import org.lapaloma.aadd.mapamundi.dao.impl.OrganismoDaoJDBC;
import org.lapaloma.aadd.mapamundi.util.GestorFicheroConfiguracion;
import org.lapaloma.aadd.mapamundi.vo.Organismo;
//bUENAS Dias
 public class AppPrincipal {
	 
	public static void main(String[] args) {
		AppPrincipal app = new AppPrincipal();
		app.gestorCsv();

	}
	
	private void gestorCsv() {
		String rutaCsv = GestorFicheroConfiguracion.getValorConfiguracion("rutaCsv");
		File f = new File(rutaCsv);
		try {
			BufferedReader br = new BufferedReader(new FileReader(f));
			String linea="";
			int cont=0;
			IOrganismoDAO dao=new OrganismoDaoJDBC();
			while((linea=br.readLine())!=null) {
				cont ++;
				if(cont>1) {
					String[] campos = linea.split("\\|");
	                String operacion = campos[0];
	                String codigo = campos[1];
	                String nombre = campos[2];
	                int añoCreacion = Integer.parseInt(campos[3]);
	                String sede = campos[4];
	                String url = campos[5];

	                Organismo organismo = new Organismo(codigo, nombre, añoCreacion, sede, url);

	                switch (operacion) {
	                    case "I":
	                        if (!dao.existeRegistro(codigo)) {
	                            dao.insertarOrganismo(organismo);
	                            System.out.println("Organismo insertado: " + nombre);
	                        } else {
	                            System.out.println("El organismo ya existe: " + nombre);
	                        }
	                        break;
	                    case "A":
	                        dao.actualizarOrganismo(organismo);
	                        System.out.println("Organismo actualizado: " + nombre);
	                        break;
	                    case "B":
	                        if (dao.existeRegistro(codigo)) {
	                            dao.borrarOrganismo(codigo);
	                            System.out.println("Organismo borrado: " + nombre);
	                        } else {
	                            System.out.println("No se encontró el organismo para borrarlo: " + nombre);
	                        }
	                        break;
	                    case "-":
	                        System.out.println("No se hará nada");
	                        break;
	                    default:
	                        System.out.println("La operacion no es correcta");
	                        break;
	                }
				}
				
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
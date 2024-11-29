/**
 * 
 */
package org.lapaloma.aadd.mapamundi.dao;

import java.util.List;

import org.lapaloma.aadd.mapamundi.vo.Organismo;
//HOLA

public interface IOrganismoDAO {
	
	public void insertarOrganismo(Organismo organismo);

	public void actualizarOrganismo(Organismo organismo);

	public void borrarOrganismo(String codigo);
	
	public boolean existeRegistro(String codigo);
}

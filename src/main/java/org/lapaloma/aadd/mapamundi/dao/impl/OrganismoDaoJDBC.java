/**
 * 
 */
package org.lapaloma.aadd.mapamundi.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.lapaloma.aadd.mapamundi.dao.IOrganismoDAO;
import org.lapaloma.aadd.mapamundi.util.GestorConexionSGDB;
import org.lapaloma.aadd.mapamundi.vo.Organismo;

public class OrganismoDaoJDBC implements IOrganismoDAO {
	private Connection conexionJDBC = null;

	@Override
	public boolean existeRegistro(String codigo) {
		conexionJDBC = GestorConexionSGDB.getConexionSGDB();
		String consulta = "SELECT 1 FROM T_ORGANISMO WHERE codigo_organismo = ?";
		try (Connection conexion = GestorConexionSGDB.getConexionSGDB();
				PreparedStatement ps = conexion.prepareStatement(consulta)) {
			ps.setString(1, codigo);
			ResultSet rs = ps.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void insertarOrganismo(Organismo organismo) {
		conexionJDBC = GestorConexionSGDB.getConexionSGDB();
		String sentencia = "INSERT INTO T_ORGANISMO (codigo_organismo, nombre, anyo_creacion, sede, url) VALUES (?, ?, ?, ?, ?)";
		try (Connection conexion = GestorConexionSGDB.getConexionSGDB();
				PreparedStatement ps = conexion.prepareStatement(sentencia)) {
			ps.setString(1, organismo.getCodigoOrganismo());
			ps.setString(2, organismo.getNombre());
			ps.setInt(3, organismo.getaCreacion());
			ps.setString(4, organismo.getSede());
			ps.setString(5, organismo.getUrl());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actualizarOrganismo(Organismo organismo) {
		conexionJDBC = GestorConexionSGDB.getConexionSGDB();
		String sentencia = "UPDATE T_ORGANISMO SET nombre = ?, anyo_creacion = ?, sede = ?, url = ? WHERE codigo_organismo = ?";
		try (Connection conexion = GestorConexionSGDB.getConexionSGDB();
				PreparedStatement ps = conexion.prepareStatement(sentencia)) {
			ps.setString(1, organismo.getNombre());
			ps.setInt(2, organismo.getaCreacion());
			ps.setString(3, organismo.getSede());
			ps.setString(4, organismo.getUrl());
			ps.setString(5, organismo.getCodigoOrganismo());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void borrarOrganismo(String codigo) {
		conexionJDBC = GestorConexionSGDB.getConexionSGDB();
		String sentencia = "DELETE FROM T_ORGANISMO WHERE codigo_organismo = ?";
		try (Connection conexion = GestorConexionSGDB.getConexionSGDB();
				PreparedStatement ps = conexion.prepareStatement(sentencia)) {
			ps.setString(1, codigo);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
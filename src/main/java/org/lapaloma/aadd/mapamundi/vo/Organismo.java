package org.lapaloma.aadd.mapamundi.vo;

public class Organismo {

	private String codigoOrganismo;
	private String nombre;
	private int aCreacion;
	private String sede;
	private String url;
	
	public Organismo() {
		
	}

	public Organismo(String codigoOrganismo, String nombre, int aCreacion, String sede, String url) {
		super();
		this.codigoOrganismo = codigoOrganismo;
		this.nombre = nombre;
		this.aCreacion = aCreacion;
		this.sede = sede;
		this.url = url;
	}

	public String getCodigoOrganismo() {
		return codigoOrganismo;
	}

	public void setCodigoOrganismo(String codigoOrganismo) {
		this.codigoOrganismo = codigoOrganismo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getaCreacion() {
		return aCreacion;
	}

	public void setaCreacion(int aCreacion) {
		this.aCreacion = aCreacion;
	}

	public String getSede() {
		return sede;
	}

	public void setSede(String sede) {
		this.sede = sede;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Organismo [codigoOrganismo=" + codigoOrganismo + ", nombre=" + nombre + ", aCreacion=" + aCreacion
				+ ", sede=" + sede + ", url=" + url + "]";
	}
	
	
	
	
}

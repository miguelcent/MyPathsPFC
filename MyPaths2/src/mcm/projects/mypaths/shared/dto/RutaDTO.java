package mcm.projects.mypaths.shared.dto;

import java.io.Serializable;
import java.util.Date;

public class RutaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2316378524143810329L;
	private String key;
	private String nombre;
	private Date fechaCreacion;
	private String descripcion;
	private String mapaKey;
	private String categoriaKey;
	private String usuarioKey;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getMapaKey() {
		return mapaKey;
	}

	public void setMapaKey(String mapaKey) {
		this.mapaKey = mapaKey;
	}

	public String getCategoriaKey() {
		return categoriaKey;
	}

	public void setCategoriaKey(String categoriaKey) {
		this.categoriaKey = categoriaKey;
	}

	public String getUsuarioKey() {
		return usuarioKey;
	}

	public void setUsuarioKey(String usuarioKey) {
		this.usuarioKey = usuarioKey;
	}
}

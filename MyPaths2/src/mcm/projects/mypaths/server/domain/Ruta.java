package mcm.projects.mypaths.server.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.appengine.api.datastore.Key;

@Entity
public class Ruta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 471127327257227718L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Key key;
	
	private String nombre;
	
	private Date fechaCreacion;
	
	private String textoDescriptivo;

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

	public String getTextoDescriptivo() {
		return textoDescriptivo;
	}

	public void setTextoDescriptivo(String textoDescriptivo) {
		this.textoDescriptivo = textoDescriptivo;
	}

	public Key getKey() {
		return key;
	}
	
	
	
}

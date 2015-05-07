package mcm.projects.mypaths.server.domain;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.appengine.api.datastore.Blob;
import com.google.appengine.api.datastore.Key;

public class Mapa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4574373899177820318L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Key key;
	
	public Blob getImagenMapa() {
		return imagenMapa;
	}

	public void setImagenMapa(Blob imagenMapa) {
		this.imagenMapa = imagenMapa;
	}

	public Key getKey() {
		return key;
	}

	private Blob imagenMapa;
}

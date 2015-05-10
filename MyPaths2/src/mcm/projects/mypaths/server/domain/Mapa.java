package mcm.projects.mypaths.server.domain;


import com.google.appengine.api.datastore.Blob;
import com.google.appengine.api.datastore.Key;

public class Mapa {

	private Key key;
	private Blob imagenMapa;
	
	public Blob getImagenMapa() {
		return imagenMapa;
	}

	public void setImagenMapa(Blob imagenMapa) {
		this.imagenMapa = imagenMapa;
	}

	public Key getKey() {
		return key;
	}	
}

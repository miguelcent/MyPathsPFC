package mcm.projects.mypaths.server.domain;

import com.google.appengine.api.datastore.Blob;
import com.google.appengine.api.datastore.Key;

public class CategoriaRuta{

	private static final long serialVersionUID = 1979166497433181685L;
	
	private Key key;
	
	private String nombreCategoria;
	
	private Blob imagenCategoria;

	public String getNombreCategoria() {
		return nombreCategoria;
	}

	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}

	public Blob getImagenCategoria() {
		return imagenCategoria;
	}

	public void setImagenCategoria(Blob imagenCategoria) {
		this.imagenCategoria = imagenCategoria;
	}

	public Key getKey() {
		return key;
	}

}

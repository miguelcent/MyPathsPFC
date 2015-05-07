package mcm.projects.mypaths.server.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.appengine.api.datastore.Blob;
import com.google.appengine.api.datastore.Key;

@Entity
public class CategoriaRuta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1979166497433181685L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

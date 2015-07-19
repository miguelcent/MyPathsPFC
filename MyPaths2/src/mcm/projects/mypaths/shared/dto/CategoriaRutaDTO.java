package mcm.projects.mypaths.shared.dto;

import java.io.Serializable;

import com.google.appengine.api.blobstore.BlobKey;

@SuppressWarnings("serial")
public class CategoriaRutaDTO implements Serializable{
	public String key;
	public String nombreCategoria;
	public String imagenCategoria;
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getNombreCategoria() {
		return nombreCategoria;
	}
	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}
	public String getImagenCategoria() {
		return imagenCategoria;
	}
	public void setImagenCategoria(String imagenCategoria) {
		this.imagenCategoria = imagenCategoria;
	}
}

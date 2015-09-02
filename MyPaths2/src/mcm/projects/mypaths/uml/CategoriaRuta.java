package mcm.projects.mypaths.uml;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CategoriaRuta implements Serializable{
	public static final String IMAGEN = "imagenCategoria";
	public static final String NOMBRE = "nombreCategoria";
	
	public String key;
	public String nombreCategoria;
	public UploadedImage imagenCategoria;
	
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
	public UploadedImage getImagenCategoria() {
		return imagenCategoria;
	}
	public void setImagenCategoria(UploadedImage imagenCategoria) {
		this.imagenCategoria = imagenCategoria;
	}
}

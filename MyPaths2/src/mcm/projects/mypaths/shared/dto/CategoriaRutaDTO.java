package mcm.projects.mypaths.shared.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CategoriaRutaDTO implements Serializable{
	public static final String IMAGEN = "imagenCategoria";
	public static final String NOMBRE = "nombreCategoria";
	
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
	
	public String toString(){
		String str = "Cattegoria:  \n key: "+this.key+"\n imagen: "+this.getImagenCategoria()+"\n nombre: "+this.nombreCategoria;
		
		return str;
	}
}

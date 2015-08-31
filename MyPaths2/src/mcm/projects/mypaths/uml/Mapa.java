package mcm.projects.mypaths.uml;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Mapa implements Serializable {
	
	public static final String SERVING_URL = "imagenMapa";
	public static final String TIPO_MAPA = "tipoMapa";
	
	public String key;
	public String imagenMapa;
	public TiposMapa tipoMapa;
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getImagenMapa() {
		return imagenMapa;
	}
	public void setImagenMapa(String imagenMapa) {
		this.imagenMapa = imagenMapa;
	}
	public TiposMapa getTipoMapa() {
		return tipoMapa;
	}
	public void setTipoMapa(TiposMapa tipoMapa) {
		this.tipoMapa = tipoMapa;
	}
}

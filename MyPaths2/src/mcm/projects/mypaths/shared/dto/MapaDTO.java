package mcm.projects.mypaths.shared.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class MapaDTO implements Serializable {
	public String key;
	public String imagenMapa;
	public String tipoMapa;
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
	public String getTipoMapa() {
		return tipoMapa;
	}
	public void setTipoMapa(String tipoMapa) {
		this.tipoMapa = tipoMapa;
	}
}

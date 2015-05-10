package mcm.projects.mypaths.server.domain;

import com.google.appengine.api.datastore.Key;

public class Valoracion{

	private Key key;
	
	private Double valoracionTotal;
	
	private Double cuentaValoracion;

	public Double getValoracionTotal() {
		return valoracionTotal;
	}

	public void setValoracionTotal(Double valoracionTotal) {
		this.valoracionTotal = valoracionTotal;
	}

	public Double getCuentaValoracion() {
		return cuentaValoracion;
	}

	public void setCuentaValoracion(Double cuentaValoracion) {
		this.cuentaValoracion = cuentaValoracion;
	}

	public Key getKey() {
		return key;
	}
}

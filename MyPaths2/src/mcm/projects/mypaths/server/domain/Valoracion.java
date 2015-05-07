package mcm.projects.mypaths.server.domain;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.appengine.api.datastore.Key;

public class Valoracion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3533918364783428611L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

package mcm.projects.mypaths.shared.dto;

public class ValoracionDTO {
	private String usuarioKey;
	private String rutaKey;
	private String key;
	private Double valoracionTotal;
	private Double cuentaValoracion;
	public String getUsuarioKey() {
		return usuarioKey;
	}
	public void setUsuarioKey(String usuarioKey) {
		this.usuarioKey = usuarioKey;
	}
	public String getRutaKey() {
		return rutaKey;
	}
	public void setRutaKey(String rutaKey) {
		this.rutaKey = rutaKey;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
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
}

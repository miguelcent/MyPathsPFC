package mcm.projects.mypaths.uml;

public class Valoracion {
	private String key;
	private Double valoracionTotal;
	private Double cuentaValoracion;
	private Usuario usuarioKey;
	private Ruta rutaKey;
	
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
	public Usuario getUsuarioKey() {
		return usuarioKey;
	}
	public void setUsuarioKey(Usuario usuarioKey) {
		this.usuarioKey = usuarioKey;
	}
	public Ruta getRutaKey() {
		return rutaKey;
	}
	public void setRutaKey(Ruta rutaKey) {
		this.rutaKey = rutaKey;
	}
}

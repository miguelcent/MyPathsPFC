package mcm.projects.mypaths.uml;

import java.io.Serializable;
import java.util.Date;

public class Ruta implements Serializable {
	
	public static final String NOMBRE = "nombre";
	public static final String FEC_CREACION = "fechaCreacion";
	public static final String DESCRIPCION = "descripcion";
	public static final String MAPA_KEY = "mapaKey";
	public static final String CATEGORIA_KEY = "categoriaKey";
	public static final String USUARIO_KEY = "usuarioKey";
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2316378524143810329L;
	private String key;
	private String nombre;
	private Date fechaCreacion;
	private String descripcion;
	private CategoriaRuta categoriaRuta;
	private Mapa mapa;
	private Usuario usuario;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public CategoriaRuta getCategoriaRuta() {
		return categoriaRuta;
	}

	public void setCategoriaRuta(CategoriaRuta categoriaRuta) {
		this.categoriaRuta = categoriaRuta;
	}

	public Mapa getMapa() {
		return mapa;
	}

	public void setMapa(Mapa mapa) {
		this.mapa = mapa;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}

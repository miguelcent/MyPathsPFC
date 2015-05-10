package mcm.projects.mypaths.server.domain;

import java.util.Date;
import java.util.List;
import com.google.appengine.api.datastore.Key;

public class Ruta{

	private Key key;
	private String nombre;
	private Date fechaCreacion;
	private String textoDescriptivo;
	
	private List<Comentario> comentarios;
	
	private Valoracion valoracion;
	
	private CategoriaRuta categoria;
	
	private Mapa mapa;

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

	public String getTextoDescriptivo() {
		return textoDescriptivo;
	}

	public void setTextoDescriptivo(String textoDescriptivo) {
		this.textoDescriptivo = textoDescriptivo;
	}

	public Key getKey() {
		return key;
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public Valoracion getValoracion() {
		return valoracion;
	}

	public void setValoracion(Valoracion valoracion) {
		this.valoracion = valoracion;
	}

	public CategoriaRuta getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaRuta categoria) {
		this.categoria = categoria;
	}

	public Mapa getMapa() {
		return mapa;
	}

	public void setMapa(Mapa mapa) {
		this.mapa = mapa;
	}
	
	
	
}

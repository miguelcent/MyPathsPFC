package mcm.projects.mypaths.server.domain;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.appengine.api.datastore.Key;

public class Comentario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4459041152295752319L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Key key;
	
	private String textoComentario;

	public String getTextoComentario() {
		return textoComentario;
	}

	public void setTextoComentario(String textoComentario) {
		this.textoComentario = textoComentario;
	}
}

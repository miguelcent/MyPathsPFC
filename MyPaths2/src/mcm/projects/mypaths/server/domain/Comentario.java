package mcm.projects.mypaths.server.domain;


import com.google.appengine.api.datastore.Key;

public class Comentario{

	
	private Key key;
	
	private String textoComentario;

	public Key getKey() {
		return key;
	}

	public void setKey(Key key) {
		this.key = key;
	}

	public String getTextoComentario() {
		return textoComentario;
	}

	public void setTextoComentario(String textoComentario) {
		this.textoComentario = textoComentario;
	}
}

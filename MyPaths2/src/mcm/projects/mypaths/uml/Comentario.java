package mcm.projects.mypaths.uml;

public class Comentario {
	
	private String key;
	private Usuario usuarioKey;
	private Ruta rutaKey;
	private String textoComentario;
	
	public Usuario getUsuarioKey() {
		return usuarioKey;
	}
	public void setUsuarioKey(Usuario usuarioKey) {
		this.usuarioKey = usuarioKey;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getTextoComentario() {
		return textoComentario;
	}
	public void setTextoComentario(String textoComentario) {
		this.textoComentario = textoComentario;
	}
	public Ruta getRutaKey() {
		return rutaKey;
	}
	public void setRutaKey(Ruta rutaKey) {
		this.rutaKey = rutaKey;
	}
	
}

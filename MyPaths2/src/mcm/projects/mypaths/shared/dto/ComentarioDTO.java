package mcm.projects.mypaths.shared.dto;

public class ComentarioDTO {
	private String usuarioKey;
	private String rutaKey;
	private String key;
	private String textoComentario;
	
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
	public String getTextoComentario() {
		return textoComentario;
	}
	public void setTextoComentario(String textoComentario) {
		this.textoComentario = textoComentario;
	}
	
}

package mcm.projects.mypaths.shared.dto;

import java.io.Serializable;
import java.util.Date;

//import com.google.appengine.api.datastore.Blob;
//import com.google.appengine.api.datastore.Key;

public class UsuarioDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -436861356546406372L;
	private String id;
	private String login;
	private String password;
	private String email;
	private String nombre;
	private String apellidos;
	private String ciudad;
	private String codigo_postal;
	private String pais;
	private String image_avavatar_KEY;
	private Date ultimoLogin;	
	private Date ultimoLogout;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getCodigo_postal() {
		return codigo_postal;
	}
	public void setCodigo_postal(String codigo_postal) {
		this.codigo_postal = codigo_postal;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getImage_avavatar_KEY() {
		return image_avavatar_KEY;
	}
	public void setImage_avavatar_KEY(String image_avavatar_KEY) {
		this.image_avavatar_KEY = image_avavatar_KEY;
	}
	public Date getUltimoLogin() {
		return ultimoLogin;
	}
	public void setUltimoLogin(Date ultimoLogin) {
		this.ultimoLogin = ultimoLogin;
	}
	public Date getUltimoLogout() {
		return ultimoLogout;
	}
	public void setUltimoLogout(Date ultimoLogout) {
		this.ultimoLogout = ultimoLogout;
	}
	
}

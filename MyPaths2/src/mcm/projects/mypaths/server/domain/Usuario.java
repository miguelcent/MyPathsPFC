package mcm.projects.mypaths.server.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.appengine.api.datastore.Blob;
import com.google.appengine.api.datastore.Key;

@Entity
public class Usuario implements Serializable {
	
	private static final long serialVersionUID = -5029275710232818218L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Key key;
	
	private  String login;
	
	private String password;
	
	private String email;
	
	private Date fechaIngreso;
	
	private String nombre;
	
	private String apellidos;
	
	private String ciudad;
	
	private String codigo_postal;
	
	private String pais;
	
	private Blob imagen_avatar; 
	
	private Date ultimoLogin;
	
	private Date ultimoLogout;

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

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
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

	public Blob getImagen_avatar() {
		return imagen_avatar;
	}

	public void setImagen_avatar(Blob imagen_avatar) {
		this.imagen_avatar = imagen_avatar;
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

	public Key getKey() {
		return key;
	}
	
	
	
	
}

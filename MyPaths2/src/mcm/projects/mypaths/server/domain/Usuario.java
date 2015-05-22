package mcm.projects.mypaths.server.domain;

import java.util.Date;
import java.util.List;

import mcm.projects.mypaths.shared.dto.UsuarioDTO;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.datastore.Blob;
import com.google.appengine.api.datastore.Email;
import com.google.appengine.api.datastore.Key;


public class Usuario{
	
	
    private Key key;
    private String id;
	private String login;	
	private String password;	
	private Email email;	
	private Date fechaIngreso;	
	private String nombre;	
	private String apellidos;	
	private String ciudad;	
	private String codigo_postal;	
	private String pais;	
	private BlobKey imagen_avatar; 	
	private Date ultimoLogin;	
	private Date ultimoLogout;
	
	private List<Ruta> rutas;

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

	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
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

	public BlobKey getImagen_avatar() {
		return imagen_avatar;
	}

	public void setImagen_avatar(BlobKey imagen_avatar) {
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

	public List<Ruta> getRutas() {
		return rutas;
	}

	public void setRutas(List<Ruta> rutas) {
		this.rutas = rutas;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public static UsuarioDTO toDTO(Usuario u) {
		UsuarioDTO ret = new UsuarioDTO();
		ret.setApellidos(u.getApellidos());
		ret.setCiudad(u.getCiudad());
		ret.setCodigo_postal(u.getCodigo_postal());
		ret.setEmail(u.getEmail().toString());
		ret.setImage_avavatar_KEY(u.getImagen_avatar().toString());
		ret.setNombre(u.getNombre());
		ret.setPais(u.getPais());
		ret.setUltimoLogin(u.getUltimoLogin());
		return ret;
	}
	
	
	
	
}

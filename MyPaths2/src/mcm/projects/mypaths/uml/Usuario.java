package mcm.projects.mypaths.uml;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Usuario implements Serializable{

	public static final String APELLIDOS = "usuario";
	public static final String CIUDAD = "ciudad";
	public static final String CODIGO_POSTAL = "codigo_postal";
	public static final String EMAIL = "email";
	public static final String FEC_INGRESO = "fechaIngreso";
	public static final String USER_IMAGE_KEY = "userImageKey";
	public static final String LOGIN = "login";
	public static final String NOMBRE = "nombre";	
	public static final String PAIS = "pais";	
	public static final String PASSWORD = "password";
	public static final String ULTIMO_LOGIN = "ultimoLogin";
	public static final String ULTIMOLOGOUT = "ultimoLogout";	
	
	private String key;
	private String login;
	private String password;
	private String email;
	private Date fechaIngreso;
	private String nombre;
	private String apellidos;
	private String ciudad;
	private String codigo_postal;
	private String pais;
	private UploadedImage userImage;
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

	public String getKey() {
		return key;
	}

	public void setKey(String id) {
		this.key = id;
	}

	public UploadedImage getUserImage() {
		return userImage;
	}

	public void setUserImage(UploadedImage userImage) {
		this.userImage = userImage;
	}

}

package mcm.projects.mypaths.server.dao;

import java.util.Date;

import mcm.projects.mypaths.shared.NotLoggedInException;
import mcm.projects.mypaths.shared.dto.UsuarioDTO;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Email;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

public class UsuarioDao {
	DatastoreService datastore;

	public UsuarioDao() {
		datastore = DatastoreServiceFactory.getDatastoreService();
	}

	public UsuarioDTO get(String encodedKey) {

		Key key = KeyFactory.createKey("Usuario", encodedKey);
		try {
			Entity result = datastore.get(key);
			UsuarioDTO usuario = fromEntity(result);
			usuario.setKey(encodedKey);
			return usuario;
		} catch (EntityNotFoundException e) {
			return null;
		}

	}

	public Boolean logOut(String username) throws NotLoggedInException {
		Boolean ret = false;
		if (!(username == null || username.equals(""))) {
			ret = true;
		}
		return ret;
	}
	
	public void add(UsuarioDTO usuario){
		Entity entity = fromDto(usuario);
		datastore.put(entity);
	}
	
	private UsuarioDTO fromEntity(Entity result) {
		UsuarioDTO usuario = new UsuarioDTO();
		usuario.setApellidos((String)result.getProperty(UsuarioDTO.APELLIDOS));
		usuario.setCiudad((String)result.getProperty(UsuarioDTO.CIUDAD));
		usuario.setCodigo_postal((String)result.getProperty(UsuarioDTO.CODIGO_POSTAL));
		usuario.setEmail(((Email)result.getProperty(UsuarioDTO.EMAIL)).getEmail());
		usuario.setFechaIngreso((Date)result.getProperty(UsuarioDTO.FEC_INGRESO));
		usuario.setUserImageKey((String)result.getProperty(UsuarioDTO.USER_IMAGE_KEY));
		if (usuario.getKey() == null) {
			String encodedKey = KeyFactory.keyToString(result.getKey());
			usuario.setKey(encodedKey);
		}
		usuario.setLogin((String)result.getProperty(UsuarioDTO.LOGIN));
		usuario.setNombre((String)result.getProperty(UsuarioDTO.NOMBRE));
		usuario.setPais((String)result.getProperty(UsuarioDTO.PAIS));
		usuario.setPassword((String)result.getProperty(UsuarioDTO.PASSWORD));
		usuario.setUltimoLogin((Date)result.getProperty(UsuarioDTO.ULTIMO_LOGIN));
		usuario.setUltimoLogout((Date)result.getProperty(UsuarioDTO.ULTIMOLOGOUT));

		return usuario;
	}
	
	private Entity fromDto(UsuarioDTO usuario) {
		Entity entity = new Entity("Usuario", usuario.getLogin());
		entity.setProperty(UsuarioDTO.APELLIDOS, usuario.getApellidos());
		entity.setProperty(UsuarioDTO.CIUDAD, usuario.getCiudad());
		entity.setProperty(UsuarioDTO.CODIGO_POSTAL, usuario.getCodigo_postal());
		Email em = new Email(usuario.getEmail());
		entity.setProperty(UsuarioDTO.EMAIL, em);
		entity.setProperty(UsuarioDTO.FEC_INGRESO, usuario.getFechaIngreso());
		entity.setProperty(UsuarioDTO.LOGIN, usuario.getLogin());
		entity.setProperty(UsuarioDTO.NOMBRE, usuario.getNombre());
		entity.setProperty(UsuarioDTO.PAIS, usuario.getPais());
		entity.setProperty(UsuarioDTO.PASSWORD, usuario.getPassword());
		entity.setProperty(UsuarioDTO.ULTIMO_LOGIN, usuario.getUltimoLogin());
		entity.setProperty(UsuarioDTO.ULTIMOLOGOUT, usuario.getUltimoLogout());
		entity.setProperty(UsuarioDTO.USER_IMAGE_KEY, usuario.getUserimageKey());
		return entity;

	}

	
	
	
}

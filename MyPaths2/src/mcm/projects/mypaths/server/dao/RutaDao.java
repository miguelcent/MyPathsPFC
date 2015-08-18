package mcm.projects.mypaths.server.dao;

import java.util.Date;
import java.util.List;

import mcm.projects.mypaths.shared.dto.RutaDTO;
import mcm.projects.mypaths.shared.dto.UsuarioDTO;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Email;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

public class RutaDao {

	DatastoreService datastore;

	public RutaDao() {
		datastore = DatastoreServiceFactory.getDatastoreService();
	}

	public RutaDTO get(String encodedKey) {
		Key key = KeyFactory.stringToKey(encodedKey);
		try {
			Entity result = datastore.get(key);
			RutaDTO usuario = fromEntity(result);
			usuario.setKey(encodedKey);
			return usuario;
		} catch (EntityNotFoundException e) {
			return null;
		}
	}

	// TODO pendiente desarrollo este metodo para traer rutas de un usuario
	// dado.
	public List<RutaDTO> getRutasUsuario(String userKey) {
		return null;

	}

	public void add(RutaDTO ruta) {
		Entity entity = fromDto(ruta);
		datastore.put(entity);
	}

	public void delete(String encodedKey) {
		Key key = KeyFactory.stringToKey(encodedKey);
		datastore.delete(key);
	}

	private Entity fromDto(RutaDTO ruta) {
		Entity entity = new Entity("Ruta");
		entity.setProperty(RutaDTO.NOMBRE, ruta.getNombre());
		entity.setProperty(RutaDTO.FEC_CREACION, new Date());
		entity.setProperty(RutaDTO.DESCRIPCION, ruta.getDescripcion());
		entity.setProperty(RutaDTO.MAPA_KEY, ruta.getMapaKey());
		entity.setProperty(RutaDTO.CATEGORIA_KEY, ruta.getCategoriaKey());
		entity.setProperty(RutaDTO.USUARIO_KEY, ruta.getUsuarioKey());
		return entity;
	}

	private RutaDTO fromEntity(Entity result) {
		// TODO Auto-generated method stub
		return null;
	}
}

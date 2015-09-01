package mcm.projects.mypaths.server.dao;


import mcm.projects.mypaths.shared.dto.ComentarioDTO;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;

public class ComentarioDao {
	
	DatastoreService datastore;
	
	public ComentarioDao() {
		datastore = DatastoreServiceFactory.getDatastoreService();
	}
	
	public void add(ComentarioDTO com){
		Entity entity = fromDto(com);
		datastore.put(entity);
	}

	private Entity fromDto(ComentarioDTO com) {
		Entity entity = new Entity("Valoracion");
		entity.setProperty("textoCOmentario", com.getTextoComentario());
		entity.setProperty("usuarioId", com.getUsuarioKey());
		entity.setProperty("rutaId", com.getRutaKey());
		return entity;
	}
}

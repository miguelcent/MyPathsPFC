package mcm.projects.mypaths.server.dao;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import mcm.projects.mypaths.shared.TiposMapa;
import mcm.projects.mypaths.shared.dto.MapaDTO;

public class MapaDao {
	DatastoreService datastore;
	public MapaDao(){
		datastore = DatastoreServiceFactory.getDatastoreService();
	}
	public MapaDTO get(String mapaKey) {
		Key key = KeyFactory.stringToKey(mapaKey);
		try {
			Entity result = datastore.get(key);
			MapaDTO mapa = fromEntity(result);
			mapa.setKey(mapaKey);
			return mapa;
		} catch (EntityNotFoundException e) {
			return null;
		}
	}
	
	public void delete(String encodedKey) {
		Key key = KeyFactory.stringToKey(encodedKey);
		datastore.delete(key);
	}
	
	private MapaDTO fromEntity(Entity result) {
		MapaDTO mapa = new MapaDTO();
		mapa.setImagenMapa((String) result.getProperty(MapaDTO.SERVING_URL));
		mapa.setTipoMapa(TiposMapa.KML.toString());
		if (mapa.getKey() == null) {
			String encodedKey = KeyFactory.keyToString(result.getKey());
			mapa.setKey(encodedKey);
		}
		return mapa;
	}
	

}

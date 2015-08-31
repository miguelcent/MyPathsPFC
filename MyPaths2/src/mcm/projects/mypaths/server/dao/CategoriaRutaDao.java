package mcm.projects.mypaths.server.dao;

import java.util.ArrayList;
import java.util.List;

import mcm.projects.mypaths.shared.dto.CategoriaRutaDTO;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.FilterPredicate;

public class CategoriaRutaDao {
	DatastoreService datastore;

	public CategoriaRutaDao() {
		datastore = DatastoreServiceFactory.getDatastoreService();
	}

	public CategoriaRutaDTO getByKey(String encodedKey) {
		Key key = KeyFactory.createKey("CategoriaRuta", encodedKey);
		try {
			Entity result = datastore.get(key);
			CategoriaRutaDTO categoria = fromEntity(result);
			categoria.setKey(encodedKey);
			return categoria;
		} catch (EntityNotFoundException e) {
			return null;
		}
	}

	public CategoriaRutaDTO getByName(String categoriaName) {
		
		Query q = new Query("CategoriaRuta");
		Filter equalFilter = new FilterPredicate("nombreCategoria", FilterOperator.EQUAL, categoriaName);
		List<Entity> categorias = datastore.prepare(q.setFilter(equalFilter)).asList(FetchOptions.Builder.withLimit(2));
		List<CategoriaRutaDTO> categoriasDTO = new ArrayList<CategoriaRutaDTO>();
		
		for (Entity result : categorias) {
			CategoriaRutaDTO dto = fromEntity(result);
			categoriasDTO.add(dto);
		}
		if(categoriasDTO.size()>0){
			return categoriasDTO.get(0);
		} else {
			return null;
		}
	}

	private CategoriaRutaDTO fromEntity(Entity result) {
		CategoriaRutaDTO categoria = new CategoriaRutaDTO();
		categoria.setImagenCategoria((String) result
				.getProperty(CategoriaRutaDTO.IMAGEN));
		categoria.setNombreCategoria((String) result
				.getProperty(CategoriaRutaDTO.NOMBRE));
		if (categoria.getKey() == null) {
			String encodedKey = KeyFactory.keyToString(result.getKey());
			categoria.setKey(encodedKey);
		}
		return categoria;
	}

}

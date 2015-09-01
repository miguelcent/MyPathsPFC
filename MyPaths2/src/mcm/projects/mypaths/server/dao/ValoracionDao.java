package mcm.projects.mypaths.server.dao;

import java.util.ArrayList;
import java.util.List;

import mcm.projects.mypaths.shared.dto.CategoriaRutaDTO;
import mcm.projects.mypaths.shared.dto.ValoracionDTO;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.FilterPredicate;

public class ValoracionDao {
	DatastoreService datastore;

	public ValoracionDao() {
		datastore = DatastoreServiceFactory.getDatastoreService();
	}
	
	public void add(ValoracionDTO val){
		Entity entity = fromDto(val);
		datastore.put(entity);
	}
	
//TODO pendiente de terminar
	public void getMaxCuentaValoracion(String key) {
		Query q = new Query("Valoracion");
		Filter equalFilter = new FilterPredicate("rutaId", FilterOperator.EQUAL, key);
		List<Entity> valoraciones = datastore.prepare(q.setFilter(equalFilter)).asList(FetchOptions.Builder.withLimit(2));
		List<ValoracionDTO> valoracionesDTO = new ArrayList<ValoracionDTO>();
		ArrayList<Double> doubles = new ArrayList<Double>();
		
		for (Entity result : valoraciones) {
			ValoracionDTO dto = fromEntity(result);
			valoracionesDTO.add(dto);
		}
		for(ValoracionDTO v: valoracionesDTO){
			doubles.add(v.getCuentaValoracion());
		}
//		if(categoriasDTO.size()>0){
//			return categoriasDTO.get(0);
//		} else {
//			return null;
//		}
	}	
	
	private ValoracionDTO fromEntity(Entity result) {
		ValoracionDTO dto = new ValoracionDTO();
		dto.setCuentaValoracion((Double) result.getProperty("cuentaValoracion"));
		dto.setValoracionTotal((Double) result.getProperty("cuentaValoracion"));
		return null;
	}

	private Entity fromDto(ValoracionDTO val) {
		Entity entity = new Entity("Valoracion");
		entity.setProperty("valoracionTotal", val.getValoracionTotal());
		entity.setProperty("cuentaValoracion", val.getCuentaValoracion());
		entity.setProperty("usuarioId", val.getUsuarioKey());
		entity.setProperty("rutaId", val.getRutaKey());
		return entity;
	}
}

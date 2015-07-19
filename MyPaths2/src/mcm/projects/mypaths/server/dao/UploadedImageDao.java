package mcm.projects.mypaths.server.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import mcm.projects.mypaths.shared.dto.UploadedImageDTO;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.SortDirection;

public class UploadedImageDao {
	DatastoreService datastore;

	public UploadedImageDao() {
		datastore = DatastoreServiceFactory.getDatastoreService();
	}

	public UploadedImageDTO get(String encodedKey) {
		Key key = KeyFactory.stringToKey(encodedKey);
		try {
			Entity result = datastore.get(key);
			UploadedImageDTO image = fromEntity(result);
			image.setKey(encodedKey);
			return image;
		} catch (EntityNotFoundException e) {
			return null;
		}

	}

	public List<UploadedImageDTO> getRecent() {
		Query query = new Query("UploadedImage");
		query.addSort(UploadedImageDTO.CREATED_AT, SortDirection.DESCENDING);
		FetchOptions options = FetchOptions.Builder.withLimit(25);

		ArrayList<UploadedImageDTO> results = new ArrayList<UploadedImageDTO>();
		for (Entity result : datastore.prepare(query).asIterable(options)) {
			UploadedImageDTO image = fromEntity(result);
			results.add(image);
		}
		return results;
	}
	
	public void delete(String encodedKey) {
		Key key = KeyFactory.stringToKey(encodedKey);
		datastore.delete(key);
	}

	private UploadedImageDTO fromEntity(Entity result) {
		UploadedImageDTO image = new UploadedImageDTO();
		image.setCreatedAt((Date) result.getProperty(UploadedImageDTO.CREATED_AT));
		image.setServingUrl((String) result
				.getProperty(UploadedImageDTO.SERVING_URL));
		
		image.setOwnerId((String) result.getProperty(UploadedImageDTO.OWNER_ID));

		if (image.getKey() == null) {
			String encodedKey = KeyFactory.keyToString(result.getKey());
			image.setKey(encodedKey);
		}

		return image;
	}
}

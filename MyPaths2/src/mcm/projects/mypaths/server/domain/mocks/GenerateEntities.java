package mcm.projects.mypaths.server.domain.mocks;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.images.ImagesService;
import com.google.appengine.api.images.ImagesServiceFactory;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class GenerateEntities extends RemoteServiceServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -332962281159123579L;
	private static DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
	private BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
	private ImagesService imageService = ImagesServiceFactory.getImagesService();
	public GenerateEntities(){
		
	}
}

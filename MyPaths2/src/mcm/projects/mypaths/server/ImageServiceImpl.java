package mcm.projects.mypaths.server;

import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;

import mcm.projects.mypaths.client.service.ImageService;

public class ImageServiceImpl implements ImageService {

	@Override
	public String getBlobstoreUploadUrl() {
		BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
        return blobstoreService.createUploadUrl("/uploadblob");
	}

}

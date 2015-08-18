package mcm.projects.mypaths.server;

import java.util.List;

import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import mcm.projects.mypaths.client.service.UserImageService;
import mcm.projects.mypaths.server.dao.UploadedImageDao;
import mcm.projects.mypaths.shared.dto.UploadedImageDTO;

@SuppressWarnings("serial")
public class UserImageServiceImpl extends RemoteServiceServlet implements UserImageService {

	@Override
	public String getBlobstoreUploadUrl() {
		BlobstoreService blobstoreService = BlobstoreServiceFactory
				.getBlobstoreService();
		return blobstoreService.createUploadUrl("/uploadimageblob");
	}

	@Override
	public UploadedImageDTO get(String key) {
			UploadedImageDao dao = new UploadedImageDao();
			UploadedImageDTO image = dao.get(key);
			return image;
	}

	@Override
	public List<UploadedImageDTO> getRecentlyUploaded() {
		UploadedImageDao dao = new UploadedImageDao();
		List<UploadedImageDTO> images = dao.getRecent(); 
		return images;
	}
//TODO no hay UserService que valga de google.
	@Override
	public void deleteImage(String key) {
		UserService userService = UserServiceFactory.getUserService();
		User user = userService.getCurrentUser();
		UploadedImageDao dao = new UploadedImageDao();
		UploadedImageDTO image = dao.get(key);
		if(image.getOwnerId().equals(user.getUserId())) {
			dao.delete(key);
		}
	}

}

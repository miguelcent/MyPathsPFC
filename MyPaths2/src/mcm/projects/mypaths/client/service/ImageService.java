package mcm.projects.mypaths.client.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("images")
public interface ImageService extends RemoteService {
	public String getBlobstoreUploadUrl();
}

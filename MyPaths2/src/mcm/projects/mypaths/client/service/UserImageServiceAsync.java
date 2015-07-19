package mcm.projects.mypaths.client.service;

import java.util.List;

import mcm.projects.mypaths.shared.dto.UploadedImageDTO;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface UserImageServiceAsync {
	public void getBlobstoreUploadUrl(AsyncCallback<String> callback);

	void get(String key, AsyncCallback<UploadedImageDTO> callback);

	void getRecentlyUploaded(AsyncCallback<List<UploadedImageDTO>> callback);

	void deleteImage(String key, AsyncCallback<Void> callback);

}

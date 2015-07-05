package mcm.projects.mypaths.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ImageServiceAsync {
	 public void getBlobstoreUploadUrl(AsyncCallback<String> callback);
}

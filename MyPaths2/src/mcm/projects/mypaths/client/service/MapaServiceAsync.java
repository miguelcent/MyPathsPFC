package mcm.projects.mypaths.client.service;

import mcm.projects.mypaths.shared.dto.MapaDTO;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface MapaServiceAsync {
	public void getBlobstoreUploadUrl(AsyncCallback<String> callback);
	void get(String key, AsyncCallback<MapaDTO> callback);
	void deleteMap(String key, AsyncCallback<Void> callback);
}

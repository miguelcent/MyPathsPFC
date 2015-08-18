package mcm.projects.mypaths.client.service;

import mcm.projects.mypaths.shared.dto.MapaDTO;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("maps")
public interface MapaService extends RemoteService{
	public String getBlobstoreUploadUrl();
	public MapaDTO get(String key);
	public void deleteMap(String key);
}

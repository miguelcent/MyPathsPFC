package mcm.projects.mypaths.client.service;

import java.util.List;

import mcm.projects.mypaths.shared.dto.UploadedImageDTO;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("images")
public interface UserImageService extends RemoteService{
	public String getBlobstoreUploadUrl();
	public UploadedImageDTO get(String key);
	public List<UploadedImageDTO> getRecentlyUploaded();
	public void deleteImage(String key);
}

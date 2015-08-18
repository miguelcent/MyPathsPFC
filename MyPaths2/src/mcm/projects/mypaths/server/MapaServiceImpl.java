package mcm.projects.mypaths.server;

import mcm.projects.mypaths.client.service.LoginService;
import mcm.projects.mypaths.client.service.MapaService;
import mcm.projects.mypaths.server.dao.MapaDao;
import mcm.projects.mypaths.shared.dto.MapaDTO;
import mcm.projects.mypaths.shared.dto.UsuarioDTO;

import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.storage.client.Storage;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class MapaServiceImpl extends RemoteServiceServlet implements MapaService{
	@Override
	public String getBlobstoreUploadUrl() {
		BlobstoreService blobstoreService = BlobstoreServiceFactory
				.getBlobstoreService();
		return blobstoreService.createUploadUrl("/uploadMap");
	}

	@Override
	public MapaDTO get(String key) {
		MapaDao dao = new MapaDao();
		MapaDTO mapa = dao.get(key);
		return mapa;
	}

	@Override
	public void deleteMap(String key) {
		LoginService ls = GWT.create(LoginService.class);
		UsuarioDTO user = ls.getLoggedInUserDTO(Storage.getSessionStorageIfSupported().getItem("currentUser"));
		MapaDao dao = new MapaDao();
		MapaDTO mapa = dao.get(key);
		dao.delete(key);
		
	}
}

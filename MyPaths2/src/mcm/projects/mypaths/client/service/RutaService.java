package mcm.projects.mypaths.client.service;

import java.util.List;

import mcm.projects.mypaths.shared.NotLoggedInException;
import mcm.projects.mypaths.shared.dto.RutaDTO;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("rutaService")
public interface RutaService extends RemoteService{
	String add(RutaDTO ruta) throws NotLoggedInException;
	RutaDTO edit(RutaDTO rutaOriginal);
	void remove(String id); 
	List<RutaDTO> getRutas();
	RutaDTO get(String ruta);
	List<RutaDTO> getRutasUsuario(String userId);
}

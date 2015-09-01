package mcm.projects.mypaths.client.service;

import mcm.projects.mypaths.shared.dto.ComentarioDTO;
import mcm.projects.mypaths.shared.dto.RutaDTO;

import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.google.gwt.user.client.rpc.RemoteService;

@RemoteServiceRelativePath("comentarioservice")
public interface ComentarioService extends RemoteService {
	public void comentarRuta(ComentarioDTO com);
}

package mcm.projects.mypaths.client.service;

import mcm.projects.mypaths.shared.dto.ComentarioDTO;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("comentarioservice")
public interface ComentarioService extends RemoteService {
	public void comentarRuta(ComentarioDTO com);
}

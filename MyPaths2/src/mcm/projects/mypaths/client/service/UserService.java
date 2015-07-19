package mcm.projects.mypaths.client.service;

import java.util.List;

import mcm.projects.mypaths.shared.NotLoggedInException;
import mcm.projects.mypaths.shared.dto.UsuarioDTO;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("usersService")
public interface UserService extends RemoteService {
	void add(UsuarioDTO usuario) throws NotLoggedInException;
	UsuarioDTO edit(UsuarioDTO usuarioOriginal);
	void remove(String id); 
	List<UsuarioDTO> getUsuarios();
	UsuarioDTO get(String username);
}

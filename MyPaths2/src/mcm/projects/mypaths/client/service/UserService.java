package mcm.projects.mypaths.client.service;

import java.util.List;

import mcm.projects.mypaths.shared.NotLoggedInException;
import mcm.projects.mypaths.shared.dto.Usuario;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("usersService")
public interface UserService extends RemoteService {
	void add(Usuario usuario) throws NotLoggedInException;
	Usuario edit(Usuario usuarioOriginal);
	void remove(String id); 
	List<Usuario> getUsuarios();
	Usuario get(String username);
}

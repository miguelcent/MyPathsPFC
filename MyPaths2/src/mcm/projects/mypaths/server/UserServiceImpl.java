package mcm.projects.mypaths.server;

import java.util.List;


import mcm.projects.mypaths.client.service.UserService;
import mcm.projects.mypaths.server.dao.UsuarioDao;
import mcm.projects.mypaths.shared.NotLoggedInException;
import mcm.projects.mypaths.shared.dto.Usuario;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class UserServiceImpl extends RemoteServiceServlet implements UserService{
	
	
    
	@Override
	public void add(Usuario usuarioDTO) throws NotLoggedInException{
		UsuarioDao dao = new UsuarioDao();
		dao.add(usuarioDTO);
	}

	@Override
	public Usuario edit(Usuario usuarioOriginal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Usuario> getUsuarios() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario get(String key) {
		UsuarioDao dao = new UsuarioDao();
		Usuario usuario = dao.get(key);
		return usuario;
	}

}

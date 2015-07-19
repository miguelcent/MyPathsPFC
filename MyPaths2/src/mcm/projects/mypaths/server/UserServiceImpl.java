package mcm.projects.mypaths.server;

import java.util.List;


import mcm.projects.mypaths.client.service.UserService;
import mcm.projects.mypaths.server.dao.UsuarioDao;
import mcm.projects.mypaths.shared.NotLoggedInException;
import mcm.projects.mypaths.shared.dto.UsuarioDTO;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class UserServiceImpl extends RemoteServiceServlet implements UserService{
	
	
    
	@Override
	public void add(UsuarioDTO usuarioDTO) throws NotLoggedInException{
		UsuarioDao dao = new UsuarioDao();
		dao.add(usuarioDTO);
	}

	@Override
	public UsuarioDTO edit(UsuarioDTO usuarioOriginal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<UsuarioDTO> getUsuarios() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UsuarioDTO get(String key) {
		UsuarioDao dao = new UsuarioDao();
		UsuarioDTO usuario = dao.get(key);
		return usuario;
	}

}

package mcm.projects.mypaths.server;

import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

import javax.jdo.PersistenceManager;
import mcm.projects.mypaths.client.service.UserService;
import mcm.projects.mypaths.server.domain.Usuario;
import mcm.projects.mypaths.shared.NotLoggedInException;
import mcm.projects.mypaths.shared.builder.UsuarioBuilder;
import mcm.projects.mypaths.shared.dto.UsuarioDTO;

import com.google.gwt.storage.client.Storage;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class UserServiceImpl extends RemoteServiceServlet implements UserService{
	
	
	private static Logger logger = Logger.getLogger(UserServiceImpl.class.getName());
	private static final int REINTENTOS = 5;
	private static Properties props = System.getProperties();
	private Storage mpStorage = null;
	
    
	@Override
	public void addUser(UsuarioDTO usuarioDTO) throws NotLoggedInException{
		PersistenceManager pm = PMF.get();
		Usuario usuario = UsuarioBuilder.getUsuario(usuarioDTO);
		try {
			pm.makePersistent(usuario);
	    } finally {
	    	pm.close();
	    }
	}

	@Override
	public UsuarioDTO editUser(UsuarioDTO usuarioOriginal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeUser(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<UsuarioDTO> getUsuarios() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UsuarioDTO getUsuario(String username) {
		PersistenceManager pm = PMF.get();
		Usuario user = pm.getObjectById(Usuario.class, username);
		return UsuarioBuilder.getUsuarioDTO(user);
	}

}

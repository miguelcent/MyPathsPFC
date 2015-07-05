package mcm.projects.mypaths.server;

import javax.jdo.PersistenceManager;

import mcm.projects.mypaths.client.service.LoginService;
import mcm.projects.mypaths.server.domain.Usuario;
import mcm.projects.mypaths.shared.NotLoggedInException;
import mcm.projects.mypaths.shared.builder.UsuarioBuilder;
import mcm.projects.mypaths.shared.dto.UsuarioDTO;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class LoginServiceImpl extends RemoteServiceServlet implements
		LoginService {
	public UsuarioDTO loggedInUser = new UsuarioDTO();
	@Override
	public UsuarioDTO getLoggedInUserDTO(String loggedUsername) {	    
	    if(loggedUsername==null || loggedUsername==""){
	    	Window.alert("Error: Usuario no logado");
	    } else {
	    	PersistenceManager pm = PMF.get();
			Usuario user = pm.getObjectById(Usuario.class, loggedUsername);
			loggedInUser = UsuarioBuilder.getUsuarioDTO(user);
	    }
		
		return loggedInUser;
	}

	@Override
	public Boolean logout(String loggedUsername) throws NotLoggedInException {
		Boolean ret = false;
		if(!(loggedUsername == null || loggedUsername.equals(""))){
			ret = true;
		}
		return ret;
	}

}

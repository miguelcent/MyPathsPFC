package mcm.projects.mypaths.server;

import mcm.projects.mypaths.client.service.LoginService;
import mcm.projects.mypaths.server.dao.UsuarioDao;
import mcm.projects.mypaths.shared.NotLoggedInException;
import mcm.projects.mypaths.shared.dto.UsuarioDTO;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class LoginServiceImpl extends RemoteServiceServlet implements
		LoginService {
	public UsuarioDTO loggedInUser = new UsuarioDTO();

	@Override
	public UsuarioDTO getLoggedInUserDTO(String loggedUsername) {
		UsuarioDao dao = new UsuarioDao();
		loggedInUser = dao.get(loggedUsername);

		return loggedInUser;
	}

	@Override
	public Boolean logout(String loggedUsername) throws NotLoggedInException {
		UsuarioDao dao = new UsuarioDao();
		return dao.logOut(loggedUsername);
	}

}

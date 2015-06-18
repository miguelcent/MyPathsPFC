package mcm.projects.mypaths.server;

import javax.servlet.http.HttpSession;

import mcm.projects.mypaths.client.service.LoginService;
import mcm.projects.mypaths.server.domain.Usuario;
import mcm.projects.mypaths.shared.NotLoggedInException;
import mcm.projects.mypaths.shared.dto.UsuarioDTO;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class LoginServiceImpl extends RemoteServiceServlet implements
		LoginService {

	@Override
	public UsuarioDTO getLoggedInUserDTO() {
		UsuarioDTO user;
		HttpSession session = getThreadLocalRequest().getSession();
		Usuario u = LoginHelper.getLoggedInUser(session, null);
	    if (u == null)
	      return null;
	    user = Usuario.toDTO(u);
	    return user;
	}

	@Override
	public void logout() throws NotLoggedInException {
		getThreadLocalRequest().getSession().invalidate();
		throw new NotLoggedInException("Logged out");
	}

}

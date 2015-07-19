package mcm.projects.mypaths.client.service;

import mcm.projects.mypaths.shared.NotLoggedInException;
import mcm.projects.mypaths.shared.dto.Usuario;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("loginservice")
public interface LoginService extends RemoteService {

  Usuario getLoggedInUserDTO(String loggedUsername);
  Boolean logout(String loggedUsername) throws NotLoggedInException;
}

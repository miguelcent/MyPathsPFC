package mcm.projects.mypaths.client.service;

import mcm.projects.mypaths.shared.dto.UsuarioDTO;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface LoginServiceAsync {

  public void getLoggedInUserDTO(String loggedUsername, AsyncCallback<UsuarioDTO> callback);

  public void logout(String loggedUsername, AsyncCallback<Boolean> callback);

}

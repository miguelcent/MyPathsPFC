package mcm.projects.mypaths.client.service;

import mcm.projects.mypaths.shared.dto.Usuario;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface LoginServiceAsync {

  public void getLoggedInUserDTO(String loggedUsername, AsyncCallback<Usuario> callback);

  public void logout(String loggedUsername, AsyncCallback<Boolean> callback);

}

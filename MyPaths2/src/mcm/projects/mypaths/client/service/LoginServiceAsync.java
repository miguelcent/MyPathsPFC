package mcm.projects.mypaths.client.service;

import mcm.projects.mypaths.shared.dto.UsuarioDTO;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface LoginServiceAsync {

  void getLoggedInUserDTO(AsyncCallback<UsuarioDTO> callback);

  void logout(AsyncCallback<Void> callback);

}

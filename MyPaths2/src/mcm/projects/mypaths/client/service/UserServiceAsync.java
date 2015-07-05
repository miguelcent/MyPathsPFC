package mcm.projects.mypaths.client.service;

import java.util.List;

import mcm.projects.mypaths.shared.dto.UsuarioDTO;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface UserServiceAsync {
	public void addUser(UsuarioDTO usuario, AsyncCallback<Void> async);
	public void editUser(UsuarioDTO usuarioOriginal, AsyncCallback<UsuarioDTO> usuarioEditado);
	public void removeUser(String idUsuario, AsyncCallback<Void> async);
	public void getUsuarios(AsyncCallback<List<UsuarioDTO>> usuarios);
	public void getUsuario(String username, AsyncCallback<UsuarioDTO> usuario);
}

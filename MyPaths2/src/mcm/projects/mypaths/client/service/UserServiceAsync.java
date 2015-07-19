package mcm.projects.mypaths.client.service;

import java.util.List;

import mcm.projects.mypaths.shared.dto.UsuarioDTO;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface UserServiceAsync {
	public void add(UsuarioDTO usuario, AsyncCallback<Void> async);
	public void edit(UsuarioDTO usuarioOriginal, AsyncCallback<UsuarioDTO> usuarioEditado);
	public void remove(String idUsuario, AsyncCallback<Void> async);
	public void getUsuarios(AsyncCallback<List<UsuarioDTO>> usuarios);
	public void get(String username, AsyncCallback<UsuarioDTO> usuario);
}

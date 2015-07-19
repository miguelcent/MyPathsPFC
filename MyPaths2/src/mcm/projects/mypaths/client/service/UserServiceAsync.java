package mcm.projects.mypaths.client.service;

import java.util.List;

import mcm.projects.mypaths.shared.dto.Usuario;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface UserServiceAsync {
	public void add(Usuario usuario, AsyncCallback<Void> async);
	public void edit(Usuario usuarioOriginal, AsyncCallback<Usuario> usuarioEditado);
	public void remove(String idUsuario, AsyncCallback<Void> async);
	public void getUsuarios(AsyncCallback<List<Usuario>> usuarios);
	public void get(String username, AsyncCallback<Usuario> usuario);
}

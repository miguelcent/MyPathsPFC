package mcm.projects.mypaths.client.service;

import java.util.List;

import mcm.projects.mypaths.shared.dto.RutaDTO;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface RutaServiceAsync {
	public void add(RutaDTO usuario, AsyncCallback<String> rutaKey);
	public void edit(RutaDTO usuarioOriginal, AsyncCallback<RutaDTO> rutaEditada);
	public void remove(String idUsuario, AsyncCallback<Void> async);
	public void getRutas(AsyncCallback<List<RutaDTO>> rutas);
	public void get(String username, AsyncCallback<RutaDTO> rutas);
	public void getRutasUsuario(String userId, AsyncCallback<List<RutaDTO>> rutas);
}

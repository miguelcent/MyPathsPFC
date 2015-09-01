package mcm.projects.mypaths.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;

import mcm.projects.mypaths.shared.dto.ComentarioDTO;
import mcm.projects.mypaths.shared.dto.RutaDTO;

public interface ComentarioServiceAsync {
	public void comentarRuta(ComentarioDTO com, AsyncCallback<Void> callback);
}

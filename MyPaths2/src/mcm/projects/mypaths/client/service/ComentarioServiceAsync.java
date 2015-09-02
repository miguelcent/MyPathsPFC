package mcm.projects.mypaths.client.service;

import mcm.projects.mypaths.shared.dto.ComentarioDTO;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ComentarioServiceAsync {
	public void comentarRuta(ComentarioDTO com, AsyncCallback<Void> callback);
}

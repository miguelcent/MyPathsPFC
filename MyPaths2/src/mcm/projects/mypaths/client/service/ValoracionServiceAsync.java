package mcm.projects.mypaths.client.service;

import mcm.projects.mypaths.shared.dto.RutaDTO;
import mcm.projects.mypaths.shared.dto.ValoracionDTO;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ValoracionServiceAsync {
	public void addValoracion(ValoracionDTO val, AsyncCallback<Void> callback);
	public void getUltimaValoracionRuta(RutaDTO ruta, AsyncCallback<ValoracionDTO> callback);
}

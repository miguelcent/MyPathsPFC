package mcm.projects.mypaths.client.service;

import mcm.projects.mypaths.shared.dto.RutaDTO;
import mcm.projects.mypaths.shared.dto.ValoracionDTO;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("valoracionservice")
public interface ValoracionService extends RemoteService {
	void addValoracion(ValoracionDTO val);
	ValoracionDTO getUltimaValoracionRuta(RutaDTO ruta);
}

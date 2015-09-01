package mcm.projects.mypaths.server;

import mcm.projects.mypaths.client.service.ValoracionService;
import mcm.projects.mypaths.server.dao.ValoracionDao;
import mcm.projects.mypaths.shared.dto.RutaDTO;
import mcm.projects.mypaths.shared.dto.ValoracionDTO;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class ValoracionServiceImpl extends RemoteServiceServlet implements
		ValoracionService {

	@Override
	public void addValoracion(ValoracionDTO val) {
		ValoracionDao dao = new ValoracionDao();
		dao.add(val);
	}
//TODO pendiente de terminar
	@Override
	public ValoracionDTO getUltimaValoracionRuta(RutaDTO ruta) {
		ValoracionDao dao = new ValoracionDao();
		dao.getMaxCuentaValoracion(ruta.getKey());
		return null;
	}

}

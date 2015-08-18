package mcm.projects.mypaths.server;

import java.util.List;

import mcm.projects.mypaths.client.service.RutaService;
import mcm.projects.mypaths.server.dao.RutaDao;
import mcm.projects.mypaths.shared.NotLoggedInException;
import mcm.projects.mypaths.shared.dto.RutaDTO;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class RutaServiceImpl extends RemoteServiceServlet implements RutaService{

	@Override
	public void add(RutaDTO ruta) throws NotLoggedInException {
		RutaDao dao = new RutaDao();
		dao.add(ruta);
	}

	@Override
	public RutaDTO edit(RutaDTO rutaOriginal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<RutaDTO> getRutas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RutaDTO get(String rutaKey) {
		RutaDao dao = new RutaDao();
		RutaDTO ruta = dao.get(rutaKey);
		return ruta;
	}

}

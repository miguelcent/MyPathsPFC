package mcm.projects.mypaths.server;

import java.util.List;

import mcm.projects.mypaths.client.service.RutaService;
import mcm.projects.mypaths.server.dao.RutaDao;
import mcm.projects.mypaths.shared.NotLoggedInException;
import mcm.projects.mypaths.shared.dto.RutaDTO;

import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class RutaServiceImpl extends RemoteServiceServlet implements RutaService{

	@Override
	public String add(RutaDTO ruta) throws NotLoggedInException {
		RutaDao dao = new RutaDao();
		String k = "hola";
		try {
			k = dao.add(ruta);
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return k;
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

	@Override
	public List<RutaDTO> getRutasUsuario(String userId) {
		RutaDao dao = new RutaDao();
		List<RutaDTO> rutas = dao.getRutasUsuario(userId);
		return rutas;
	}

}

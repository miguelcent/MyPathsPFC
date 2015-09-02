package mcm.projects.mypaths.server;

import mcm.projects.mypaths.client.service.ComentarioService;
import mcm.projects.mypaths.server.dao.ComentarioDao;
import mcm.projects.mypaths.shared.dto.ComentarioDTO;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class ComentarioServiceImpl extends RemoteServiceServlet implements
		ComentarioService {

	@Override
	public void comentarRuta(ComentarioDTO com) {
		ComentarioDao dao = new ComentarioDao();
		dao.add(com);
	}

}

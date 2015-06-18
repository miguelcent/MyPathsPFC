package mcm.projects.mypaths.server;

import java.util.Date;
import java.util.logging.Logger;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import mcm.projects.mypaths.server.domain.Usuario;
import mcm.projects.mypaths.server.utils.ServletHelper;
import mcm.projects.mypaths.server.utils.ServletUtils;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class LoginHelper extends RemoteServiceServlet {

	private static final long serialVersionUID = 8523775754657727824L;

	private static Logger logger = Logger
			.getLogger(LoginHelper.class.getName());
	private static final int NUM_RETRIES = 5;

	static public String getApplitionURL(HttpServletRequest request) {

		if (ServletHelper.isDevelopment(request)) {
			return "http://127.0.0.1:8888/ConnectrApp.html?gwt.codesvr=127.0.0.1:9997";
		} else {
			return ServletUtils.getBaseUrl(request);
		}

	}

	static public Usuario getLoggedInUser(HttpSession session,
			PersistenceManager pm) {
		
		boolean localPM = false;
		
		if (session == null)
			return null; // user not logged in

		String userId = (String) session.getAttribute("userId");
		if (userId == null)
			return null; // user not logged in

		Long id = Long.parseLong(userId.trim());

		if (pm == null) {
			// then create local pm
			pm = PMF.get().getPersistenceManager();
			localPM = true;
		}

		String query = "select from " + Usuario.class.getName()
				+ " where id == :userId";
		Query q = pm.newQuery(query);
		q.setUnique(true);

		try {
			Usuario u = (Usuario) q.execute(id);
			u.setUltimoLogin(new Date());
			return u;
		} finally {
			if (localPM) {
				pm.close();
			}
		}

	}

}

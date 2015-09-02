package mcm.projects.mypaths.server.dao;

import static org.easymock.EasyMock.createStrictMock;

import java.util.Date;

import junit.framework.TestCase;
import mcm.projects.mypaths.client.presenter.RegistroPresenter;
import mcm.projects.mypaths.client.service.UserServiceAsync;
import mcm.projects.mypaths.shared.dto.UsuarioDTO;

import org.junit.Test;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.gwt.event.shared.SimpleEventBus;

public class UsuarioDaoTest extends TestCase {

	@SuppressWarnings("unused")
	private RegistroPresenter registroPresenter;
	private UserServiceAsync mockRpcService;
	private SimpleEventBus eventBus;
	private RegistroPresenter.Display mockDisplay;
	private UsuarioDTO usuarioMock;
	private UsuarioDao userDaoMock;

	protected void setUp() {
		mockRpcService = createStrictMock(UserServiceAsync.class);
		eventBus = new SimpleEventBus();
		mockDisplay = createStrictMock(RegistroPresenter.Display.class);
		registroPresenter = new RegistroPresenter(mockRpcService, eventBus,
				mockDisplay);
		usuarioMock = new UsuarioDTO();
		userDaoMock = new UsuarioDao();
	}

	@Test
	public void testDaoAdd() {
		usuarioMock.setApellidos("Paquito");
		usuarioMock.setCiudad("Sevilla");
		usuarioMock.setCodigo_postal("41007");
		usuarioMock.setEmail("miguelcent@gmail.com");
		usuarioMock.setFechaIngreso(new Date());
		Key k = KeyFactory.createKey("Usuario", "paco");
		usuarioMock.setKey(KeyFactory.keyToString(k));
		usuarioMock.setLogin("paco");
		usuarioMock.setNombre("Paco");
		usuarioMock.setPais("España");
		usuarioMock.setPassword("uefacup12");
		usuarioMock.setUltimoLogin(new Date());
		usuarioMock.setUltimoLogout(new Date());

		userDaoMock.add(usuarioMock);
	}

}

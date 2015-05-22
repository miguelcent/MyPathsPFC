/**
 * 
 */
package mcm.projects.mypaths.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import mcm.projects.mypaths.client.event.LoginEvent;
import mcm.projects.mypaths.client.helper.RPCCall;
import mcm.projects.mypaths.client.presenter.BusquedaPresenter;
import mcm.projects.mypaths.client.presenter.LoginPresenter;
import mcm.projects.mypaths.client.presenter.MenuPresenter;
import mcm.projects.mypaths.client.service.LoginService;
import mcm.projects.mypaths.client.service.LoginServiceAsync;
import mcm.projects.mypaths.client.view.BusquedaView;
import mcm.projects.mypaths.client.view.LoginView;
import mcm.projects.mypaths.client.view.MenuView;
import mcm.projects.mypaths.shared.dto.UsuarioDTO;

/**
 * @author Miguel
 *
 */
public class MyPathsApp implements EntryPoint {

	interface MyPathsAppUiBinder extends UiBinder<DockLayoutPanel, MyPathsApp> {
	}

	@UiField
	CabeceraPanel panelCabecera;
	@UiField
	VerticalPanel panelPrincipal;

	DockLayoutPanel outer = new DockLayoutPanel(Unit.EM);

	RootLayoutPanel root;

	private static MyPathsApp singleton;
	// TODO Inicializamos usuarioActual a null temporalmente hasta desarrollar
	// el
	// servicio de usuarios.
	private UsuarioDTO usuarioActual = null;
	private SimpleEventBus eventBus = new SimpleEventBus();
	// Presenters
	private MenuPresenter menuPresenter;
	private BusquedaPresenter busquedaPresenter;

	// RPC services
	private LoginServiceAsync loginService = GWT.create(LoginService.class);;

	/**
	 * Devuelve la instancia singleton de la aplicacion
	 */
	public static MyPathsApp get() {
		return singleton;
	}

	private static final MyPathsAppUiBinder binder = GWT
			.create(MyPathsAppUiBinder.class);

	@Override
	public void onModuleLoad() {
		singleton = this;
	    getLoggedInUser();

//		init();
	}
	
	 private void getLoggedInUser() {
		    new RPCCall<UsuarioDTO>() {
		      @Override protected void callService(AsyncCallback<UsuarioDTO> cb) {
		        loginService.getLoggedInUserDTO(cb);
		      }

		      @Override public void onSuccess(UsuarioDTO loggedInUserDTO) {
		        if (loggedInUserDTO == null) {
		          // nobody is logged in
		          init();
		        } else {
		          // user is logged in
		          setUsuarioActual(loggedInUserDTO);
		          createUI();
		        }
		      }

		      @Override public void onFailure(Throwable caught) {
		        Window.alert("Error: " + caught.getMessage());
		      }
		    }.retry(3);

		  }
	 private void createUI() {

		    GWT.runAsync(new RunAsyncCallback() {
		      @Override public void onFailure(Throwable reason) {
		        Window.alert("Code download error: " + reason.getMessage());
		      }

		      @Override public void onSuccess() {
		        goAfterLogin();
		        eventBus.fireEvent(new LoginEvent(usuarioActual));
		      }
		    });
		  }
//El inicio si logado seria "Mis Rutas" (pendiente en su totalidad).
	protected void goAfterLogin() {
		
		
	}

	public void init() {
//		menuPresenter = new MenuPresenter(loginService, eventBus, new MenuView());
		
		DockLayoutPanel outer = binder.createAndBindUi(this);
//		menuPresenter.go(panelCabecera.menuCabecera);
//		busquedaPresenter = new BusquedaPresenter(loginService, eventBus, new BusquedaView());
//		busquedaPresenter.go(panelPrincipal);
		root = RootLayoutPanel.get();
		root.clear();
		root.add(outer);
		
		AppController appViewer = new AppController(loginService, eventBus);
	    appViewer.go();
	    
	    
	}

	public SimpleEventBus getEventBus() {
		return eventBus;
	}
	
	public UsuarioDTO getUsuarioActual() {
		return usuarioActual;
	}
	
	void setUsuarioActual(UsuarioDTO currentUser) {
		this.usuarioActual = currentUser;
	}

	public CabeceraPanel getPanelCabecera() {
		return panelCabecera;
	}

	public void setPanelCabecera(CabeceraPanel panelCabecera) {
		this.panelCabecera = panelCabecera;
	}

	public VerticalPanel getPanelPrincipal() {
		return panelPrincipal;
	}

	public void setPanelPrincipal(VerticalPanel panelPrincipal) {
		this.panelPrincipal = panelPrincipal;
	}
}

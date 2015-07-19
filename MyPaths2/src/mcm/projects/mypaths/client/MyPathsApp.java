/**
 * 
 */
package mcm.projects.mypaths.client;

import mcm.projects.mypaths.client.service.LoginService;
import mcm.projects.mypaths.client.service.LoginServiceAsync;
import mcm.projects.mypaths.shared.dto.Usuario;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

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
	private Usuario usuarioActual = new Usuario();
	private SimpleEventBus eventBus = new SimpleEventBus();
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
		init();

	}
//TODO ya se vera si hace algo diferente con session storage lleno o vacio.
//	private void getLoggedInUser() {
//		Storage storage = Storage.getSessionStorageIfSupported();
//			if(storage.getItem("currentUser")==null || storage.getItem("currentUser")==""){
//				init();
//			}else {
//				createUI();
//			}
//	}

//	private void createUI() {
//
//		GWT.runAsync(new RunAsyncCallback() {
//			@Override
//			public void onFailure(Throwable reason) {
//				Window.alert("Code download error: " + reason.getMessage());
//			}
//
//			@Override
//			public void onSuccess() {
//				eventBus.fireEvent(new LoginEvent(usuarioActual));
//			}
//		});
//	}

	public void init() {
		DockLayoutPanel outer = binder.createAndBindUi(this);
		root = RootLayoutPanel.get();
		root.clear();
		root.add(outer);
		AppController appViewer = new AppController(loginService, eventBus);
		appViewer.go();

	}

	public SimpleEventBus getEventBus() {
		return eventBus;
	}

	public Usuario getUsuarioActual() {
		return usuarioActual;
	}

	public void setUsuarioActual(Usuario currentUser) {
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

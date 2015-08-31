/**
 * 
 */
package mcm.projects.mypaths.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import mcm.projects.mypaths.client.service.CategoriaRutaService;
import mcm.projects.mypaths.client.service.CategoriaRutaServiceAsync;
import mcm.projects.mypaths.client.service.LoginService;
import mcm.projects.mypaths.client.service.LoginServiceAsync;
import mcm.projects.mypaths.client.service.UploadCategoriaRutas;
import mcm.projects.mypaths.client.service.UploadCategoriaRutasAsync;
import mcm.projects.mypaths.shared.dto.CategoriaRutaDTO;
import mcm.projects.mypaths.shared.dto.UsuarioDTO;

import com.dropbox.core.DbxAppInfo;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.DbxWebAuthNoRedirect;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
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
	@UiField
	VerticalPanel panelBuscar;

	DockLayoutPanel outer = new DockLayoutPanel(Unit.EM);

	RootLayoutPanel root;

	private static MyPathsApp singleton;
	private UsuarioDTO usuarioActual = new UsuarioDTO();
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

	public void init() {
		UploadCategoriaRutasAsync uploadCatService = GWT.create(UploadCategoriaRutas.class);
		uploadCatService.up(new AsyncCallback<Void>() {
			
			@Override
			public void onSuccess(Void result) {
				Window.alert("exito subiendo categorias");
			}
			
			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Error subiendo categorias");
				
			}
		});
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

	public UsuarioDTO getUsuarioActual() {
		return usuarioActual;
	}

	public void setUsuarioActual(UsuarioDTO currentUser) {
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
	
	public VerticalPanel getPanelBuscar() {
		return panelBuscar;
	}

	public void setPanelBuscar(VerticalPanel panelBuscar) {
		this.panelBuscar = panelBuscar;
	}
}

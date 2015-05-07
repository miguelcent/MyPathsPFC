/**
 * 
 */
package mcm.projects.mypaths.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.Widget;

import mcm.projects.mypaths.client.panels.BusquedasPnl;
import mcm.projects.mypaths.client.panels.CabeceraPanel;
import mcm.projects.mypaths.shared.dto.UsuarioDTO;

/**
 * @author Miguel
 *
 */
public class MyPathsApp implements EntryPoint {

	interface MyPathsAppUiBinder extends UiBinder<Widget, MyPathsApp> {
	}
	
	RootLayoutPanel root;

	private static MyPathsApp singleton;
//	TODO Inicializamos usuarioActual a null temporalmente hasta desarrollar el
// 	servicio de usuarios.
	private UsuarioDTO usuarioActual = null;

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
	}

	private void getLoggedInUser() {
//TODO	Pendiente creación Services y Presenters
		
//		new RPCCall<UsuarioDTO>() {
//			@Override
//			protected void callService(AsyncCallback<UsuarioDTO> cb) {
//				loginService.getLoggedInUserDTO(cb);
//			}
//
//			@Override
//			public void onSuccess(UsuarioDTO loggedInUserDTO) {
//				if (loggedInUserDTO == null) {
//					// nobody is logged in
//					showLoginView();
//				} else {
//					// user is logged in
//					setCurrentUser(usuarioActual);
//					createUI();
//				}
//			}
//
//			@Override
//			public void onFailure(Throwable caught) {
//				Window.alert("Error: " + caught.getMessage());
//			}
//		}.retry(3);

//TODO Eliminar al desarrollar metodo comentado anterior
		if (usuarioActual == null) {
			// nobody is logged in
			mostrarInicioNoLogado();
		} else {
			// user is logged in
			setUsuarioActual(usuarioActual);
			mostrarInicioLogado();
		}

	}

//TODO metodo q muestra la pantalla inicial (panel busqueda)
	private void mostrarInicioNoLogado() {
//		root = RootLayoutPanel.get();
//	    root.clear();
//	    LoginPresenter loginPresenter = new LoginPresenter(eventBus, new LoginView());
//	    loginPresenter.go(root);
		DockLayoutPanel outer = new DockLayoutPanel(Unit.EM);
		/*
		 * TODO añado panel "a pelo"
		 */
		outer.addNorth(new CabeceraPanel(), 9);
		outer.add(new BusquedasPnl());
	    root = RootLayoutPanel.get();
	    root.clear();
	    root.add(outer);
	}
	
	private void mostrarInicioLogado() {
		// TODO Auto-generated method stub
		
	}

	public UsuarioDTO getUsuarioActual() {
		return usuarioActual;
	}

	public void setUsuarioActual(UsuarioDTO usuarioActual) {
		this.usuarioActual = usuarioActual;
	}

}

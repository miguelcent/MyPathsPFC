package mcm.projects.mypaths.client;

import mcm.projects.mypaths.client.event.AddPathEvent;
import mcm.projects.mypaths.client.event.AddPathEventHandler;
import mcm.projects.mypaths.client.event.InicioEvent;
import mcm.projects.mypaths.client.event.InicioEventHandler;
import mcm.projects.mypaths.client.event.LoginEvent;
import mcm.projects.mypaths.client.event.LoginEventHandler;
import mcm.projects.mypaths.client.event.RegistroEvent;
import mcm.projects.mypaths.client.event.RegistroEventHandler;
import mcm.projects.mypaths.client.presenter.AddPathPresenter;
import mcm.projects.mypaths.client.presenter.BusquedaPresenter;
import mcm.projects.mypaths.client.presenter.LoginPresenter;
import mcm.projects.mypaths.client.presenter.MenuPresenter;
import mcm.projects.mypaths.client.presenter.Presenter;
import mcm.projects.mypaths.client.presenter.RegistroPresenter;
import mcm.projects.mypaths.client.service.LoginServiceAsync;
import mcm.projects.mypaths.client.utils.MapsUtils;
import mcm.projects.mypaths.client.view.AddPathView;
import mcm.projects.mypaths.client.view.BusquedaView;
import mcm.projects.mypaths.client.view.LoginView;
import mcm.projects.mypaths.client.view.MenuView;
import mcm.projects.mypaths.client.view.RegistroView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.History;

public class AppController implements ValueChangeHandler<String> {

	private final SimpleEventBus eventbus;
	private LoginServiceAsync loginService;
	private LoginPresenter loginPresenter;
	private RegistroPresenter registroPresenter;
	private MenuView menu;

	public AppController(LoginServiceAsync loginService, SimpleEventBus eventbus) {
		this.eventbus = eventbus;
		this.loginService = loginService;
		bind();
	}

	private void bind() {
		History.addValueChangeHandler(this);

		eventbus.addHandler(InicioEvent.TYPE, new InicioEventHandler() {

			@Override
			public void onInicio(InicioEvent event) {
				doInicio();
			}

		});

		eventbus.addHandler(LoginEvent.TYPE, new LoginEventHandler() {

			@Override
			public void onLogin(LoginEvent event) {
				doLogin();
			}

		});

		eventbus.addHandler(RegistroEvent.TYPE, new RegistroEventHandler() {
			@Override
			public void onRegistro(RegistroEvent event) {
				doRegistro();
			}
		});
		
		eventbus.addHandler(AddPathEvent.TYPE, new AddPathEventHandler() {
			@Override
			public void onAddPath(AddPathEvent event) {
				doAddPath();
			}
		});
		
	}

	protected void doRegistro() {
		History.newItem("Registro");

	}

	protected void doLogin() {
		History.newItem("Login");
	}

	protected void doInicio() {
		History.newItem("Inicio");
	}
	
	protected void doAddPath() {
		History.newItem("AddPath");
	}

	public void go() {

		if ("".equals(History.getToken())) {
			History.newItem("Inicio");
		} else {
			History.fireCurrentHistoryState();
		}
	}

	@Override
	public void onValueChange(ValueChangeEvent<String> event) {
		String token = event.getValue();
		Presenter presenter = null;
		Presenter presenter2 = null;
		if (token != null) {

			if (token.equals("Inicio")) {
				presenter = new BusquedaPresenter(loginService, eventbus,
						new BusquedaView());
				presenter.go(MyPathsApp.get().getPanelPrincipal());
				// TODO en cada caso, si MyPaths.get().getUsuarioActual()!=null
				// y History.getToken().equals(X). hacemos Y
				if (MyPathsApp.get().getUsuarioActual() == null) {
					menu = new MenuView();
					menu.getMenuBar().removeItem(menu.getBuscarLink());
					menu.getMenuBar().removeItem(menu.getAddPathLink());
					menu.getMenuBar().removeItem(menu.getCerrarSesionLink());
					menu.getMenuBar().removeItem(menu.getPerfilLink());
				} else {
					menu = new MenuView();
					menu.getMenuBar().removeItem(menu.getBuscarLink());
					menu.getMenuBar().removeItem(menu.getLoginLink());
					menu.getMenuBar().removeItem(menu.getRegistroLink());
				}
				presenter2 = new MenuPresenter(loginService, eventbus, menu);
				presenter2.go(MyPathsApp.get().getPanelCabecera()
						.getMenuCabecera());
			} else if (token.equals("Login")) {
				presenter = getLoginPresenter();
				presenter.go(MyPathsApp.get().getPanelPrincipal());
				if (MyPathsApp.get().getUsuarioActual() == null) {
					menu = new MenuView();
					menu.getMenuBar().removeItem(menu.getBuscarLink());
					menu.getMenuBar().removeItem(menu.getAddPathLink());
					menu.getMenuBar().removeItem(menu.getCerrarSesionLink());
					menu.getMenuBar().removeItem(menu.getPerfilLink());
					menu.getMenuBar().removeItem(menu.getLoginLink());
				} else {
					menu = new MenuView();
					menu.getMenuBar().removeItem(menu.getBuscarLink());
					menu.getMenuBar().removeItem(menu.getLoginLink());
					menu.getMenuBar().removeItem(menu.getRegistroLink());
				}
				presenter2 = new MenuPresenter(loginService, eventbus, menu);
				presenter2.go(MyPathsApp.get().getPanelCabecera()
						.getMenuCabecera());
				return;
			} else if (token.equals("Registro")) {
				presenter = new RegistroPresenter(loginService, eventbus,
						new RegistroView());
				presenter.go(MyPathsApp.get().getPanelPrincipal());
				if (MyPathsApp.get().getUsuarioActual() == null) {
					menu = new MenuView();
					menu.getMenuBar().removeItem(menu.getBuscarLink());
					menu.getMenuBar().removeItem(menu.getAddPathLink());
					menu.getMenuBar().removeItem(menu.getCerrarSesionLink());
					menu.getMenuBar().removeItem(menu.getPerfilLink());
					menu.getMenuBar().removeItem(menu.getRegistroLink());
				} else {
					menu = new MenuView();
					menu.getMenuBar().removeItem(menu.getBuscarLink());
					menu.getMenuBar().removeItem(menu.getRegistroLink());
					menu.getMenuBar().removeItem(menu.getRegistroLink());
				}
				presenter2 = new MenuPresenter(loginService, eventbus, menu);
				presenter2.go(MyPathsApp.get().getPanelCabecera()
						.getMenuCabecera());
				return;
			}else if (token.equals("AddPath")) {
				AddPathView vista = new AddPathView();
				presenter = new AddPathPresenter(loginService, eventbus,
						vista);
				presenter.go(MyPathsApp.get().getPanelPrincipal());
				MapsUtils.pintarMapaDefecto(vista);
				if (MyPathsApp.get().getUsuarioActual() == null) {
					menu = new MenuView();
					menu.getMenuBar().removeItem(menu.getBuscarLink());
					menu.getMenuBar().removeItem(menu.getAddPathLink());
					menu.getMenuBar().removeItem(menu.getCerrarSesionLink());
					menu.getMenuBar().removeItem(menu.getPerfilLink());
					menu.getMenuBar().removeItem(menu.getRegistroLink());
				} else {
					menu = new MenuView();
					menu.getMenuBar().removeItem(menu.getBuscarLink());
					menu.getMenuBar().removeItem(menu.getRegistroLink());
					menu.getMenuBar().removeItem(menu.getRegistroLink());
				}
				presenter2 = new MenuPresenter(loginService, eventbus, menu);
				presenter2.go(MyPathsApp.get().getPanelCabecera()
						.getMenuCabecera());
				return;
			}

		}
	}


	private LoginPresenter getLoginPresenter() {
		if (loginPresenter == null) {
			GWT.log("AppController: Creando LoginPresenter");
			loginPresenter = new LoginPresenter(loginService, eventbus,
					new LoginView());
		}
		return loginPresenter;
	}

}

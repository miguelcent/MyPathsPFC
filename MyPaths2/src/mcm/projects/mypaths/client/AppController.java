package mcm.projects.mypaths.client;

import mcm.projects.mypaths.client.event.AddPathEvent;
import mcm.projects.mypaths.client.event.AddPathEventHandler;
import mcm.projects.mypaths.client.event.EditProfileEvent;
import mcm.projects.mypaths.client.event.EditProfileEventHandler;
import mcm.projects.mypaths.client.event.InicioEvent;
import mcm.projects.mypaths.client.event.InicioEventHandler;
import mcm.projects.mypaths.client.event.LoginEvent;
import mcm.projects.mypaths.client.event.LoginEventHandler;
import mcm.projects.mypaths.client.event.LogoutEvent;
import mcm.projects.mypaths.client.event.LogoutEventHandler;
import mcm.projects.mypaths.client.event.RegistroEvent;
import mcm.projects.mypaths.client.event.RegistroEventHandler;
import mcm.projects.mypaths.client.presenter.AddPathPresenter;
import mcm.projects.mypaths.client.presenter.BusquedaPresenter;
import mcm.projects.mypaths.client.presenter.EditProfilePresenter;
import mcm.projects.mypaths.client.presenter.LoginPresenter;
import mcm.projects.mypaths.client.presenter.MenuPresenter;
import mcm.projects.mypaths.client.presenter.Presenter;
import mcm.projects.mypaths.client.presenter.RegistroPresenter;
import mcm.projects.mypaths.client.service.LoginServiceAsync;
import mcm.projects.mypaths.client.service.UserService;
import mcm.projects.mypaths.client.service.UserServiceAsync;
import mcm.projects.mypaths.client.utils.MapsUtils;
import mcm.projects.mypaths.client.utils.MenuUtil;
import mcm.projects.mypaths.client.view.AddPathView;
import mcm.projects.mypaths.client.view.BusquedaView;
import mcm.projects.mypaths.client.view.EditProfileView;
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
	private MenuView menuView;
	

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
		
		eventbus.addHandler(EditProfileEvent.TYPE, new EditProfileEventHandler() {
			@Override
			public void onEditProfile(EditProfileEvent event) {
				doEditProfile();
			}
		});
		
		eventbus.addHandler(LogoutEvent.TYPE, new LogoutEventHandler() {
			
			@Override
			public void onLogout(LogoutEvent event) {
				doLogout();
			}
		});
		
	}

	protected void doLogout() {
		History.newItem("Logout");
		History.newItem("Inicio");
	}

	protected void doEditProfile() {
		History.newItem("Perfil");
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
				menuView = MenuUtil.getMenu(token);				
				presenter2 = new MenuPresenter(loginService, eventbus, menuView);
				presenter2.go(MyPathsApp.get().getPanelCabecera()
						.getMenuCabecera());
			} else if (token.equals("Login")) {
				presenter = getLoginPresenter();
				presenter.go(MyPathsApp.get().getPanelPrincipal());
				menuView = MenuUtil.getMenu(token);		
				
				presenter2 = new MenuPresenter(loginService, eventbus, menuView);
				presenter2.go(MyPathsApp.get().getPanelCabecera()
						.getMenuCabecera());
				return;
			} else if (token.equals("Registro")) {
				UserServiceAsync userservice = GWT.create(UserService.class);
				presenter = new RegistroPresenter(userservice, eventbus,
						new RegistroView());
				presenter.go(MyPathsApp.get().getPanelPrincipal());
				menuView = MenuUtil.getMenu(token);
				presenter2 = new MenuPresenter(loginService, eventbus, menuView);
				presenter2.go(MyPathsApp.get().getPanelCabecera()
						.getMenuCabecera());
				return;
			}else if (token.equals("AddPath")) {
				AddPathView vista = new AddPathView();
				presenter = new AddPathPresenter(loginService, eventbus,
						vista);
				presenter.go(MyPathsApp.get().getPanelPrincipal());
				
				MapsUtils.pintarMapaDefecto(vista);
				menuView = MenuUtil.getMenu(token);
				presenter2 = new MenuPresenter(loginService, eventbus, menuView);
				presenter2.go(MyPathsApp.get().getPanelCabecera()
						.getMenuCabecera());
				return;
			}else if (token.equals("Perfil")) {
				EditProfileView vista = new EditProfileView();
				presenter = new EditProfilePresenter(loginService, vista,
						eventbus);
				presenter.go(MyPathsApp.get().getPanelPrincipal());
				menuView = MenuUtil.getMenu(token);
				presenter2 = new MenuPresenter(loginService, eventbus, menuView);
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

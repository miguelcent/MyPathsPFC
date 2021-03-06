package mcm.projects.mypaths.client;


import mcm.projects.mypaths.client.event.AddPathEvent;
import mcm.projects.mypaths.client.event.AddPathEventHandler;
import mcm.projects.mypaths.client.event.ComentarRutaEvent;
import mcm.projects.mypaths.client.event.ComentarRutaEventHandler;
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
import mcm.projects.mypaths.client.event.ValorarRutaEvent;
import mcm.projects.mypaths.client.event.ValorarRutaEventHandler;
import mcm.projects.mypaths.client.event.ViewRutaEvent;
import mcm.projects.mypaths.client.event.ViewRutaEventHandler;
import mcm.projects.mypaths.client.presenter.AddPathPresenter;
import mcm.projects.mypaths.client.presenter.BusquedaPresenter;
import mcm.projects.mypaths.client.presenter.ComentarRutaPopUpPresenter;
import mcm.projects.mypaths.client.presenter.EditProfilePresenter;
import mcm.projects.mypaths.client.presenter.ListaRutasPresenter;
import mcm.projects.mypaths.client.presenter.LoginPresenter;
import mcm.projects.mypaths.client.presenter.MenuPresenter;
import mcm.projects.mypaths.client.presenter.Presenter;
import mcm.projects.mypaths.client.presenter.RegistroPresenter;
import mcm.projects.mypaths.client.presenter.ValorarRutaPopUpPresenter;
import mcm.projects.mypaths.client.presenter.VerRutaPresenter;
import mcm.projects.mypaths.client.service.ComentarioService;
import mcm.projects.mypaths.client.service.ComentarioServiceAsync;
import mcm.projects.mypaths.client.service.LoginServiceAsync;
import mcm.projects.mypaths.client.service.MapaService;
import mcm.projects.mypaths.client.service.MapaServiceAsync;
import mcm.projects.mypaths.client.service.UserService;
import mcm.projects.mypaths.client.service.UserServiceAsync;
import mcm.projects.mypaths.client.service.ValoracionService;
import mcm.projects.mypaths.client.service.ValoracionServiceAsync;
import mcm.projects.mypaths.client.utils.MenuUtil;
import mcm.projects.mypaths.client.view.AddPathView;
import mcm.projects.mypaths.client.view.BusquedaView;
import mcm.projects.mypaths.client.view.ComentarRutaPopUpView;
import mcm.projects.mypaths.client.view.EditProfileView;
import mcm.projects.mypaths.client.view.LoginView;
import mcm.projects.mypaths.client.view.MenuView;
import mcm.projects.mypaths.client.view.RegistroView;
import mcm.projects.mypaths.client.view.ValorarRutaPopUpView;
import mcm.projects.mypaths.client.view.VerRutaView;
import mcm.projects.mypaths.client.view.widgets.ListaRutasWidget;
import mcm.projects.mypaths.shared.dto.RutaDTO;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.ScrollPanel;

public class AppController implements ValueChangeHandler<String> {

	private final SimpleEventBus eventbus;
	private LoginServiceAsync loginService;
	private LoginPresenter loginPresenter;
	private RutaDTO rutaDTO;
	private MenuView menuView;
	
	public RutaDTO rutita = new RutaDTO();

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

		eventbus.addHandler(EditProfileEvent.TYPE,
				new EditProfileEventHandler() {
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
		
		eventbus.addHandler(ViewRutaEvent.TYPE, new ViewRutaEventHandler() {
			
			@Override
			public void onViewRuta(ViewRutaEvent viewRutaEvent) {
				setRutaDTO(viewRutaEvent.getRuta());
				doVerRuta();
			}
		});
		
		eventbus.addHandler(ValorarRutaEvent.TYPE, new ValorarRutaEventHandler() {
			
			@Override
			public void onValorarRuta(ValorarRutaEvent event) {
				PopupPanel popup = new PopupPanel(true, true);
				ValoracionServiceAsync valServ = GWT.create(ValoracionService.class);
				ValorarRutaPopUpPresenter valPopPresenter = new ValorarRutaPopUpPresenter(valServ, eventbus, new ValorarRutaPopUpView(), event.getRuta());
				valPopPresenter.go(popup);
				popup.setGlassEnabled(true);
				popup.center();
			}
		});
		
		eventbus.addHandler(ComentarRutaEvent.TYPE, new ComentarRutaEventHandler() {		
			@Override
			public void onComentarRuta(ComentarRutaEvent comentarRutaEvent) {
				PopupPanel popup = new PopupPanel(true, true);
				ComentarioServiceAsync comServ = GWT.create(ComentarioService.class);
				ComentarRutaPopUpPresenter comPresenter = new ComentarRutaPopUpPresenter(comServ, eventbus, new ComentarRutaPopUpView(), comentarRutaEvent.getRuta());
				comPresenter.go(popup);
				popup.setGlassEnabled(true);
				popup.center();
			}
		});
		

	}
	
	protected void doValorarRuta() {
		History.newItem("ValorarRuta");
	}

	protected void doVerRuta() {
		History.newItem("VerRuta");
	}

	protected void doPruebaRutaItem() {
		History.newItem("PruebaRutaItem");
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
		Presenter presenter3 = null;

		if (token != null) {

			if (token.equals("Inicio")) {
				MyPathsApp.get().getPanelPrincipal().clear();
				BusquedaPresenter presenterBusquedas = new BusquedaPresenter(loginService, eventbus,
						new BusquedaView());
				presenterBusquedas.go(MyPathsApp.get().getPanelBuscar());
				
				ListaRutasPresenter rutasUsuario = new ListaRutasPresenter(loginService, eventbus, new ListaRutasWidget());
				rutasUsuario.go(MyPathsApp.get().getPanelPrincipal());
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
				MyPathsApp.get().getPanelBuscar().clear();
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
				MyPathsApp.get().getPanelBuscar().clear();
				return;
			} else if (token.equals("AddPath")) {
				AddPathView vista = new AddPathView();
				presenter = new AddPathPresenter(loginService, eventbus, vista);
				presenter.go(MyPathsApp.get().getPanelPrincipal());
				menuView = MenuUtil.getMenu(token);
				presenter2 = new MenuPresenter(loginService, eventbus, menuView);
				presenter2.go(MyPathsApp.get().getPanelCabecera()
						.getMenuCabecera());
				MyPathsApp.get().getPanelBuscar().clear();
				return;
			} else if (token.equals("Perfil")) {
				EditProfileView vista = new EditProfileView();
				presenter = new EditProfilePresenter(loginService, vista,
						eventbus);
				presenter.go(MyPathsApp.get().getPanelPrincipal());
				menuView = MenuUtil.getMenu(token);
				presenter2 = new MenuPresenter(loginService, eventbus, menuView);
				presenter2.go(MyPathsApp.get().getPanelCabecera()
						.getMenuCabecera());
				MyPathsApp.get().getPanelBuscar().clear();
				return;
//			} else if (token.equals("PruebaRutaItem")) {
//				RutaWidget vista = new RutaWidget();
//				RutaWidget vista2 = new RutaWidget();
//				RutaWidget vista3 = new RutaWidget();
//				MyPathsApp.get().getPanelPrincipal().clear();
//				Label l = new Label("B�squeda de Rutas");
//				Label l2 = new Label("Ordenar por:   ");
//				CheckBox cb1 = new CheckBox("Categoria");
//				CheckBox cb2 = new CheckBox("Nombre de ruta");
//				VerticalPanel vp = new VerticalPanel();
//				HorizontalPanel hp = new HorizontalPanel();
//				hp.add(l2);
//				hp.add(cb1);
//				hp.add(cb2);
//				vp.add(l);
//				vp.add(hp);
//				DecoratorPanel dp = new DecoratorPanel();
//				dp.add(vp);
//				MyPathsApp.get().getPanelPrincipal().add(dp);
//				RutaServiceAsync rs = GWT.create(RutaService.class);
//				presenter = new RutaWidgetPresenter("agtzfm15cGFodHMyMHIRCxIEUnV0YRiAgICAnfmeCQw", rs, eventbus, vista);
//				presenter.addIn(MyPathsApp.get().getPanelPrincipal());
//				presenter4 = new RutaWidgetPresenter("agtzfm15cGFodHMyMHIRCxIEUnV0YRiAgICA67iPCQw", rs, eventbus, vista2);
//				presenter4.addIn(MyPathsApp.get().getPanelPrincipal());
//				presenter5 = new RutaWidgetPresenter("agtzfm15cGFodHMyMHIRCxIEUnV0YRiAgICA3s_NCAw", rs, eventbus, vista3);
//				presenter5.addIn(MyPathsApp.get().getPanelPrincipal());
//				presenter2 = new MenuPresenter(loginService, eventbus, menuView);
//				presenter2.go(MyPathsApp.get().getPanelCabecera()
//						.getMenuCabecera());
//				presenter3 = new BusquedaPresenter(loginService, eventbus,
//						new BusquedaView());
//				presenter3.go(MyPathsApp.get().getPanelBuscar());
//				return;
			} else if (token.equals("VerRuta")) {
//				Window.alert(getRutaDTO().getNombre());
				VerRutaView vista = new VerRutaView();
				MapaServiceAsync mapaService = GWT.create(MapaService.class);
				presenter = new VerRutaPresenter(mapaService, eventbus, vista, getRutaDTO());
				presenter.go(MyPathsApp.get().getPanelPrincipal());
				menuView = MenuUtil.getMenu(token);
				presenter2 = new MenuPresenter(loginService, eventbus, menuView);
				presenter2.go(MyPathsApp.get().getPanelCabecera()
						.getMenuCabecera());
				presenter3 = new BusquedaPresenter(loginService, eventbus,
						new BusquedaView());
				presenter3.go(MyPathsApp.get().getPanelBuscar());
				MyPathsApp.get().getPanelBuscar().clear();
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

	public RutaDTO getRutaDTO() {
		return rutaDTO;
	}

	public void setRutaDTO(RutaDTO rutaDTO) {
		this.rutaDTO = rutaDTO;
	}

}

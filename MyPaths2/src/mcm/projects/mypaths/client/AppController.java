package mcm.projects.mypaths.client;

import mcm.projects.mypaths.client.event.InicioEvent;
import mcm.projects.mypaths.client.event.InicioEventHandler;
import mcm.projects.mypaths.client.event.LoginEvent;
import mcm.projects.mypaths.client.event.LoginEventHandler;
import mcm.projects.mypaths.client.presenter.BusquedaPresenter;
import mcm.projects.mypaths.client.presenter.LoginPresenter;
import mcm.projects.mypaths.client.presenter.MenuPresenter;
import mcm.projects.mypaths.client.presenter.Presenter;
import mcm.projects.mypaths.client.service.LoginServiceAsync;
import mcm.projects.mypaths.client.view.BusquedaView;
import mcm.projects.mypaths.client.view.LoginView;
import mcm.projects.mypaths.client.view.MenuView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;

public class AppController implements ValueChangeHandler<String>{
	
	private final SimpleEventBus eventbus;
	private LoginServiceAsync loginService;
	private LoginPresenter loginPresenter;
	private MenuView menu;
	
	public AppController(LoginServiceAsync loginService, SimpleEventBus eventbus){
		this.eventbus = eventbus;
		this.loginService = loginService;
		bind();
	}
	
	private void bind(){
		History.addValueChangeHandler(this);
		
		eventbus.addHandler(InicioEvent.TYPE, new InicioEventHandler(){

			@Override
			public void onInicio(InicioEvent event) {
				doInicio();
			}
			
		});
		
		eventbus.addHandler(LoginEvent.TYPE,  new LoginEventHandler(){

			@Override
			public void onLogin(LoginEvent event) {
				doLogin();
			}
			
		});
	}
	
	protected void doLogin() {
		History.newItem("Login");
	}

	protected void doInicio() {
		History.newItem("Inicio");
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
		if (token != null) {
		      Presenter presenter = null;
		      Presenter presenter2 = null;
		      if (token.equals("Inicio")) {
		    	presenter = new BusquedaPresenter(loginService, eventbus, new BusquedaView());
		    	presenter.go(MyPathsApp.get().getPanelPrincipal());
//		    	TODO en cada caso, si MyPaths.get().getUsuarioActual()!=null y History.getToken().equals(X). hacemos Y
		    	if(MyPathsApp.get().getUsuarioActual()==null){
		    		menu = new MenuView();
		    		menu.getMenuBar().removeItem(menu.getBuscarLink());
		    		menu.getMenuBar().removeItem(menu.getAddPathLink());
		    		menu.getMenuBar().removeItem(menu.getCerrarSesionLink());
		    		menu.getMenuBar().removeItem(menu.getPerfilLink());
		    	}else{
		    		
		    	}
		    	presenter2 = new MenuPresenter(loginService, eventbus, menu);
		    	presenter2.go(MyPathsApp.get().getPanelCabecera().getMenuCabecera());
		      } else if (token.equals("Login")) {
		        presenter = getLoginPresenter();
		        presenter.go(MyPathsApp.get().getPanelPrincipal());
		        presenter2 = new MenuPresenter(loginService, eventbus, new MenuView());
		        presenter2.go(MyPathsApp.get().getPanelCabecera().getMenuCabecera());
		        return;
		      }
		}
	}
	
	private LoginPresenter getLoginPresenter() {
		if(loginPresenter == null){
			GWT.log("AppController: Creando LoginPresenter");
			loginPresenter = new LoginPresenter(loginService, eventbus, new LoginView());
		}
		return loginPresenter;
	}
	
}

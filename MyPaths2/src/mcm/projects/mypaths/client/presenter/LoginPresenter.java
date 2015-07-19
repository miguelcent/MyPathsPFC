package mcm.projects.mypaths.client.presenter;

import mcm.projects.mypaths.client.MyPathsApp;
import mcm.projects.mypaths.client.event.InicioEvent;
import mcm.projects.mypaths.client.event.RememberEvent;
import mcm.projects.mypaths.client.service.LoginServiceAsync;
import mcm.projects.mypaths.client.service.UserService;
import mcm.projects.mypaths.client.service.UserServiceAsync;
import mcm.projects.mypaths.shared.dto.Usuario;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.storage.client.Storage;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

public class LoginPresenter implements Presenter {

	public interface Display {
		HasValue<String> getUsername();

		HasValue<String> getPassword();

		HasClickHandlers getRememberLink();

		HasClickHandlers getLoginGoogleButton();

		Widget asWidget();

		HasClickHandlers getLoginButton();
	}
	private Storage sto = Storage.getSessionStorageIfSupported();
	private Usuario user;
	private final LoginServiceAsync loginService;
	private final UserServiceAsync userService;
	private final SimpleEventBus eventBus;
	private final Display display;
	
	public LoginPresenter(LoginServiceAsync rpcService,
			SimpleEventBus eventBus, Display display) {
		this.loginService = rpcService;
		this.eventBus = eventBus;
		this.display = display;
		this.userService = GWT.create(UserService.class);
		bind();
	}

	private void bind() {
		/**
		 * TODO En el metodo bind() se da funcionalidad a los UiField's 1)
		 * Añadir "clickHandler" a los botones y links 2) Añadir handlers al
		 * eventBus
		 */
		display.getLoginButton().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				doLogin();
			}
		});
//TODO Este metodo debe hacer una llamada RPC para traerse el mail del nombre de usuario que se ha introducido.
		display.getRememberLink().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				eventBus.fireEvent(new RememberEvent(display.getUsername().getValue()));
			}
		});

		display.getLoginGoogleButton().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				doLoginGoogle();
			}
		});
	}

	@Override
	public void go(HasWidgets container) {
		container.clear();
		container.add(display.asWidget());
	}
	
	protected void doLogin() {
		
		if(validate()){
			String username = display.getUsername().getValue();
			userService.get(username, new AsyncCallback<Usuario>() {
				@Override
				public void onSuccess(Usuario result) {
					if(result == null){
						sto.clear();
						Window.alert("No existe el usuario. Pruebe de nuevo");
						
					} else {
						user = result;
						if(display.getPassword().getValue().equals(user.getPassword())){
							sto.setItem("currentUser", user.getLogin());
							//Limpio password del usuario obtenido, y lo seteo en el singleton de MyPathsApp para poder acceder a sus otros atributos
							user.setPassword("");
							MyPathsApp.get().setUsuarioActual(user);
							eventBus.fireEvent(new InicioEvent());
							Window.alert("Login realizado correctamente \nBienvenido Mr./Mrs. "+sto.getItem("currentUser"));
							display.getUsername().setValue("");
							display.getPassword().setValue("");
						}
						else {
							sto.clear();
							Window.alert("Password introducido erroneo");
						}
					}
				}
				@Override
				public void onFailure(Throwable caught) {
					Window.alert("Error realizando login no puede consultarse input");
				}
			});
		}
	}
	
	private void limpiaForm(){
		display.getUsername().setValue("");
		display.getPassword().setValue("");
	}
	
	//TODO pendiente de validacion del formulario de login Y DE QUE NO HAYA YA UN USUARIO LOGADO.
	private boolean validate() {
		return true;
	}

	// TODO pendiente definir servlet /logingoogle y logica de logingoogle.
	protected void doLoginGoogle() {
		Window.Location.assign("/logingoogle");
	}

}

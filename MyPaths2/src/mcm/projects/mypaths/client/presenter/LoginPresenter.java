package mcm.projects.mypaths.client.presenter;

import mcm.projects.mypaths.client.MyPathsApp;
import mcm.projects.mypaths.client.event.LoginEvent;
import mcm.projects.mypaths.client.event.RememberEvent;
import mcm.projects.mypaths.client.service.LoginServiceAsync;
import mcm.projects.mypaths.shared.dto.UserAccountDTO;
import mcm.projects.mypaths.shared.dto.UsuarioDTO;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.Window;
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

	private UsuarioDTO user;
	private final LoginServiceAsync rpcService;
	private final SimpleEventBus eventBus;
	private final Display display;
	
	public LoginPresenter(LoginServiceAsync rpcService,
			SimpleEventBus eventBus, Display display) {
		this.rpcService = rpcService;
		this.eventBus = eventBus;
		this.display = display;
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
				if(!(display.getUsername()==null || display.getUsername().equals("")) && !(display.getPassword()==null && display.getPassword().equals(""))){
					user.setLogin(display.getUsername().getValue());
					user.setPassword(display.getPassword().getValue());
					eventBus.fireEvent(new LoginEvent(user));
				}
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
		
		if(MyPathsApp.get().getUsuarioActual()!=null){
			display.getUsername().setValue(MyPathsApp.get().getUsuarioActual().getLogin());
		}
	}

	@Override
	public void go(HasWidgets container) {
		container.clear();
		container.add(display.asWidget());
	}

	// TODO pendiente definir servlet /logingoogle y logica de logingoogle.
	protected void doLoginGoogle() {
		Window.Location.assign("/logingoogle");
	}

}

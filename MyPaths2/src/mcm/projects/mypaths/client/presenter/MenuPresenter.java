package mcm.projects.mypaths.client.presenter;

import mcm.projects.mypaths.client.MyPathsApp;
import mcm.projects.mypaths.client.event.InicioEvent;
import mcm.projects.mypaths.client.event.LoginEvent;
import mcm.projects.mypaths.client.helper.RPCCall;
import mcm.projects.mypaths.client.service.LoginServiceAsync;
import mcm.projects.mypaths.shared.dto.UserAccountDTO;
import mcm.projects.mypaths.shared.dto.UsuarioDTO;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.Widget;

public class MenuPresenter implements Presenter {

	public interface Display {
		MenuItem getInicioLink();
		MenuItem getLoginLink();
		MenuItem getRegistroLink();
		MenuItem getAddPathLink();
		MenuItem getPerfilLink();
		MenuItem getCerrarSesionLink();
		MenuItem getBuscarLink();
		HasText getUsernameLabel();
		Widget asWidget();
	}

	private final LoginServiceAsync rpcService;
	private final SimpleEventBus eventBus;
	private final Display display;
	private UsuarioDTO usuario= new UsuarioDTO();

	public MenuPresenter(LoginServiceAsync rpcService, SimpleEventBus eventBus,
			Display display) {
		this.rpcService = rpcService;
		this.eventBus = eventBus;
		this.display = display;
		usuario.setNombre("miguel");
		usuario.setApellidos("Centeno");
	}

	public void bind() {
		this.display.getCerrarSesionLink().setScheduledCommand(new Scheduler.ScheduledCommand() {
			
			@Override
			public void execute() {
				doLogout();
			}
		});
				
	}

	protected void doLogout() {
		new RPCCall<Void>() {
			@Override
			protected void callService(AsyncCallback<Void> cb) {
				rpcService.logout(cb);
			}

			@Override
			public void onSuccess(Void result) {
				// logout event already fired by RPCCall
			}

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("An error occurred: " + caught.toString());
			}
		}.retry(3);
	}

	@Override
	public void go(final HasWidgets container) {
		container.clear();
		container.add(display.asWidget());
		bind();
	}

}

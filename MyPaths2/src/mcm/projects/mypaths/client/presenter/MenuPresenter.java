package mcm.projects.mypaths.client.presenter;

import mcm.projects.mypaths.client.MyPathsApp;
import mcm.projects.mypaths.client.event.LogoutEvent;
import mcm.projects.mypaths.client.service.LoginServiceAsync;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.storage.client.Storage;
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
		MenuItem getVerRutaItemLink();
		HasText getUsernameLabel();
		Widget asWidget();
	}

	private final LoginServiceAsync rpcService;
	private final SimpleEventBus eventBus;
	private final Display display;
	

	public MenuPresenter(LoginServiceAsync rpcService, SimpleEventBus eventBus,
			Display display) {
		this.rpcService = rpcService;
		this.eventBus = eventBus;
		this.display = display;
		
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
		String logado = Storage.getSessionStorageIfSupported().getItem("currentUser");
		
		rpcService.logout(logado, new AsyncCallback<Boolean>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Error al hacer logout..:");
			}

			@Override
			public void onSuccess(Boolean result) {
				if(result = true){
					Window.alert("Usuario "+ Storage.getSessionStorageIfSupported().getItem("currentUser")+" ha cerrado sesión correctamente.");
					Storage.getSessionStorageIfSupported().clear();
					MyPathsApp.get().setUsuarioActual(null);
					eventBus.fireEvent(new LogoutEvent());
				}
			}
		});
	}

	@Override
	public void go(final HasWidgets container) {
		container.clear();
		container.add(display.asWidget());
		bind();
	}

}

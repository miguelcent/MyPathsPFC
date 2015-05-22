package mcm.projects.mypaths.client.presenter;

import mcm.projects.mypaths.client.service.LoginServiceAsync;
import mcm.projects.mypaths.shared.dto.UsuarioDTO;

import com.google.gwt.event.dom.client.HasChangeHandlers;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Widget;

public class BusquedaPresenter implements Presenter{

	public interface Display {
		HasChangeHandlers getlistaCategorias();
		HasClickHandlers getBuscarRutas();
		HasValue<String> getInputBusqueda();
		HorizontalPanel getFormContainer();
		Widget asWidget();
	}
	
	private UsuarioDTO user;
	private final LoginServiceAsync rpcService;
	private final SimpleEventBus eventBus;
	private final Display display;
	
	public BusquedaPresenter(LoginServiceAsync rpcService,
			SimpleEventBus eventBus, Display display){
		this.rpcService = rpcService;
		this.eventBus = eventBus;
		this.display = display;
		bind();
	}
	
	private void bind() {
		
		
	}

	@Override
	public void go(HasWidgets container) {
		container.clear();
		container.add(display.asWidget());
		
	}
	
}

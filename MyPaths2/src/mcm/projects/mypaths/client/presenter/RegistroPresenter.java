package mcm.projects.mypaths.client.presenter;

import mcm.projects.mypaths.client.service.LoginServiceAsync;
import mcm.projects.mypaths.shared.dto.UsuarioDTO;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasChangeHandlers;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

public class RegistroPresenter implements Presenter{
	
	public interface Display {
		HasValue<String> getUserNameInput();
		HasValue<String> getPasswordInput();
		HasValue<String> getRePasswordInput();
		HasValue<String> getEmailInput();
		HasValue<String> getNombreInput();
		HasValue<String> getApellidosInput();
		HasChangeHandlers getPaisSeleccionado();
		CheckBox getChkAcepto();
		HasClickHandlers getAceptoLink();
		HasClickHandlers getBotonEnviar();
		Widget asWidget();
	}
	
	private UsuarioDTO user;
	private final Display display;
	private final SimpleEventBus eventBus;
//	private final RegistroUsuarioServiceAsync rpcService;
	//TODO cambiar linea siguiente a esta por linea anterior a esta.
	private final LoginServiceAsync rpcService;
	
	public RegistroPresenter(LoginServiceAsync rpcService,
			SimpleEventBus eventBus, Display display){
		this.rpcService = rpcService;
		this.eventBus = eventBus;
		this.display = display;
		bind();
	}
	//TODO pendiente definir que hace lo "clickable"
	private void bind() {
		this.display.getChkAcepto().addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				display.getChkAcepto().setValue(!display.getChkAcepto().getValue());
			}
		});
	}
	
	@Override
	public void go(HasWidgets container) {
		container.clear();
		container.add(display.asWidget());
	}

}

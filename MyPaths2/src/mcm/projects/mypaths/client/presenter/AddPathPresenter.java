package mcm.projects.mypaths.client.presenter;

import mcm.projects.mypaths.client.MyPathsApp;
import mcm.projects.mypaths.client.service.LoginServiceAsync;
import mcm.projects.mypaths.client.utils.ValidateFormsUtil;
import mcm.projects.mypaths.shared.dto.UsuarioDTO;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasChangeHandlers;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.maps.gwt.client.GoogleMap;
import com.google.maps.gwt.client.LatLng;
import com.google.maps.gwt.client.MapOptions;
import com.google.maps.gwt.client.MapTypeId;

public class AddPathPresenter implements Presenter {
	
	public interface Display {
		HasValue<String> getTituloInput();
		HasChangeHandlers categoriaList();
		HasValue<String> getDescripcionInput();		
		HasClickHandlers getBotonEnviar();
		FormPanel getFormPanel();
		
		FlowPanel getMapCanvas();
		FileUpload getFileUpload();
		void setMapaUpload(FileUpload fileUpload);
		Widget asWidget();
	}
	
	private UsuarioDTO user;
	private final LoginServiceAsync rpcService;
	private final SimpleEventBus eventBus;
	private final Display display;
	
	public AddPathPresenter(LoginServiceAsync rpcService,
			SimpleEventBus eventBus, Display display){
		this.rpcService = rpcService;
		this.eventBus = eventBus;
		this.display = display;
		bind();
	}
	
	//TODO pendiente definir que hace lo "clickable"
	private void bind() {
		GWT.log("AddPathPresenter: binding");
		
//		display.getFileUpload().addChangeHandler(new ChangeHandler() {
//			
//			@Override
//			public void onChange(ChangeEvent event) {
//				if (display.getFileUpload().getFilename().endsWith(".kml")) {
//					Window.alert("El dichero es valido");
//				} else {
//					Window.alert("Extensión inválida. Sólo son válidos ficheros KML.");
//					MyPathsApp.get().getPanelPrincipal().getElement().
//				}
//			}
//		});
		
		display.getBotonEnviar().addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				boolean validForm = ValidateFormsUtil.validateAddPathForm(display.getFormPanel());
				if(validForm){
					
				}
			}
			
		});
	}
	
	
	@Override
	public void go(HasWidgets container) {
		container.clear();
		container.add(display.asWidget());
	}

}

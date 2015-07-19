package mcm.projects.mypaths.client.presenter;

import mcm.projects.mypaths.client.service.LoginServiceAsync;
import mcm.projects.mypaths.client.utils.ValidateFormsUtil;
import mcm.projects.mypaths.shared.dto.RutaDTO;
import mcm.projects.mypaths.shared.dto.UsuarioDTO;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasChangeHandlers;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.storage.client.Storage;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteEvent;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Widget;

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

		Label getValidationMessages();
		
		ListBox getCategoriaList();
	}

	private RutaDTO ruta;
	private UsuarioDTO user;
	private final LoginServiceAsync rpcService;
	private final SimpleEventBus eventBus;
	private final Display display;

	public AddPathPresenter(LoginServiceAsync rpcService,
			SimpleEventBus eventBus, Display display) {
		this.rpcService = rpcService;
		this.eventBus = eventBus;
		this.display = display;
		rpcService.getLoggedInUserDTO(Storage.getSessionStorageIfSupported().getItem("currentUser"), new AsyncCallback<UsuarioDTO>() {
			
			@Override
			public void onSuccess(UsuarioDTO result) {
				user = result;
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}
		});
		bind();
	}

	// TODO pendiente definir que hace lo "clickable"
	private void bind() {
		GWT.log("AddPathPresenter: binding");

		display.getBotonEnviar().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				boolean validForm = ValidateFormsUtil
						.validateAddPathForm(display);
				if (validForm) {
					doSave();
					submit();
				}
			}
		});
	}

	protected void doSave() {
		ruta.setNombre(display.getTituloInput().getValue().trim());
		ruta.setDescripcion(display.getDescripcionInput()
				.getValue().trim());
	}

	protected void submit() {
		display.getFormPanel().addSubmitCompleteHandler(
				new FormPanel.SubmitCompleteHandler() {
					@Override
					public void onSubmitComplete(SubmitCompleteEvent event) {
						display.getFormPanel().reset();
					}

				}
		);
	}

	@Override
	public void go(HasWidgets container) {
		container.clear();
		container.add(display.asWidget());
	}

}

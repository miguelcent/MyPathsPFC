package mcm.projects.mypaths.client.presenter;

import java.util.Date;

import mcm.projects.mypaths.client.service.LoginServiceAsync;
import mcm.projects.mypaths.client.service.MapaService;
import mcm.projects.mypaths.client.service.MapaServiceAsync;
import mcm.projects.mypaths.client.service.RutaService;
import mcm.projects.mypaths.client.service.RutaServiceAsync;
import mcm.projects.mypaths.client.utils.MapsUtils;
import mcm.projects.mypaths.client.utils.ValidateFormsUtil;
import mcm.projects.mypaths.shared.dto.MapaDTO;
import mcm.projects.mypaths.shared.dto.RutaDTO;
import mcm.projects.mypaths.shared.dto.UsuarioDTO;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasChangeHandlers;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.storage.client.Storage;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteEvent;
import com.google.gwt.user.client.ui.FormPanel.SubmitEvent;
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
	private final MapaServiceAsync mapaService;
	private final RutaServiceAsync rutaService;
	private final Display display;

	public AddPathPresenter(LoginServiceAsync rpcService,
			SimpleEventBus eventBus, Display display) {
		this.rpcService = rpcService;
		this.eventBus = eventBus;
		this.display = display;
		MapsUtils.pintarMapaDefecto(this.display.getMapCanvas());
		mapaService = GWT.create(MapaService.class);
		rutaService = GWT.create(RutaService.class);
		
		rpcService.getLoggedInUserDTO(Storage.getSessionStorageIfSupported().getItem("currentUser"), new AsyncCallback<UsuarioDTO>() {
			
			@Override
			public void onSuccess(UsuarioDTO result) {
				user = result;
			}
			
			@Override
			public void onFailure(Throwable caught) {
				Window.alert("no hay usuario logado");
			}
		});
		startMapUploadSession();
		bind();
	}

	private void startMapUploadSession() {
		mapaService.getBlobstoreUploadUrl(new AsyncCallback<String>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Error subiendo mapa al Datastore");
			}

			@Override
			public void onSuccess(String result) {
				display.getFormPanel().setAction(result);
			}
		});
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
					display.getFormPanel().submit();
				}
			}
		});
		
		display.getFormPanel().addSubmitCompleteHandler(new FormPanel.SubmitCompleteHandler() {
			
			@Override
			public void onSubmitComplete(SubmitCompleteEvent event) {
				startMapUploadSession();
				String key = event.getResults();
				Window.alert(key+display.getFileUpload().getFilename());
				if(!(null == key || key.equals(""))){
					mapaService.get(key, new AsyncCallback<MapaDTO>() {

						@Override
						public void onFailure(Throwable caught) {
							Window.alert("Error al traerse mapa de BBDD");
						}

						@Override
						public void onSuccess(MapaDTO mapaDTO) {
							String mapaKey = mapaDTO.getKey();
							doAdd(mapaKey);
						}
					});
				} else {
					Window.alert("No se ha podido subir el mapa");
				}
				
			}
		});
		
		display.getFormPanel().addSubmitHandler(new FormPanel.SubmitHandler() {
			
			@Override
			public void onSubmit(SubmitEvent event) {
				String mensaje = display.getFileUpload().getFilename();
				Window.alert(mensaje);
			}
		});
	}

	protected void doAdd(String mapaKey) {
		ruta = new RutaDTO();
		ruta.setNombre(display.getTituloInput().getValue().trim());
		ruta.setDescripcion(display.getDescripcionInput()
				.getValue().trim());
		ruta.setMapaKey(mapaKey);
		ruta.setUsuarioKey(user.getKey());
		ruta.setFechaCreacion(new Date());
		ruta.setCategoriaKey(display.getCategoriaList().getValue(display.getCategoriaList().getSelectedIndex()));
		rutaService.add(ruta, new AsyncCallback<Void>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("No se ha podido registrar la Ruta");
			}

			@Override
			public void onSuccess(Void result) {
				Window.alert("Ruta dada de alta perfectamente");
			}
		});
	}

	@Override
	public void go(HasWidgets container) {
		container.clear();
		container.add(display.asWidget());
	}

}

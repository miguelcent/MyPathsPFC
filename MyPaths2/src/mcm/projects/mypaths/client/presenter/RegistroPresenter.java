package mcm.projects.mypaths.client.presenter;

import mcm.projects.mypaths.client.event.InicioEvent;
import mcm.projects.mypaths.client.service.UserImageService;
import mcm.projects.mypaths.client.service.UserImageServiceAsync;
import mcm.projects.mypaths.client.service.UserServiceAsync;
import mcm.projects.mypaths.shared.dto.UploadedImageDTO;
import mcm.projects.mypaths.shared.dto.UsuarioDTO;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteEvent;

public class RegistroPresenter implements Presenter {

	public interface Display {
		HasValue<String> getUserNameInput();

		HasValue<String> getPasswordInput();

		HasValue<String> getRePasswordInput();

		HasValue<String> getEmailInput();

		HasValue<String> getNombreInput();

		HasValue<String> getApellidosInput();

		ListBox getPaisSeleccionado();

		CheckBox getChkAcepto();

		HasClickHandlers getAceptoLink();

		HasClickHandlers getBotonEnviar();

		Widget asWidget();

		Label getValidationMessages();

		FormPanel getFormulario();
	}

	private UsuarioDTO user;
	private final Display display;
	private final SimpleEventBus eventBus;
	private final UserServiceAsync rpcService;
	private final UserImageServiceAsync imageService;

	public RegistroPresenter(UserServiceAsync rpcService,
			SimpleEventBus eventBus, Display display) {
		this.rpcService = rpcService;
		this.eventBus = eventBus;
		this.display = display;
		user = new UsuarioDTO();
		this.display.getValidationMessages().setText(
				"Todos los campos, excepto la imagen, son obligatorios");
		imageService = GWT.create(UserImageService.class);
		startNewBlobstoreSession();
		bind();
	}

	// TODO pendiente definir que hace lo "clickable"
	private void bind() {

		this.display.getFormulario().addSubmitCompleteHandler(
				new FormPanel.SubmitCompleteHandler() {

					@Override
					public void onSubmitComplete(SubmitCompleteEvent event) {
						startNewBlobstoreSession();
						
						String key = event.getResults();
//						Window.alert(key);
						if(!(null==key || key.equals(""))){
							imageService.get(key,
							new AsyncCallback<UploadedImageDTO>() {
	
								@Override
								public void onFailure(Throwable caught) {
									Window.alert(caught.getMessage());
								}
		
								@Override
								public void onSuccess(
										UploadedImageDTO imgDTO) {
									String imgKey = imgDTO.getKey();
									doAdd(imgKey);
									
								}
							});
						}else {
							doAdd("");
						}
					}
				});

		this.display.getBotonEnviar().addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {
				if (validate()) {
					display.getFormulario().submit();
				}
			}
		});
	}

	protected void doAdd(String res) {
		user.setKey(display.getUserNameInput().getValue().trim());
		user.setLogin(display.getUserNameInput().getValue().trim());
		user.setPassword(display.getPasswordInput().getValue().trim());
		user.setEmail(display.getEmailInput().getValue().trim());
		user.setNombre(display.getNombreInput().getValue().trim());
		user.setApellidos(display.getApellidosInput().getValue());
		user.setPais(display.getPaisSeleccionado().getValue(
				display.getPaisSeleccionado().getSelectedIndex()));
		user.setUserImageKey(res);
		rpcService.add(user, new AsyncCallback<Void>() {

			@Override
			public void onSuccess(Void result) {
				Window.alert("Registro realizado correctamente");
				eventBus.fireEvent(new InicioEvent());
				display.getFormulario().reset();
			}

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Error añadiendo usuario..:");
			}
		});

	}

	@Override
	public void go(HasWidgets container) {
		container.clear();
		container.add(display.asWidget());
	}

	private boolean validate() {
		boolean valido = true;
		if (validaObligatorios().equals("")) {
			if (!display.getChkAcepto().getValue()) {
				display.getValidationMessages().setText(
						"Debe aceptar condiciones.");
				valido = false;

			} else {
				display.getValidationMessages().setText("");
				if (!display.getRePasswordInput().getValue().trim()
						.equals(display.getPasswordInput().getValue().trim())
						|| display.getRePasswordInput().getValue().trim()
								.equals("")
						|| display.getPasswordInput().getValue().trim()
								.equals("")) {
					display.getValidationMessages().setText(
							"Passwords no son iguales o alguno vacío.");
					valido = false;
				} else {
					display.getValidationMessages().setText("");
				}
			}
		} else {
			display.getValidationMessages().setText(
					validaObligatorios() + "es obligatorio.");
			valido = false;
		}
		return valido;
	}

	private String validaObligatorios() {
		String error = "";
		if (display.getUserNameInput().getValue().trim().equals("")) {
			error = "Nombre de usuario ";
		}
		if (error.equals("")
				&& display.getPasswordInput().getValue().trim().equals("")) {
			error = "Password ";
		}
		if (error.equals("")
				&& display.getEmailInput().getValue().trim().equals("")) {
			error = "Email ";
		}
		if (error.equals("")
				&& display.getNombreInput().getValue().trim().equals("")) {
			error = "Nombre ";
		}
		if (error.equals("")
				&& display.getApellidosInput().getValue().trim().equals("")) {
			error = "Apellidos ";
		}
		return error;
	}

	public void startNewBlobstoreSession() {
		imageService.getBlobstoreUploadUrl(new AsyncCallback<String>() {

			@Override
			public void onSuccess(String result) {
				display.getFormulario().setAction(result);
			}

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Error trayendose url para el tratamiento de la subida de imagen");
			}
		});
	}

	@Override
	public void addIn(VerticalPanel panelPrincipal) {
		// TODO Auto-generated method stub
		
	}

}

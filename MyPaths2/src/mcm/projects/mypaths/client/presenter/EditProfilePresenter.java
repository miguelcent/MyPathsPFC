package mcm.projects.mypaths.client.presenter;

import mcm.projects.mypaths.client.event.EditProfileEvent;
import mcm.projects.mypaths.client.event.InicioEvent;
import mcm.projects.mypaths.client.service.LoginServiceAsync;
import mcm.projects.mypaths.client.service.UserImageService;
import mcm.projects.mypaths.client.service.UserImageServiceAsync;
import mcm.projects.mypaths.client.service.UserService;
import mcm.projects.mypaths.client.service.UserServiceAsync;
import mcm.projects.mypaths.client.utils.UtilsImages;
import mcm.projects.mypaths.shared.dto.UploadedImageDTO;
import mcm.projects.mypaths.shared.dto.Usuario;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.storage.client.Storage;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteEvent;

public class EditProfilePresenter implements Presenter {

	public interface Display {
		HasValue<String> getUserNameInput();

		HasValue<String> getPasswordInput();

		HasValue<String> getRePasswordInput();

		HasValue<String> getEmailInput();

		HasValue<String> getNombreInput();

		HasValue<String> getApellidosInput();

		ListBox getPaisSeleccionado();

		HasClickHandlers getBotonEditar();

		FlowPanel getImagenWrapper();

		TextBox getUsernameInputWidget();

		FormPanel getFormulario();

		Widget asWidget();

		Label getValidationMessages();

		FileUpload getFotoUpload();
	}

	private Storage sto = Storage.getSessionStorageIfSupported();
	private String loggedUsername = sto.getItem("currentUser");
	private Usuario user;
	private Usuario newUser;
	private final Display display;
	private final SimpleEventBus eventBus;
	private final LoginServiceAsync rpcService;
	private final UserImageServiceAsync imageService;
	private final UserServiceAsync userService;

	public EditProfilePresenter(LoginServiceAsync rpcService, Display display,
			SimpleEventBus eventBus) {

		this.rpcService = rpcService;
		this.eventBus = eventBus;
		this.display = display;
		this.user = new Usuario();
		this.newUser = new Usuario();
		imageService = GWT.create(UserImageService.class);
		userService = GWT.create(UserService.class);
		display.getUsernameInputWidget().setEnabled(false);
		bind();
		iniciando();

	}

	private void iniciando() {
		if (!(loggedUsername == null || loggedUsername.equals(""))) {
			rpcService.getLoggedInUserDTO(loggedUsername,
					new AsyncCallback<Usuario>() {
						public void onSuccess(Usuario result) {
							user = result;
							if (null == user.getUserimageKey()) {
								EditProfilePresenter.this.display
										.getImagenWrapper().add(
												UtilsImages
														.getImagenPorDefecto());

							} else {
								imageService.get(result.getUserimageKey(), new AsyncCallback<UploadedImageDTO>() {

									@Override
									public void onFailure(Throwable caught) {
										Window.alert("Algo salio mal...   "
												+ caught.getMessage());
									}

									

									@Override
									public void onSuccess(
											UploadedImageDTO result) {
										Image img = new Image();
										img.setUrl(result.getServingUrl()+"=s200-c");
										EditProfilePresenter.this.display
												.getImagenWrapper()
												.add(img);
									}
								});
								

							}
							cargaForm();
						}

						public void onFailure(Throwable caught) {
							Window.alert("Error recuperando usuario.");
						}

					});
		} else {
			Window.alert("Error: usuario no logado o no se puede recuperar.");
		}
	}

	protected void cargaForm() {
		this.display.getApellidosInput().setValue(user.getApellidos());
		this.display.getEmailInput().setValue(user.getEmail());
		this.display.getNombreInput().setValue(user.getNombre());
		this.display.getPaisSeleccionado().getSelectedIndex();
		this.display.getPasswordInput().setValue(user.getPassword());
		this.display.getUserNameInput().setValue(user.getLogin());
	}

	private void bind() {

		display.getFotoUpload().addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent event) {
				
				imageService.getBlobstoreUploadUrl(new AsyncCallback<String>() {

					@Override
					public void onFailure(Throwable caught) {
						
					}

					@Override
					public void onSuccess(String result) {
						display.getFormulario().setAction(result);
						display.getFormulario().submit();
					}
				});
			}
		});

		this.display.getFormulario().addSubmitCompleteHandler(
				new FormPanel.SubmitCompleteHandler() {

					@Override
					public void onSubmitComplete(SubmitCompleteEvent event) {

						String res = event.getResults();
						newUser.setUserImageKey(res);
						imageService.get(res, new AsyncCallback<UploadedImageDTO>() {

							@Override
							public void onFailure(Throwable caught) {
								// TODO Auto-generated method stub
								
							}

							@Override
							public void onSuccess(UploadedImageDTO result) {
								Image img = new Image();
								img.setUrl(result.getServingUrl()+"=s200-c");
								EditProfilePresenter.this.display.getImagenWrapper().clear();
								EditProfilePresenter.this.display
								.getImagenWrapper()
								.add(img);
							}
						});
						
					}
				});

		display.getBotonEditar().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				if (validate()) {
					doUpdate();
				}

			}
		});
	}

	protected void doUpdate() {
		newUser.setLogin(display.getUserNameInput().getValue().trim());
		newUser.setPassword(display.getPasswordInput().getValue().trim());
		newUser.setEmail(display.getEmailInput().getValue().trim());
		newUser.setNombre(display.getNombreInput().getValue().trim());
		newUser.setApellidos(display.getApellidosInput().getValue());
		newUser.setPais(display.getPaisSeleccionado().getValue(
				display.getPaisSeleccionado().getSelectedIndex()));

		if (newUser.equals(user)) {
			Window.alert("Nada ha cambiado");
		} else {
			userService.add(newUser, new AsyncCallback<Void>() {

				@Override
				public void onSuccess(Void result) {
					Window.alert("Modificacion realizado correctamente");
					imageService.deleteImage(user.getUserimageKey(), new AsyncCallback<Void>() {

						@Override
						public void onFailure(Throwable caught) {
							// TODO Auto-generated method stub
							
						}

						@Override
						public void onSuccess(Void result) {
							eventBus.fireEvent(new InicioEvent());
						}
					});
					
				}

				@Override
				public void onFailure(Throwable caught) {
					rollback();
					Window.alert("Error modificando usuario..:");
				}
			});
		}
	}

	protected void rollback() {
		newUser = user;
		userService.add(newUser, new AsyncCallback<Void>() {

			@Override
			public void onSuccess(Void result) {
				eventBus.fireEvent(new EditProfileEvent());
			}

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Error modificando usuario... Marcha atras.");
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

			display.getValidationMessages().setText("");
			if (!display.getRePasswordInput().getValue().trim()
					.equals(display.getPasswordInput().getValue().trim())
					|| display.getRePasswordInput().getValue().trim()
							.equals("")
					|| display.getPasswordInput().getValue().trim().equals("")) {
				display.getValidationMessages().setText(
						"Passwords no son iguales o alguno vacío.");
				valido = false;
			} else {
				display.getValidationMessages().setText("");
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
}

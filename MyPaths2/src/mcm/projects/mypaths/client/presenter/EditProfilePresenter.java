package mcm.projects.mypaths.client.presenter;

import mcm.projects.mypaths.client.service.LoginServiceAsync;
import mcm.projects.mypaths.client.utils.UtilsImages;
import mcm.projects.mypaths.shared.dto.UsuarioDTO;

import com.google.gwt.event.dom.client.HasChangeHandlers;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.storage.client.Storage;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

public class EditProfilePresenter implements Presenter {

	public interface Display {
		HasValue<String> getUserNameInput();

		HasValue<String> getPasswordInput();

		HasValue<String> getRePasswordInput();

		HasValue<String> getEmailInput();

		HasValue<String> getNombreInput();

		HasValue<String> getApellidosInput();

		HasChangeHandlers getPaisSeleccionado();

		HasClickHandlers getBotonEditar();

		FlowPanel getImagenWrapper();

		Widget asWidget();
	}

	private Storage sto = Storage.getSessionStorageIfSupported();;
	private String loggedUsername = sto.getItem("currentUser");
	private UsuarioDTO user;
	private final Display display;
	private final SimpleEventBus eventBus;
	private final LoginServiceAsync rpcService;
	

	public EditProfilePresenter(LoginServiceAsync rpcService, Display display,
			SimpleEventBus eventBus) {

		this.rpcService = rpcService;
		this.eventBus = eventBus;
		this.display = display;
		this.user = new UsuarioDTO();
		bind();
		if (!(loggedUsername == null || loggedUsername.equals(""))) {
			rpcService.getLoggedInUserDTO(loggedUsername,
					new AsyncCallback<UsuarioDTO>() {
						public void onSuccess(UsuarioDTO result) {
							user = result;
							if (null == user.getImage_avavatar_KEY()) {
								EditProfilePresenter.this.display
										.getImagenWrapper().add(
												UtilsImages
														.getImagenPorDefecto());
								cargaForm();
							} else {
								// TODO pendiente traerse datos de base de datos
								// para tener
								// la key del ImageAPI de DataStore.
							}
						}

						public void onFailure(Throwable caught) {
							Window.alert("Error recuperando usuario.");
						}

					});
		} else {
			Window.alert("Error: usuario no loagado o no se puede recuperar.");
		}
	}

	protected void cargaForm() {
		this.display.getApellidosInput().setValue(user.getApellidos());
		this.display.getEmailInput().setValue(user.getEmail());
		this.display.getNombreInput().setValue(user.getNombre());
		// TODO pendiente hacer
		// "cómo se carga pais de un HasValueChangeHandler?"
		this.display.getPasswordInput().setValue(user.getPassword());
		this.display.getUserNameInput().setValue(user.getLogin());
	}

	private void bind() {

	}

	@Override
	public void go(HasWidgets container) {
		container.clear();
		container.add(display.asWidget());
	}

}

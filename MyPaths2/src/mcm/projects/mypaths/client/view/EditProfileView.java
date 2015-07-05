package mcm.projects.mypaths.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasChangeHandlers;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

import mcm.projects.mypaths.client.presenter.EditProfilePresenter;

public class EditProfileView extends Composite implements EditProfilePresenter.Display{

	private static EditProfileViewUiBinder uiBinder = GWT
			.create(EditProfileViewUiBinder.class);

	interface EditProfileViewUiBinder extends UiBinder<Widget, EditProfileView> {
	}
	
	@UiField
	Label tituloUsuario;

	@UiField
	Label usuarioLabel;

	@UiField
	TextBox usernameInput;

	@UiField
	Label passwordLabel;
	
	@UiField
	PasswordTextBox passwordInput;

	@UiField
	Label rePasswordLabel;
	
	@UiField
	PasswordTextBox rePasswordInput;

	@UiField
	Label tituloDatosPersonales;

	@UiField
	Label emailLabel;

	@UiField
	TextBox emailInput;

	@UiField
	Label nombreLabel;

	@UiField
	TextBox nombreInput;

	@UiField
	Label apellidosLabel;

	@UiField
	TextBox apellidosInput;

	@UiField
	Label paisLabel;

	@UiField
	ListBox listaPaises;

	@UiField
	Label fotoLabel;

	@UiField
	FileUpload fotoUpload;
	
	@UiField
	Button editarButton;
	
	@UiField 
	FlowPanel image;

	public EditProfileView() {
		initWidget(uiBinder.createAndBindUi(this));
		tituloUsuario.setText("Datos de Usuario");
		usuarioLabel.setText("Username");
		usernameInput.getElement().setPropertyString("placeholder", "Nombre de usuario");
		passwordLabel.setText("Password");
		passwordInput.getElement().setPropertyString("placeholder", "Password");
		rePasswordLabel.setText("Re-Password");
		rePasswordInput.getElement().setPropertyString("placeholder", "Re-Password");
		tituloDatosPersonales.setText("Datos Personales");
		emailLabel.setText("Email");
		emailInput.getElement().setPropertyString("placeholder", "Email");
		nombreLabel.setText("Nombre");
		nombreInput.getElement().setPropertyString("placeholder", "Nombre");
		apellidosLabel.setText("Apellidos");
		apellidosInput.getElement().setPropertyString("placeholder", "Aoellidos");
		paisLabel.setText("País");
		listaPaises.addItem("España");
		fotoLabel.setText("Foto");
		fotoUpload.getElement().setPropertyString("placeholder", "Imagen del perfil");
		fotoUpload.getElement().setPropertyString("accept", "image/x-png, image/gif, image/jpeg");
		this.editarButton.setText("Editar");
	}

	@Override
	public HasValue<String> getUserNameInput() {
		// TODO Auto-generated method stub
		return usernameInput;
	}

	@Override
	public HasValue<String> getPasswordInput() {
		// TODO Auto-generated method stub
		return passwordInput;
	}

	@Override
	public HasValue<String> getRePasswordInput() {
		// TODO Auto-generated method stub
		return rePasswordInput;
	}

	@Override
	public HasValue<String> getEmailInput() {
		// TODO Auto-generated method stub
		return emailInput;
	}

	@Override
	public HasValue<String> getNombreInput() {
		// TODO Auto-generated method stub
		return nombreInput;
	}

	@Override
	public HasValue<String> getApellidosInput() {
		// TODO Auto-generated method stub
		return apellidosInput;
	}

	@Override
	public HasChangeHandlers getPaisSeleccionado() {
		// TODO Auto-generated method stub
		return listaPaises;
	}

	@Override
	public HasClickHandlers getBotonEditar() {
		// TODO Auto-generated method stub
		return editarButton;
	}

	@Override
	public FlowPanel getImagenWrapper() {
		// TODO Auto-generated method stub
		return image;
	}

}

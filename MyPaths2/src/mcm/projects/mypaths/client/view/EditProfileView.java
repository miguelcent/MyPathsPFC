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
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

import mcm.projects.mypaths.client.presenter.EditProfilePresenter;
import mcm.projects.mypaths.client.service.UserImageService;
import mcm.projects.mypaths.client.service.UserImageServiceAsync;

public class EditProfileView extends Composite implements EditProfilePresenter.Display{

	private static EditProfileViewUiBinder uiBinder = GWT
			.create(EditProfileViewUiBinder.class);
	
	UserImageServiceAsync userImageService = GWT.create(UserImageService.class);
	
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
	
	@UiField
	FormPanel formulario;
	
	@UiField
	Label validationMessages;

	public EditProfileView() {
		initWidget(uiBinder.createAndBindUi(this));
		this.tituloUsuario.setText("Datos de Usuario");
		this.usuarioLabel.setText("Username");
		this.usernameInput.getElement().setPropertyString("placeholder", "Nombre de usuario");
		this.passwordLabel.setText("Password");
		this.passwordInput.getElement().setPropertyString("placeholder", "Password");
		this.rePasswordLabel.setText("Re-Password");
		this.rePasswordInput.getElement().setPropertyString("placeholder", "Re-Password");
		this.tituloDatosPersonales.setText("Datos Personales");
		this.emailLabel.setText("Email");
		this.emailInput.getElement().setPropertyString("placeholder", "Email");
		this.nombreLabel.setText("Nombre");
		this.nombreInput.getElement().setPropertyString("placeholder", "Nombre");
		this.apellidosLabel.setText("Apellidos");
		this.apellidosInput.getElement().setPropertyString("placeholder", "Aoellidos");
		this.paisLabel.setText("País");
		this.listaPaises.addItem("España");
		this.fotoLabel.setText("Foto");
		this.fotoUpload.getElement().setPropertyString("placeholder", "Imagen del perfil");
		this.fotoUpload.getElement().setPropertyString("accept", "image/x-png, image/gif, image/jpeg");
		this.fotoUpload.setName("image");
		this.editarButton.setText("Editar");
		this.formulario.setEncoding(FormPanel.ENCODING_MULTIPART);
		this.formulario.setMethod(FormPanel.METHOD_POST);
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
	public ListBox getPaisSeleccionado() {
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

	@Override
	public TextBox getUsernameInputWidget() {
		// TODO Auto-generated method stub
		return usernameInput;
	}

	@Override
	public FormPanel getFormulario() {
		return formulario;
	}
	
	@Override
	public Label getValidationMessages() {
		return validationMessages;
	}

	@Override
	public FileUpload getFotoUpload() {
		// TODO Auto-generated method stub
		return fotoUpload;
	}

}

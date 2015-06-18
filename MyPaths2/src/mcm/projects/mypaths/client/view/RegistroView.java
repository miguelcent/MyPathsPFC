package mcm.projects.mypaths.client.view;

import com.gargoylesoftware.htmlunit.javascript.host.HashChangeEvent;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasChangeHandlers;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

import mcm.projects.mypaths.client.presenter.RegistroPresenter;

public class RegistroView extends Composite implements RegistroPresenter.Display {

	private static RegistroViewUiBinder uiBinder = GWT
			.create(RegistroViewUiBinder.class);

	interface RegistroViewUiBinder extends UiBinder<Widget, RegistroView> {
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
	CheckBox chkCondiciones;

	@UiField
	Label aceptoTxt;

	@UiField
	Hyperlink aceptoLink;
	
	@UiField
	Button registroButton;

	public RegistroView() {
		initWidget(uiBinder.createAndBindUi(this));
		this.tituloUsuario.setText("Datos de Usuario");
		this.usuarioLabel.setText("Username (*)");
		this.usernameInput.getElement().setPropertyString("placeholder", "Nombre de usuario");
		this.passwordLabel.setText("Password (*)");
		this.passwordInput.getElement().setPropertyString("placeholder", "Password");
		this.rePasswordLabel.setText("Re-Password (*)");
		this.rePasswordInput.getElement().setPropertyString("placeholder", "Re-Password");
		this.tituloDatosPersonales.setText("Datos Personales");
		this.emailLabel.setText("Email (*)");
		this.emailInput.getElement().setPropertyString("placeholder", "Email");
		this.nombreLabel.setText("Nombre");
		this.nombreInput.getElement().setPropertyString("placeholder", "Nombre");
		this.apellidosLabel.setText("Apellidos");
		this.apellidosInput.getElement().setPropertyString("placeholder", "Aoellidos");
		this.paisLabel.setText("País");
		this.listaPaises.addItem("España");
		this.fotoLabel.setText("Foto");
		this.fotoUpload.getElement().setPropertyString("placeholder", "Imagen del perfil");
		this.chkCondiciones.setValue(true);
		this.aceptoTxt.setText("Acepto los");
		this.aceptoLink.setText("términos de privacidad");
		this.registroButton.setText("Registrarse");
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
	public CheckBox getChkAcepto() {
		// TODO Auto-generated method stub
		return chkCondiciones;
	}

	@Override
	public HasClickHandlers getAceptoLink() {
		// TODO Auto-generated method stub
		return aceptoLink;
	}

	@Override
	public HasClickHandlers getBotonEnviar() {
		// TODO Auto-generated method stub
		return registroButton;
	}

}

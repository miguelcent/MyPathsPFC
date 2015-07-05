package mcm.projects.mypaths.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteEvent;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

import mcm.projects.mypaths.client.presenter.RegistroPresenter;
import mcm.projects.mypaths.client.service.ImageService;
import mcm.projects.mypaths.client.service.ImageServiceAsync;

public class RegistroView extends Composite implements RegistroPresenter.Display {

	private static RegistroViewUiBinder uiBinder = GWT
			.create(RegistroViewUiBinder.class);
	ImageServiceAsync userImageService = GWT.create(ImageService.class);

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
	
	@UiField
	Label validationMessages;
	
	@UiField 
	FormPanel formulario;

	public RegistroView() {
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
		this.fotoUpload.setName("image");
		this.chkCondiciones.setValue(true);
		this.aceptoTxt.setText("Acepto los");
		this.aceptoLink.setText("términos de privacidad");
		this.registroButton.setText("Registrarse");
		this.validationMessages.setText("");
		this.formulario.setEncoding(FormPanel.ENCODING_MULTIPART);
		this.formulario.setMethod(FormPanel.METHOD_POST);
		startNewBlobstoreSession();
		// Once we've hit submit and it's complete, let's set the form to a new session.
        // We could also have probably done this on the onClick handler
        formulario.addSubmitCompleteHandler(new FormPanel.SubmitCompleteHandler() {
 
            @Override
            public void onSubmitComplete(SubmitCompleteEvent event) {
               formulario.reset();
               startNewBlobstoreSession();
               ////////PRUEBAS
               // This is what gets the result back - the content-type *must* be
               // text-html
               String imageUrl = event.getResults();
               Image image = new Image();
               image.setUrl(imageUrl);
            
               final PopupPanel imagePopup = new PopupPanel(true);
               imagePopup.setWidget(image);
            
               // Add some effects
               imagePopup.setAnimationEnabled(true); // animate opening the image
               imagePopup.setGlassEnabled(true); // darken everything under the image
               imagePopup.setAutoHideEnabled(true); // close image when the user clicks
                                                       // outside it
               imagePopup.center(); // center the image
            }

        });
	}

	@Override
	public HasValue<String> getUserNameInput() {
		return usernameInput;
	}

	@Override
	public HasValue<String> getPasswordInput() {
		return passwordInput;
	}

	@Override
	public HasValue<String> getRePasswordInput() {
		return rePasswordInput;
	}

	@Override
	public HasValue<String> getEmailInput() {
		return emailInput;
	}

	@Override
	public HasValue<String> getNombreInput() {
		return nombreInput;
	}

	@Override
	public HasValue<String> getApellidosInput() {
		return apellidosInput;
	}

	@Override
	public ListBox getPaisSeleccionado() {
		return listaPaises;
	}

	@Override
	public CheckBox getChkAcepto() {
		return chkCondiciones;
	}

	@Override
	public HasClickHandlers getAceptoLink() {
		return aceptoLink;
	}

	@Override
	public HasClickHandlers getBotonEnviar() {
		return registroButton;
	}

	@Override
	public Label getValidationMessages() {
		return validationMessages;
	}
	
	private void startNewBlobstoreSession() {
        userImageService.getBlobstoreUploadUrl(new AsyncCallback<String>() {
 
            @Override
            public void onSuccess(String result) {
                formulario.setAction(result);
            }
 
            @Override
            public void onFailure(Throwable caught) {
                // We probably want to do something here
            }
        });
    }
	
	@UiHandler("registroButton")
    void onSubmit(ClickEvent e) {
        formulario.submit();
    }

}

package mcm.projects.mypaths.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

import mcm.projects.mypaths.client.presenter.LoginPresenter;

public class LoginView extends Composite implements LoginPresenter.Display {

	private static LoginViewUiBinder uiBinder = GWT
			.create(LoginViewUiBinder.class);

	interface LoginViewUiBinder extends UiBinder<Widget, LoginView> {
	}

	@UiField
	Label titulo;
	@UiField
	Label usernameLabel;
	@UiField
	TextBox usernameInput;
	@UiField
	Label passwordLabel;
	@UiField
	PasswordTextBox passwordInput;
	@UiField
	Label rememberText;
	@UiField
	Hyperlink rememberLink;
	@UiField
	Button loginButton;
	@UiField
	Button loginGoogleButton;

	public LoginView() {
		initWidget(uiBinder.createAndBindUi(this));
		this.titulo.setText("Login");
		this.usernameLabel.setText("Usuario: ");
		usernameInput.getElement().setPropertyString("placeholder",
				"Nombre de Usuario");
		this.passwordLabel.setText("Password: ");
		passwordInput.getElement().setPropertyString("placeholder", "Password");
		this.rememberText
				.setText("¿Has olvidado tus credenciales?. Click ");
		this.rememberLink.setText("aquí.");
		this.loginButton.setText("Login");
		this.loginGoogleButton.setText("Login Google");
	}

	@Override
	public HasValue<String> getUsername() {
		return usernameInput;
	}

	@Override
	public HasValue<String> getPassword() {
		return passwordInput;
	}

	@Override
	public HasClickHandlers getRememberLink() {
		return rememberLink;
	}

	@Override
	public HasClickHandlers getLoginGoogleButton() {
		return loginGoogleButton;
	}

	@Override
	public HasClickHandlers getLoginButton() {
		return loginButton;
	}

	public Widget asWidget() {
		return this;
	}
}

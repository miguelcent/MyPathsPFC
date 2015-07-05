package mcm.projects.mypaths.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class MenuPanel extends Composite{

	private static MenuPanelUiBinder uiBinder = GWT
			.create(MenuPanelUiBinder.class);
	
	
	@UiField
	Hyperlink inicioLink;
	@UiField
	Hyperlink loginLink;
	@UiField
	Hyperlink registroLink;
	@UiField
	Hyperlink addPathLink;
	@UiField
	Hyperlink perfilLink;
	@UiField
	Hyperlink cerrarSesionLink;
	@UiField
	Hyperlink buscarLink;
	@UiField
	Label usernameLabel;

	interface MenuPanelUiBinder extends UiBinder<Widget, MenuPanel> {
	}

	public MenuPanel() {
		initWidget(uiBinder.createAndBindUi(this));
		inicioLink.setText("Inicio");
		loginLink.setText("Login");
		registroLink.setText("Registro");
		addPathLink.setText("Nuevo Path");
		perfilLink.setText("Perfil");
		cerrarSesionLink.setText("Logout");
		buscarLink.setText("Buscar");
	}

	public HasClickHandlers getInicioLink() {
		return inicioLink;
	}

	public HasClickHandlers getLoginLink() {
		return loginLink;
	}

	public HasClickHandlers getRegistroLink() {
		return registroLink;
	}

	public HasClickHandlers getAddPathLink() {
		return addPathLink;
	}

	public HasClickHandlers getPerfilLink() {
		return perfilLink;
	}

	public HasClickHandlers getCerrarSesionLink() {
		return cerrarSesionLink;
	}

	public HasClickHandlers getBuscarLink() {
		return buscarLink;
	}

	public HasText getUsernameLabel() {
		return usernameLabel;
	}

//	@UiField
//	Button button;
//
//	public MenuPanel(String firstName) {
//		initWidget(uiBinder.createAndBindUi(this));
//		button.setText(firstName);
//	}
//
//	@UiHandler("button")
//	void onClick(ClickEvent e) {
//		Window.alert("Hello!");
//	}
//
//	public void setText(String text) {
//		button.setText(text);
//	}
//
//	public String getText() {
//		return button.getText();
//	}

}

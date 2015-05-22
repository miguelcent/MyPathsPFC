package mcm.projects.mypaths.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.Label;

import mcm.projects.mypaths.client.presenter.MenuPresenter;
import mcm.projects.mypaths.client.utils.HistoryToken;
import mcm.projects.mypaths.client.utils.MenuCommand;

public class MenuView extends Composite implements MenuPresenter.Display {

	private static MenuViewUiBinder uiBinder = GWT
			.create(MenuViewUiBinder.class);
	@UiField
	MenuBar menuBar;
	@UiField
	MenuItem inicioLink;
	@UiField
	MenuItem loginLink;
	@UiField
	MenuItem registroLink;
	@UiField
	MenuItem addPathLink;
	@UiField
	MenuItem perfilLink;
	@UiField
	MenuItem cerrarSesionLink;
	@UiField
	MenuItem buscarLink;
	@UiField
	Label usernameLabel;

	interface MenuViewUiBinder extends UiBinder<Widget, MenuView> {
	}
	//mcm: En constructor se crean y colocan elementos
	public MenuView() {
		initWidget(uiBinder.createAndBindUi(this));
		inicioLink.setText("Inicio");
		inicioLink.setScheduledCommand(new MenuCommand(HistoryToken.Inicio));
		loginLink.setText("Login");
		loginLink.setScheduledCommand(new MenuCommand(HistoryToken.Login));
		registroLink.setText("Registro");
		registroLink.setScheduledCommand(new MenuCommand(HistoryToken.Registro));
		addPathLink.setText("Nuevo Path");
		addPathLink.setScheduledCommand(new MenuCommand(HistoryToken.AddPath));
		perfilLink.setText("Perfil");
		perfilLink.setScheduledCommand(new MenuCommand(HistoryToken.Perfil));
		cerrarSesionLink.setText("Logout");
		buscarLink.setText("Buscar");
		buscarLink.setScheduledCommand(new MenuCommand(HistoryToken.Buscar));
	}

	public MenuBar getMenuBar() {
		return menuBar;
	}

	public MenuItem getInicioLink() {
		return inicioLink;
	}

	public MenuItem getLoginLink() {
		return loginLink;
	}

	public MenuItem getRegistroLink() {
		return registroLink;
	}

	public MenuItem getAddPathLink() {
		return addPathLink;
	}

	public MenuItem getPerfilLink() {
		return perfilLink;
	}

	public MenuItem getCerrarSesionLink() {
		return cerrarSesionLink;
	}

	public MenuItem getBuscarLink() {
		return buscarLink;
	}

	public HasText getUsernameLabel() {
		return usernameLabel;
	}
	
	public MenuView asWidget(){
		return this;
	}

}

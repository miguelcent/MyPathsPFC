package mcm.projects.mypaths.client.panels;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;

public class MenuCabeceraPnl extends Composite {

	private static MenuCabeceraPnlUiBinder uiBinder = GWT
			.create(MenuCabeceraPnlUiBinder.class);
	@UiField MenuBar menuBar;
	@UiField MenuItem inicioLink;
	@UiField MenuItem loginLink;
	@UiField MenuItem registroLink;
	@UiField MenuItem addPathLink;
	@UiField MenuItem perfilLink;
	@UiField MenuItem cerrarSesionLink;

	interface MenuCabeceraPnlUiBinder extends UiBinder<Widget, MenuCabeceraPnl> {
	}

	public MenuCabeceraPnl() {
		initWidget(uiBinder.createAndBindUi(this));
		
	}

	public MenuBar getMenuBar() {
		return menuBar;
	}

	public void setMenuBar(MenuBar menuBar) {
		this.menuBar = menuBar;
	}

	public MenuItem getInicioLink() {
		return inicioLink;
	}

	public void setInicioLink(MenuItem inicioLink) {
		this.inicioLink = inicioLink;
	}

	public MenuItem getLoginLink() {
		return loginLink;
	}

	public void setLoginLink(MenuItem loginLink) {
		this.loginLink = loginLink;
	}

	public MenuItem getRegistroLink() {
		return registroLink;
	}

	public void setRegistroLink(MenuItem registroLink) {
		this.registroLink = registroLink;
	}

	public MenuItem getAddPathLink() {
		return addPathLink;
	}

	public void setAddPathLink(MenuItem addPathLink) {
		this.addPathLink = addPathLink;
	}

	public MenuItem getPerfilLink() {
		return perfilLink;
	}

	public void setPerfilLink(MenuItem perfilLink) {
		this.perfilLink = perfilLink;
	}

	public MenuItem getCerrarSesionLink() {
		return cerrarSesionLink;
	}

	public void setCerrarSesionLink(MenuItem cerrarSesionLink) {
		this.cerrarSesionLink = cerrarSesionLink;
	}
	
}

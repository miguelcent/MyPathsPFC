package mcm.projects.mypaths.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Image;

public class CabeceraPanel extends Composite {

	private static CabeceraPanelUiBinder uiBinder = GWT
			.create(CabeceraPanelUiBinder.class);
	@UiField VerticalPanel menuCabecera;
	@UiField Image logoCabecera;

	interface CabeceraPanelUiBinder extends UiBinder<Widget, CabeceraPanel> {
	}

	public CabeceraPanel() {	
		initWidget(uiBinder.createAndBindUi(this));
	}

	public VerticalPanel getMenuCabecera() {
		return menuCabecera;
	}

	public void setMenuCabecera(VerticalPanel menuCabecera) {
		this.menuCabecera = menuCabecera;
	}

	public Image getLogoCabecera() {
		return logoCabecera;
	}

	public void setLogoCabecera(Image logoCabecera) {
		this.logoCabecera = logoCabecera;
	}

}

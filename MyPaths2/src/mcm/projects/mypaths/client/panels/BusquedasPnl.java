/**
 * 
 */
package mcm.projects.mypaths.client.panels;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Miguel
 *
 */
public class BusquedasPnl extends Composite {

	private static BusquedasPnlUiBinder uiBinder = GWT
			.create(BusquedasPnlUiBinder.class);
	@UiField ListBox listaCategorias;
	@UiField TextBox inputBusqueda;
	@UiField Button buscarRutas;
	@UiField HorizontalPanel formContainer;
	interface BusquedasPnlUiBinder extends UiBinder<Widget, BusquedasPnl> {
	}

	/**
	 * Because this class has a default constructor, it can
	 * be used as a binder template. In other words, it can be used in other
	 * *.ui.xml files as follows:
	 * <ui:UiBinder xmlns:ui="urn:ui:com.google.gwt.uibinder"
	 *   xmlns:g="urn:import:**user's package**">
	 *  <g:**UserClassName**>Hello!</g:**UserClassName>
	 * </ui:UiBinder>
	 * Note that depending on the widget that is used, it may be necessary to
	 * implement HasHTML instead of HasText.
	 */
	public BusquedasPnl() {
		initWidget(uiBinder.createAndBindUi(this));
		this.getInputBusqueda().getElement().setPropertyString("placeholder", "Introduce el texto de busqueda");
	}

	public ListBox getListaCategorias() {
		return listaCategorias;
	}

	public void setListaCategorias(ListBox listaCategorias) {
		this.listaCategorias = listaCategorias;
	}

	public TextBox getInputBusqueda() {
		return inputBusqueda;
	}

	public void setInputBusqueda(TextBox inputBusqueda) {
		this.inputBusqueda = inputBusqueda;
	}

	public Button getBuscarRutas() {
		return buscarRutas;
	}

	public void setBuscarRutas(Button buscarRutas) {
		this.buscarRutas = buscarRutas;
	}

	public HorizontalPanel getFormContainer() {
		return formContainer;
	}

	public void setFormContainer(HorizontalPanel formContainer) {
		this.formContainer = formContainer;
	}

}

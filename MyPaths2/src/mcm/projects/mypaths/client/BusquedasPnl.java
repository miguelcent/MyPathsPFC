/**
 * 
 */
package mcm.projects.mypaths.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasChangeHandlers;
import com.google.gwt.event.dom.client.HasClickHandlers;
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

		this.inputBusqueda.getElement().setPropertyString("placeholder", "Introduce el texto de busqueda");
		this.listaCategorias.addItem("Ciclista");
		this.listaCategorias.addItem("Gastron�mica");
		this.listaCategorias.addItem("Tur�stica");
		this.listaCategorias.addItem("Senderismo");
		this.listaCategorias.addItem("Running");

	}

	public HasChangeHandlers getListaCategorias() {
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

	public HasClickHandlers getBuscarRutas() {
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

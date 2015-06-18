package mcm.projects.mypaths.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasChangeHandlers;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

import mcm.projects.mypaths.client.presenter.BusquedaPresenter;

public class BusquedaView extends Composite implements BusquedaPresenter.Display {

	private static BusquedaViewUiBinder uiBinder = GWT
			.create(BusquedaViewUiBinder.class);
	
	interface BusquedaViewUiBinder extends UiBinder<Widget, BusquedaView> {
	}
	
	@UiField ListBox listaCategorias;
	@UiField TextBox inputBusqueda;
	@UiField Button buscarRutas;
	@UiField HorizontalPanel formContainer;

	public BusquedaView() {
		initWidget(uiBinder.createAndBindUi(this));

		this.inputBusqueda.getElement().setPropertyString("placeholder", "Introduce el texto de busqueda");
		this.listaCategorias.addItem("Ciclista");
		this.listaCategorias.addItem("Gastronómica");
		this.listaCategorias.addItem("Turística");
		this.listaCategorias.addItem("Senderismo");
		this.listaCategorias.addItem("Running");
	}

	public void setListaCategorias(ListBox listaCategorias) {
		this.listaCategorias = listaCategorias;
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

	@Override
	public HasChangeHandlers getlistaCategorias() {
		// TODO Auto-generated method stub
		return listaCategorias;
	}

	@Override
	public HasValue<String> getInputBusqueda() {
		// TODO Auto-generated method stub
		return inputBusqueda;
	}

}
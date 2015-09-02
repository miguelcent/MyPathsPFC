package mcm.projects.mypaths.client.view;

import mcm.projects.mypaths.client.presenter.BusquedaPresenter;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasChangeHandlers;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class BusquedaView extends Composite implements BusquedaPresenter.Display {

	private static BusquedaViewUiBinder uiBinder = GWT
			.create(BusquedaViewUiBinder.class);
	
	interface BusquedaViewUiBinder extends UiBinder<Widget, BusquedaView> {
	}
	
	@UiField ListBox listaCategorias;
	@UiField TextBox inputBusqueda;
	@UiField Button buscarRutas;
	@UiField HorizontalPanel formContainer;
	@UiField SimplePanel imagenInicio;

	public BusquedaView() {
		initWidget(uiBinder.createAndBindUi(this));

		this.inputBusqueda.getElement().setPropertyString("placeholder", "Introduce el texto de busqueda");
		this.listaCategorias.addItem("Ciclismo");
		this.listaCategorias.addItem("Gastronomica");
		this.listaCategorias.addItem("Turistica");
		this.listaCategorias.addItem("Senderismo");
		this.listaCategorias.addItem("Running");
		this.listaCategorias.setSelectedIndex(0);
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

	@Override
	public SimplePanel getImagenInicio() {
		return imagenInicio;
	}

}

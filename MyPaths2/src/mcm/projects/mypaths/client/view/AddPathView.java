package mcm.projects.mypaths.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.event.dom.client.HasChangeHandlers;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.dom.client.LoadEvent;
import com.google.gwt.event.dom.client.LoadHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.maps.gwt.client.GoogleMap;
import com.google.maps.gwt.client.LatLng;
import com.google.maps.gwt.client.MapOptions;
import com.google.maps.gwt.client.MapTypeId;

import mcm.projects.mypaths.client.presenter.AddPathPresenter;

public class AddPathView extends Composite implements AddPathPresenter.Display{

	private static AddPathViewUiBinder uiBinder = GWT
			.create(AddPathViewUiBinder.class);

	interface AddPathViewUiBinder extends UiBinder<Widget, AddPathView> {
	}
	
	@UiField
	Label tituloLabel;
	@UiField
	TextBox tituloInput;
	@UiField
	Label categoriaLabel;
	@UiField
	ListBox categoriaList;
	@UiField
	Label descripcionLabel;
	@UiField
	TextArea descripcionInput;
	@UiField
	Label mapaLabel;
	@UiField
	FileUpload mapaUpload;
	@UiField
	FlowPanel mapCanvas;
	@UiField
	Button botonEnviar;

	public AddPathView() {
		initWidget(uiBinder.createAndBindUi(this));
		tituloLabel.setText("Título (*)");
		tituloInput.getElement().setPropertyString("placeholder", "Título de la ruta...");
		categoriaLabel.setText("Categoría (*)");
		categoriaList.addItem("Ciclista");
		categoriaList.addItem("Gastronómica");
		categoriaList.addItem("Turística");
		categoriaList.addItem("Senderismo");
		categoriaList.addItem("Running");
		descripcionLabel.setText("Descripción ruta (*)");
		descripcionInput.getElement().setPropertyString("placeholder", "Descripción de la ruta...");
		botonEnviar.setText("Enviar");
		mapCanvas.getElement().setId("map-canvas");
	}

	

	@Override
	public HasValue<String> getTituloInput() {
		// TODO Auto-generated method stub
		return tituloInput;
	}

	@Override
	public HasChangeHandlers categoriaList() {
		// TODO Auto-generated method stub
		return categoriaList;
	}

	@Override
	public HasValue<String> getDescripcionInput() {
		// TODO Auto-generated method stub
		return descripcionInput;
	}

	@Override
	public HasClickHandlers getBotonEnviar() {
		// TODO Auto-generated method stub
		return botonEnviar;
	}

	@Override
	public FlowPanel getMapCanvas() {
		// TODO Auto-generated method stub
		return mapCanvas;
	}

}

package mcm.projects.mypaths.client.presenter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import mcm.projects.mypaths.client.resources.ResourcesBundle;
import mcm.projects.mypaths.client.service.RutaService;
import mcm.projects.mypaths.client.service.RutaServiceAsync;
import mcm.projects.mypaths.client.view.widgets.RutaWidget;
import mcm.projects.mypaths.shared.dto.RutaDTO;

import com.google.gwt.cell.client.ImageResourceCell;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.ColumnSortEvent.ListHandler;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.SimplePager.TextLocation;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.view.client.ProvidesKey;

public class ListaRutasPresenter{

//	// Widget necesario para ser presentado
//	CellTable<RutaDTO> cellTable;
	// Items a cargar en el widget
	List<RutaDTO> rutas = new ArrayList<RutaDTO>();
	// Servicios necesarios para obtener datos
	RutaServiceAsync rutaService;
	
	SimpleEventBus se = new SimpleEventBus();

	ResourcesBundle rb = ResourcesBundle.RESOURCE;

	public ListaRutasPresenter(String userId) {
		rutaService = GWT.create(RutaService.class);
		rutaService.getRutasUsuario(userId, new AsyncCallback<List<RutaDTO>>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("No se trajeron rutas");
			}

			@Override
			public void onSuccess(List<RutaDTO> result) {
				Window.alert("Exito, se ha traido " + result.size() + " rutas.");
				rutas = result;
			}
		});
	}

	public List<RutaDTO> cargaLista() {
		return rutas;
	}
}

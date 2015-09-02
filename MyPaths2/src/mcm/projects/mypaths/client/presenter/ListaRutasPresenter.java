package mcm.projects.mypaths.client.presenter;

//import java.util.ArrayList;
//import java.util.Comparator;
//import java.util.List;
//
//import mcm.projects.mypaths.client.resources.ResourcesBundle;
//import mcm.projects.mypaths.client.service.RutaService;
//import mcm.projects.mypaths.client.service.RutaServiceAsync;
//import mcm.projects.mypaths.client.view.widgets.ListaRutasWidget;
//import mcm.projects.mypaths.client.view.widgets.RutaWidget;
//import mcm.projects.mypaths.shared.dto.RutaDTO;
//
//import com.google.gwt.cell.client.Cell;
//import com.google.gwt.cell.client.ImageResourceCell;
//import com.google.gwt.cell.client.TextCell;
//import com.google.gwt.core.shared.GWT;
//import com.google.gwt.dom.client.Style.Unit;
//import com.google.gwt.event.shared.EventBus;
//import com.google.gwt.event.shared.SimpleEventBus;
//import com.google.gwt.resources.client.ImageResource;
//import com.google.gwt.user.cellview.client.CellList;
//import com.google.gwt.user.cellview.client.CellTable;
//import com.google.gwt.user.cellview.client.Column;
//import com.google.gwt.user.cellview.client.ColumnSortEvent.ListHandler;
//import com.google.gwt.user.cellview.client.SimplePager;
//import com.google.gwt.user.cellview.client.SimplePager.TextLocation;
//import com.google.gwt.user.client.Window;
//import com.google.gwt.user.client.rpc.AsyncCallback;
//import com.google.gwt.user.client.ui.HasWidgets;
//import com.google.gwt.user.client.ui.Widget;
//import com.google.gwt.view.client.HasData;
//import com.google.gwt.view.client.ListDataProvider;
//import com.google.gwt.view.client.ProvidesKey;

public class ListaRutasPresenter{
	
//	public interface Display {
//		CellList<RutaDTO> getCellList();
//		SimplePager getPager();
//		Widget asWidget();
//	}
////	// Widget necesario para ser presentado
////	CellTable<RutaDTO> cellTable;
//	
//	// Items a cargar en el widget
//	List<RutaDTO> rutas;
//	
//	ListDataProvider<RutaWidget> listProvider;
//	
//	CellList<RutaWidget> tabla;
//	
//	// Servicios necesarios para obtener datos
//	private final RutaServiceAsync rutaService;
//	//Bus de eventos
//	private final SimpleEventBus se;
//	//Display donde mostrar las rutas
//	private final Display display;
//	//Recursos
//	private final ResourcesBundle rb = ResourcesBundle.RESOURCE;
//	
//
//	public ListaRutasPresenter(List<RutaDTO> rutas, RutaServiceAsync rutaService, SimpleEventBus eventbus, Display display) {
//		this.rutaService = rutaService;
//		this.display = display;
//		this.se = eventbus;
//		this.rutas = rutas;
//		listProvider = new ListDataProvider<RutaWidget>();
//		loadRutas(rutas);
//	}
//
//	private void loadRutas(List<RutaDTO> rutas2) {
//		for(RutaDTO dto : rutas2){
//			RutaWidget display = new RutaWidget();
//			RutaWidgetPresenter rutaAsWidget = new RutaWidgetPresenter(dto.getKey(), rutaService, se, display);
//			tabla = new CellList<RutaWidget>(new Cell<RutaWidget>());
//		}
//		listProvider.addDataDisplay();
//	}
}

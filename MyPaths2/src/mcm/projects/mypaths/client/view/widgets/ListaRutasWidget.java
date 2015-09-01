package mcm.projects.mypaths.client.view.widgets;

import java.util.ArrayList;
import java.util.List;

import mcm.projects.mypaths.client.service.RutaServiceAsync;
import mcm.projects.mypaths.shared.dto.RutaDTO;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class ListaRutasWidget extends Composite {

	private static ListaRutasWidgetUiBinder uiBinder = GWT
			.create(ListaRutasWidgetUiBinder.class);

	interface ListaRutasWidgetUiBinder extends
			UiBinder<Widget, ListaRutasWidget> {
	}

	/**
	 * The main CellTable.
	 */
	@UiField(provided = true)
	CellTable<RutaDTO> cellTable;

	/**
	 * The pager used to change the range of data.
	 */
	@UiField(provided = true)
	SimplePager pager;
	// Items a cargar en el widget
	List<RutaDTO> rutas = new ArrayList<RutaDTO>();
	// Servicios necesarios para obtener datos
	RutaServiceAsync rutaService;

	/**
	 * Initialize this example.
	 */
//		public Widget onInitialize() {
			
//		    // Create a CellTable.
//			/**
//			 * The key provider that provides the unique ID of a contact.
//			 */
//			ProvidesKey<RutaDTO> keyProvider = new ProvidesKey<RutaDTO>() {
//				@Override
//				public Object getKey(RutaDTO item) {
//					return item == null ? null : item.getKey();
//				}
//			};
//		    // Set a key provider that provides a unique key for each contact. If key is
//		    // used to identify contacts when fields (such as the name and address)
//		    // change.
//		    cellTable = new CellTable<RutaDTO>(keyProvider);
//		    cellTable.setWidth("100%", true);
//
//		    // Do not refresh the headers and footers every time the data is updated.
//		    cellTable.setAutoHeaderRefreshDisabled(true);
//		    cellTable.setAutoFooterRefreshDisabled(true);
//
//		    // Attach a column sort handler to the ListDataProvider to sort the list.
//		    ListHandler<RutaDTO> sortHandler = new ListHandler<RutaDTO>(
//		        ContactDatabase.get().getDataProvider().getList());
//		    cellTable.addColumnSortHandler(sortHandler);
//
//		    // Create a Pager to control the table.
//		    SimplePager.Resources pagerResources = GWT.create(SimplePager.Resources.class);
//		    pager = new SimplePager(TextLocation.CENTER, pagerResources, false, 0, true);
//		    pager.setDisplay(cellTable);
//
//		    // Add a selection model so we can select cells.
//		    final SelectionModel<ContactInfo> selectionModel = new MultiSelectionModel<ContactInfo>(
//		        ContactDatabase.ContactInfo.KEY_PROVIDER);
//		    cellTable.setSelectionModel(selectionModel,
//		        DefaultSelectionEventManager.<ContactInfo> createCheckboxManager());
//
//		    // Initialize the columns.
//		    initTableColumns(selectionModel, sortHandler);
//
//		    // Add the CellList to the adapter in the database.
//		    ContactDatabase.get().addDataDisplay(cellTable);
//
//		    // Create the UiBinder.
//		    Binder uiBinder = GWT.create(Binder.class);
//		    Widget widget = uiBinder.createAndBindUi(this);
//
//		    return widget;
//		  }
//	}
}

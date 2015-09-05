package mcm.projects.mypaths.client.view.widgets;

import java.util.Iterator;

import mcm.projects.mypaths.client.presenter.ListaRutasPresenter;
import mcm.projects.mypaths.client.utils.RutaInfo;
import mcm.projects.mypaths.shared.dto.RutaDTO;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class ListaRutasWidget extends Composite implements ListaRutasPresenter.Display, HasWidgets{
	
	private static ListaRutasWidgetUiBinder uiBinder = GWT.create(ListaRutasWidgetUiBinder.class);

	interface ListaRutasWidgetUiBinder extends
			UiBinder<Widget, ListaRutasWidget> {
	}

	/**
	 * The main CellTable.
	 */
	@UiField
	VerticalPanel cellList;

	/**
	 * The pager used to change the range of data.
	 */
	@UiField
	SimplePager pager;
	
	public ListaRutasWidget(){ 
		initWidget(uiBinder.createAndBindUi(this));
	}

	

	@Override
	public SimplePager getPager() {
		return pager;
	}



	@Override
	public VerticalPanel getCellList() {
		return cellList;
	}



	@Override
	public void add(Widget w) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public Iterator<Widget> iterator() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public boolean remove(Widget w) {
		// TODO Auto-generated method stub
		return false;
	}
}

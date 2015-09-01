package mcm.projects.mypaths.client.view.widgets;


import mcm.projects.mypaths.client.presenter.RutaWidgetPresenter;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.Widget;

public class RutaWidget extends Composite implements RutaWidgetPresenter.Display{

	private static RutaWidgetUiBinder uiBinder = GWT
			.create(RutaWidgetUiBinder.class);
	
	interface RutaWidgetUiBinder extends UiBinder<Widget, RutaWidget> {
	}
	
	@UiField
	Label tituloLabel;
	@UiField
	HorizontalPanel otherUser;
	@UiField
	Hyperlink userLink;
	@UiField
	HorizontalPanel ownUser;
	@UiField
	PushButton editButton;
	@UiField
	PushButton deleteButton;
	@UiField
	FlowPanel imageCategoryWrapper;
	@UiField
	Label tituloCategoria;
	@UiField
	Label ownRuta;
	@UiField
	PushButton viewButton;
	
	public RutaWidget(){ 
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public HasText getTituloLabel() {
		return tituloLabel;
	}

	@Override
	public HasText getTituloCategoriaLabel() {
		return tituloCategoria;
	}

	@Override
	public HasText getOwnRutaLabel() {
		return ownRuta;
	}

	@Override
	public HorizontalPanel getOtherUserPanel() {
		return otherUser;
	}

	@Override
	public HorizontalPanel getOwnUserPanel() {
		return ownUser;
	}

	@Override
	public FlowPanel getImageCategoryWrapper() {
		return imageCategoryWrapper;
	}

	@Override
	public Hyperlink getUserLink() {
		return userLink;
	}

	@Override
	public PushButton getEditButton() {
		return editButton;
	}

	@Override
	public PushButton getDeleteButton() {
		return deleteButton;
	}

	@Override
	public PushButton getViewButton() {
		return viewButton;
	}
}

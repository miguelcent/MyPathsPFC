package mcm.projects.mypaths.client.view;

import mcm.projects.mypaths.client.presenter.VerRutaPresenter;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Widget;

public class VerRutaView extends Composite implements VerRutaPresenter.Display{

	private static VerRutaViewUiBinder uiBinder = GWT
			.create(VerRutaViewUiBinder.class);

	interface VerRutaViewUiBinder extends UiBinder<Widget, VerRutaView> {
	}
	
	@UiField
	Label tituloLabel;
	@UiField
	Hyperlink linkUsuario;
	@UiField
	FlowPanel mapCanvas;
	@UiField
	ScrollPanel descripcionScrollPanel;
	@UiField
	PushButton comentarButton;
	@UiField
	PushButton valorarButton;

	public VerRutaView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public HasText getTituloLabel() {
		return tituloLabel;
	}

	@Override
	public Hyperlink getUsuarioLink() {
		return linkUsuario;
	}

	@Override
	public FlowPanel getMapCanvas() {
		return mapCanvas;
	}

	@Override
	public ScrollPanel getDescripcionScrollPanel() {
		return descripcionScrollPanel;
	}

	@Override
	public HasClickHandlers getComentarButton() {
		return comentarButton;
	}

	@Override
	public HasClickHandlers getValorarButton() {
		return valorarButton;
	}

}

package mcm.projects.mypaths.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.Widget;

import mcm.projects.mypaths.client.presenter.ValorarRutaPopUpPresenter.Display;

public class ValorarRutaPopUpView extends Composite implements Display{

	private static ValorarRutaPopUpViewUiBinder uiBinder = GWT
			.create(ValorarRutaPopUpViewUiBinder.class);

	interface ValorarRutaPopUpViewUiBinder extends
			UiBinder<Widget, ValorarRutaPopUpView> {
	}
	
	@UiField
	Label valoracionActualLabel;
	@UiField
	Label votosLabel;
	@UiField
	FlowPanel votosGroup;
	@UiField
	RadioButton voto1;
	@UiField
	RadioButton voto2;
	@UiField
	RadioButton voto3;
	@UiField
	RadioButton voto4;
	@UiField
	RadioButton voto5;
	@UiField
	PushButton enviarButton;
	
	public ValorarRutaPopUpView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public HasValue<Boolean> getRadio1() {
		return voto1;
	}

	@Override
	public HasValue<Boolean> getRadio2() {
		return voto2;
	}

	@Override
	public HasValue<Boolean> getRadio3() {
		return voto3;
	}

	@Override
	public HasValue<Boolean> getRadio4() {
		return voto4;
	}

	@Override
	public HasValue<Boolean> getRadio5() {
		return voto5;
	}

	@Override
	public HasClickHandlers getPushButton() {
		return enviarButton;
	}

	@Override
	public FlowPanel getGrupoValoraciones() {
		return votosGroup; 
	}

	@Override
	public Label getValoracionActual() {
		return valoracionActualLabel;
	}

	@Override
	public Label getCuentaValoraciones() {
		return votosLabel;
	}
	
	@Override
	  public Widget asWidget() {
	    return this;
	  }

}

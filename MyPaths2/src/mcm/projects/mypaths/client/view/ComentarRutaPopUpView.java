package mcm.projects.mypaths.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;

import mcm.projects.mypaths.client.presenter.ComentarRutaPopUpPresenter;

public class ComentarRutaPopUpView extends Composite implements ComentarRutaPopUpPresenter.Display{

	private static ComentarRutaPopUpViewUiBinder uiBinder = GWT
			.create(ComentarRutaPopUpViewUiBinder.class);

	interface ComentarRutaPopUpViewUiBinder extends
			UiBinder<Widget, ComentarRutaPopUpView> {
	}
	
	@UiField
	TextArea comentarioInput;
	@UiField
	Label labelUsuario;
	
	public ComentarRutaPopUpView() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	@Override
	public HasText getComentario() {
		return comentarioInput;
	}
	
	@Override
	  public Widget asWidget() {
	    return this;
	  }

	@Override
	public HasText getLabelUsuario() {
		return labelUsuario;
	}
}

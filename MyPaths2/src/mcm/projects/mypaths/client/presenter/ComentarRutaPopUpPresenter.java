package mcm.projects.mypaths.client.presenter;

import mcm.projects.mypaths.client.presenter.ValorarRutaPopUpPresenter.Display;
import mcm.projects.mypaths.client.service.ComentarioService;
import mcm.projects.mypaths.client.service.ComentarioServiceAsync;
import mcm.projects.mypaths.client.service.RutaService;
import mcm.projects.mypaths.client.service.RutaServiceAsync;
import mcm.projects.mypaths.client.service.ValoracionServiceAsync;
import mcm.projects.mypaths.shared.dto.ComentarioDTO;
import mcm.projects.mypaths.shared.dto.RutaDTO;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

public class ComentarRutaPopUpPresenter implements Presenter{
	public interface Display {
		HasText getComentario();
		Widget asWidget();
		HasText getLabelUsuario();
	}
	
	private RutaDTO ruta = new RutaDTO();
	private final SimpleEventBus eventBus;
	private final ComentarioServiceAsync comService;
	private final RutaServiceAsync rutaService;
	private final Display display;
	
	public ComentarRutaPopUpPresenter(ComentarioServiceAsync comentarioService, SimpleEventBus eventBus, Display display, RutaDTO ruta) {
		this.rutaService = GWT.create(RutaService.class);
		this.comService = comentarioService;
		this.eventBus = eventBus;
		this.display = display;
		this.ruta = ruta;
		mock("agtzfm15cGFodHMyMHIRCxIEUnV0YRiAgICA3s_NCAw");
//		paint(ruta);
		bind();
	}
	
	private void paint(RutaDTO ruta2) {
		// TODO Auto-generated method stub
		
	}

	private void bind() {
		// TODO Auto-generated method stub
		
	}

	private void mock(String rutaKey) {
		ComentarioDTO com = new ComentarioDTO();
		com.setUsuarioKey("paco");
		com.setRutaKey(rutaKey);
		com.setTextoComentario("La ruta me ha parecido espectacular.\n Le doy 5 estrellas");
		paintFC(com);
	}

	private void paintFC(ComentarioDTO com) {
		this.display.getComentario().setText(com.getTextoComentario());
		this.display.getLabelUsuario().setText(com.getUsuarioKey());
	}

	@Override
	public void go(HasWidgets container) {
		container.clear();
		container.add(display.asWidget());
	}
	public void go(){
		
	}
}

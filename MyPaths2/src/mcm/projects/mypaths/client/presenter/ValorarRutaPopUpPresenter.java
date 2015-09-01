package mcm.projects.mypaths.client.presenter;

import mcm.projects.mypaths.client.service.RutaService;
import mcm.projects.mypaths.client.service.RutaServiceAsync;
import mcm.projects.mypaths.client.service.ValoracionServiceAsync;
import mcm.projects.mypaths.shared.dto.RutaDTO;
import mcm.projects.mypaths.shared.dto.ValoracionDTO;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class ValorarRutaPopUpPresenter implements Presenter {
	
	public interface Display {
		HasValue<Boolean> getRadio1();
		HasValue<Boolean> getRadio2();
		HasValue<Boolean> getRadio3();
		HasValue<Boolean> getRadio4();
		HasValue<Boolean>  getRadio5();
		HasClickHandlers getPushButton();
		FlowPanel getGrupoValoraciones();
		Label getValoracionActual();
		Label getCuentaValoraciones();
		Widget asWidget();
	}
	
	private RutaDTO ruta = new RutaDTO();
	private ValoracionDTO valoracion = new ValoracionDTO();
	private final SimpleEventBus eventBus;
	private final ValoracionServiceAsync valService;
	private final RutaServiceAsync rutaService;
	private final Display display;
	
	public ValorarRutaPopUpPresenter(ValoracionServiceAsync service, SimpleEventBus bus, Display display, RutaDTO ruta) {
		this.eventBus = bus;
		this.display = display;
		this.ruta = ruta;
		this.valService = service;
		rutaService = GWT.create(RutaService.class);
		mock("agtzfm15cGFodHMyMHIRCxIEUnV0YRiAgICA3s_NCAw");
//		paint(ruta);
		bind();
	}
	
	private void mock(String rutaKey) {
		ValoracionDTO val = new ValoracionDTO();
		val.setUsuarioKey("paco");
		val.setRutaKey(rutaKey);
		val.setCuentaValoracion(8.0);
		val.setValoracionTotal(3.9);
		paintFV(val);
	}

	private void paintFV(ValoracionDTO val) {
		this.display.getCuentaValoraciones().setText("Sobre: "+val.getCuentaValoracion()+" valoraciones.");
		this.display.getValoracionActual().setText("Valoracion actual: "+val.getValoracionTotal()+" puntos de media.");
	}

	private void bind() {
		// TODO Auto-generated method stub
		
	}

	private void paint(RutaDTO ruta2) {
		
	}

	@Override
	public void go(HasWidgets container) {
		container.clear();
		container.add(display.asWidget());
	}
	
	public void go(){
		
	}

}

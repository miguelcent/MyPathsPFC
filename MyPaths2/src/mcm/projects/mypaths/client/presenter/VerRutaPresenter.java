package mcm.projects.mypaths.client.presenter;

import mcm.projects.mypaths.client.event.ValorarRutaEvent;
import mcm.projects.mypaths.client.service.MapaServiceAsync;
import mcm.projects.mypaths.client.utils.MapsUtils;
import mcm.projects.mypaths.shared.dto.RutaDTO;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Widget;

public class VerRutaPresenter implements Presenter {
	
	public interface Display {
		HasText getTituloLabel();

		Hyperlink getUsuarioLink();
		
		FlowPanel getMapCanvas();
		
		ScrollPanel getDescripcionScrollPanel();
		
		HasClickHandlers getComentarButton();
		
		HasClickHandlers getValorarButton();

		Widget asWidget();
	}
	
	private RutaDTO ruta = new RutaDTO();
	private final SimpleEventBus eventBus;
	private final MapaServiceAsync mapaService;
	private final Display display;
	
	public VerRutaPresenter(MapaServiceAsync mapaService, SimpleEventBus eventBus, Display display, RutaDTO ruta){
		this.mapaService = mapaService;
		this.eventBus = eventBus;
		this.display = display;
		this.ruta = ruta;
		paint(ruta);
		bind();
	}
	
	private void bind() {
		this.display.getValorarButton().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				eventBus.fireEvent(new ValorarRutaEvent(ruta));
			}
		});
	}

	private void paint(RutaDTO r) {
		display.getTituloLabel().setText(r.getNombre());
		display.getUsuarioLink().setText(r.getUsuarioKey());
		HTML desc = new HTML(r.getDescripcion());
		display.getDescripcionScrollPanel().add(desc);
		MapsUtils.pintarMapaDefecto(this.display.getMapCanvas());
	}

	@Override
	public void go(HasWidgets container) {
		container.clear();
		container.add(display.asWidget());
	}

}

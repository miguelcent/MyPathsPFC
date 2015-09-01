package mcm.projects.mypaths.client.event;

import mcm.projects.mypaths.shared.dto.RutaDTO;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class ViewRutaEvent extends GwtEvent<ViewRutaEventHandler> {
	public static Type<ViewRutaEventHandler> TYPE = new Type<ViewRutaEventHandler>();
	private final RutaDTO ruta;

	public ViewRutaEvent(RutaDTO ruta) {
		this.ruta = ruta;
	}
	
	public RutaDTO getRuta(){
		return ruta;
	}

	@Override
	public Type<ViewRutaEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(ViewRutaEventHandler handler) {
		handler.onViewRuta(this);
	}
}

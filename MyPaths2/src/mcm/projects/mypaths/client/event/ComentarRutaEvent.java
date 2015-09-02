package mcm.projects.mypaths.client.event;

import mcm.projects.mypaths.shared.dto.RutaDTO;

import com.google.gwt.event.shared.GwtEvent;

public class ComentarRutaEvent extends GwtEvent<ComentarRutaEventHandler>{
	public static Type<ComentarRutaEventHandler> TYPE = new Type<ComentarRutaEventHandler>();
	
	RutaDTO ruta;
	
	public ComentarRutaEvent(RutaDTO ruta) {
		this.ruta = ruta;
	}

	@Override
	public Type<ComentarRutaEventHandler> getAssociatedType() {
		
		return TYPE;
	}
	
	public RutaDTO getRuta(){
		return ruta;
	}

	@Override
	protected void dispatch(ComentarRutaEventHandler handler) {
		handler.onComentarRuta(this);
	}

}

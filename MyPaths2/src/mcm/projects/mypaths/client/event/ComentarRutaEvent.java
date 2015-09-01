package mcm.projects.mypaths.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class ComentarRutaEvent extends GwtEvent<ComentarRutaEventHandler>{
	public static Type<ComentarRutaEventHandler> TYPE = new Type<ComentarRutaEventHandler>();
	@Override
	public Type<ComentarRutaEventHandler> getAssociatedType() {
		
		return TYPE;
	}

	@Override
	protected void dispatch(ComentarRutaEventHandler handler) {
		handler.onValorarRuta(this);
	}

}

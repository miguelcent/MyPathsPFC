package mcm.projects.mypaths.client.event;

import mcm.projects.mypaths.shared.dto.RutaDTO;

import com.google.gwt.event.shared.GwtEvent;

public class ValorarRutaEvent extends GwtEvent<ValorarRutaEventHandler> {
	 public static Type<ValorarRutaEventHandler> TYPE = new Type<ValorarRutaEventHandler>();
	 
	 private final RutaDTO ruta;
	 
	 public ValorarRutaEvent(RutaDTO ruta){
		 this.ruta = ruta;
	 }
	 
	@Override
	public Type<ValorarRutaEventHandler> getAssociatedType() {
		
		return TYPE;
	}

	@Override
	protected void dispatch(ValorarRutaEventHandler handler) {
		handler.onValorarRuta(this);
	}

	public RutaDTO getRuta() {
		return ruta;
	}
}

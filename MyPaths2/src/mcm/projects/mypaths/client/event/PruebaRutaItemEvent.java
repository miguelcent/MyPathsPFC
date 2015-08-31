package mcm.projects.mypaths.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class PruebaRutaItemEvent extends GwtEvent<PruebaRutaItemEventHandler>{

	public static Type<PruebaRutaItemEventHandler> TYPE = new Type<PruebaRutaItemEventHandler>();
	
	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<PruebaRutaItemEventHandler> getAssociatedType() {
		// TODO Auto-generated method stub
		return TYPE;
	}

	@Override
	protected void dispatch(PruebaRutaItemEventHandler handler) {
		handler.onPruebaRutaItem(this);
	}

}

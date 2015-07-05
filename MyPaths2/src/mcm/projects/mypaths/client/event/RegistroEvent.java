package mcm.projects.mypaths.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class RegistroEvent extends GwtEvent<RegistroEventHandler>{
	
	public static Type<RegistroEventHandler> TYPE = new Type<RegistroEventHandler>();
	
	public RegistroEvent(){
		
	}
	
	@Override
	public Type<RegistroEventHandler> getAssociatedType() {
		
		return TYPE;
	}

	@Override
	protected void dispatch(RegistroEventHandler handler) {
		handler.onRegistro(this);
	}
	
	
	
}

package mcm.projects.mypaths.client.event;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class RegistroEvent extends GwtEvent<RegistroEventHandler>{
	
	public static Type<RegistroEventHandler> TYPE = new Type<RegistroEventHandler>();
	
	@Override
	public Type<RegistroEventHandler> getAssociatedType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void dispatch(RegistroEventHandler handler) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}

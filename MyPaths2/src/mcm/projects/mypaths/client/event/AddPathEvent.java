package mcm.projects.mypaths.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class AddPathEvent extends GwtEvent<AddPathEventHandler>{
	
	public static Type<AddPathEventHandler> TYPE = new Type<AddPathEventHandler>();

	@Override
	public Type<AddPathEventHandler> getAssociatedType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void dispatch(AddPathEventHandler handler) {
		// TODO Auto-generated method stub
		
	}
}

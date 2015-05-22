package mcm.projects.mypaths.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class InicioEvent extends GwtEvent<InicioEventHandler>{
	
	public static Type<InicioEventHandler> TYPE = new Type<InicioEventHandler>();
	
	@Override
	public Type<InicioEventHandler> getAssociatedType() {
		// TODO Auto-generated method stub
		return TYPE;
	}

	@Override
	protected void dispatch(InicioEventHandler handler) {
		handler.onInicio(this);
	}

}

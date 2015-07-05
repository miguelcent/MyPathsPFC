package mcm.projects.mypaths.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class RememberEvent extends GwtEvent<RememberEventHandler> {
	
	public static Type<RememberEventHandler> TYPE = new Type<RememberEventHandler>();
	private final String username;
	
	public RememberEvent(String username) {
		this.username = username;
	}
	
	public String getUsername(){
		return username;
	}
	
	@Override
	public Type<RememberEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(RememberEventHandler handler) {
		handler.onRemember(this);
	}

}

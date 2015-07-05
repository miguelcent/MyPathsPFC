package mcm.projects.mypaths.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class EditProfileEvent extends GwtEvent<EditProfileEventHandler>{
	public static Type<EditProfileEventHandler> TYPE = new Type<EditProfileEventHandler>();
	
	@Override
	public Type<EditProfileEventHandler> getAssociatedType() {
		// TODO Auto-generated method stub
		return TYPE;
	}

	@Override
	protected void dispatch(EditProfileEventHandler handler) {
		handler.onEditProfile(this);
	}
}

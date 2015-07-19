package mcm.projects.mypaths.client.event;


import com.google.gwt.event.shared.GwtEvent;

import mcm.projects.mypaths.shared.dto.UsuarioDTO;

public class LoginEvent extends GwtEvent<LoginEventHandler> {
	
	public static Type<LoginEventHandler> TYPE = new Type<LoginEventHandler>();
	private final String username;
	private final String password;
	
	public LoginEvent(UsuarioDTO usuario){
		this.username = usuario.getLogin();
		this.password = usuario.getPassword();
	}
	
	public String getUsername(){
		return username;
	}
	
	public String getPasword(){
		return password;
	}
	
	@Override
	public Type<LoginEventHandler> getAssociatedType() {	
		return TYPE;
	}

	@Override
	protected void dispatch(LoginEventHandler handler) {
		handler.onLogin(this);
	}

}

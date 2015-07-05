package mcm.projects.mypaths.client.utils;

import com.google.gwt.storage.client.Storage;

import mcm.projects.mypaths.client.view.MenuView;

public class MenuUtil {
	
	static Storage st = Storage.getSessionStorageIfSupported();
	
	public static MenuView getMenu(String token) {
		MenuView menuView = new MenuView();
		if(token.equals("Inicio")){
			if (st.getItem("currentUser")==null || st.getItem("currentUser").equals("")) {
				menuView = new MenuView();
				menuView.getMenuBar().removeItem(menuView.getBuscarLink());
				menuView.getMenuBar().removeItem(menuView.getAddPathLink());
				menuView.getMenuBar().removeItem(menuView.getCerrarSesionLink());
				menuView.getMenuBar().removeItem(menuView.getPerfilLink());
			} else {
				menuView = new MenuView();
				menuView.getMenuBar().removeItem(menuView.getBuscarLink());
				menuView.getMenuBar().removeItem(menuView.getLoginLink());
				menuView.getMenuBar().removeItem(menuView.getRegistroLink());
			}
		}
		if (token.equals("Login")) {
			if (st.getItem("currentUser")==null || st.getItem("currentUser").equals("")) {
				menuView = new MenuView();
				menuView.getMenuBar().removeItem(menuView.getBuscarLink());
				menuView.getMenuBar().removeItem(menuView.getAddPathLink());
				menuView.getMenuBar().removeItem(menuView.getCerrarSesionLink());
				menuView.getMenuBar().removeItem(menuView.getPerfilLink());
				menuView.getMenuBar().removeItem(menuView.getLoginLink());
			} else {
				menuView = new MenuView();
				menuView.getMenuBar().removeItem(menuView.getBuscarLink());
				menuView.getMenuBar().removeItem(menuView.getLoginLink());
				menuView.getMenuBar().removeItem(menuView.getRegistroLink());
			}
		}
		if (token.equals("Registro")) {
			if (st.getItem("currentUser")==null || st.getItem("currentUser").equals("")) {
				menuView = new MenuView();
				menuView.getMenuBar().removeItem(menuView.getBuscarLink());
				menuView.getMenuBar().removeItem(menuView.getAddPathLink());
				menuView.getMenuBar().removeItem(menuView.getCerrarSesionLink());
				menuView.getMenuBar().removeItem(menuView.getPerfilLink());
				menuView.getMenuBar().removeItem(menuView.getRegistroLink());
			} else {
				menuView = new MenuView();
				menuView.getMenuBar().removeItem(menuView.getBuscarLink());
				menuView.getMenuBar().removeItem(menuView.getRegistroLink());
				menuView.getMenuBar().removeItem(menuView.getRegistroLink());
			}
		}
		if (token.equals("AddPath")) {
			if (st.getItem("currentUser")==null || st.getItem("currentUser").equals("")) {
				menuView = new MenuView();
				menuView.getMenuBar().removeItem(menuView.getBuscarLink());
				menuView.getMenuBar().removeItem(menuView.getAddPathLink());
				menuView.getMenuBar().removeItem(menuView.getCerrarSesionLink());
				menuView.getMenuBar().removeItem(menuView.getPerfilLink());
				menuView.getMenuBar().removeItem(menuView.getRegistroLink());
			} else {
				menuView = new MenuView();
				menuView.getMenuBar().removeItem(menuView.getBuscarLink());
				menuView.getMenuBar().removeItem(menuView.getRegistroLink());
				menuView.getMenuBar().removeItem(menuView.getRegistroLink());
				menuView.getMenuBar().removeItem(menuView.getAddPathLink());
			}
		}
		if (token.equals("Perfil")) {
			if (st.getItem("currentUser")==null || st.getItem("currentUser").equals("")) {
				menuView = new MenuView();
				menuView.getMenuBar().removeItem(menuView.getBuscarLink());
				menuView.getMenuBar().removeItem(menuView.getAddPathLink());
				menuView.getMenuBar().removeItem(menuView.getCerrarSesionLink());
				menuView.getMenuBar().removeItem(menuView.getPerfilLink());
				menuView.getMenuBar().removeItem(menuView.getRegistroLink());
			} else {
				menuView = new MenuView();
				menuView.getMenuBar().removeItem(menuView.getBuscarLink());
				menuView.getMenuBar().removeItem(menuView.getRegistroLink());
				menuView.getMenuBar().removeItem(menuView.getRegistroLink());
			}
		}
		return menuView;
	}
}

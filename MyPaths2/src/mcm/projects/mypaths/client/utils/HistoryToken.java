package mcm.projects.mypaths.client.utils;

import com.google.gwt.user.client.History;

public enum HistoryToken {
	Inicio, Login, Registro, Buscar, AddPath, Perfil, PruebaRutaItem;
	public void fire(){
		History.newItem(this.toString());
	}
}

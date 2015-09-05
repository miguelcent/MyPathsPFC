package mcm.projects.mypaths.client.presenter;

import java.util.ArrayList;
import java.util.List;

import mcm.projects.mypaths.client.resources.ResourcesBundle;
import mcm.projects.mypaths.client.service.LoginServiceAsync;
import mcm.projects.mypaths.client.service.RutaService;
import mcm.projects.mypaths.client.service.RutaServiceAsync;
import mcm.projects.mypaths.client.view.widgets.ListaRutasWidget;
import mcm.projects.mypaths.client.view.widgets.RutaWidget;
import mcm.projects.mypaths.shared.dto.RutaDTO;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.storage.client.Storage;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class ListaRutasPresenter implements Presenter {
	// Interfaz Display que comunica Presenter y View
	public interface Display {
		VerticalPanel getCellList();
		SimplePager getPager();
		Widget asWidget();
	}

	//

	// Atributos propios de la clase
	// Ruta Service
	private final RutaServiceAsync rs;
	// Login Service
	private final LoginServiceAsync loginService;
	// Bus de eventos
	private final SimpleEventBus se;
	// Display donde mostrar las rutas
	private final Display display;
	//Lista Rutas Usuario
	private List<RutaDTO> listaRutasUsuario;
	// Recursos
	private final ResourcesBundle rb = ResourcesBundle.RESOURCE;

	public ListaRutasPresenter(LoginServiceAsync loginService,
			SimpleEventBus eventbus, ListaRutasWidget listaRutasWidget) {
		this.rs = GWT.create(RutaService.class);
		this.se = eventbus;
		this.display = listaRutasWidget;
		this.loginService = loginService;
		this.listaRutasUsuario = new ArrayList<RutaDTO>();
		rutasUsuarioLogado();
	}

	private void rutasUsuarioLogado() {
		String usuario = Storage.getSessionStorageIfSupported().getItem("currentUser");
		rs.getRutasUsuario(usuario, new AsyncCallback<List<RutaDTO>>() {
			
			@Override
			public void onSuccess(List<RutaDTO> result) {
				listaRutasUsuario = result;
				Window.alert("Del servicio de rutas de usuario: "+listaRutasUsuario.size()+"");
				pintaRutas(listaRutasUsuario);
			}
			
			@Override
			public void onFailure(Throwable caught) {
				Window.alert("No hay usuario logado");
			}
		});
	}

	protected void pintaRutas(List<RutaDTO> listaRutasUsuario2) {
		Window.alert("Al pintaRutas: "+listaRutasUsuario2.size()+"");
		for(RutaDTO r: listaRutasUsuario2){
			RutaWidgetPresenter rp = new RutaWidgetPresenter(r, rs, se, new RutaWidget());
			this.display.getCellList().add(rp.getDisplay());
		}
	}

	@Override
	public void go(HasWidgets container) {
		container.clear();
		container.add(display.asWidget());
	}

	@Override
	public void addIn(VerticalPanel panelPrincipal) {
		// TODO Auto-generated method stub

	}
}

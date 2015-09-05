package mcm.projects.mypaths.client.presenter;

import java.util.ArrayList;
import java.util.List;

import mcm.projects.mypaths.client.service.LoginServiceAsync;
import mcm.projects.mypaths.client.utils.UtilsImages;
import mcm.projects.mypaths.shared.dto.RutaDTO;
import mcm.projects.mypaths.shared.dto.UsuarioDTO;

import com.google.gwt.event.dom.client.HasChangeHandlers;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.storage.client.Storage;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class BusquedaPresenter implements Presenter{

	public interface Display {
		HasChangeHandlers getlistaCategorias();
		HasClickHandlers getBuscarRutas();
		HasValue<String> getInputBusqueda();
		HorizontalPanel getFormContainer();
		SimplePanel getImagenInicio();
		Widget asWidget();
	}
	
	@SuppressWarnings("unused")
	private UsuarioDTO user;
	private final LoginServiceAsync rpcService;
	//TODO eventbus no usado porque aun no estan eventos funcionalidad busqueda de rutas.
	private final SimpleEventBus eventBus;
	private final Display display;
	
	private List<RutaDTO> listaRutas = new ArrayList<RutaDTO>();
	
	public BusquedaPresenter(LoginServiceAsync rpcService,
			SimpleEventBus eventBus, Display display){
		this.rpcService = rpcService;
		this.eventBus = eventBus;
		this.display = display;
		isLogado();
		bind();
	}
	
	private void isLogado() {
		String logado = Storage.getSessionStorageIfSupported().getItem("currentUser");
		rpcService.getLoggedInUserDTO(logado, new AsyncCallback<UsuarioDTO>() {
			
			@Override
			public void onSuccess(UsuarioDTO result) {
				//NADA QUE HACER
			}
			
			@Override
			public void onFailure(Throwable caught) {
				Image img = UtilsImages.getImagenInicio();
				display.getImagenInicio().add(img);
			}
		});
	}
	//TODO eventos de funcionalidad de busqueda de rutas.
	private void bind() {
		
		
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
	public List<RutaDTO> getListaRutas(){
		return listaRutas;
	}
}

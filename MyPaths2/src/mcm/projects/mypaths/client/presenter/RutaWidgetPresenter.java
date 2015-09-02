package mcm.projects.mypaths.client.presenter;

import mcm.projects.mypaths.client.event.ViewRutaEvent;
import mcm.projects.mypaths.client.service.CategoriaRutaService;
import mcm.projects.mypaths.client.service.CategoriaRutaServiceAsync;
import mcm.projects.mypaths.client.service.RutaServiceAsync;
import mcm.projects.mypaths.client.utils.UtilsImages;
import mcm.projects.mypaths.client.view.widgets.RutaWidget;
import mcm.projects.mypaths.shared.dto.CategoriaRutaDTO;
import mcm.projects.mypaths.shared.dto.RutaDTO;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.storage.client.Storage;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class RutaWidgetPresenter implements Presenter {

	public interface Display {
		HasText getTituloLabel();

		HasText getTituloCategoriaLabel();

		HasText getOwnRutaLabel();

		HorizontalPanel getOtherUserPanel();

		HorizontalPanel getOwnUserPanel();

		FlowPanel getImageCategoryWrapper();

		Hyperlink getUserLink();

		PushButton getEditButton();

		PushButton getDeleteButton();

		PushButton getViewButton();

		Widget asWidget();
	}

	private Storage sto = Storage.getSessionStorageIfSupported();
	@SuppressWarnings("unused")
	private String loggedUsername = sto.getItem("currentUser");

	private RutaDTO ruta;
	private CategoriaRutaDTO categoria;
	private final Display display;
	private final SimpleEventBus eventBus;
	private final RutaServiceAsync rutaService;
	private final CategoriaRutaServiceAsync categoriaService;
	

	public RutaWidgetPresenter(String rutaKey, RutaServiceAsync rutaService,
			SimpleEventBus eventBus, Display display) {
		this.display = display;
		this.eventBus = eventBus;
		this.rutaService = rutaService;
		this.ruta = new RutaDTO();
		this.categoria = new CategoriaRutaDTO();
		categoriaService = GWT
				.create(CategoriaRutaService.class);
		loadRutaDetails(rutaKey);
		bind();
				
	}

	private void bind() {
		this.display.getViewButton().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				eventBus.fireEvent(new ViewRutaEvent(ruta));
			}
		});
	}

	private void loadRutaDetails(String rutaKey) {
		rutaService.get(rutaKey, new AsyncCallback<RutaDTO>() {
			
			@Override
			public void onSuccess(RutaDTO result) {
				ruta = result;
				loadCategoriaRutaAndDraw(ruta);
			}
			
			@Override
			public void onFailure(Throwable caught) {
				Window.alert("error retrieving ruta from id");
			}
		});
		
	}
	
	public void setRuta(RutaDTO ruta) {
		this.ruta = ruta;
	}

	private void loadCategoriaRutaAndDraw(RutaDTO ruta) {
		categoriaService.getCategoriaFromCategoriaName(ruta.getCategoriaKey(), new AsyncCallback<CategoriaRutaDTO>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("RutaWidgetPresenter: Ruta de categoría no recuperable.");
			}

			@Override
			public void onSuccess(CategoriaRutaDTO result) {
				categoria = result;
				cargaVista();
//				categoriaService.getImagenCategoria(result.getImagenCategoria(), new AsyncCallback<UploadedImageDTO>() {
//
//					@Override
//					public void onFailure(Throwable caught) {
//						Window.alert("RutaWidgetPresenter: Recuperada categoría, pero no se encuentra imagen en ImageService.");
//					}
//
//					@Override
//					public void onSuccess(UploadedImageDTO result) {
//						cargaVista(result);
//					}
//				});
				
			}
		});
	
	}

	protected void cargaVista() {
		
		RutaWidgetPresenter.this.display.getTituloCategoriaLabel().setText(categoria.getNombreCategoria());
		RutaWidgetPresenter.this.display.getTituloLabel().setText(ruta.getNombre());
		RutaWidgetPresenter.this.display.getUserLink().setText(ruta.getUsuarioKey());
		
		
//setting image category		
		Image img = selectImagenCategoria(categoria);
		RutaWidgetPresenter.this.display
				.getImageCategoryWrapper()
				.add(img);
		
//		if (!(loggedUsername == null || loggedUsername.equals(""))) {
//			if (loggedUsername.equals(ruta.getUsuarioKey())) {
//				loadMine();
//			} else {
//				loadOther();
//			}
//		} else {
//			loadOther();
//		}
//		EditProfilePresenter.this.display
//		.getImagenWrapper().add(
//				UtilsImages
//						.getImagenPorDefecto());
	}

	private Image selectImagenCategoria(CategoriaRutaDTO categoria) {
		Image imagenCategoria; 
		switch (categoria.getNombreCategoria()){
			case "Ciclismo":	imagenCategoria = UtilsImages.getImagenCiclismo();
								break;
			case "Gastronomica": 	imagenCategoria = UtilsImages.getImagenGastronomica();
									break;
			case "Running":	imagenCategoria = UtilsImages.getImagenRunning();
							break;
			case "Senderismo":	imagenCategoria = UtilsImages.getImagenSenderismo();
								break;
			case "Turistica":	imagenCategoria = UtilsImages.getImagenTuristica();
								break;
			default: imagenCategoria = UtilsImages.getImagenPorDefecto();
		}
		imagenCategoria.setWidth("40px");
		imagenCategoria.setHeight("40px");
		return imagenCategoria;
	}

	@SuppressWarnings("unused")
	private void loadMine() {
		this.display.getOtherUserPanel().setVisible(false);
		this.display.getOwnUserPanel().setVisible(true);
	}

	@SuppressWarnings("unused")
	private void loadOther() {
		this.display.getOtherUserPanel().setVisible(true);
		this.display.getOwnUserPanel().setVisible(false);
	}
	
	@Override
	public void go(HasWidgets container) {
		container.clear();
		container.add(display.asWidget());
	}
	
	@Override
	public void addIn(VerticalPanel container) {
		container.add(display.asWidget());
	}
	
	public RutaWidget getDisplay(){
		return (RutaWidget) display;
	}

}

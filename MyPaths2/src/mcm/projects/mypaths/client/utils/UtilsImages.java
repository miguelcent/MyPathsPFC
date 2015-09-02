package mcm.projects.mypaths.client.utils;

import mcm.projects.mypaths.client.resources.ResourcesBundle;

import com.google.gwt.user.client.ui.Image;

public class UtilsImages {
	public static Image getImagenPorDefecto(){
		ResourcesBundle res = ResourcesBundle.RESOURCE;
		Image blankProfile = new Image(res.profileBlank());
		return blankProfile;
	}
	
	public static Image getEditRutaImage(){
		ResourcesBundle res = ResourcesBundle.RESOURCE;
		Image editImage = new Image(res.editar());
		return editImage;
	}
	
	public static Image getDeleteRutaImage(){
		ResourcesBundle res = ResourcesBundle.RESOURCE;
		Image deleteImage = new Image(res.eliminar());
		return deleteImage;
	}

	public static Image getViewRutaImage() {
		ResourcesBundle res = ResourcesBundle.RESOURCE;
		Image viewRutaImage = new Image(res.verMapa());
		return viewRutaImage;
	}

	public static Image getImagenCiclismo() {
		ResourcesBundle res = ResourcesBundle.RESOURCE;
		Image imagenImage = new Image(res.ciclistaBlue());
		return imagenImage;
	}

	public static Image getImagenGastronomica() {
		ResourcesBundle res = ResourcesBundle.RESOURCE;
		Image gastroImage = new Image(res.gastronomicoBlue());
		return gastroImage;
	}

	public static Image getImagenRunning() {
		ResourcesBundle res = ResourcesBundle.RESOURCE;
		Image runningImage = new Image(res.runningBlue());
		return runningImage;
	}

	public static Image getImagenSenderismo() {
		ResourcesBundle res = ResourcesBundle.RESOURCE;
		Image senderismoImage = new Image(res.senderismoBlue());
		return senderismoImage;
	}

	public static Image getImagenTuristica() {
		ResourcesBundle res = ResourcesBundle.RESOURCE;
		Image turisticaImagen = new Image(res.turisticoBlue());
		return turisticaImagen;
	}
	
	public static Image getImagenInicio() {
		ResourcesBundle res = ResourcesBundle.RESOURCE;
		Image imagenInicio = new Image(res.imagenInicio());
		return imagenInicio;
	}
}

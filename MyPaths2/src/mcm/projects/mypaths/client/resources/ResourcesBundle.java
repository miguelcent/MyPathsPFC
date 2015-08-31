/**
 * 
 */
package mcm.projects.mypaths.client.resources;



import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

/**
 * @author Miguel
 *
 */
public interface ResourcesBundle extends ClientBundle {
	
	public static final ResourcesBundle RESOURCE =  GWT.create(ResourcesBundle.class);
	
	@Source("ciclista-blue.png")
	ImageResource ciclistaBlue();

	@Source("compartir-facebook.png")
	ImageResource compartirFacebook();
	
	@Source("editar.png")
	ImageResource editar();
	
	@Source("eliminar.png")
	ImageResource eliminar();

	@Source("gastronomico-blue.png")
	ImageResource gastronomicoBlue();

	@Source("icono-compartir-google-+.png")
	ImageResource iconoCompartirGoogle();

	@Source("icono-google-+.png")
	ImageResource iconoGoogle();

	@Source("icono-google-maps.png")
	ImageResource iconoGoogleMaps();

	@Source("icono-twitter.jpg")
	ImageResource iconoTwitter();

	ImageResource logo();
	
	@Source("logo200.png")
	ImageResource logo200();
	
	@Source("mapa_fondo_fuente.PNG")
	ImageResource mapa_fondo_fuente();

	ImageResource mapa_fondo_fuenteNY();

	@Source("running-blue.png")
	ImageResource runningBlue();

	@Source("senderismo-blue.png")
	ImageResource senderismoBlue();

	@Source("turistico-blue.png")
	ImageResource turisticoBlue();
	
	@Source("blank_profile.gif")
	ImageResource profileBlank();

	@Source("verMapa.png")
	ImageResource verMapa();

}

package mcm.projects.mypaths.server;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import mcm.projects.mypaths.client.service.UploadCategoriaRutas;
import mcm.projects.mypaths.shared.dto.CategoriaRutaDTO;
import mcm.projects.mypaths.shared.dto.UploadedImageDTO;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.images.ImagesService;
import com.google.appengine.api.images.ImagesServiceFactory;
import com.google.appengine.api.images.ServingUrlOptions;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class UploadCategoriaRutasImpl extends RemoteServiceServlet implements UploadCategoriaRutas{

	@Override
	public void up() {
		DatastoreService ser = DatastoreServiceFactory.getDatastoreService();
		CategoriaRutaDTO ciclismo = new CategoriaRutaDTO();
		CategoriaRutaDTO gastronomica = new CategoriaRutaDTO();
		CategoriaRutaDTO running = new CategoriaRutaDTO();
		CategoriaRutaDTO senderismo = new CategoriaRutaDTO();
		CategoriaRutaDTO turistica = new CategoriaRutaDTO();
		
		ciclismo.setKey("Ciclismo");
		ciclismo.setImagenCategoria("agtzfm15cGFodHMyMHIaCxINVXBsb2FkZWRJbWFnZRiAgICAvvGLCgw");
		ciclismo.setNombreCategoria("Ciclismo");
		gastronomica.setKey("Gastronomica");
		gastronomica.setImagenCategoria("agtzfm15cGFodHMyMHIaCxINVXBsb2FkZWRJbWFnZRiAgIDAyMWMCQw");
		gastronomica.setNombreCategoria("Gastronomica");
		running.setKey("Running");
		running.setImagenCategoria("agtzfm15cGFodHMyMHIaCxINVXBsb2FkZWRJbWFnZRiAgICAwN-XCgw");
		running.setNombreCategoria("Running");
		senderismo.setKey("Senderismo");
		senderismo.setImagenCategoria("agtzfm15cGFodHMyMHIaCxINVXBsb2FkZWRJbWFnZRiAgICAuo2JCQw");
		senderismo.setNombreCategoria("Senderismo");
		turistica.setKey("Turistica");
		turistica.setImagenCategoria("agtzfm15cGFodHMyMHIaCxINVXBsb2FkZWRJbWFnZRiAgICAoMSOCgw");
		turistica.setNombreCategoria("Turistica");
////Subida imagenes categorias	
//		ImagesService imagesService = ImagesServiceFactory.getImagesService();
//		
//		BlobKey key = new BlobKey("AMIfv94nVQOMiTC__TPsR1K2Rjbw2I8VTUs9DEOh3ftx3nBtvPsINuPXvrk9ezCPTnLUee65lqOgyef5xooPmEUrtz8qNTvRcRLVFuCSncjwUCFlfmXexK_7tZqkO52zaZJ5yGLAXU4cHQyFgXgMxWIkHHaEoRlCVQ");
//		ServingUrlOptions so = ServingUrlOptions.Builder.withBlobKey(key);
//		String imageUrl =  imagesService.getServingUrl(so);
//		Entity uploadedImage = new Entity("UploadedImage");
//     	uploadedImage.setProperty("blobKey", key);
//     	uploadedImage.setProperty(UploadedImageDTO.CREATED_AT, new Date());
//     	uploadedImage.setUnindexedProperty(UploadedImageDTO.SERVING_URL, imageUrl);
//     	
//		BlobKey key2 = new BlobKey("AMIfv94vjcG3X551fx3ElIEzWAnWOX45VhUB0so9ktkJNdYfN050FAshDV_YOh_cVeucb4IOKtzr8r9DQtyK-Sd7InDG3AovUJaiT94oaCEL4TNb3I9rNyvp6RzySL7gU6_yG9HsOG7aim9oayc2TdffOdi9pTQVzw");
//		ServingUrlOptions so2 = ServingUrlOptions.Builder.withBlobKey(key2);
//		String imageUrl2 =  imagesService.getServingUrl(so2);
//		Entity uploadedImage2 = new Entity("UploadedImage");
//     	uploadedImage2.setProperty("blobKey", key2);
//     	uploadedImage2.setProperty(UploadedImageDTO.CREATED_AT, new Date());
//     	uploadedImage2.setUnindexedProperty(UploadedImageDTO.SERVING_URL, imageUrl2);
//     	
//     	BlobKey key3 = new BlobKey("AMIfv95g21T1y3uSqrCElzYUxrn1qb7oNcymiVvdiPsbaMgPZE16tWAU6ygp5m5rzb0C5E6uOJdk9SUO0GX6yee5p9j84VhKtcsRvQ1OmrsOptMmEcJglzDdL5A5k9GJaLjP7R4GromWul9AVzKVlE2KNdORcWwynw");
//		ServingUrlOptions so3 = ServingUrlOptions.Builder.withBlobKey(key3);
//		String imageUrl3 =  imagesService.getServingUrl(so3);
//		Entity uploadedImage3 = new Entity("UploadedImage");
//     	uploadedImage3.setProperty("blobKey", key3);
//     	uploadedImage3.setProperty(UploadedImageDTO.CREATED_AT, new Date());
//     	uploadedImage3.setUnindexedProperty(UploadedImageDTO.SERVING_URL, imageUrl3);
//     	
//     	BlobKey key4 = new BlobKey("AMIfv97xt95a9FB_1qWczzdXMFUCby9ovJjYOFfJIAXOl3kIT7cxiZwjhPtwVpZGam3kFurjM3CHZuFaYYkR-UPyd0l553LYIwT1wBCYEGDzHyunXtFRRH-3stf1Rn964_OtEJ50InUPY9dawrjzZZB2J0jK0u7p6A");
//		ServingUrlOptions so4 = ServingUrlOptions.Builder.withBlobKey(key4);
//		String imageUrl4 =  imagesService.getServingUrl(so4);
//		Entity uploadedImage4 = new Entity("UploadedImage");
//     	uploadedImage4.setProperty("blobKey", key4);
//     	uploadedImage4.setProperty(UploadedImageDTO.CREATED_AT, new Date());
//     	uploadedImage4.setUnindexedProperty(UploadedImageDTO.SERVING_URL, imageUrl4);
//     	
//     	BlobKey key5 = new BlobKey("AMIfv97yRsqplKa7N4a3-oj-QgWcfZEI65S9lkSJsty2hoRAH7khZ-xc1OD4ULuzfRlgk21kvRqQRGhomD4XPUCYd3KnODCoSZwq8npSkrla-HoABmhCwxIGBygVrbPA-AaSAFo-Wxy99JDmP3H2D7YvqcVmDrCipg");
//		ServingUrlOptions so5 = ServingUrlOptions.Builder.withBlobKey(key5);
//		String imageUrl5 =  imagesService.getServingUrl(so5);
//		Entity uploadedImage5 = new Entity("UploadedImage");
//     	uploadedImage5.setProperty("blobKey", key5);
//     	uploadedImage5.setProperty(UploadedImageDTO.CREATED_AT, new Date());
//     	uploadedImage5.setUnindexedProperty(UploadedImageDTO.SERVING_URL, imageUrl5);
//     	
//     	ser.put(uploadedImage);
//     	ser.put(uploadedImage2);
//     	ser.put(uploadedImage3);
//     	ser.put(uploadedImage4);
//     	ser.put(uploadedImage5);
		
		Entity cic = new Entity("CategoriaRuta", ciclismo.getKey());
		cic.setProperty("imagenCategoria", ciclismo.getImagenCategoria());
		cic.setProperty("nombreCategoria", ciclismo.getNombreCategoria());
		
		Entity gas = new Entity("CategoriaRuta", gastronomica.getKey());
		gas.setProperty("imagenCategoria", gastronomica.getImagenCategoria());
		gas.setProperty("nombreCategoria", gastronomica.getNombreCategoria());
		
		Entity run = new Entity("CategoriaRuta", running.getKey());
		run.setProperty("imagenCategoria", running.getImagenCategoria());
		run.setProperty("nombreCategoria", running.getNombreCategoria());
		
		Entity sen = new Entity("CategoriaRuta", senderismo.getKey());
		sen.setProperty("imagenCategoria", senderismo.getImagenCategoria());
		sen.setProperty("nombreCategoria", senderismo.getNombreCategoria());
		
		Entity tur = new Entity("CategoriaRuta", turistica.getKey());
		tur.setProperty("imagenCategoria", turistica.getImagenCategoria());
		tur.setProperty("nombreCategoria", turistica.getNombreCategoria());
		
		List<Entity> entidades = new ArrayList<Entity>();
		
		entidades.add(cic);
		entidades.add(run);
		entidades.add(sen);
		entidades.add(tur);
		entidades.add(gas);
		
		ser.put(entidades);
	}

}

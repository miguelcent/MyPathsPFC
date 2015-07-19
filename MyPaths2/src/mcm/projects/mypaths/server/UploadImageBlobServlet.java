package mcm.projects.mypaths.server;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mcm.projects.mypaths.shared.dto.UploadedImageDTO;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.images.ImagesService;
import com.google.appengine.api.images.ImagesServiceFactory;
import com.google.appengine.api.images.ServingUrlOptions;

@SuppressWarnings("serial")
public class UploadImageBlobServlet extends HttpServlet {
	private static final Logger log = Logger.getLogger(UploadImageBlobServlet.class
            .getName());
 
    private BlobstoreService blobstoreService = BlobstoreServiceFactory
            .getBlobstoreService();
 
    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
    	
        
        Map<String, List<BlobKey>> blobs = blobstoreService.getUploads(req);
        List<BlobKey> blobKeys = blobs.get("image");
        
        if (null==blobKeys){
        	
        }
        else{
        	BlobKey key = blobKeys.get(0);
            ImagesService imagesService = ImagesServiceFactory
                    .getImagesService();
            
            ServingUrlOptions so = ServingUrlOptions.Builder.withBlobKey(key);
           
            
            // Get the image serving URL
            String imageUrl =  imagesService.getServingUrl(so);
            		
            Entity uploadedImage = new Entity("UploadedImage");
        	uploadedImage.setProperty("blobKey", key);
        	uploadedImage.setProperty(UploadedImageDTO.CREATED_AT, new Date());
        	
        	
        	// Highly unlikely we'll ever search on this property
        	uploadedImage.setUnindexedProperty(UploadedImageDTO.SERVING_URL, imageUrl);
        		
 
            DatastoreService datastore = DatastoreServiceFactory
                    .getDatastoreService();
            datastore.put(uploadedImage);
            
            String keyString = KeyFactory.keyToString(uploadedImage.getKey());
            
            res.sendRedirect("/uploadimageblob?uploadImageKey="+keyString);
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
    	
    	String uploadedImageKey = req.getParameter("uploadImageKey");
    	resp.setHeader("Content-Type", "text/html");
    	resp.getWriter().println(uploadedImageKey);
    	
    }
 
}

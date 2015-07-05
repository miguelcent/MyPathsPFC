package mcm.projects.mypaths.client.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.images.ImagesService;
import com.google.appengine.api.images.ImagesServiceFactory;
import com.google.appengine.api.images.ServingUrlOptions;

@SuppressWarnings("serial")
public class UploadBlobServlet extends HttpServlet {
	private static final Logger log = Logger.getLogger(UploadBlobServlet.class
            .getName());
 
    private BlobstoreService blobstoreService = BlobstoreServiceFactory
            .getBlobstoreService();
 
    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
    	
    	List<BlobKey>	blobs	=	blobstoreService.getUploads(req).get("image");
        BlobKey blobKey = blobs.get(0);
 
        if (blobKey == null) {
            // Uh ... something went really wrong here
        } else {
 
            ImagesService imagesService = ImagesServiceFactory
                    .getImagesService();
            
            ServingUrlOptions so = ServingUrlOptions.Builder.withBlobKey(blobKey);
           
            
            // Get the image serving URL
            String imageUrl =  imagesService.getServingUrl(so);
            		
            // For the sake of clarity, we'll use low-level entities
            Entity uploadedImage = new Entity("UploadedImage");
            uploadedImage.setProperty("blobKey", blobKey);
            uploadedImage.setProperty("createdAt", new Date());
 
            // Highly unlikely we'll ever filter on this property
            uploadedImage.setUnindexedProperty("iamgeURL",
                    imageUrl);
 
            DatastoreService datastore = DatastoreServiceFactory
                    .getDatastoreService();
            datastore.put(uploadedImage);
 
            res.sendRedirect("/upload?imageUrl=" + imageUrl);
        }
    }
 
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
 
        String imageUrl = req.getParameter("imageUrl");
        resp.setHeader("Content-Type", "text/html");
 
        // This is a bit hacky, but it'll work. We'll use this key in an Async
        // service to
        // fetch the image and image information
        resp.getWriter().println(imageUrl);
 
    }
}

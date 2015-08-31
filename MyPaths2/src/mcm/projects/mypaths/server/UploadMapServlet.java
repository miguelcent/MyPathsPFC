package mcm.projects.mypaths.server;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mcm.projects.mypaths.shared.TiposMapa;
import mcm.projects.mypaths.shared.dto.MapaDTO;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.KeyFactory;

@SuppressWarnings("serial")
public class UploadMapServlet extends HttpServlet{
	private BlobstoreService blobstoreService = BlobstoreServiceFactory
            .getBlobstoreService();
 
    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
    	
        
        Map<String, List<BlobKey>> blobs = blobstoreService.getUploads(req);
        List<BlobKey> blobKeys = blobs.get("map");
        
        if (null==blobKeys){
        	
        }
        else{
        	BlobKey key = blobKeys.get(0);
        	Entity map = new Entity("Mapa");
        	map.setUnindexedProperty(MapaDTO.SERVING_URL, key.getKeyString());
        	map.setProperty(MapaDTO.TIPO_MAPA, TiposMapa.KML.toString());
        	DatastoreService datastore = DatastoreServiceFactory
                    .getDatastoreService();
            datastore.put(map);
            String keyString = KeyFactory.keyToString(map.getKey());
            res.sendRedirect("/uploadMap?uploadMapaKey="+keyString);
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
    	
    	String uploadedMapaKey = req.getParameter("uploadMapaKey");
    	resp.setHeader("Content-Type", "text/html");
    	resp.getWriter().println(uploadedMapaKey);
    	
    }
}

package mcm.projects.mypaths.server;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;

@SuppressWarnings("serial")
public class Serve2 extends HttpServlet {
    @SuppressWarnings("unused")
	private BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res)
        throws IOException {
    		String blobkey = req.getParameter("uploadImageKey");
	    	res.setHeader("Content-Type", "text/html");
	        res.getWriter().println(blobkey);
    	
//	    	Storage sto = Storage.getLocalStorageIfSupported();
//	        sto.setItem("imageUrl", req.getParameter("imageUrl"));
//	        sto.setItem("blob-key", req.getParameter("blob-key"));
    	
//	    	BlobKey blobKey = new BlobKey(req.getParameter("blob-key"));
//	        blobstoreService.serve(blobKey, res);
        }
}

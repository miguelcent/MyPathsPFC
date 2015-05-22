package mcm.projects.mypaths.client.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;

public class Serve extends HttpServlet{
	private BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
	private DatastoreService dt = DatastoreServiceFactory.getDatastoreService();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
            List<Entity> toPersist = new ArrayList<Entity>();
    		
    		BlobKey blobCiclista = new BlobKey(req.getParameter("blobCiclista"));
            blobstoreService.serve(blobCiclista, res);
            BlobKey blobGastro = new BlobKey(req.getParameter("blobGastro"));
            blobstoreService.serve(blobGastro, res);
            BlobKey blobRun = new BlobKey(req.getParameter("blobRun"));
            blobstoreService.serve(blobRun, res);
            BlobKey blobSend = new BlobKey(req.getParameter("blobSend"));
            blobstoreService.serve(blobSend, res);
            BlobKey blobTur = new BlobKey(req.getParameter("blobTur"));
            blobstoreService.serve(blobTur, res);
            
            Entity ciclismo = new Entity("CategoriaRuta", "Ciclismo");
            ciclismo.setProperty("nombreCategoria", "Ciclismo");
            ciclismo.setProperty("imagenCategoria", blobCiclista.toString());
            Entity gastronomica = new Entity("CategoriaRuta", "Gastronomica");
            gastronomica.setProperty("nombreCategoria", "Gastronomica");
            gastronomica.setProperty("imagenCategoria", blobGastro.toString());
            Entity running = new Entity("CategoriaRuta", "Running");
            running.setProperty("nombreCategoria", "Running");
            running.setProperty("imagenCategoria", blobRun.toString());
            Entity senderismo = new Entity("CategoriaRuta", "Senderismo");
            senderismo.setProperty("nombreCategoria", "Senderismo");
            senderismo.setProperty("imagenCategoria", blobSend.toString());
            Entity turistica = new Entity("CategoriaRuta", "Turistica");
            turistica.setProperty("nombreCategoria", "Turistica");
            turistica.setProperty("imagenCategoria", blobTur.toString());
            
            toPersist.add(ciclismo);
            toPersist.add(gastronomica);
            toPersist.add(running);
            toPersist.add(senderismo);
            toPersist.add(turistica);
            
            dt.put(toPersist);
            
    }

}

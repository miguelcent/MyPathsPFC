package mcm.projects.mypaths.client.utils;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;

public class Upload extends HttpServlet {
	private BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {

        Map<String, List<BlobKey>> blobs = blobstoreService.getUploads(req);
        List<BlobKey> blobCiclista = blobs.get("myFileCicl");
        List<BlobKey> blobGastro = blobs.get("myFileGastro");
        List<BlobKey> blobRun = blobs.get("myFileRunning");
        List<BlobKey> blobSend = blobs.get("myFileSenderismo");
        List<BlobKey> blobTur = blobs.get("myFileTuristico");

        if ((blobCiclista == null || blobCiclista.isEmpty())&&
        		(blobGastro == null || blobGastro.isEmpty())&&
        		(blobRun == null || blobRun.isEmpty())&&
        		(blobSend == null || blobSend.isEmpty())&&
        		(blobTur == null || blobTur.isEmpty())) {
            res.sendRedirect("/");
        } else {
            res.sendRedirect("/serve?blobCiclista=" + blobCiclista.get(0).getKeyString()
            				+ "&blobGastro=" + blobGastro.get(0).getKeyString()
            				+ "&blobRun=" + blobRun.get(0).getKeyString()
            				+ "&blobSend=" + blobSend.get(0).getKeyString()
            				+ "&blobTur=" + blobTur.get(0).getKeyString());
        }
    }


}

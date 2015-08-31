package mcm.projects.mypaths.server;

import java.util.List;

import mcm.projects.mypaths.client.service.CategoriaRutaService;
import mcm.projects.mypaths.server.dao.CategoriaRutaDao;
import mcm.projects.mypaths.server.dao.RutaDao;
import mcm.projects.mypaths.server.dao.UploadedImageDao;
import mcm.projects.mypaths.shared.dto.CategoriaRutaDTO;
import mcm.projects.mypaths.shared.dto.RutaDTO;
import mcm.projects.mypaths.shared.dto.UploadedImageDTO;
import mcm.projects.mypaths.uml.UploadedImage;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class CategoriaRutaServiceImpl extends RemoteServiceServlet implements
		CategoriaRutaService {

	@Override
	public void add(CategoriaRutaDTO categoria) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(String categoriaKey) {
		// TODO Auto-generated method stub

	}

	@Override
	public CategoriaRutaDTO edit(CategoriaRutaDTO categoriaOriginal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CategoriaRutaDTO> getCategorias() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CategoriaRutaDTO getCategoriaFromKey(String categoriaKey) {
		CategoriaRutaDao dao = new CategoriaRutaDao();
		CategoriaRutaDTO ruta = dao.getByKey(categoriaKey);
		return ruta;
	}

	@Override
	public CategoriaRutaDTO getCategoriaFromCategoriaName(String categoriaName) {
		CategoriaRutaDao dao = new CategoriaRutaDao();
		CategoriaRutaDTO ruta = dao.getByName(categoriaName);
		return ruta;
	}

	@Override
	public UploadedImageDTO getImagenCategoria(String imagenKey) {
		UploadedImageDao dao = new UploadedImageDao();
		UploadedImageDTO uploadedImage = dao.get(imagenKey);
		return uploadedImage;
	}

}

package mcm.projects.mypaths.client.service;

import java.util.List;

import mcm.projects.mypaths.shared.dto.CategoriaRutaDTO;
import mcm.projects.mypaths.shared.dto.UploadedImageDTO;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("categoriaRutaService")
public interface CategoriaRutaService extends RemoteService {
	void add(CategoriaRutaDTO categoria);
	void remove(String categoriaKey);
	CategoriaRutaDTO edit(CategoriaRutaDTO categoriaOriginal);
	List<CategoriaRutaDTO> getCategorias();
	CategoriaRutaDTO getCategoriaFromKey(String categoriaKey);
	CategoriaRutaDTO getCategoriaFromCategoriaName(String categoriaName);
	UploadedImageDTO getImagenCategoria(String imagenKey);
}

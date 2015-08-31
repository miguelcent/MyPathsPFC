package mcm.projects.mypaths.client.service;

import java.util.List;

import mcm.projects.mypaths.shared.dto.CategoriaRutaDTO;
import mcm.projects.mypaths.shared.dto.UploadedImageDTO;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CategoriaRutaServiceAsync {
	public void add(CategoriaRutaDTO categoria, AsyncCallback<Void> async);
	public void edit(CategoriaRutaDTO categoriaOriginal, AsyncCallback<CategoriaRutaDTO> categoriaEditada);
	public void remove(String categoriaKey, AsyncCallback<Void> async);
	public void getCategorias(AsyncCallback<List<CategoriaRutaDTO>> categorias);
	public void getCategoriaFromKey(String categoriaKey, AsyncCallback<CategoriaRutaDTO> categoria);
	public void getCategoriaFromCategoriaName(String categoriaName, AsyncCallback<CategoriaRutaDTO> categoria);
	public void getImagenCategoria(String imagenKey, AsyncCallback<UploadedImageDTO> imagenDTO);
}

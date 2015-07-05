package mcm.projects.mypaths.shared.builder;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.datastore.Email;
import com.google.appengine.api.datastore.KeyFactory;

import mcm.projects.mypaths.server.domain.Usuario;
import mcm.projects.mypaths.shared.dto.UsuarioDTO;

public class UsuarioBuilder {
	public static UsuarioDTO getUsuarioDTO(Usuario usuario){
		
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		
		usuarioDTO.setApellidos(usuario.getApellidos());
		if(usuario.getCiudad()!=null){
			usuarioDTO.setCiudad(usuario.getCiudad());
		}
		if(usuario.getCodigo_postal()!=null){
			usuarioDTO.setCodigo_postal(usuario.getCodigo_postal());
		}
		
		usuarioDTO.setEmail(usuario.getEmail().getEmail());
		usuarioDTO.setKey(KeyFactory.keyToString(usuario.getKey()));
		if(usuario.getImagen_avatar()!=null){
			usuarioDTO.setImage_avavatar_KEY(usuario.getImagen_avatar().toString());
		}
		usuarioDTO.setLogin(usuario.getLogin());
		usuarioDTO.setNombre(usuario.getNombre());
		usuarioDTO.setPais(usuario.getPais());
		usuarioDTO.setPassword(usuario.getPassword());
		//TODO nunca debe de ser null, pero no se esta seteando en login
		if(usuario.getUltimoLogin()!=null){
			usuarioDTO.setUltimoLogin(usuario.getUltimoLogin());
		}
		if(usuario.getUltimoLogout()!=null){
			usuarioDTO.setUltimoLogout(usuario.getUltimoLogout());
		}
		
		return usuarioDTO;
	}
	
	public static Usuario getUsuario(UsuarioDTO usuarioDTO){
		
		Usuario usuario = new Usuario();
		
		usuario.setApellidos(usuarioDTO.getApellidos());
		if(usuarioDTO.getCiudad()!=null){
			usuario.setCiudad(usuarioDTO.getCiudad());
		}
		if(usuarioDTO.getCodigo_postal()!=null){
			usuario.setCodigo_postal(usuarioDTO.getCodigo_postal());
		}
		usuario.setEmail(new Email(usuarioDTO.getEmail()));
		
			usuario.setKey(KeyFactory.createKey(Usuario.class.getSimpleName(), usuarioDTO.getLogin()));
		
		if(usuarioDTO.getImage_avavatar_KEY()!=null){
			usuario.setImagen_avatar(new BlobKey(usuarioDTO.getImage_avavatar_KEY()));
		}
		usuario.setLogin(usuarioDTO.getLogin());
		usuario.setNombre(usuarioDTO.getNombre());
		usuario.setPais(usuarioDTO.getPais());
		usuario.setPassword(usuarioDTO.getPassword());
		if(usuarioDTO.getUltimoLogin()!=null){
			usuario.setUltimoLogin(usuarioDTO.getUltimoLogin());
		}
		if(usuarioDTO.getUltimoLogout()!=null){
			usuario.setUltimoLogout(usuarioDTO.getUltimoLogout());
		}
		
		return usuario;
	}
}

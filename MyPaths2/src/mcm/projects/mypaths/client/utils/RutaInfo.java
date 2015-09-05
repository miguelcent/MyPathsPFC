package mcm.projects.mypaths.client.utils;

import mcm.projects.mypaths.shared.dto.RutaDTO;

import com.google.gwt.view.client.ProvidesKey;

public class RutaInfo implements Comparable<RutaInfo> {

	/**
	 * The key provider that provides the unique ID of a contact.
	 */
	public static final ProvidesKey<RutaInfo> KEY_PROVIDER = new ProvidesKey<RutaInfo>() {
		@Override
		public Object getKey(RutaInfo item) {
			return item == null ? null : item.getId();
		}
	};

	private String id;
	private String nombreRuta;
	private String categoriaRuta;
	private String usuarioRuta;

	public RutaInfo(RutaDTO dto) {
		this.id = dto.getKey();
		this.nombreRuta = dto.getNombre();
		this.categoriaRuta = dto.getCategoriaKey();
		this.usuarioRuta = dto.getUsuarioKey();
	}

	@Override
	public int compareTo(RutaInfo o) {
		return (o == null || o.nombreRuta == null) ? -1 : -o.nombreRuta
				.compareTo(nombreRuta);
	}
	
	@Override
    public boolean equals(Object o) {
      if (o instanceof RutaInfo) {
        return id == ((RutaInfo) o).id;
      }
      return false;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombreRuta() {
		return nombreRuta;
	}

	public void setNombreRuta(String nombreRuta) {
		this.nombreRuta = nombreRuta;
	}

	public String getCategoriaRuta() {
		return categoriaRuta;
	}

	public void setCategoriaRuta(String categoriaRuta) {
		this.categoriaRuta = categoriaRuta;
	}

	public String getUsuarioRuta() {
		return usuarioRuta;
	}

	public void setUsuarioRuta(String usuarioRuta) {
		this.usuarioRuta = usuarioRuta;
	}

}

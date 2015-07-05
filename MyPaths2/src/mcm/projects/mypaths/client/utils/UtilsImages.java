package mcm.projects.mypaths.client.utils;

import mcm.projects.mypaths.client.resources.ResourcesBundle;

import com.google.gwt.user.client.ui.Image;

public class UtilsImages {
	public static Image getImagenPorDefecto(){
		ResourcesBundle res = ResourcesBundle.RESOURCE;
		Image blankProfile = new Image(res.profileBlank());
		return blankProfile;
	}
}

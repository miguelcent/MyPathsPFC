package mcm.projects.mypaths.client.utils;

import mcm.projects.mypaths.client.presenter.AddPathPresenter.Display;

public class ValidateFormsUtil {

	

	public static boolean validateAddPathForm(Display display) {
		boolean ret = true;
		if(display.getTituloInput().getValue().equals("")||display.getTituloInput().getValue()==null){
			display.getValidationMessages().setText("");
			ret = false;
			display.getValidationMessages().setText("Necesario rellenar titulo");
		}
		if(display.getDescripcionInput().getValue().equals("")||display.getDescripcionInput().getValue()==null){
			display.getValidationMessages().setText("");
			ret = false;
			display.getValidationMessages().setText("Necesario rellenar descripción");
		}
		return ret;
	}

}

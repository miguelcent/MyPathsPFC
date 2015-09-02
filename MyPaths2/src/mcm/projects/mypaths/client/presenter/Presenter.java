package mcm.projects.mypaths.client.presenter;

import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.VerticalPanel;

public abstract interface Presenter {
	 public abstract void go(final HasWidgets container);

	public abstract void addIn(VerticalPanel panelPrincipal);
}

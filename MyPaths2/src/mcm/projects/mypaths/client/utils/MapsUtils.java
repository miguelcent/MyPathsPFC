package mcm.projects.mypaths.client.utils;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.maps.gwt.client.GoogleMap;
import com.google.maps.gwt.client.LatLng;
import com.google.maps.gwt.client.MapOptions;
import com.google.maps.gwt.client.MapTypeId;
import com.google.maps.gwt.client.Marker;

import mcm.projects.mypaths.client.view.AddPathView;

public class MapsUtils {
	
	public static void pintarMapaDefecto(FlowPanel vista){
		LatLng sevilla = LatLng.create(37.388096, -5.982330);
	    MapOptions options = MapOptions.create();
	    options.setZoom(12);
	    options.setMapTypeId(MapTypeId.ROADMAP);
	    options.setDraggable(true);
	    options.setMapTypeControl(true);
	    options.setScaleControl(true);
	    options.setScrollwheel(true);
	    GoogleMap gMap = GoogleMap.create(vista.getElement(), options);
	    gMap.setCenter(sevilla);
	    Marker marker = Marker.create();
	    marker.setPosition(sevilla);
	    marker.setMap(gMap);
	    marker.setTitle("Hola a todos");
	}
	
}

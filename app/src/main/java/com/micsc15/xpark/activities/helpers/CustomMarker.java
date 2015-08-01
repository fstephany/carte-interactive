package com.micsc15.xpark.activities.helpers;

import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.overlay.Marker;
import com.mapbox.mapboxsdk.views.MapView;
import com.micsc15.xpark.R;

public class CustomMarker extends Marker {


    // -------------- Objects, Variables -------------- //


    // ------------------ Constructor ----------------- //

    public CustomMarker(MapView mapView, String title, String description, LatLng latLng) {
        super(mapView, title, description, latLng);
    }


    // ------------------ Listeners ------------------- //


    // ------------------- Methods -------------------- //

    @Override
    protected CustomInfoWindow createTooltip(MapView mapView) {
        return new CustomInfoWindow(R.layout.map_info_window, mapView);
    }



    // -------------------- Divers -------------------- //

}

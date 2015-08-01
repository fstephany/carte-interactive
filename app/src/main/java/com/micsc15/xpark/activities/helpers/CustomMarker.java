package com.micsc15.xpark.activities.helpers;

import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.overlay.Marker;
import com.mapbox.mapboxsdk.views.MapView;
import com.micsc15.xpark.R;
import com.micsc15.xpark.models.ParkAttraction;

public class CustomMarker extends Marker {


    // -------------- Objects, Variables -------------- //

    ParkAttraction parkAttraction;

    // ------------------ Constructor ----------------- //

    public CustomMarker(MapView mapView, ParkAttraction parkAttraction){
        super(mapView, parkAttraction.Name, "", new LatLng(parkAttraction.Latitude, parkAttraction.Longitude));
        this.parkAttraction = parkAttraction;
    }


    // ------------------ Listeners ------------------- //


    // ------------------- Methods -------------------- //

    @Override
    protected CustomInfoWindow createTooltip(MapView mapView) {
        return new CustomInfoWindow(R.layout.map_info_window, mapView);
    }



    // -------------------- Divers -------------------- //

}

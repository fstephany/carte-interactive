package com.micsc15.xpark.activities.helpers;

import android.content.Intent;

import com.mapbox.mapboxsdk.overlay.Marker;
import com.mapbox.mapboxsdk.views.InfoWindow;
import com.mapbox.mapboxsdk.views.MapView;
import com.micsc15.xpark.activities.NewsActivity;

public class CustomInfoWindow extends InfoWindow {

    // -------------- Objects, Variables -------------- //


    // ------------------ Constructor ----------------- //

    public CustomInfoWindow(int resId, MapView mapView) {
        super(resId, mapView);
    }


    // ------------------ Listeners ------------------- //


    // ------------------- Methods -------------------- //

    @Override
    public void onOpen(Marker overlayItem) {
        //super.onOpen(overlayItem);
    }

    @Override
    public void onClose() {
        super.onClose();
        getView().getContext().startActivity(new Intent(getView().getContext(), NewsActivity.class));
    }


    // -------------------- Divers -------------------- //

}

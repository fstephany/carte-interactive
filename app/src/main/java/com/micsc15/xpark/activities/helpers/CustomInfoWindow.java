package com.micsc15.xpark.activities.helpers;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.mapbox.mapboxsdk.overlay.Marker;
import com.mapbox.mapboxsdk.views.InfoWindow;
import com.mapbox.mapboxsdk.views.MapView;
import com.micsc15.xpark.R;

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
        Button button = (Button) getView().findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getView().getContext(), "jiojoijoij", Toast.LENGTH_LONG).show();
            }
        });
    }


    // -------------------- Divers -------------------- //

}

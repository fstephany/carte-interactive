package com.micsc15.xpark.activities.helpers;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.mapbox.mapboxsdk.overlay.Marker;
import com.mapbox.mapboxsdk.views.InfoWindow;
import com.mapbox.mapboxsdk.views.MapView;
import com.micsc15.xpark.R;
import com.micsc15.xpark.models.ParkAttraction;

public class CustomInfoWindow extends InfoWindow {

    // -------------- Objects, Variables -------------- //

    ParkAttraction parkAttraction;


    // ------------------ Constructor ----------------- //

    public CustomInfoWindow(int resId, MapView mapView, ParkAttraction parkAttraction) {
        super(resId, mapView);
        this.parkAttraction = parkAttraction;
    }


    // ------------------ Listeners ------------------- //


    // ------------------- Methods -------------------- //

    @Override
    public void onOpen(Marker overlayItem) {
        ((TextView) getView().findViewById(R.id.textView_Title)).setText(parkAttraction.Name);

        Button button = (Button) getView().findViewById(R.id.bt_Details);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getView().getContext(), "jiojoijoij", Toast.LENGTH_LONG).show();
            }
        });
    }


    // -------------------- Divers -------------------- //

}

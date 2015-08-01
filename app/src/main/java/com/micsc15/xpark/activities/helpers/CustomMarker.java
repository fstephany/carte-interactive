package com.micsc15.xpark.activities.helpers;

import android.content.res.Resources;

import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.overlay.Icon;
import com.mapbox.mapboxsdk.overlay.Marker;
import com.mapbox.mapboxsdk.views.MapView;
import com.micsc15.xpark.R;
import com.micsc15.xpark.models.ParkAttraction;
import com.micsc15.xpark.models.enums.AttractionType;

public class CustomMarker extends Marker {


    // -------------- Objects, Variables -------------- //

    ParkAttraction parkAttraction;

    // ------------------ Constructor ----------------- //

    public CustomMarker(Resources resources, MapView mapView, ParkAttraction parkAttraction){
        super(mapView, parkAttraction.Name, "", new LatLng(parkAttraction.Latitude, parkAttraction.Longitude));
        this.parkAttraction = parkAttraction;
        switch(parkAttraction.AttractionType){
            case 0:
            default:
                this.setIcon(new Icon(resources.getDrawable(R.drawable.animal_menu)));
                break;
            case 1:
                this.setIcon(new Icon(resources.getDrawable(R.drawable.food_menu)));
                break;
            case 2:
                this.setIcon(new Icon(resources.getDrawable(R.drawable.news_pin)));
                break;
        }


    }


    // ------------------ Listeners ------------------- //


    // ------------------- Methods -------------------- //

    @Override
    protected CustomInfoWindow createTooltip(MapView mapView) {
        return new CustomInfoWindow(R.layout.map_info_window, mapView);
    }



    // -------------------- Divers -------------------- //

}

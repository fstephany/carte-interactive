package com.micsc15.xpark.activities.helpers;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.overlay.Icon;
import com.mapbox.mapboxsdk.overlay.Marker;
import com.mapbox.mapboxsdk.views.MapView;
import com.micsc15.xpark.R;
import com.micsc15.xpark.models.ParkAttraction;

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
                this.setIcon(new Icon(resources.getDrawable(R.drawable.animal_pin)));
                break;
            case 1:
                this.setIcon(new Icon(resources.getDrawable(R.drawable.food_pin)));
                break;
            case 2:
                this.setIcon(new Icon(resources.getDrawable(R.drawable.news_pin)));
                break;
        }


    }

private Drawable getResizedIcon(Resources resources, Drawable dr){
    Bitmap bitmap = ((BitmapDrawable) dr).getBitmap();
    Drawable d = new BitmapDrawable(resources, Bitmap.createScaledBitmap(bitmap, 250, 300, true));
    return d;
}
    // ------------------ Listeners ------------------- //


    // ------------------- Methods -------------------- //

    @Override
    protected CustomInfoWindow createTooltip(MapView mapView) {
        return new CustomInfoWindow(R.layout.map_info_window, mapView, parkAttraction);
    }



    // -------------------- Divers -------------------- //

}

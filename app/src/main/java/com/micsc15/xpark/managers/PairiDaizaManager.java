package com.micsc15.xpark.managers;

import com.mapbox.mapboxsdk.api.ILatLng;
import com.micsc15.xpark.models.Card;
import com.micsc15.xpark.models.ParkArea;
import com.micsc15.xpark.models.ParkAttraction;

import java.util.UUID;

public class PairiDaizaManager {

    // -------------- Objects, Variables -------------- //

    public static ILatLng iLatLng = new ILatLng() {
        @Override
        public double getLatitude() {
            return 50.584768;
        }

        @Override
        public double getLongitude() {
            return 3.886962;
        }

        @Override
        public double getAltitude() {
            return 0;
        }
    };


    // --------------- Public Methods ----------------- //

    public static ParkAttraction GetAttractionCard(UUID attractionID){
        ParkAttraction attraction = null;

        for (ParkArea area : MapManager.ParkAreas) {
            if(area.Attractions != null){
                for (ParkAttraction attr: area.Attractions) {
                    if(attr.AttractionID == attractionID){
                        attraction = attr;
                    }
                }
            }
        }

        return attraction;
    }

    // --------------- Private Methods ---------------- //


    // ----------------- Miscellaneous ---------------- //

}

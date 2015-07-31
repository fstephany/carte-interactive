package com.micsc15.xpark.managers;

import com.mapbox.mapboxsdk.api.ILatLng;

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


    // --------------- Private Methods ---------------- //


    // ----------------- Miscellaneous ---------------- //

}

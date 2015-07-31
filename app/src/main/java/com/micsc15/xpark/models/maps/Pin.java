package com.micsc15.xpark.models.maps;

import java.util.UUID;

public class Pin {

    // -------------- Objects, Variables -------------- //

    // ------------------ Properties ------------------ //

    public UUID PinID;
    public String ImageUrl;
    public double Latitude;
    public double Longitude;

    // ------------------ Constructor ----------------- //

    public Pin(){}

    public Pin(UUID pinID, String imageUrl, double latitude, double longitude){
        this.PinID = pinID;
        this.ImageUrl = imageUrl;
        this.Latitude = latitude;
        this.Longitude = longitude;
    }

    // --------------- Public Methods ----------------- //


    // --------------- Private Methods ---------------- //


    // ----------------- Miscellaneous ---------------- //

}

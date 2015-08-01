package com.micsc15.xpark.models;

import com.micsc15.xpark.models.enums.AttractionType;

import java.util.UUID;

public class ParkAttraction {

    // -------------- Objects, Variables -------------- //

    // ------------------ Properties ------------------ //

    public UUID PinID;
    public String ImageUrl;
    public double Latitude;
    public double Longitude;
    public AttractionType AttractionType;

    // ------------------ Constructor ----------------- //

    public ParkAttraction(){}

    public ParkAttraction(UUID pinID, String imageUrl, double latitude, double longitude){
        this.PinID = pinID;
        this.ImageUrl = imageUrl;
        this.Latitude = latitude;
        this.Longitude = longitude;
    }

    // --------------- Public Methods ----------------- //


    // --------------- Private Methods ---------------- //


    // ----------------- Miscellaneous ---------------- //

}

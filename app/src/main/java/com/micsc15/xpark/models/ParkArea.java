package com.micsc15.xpark.models;

import java.util.ArrayList;
import java.util.UUID;

public class ParkArea {

    // -------------- Objects, Variables -------------- //

    // ------------------ Properties ------------------ //

    public String Name;
    public String Description;
    public string ImageUrl;
    public UUID AreaID;
    public ArrayList<ParkAttraction> Attractions;

    // ------------------ Constructor ----------------- //

    public ParkArea(){
        Attractions = new ArrayList<ParkAttraction>();
    }


    // --------------- Public Methods ----------------- //


    // --------------- Private Methods ---------------- //


    // ----------------- Miscellaneous ---------------- //
}

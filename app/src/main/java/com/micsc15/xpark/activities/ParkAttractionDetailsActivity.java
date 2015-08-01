package com.micsc15.xpark.activities;

import android.os.Bundle;

import com.micsc15.xpark.managers.ParkAttractionManager;
import com.micsc15.xpark.models.ParkAttraction;

import java.util.UUID;

public class ParkAttractionDetailsActivity extends BaseActivity {

    // -------------- Objects, Variables -------------- //

    public static final String EXTRA_PARK_ATTRACTION_ID = "extraParkAttractionID";


    // --------------------- Views -------------------- //


    // ------------------ LifeCycle ------------------- //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ParkAttraction attraction = ParkAttractionManager.getParkAttraction(UUID.fromString(getIntent().getStringExtra(EXTRA_PARK_ATTRACTION_ID)));
        
    }


    // ------------------ Listeners ------------------- //


    // ------------------- Methods -------------------- //


    // --------------------- Menu --------------------- //


    // ----------------- GUI Adapter ------------------ //


    // ----------------- Miscellaneous ---------------- //

}

package com.micsc15.xpark.activities;

import android.os.Bundle;

import com.facebook.FacebookSdk;

public class SplashActivity extends BaseActivity {

    // -------------- Objects, Variables -------------- //


    // ------------------ Properties ------------------ //


    // ------------------ Constructor ----------------- //


    // ------------------- Methods -------------------- //


    // ------------ Gestion de la DataBase ------------ //


    // --------------------- Views -------------------- //


    // ------------------ LifeCycle ------------------- //


    // ----------------- GUI Adapter ------------------ //


    // ------------------ Listeners ------------------- //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // setup Facebook SDK
        FacebookSdk.sdkInitialize(getApplicationContext());

    }


    // -------------------- Divers -------------------- //

}

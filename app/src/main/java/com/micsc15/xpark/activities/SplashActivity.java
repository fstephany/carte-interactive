package com.micsc15.xpark.activities;

import android.os.Bundle;
import android.os.PersistableBundle;

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
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        // initialize Facebook SDK
        FacebookSdk.sdkInitialize(getApplicationContext());

    }


    // -------------------- Divers -------------------- //

}

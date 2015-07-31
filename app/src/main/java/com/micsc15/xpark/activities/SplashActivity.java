package com.micsc15.xpark.activities;

import android.content.Intent;
import android.os.Bundle;

import com.facebook.FacebookSdk;

public class SplashActivity extends BaseActivity {


    // -------------- Objects, Variables -------------- //


    // --------------------- Views -------------------- //


    // ------------------ LifeCycle ------------------- //


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // setup Facebook SDK
        FacebookSdk.sdkInitialize(getApplicationContext());

        startActivity(new Intent(SplashActivity.this, MapActivity.class));
        finish();
    }


    // ------------------ Listeners ------------------- //


    // ----------------- GUI Adapter ------------------ //


    // ----------------- Miscellaneous ---------------- //

}

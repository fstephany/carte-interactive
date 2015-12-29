package com.micsc15.xpark.activities;

import android.content.Intent;
import android.os.Bundle;
import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;

import com.crashlytics.android.Crashlytics;

import io.fabric.sdk.android.Fabric;

public class SplashActivity extends BaseActivity {


    // -------------- Objects, Variables -------------- //


    // --------------------- Views -------------------- //


    // ------------------ LifeCycle ------------------- //


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        startActivity(new Intent(SplashActivity.this, MapActivity.class));
        finish();
    }


    // ------------------ Listeners ------------------- //


    // ----------------- GUI Adapter ------------------ //


    // ----------------- Miscellaneous ---------------- //

}

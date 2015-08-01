package com.micsc15.xpark.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.MarkerOptions;
import com.micsc15.xpark.R;
import com.micsc15.xpark.managers.ParkAttractionManager;
import com.micsc15.xpark.models.ParkAttraction;
import com.micsc15.xpark.models.enums.AttractionType;

public class MapActivity extends BaseActivity implements View.OnClickListener {

    // -------------- Objects, Variables -------------- //


    // --------------------- Views -------------------- //

    private GoogleMap googleMap;

    private FloatingActionsMenu floatingActionsMenu;
    private FloatingActionButton fab_FilterAll, fab_FilterNews2015, fab_FilterEat, fab_FilterAnimationsAndFeed;


    // ------------------ LifeCycle ------------------- //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        setUpMap();

        fab_FilterAll = (FloatingActionButton) findViewById(R.id.fab_FilterAll);
        fab_FilterAll.setOnClickListener(this);
        fab_FilterNews2015 = (FloatingActionButton) findViewById(R.id.fab_FilterNews2015);
        fab_FilterNews2015.setOnClickListener(this);
        fab_FilterEat = (FloatingActionButton) findViewById(R.id.fab_FilterEat);
        fab_FilterEat.setOnClickListener(this);
        fab_FilterAnimationsAndFeed = (FloatingActionButton) findViewById(R.id.fab_FilterAnimationsAndFeed);
        fab_FilterAnimationsAndFeed.setOnClickListener(this);

        floatingActionsMenu = (FloatingActionsMenu) findViewById(R.id.floatingActionsMenu);

        drawMarkers(null);
    }


    // ------------------ Listeners ------------------- //

    @Override
    public void onClick(View v) {
        if (v == fab_FilterAll)
            drawMarkers(null);
        else if (v == fab_FilterAnimationsAndFeed)
            drawMarkers(AttractionType.ATTRACTION);
        else if (v == fab_FilterEat)
            drawMarkers(AttractionType.RESTAURANT);
        else if (v == fab_FilterNews2015)
            drawMarkers(AttractionType.NEWATTRACTION);

        floatingActionsMenu.collapse();
    }


    // ------------------- Methods -------------------- //


    private void setUpMap() {
        if (googleMap == null) {
            googleMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
googleMap.animateCamera(new CameraUpdate());

//        mapView.setCenter(PairiDaizaManager.iLatLng);
//        mapView.setZoom(18);
//        mapView.setScrollableAreaLimit(new BoundingBox(new LatLng(50.588746, 3.896243), new LatLng(50.580461, 3.879834)));

        }
        drawMarkers(null);
    }

    private void drawMarkers(AttractionType attractionType) {
        if (googleMap != null)
            for (ParkAttraction attraction : attractionType != null ? ParkAttractionManager.getParkAttractions(getBaseContext(), attractionType.ordinal()) : ParkAttractionManager.getParkAttractions(getBaseContext())) {
                // CustomMarker marker = new CustomMarker(getResources(), mapView, attraction);
                // mapView.addMarker(marker);
                googleMap.addMarker(new MarkerOptions().position(new com.google.android.gms.maps.model.LatLng(0, 0)).title("Marker"));
            }
    }


    // -------------------- Menu ---------------------- //

    private final int MENU_NEWS = 3473;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, MENU_NEWS, 0, "News");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case MENU_NEWS:
                startActivity(new Intent(MapActivity.this, NewsActivity.class));
                break;
        }

        return super.onOptionsItemSelected(item);
    }


    // ----------------- Miscellaneous ---------------- //

}
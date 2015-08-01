package com.micsc15.xpark.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;
import com.mapbox.mapboxsdk.geometry.BoundingBox;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.overlay.Icon;
import com.mapbox.mapboxsdk.views.MapView;
import com.micsc15.xpark.R;
import com.micsc15.xpark.activities.helpers.CustomMarker;
import com.micsc15.xpark.managers.MapManager;
import com.micsc15.xpark.managers.PairiDaizaManager;
import com.micsc15.xpark.models.ParkAttraction;

public class MapActivity extends BaseActivity implements View.OnClickListener {

    // -------------- Objects, Variables -------------- //


    // --------------------- Views -------------------- //

    private MapView mapView;

    private FloatingActionsMenu floatingActionsMenu;
    private FloatingActionButton fab_FilterAll, fab_FilterNews2015, fab_FilterEat, fab_FilterAnimationsAndFeed;


    // ------------------ LifeCycle ------------------- //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        mapView = (MapView) findViewById(R.id.mapView);
        mapView.setCenter(PairiDaizaManager.iLatLng);
        mapView.setZoom(18);
        mapView.setScrollableAreaLimit(new BoundingBox(new LatLng(50.588746, 3.896243), new LatLng(50.580461, 3.879834)));

        fab_FilterAll = (FloatingActionButton) findViewById(R.id.fab_FilterAll);
        fab_FilterAll.setOnClickListener(this);
        fab_FilterNews2015 = (FloatingActionButton) findViewById(R.id.fab_FilterNews2015);
        fab_FilterNews2015.setOnClickListener(this);
        fab_FilterEat = (FloatingActionButton) findViewById(R.id.fab_FilterEat);
        fab_FilterEat.setOnClickListener(this);
        fab_FilterAnimationsAndFeed = (FloatingActionButton) findViewById(R.id.fab_FilterAnimationsAndFeed);
        fab_FilterAnimationsAndFeed.setOnClickListener(this);

        floatingActionsMenu = (FloatingActionsMenu) findViewById(R.id.floatingActionsMenu);

        drawMarkers();
    }


    // ------------------ Listeners ------------------- //

    @Override
    public void onClick(View v) {
        if (v == fab_FilterAll) {
            drawMarkers();
        }

        floatingActionsMenu.collapse();
    }


    // ------------------- Methods -------------------- //

    private void drawMarkers() {
        mapView.clear();

        for (ParkAttraction attraction : MapManager.GetMapPins(getBaseContext())) {
            CustomMarker marker = new CustomMarker(mapView, attraction);
            marker.setIcon(new Icon(getResources().getDrawable(R.drawable.ic_launcher)));
            mapView.addMarker(marker);
        }
    }


    // ----------------- GUI Adapter ------------------ //


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
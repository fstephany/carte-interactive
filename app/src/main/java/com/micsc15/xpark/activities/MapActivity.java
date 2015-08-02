package com.micsc15.xpark.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.micsc15.xpark.R;
import com.micsc15.xpark.managers.PairiDaizaManager;
import com.micsc15.xpark.managers.ParkAttractionManager;
import com.micsc15.xpark.models.ParkAttraction;
import com.micsc15.xpark.models.enums.AttractionType;

import java.util.HashMap;

public class MapActivity extends BaseActivity implements View.OnClickListener, GoogleMap.InfoWindowAdapter, GoogleMap.OnInfoWindowClickListener {

    // -------------- Objects, Variables -------------- //

    private HashMap<Marker, ParkAttraction> markersParkAttrationsMap;

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

    @Override
    public View getInfoWindow(Marker marker) {
        final ParkAttraction parkAttraction = markersParkAttrationsMap.get(marker);

        final View view = getLayoutInflater().inflate(R.layout.map_info_window, null);
        ((TextView) view.findViewById(R.id.textView_Title)).setText(parkAttraction.Name);

        return view;
    }

    @Override
    public View getInfoContents(Marker marker) {
        return null;
    }

    @Override
    public void onInfoWindowClick(Marker marker) {
        final ParkAttraction parkAttraction = markersParkAttrationsMap.get(marker);
        startActivity(
                new Intent(MapActivity.this, ParkAttractionDetailsActivity.class)
                        .putExtra(ParkAttractionDetailsActivity.EXTRA_PARK_ATTRACTION_ID, parkAttraction.AttractionID.toString()));
    }


    // ------------------- Methods -------------------- //


    private void setUpMap() {
        if (googleMap == null) {
            googleMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
            if (googleMap == null) {
                // google map not available
                return;
            }
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(PairiDaizaManager.latLng, 17));
            googleMap.setInfoWindowAdapter(this);
            googleMap.setOnInfoWindowClickListener(this);
            googleMap.setMyLocationEnabled(true);
        }

        drawMarkers(null);
    }

    private void drawMarkers(AttractionType attractionType) {
        if (googleMap != null) {
            googleMap.clear();
            markersParkAttrationsMap = new HashMap<>();

            for (ParkAttraction attraction : attractionType != null ? ParkAttractionManager.getParkAttractions(getBaseContext(), attractionType.ordinal()) : ParkAttractionManager.getParkAttractions(getBaseContext())) {

                int iconResourceId = 0;
                if (attraction.AttractionType == 0)
                    iconResourceId = R.drawable.animal_pin;
                else if (attraction.AttractionType == 1)
                    iconResourceId = R.drawable.food_pin;
                else if (attraction.AttractionType == 2)
                    iconResourceId = R.drawable.news_pin;

                Marker marker = googleMap.addMarker(new MarkerOptions()
                        .position(new LatLng(attraction.Latitude, attraction.Longitude))
                        .icon(BitmapDescriptorFactory.fromResource(iconResourceId)));

                markersParkAttrationsMap.put(marker, attraction);
            }
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
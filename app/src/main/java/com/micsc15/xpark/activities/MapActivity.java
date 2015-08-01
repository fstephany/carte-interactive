package com.micsc15.xpark.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.overlay.Icon;
import com.mapbox.mapboxsdk.views.MapView;
import com.micsc15.xpark.R;
import com.micsc15.xpark.activities.helpers.CustomMarker;
import com.micsc15.xpark.managers.MapManager;
import com.micsc15.xpark.managers.PairiDaizaManager;
import com.micsc15.xpark.models.maps.Pin;

public class MapActivity extends BaseActivity implements View.OnClickListener {

    // -------------- Objects, Variables -------------- //


    // --------------------- Views -------------------- //

    private MapView mapView;

    private FloatingActionsMenu fam;
    private FloatingActionButton fabA, fabB;


    // ------------------ LifeCycle ------------------- //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        mapView = (MapView) findViewById(R.id.mapView);
        mapView.setCenter(PairiDaizaManager.iLatLng);
        mapView.setZoom(18);

        drawMarkers();

        fabA = (FloatingActionButton) findViewById(R.id.action_a);
        fabA.setOnClickListener(this);

        fabB = (FloatingActionButton) findViewById(R.id.action_b);
        fabB.setOnClickListener(this);

        fam = (FloatingActionsMenu) findViewById(R.id.multiple_actions);
    }


    // ------------------ Listeners ------------------- //

    @Override
    public void onClick(View v) {
        if (v == fabA)
            Toast.makeText(getBaseContext(), "jiojioji", Toast.LENGTH_LONG).show();

        fam.collapse();
    }


    // ------------------- Methods -------------------- //

    private void drawMarkers() {
        for (Pin pin : MapManager.GetMapPins()) {
            CustomMarker marker = new CustomMarker(mapView, "title", "description", new LatLng(pin.Latitude, pin.Longitude));
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
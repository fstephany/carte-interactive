package com.micsc15.xpark.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.mapbox.mapboxsdk.views.MapView;
import com.micsc15.xpark.R;
import com.micsc15.xpark.managers.PairiDaizaManager;

public class MapActivity extends BaseActivity {

    // -------------- Objects, Variables -------------- //


    // --------------------- Views -------------------- //

    private MapView mapView;


    // ------------------ LifeCycle ------------------- //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        mapView = (MapView) findViewById(R.id.mapView);
        mapView.setCenter(PairiDaizaManager.iLatLng);
        mapView.setZoom(18);

        drawMarkers();
    }


    // ------------------ Listeners ------------------- //


    // ------------------- Methods -------------------- //

    private void drawMarkers(){
//        Marker marker = new Marker(mapView, "title", "description", new LatLng(PairiDaizaManager.iLatLng.getLatitude(), PairiDaizaManager.iLatLng.getLongitude()));
//        marker.setImage(getResources().getDrawable(R.drawable.ic_launcher));
//        marker.setIcon(new Icon(getResources().getDrawable(R.drawable.ic_launcher)));
//        marker.setToolTip(new InfoWindow(R.layout.map_info_window, mapView));
//        mapView.addMarker(marker);
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
        switch (item.getItemId()){
            case MENU_NEWS:
                startActivity(new Intent(MapActivity.this, NewsActivity.class));
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    // ----------------- Miscellaneous ---------------- //

}
package com.micsc15.xpark.activities;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.micsc15.xpark.R;

public class BaseActivity extends AppCompatActivity {

    // -------------- Objects, Variables -------------- //


    // --------------------- Views -------------------- //

    private ActionBarDrawerToggle drawerToggle;


    // ------------------ LifeCycle ------------------- //

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        manageNavigationDrawer();

        drawerToggle.syncState();
    }


    // ------------------ Listeners ------------------- //




    // ------------------- Methods -------------------- //

    protected void manageNavigationDrawer() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        DrawerLayout mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        drawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.app_name, R.string.app_name) {

            public void onDrawerOpened(View drawerView) {
            }

            public void onDrawerClosed(View view) {
            }
        };
        drawerToggle.setDrawerIndicatorEnabled(true);
        mDrawerLayout.setDrawerListener(drawerToggle);

        manageNavigationDrawerContent();

    }

    private void manageNavigationDrawerContent(){
        ListView listView = (ListView) findViewById(R.id.listView_NavigationDrawer);
        listView.setAdapter(new Adapter());
    }


    // --------------------- Menu --------------------- //

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }


    // ----------------- GUI Adapter ------------------ //

    private class Adapter extends BaseAdapter {

        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return null;
        }
    }


    // ----------------- Miscellaneous ---------------- //

}

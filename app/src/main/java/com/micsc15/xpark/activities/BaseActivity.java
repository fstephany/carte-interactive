package com.micsc15.xpark.activities;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.micsc15.xpark.R;

import java.util.ArrayList;

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
        ArrayList<NavigationMenuItem> menuitems = new ArrayList<NavigationMenuItem>();

        menuitems.add(new NavigationMenuItem(R.drawable.map_drawer, "Carte"));
        menuitems.add(new NavigationMenuItem(R.drawable.list_drawer, "liste des activités"));
        menuitems.add(new NavigationMenuItem(R.drawable.news_drawer, "Actualité"));
        menuitems.add(new NavigationMenuItem(R.drawable.info_drawer, "Infos pratique"));
        menuitems.add(new NavigationMenuItem(R.drawable.mail_drawer, "Contact"));

        ListView listView = (ListView) findViewById(R.id.listView_NavigationDrawer);
        ImageView imageview =  new ImageView(getBaseContext());
        imageview.setImageResource(R.drawable.drawer_image);


        listView.addHeaderView(imageview);
        listView.setAdapter(new Adapter(menuitems));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              // if(position == 3){
                //   startActivity(new Intent(BaseActivity.this, NewsActivity.class));
               //}else{
                //   startActivity(new Intent(BaseActivity.this, MapActivity.class));
               //}
            }
        });
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

        public ArrayList<NavigationMenuItem> menuItems;

        public Adapter(ArrayList<NavigationMenuItem> menuItems){
            this.menuItems = menuItems;
        }

        @Override
        public int getCount() {
            return menuItems.size();
        }

        @Override
        public NavigationMenuItem getItem(int position) {
            return menuItems.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            NavigationMenuItem item = getItem(position);

            View view = getLayoutInflater().inflate(R.layout.menu_item, null);
            ((TextView)view.findViewById(R.id.textView)).setText(item.text);
            ((ImageView) view.findViewById(R.id.imageView)).setImageResource(item.imageResourceID);

            return view;
        }

    }


    // ----------------- Miscellaneous ---------------- //
    public class NavigationMenuItem{

        public int imageResourceID;
        public String text;

        public NavigationMenuItem(int imageResourceID, String text){
            this.imageResourceID = imageResourceID;
            this.text = text;
        }
    }
}



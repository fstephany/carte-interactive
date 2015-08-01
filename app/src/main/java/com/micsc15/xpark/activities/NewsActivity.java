package com.micsc15.xpark.activities;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.micsc15.xpark.R;
import com.micsc15.xpark.dataaccess.facebook.FacebookGraphResponse;
import com.micsc15.xpark.managers.NewsManager;
import com.micsc15.xpark.models.Facebook.NewsSchema;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by fd on 31-07-15.
 */
public class NewsActivity extends BaseActivity {

    // -------------- Objects, Variables -------------- //

    private NewsManager _newsManager;

    // --------------------- Views -------------------- //

    ListView lvNews;


    // ------------------ LifeCycle ------------------- //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        // get reference to the views
        lvNews = (ListView) findViewById(R.id.lvNews);

        // init members
        _newsManager = new NewsManager(getBaseContext());

        // check if you are connected or not
        if (isConnected()) {
            // call AsyncTask to perform network operation on separate thread
            new NewsAsyncTask().execute();
        }
    }


    // ------------------ Listeners ------------------- //


    // ------------------- Methods -------------------- //

    public boolean isConnected() {
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        } else {
            return false;
        }
    }

    private class NewsAsyncTask extends AsyncTask<Void, ArrayList<NewsSchema>, ArrayList<NewsSchema>> {

        @Override
        protected ArrayList<NewsSchema> doInBackground(Void... params) {
            try {
                return _newsManager.Load();
            } catch (IOException e) {
                return null;
            }
        }

        @Override
        protected void onPostExecute(ArrayList<NewsSchema> news) {
            //todo

        }
    }

}

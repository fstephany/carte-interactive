package com.micsc15.xpark.activities;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.micsc15.xpark.R;
import com.micsc15.xpark.managers.NewsManager;

import java.io.IOException;

/**
 * Created by fd on 31-07-15.
 */
public class NewsActivity extends BaseActivity {

    // -------------- Objects, Variables -------------- //

    private NewsManager _newsManager;

    // --------------------- Views -------------------- //

    EditText etResponse;
    TextView tvIsConnected;


    // ------------------ LifeCycle ------------------- //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        // get reference to the views
        etResponse = (EditText) findViewById(R.id.etResponse);
        tvIsConnected = (TextView) findViewById(R.id.tvIsConnected);

        // init members
        _newsManager = new NewsManager(getBaseContext());

        // check if you are connected or not
        if (isConnected()) {
            tvIsConnected.setBackgroundColor(0xFF00CC00);
            tvIsConnected.setText("You are connected");

            // call AsyncTask to perform network operation on separate thread
            new NewsAsyncTask().execute();
        } else {
            tvIsConnected.setText("You are NOT connected");
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

    private class NewsAsyncTask extends AsyncTask<Void, String, String> {

        @Override
        protected String doInBackground(Void... params) {
            try {
                return _newsManager.Load();
            } catch (IOException e) {
                return "Unable to retrieve web page. URL may be invalid.";
            }
        }

        @Override
        protected void onPostExecute(String result) {
            Toast.makeText(getBaseContext(), "Received!", Toast.LENGTH_LONG).show();
            etResponse.setText(result);
        }
    }

}

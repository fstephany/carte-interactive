package com.micsc15.xpark.activities;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.micsc15.xpark.R;
import com.micsc15.xpark.dataaccess.facebook.FacebookGraphResponse;
import com.micsc15.xpark.managers.NewsManager;
import com.micsc15.xpark.models.Facebook.NewsSchema;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by fd on 31-07-15.
 */
public class NewsActivity extends BaseActivity {

    static class ViewHolder {
        public TextView content;
        public TextView datum;
        public ImageView picture;
    }

    // -------------- Objects, Variables -------------- //

    private NewsManager _newsManager;

    // --------------------- Views -------------------- //

    ListView listNews;


    // ------------------ LifeCycle ------------------- //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_news);
        setTitle(R.string.news);

        // get reference to the views
        listNews = (ListView) findViewById(R.id.listNews);

        // init members
        _newsManager = new NewsManager(getBaseContext());

        // check if you are connected or not
        if (isConnected()) {
            // call AsyncTask to perform network operation on separate thread
            new NewsAsyncTask(this).execute();
        }
    }


    // ------------------ Listeners ------------------- //


    // ------------------- Methods -------------------- //

    private boolean isConnected() {
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        } else {
            return false;
        }
    }

    private class NewsAsyncTask extends AsyncTask<Void, ArrayList<NewsSchema>, ArrayList<NewsSchema>> {

        private final Activity _context;

        public NewsAsyncTask(Activity context) {
            _context = context;
        }

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
            NewsAdapter adapter = new NewsAdapter(_context, news);
            listNews.setAdapter(adapter);
        }
    }

    private class NewsAdapter extends BaseAdapter {

        private final Activity _context;
        private final ArrayList<NewsSchema> _news;
        private final SimpleDateFormat _simpleDate = new SimpleDateFormat("dd/MM/yyyy");

        public NewsAdapter(Activity context, ArrayList<NewsSchema> news) {
            _context = context;
            _news = news;
        }

        @Override
        public int getCount() {
            if (_news == null)
                return 0;
            return _news.size();
        }

        @Override
        public Object getItem(int position) {
            return _news.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View rowView = convertView;

            // reuse views
            if (rowView == null) {
                LayoutInflater inflater = _context.getLayoutInflater();
                rowView = inflater.inflate(R.layout.news_layout, null);

                // configure view holder
                ViewHolder viewHolder = new ViewHolder();
                viewHolder.content = (TextView) rowView.findViewById(R.id.content);
                viewHolder.datum = (TextView) rowView.findViewById(R.id.datum);
                viewHolder.picture = (ImageView) rowView.findViewById(R.id.picture);

                rowView.setTag(viewHolder);
            }

            // fill data
            ViewHolder holder = (ViewHolder) rowView.getTag();
            NewsSchema news = _news.get(position);
            holder.content.setText(news.Content);
            holder.datum.setText(_simpleDate.format(news.PublishDate));
            if(news.ImageUri != null) {
                holder.picture.setImageURI(news.ImageUri);
            }

            return rowView;
        }
    }

}

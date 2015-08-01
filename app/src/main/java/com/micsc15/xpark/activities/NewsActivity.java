package com.micsc15.xpark.activities;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
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
        setTitle(R.string.news);

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
            NewsAdapter adapter = new NewsAdapter(news);
            lvNews.setAdapter(adapter);
        }
    }

    private class NewsAdapter extends BaseAdapter {

        private ArrayList<NewsSchema> _news;

        public NewsAdapter(ArrayList<NewsSchema> news) {
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
            return null;
//            MyViewHolder mViewHolder = null;
//
//            // au premier appel ConvertView est null, on inflate notre layout
//            if (convertView == null) {
//                LayoutInflater mInflater = (LayoutInflater) context
//                        .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
//
//                convertView = mInflater.inflate(R.layout.row_list, parent, false);
//
//                // nous plaçons dans notre MyViewHolder les vues de notre layout
//                mViewHolder = new MyViewHolder();
//                mViewHolder.textViewName = (TextView) convertView
//                        .findViewById(R.id.textViewName);
//                mViewHolder.textViewAge = (TextView) convertView
//                        .findViewById(R.id.textViewAge);
//                mViewHolder.imageView = (ImageView) convertView
//                        .findViewById(R.id.imageView);
//
//                // nous attribuons comme tag notre MyViewHolder à convertView
//                convertView.setTag(mViewHolder);
//            } else {
//                // convertView n'est pas null, nous récupérons notre objet MyViewHolder
//                // et évitons ainsi de devoir retrouver les vues à chaque appel de getView
//                mViewHolder = (MyViewHolder) convertView.getTag();
//            }
//
//            // nous récupérons l'item de la liste demandé par getView
//            ListItem listItem = (ListItem) getItem(position);
//
//            // nous pouvons attribuer à nos vues les valeurs de l'élément de la liste
//            mViewHolder.textViewName.setText(listItem.getName());
//            mViewHolder.textViewAge.setText(String.valueOf(listItem.getAge())
//                    + " ans");
//            mViewHolder.imageView.setImageResource(listItem.getImageId());
//
//            // nous retournos la vue de l'item demandé
//            return convertView;
        }
    }

}

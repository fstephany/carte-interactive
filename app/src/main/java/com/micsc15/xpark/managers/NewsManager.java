package com.micsc15.xpark.managers;

import android.content.Context;
import android.net.Uri;
import android.text.Html;
import android.text.TextUtils;

import com.micsc15.xpark.R;
import com.micsc15.xpark.dataaccess.facebook.FacebookDataProvider;
import com.micsc15.xpark.dataaccess.facebook.FacebookGraphResponse;
import com.micsc15.xpark.dataaccess.facebook.GraphData;
import com.micsc15.xpark.models.Facebook.NewsSchema;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by fd on 31-07-15.
 */
public class NewsManager {


    // -------------- Objects, Variables -------------- //

    private FacebookDataProvider _facebookDataProvider;


    // -------------- .ctor -------------- //

    public NewsManager(Context baseContext) {
        _facebookDataProvider = new FacebookDataProvider(baseContext.getString(R.string.Facebook_UserID),
                baseContext.getString(R.string.Facebook_AppID), baseContext.getString(R.string.Facebook_AppSecret));
    }

    public ArrayList<NewsSchema> Load() throws IOException {
        //get data from Facebook graph API
        FacebookGraphResponse response = _facebookDataProvider.Load();

        //create formatted result
        ArrayList<NewsSchema> result = new ArrayList<>();
        for (GraphData graphData : response.data) {
            if (!TextUtils.isEmpty(graphData.message) && !TextUtils.isEmpty(graphData.link)) {
                NewsSchema newsSchema = new NewsSchema();
                newsSchema.Id = graphData.id;
                newsSchema.Author = graphData.from.name;
                newsSchema.PublishDate = graphData.created_time;
                if(!TextUtils.isEmpty(graphData.story)) {
                    newsSchema.Title = Html.escapeHtml(graphData.story);
                }
                if(!TextUtils.isEmpty(graphData.message)) {
                    newsSchema.Content = Html.escapeHtml(graphData.message);
                }
                newsSchema.ImageUrl = ConvertImageUrlFromParameter(graphData.picture);
                newsSchema.FeedUrl = graphData.link;
                result.add(newsSchema);
            }
        }

        return result;
    }

    private String ConvertImageUrlFromParameter(String imageUrl) {
        String parsedImageUrl = null;
        try {
            if (!TextUtils.isEmpty(imageUrl)) {
                if (imageUrl.contains("url=")) {

                    Uri imageUri = Uri.parse(imageUrl);
                    String url = imageUri.getQueryParameter("url");
                    parsedImageUrl = Uri.decode(url);
                } else {
                    parsedImageUrl = Html.escapeHtml(imageUrl);
                }
            }
        } catch (Exception e) {
        }

        return parsedImageUrl;
    }


}

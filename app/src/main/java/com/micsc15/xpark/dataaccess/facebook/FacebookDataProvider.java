package com.micsc15.xpark.dataaccess.facebook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by fd on 31-07-15.
 */
public class FacebookDataProvider {


    // -------------- Objects, Variables -------------- //

    private final String _BASE_URL = "https://graph.facebook.com/v2.4";
    private String _userID;
    private String _appID;
    private String _appSecret;


    // -------------- Properties -------------- //

    private String getPageUrl() {
        return String.format("%1$s/%2$s/posts?&access_token=%3$s|%4$s", _BASE_URL, _userID, _appID, _appSecret);
    }


    // -------------- .ctor -------------- //

    public FacebookDataProvider(String userID, String appID, String appSecret) {
        this._userID = userID;
        this._appSecret = appSecret;
        this._appID = appID;
    }


    // -------------- Public Methods -------------- //

    public String Load() throws IOException {
        return downloadUrl(getPageUrl());
    }


    // -------------- Private Methods -------------- //

    // Given a URL, establishes an HttpUrlConnection and retrieves
    // the web page content as a InputStream, which it returns as
    // a string.
    private String downloadUrl(String myurl) throws IOException {
        InputStream inputStream = null;
        try {
            URL url = new URL(myurl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000 /* milliseconds */);
            conn.setConnectTimeout(15000 /* milliseconds */);
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            // Starts the query
            conn.connect();
            conn.getResponseCode();

            inputStream = conn.getInputStream();

            // Convert the InputStream into a string
            String contentAsString = readIt(inputStream);
            return contentAsString;
        } finally {
            // Makes sure that the InputStream is closed after the app is
            // finished using it.
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    // Reads an InputStream and converts it to a String.
    private String readIt(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        String result = "";
        while ((line = bufferedReader.readLine()) != null)
            result += line;

        inputStream.close();
        return result;
    }

}

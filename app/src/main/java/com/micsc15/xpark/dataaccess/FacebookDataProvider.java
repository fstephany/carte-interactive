package com.micsc15.xpark.dataaccess;

/**
 * Created by fd on 31-07-15.
 */
public class FacebookDataProvider {

    private final String _BASE_URL = "https://graph.facebook.com/v2.2";
    private String _userID;
    private String _appID;
    private String _appSecret;

    public FacebookDataProvider(String userID, String appID, String appSecret)
    {
        this._userID = userID;
        this._appSecret = appSecret;
        this._appID = appID;
    }

    private String getPageUrl() {
        return String.format("%1$s/%2$s/posts?&access_token=%3$s|%4$s", _BASE_URL, _userID, _appID, _appSecret);
    }




}

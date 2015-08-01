package com.micsc15.xpark.managers;

import android.content.Context;

import com.micsc15.xpark.R;
import com.micsc15.xpark.dataaccess.facebook.FacebookDataProvider;
import com.micsc15.xpark.dataaccess.facebook.FacebookGraphResponse;

import java.io.IOException;

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

    public FacebookGraphResponse Load() throws IOException {
        return _facebookDataProvider.Load();
    }


}

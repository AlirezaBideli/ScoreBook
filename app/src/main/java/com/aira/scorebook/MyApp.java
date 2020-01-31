package com.aira.scorebook;

import android.app.Application;
import android.content.Context;

public class MyApp extends Application {

    private static MyApp mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext=this;
    }
    public  static Context getContext()
    {
        return mContext;
    }
}

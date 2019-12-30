package com.aira.scorebook;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.aira.scorebook.database.DbOpenHelper;
import com.aira.scorebook.model.DaoMaster;
import com.aira.scorebook.model.DaoSession;

public class MyApplication extends Application {

    private  DaoSession mDaoSession;
    private static MyApplication instance;


    @Override
    public void onCreate() {
        super.onCreate();

        instance=this;
        //initialize greenDao ORM
        DbOpenHelper helper = new DbOpenHelper(this,"NoteBook-db",null);
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        mDaoSession = daoMaster.newSession();
    }

    public static MyApplication getInstance()
    {
        return instance;
    }
    public  DaoSession getDaoSession()
    {
        return mDaoSession;
    }







}

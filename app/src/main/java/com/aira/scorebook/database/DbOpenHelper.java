package com.aira.scorebook.database;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.aira.scorebook.model.DaoMaster;

public class DbOpenHelper extends DaoMaster.DevOpenHelper {


    public DbOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }
}

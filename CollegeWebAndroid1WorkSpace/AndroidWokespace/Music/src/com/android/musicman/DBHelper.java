package com.android.musicman;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, "data.db", null, 2);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "create table userinformation ("
                + "telphone text primary key, "
                + "pwd text, "
                + "nickname text, "
                + "sex text)";

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

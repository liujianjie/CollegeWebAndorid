package com.example.sixteentask;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2020/5/29.
 */

public class MyHelper  extends SQLiteOpenHelper{
    // 表定义
    private final static String CREATE_TABLE = "create table user(_id integer primary key autoincrement,name,pwd)";
    public MyHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
        //db执行sql语句
        db.execSQL("insert into user(name, pwd) values('jvtc','2020')");
        db.execSQL("insert into user(name, pwd) values('ljj','123456')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}

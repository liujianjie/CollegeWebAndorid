package com.example.fourteenone;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MyHelper extends SQLiteOpenHelper{

    public MyHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
        Log.i("数据库状态","MyHelper对象创建完成");
        Log.i("数据库状态","数据库被声明：数据库名-"+name+", 版本号-"+version);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.i("数据库状态","创建数据库");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        Log.i("数据库状态","升级数据库");
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        Log.i("数据库状态","链接数据库");
    }
}

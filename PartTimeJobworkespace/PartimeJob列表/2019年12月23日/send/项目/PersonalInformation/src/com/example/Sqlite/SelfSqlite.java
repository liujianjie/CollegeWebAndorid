package com.example.Sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

// sqlite数据库操作
public class SelfSqlite extends SQLiteOpenHelper{

	public SelfSqlite(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase sqlite) {
		// TODO Auto-generated method stub
		// 个人信息 主键，信息名称，信息内容
		String personsql = "create table myinfo(perid integer primary key autoincrement,title text,context text);";
		sqlite.execSQL(personsql);
		// 爱好 主键，爱好内容
		String hobbysql = "create table hobby(hobbyid integer primary key autoincrement,hobbyname text);";
		sqlite.execSQL(hobbysql);
		// 我的爱好
		String myhobbysql = "create table myhobby(myhobbyid integer);";
		sqlite.execSQL(myhobbysql);
		// 设置
		String settingsql = "create table setting(settingid integer primary key autoincrement,mainnum integer,photonum integer, hobbynum integer, titlesize integer);";
		sqlite.execSQL(settingsql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase sqlite, int arg1, int arg2) {
		// TODO Auto-generated method stub
		sqlite.execSQL("drop table if exists myinfo");
		sqlite.execSQL("drop table if exists hobby");
		sqlite.execSQL("drop table if exists myhobby");
		sqlite.execSQL("drop table if exists setting");
		onCreate(sqlite);
	}

}

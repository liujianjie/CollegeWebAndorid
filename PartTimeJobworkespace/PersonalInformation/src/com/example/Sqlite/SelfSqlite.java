package com.example.Sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

// sqlite���ݿ����
public class SelfSqlite extends SQLiteOpenHelper{

	public SelfSqlite(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase sqlite) {
		// TODO Auto-generated method stub
		// ������Ϣ ��������Ϣ���ƣ���Ϣ����
		String personsql = "create table myinfo(perid integer primary key autoincrement,title text,context text);";
		sqlite.execSQL(personsql);
		// ���� ��������������
		String hobbysql = "create table hobby(hobbyid integer primary key autoincrement,hobbyname text);";
		sqlite.execSQL(hobbysql);
		// �ҵİ���
		String myhobbysql = "create table myhobby(myhobbyid integer);";
		sqlite.execSQL(myhobbysql);
		// ����
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

package com.example.application;

import com.example.Sqlite.SelfSqlite;
import com.example.Sqlite.Version;
import com.example.bean.SettingBean;
import com.example.dao.SettingDao;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

public class MyApplication extends Application{
	
	// ȫ������
	static SettingBean settingbean;

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		// һ����Ҫ���������Ϣ ����ѯ��application��
		insertToSettingAndSel();
	}
	// ��ȡӦ��Ĭ����Ϣ
	private void insertToSettingAndSel(){
		SelfSqlite seqlite = new SelfSqlite(this, "personal.db", null, Version.dataversion);
		SQLiteDatabase db = seqlite.getReadableDatabase();// �Զ���ʽ��
		// ����
		SettingDao sedao = new SettingDao(); 
		sedao.inserInfo(db);
		// ��ȡ
		SettingBean settingbean = sedao.readSettingData(db);
		// ����ȫ��
		MyApplication.setSettingbean(settingbean);
	}
	public static SettingBean getSettingbean() {
		return settingbean;
	}
	public static void setSettingbean(SettingBean settingbean) {
		MyApplication.settingbean = settingbean;
	}
	
	
}

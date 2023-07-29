package com.example.application;

import com.example.Sqlite.SelfSqlite;
import com.example.Sqlite.Version;
import com.example.bean.SettingBean;
import com.example.dao.SettingDao;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

public class MyApplication extends Application{
	
	// 全局设置
	static SettingBean settingbean;

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		// 一进来要添加设置信息 并查询到application中
		insertToSettingAndSel();
	}
	// 获取应用默认信息
	private void insertToSettingAndSel(){
		SelfSqlite seqlite = new SelfSqlite(this, "personal.db", null, Version.dataversion);
		SQLiteDatabase db = seqlite.getReadableDatabase();// 以读方式打开
		// 插入
		SettingDao sedao = new SettingDao(); 
		sedao.inserInfo(db);
		// 读取
		SettingBean settingbean = sedao.readSettingData(db);
		// 设置全局
		MyApplication.setSettingbean(settingbean);
	}
	public static SettingBean getSettingbean() {
		return settingbean;
	}
	public static void setSettingbean(SettingBean settingbean) {
		MyApplication.settingbean = settingbean;
	}
	
	
}

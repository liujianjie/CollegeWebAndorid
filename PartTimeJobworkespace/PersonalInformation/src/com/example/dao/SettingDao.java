package com.example.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.bean.PersonalBean;
import com.example.bean.SettingBean;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class SettingDao {
    //
    public List<Integer> li1 = new ArrayList<Integer>();
    public List<Integer> li2 = new ArrayList<Integer>();
    public List<Integer> li3 = new ArrayList<Integer>();
    public List<Integer> li4 = new ArrayList<Integer>();
    
    SettingBean setting;
    
    // 得到bean
    public SettingDao(){
    	setting = new SettingBean();
    }
    // 获取默认list
    public void getDefaultSettingList(){
    	li1.add(1);
    	li1.add(2);
    	li1.add(3);
    	
    	li2.add(1);
    	li2.add(2);
    	li2.add(3);
    	
    	li3.add(1);
    	li3.add(2);
    	li3.add(3);
    	
    	li4.add(18);
    	li4.add(19);
    	li4.add(20);
    	li4.add(21);
    	li4.add(22);
    	li4.add(23);
    	li4.add(24);
    }
    // 设置默认的设置
    public void setDefaultSetting(){
    	setting.setMainnum(3);
    	setting.setPhotonum(2);
    	setting.setHobbynum(3);
    	setting.setTitlesize(21);
    }
    
    // 
    public void inserInfo(SQLiteDatabase db) {
		int count = isNullData(db);
		if(count == 0){
			// 添加数据到数据库
			// 获取默认数据
			setDefaultSetting();
			ContentValues content = new ContentValues();
			content.put("mainnum", setting.getMainnum());
			content.put("photonum", setting.getPhotonum());
			content.put("hobbynum", setting.getHobbynum());
			content.put("titlesize", setting.getTitlesize());
			db.insert("setting", null, content);
		}
	}
    public int isNullData(SQLiteDatabase db){
		int count = 0;
		String[] columns = { "mainnum", "photonum","hobbynum","titlesize" };
		Cursor cursor = db.query("setting", columns, "", null, "", null, "");
		count = cursor.getCount();
		cursor.close();
		return count;
	}
    // 读取设置
 	public SettingBean readSettingData(SQLiteDatabase db) {
 		SettingBean se = new SettingBean();
 		String[] columns = { "mainnum", "photonum","hobbynum","titlesize" };
 		Cursor cursor = db.query("setting", columns, "", null, "", null, "");
 		if(cursor.getCount() != 0){
 			while (!cursor.isLast()) {
 				cursor.moveToNext();
 				se.setMainnum(cursor.getInt(cursor.getColumnIndex("mainnum")));
 				se.setPhotonum(cursor.getInt(cursor.getColumnIndex("photonum")));
 				se.setHobbynum(cursor.getInt(cursor.getColumnIndex("hobbynum")));
 				se.setTitlesize(cursor.getInt(cursor.getColumnIndex("titlesize")));
 			}
 		}
 		cursor.close();
 		return se;
 	}
 	// 更改设置
 	public void updateSetting(SQLiteDatabase db, SettingBean set){
 		set.setSettingid(0);// 第一个
		ContentValues content = new ContentValues();
		content.put("mainnum", set.getMainnum());
		content.put("photonum", set.getPhotonum());
		content.put("hobbynum", set.getHobbynum());
		content.put("titlesize", set.getTitlesize());
		
		String whereClause = "settingid = ?";
		String []whereArgs = {set.getSettingid()+""};
		db.update("setting", content, whereClause, whereArgs);
	}
}

package com.example.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.bean.PersonalBean;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

// 个人信息的默认数据
public class PersonalDao {
	List<PersonalBean> perlist;
	
	public PersonalDao(){
		perlist = new ArrayList<PersonalBean>();
	}
	// 获取默认list
	public List<PersonalBean> getPersonalDefaultList(){
		PersonalBean per = null;
		per = new PersonalBean(1, "姓名", "刘建杰");
		perlist.add(per);
		per = new PersonalBean(2, "学校", "北京都市学院");
		perlist.add(per);
		per = new PersonalBean(3, "班级", "安卓1802");
		perlist.add(per);
		per = new PersonalBean(4, "学号", "183052745");
		perlist.add(per);
		per = new PersonalBean(5, "性别", "男");
		perlist.add(per);
		per = new PersonalBean(6, "名族", "汉");
		perlist.add(per);
		per = new PersonalBean(7, "出生年月", "1998年12月10日");
		perlist.add(per);
		per = new PersonalBean(8, "家庭住址", "广东省深圳市南山区蛇口");
		perlist.add(per);
		return perlist;
	}
	public void inserInfo(SQLiteDatabase db) {
		int count = isNullData(db);
		if(count == 0){
			// 添加数据到数据库
			// 获取默认数据
			getPersonalDefaultList();
			for(int i = 0; i < perlist.size(); i++){
				PersonalBean per = perlist.get(i);
				ContentValues content = new ContentValues();
				content.put("title", per.getTitle());
				content.put("context", per.getContext());
				db.insert("myinfo", null, content);
			}
		}
	}
	// 是否为空
	public int isNullData(SQLiteDatabase db){
		int count = 0;
		String[] columns = { "title", "context" };
		Cursor cursor = db.query("myinfo", columns, "", null, "", null, "");
		count = cursor.getCount();
		cursor.close();
		return count;
	}
	// 读取数据map中
	public List<Map<String, Object>> readData(SQLiteDatabase db, List<Map<String, Object>> perlist) {
		String[] columns = { "perid","title", "context" };// 读取的列
		Cursor cursor = db.query("myinfo", columns, "", null, "", null, "");
		if(cursor.getCount() != 0){
			while (!cursor.isLast()) {
				cursor.moveToNext();
				Map<String, Object> ma = new HashMap<String, Object>();
				ma.put("perid", cursor.getInt(cursor.getColumnIndex("perid")));
				ma.put("title", cursor.getString(cursor.getColumnIndex("title")));
				ma.put("context", cursor.getString(cursor.getColumnIndex("context")));
				perlist.add(ma);
			}
		}
		cursor.close();
		return perlist;
	}
	// 读取数据到list
	public List<PersonalBean> readDataToPersonalBean(SQLiteDatabase db, List<PersonalBean> perlist) {
		String[] columns = { "perid","title", "context" };// 读取的列
		Cursor cursor = db.query("myinfo", columns, "", null, "", null, "");
		if(cursor.getCount() != 0){
			while (!cursor.isLast()) {
				cursor.moveToNext();
				PersonalBean per = new PersonalBean();
				per.setPerid(cursor.getInt(cursor.getColumnIndex("perid")));
				per.setTitle(cursor.getString(cursor.getColumnIndex("title")));
				per.setContext(cursor.getString(cursor.getColumnIndex("context")));
				perlist.add(per);
			}
		}
		cursor.close();
		return perlist;
	}
	// 删除
	public void deletePersonalByid(SQLiteDatabase db, int perid){
		String whereClause = "perid = ?";
		String[] whereArgs = {perid+""};
		Log.i("check", "开始删除个人信息");
		db.delete("myinfo", whereClause, whereArgs);
		Log.i("check", "结束删除个人信息");
	}
	// 修改个人信息
	public void updatePersonalByid(SQLiteDatabase db, PersonalBean per){
		ContentValues content = new ContentValues();
		content.put("title", per.getTitle());
		content.put("context", per.getContext());
		
		String whereClause = "perid = ?";
		String []whereArgs = {per.getPerid()+""};
		db.update("myinfo", content, whereClause, whereArgs);
	}
	// 添加一项个人信息
	public int addonePersonal(SQLiteDatabase db, String title, String context){
		ContentValues content = new ContentValues();
		content.put("title", title);
		content.put("context", context);
		db.insert("myinfo", null, content);
		Cursor cursor = db.rawQuery("select last_insert_rowid() from myinfo",null);          
		int id = 0;    
		if(cursor.moveToFirst())  
			id = cursor.getInt(0);  
		Log.i("check", id+"");
		return id;
	}
}

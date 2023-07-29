package com.example.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.Sqlite.SelfSqlite;
import com.example.bean.HobbyBean;
import com.example.bean.MyhobbyBean;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class HobbyDao {
	List<HobbyBean> hoblist;
	
	public HobbyDao() {
		hoblist = new ArrayList<HobbyBean>();
	}
	
	// 当为空，获取默认hoblist
	public List<HobbyBean> getDefaultHobbyList(){
		HobbyBean hob = null;
		hob = new HobbyBean(1, "蓝球");
		hoblist.add(hob);
		hob = new HobbyBean(2, "排球");
		hoblist.add(hob);
		hob = new HobbyBean(3, "羽毛球");
		hoblist.add(hob);
		hob = new HobbyBean(4, "跳绳");
		hoblist.add(hob);
		hob = new HobbyBean(5, "游戏");
		hoblist.add(hob);
		hob = new HobbyBean(5, "看电影");
		hoblist.add(hob);
		hob = new HobbyBean(6, "读小说");
		hoblist.add(hob);
		hob = new HobbyBean(7, "足球");
		hoblist.add(hob);
		hob = new HobbyBean(8, "睡觉");
		hoblist.add(hob);
		hob = new HobbyBean(9, "逛街");
		hoblist.add(hob);
		hob = new HobbyBean(10, "学习");
		hoblist.add(hob);
		return hoblist;
	}
	// 添加数据
	public void inserInfo(SQLiteDatabase db) {
		int count = isNullData(db);
		if(count == 0){
			// 添加数据到数据库
			getDefaultHobbyList();// 获取默认数据
			for(int i = 0; i < hoblist.size(); i++){
				HobbyBean per = hoblist.get(i);
				ContentValues content = new ContentValues();
				content.put("hobbyname", per.getHobbyname());
				db.insert("hobby", null, content);
			}
		}
	}
	// 是否为空
	public int isNullData(SQLiteDatabase db){
		int count = 0;
		String[] columns = { "hobbyname" };
		Cursor cursor = db.query("hobby", columns, "", null, "", null, "");
		count = cursor.getCount();
		cursor.close();
		return count;
	}
	// 读取所有爱好数据
	public List<Map<String, Object>> readData(SQLiteDatabase db,List<Map<String, Object>> list) {
		String[] columns = { "hobbyid", "hobbyname" };// 读取的列
		Cursor cursor = db.query("hobby", columns, "", null, "", null, "");
		if(cursor.getCount() != 0){
			while (!cursor.isLast()) {
				cursor.moveToNext();
				Map<String, Object> ma = new HashMap<String, Object>();
				ma.put("hobbyid", cursor.getInt(cursor.getColumnIndex("hobbyid")));
				ma.put("hobbyname", cursor.getString(cursor.getColumnIndex("hobbyname")));
				list.add(ma);
			}
		}
		cursor.close();
		return list;
	}
	// 读取所有爱好数据
	public List<HobbyBean> readDataToHobbyBean(SQLiteDatabase db,List<HobbyBean> hoblist) {
		String[] columns = { "hobbyid", "hobbyname" };// 读取的列
		Cursor cursor = db.query("hobby", columns, "", null, "", null, "");
		if(cursor.getCount() != 0){
			while (!cursor.isLast()) {
				cursor.moveToNext();
				HobbyBean ho = new HobbyBean();
				ho.setHobbyid(cursor.getInt(cursor.getColumnIndex("hobbyid")));
				ho.setHobbyname(cursor.getString(cursor.getColumnIndex("hobbyname")));
				hoblist.add(ho);
			}
		}
		cursor.close();
		return hoblist;
	}
	// 删除所有爱好数据的其中一个，根据id
	public void deleteHobbyByid(SQLiteDatabase db,int hobbyid){
		String whereClause = "hobbyid = ?";
		String[] whereArgs = {hobbyid+""};
		Log.i("check", "开始删除爱好");
		db.delete("hobby", whereClause, whereArgs);
		Log.i("check", "结束删除爱好");
	}
	// 添加一个爱好 返回主键id
	public int addoneHobbyName(SQLiteDatabase db, String hobbyname){
		ContentValues content = new ContentValues();
		content.put("hobbyname", hobbyname);
		db.insert("hobby", null, content);
		Cursor cursor = db.rawQuery("select last_insert_rowid() from hobby",null);          
		int id = 0;    
		if(cursor.moveToFirst())  
			id = cursor.getInt(0);  
		Log.i("check", id+"");
		return id;
	}
	
	// 我的爱好
	public List<String> readDataWithMyhobby(SQLiteDatabase db,List<String> myholist){
		String[] columns = { "myhobbyid"};// 读取的列
		Cursor cursor = db.query("myhobby", columns, "", null, "", null, "");
		if(cursor.getCount() != 0){
			while (!cursor.isLast()) {
				cursor.moveToNext();
				String hobbyid = cursor.getString(cursor.getColumnIndex("myhobbyid"));
				myholist.add(hobbyid);
			}
		}
		cursor.close();
		return myholist;
	}
	// 删除所有我的爱好
	public void deleteAllMyhobby(SQLiteDatabase db){
		String deletesql = "delete from myhobby";
		db.execSQL(deletesql);
	}
	// 添加我的爱好
	public void addMyhobby(SQLiteDatabase db, List<String> alterselfhobbylist){
		Log.i("check", "开始添加我的爱好");
		for (int i = 0; i < alterselfhobbylist.size(); i++) {
			ContentValues content = new ContentValues();
			content.put("myhobbyid", Integer.valueOf(alterselfhobbylist.get(i)));
			db.insert("myhobby", null, content);
		}
		Log.i("check", "结束添加我的爱好");
	}
	// 删除我爱好中的数据其中一个，根据id
	public void deleteMyHobbyByid(SQLiteDatabase db,int hobbyid){
		String whereClause = "myhobbyid = ?";
		String[] whereArgs = {hobbyid+""};
		Log.i("check", "开始删除爱好");
		db.delete("myhobby", whereClause, whereArgs);
		Log.i("check", "结束删除爱好");
	}
}

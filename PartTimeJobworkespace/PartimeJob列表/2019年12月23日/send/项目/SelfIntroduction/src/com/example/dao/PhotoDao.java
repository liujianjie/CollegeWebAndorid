package com.example.dao;

import java.util.List;

import com.example.bean.PhotoBean;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class PhotoDao {
	
	
	public PhotoDao() {
		// TODO Auto-generated constructor stub
	}
	
	// ��ȡͼƬ ��bitmap
	public List<PhotoBean> readDataWithPhoto(SQLiteDatabase db,List<PhotoBean> list){
		String[] columns = { "photoid","photouri"};// ��ȡ����
		Cursor cursor = db.query("photo", columns, "", null, "", null, "");
		if(cursor.getCount() != 0){
			while (!cursor.isLast()) {
				cursor.moveToNext();
				PhotoBean ph = new PhotoBean();
				ph.setPhotoid(cursor.getInt(cursor.getColumnIndex("photoid")));
				ph.setPhotouri(cursor.getString(cursor.getColumnIndex("photouri")));
				list.add(ph);
			}
		}
		cursor.close();
		return list;
	}
	// ���ͼƬ
	public int addPhoto(SQLiteDatabase db, String uri){
		ContentValues content = new ContentValues();
		content.put("photouri", uri);
		db.insert("photo", null, content);
		Cursor cursor = db.rawQuery("select last_insert_rowid() from photo",null);          
		int id = 0;    
		if(cursor.moveToFirst())  
			id = cursor.getInt(0);  
		Log.i("check", id+"");
		return id;
	}
	// ɾ��һ��ͼƬ����id
	public void deletePhotoByid(SQLiteDatabase db,int hobbyid){
		String whereClause = "photoid = ?";
		String[] whereArgs = {hobbyid+""};
		db.delete("photo", whereClause, whereArgs);
	}
}

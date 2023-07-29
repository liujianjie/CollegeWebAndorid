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
	
	// ��Ϊ�գ���ȡĬ��hoblist
	public List<HobbyBean> getDefaultHobbyList(){
		HobbyBean hob = null;
		hob = new HobbyBean(1, "����");
		hoblist.add(hob);
		hob = new HobbyBean(2, "����");
		hoblist.add(hob);
		hob = new HobbyBean(3, "��ë��");
		hoblist.add(hob);
		hob = new HobbyBean(4, "����");
		hoblist.add(hob);
		hob = new HobbyBean(5, "��Ϸ");
		hoblist.add(hob);
		hob = new HobbyBean(5, "����Ӱ");
		hoblist.add(hob);
		hob = new HobbyBean(6, "��С˵");
		hoblist.add(hob);
		hob = new HobbyBean(7, "����");
		hoblist.add(hob);
		hob = new HobbyBean(8, "˯��");
		hoblist.add(hob);
		hob = new HobbyBean(9, "���");
		hoblist.add(hob);
		hob = new HobbyBean(10, "ѧϰ");
		hoblist.add(hob);
		return hoblist;
	}
	// �������
	public void inserInfo(SQLiteDatabase db) {
		int count = isNullData(db);
		if(count == 0){
			// ������ݵ����ݿ�
			getDefaultHobbyList();// ��ȡĬ������
			for(int i = 0; i < hoblist.size(); i++){
				HobbyBean per = hoblist.get(i);
				ContentValues content = new ContentValues();
				content.put("hobbyname", per.getHobbyname());
				db.insert("hobby", null, content);
			}
		}
	}
	// �Ƿ�Ϊ��
	public int isNullData(SQLiteDatabase db){
		int count = 0;
		String[] columns = { "hobbyname" };
		Cursor cursor = db.query("hobby", columns, "", null, "", null, "");
		count = cursor.getCount();
		cursor.close();
		return count;
	}
	// ��ȡ���а�������
	public List<Map<String, Object>> readData(SQLiteDatabase db,List<Map<String, Object>> list) {
		String[] columns = { "hobbyid", "hobbyname" };// ��ȡ����
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
	// ��ȡ���а�������
	public List<HobbyBean> readDataToHobbyBean(SQLiteDatabase db,List<HobbyBean> hoblist) {
		String[] columns = { "hobbyid", "hobbyname" };// ��ȡ����
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
	// ɾ�����а������ݵ�����һ��������id
	public void deleteHobbyByid(SQLiteDatabase db,int hobbyid){
		String whereClause = "hobbyid = ?";
		String[] whereArgs = {hobbyid+""};
		Log.i("check", "��ʼɾ������");
		db.delete("hobby", whereClause, whereArgs);
		Log.i("check", "����ɾ������");
	}
	// ���һ������ ��������id
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
	
	// �ҵİ���
	public List<String> readDataWithMyhobby(SQLiteDatabase db,List<String> myholist){
		String[] columns = { "myhobbyid"};// ��ȡ����
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
	// ɾ�������ҵİ���
	public void deleteAllMyhobby(SQLiteDatabase db){
		String deletesql = "delete from myhobby";
		db.execSQL(deletesql);
	}
	// ����ҵİ���
	public void addMyhobby(SQLiteDatabase db, List<String> alterselfhobbylist){
		Log.i("check", "��ʼ����ҵİ���");
		for (int i = 0; i < alterselfhobbylist.size(); i++) {
			ContentValues content = new ContentValues();
			content.put("myhobbyid", Integer.valueOf(alterselfhobbylist.get(i)));
			db.insert("myhobby", null, content);
		}
		Log.i("check", "��������ҵİ���");
	}
	// ɾ���Ұ����е���������һ��������id
	public void deleteMyHobbyByid(SQLiteDatabase db,int hobbyid){
		String whereClause = "myhobbyid = ?";
		String[] whereArgs = {hobbyid+""};
		Log.i("check", "��ʼɾ������");
		db.delete("myhobby", whereClause, whereArgs);
		Log.i("check", "����ɾ������");
	}
}

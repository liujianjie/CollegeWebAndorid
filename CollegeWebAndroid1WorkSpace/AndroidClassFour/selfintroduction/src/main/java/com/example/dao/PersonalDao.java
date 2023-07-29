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

// ������Ϣ��Ĭ������
public class PersonalDao {
	List<PersonalBean> perlist;
	
	public PersonalDao(){
		perlist = new ArrayList<PersonalBean>();
	}
	// ��ȡĬ��list
	public List<PersonalBean> getPersonalDefaultList(){
		PersonalBean per = null;
		per = new PersonalBean(1, "����", "������");
		perlist.add(per);
		per = new PersonalBean(2, "ѧУ", "��������ѧԺ");
		perlist.add(per);
		per = new PersonalBean(3, "�༶", "��׿1802");
		perlist.add(per);
		per = new PersonalBean(4, "ѧ��", "183052745");
		perlist.add(per);
		per = new PersonalBean(5, "�Ա�", "��");
		perlist.add(per);
		per = new PersonalBean(6, "����", "��");
		perlist.add(per);
		per = new PersonalBean(7, "��������", "1998��12��10��");
		perlist.add(per);
		per = new PersonalBean(8, "��ͥסַ", "�㶫ʡ��������ɽ���߿�");
		perlist.add(per);
		return perlist;
	}
	public void inserInfo(SQLiteDatabase db) {
		int count = isNullData(db);
		if(count == 0){
			// ������ݵ����ݿ�
			// ��ȡĬ������
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
	// �Ƿ�Ϊ��
	public int isNullData(SQLiteDatabase db){
		int count = 0;
		String[] columns = { "title", "context" };
		Cursor cursor = db.query("myinfo", columns, "", null, "", null, "");
		count = cursor.getCount();
		cursor.close();
		return count;
	}
	// ��ȡ����map��
	public List<Map<String, Object>> readData(SQLiteDatabase db, List<Map<String, Object>> perlist) {
		String[] columns = { "perid","title", "context" };// ��ȡ����
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
	// ��ȡ���ݵ�list
	public List<PersonalBean> readDataToPersonalBean(SQLiteDatabase db, List<PersonalBean> perlist) {
		String[] columns = { "perid","title", "context" };// ��ȡ����
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
	// ɾ��
	public void deletePersonalByid(SQLiteDatabase db, int perid){
		String whereClause = "perid = ?";
		String[] whereArgs = {perid+""};
		Log.i("check", "��ʼɾ��������Ϣ");
		db.delete("myinfo", whereClause, whereArgs);
		Log.i("check", "����ɾ��������Ϣ");
	}
	// �޸ĸ�����Ϣ
	public void updatePersonalByid(SQLiteDatabase db, PersonalBean per){
		ContentValues content = new ContentValues();
		content.put("title", per.getTitle());
		content.put("context", per.getContext());
		
		String whereClause = "perid = ?";
		String []whereArgs = {per.getPerid()+""};
		db.update("myinfo", content, whereClause, whereArgs);
	}
	// ���һ�������Ϣ
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

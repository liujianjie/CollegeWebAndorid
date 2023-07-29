package com.example.personalinformation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.example.Sqlite.SelfSqlite;
import com.example.Sqlite.Version;
import com.example.adpter.HobbyAlterBaseAdapter;
import com.example.adpter.HobbyBaseAdapter;
import com.example.application.MyApplication;
import com.example.bean.HobbyBean;
import com.example.bean.MyhobbyBean;
import com.example.dao.HobbyDao;
import com.example.personalinformation.R;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

// ����activity
public class HobbyActivity extends Activity{
	private TextView title;
	HobbyBaseAdapter hobbybase;
	
	GridView hobbygridview;

	private List<HobbyBean> allhobbylist;
	
	public List<String> myhobbylist;
	
	HobbyDao hobydao = new HobbyDao();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);//�ޱ���
		setContentView(R.layout.activity_hobby);
		findViews();
		initData();
		getInfoFromSqlite();
		inAdater();
	}
	private void findViews() {
		hobbygridview = (GridView) findViewById(R.id.hobby_gridview);
		title = (TextView) findViewById(R.id.hobby_title);
		if(MyApplication.getSettingbean() != null){
			hobbygridview.setNumColumns(MyApplication.getSettingbean().getHobbynum());
			title.setTextSize(MyApplication.getSettingbean().getTitlesize());
		}
	}
	private void initData(){
		allhobbylist = new ArrayList<HobbyBean>();
		myhobbylist = new ArrayList<String>();
	}
	private void inAdater() {
		if (allhobbylist != null) {
			hobbybase = new HobbyBaseAdapter(this);
			hobbybase.SetData(allhobbylist);
			hobbygridview.setAdapter(hobbybase);
		}
	}
	// ��ȡ���ݿ���Ϣ
	private void getInfoFromSqlite() {
		// �������ݿ�ʵ��
		SelfSqlite seqlite = new SelfSqlite(this, "personal.db", null, Version.dataversion);
		SQLiteDatabase db = seqlite.getReadableDatabase();// �Զ���ʽ��
		// ������ݵ����ݿ�
		hobydao.inserInfo(db);
		
		// ��ȡ���еİ��ã����ҵİ���
		allhobbylist = hobydao.readDataToHobbyBean(db, allhobbylist);
		myhobbylist = hobydao.readDataWithMyhobby(db, myhobbylist);
	}
	
	// ҳ�����
	public void HobbyToAlter(View view){
		Intent in = new Intent(this, HobbyAlterActivity.class);
		startActivity(in);
		finish();
	}
	//
	public void Back(View view){
		finish();
	}
}

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

// 爱好activity
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
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);//无标题
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
	// 获取数据库信息
	private void getInfoFromSqlite() {
		// 创建数据库实例
		SelfSqlite seqlite = new SelfSqlite(this, "personal.db", null, Version.dataversion);
		SQLiteDatabase db = seqlite.getReadableDatabase();// 以读方式打开
		// 添加数据到数据库
		hobydao.inserInfo(db);
		
		// 读取所有的爱好，和我的爱好
		allhobbylist = hobydao.readDataToHobbyBean(db, allhobbylist);
		myhobbylist = hobydao.readDataWithMyhobby(db, myhobbylist);
	}
	
	// 页面操作
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

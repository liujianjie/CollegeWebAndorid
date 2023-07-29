package com.example.selfintroduction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.Sqlite.SelfSqlite;
import com.example.Sqlite.Version;
import com.example.application.GetColorAndStyleClass;
import com.example.application.MyApplication;
import com.example.bean.PersonalBean;
import com.example.dao.PersonalDao;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class PersonalProfileActivity extends Activity {
	private TextView title;
	ListView perlistview;

	private SimpleAdapter personalsimp;

	private List<Map<String, Object>> allperlist;
	
	SelfSqlite seqlite;
	SQLiteDatabase db;
	// Ĭ������
	private PersonalDao perdao = new PersonalDao();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);// �ޱ���
		setContentView(R.layout.activity_personal);
		findViews();
		initData();
		getInfoFromSqlite();
		inAdater();
	}

	private void findViews() {
		perlistview = (ListView) findViewById(R.id.personal_listview);
		title = (TextView) findViewById(R.id.personal_title);
		if(MyApplication.getSettingbean() != null){
			title.setTextSize(MyApplication.getSettingbean().getTitlesize());
			// ��ɫ
			title.setTextColor(GetColorAndStyleClass.getColorFromIndex(MyApplication.getSettingbean().getTitlecolor()));
			// ��ʽ����
			int style = MyApplication.getSettingbean().getTitlestyle();
			title.setTypeface(Typeface.MONOSPACE, GetColorAndStyleClass.getStyleFromIndex(style));
		}
	}

	private void initData() {
		allperlist = new ArrayList<Map<String, Object>>();
	}

	// ��ȡ���ݿ���Ϣ
	private void getInfoFromSqlite() {
		seqlite = new SelfSqlite(this, "personal.db", null, Version.dataversion);
		db = seqlite.getReadableDatabase();// �Զ���ʽ��
		// ������ݵ����ݿ�
		perdao.inserInfo(db);
		
		// ��ȡ���е���Ϣ
		allperlist = perdao.readData(db, allperlist);
	}
	public void inAdater() {
		personalsimp = new SimpleAdapter(this, allperlist, R.layout.personal_item, new String[] { "title", "context" },
				new int[] { R.id.personal_itemtitle, R.id.personal_itemcontext });

		// ����
		perlistview.setAdapter(personalsimp);
	}
	// ��ť���
	// ȥ�޸���Ϣ
	public void PersonalToAlter(View v){
		Intent in = new Intent(this, PersonalAlterActivity.class);
		startActivity(in);
		finish();
	}
	// ����
	public void Back(View v){
		finish();
	}
}

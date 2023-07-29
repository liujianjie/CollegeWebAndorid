package com.example.selfintroduction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.Sqlite.SelfSqlite;
import com.example.Sqlite.Version;
import com.example.adpter.HobbyAlterBaseAdapter;
import com.example.adpter.PersonalAlterBaseAdapter;
import com.example.application.GetColorAndStyleClass;
import com.example.application.MyApplication;
import com.example.bean.HobbyBean;
import com.example.bean.MyhobbyBean;
import com.example.bean.PersonalBean;
import com.example.dao.HobbyDao;
import com.example.dao.PersonalDao;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.widget.ViewDragHelper;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

// ������Ϣ�޸�activity
public class PersonalAlterActivity extends AppCompatActivity {
	private TextView title;
	EditText titletext,contexttext;
	
	PersonalAlterBaseAdapter perbase;

	ListView perlistview;

	private List<PersonalBean> perlist;

	PersonalDao perdao = new PersonalDao();
	
	SelfSqlite seqlite;
	SQLiteDatabase db;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);// �ޱ���
		setContentView(R.layout.activity_personalalter);
		getSupportActionBar().hide();
		findViews();
		initData();
		getInfoFromSqlite();
		inAdater();
		giveListToGridView();
	}

	private void findViews() {
		perlistview = (ListView) findViewById(R.id.personalalter_listview);
		titletext = (EditText)findViewById(R.id.personalalter_title);
		contexttext = (EditText)findViewById(R.id.personalalter_context);
		title = (TextView) findViewById(R.id.personalalter_toptitle);
		if(MyApplication.getSettingbean() != null){
			title.setTextSize(MyApplication.getSettingbean().getTitlesize());
			// ��ɫ
			title.setTextColor(GetColorAndStyleClass.getColorFromIndex(MyApplication.getSettingbean().getTitlecolor()));
			// ��ʽ����
			int style = MyApplication.getSettingbean().getTitlestyle();
			title.setTypeface(Typeface.MONOSPACE, GetColorAndStyleClass.getStyleFromIndex(style));
		}
	}
	

	// ��ʼ������
	private void initData() {
		perlist = new ArrayList<PersonalBean>();
	}

	private void inAdater() {
		if (perlist != null) {
			perbase = new PersonalAlterBaseAdapter(this);
			perbase.SetData(perlist);
			perlistview.setAdapter(perbase);
		}
	}

	// ��ȡ���ݿ���Ϣ
	private void getInfoFromSqlite() {
		// �������ݿ�ʵ��
		seqlite = new SelfSqlite(this, "personal.db", null, Version.dataversion);
		db = seqlite.getReadableDatabase();// �Զ���ʽ��

		// ��ȡ ���е�
		perlist = perdao.readDataToPersonalBean(db, perlist);
		Log.i("check", "perlist:"+perlist.toString()+"");
	}

	// ����view���� ֪��ѡ���ļ���
	private void giveListToGridView() {
	}
	// ���ݲ���
	// 1.ɾ��һ��,�����±�
	public void PersonalDelete(int pos) {
		// �ȵõ�ʵ����
		PersonalBean per = perlist.get(pos);
		
		// ɾ�����ݿ�� ��Ϣ
		perdao.deletePersonalByid(db, per.getPerid());
		
		// ɾ��list����
		perlist.remove(pos);
		perbase.notifyDataSetChanged();
	}
	// 2.�޸ĸ�����Ϣ
	public void PersonalAlter(int pos, String title, String context) {
		if(!title.trim().equals("") && !context.trim().equals("")){
			// Ҫ��ȡ�����
			PersonalBean per = perlist.get(pos);
			per.setTitle(title);
			per.setContext(context);
			
//			Toast.makeText(this, per.toString(), Toast.LENGTH_SHORT).show(); 
			// ����id�޸�
			perdao.updatePersonalByid(db, perlist.get(pos));

			Toast.makeText(this, "�޸ĳɹ�", Toast.LENGTH_SHORT).show(); 
			Log.i("check", "�޸ĸ�����Ϣ���");
		}else{
			Toast.makeText(this, "����Ϊ��", Toast.LENGTH_SHORT).show(); 
		}
		
	}
	// 3.���� ���¶��嵽PersonalActivity����ΪҪ���¼������� ���򵥵�����
	public void Back(View view){
		Intent in = new Intent(this, PersonalProfileActivity.class);
		startActivity(in);
		finish();
	}
	
	// 4.���һ��
	public void PersonalAdd(View view){
		// ��ȡ����ģ�����Ϊ�� 
		String titlest = titletext.getText().toString();
		String contextst = contexttext.getText().toString();
		if(!titlest.trim().equals("") && !contextst.trim().equals("")){
			// 1.��ӵ����ݿⲢ�ҷ���id
			int id = perdao.addonePersonal(db, titlest, contextst);
			if(id != 0){
				Toast.makeText(this, "��ӳɹ�", Toast.LENGTH_SHORT).show();
				// ����µ�bean��ӵ�list ˢ��
				PersonalBean per = new PersonalBean(id, titlest, contextst);
				perlist.add(per);
				perbase.notifyDataSetChanged();
			}
		}else{
			Toast.makeText(this, "����Ϊ��", Toast.LENGTH_SHORT).show(); 
		}
	}
	// ��д�������·��ذ�ťʱ ���ظ�����Ϣ
	@Override
	public void onBackPressed() {
		Intent in = new Intent(this, PersonalProfileActivity.class);
		startActivity(in);
		finish();
	}
}

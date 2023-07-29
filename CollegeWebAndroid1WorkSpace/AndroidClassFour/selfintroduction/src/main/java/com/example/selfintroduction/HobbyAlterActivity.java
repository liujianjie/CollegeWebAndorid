package com.example.selfintroduction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.Sqlite.SelfSqlite;
import com.example.Sqlite.Version;
import com.example.adpter.HobbyAlterBaseAdapter;
import com.example.application.GetColorAndStyleClass;
import com.example.application.MyApplication;
import com.example.bean.HobbyBean;
import com.example.bean.MyhobbyBean;
import com.example.bean.PersonalBean;
import com.example.dao.HobbyDao;

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

// ����activity
public class HobbyAlterActivity extends AppCompatActivity {
	private TextView title;
	EditText addhobbyedit;

	HobbyAlterBaseAdapter hobbybase;

	GridView hobbygridview;

	private List<HobbyBean> hobbylist;

	HobbyDao hobydao = new HobbyDao();

	public List<String> alterselfhobbylist;// Ҫɾ���ĺ�Ҫ�޸��Լ����õ�list

	SelfSqlite seqlite;
	SQLiteDatabase db;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);// �ޱ���
		setContentView(R.layout.activity_hobbyalter);
		getSupportActionBar().hide();
		findViews();
		initData();
		getInfoFromSqlite();
		inAdater();
	}

	private void findViews() {
		hobbygridview = (GridView) findViewById(R.id.hobbyalter_gridview);
		addhobbyedit = (EditText)findViewById(R.id.hobbyalter_edit);
		title = (TextView) findViewById(R.id.hobbyalter_title);
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
		hobbylist = new ArrayList<HobbyBean>();
		alterselfhobbylist = new ArrayList<String>();
	}

	private void inAdater() {
		if (hobbylist != null) {
			hobbybase = new HobbyAlterBaseAdapter(this);
			hobbybase.SetData(hobbylist);
			hobbygridview.setAdapter(hobbybase);
		}
	}

	// ��ȡ���ݿ���Ϣ
	private void getInfoFromSqlite() {
		// �������ݿ�ʵ��
		seqlite = new SelfSqlite(this, "personal.db", null, Version.dataversion);
		db = seqlite.getReadableDatabase();// �Զ���ʽ��

		// ��ȡ ���еİ���
		hobbylist = hobydao.readDataToHobbyBean(db, hobbylist);
		// ��ȡ�ҵİ���
		alterselfhobbylist = hobydao.readDataWithMyhobby(db, alterselfhobbylist);
		Log.i("check", "alterselfhobbylist:"+alterselfhobbylist.toString()+"");
	}
	// ���ݲ���
	// 1.ɾ����������,�����±�
	public void HobbyNameDelete(int pos) {
		// �ȵõ�ʵ����
		HobbyBean ho = hobbylist.get(pos);

		// ���а����е��Ǹ�Ҫ���� ɾ��������id
		hobydao.deleteHobbyByid(db,ho.getHobbyid());
		// ��������ҵİ���ҲҪɾ���Ǹ�
		if(alterselfhobbylist.contains(ho.getHobbyid()+"")){
			alterselfhobbylist.remove(ho.getHobbyid()+"");// ɾ���ҵ�
		}
		// ������û�� ɾ��
		hobydao.deleteMyHobbyByid(db,ho.getHobbyid());// ɾ�����ݿ��

		Log.i("check", "HobbyNameDelete,alterselfhobbylist:"+alterselfhobbylist.toString()+"");

		// ��ͼ����
		hobbylist.remove(pos);
		hobbybase.notifyDataSetChanged();

		Toast.makeText(this, "ɾ�����óɹ�", Toast.LENGTH_SHORT).show();
	}
	// 2.�޸�ϲ���İ���
	public void HobbyNameAlter(View view) {
		// ��ѡ���������ӵ����ݿ��У���ɾ�����ٸ���ѡ������
		hobydao.deleteAllMyhobby(db);

		Log.i("check", alterselfhobbylist.size()+"�޸��ҵİ���ǰ�������!!!!");

		hobydao.addMyhobby(db, alterselfhobbylist);

		Toast.makeText(this, "�޸İ��óɹ�", Toast.LENGTH_SHORT).show();
	}
	// 3.���� ���¶��嵽hobyactivity����ΪҪ���¼������� ���򵥵�����
	public void Back(View view){
		Intent in = new Intent(this, HobbyActivity.class);
		startActivity(in);
		finish();
	}
	// 4.���һ������
	public void HobbyNameAdd(View view){
		// ��ȡ����ģ�����Ϊ�գ�Ҳ���ܴ���ͬ����
		String hname = addhobbyedit.getText().toString();
		if(!hname.trim().equals("")){
			boolean isadd = true;
			for(int i = 0; i < hobbylist.size(); i++){
				HobbyBean h = hobbylist.get(i);
				if(h.getHobbyname().equals(hname)){
					Toast.makeText(this, "�Ѵ���ͬ������", Toast.LENGTH_SHORT).show();
					isadd = false;
					break;
				}
			}
			// ������ͬ����
			if(isadd){
				// 1.��ӵ����ݿⲢ�ҷ���id
				int id = hobydao.addoneHobbyName(db,hname);
				if(id != 0){
					Toast.makeText(this, "��ӳɹ�", Toast.LENGTH_SHORT).show();
					// ����µ�bean��ӵ�list ˢ��
					HobbyBean ho = new HobbyBean();
					ho.setHobbyid(id);
					ho.setHobbyname(hname);
					hobbylist.add(ho);
					hobbybase.notifyDataSetChanged();

					// ��Ϊ��
					addhobbyedit.setText("");
				}
			}
		}else{
			Toast.makeText(this, "����Ϊ��", Toast.LENGTH_SHORT).show();
		}
	}

	// ��д�������·��ذ�ťʱ ���ذ���
	@Override
	public void onBackPressed() {
		Intent in = new Intent(this, HobbyActivity.class);
		startActivity(in);
		finish();
	}
}

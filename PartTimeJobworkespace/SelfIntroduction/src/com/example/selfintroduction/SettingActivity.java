package com.example.selfintroduction;

import com.example.Sqlite.SelfSqlite;
import com.example.Sqlite.Version;
import com.example.application.GetColorAndStyleClass;
import com.example.application.MyApplication;
import com.example.bean.SettingBean;
import com.example.dao.SettingDao;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ArrayAdapter;

// ����
public class SettingActivity extends Activity {
	private TextView title;
	private Spinner sp1,sp2,sp3,sp4,sp5,sp6;

    ArrayAdapter<Integer> ad1;
    ArrayAdapter<Integer> ad2;
    ArrayAdapter<Integer> ad3;
    ArrayAdapter<Integer> ad4;
    ArrayAdapter<String> ad5;
    ArrayAdapter<String> ad6;
    
    SettingDao sedao = new SettingDao();
    SelfSqlite seqlite;
	SQLiteDatabase db;
	SettingBean sebean;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);//�ޱ���
		setContentView(R.layout.activity_setting);
		findViews();
		initData();
		giveSelect();
		settingInfo();
	}
	private void findViews(){
		title = (TextView) findViewById(R.id.setting_title);
		sp1 = (Spinner)findViewById(R.id.setting_mainsp);
		sp2 = (Spinner)findViewById(R.id.setting_photosp);
		sp3 = (Spinner)findViewById(R.id.setting_hobbysp);
		sp4 = (Spinner)findViewById(R.id.setting_titlesp);
		sp5 = (Spinner)findViewById(R.id.setting_titlecolorsp);
		sp6 = (Spinner)findViewById(R.id.setting_titlestylesp);
	
		// ��ȡlistֵ
		sedao.getDefaultSettingList();
		ad1 = new ArrayAdapter<Integer>(this,android.R.layout.simple_list_item_1,sedao.li1);
        ad2 = new ArrayAdapter<Integer>(this,android.R.layout.simple_list_item_1,sedao.li2);
        ad3 = new ArrayAdapter<Integer>(this,android.R.layout.simple_list_item_1,sedao.li3);
        ad4 = new ArrayAdapter<Integer>(this,android.R.layout.simple_list_item_1,sedao.li4);
        ad5 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,sedao.li5);
        ad6 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,sedao.li6);

        sp1.setAdapter(ad1);
        sp2.setAdapter(ad2);
        sp3.setAdapter(ad3);
        sp4.setAdapter(ad4);
        sp5.setAdapter(ad5);
        sp6.setAdapter(ad6);
	}
	// ��������ó�Ĭ������
	private void initData(){
		seqlite = new SelfSqlite(this, "personal.db", null, Version.dataversion);
		db = seqlite.getReadableDatabase();// �Զ���ʽ��
		// ��ȫ�ָ�ֵ
		sebean = MyApplication.getSettingbean();
		Log.i("check", sebean.toString());
	}
	// ����spѡ��
	private void giveSelect(){
		// ����sebean��ѡ��
		int c1 = ad1.getCount();
		for(int i = 0; i < c1; i++){
			if(ad1.getItem(i).toString().equals(sebean.getMainnum()+"")){
				sp1.setSelection(i);
			}
			
		}
		int c2 = ad2.getCount();
		for(int i = 0; i < c2; i++){
			if(ad2.getItem(i).toString().equals(sebean.getPhotonum()+"")){
				sp2.setSelection(i);
			}
			
		}
		int c3 = ad3.getCount();
		for(int i = 0; i < c3; i++){
			if(ad3.getItem(i).toString().equals(sebean.getHobbynum()+"")){
				sp3.setSelection(i);
			}
			
		}
		int c4 = ad4.getCount();
		for(int i = 0; i < c4; i++){
			if(ad4.getItem(i).toString().equals(sebean.getTitlesize()+"")){
				sp4.setSelection(i);
			}
		}
		int c5 = ad5.getCount();
		for(int i = 0; i < c5; i++){
			String st = changeTitleColor(sebean.getTitlecolor());
			// ��Ҫת��
			if(ad5.getItem(i).toString().equals(st)){
				sp5.setSelection(i);
			}
		}
		int c6 = ad6.getCount();
		for(int i = 0; i < c6; i++){
			String st = changeTitleStyle(sebean.getTitlestyle());
			if(ad6.getItem(i).toString().equals(st)){
				sp6.setSelection(i);
			}
		}
	}
	private String changeTitleColor(int index){
		String st = "";
		switch (index) {
		case 0:
			st = "��ɫ";
			break;
		case 1:
			st = "��ɫ";
			break;
		case 2:
			st = "��ɫ";
			break;
		case 3:
			st = "��ɫ";
			break;
		}
		return st;
	}
	private String changeTitleStyle(int index){
		String st = "";
		switch (index) {
		case 0:
			st = "Ĭ��";
			break;
		case 1:
			st = "�Ӵ�";
			break;
		case 2:
			st = "��б";
			break;
		case 3:
			st = "��б�Ӵ�";
			break;
		}
		return st;
	}
	// ����ѡ������޸ı���Ϣ
	public void SettingAlter(View v){
		SettingBean se = new SettingBean();
		se.setSettingid(MyApplication.getSettingbean().getSettingid());
		se.setMainnum(Integer.valueOf(sp1.getSelectedItem().toString()));
		se.setPhotonum(Integer.valueOf(sp2.getSelectedItem().toString()));
		se.setHobbynum(Integer.valueOf(sp3.getSelectedItem().toString()));
		se.setTitlesize(Integer.valueOf(sp4.getSelectedItem().toString()));
		se.setTitlecolor(sp5.getSelectedItemPosition());// ֻ��Ҫ�±������
		se.setTitlestyle(sp6.getSelectedItemPosition());
		// �޸ı�
		sedao.updateSetting(db, se);
		// ��ȫ�ֵĵ������
		MyApplication.setSettingbean(se);
		
		Toast.makeText(this, "���óɹ�", Toast.LENGTH_SHORT).show();;
		settingInfo();
	}
	public void settingInfo(){
		if(MyApplication.getSettingbean() != null){
			title.setTextSize(MyApplication.getSettingbean().getTitlesize());
			// ��ɫ
			title.setTextColor(GetColorAndStyleClass.getColorFromIndex(MyApplication.getSettingbean().getTitlecolor()));
			// ��ʽ����
			int style = MyApplication.getSettingbean().getTitlestyle();
			title.setTypeface(Typeface.MONOSPACE, GetColorAndStyleClass.getStyleFromIndex(style));
		}
	}
	// ����
	public void Back(View v){
		finish();
	}
}

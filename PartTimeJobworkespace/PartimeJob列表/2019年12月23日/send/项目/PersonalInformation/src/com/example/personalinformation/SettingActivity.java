package com.example.personalinformation;

import com.example.Sqlite.SelfSqlite;
import com.example.Sqlite.Version;
import com.example.application.MyApplication;
import com.example.bean.SettingBean;
import com.example.dao.SettingDao;
import com.example.personalinformation.R;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ArrayAdapter;

// 设置
public class SettingActivity extends Activity {
	private TextView title;
	private Spinner sp1,sp2,sp3,sp4;

    ArrayAdapter<Integer> ad1;
    ArrayAdapter<Integer> ad2;
    ArrayAdapter<Integer> ad3;
    ArrayAdapter<Integer> ad4;

    SettingDao sedao = new SettingDao();
    SelfSqlite seqlite;
	SQLiteDatabase db;
	SettingBean sebean;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);//无标题
		setContentView(R.layout.activity_setting);
		findViews();
		initData();
		giveSelect();
		giveListen();
	}
	private void findViews(){
		title = (TextView) findViewById(R.id.setting_title);
		if(MyApplication.getSettingbean() != null){
			title.setTextSize(MyApplication.getSettingbean().getTitlesize());
		}
		
		sp1 = (Spinner)findViewById(R.id.setting_mainsp);
		sp2 = (Spinner)findViewById(R.id.setting_photosp);
		sp3 = (Spinner)findViewById(R.id.setting_hobbysp);
		sp4 = (Spinner)findViewById(R.id.setting_titlesp);
		
		// 获取list值
		sedao.getDefaultSettingList();
		ad1 = new ArrayAdapter<Integer>(this,android.R.layout.simple_list_item_1,sedao.li1);
        ad2 = new ArrayAdapter<Integer>(this,android.R.layout.simple_list_item_1,sedao.li2);
        ad3 = new ArrayAdapter<Integer>(this,android.R.layout.simple_list_item_1,sedao.li3);
        ad4 = new ArrayAdapter<Integer>(this,android.R.layout.simple_list_item_1,sedao.li4);

        sp1.setAdapter(ad1);
        sp2.setAdapter(ad2);
        sp3.setAdapter(ad3);
        sp4.setAdapter(ad4);

	}
	// 从数据里得出默认设置
	private void initData(){
		seqlite = new SelfSqlite(this, "personal.db", null, Version.dataversion);
		db = seqlite.getReadableDatabase();// 以读方式打开
		// 从全局赋值
		sebean = MyApplication.getSettingbean();
		Log.i("check", sebean.toString());
	}
	// 给予sp选中
	private void giveSelect(){
		// 根据sebean来选择
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
	}
	private void giveListen(){
		
	}
	// 根据选择的项修改表信息
	public void SettingAlter(View v){
		SettingBean se = new SettingBean();
		se.setMainnum(Integer.valueOf(sp1.getSelectedItem().toString()));
		se.setPhotonum(Integer.valueOf(sp2.getSelectedItem().toString()));
		se.setHobbynum(Integer.valueOf(sp3.getSelectedItem().toString()));
		se.setTitlesize(Integer.valueOf(sp4.getSelectedItem().toString()));
		// 修改表
		sedao.updateSetting(db, se);
		// 让全局的等于这个
		MyApplication.setSettingbean(se);
	}
	// 返回
	public void Back(View v){
		finish();
	}
}

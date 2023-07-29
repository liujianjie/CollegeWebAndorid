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

// 个人信息修改activity
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
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);// 无标题
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
			// 颜色
			title.setTextColor(GetColorAndStyleClass.getColorFromIndex(MyApplication.getSettingbean().getTitlecolor()));
			// 样式特殊
			int style = MyApplication.getSettingbean().getTitlestyle();
			title.setTypeface(Typeface.MONOSPACE, GetColorAndStyleClass.getStyleFromIndex(style));
		}
	}
	

	// 初始化数据
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

	// 获取数据库信息
	private void getInfoFromSqlite() {
		// 创建数据库实例
		seqlite = new SelfSqlite(this, "personal.db", null, Version.dataversion);
		db = seqlite.getReadableDatabase();// 以读方式打开

		// 读取 所有的
		perlist = perdao.readDataToPersonalBean(db, perlist);
		Log.i("check", "perlist:"+perlist.toString()+"");
	}

	// 给予view监听 知道选了哪几个
	private void giveListToGridView() {
	}
	// 数据操作
	// 1.删除一项,根据下标
	public void PersonalDelete(int pos) {
		// 先得到实例化
		PersonalBean per = perlist.get(pos);
		
		// 删除数据库的 信息
		perdao.deletePersonalByid(db, per.getPerid());
		
		// 删除list更新
		perlist.remove(pos);
		perbase.notifyDataSetChanged();
	}
	// 2.修改个人信息
	public void PersonalAlter(int pos, String title, String context) {
		if(!title.trim().equals("") && !context.trim().equals("")){
			// 要获取输入的
			PersonalBean per = perlist.get(pos);
			per.setTitle(title);
			per.setContext(context);
			
//			Toast.makeText(this, per.toString(), Toast.LENGTH_SHORT).show(); 
			// 根据id修改
			perdao.updatePersonalByid(db, perlist.get(pos));

			Toast.makeText(this, "修改成功", Toast.LENGTH_SHORT).show(); 
			Log.i("check", "修改个人信息完成");
		}else{
			Toast.makeText(this, "不能为空", Toast.LENGTH_SHORT).show(); 
		}
		
	}
	// 3.返回 重新定义到PersonalActivity，因为要重新加载数据 更简单的做法
	public void Back(View view){
		Intent in = new Intent(this, PersonalProfileActivity.class);
		startActivity(in);
		finish();
	}
	
	// 4.添加一项
	public void PersonalAdd(View view){
		// 获取输入的，不能为空 
		String titlest = titletext.getText().toString();
		String contextst = contexttext.getText().toString();
		if(!titlest.trim().equals("") && !contextst.trim().equals("")){
			// 1.添加到数据库并且返回id
			int id = perdao.addonePersonal(db, titlest, contextst);
			if(id != 0){
				Toast.makeText(this, "添加成功", Toast.LENGTH_SHORT).show();
				// 组成新的bean添加到list 刷新
				PersonalBean per = new PersonalBean(id, titlest, contextst);
				perlist.add(per);
				perbase.notifyDataSetChanged();
			}
		}else{
			Toast.makeText(this, "不能为空", Toast.LENGTH_SHORT).show(); 
		}
	}
	// 重写，当按下返回按钮时 跳回个人信息
	@Override
	public void onBackPressed() {
		Intent in = new Intent(this, PersonalProfileActivity.class);
		startActivity(in);
		finish();
	}
}

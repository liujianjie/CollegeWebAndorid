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

// 爱好activity
public class HobbyAlterActivity extends AppCompatActivity {
	private TextView title;
	EditText addhobbyedit;

	HobbyAlterBaseAdapter hobbybase;

	GridView hobbygridview;

	private List<HobbyBean> hobbylist;

	HobbyDao hobydao = new HobbyDao();

	public List<String> alterselfhobbylist;// 要删除的和要修改自己爱好的list

	SelfSqlite seqlite;
	SQLiteDatabase db;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);// 无标题
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
			// 颜色
			title.setTextColor(GetColorAndStyleClass.getColorFromIndex(MyApplication.getSettingbean().getTitlecolor()));
			// 样式特殊
			int style = MyApplication.getSettingbean().getTitlestyle();
			title.setTypeface(Typeface.MONOSPACE, GetColorAndStyleClass.getStyleFromIndex(style));
		}
	}

	// 初始化数据
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

	// 获取数据库信息
	private void getInfoFromSqlite() {
		// 创建数据库实例
		seqlite = new SelfSqlite(this, "personal.db", null, Version.dataversion);
		db = seqlite.getReadableDatabase();// 以读方式打开

		// 读取 所有的爱好
		hobbylist = hobydao.readDataToHobbyBean(db, hobbylist);
		// 读取我的爱好
		alterselfhobbylist = hobydao.readDataWithMyhobby(db, alterselfhobbylist);
		Log.i("check", "alterselfhobbylist:"+alterselfhobbylist.toString()+"");
	}
	// 数据操作
	// 1.删除爱好名字,根据下标
	public void HobbyNameDelete(int pos) {
		// 先得到实例化
		HobbyBean ho = hobbylist.get(pos);

		// 所有爱好中的那个要更新 删除，根据id
		hobydao.deleteHobbyByid(db,ho.getHobbyid());
		// 如果存在我的爱好也要删除那个
		if(alterselfhobbylist.contains(ho.getHobbyid()+"")){
			alterselfhobbylist.remove(ho.getHobbyid()+"");// 删除我的
		}
		// 不管有没有 删除
		hobydao.deleteMyHobbyByid(db,ho.getHobbyid());// 删除数据库的

		Log.i("check", "HobbyNameDelete,alterselfhobbylist:"+alterselfhobbylist.toString()+"");

		// 视图更新
		hobbylist.remove(pos);
		hobbybase.notifyDataSetChanged();

		Toast.makeText(this, "删除爱好成功", Toast.LENGTH_SHORT).show();
	}
	// 2.修改喜欢的爱好
	public void HobbyNameAlter(View view) {
		// 把选择的数据添加到数据库中，先删除，再根据选择的添加
		hobydao.deleteAllMyhobby(db);

		Log.i("check", alterselfhobbylist.size()+"修改我的爱好前检查数量!!!!");

		hobydao.addMyhobby(db, alterselfhobbylist);

		Toast.makeText(this, "修改爱好成功", Toast.LENGTH_SHORT).show();
	}
	// 3.返回 重新定义到hobyactivity，因为要重新加载数据 更简单的做法
	public void Back(View view){
		Intent in = new Intent(this, HobbyActivity.class);
		startActivity(in);
		finish();
	}
	// 4.添加一个爱好
	public void HobbyNameAdd(View view){
		// 获取输入的，不能为空，也不能存在同名的
		String hname = addhobbyedit.getText().toString();
		if(!hname.trim().equals("")){
			boolean isadd = true;
			for(int i = 0; i < hobbylist.size(); i++){
				HobbyBean h = hobbylist.get(i);
				if(h.getHobbyname().equals(hname)){
					Toast.makeText(this, "已存在同名爱好", Toast.LENGTH_SHORT).show();
					isadd = false;
					break;
				}
			}
			// 不存在同名的
			if(isadd){
				// 1.添加到数据库并且返回id
				int id = hobydao.addoneHobbyName(db,hname);
				if(id != 0){
					Toast.makeText(this, "添加成功", Toast.LENGTH_SHORT).show();
					// 组成新的bean添加到list 刷新
					HobbyBean ho = new HobbyBean();
					ho.setHobbyid(id);
					ho.setHobbyname(hname);
					hobbylist.add(ho);
					hobbybase.notifyDataSetChanged();

					// 设为空
					addhobbyedit.setText("");
				}
			}
		}else{
			Toast.makeText(this, "不能为空", Toast.LENGTH_SHORT).show();
		}
	}

	// 重写，当按下返回按钮时 跳回爱好
	@Override
	public void onBackPressed() {
		Intent in = new Intent(this, HobbyActivity.class);
		startActivity(in);
		finish();
	}
}

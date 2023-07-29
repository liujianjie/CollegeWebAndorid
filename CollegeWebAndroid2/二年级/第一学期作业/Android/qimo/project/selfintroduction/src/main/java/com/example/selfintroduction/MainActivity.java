package com.example.selfintroduction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.Sqlite.SelfSqlite;
import com.example.Sqlite.Version;
import com.example.application.GetColorAndStyleClass;
import com.example.application.MyApplication;
import com.example.bean.SettingBean;
import com.example.dao.SettingDao;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.AdapterView;

// ��ҳ��
public class MainActivity extends AppCompatActivity {
	
	private TextView title;
	private GridView zhygrid;
	
	private SimpleAdapter mainsimp;
	
	private List<Map<String,Object>> list;
	
	private String[] maintext ={"���","���˼��","��Ȥ����","����","����","�˳�"};// ������Դ
	
	private int[] mainimg = {R.drawable.photo,R.drawable.person,R.drawable.hobby,R.drawable.setting,R.drawable.help,R.drawable.tuichu};// ͼƬ��Դ
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);//�ޱ���
		setContentView(R.layout.activity_main);
		getSupportActionBar().hide();
		findViews();
		initData();
		giveListen();
		settingInfo();
	}
	private void findViews(){
		zhygrid = (GridView) findViewById(R.id.main_gridview);
		title = (TextView) findViewById(R.id.mian_title);
	}
	// ������Ϣ
	public void settingInfo(){
		// �޸ĸ��� ��������get
		if(MyApplication.getSettingbean() != null){
			zhygrid.setNumColumns(MyApplication.getSettingbean().getMainnum());
			title.setTextSize(MyApplication.getSettingbean().getTitlesize());
			// ��ɫ
			title.setTextColor(GetColorAndStyleClass.getColorFromIndex(MyApplication.getSettingbean().getTitlecolor()));
			// ��ʽ����
			int style = MyApplication.getSettingbean().getTitlestyle();
			title.setTypeface(Typeface.MONOSPACE, GetColorAndStyleClass.getStyleFromIndex(style));
		}
	}
	private void initData(){
		list = new ArrayList<Map<String,Object>>();
		// �������� Ĭ��6�� �����
		for(int i = 0; i < 6; i++){
			Map<String,Object> ma = new HashMap<String, Object>();
			ma.put("img", mainimg[i]);
			ma.put("text",maintext[i]);
			list.add(ma);
		}
				
		mainsimp = new SimpleAdapter(this, list, R.layout.main_item, 
				new String[]{"img","text"},
				new int[]{R.id.mainitem1_img,R.id.mainitem1_text});
		
		// ����
		zhygrid.setAdapter(mainsimp);
	}
	private void giveListen(){
		zhygrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			// ����¼�
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// TODO Auto-generated method stub
				Intent in = null;
				switch (position) {// 6��
					case 0:
						in = new Intent(MainActivity.this,PhotoActivity.class);
					break;
					case 1:
						in = new Intent(MainActivity.this,PersonalProfileActivity.class);
					break;
					case 2:
						in = new Intent(MainActivity.this,HobbyActivity.class);
					break;
					case 3:
						in = new Intent(MainActivity.this,SettingActivity.class);
					break;
					case 4:
						// �������ûʲô���ݰ�
						Builder builders = new Builder(MainActivity.this);
						builders.setTitle("����");
						builders.setMessage("1.���ͼƬ������Ӧ����\n2.������������\n");
						builders.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {
							
							@Override
							public void onClick(DialogInterface arg0, int arg1) {
								// TODO Auto-generated method stub
							}
						});
						builders.show();
					break;
					case 5:
						// �˳�������ѯ���Ƿ��˳�
						Builder builder = new Builder(MainActivity.this);
						builder.setTitle("ϵͳ��ʾ");
						builder.setMessage("��ȷ���˳���");
						builder.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {
							
							@Override
							public void onClick(DialogInterface arg0, int arg1) {
								// TODO Auto-generated method stub
								MainActivity.this.finish();
							}
						});
						builder.show();
					break;
				};
				// �����˳�����ת
				if(position != 5 && in != null){
					startActivity(in);
				}
			}
		});
	}
	// ����������ʱ���Ҫ������Ϣ
	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		Log.i("check", "���´���mian");
		settingInfo();
	}
}

package com.example.testlisthorapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.AdapterView;

public class MainActivity extends Activity {
	
	private GridView zhygrid;
	
	private SimpleAdapter mainsimp;
	
	private List<Map<String,Object>> list;
	
	private String[] maintext ={"相册","个人简介","兴趣爱好","设置","帮助","退出"};// 文字资源
	
	private int[] mainimg = {R.drawable.zhuye1,R.drawable.zhuye1,R.drawable.zhuye1,R.drawable.zhuye1,R.drawable.zhuye1,R.drawable.zhuye1};// 图片资源
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);//无标题
		setContentView(R.layout.activity_main);
		findViews();
		initData();
		giveListen();
	}
	private void findViews(){
		zhygrid = (GridView) findViewById(R.id.main_gridview);
	}
	private void initData(){
		list = new ArrayList<Map<String,Object>>();
		mainsimp = new SimpleAdapter(this, list, R.layout.main_item1, 
				new String[]{"img","text"},
				new int[]{R.id.mainitem1_img,R.id.mainitem1_text});
		
		// 给予数据 默认6个 不变的
		for(int i = 0; i < 6; i++){
			Map<String,Object> ma = new HashMap<String, Object>();
			ma.put("img", mainimg[i]);
			ma.put("text",maintext[i]);
		}
		// 适配
		zhygrid.setAdapter(mainsimp);
	}
	private void giveListen(){
		zhygrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
}

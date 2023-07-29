package com.example.personalinformation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.application.MyApplication;
import com.example.personalinformation.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

// 相册页面
public class PhotoActivity extends Activity {
	private TextView title;
	private GridView photogrid;
	
	private SimpleAdapter photosimp;
	
	private List<Map<String,Object>> list;
	
	private int[] selfimg = {R.drawable.self1,R.drawable.self2};// 图片
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);//无标题
		setContentView(R.layout.activity_photo);
		findViews();
		initData();
		SetAapTer();
	}
	private void findViews(){
		photogrid = (GridView) findViewById(R.id.photo_gridview);
		title = (TextView) findViewById(R.id.photo_title);
		if(MyApplication.getSettingbean() != null){
			photogrid.setNumColumns(MyApplication.getSettingbean().getPhotonum());
			title.setTextSize(MyApplication.getSettingbean().getTitlesize());
		}
	}
	private void initData(){
		list = new ArrayList<Map<String,Object>>();
		for(int i = 0; i < selfimg.length; i++){
			Map<String,Object> ma = new HashMap<String, Object>();
			ma.put("img", selfimg[i]);
			list.add(ma);
		}
	}
	public void SetAapTer(){
		photosimp = new SimpleAdapter(this, list, R.layout.photo_item, 
				new String[]{"img"},
				new int[]{R.id.photoitem_img});
		
		// 适配
		photogrid.setAdapter(photosimp);
	}
	public void Back(View view){
		finish();
	}
}

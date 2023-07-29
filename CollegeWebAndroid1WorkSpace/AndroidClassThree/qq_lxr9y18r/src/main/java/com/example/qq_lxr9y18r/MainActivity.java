package com.example.qq_lxr9y18r;


import java.util.ArrayList;

import org.json.JSONObject;

import com.example.qq_lxr9y18r.bean.AndroidQqMessage;
import com.example.qq_lxr9y18r.bean.AndroidQqMessageList;
import com.example.qq_lxr9y18r.bean.AndroidQqUser;
import com.example.qq_lxr9y18r.constant.URI_IP;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends FragmentActivity implements OnClickListener{

	private Button btn;
	private Button btn2;
	private Button btn3;
	
	//用户信息
	AndroidQqUser qquser;
	
	//三个 模块 Fragment
	private XiaoXiFragment xiaoxi_fg;
	private LianXiRenFragment lianxiren_fg;
	
	FragmentManager manager;
	
	//这里一个广播
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);//无标题
		setContentView(R.layout.activity_main);
		getQQuser();//获取登录俄用户 先获取用户 在获取好友
		findView();
		setManagers();
	}
	public void getQQuser(){
		qquser=Applications.getqquser();
	}
	public void findView(){
		btn = (Button) this.findViewById(R.id.btn);
		btn.setOnClickListener(this);
		btn2 = (Button) this.findViewById(R.id.btn2);
		btn2.setOnClickListener(this);
		btn3 = (Button) this.findViewById(R.id.btn3);
		btn3.setOnClickListener(this);
		
		xiaoxi_fg = new XiaoXiFragment(this);
		lianxiren_fg = new LianXiRenFragment(this);
	}
	//一开始设置为消息fragment
	public void setManagers(){
		manager = this.getSupportFragmentManager();
		FragmentTransaction tran = manager.beginTransaction();
		tran.add(R.id.main_zhong,xiaoxi_fg );
		tran.commit();
	}
	
	@Override
	public void onClick(View v) {
		FragmentTransaction tran = manager.beginTransaction();
		int id = v.getId();
		if(id == R.id.btn){
			btn.setEnabled(false);
			btn2.setEnabled(true);
			btn3.setEnabled(true);
			tran.replace(R.id.main_zhong, xiaoxi_fg);
		}else if(id == R.id.btn2){
			btn.setEnabled(true);
			btn2.setEnabled(false);
			btn3.setEnabled(true);
			tran.replace(R.id.main_zhong, lianxiren_fg);
		}else if(id == R.id.btn3){//动态
			Intent intent = new Intent(this,DongTaiActivity.class);
			startActivity(intent);
		}
		tran.commit();
	}
}

package com.example.qq;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.w3c.dom.Text;

import com.example.qq.basadpter.MoveFenzuAdpdter;
import com.example.qq.bean.AndroidQqHy;
import com.example.qq.bean.AndroidQqUser;
import com.example.qq.constant.URI_IP;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MoveFenZuActivity extends FragmentActivity{
	private ListView fenzu_lv;
	private TextView layout1_tv2_ok;
	private List<String> list;
	int id;
	private AndroidQqUser qquser;
	private AndroidQqHy hyqquser;
	MoveFenzuAdpdter move ;
	int hystatu;
	public Handler handler = new Handler(){
		@Override
		public void handleMessage(Message msg) {
			int what = msg.what;
			switch (what) {
			case 0:
				break;
			case 1:
				Applications.setHyqquser(hyqquser);
				notifys();
				break;
			case 2:
				Toast.makeText(MoveFenZuActivity.this, "网络连接失败", 0).show();
				break;
			case 3:
				//广播 关闭
				sendBroasts();
				finish();
				break;
			case 4:
				
				break;
			default:
				break;
			}
		}
	};
	@Override
	protected void onCreate(Bundle arg0) {
		// TODO 自动生成的方法存根
		super.onCreate(arg0);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);//无标题
		setContentView(R.layout.activity_fenzu);
		id = Applications.getNeedid();
		qquser=Applications.getqquser();
		findView();
		setAdapter();
		getHy();
	}
	public void findView(){
		fenzu_lv=(ListView) this.findViewById(R.id.fenzu_lv);
		fenzu_lv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				if(qquser.getQqId().equals(hyqquser.getHyqqId())){//发送者是好友表的我
					hyqquser.setMyqqFengzu((long)position);
				}else{
					hyqquser.setHyqqFengzu((long)position);
				}
				handler.sendEmptyMessage(1);//刷新
			}
		});
		layout1_tv2_ok =(TextView) this.findViewById(R.id.layout1_tv2_ok);
		layout1_tv2_ok.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				savehy();
			}
		});
	}
	public void sendBroasts(){
		Intent intent = new Intent();
		intent.setAction("broadcast.lianxirenfragment");
		sendBroadcast(intent);
	}
	public void setAdapter(){
		list= new ArrayList<String>();
		list.add("我的好友");
		list.add("家人");
		list.add("同学");
		list.add("朋友");
		move= new MoveFenzuAdpdter(this);
		move.setDate(list);
		fenzu_lv.setAdapter(move);
	}
	public void notifys(){
		move.setDate(list);
		move.notifyDataSetChanged();
	}
	//获取这个好友对象
	public void getHy(){
		AsyncHttpClient client = new AsyncHttpClient();
		String uri =URI_IP.URI+"Android_Service/QQ/gethyuser";
		RequestParams params = new RequestParams();
		params.put("hyqqId", id+"");
		params.put("qqId", qquser.getQqId()+"");
		client.post(uri,params,new JsonHttpResponseHandler(){
			@Override
			public void onStart() {       
			}
			@Override
			public void onFailure(Throwable arg0, String arg1) {
				//登录失败-网络问题
				handler.sendEmptyMessage(2);
			}
			@Override
			public void onSuccess(int arg0, JSONObject arg1) {
				//如果Jsonobject获取的值不正确（jsonview）是不会继续下去的
				int result=arg1.optInt("result");
				if(result==1){
					Gson gson = new Gson();
					hyqquser= gson.fromJson(arg1.toString(), AndroidQqHy.class);
					handler.sendEmptyMessage(1);
				}else{
					handler.sendEmptyMessage(0);
				}
			}
			@Override
			public void onFinish() {
			}
		});
	}
	//保存这个对象
	public void savehy(){
		AsyncHttpClient client = new AsyncHttpClient();
		String uri =URI_IP.URI+"Android_Service/QQ/savehaoyou";
		RequestParams params = new RequestParams();
		params.put("hyId", hyqquser.getHyId()+"");//主键
		if(qquser.getQqId().equals(hyqquser.getHyqqId())){//发送者是好友表的我
			params.put("myqqfenzu", hyqquser.getMyqqFengzu()+"");
		}else{
			params.put("hyqqfenzu", hyqquser.getHyqqFengzu()+"");
		}
		client.post(uri,params,new JsonHttpResponseHandler(){
			@Override
			public void onStart() {       
			}
			@Override
			public void onFailure(Throwable arg0, String arg1) {
				//登录失败-网络问题
				handler.sendEmptyMessage(2);
			}
			@Override
			public void onSuccess(int arg0, JSONObject arg1) {
				//如果Jsonobject获取的值不正确（jsonview）是不会继续下去的
				int result=arg1.optInt("result");
				if(result==1){
					Gson gson = new Gson();
					hyqquser= gson.fromJson(arg1.toString(), AndroidQqHy.class);
					handler.sendEmptyMessage(3);
				}else{
					handler.sendEmptyMessage(4);
				}
			}
			@Override
			public void onFinish() {
			}
		});
	}
}

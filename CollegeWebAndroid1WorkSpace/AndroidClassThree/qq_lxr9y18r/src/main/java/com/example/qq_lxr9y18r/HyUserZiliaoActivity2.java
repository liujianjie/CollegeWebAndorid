package com.example.qq_lxr9y18r;

import java.util.List;

import org.json.JSONObject;

import com.example.qq_lxr9y18r.bean.AndroidQqHy;
import com.example.qq_lxr9y18r.bean.AndroidQqUser;
import com.example.qq_lxr9y18r.constant.URI_IP;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.squareup.picasso.Picasso;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.view.Window;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class HyUserZiliaoActivity2 extends FragmentActivity implements OnClickListener{
	//所有控件
	private ImageView layout2_tv_touxiang;
	private TextView layout2_tv2_name;
	private TextView layout2_tv3_zhanghao;
	private TextView layout2_tv4_sex;
	private TextView layout2_tv5_address;
	private TextView layout2_tv6_phone;
	private TextView layout2_tv7_mark;
	
	private AndroidQqUser selqquser;
	
	private TextView back;
	int id;
	public Handler handler = new Handler(){
		@Override
		public void handleMessage(Message msg) {
			int what = msg.what;
			switch (what) {
			case 0:
				break;
			case 1:
				//必须获取完了才能赋值
				setValues();
				break;
			case 2:
				Toast.makeText(HyUserZiliaoActivity2.this, "网络连接失败", 0).show();
				break;
			default:
				break;
			}
		}
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);//无标题
		setContentView(R.layout.activity_hyuserziliao2);
		findView();
		//获取id
		id = Applications.getNeedid();
		//获取值
		getUser();
	}
	public void findView(){
		back = (TextView) this.findViewById(R.id.back);
		layout2_tv_touxiang = (ImageView) this.findViewById(R.id.layout2_tv_touxiang);
		layout2_tv2_name = (TextView) this.findViewById(R.id.layout2_tv2_name);
		layout2_tv3_zhanghao = (TextView) this.findViewById(R.id.layout2_tv3_zhanghao);
		layout2_tv4_sex = (TextView) this.findViewById(R.id.layout2_tv4_sex);
		layout2_tv5_address = (TextView) this.findViewById(R.id.layout2_tv5_address);
		layout2_tv6_phone = (TextView) this.findViewById(R.id.layout2_tv6_phone);
		layout2_tv7_mark = (TextView) this.findViewById(R.id.layout2_tv7_mark);
		back.setOnClickListener(this);
	}
	public void setValues(){
		Picasso.with(this).load(URI_IP.URI+"Android_Service/image/"+selqquser.getQqTouxiang()+"").placeholder(R.drawable.touxiang).into(layout2_tv_touxiang);
		layout2_tv2_name.setText(selqquser.getQqName());
		layout2_tv3_zhanghao.setText(selqquser.getQqZhanghao());
		layout2_tv4_sex.setText(selqquser.getQqSex());
		layout2_tv5_address.setText(selqquser.getQqAddress());
		layout2_tv6_phone.setText(selqquser.getQqPhone());
		layout2_tv7_mark.setText(selqquser.getQqMark());
	}
	
	public void getUser(){
		AsyncHttpClient client = new AsyncHttpClient();
		String uri =URI_IP.URI+"Android_Service/QQ/selqquser";
		RequestParams params = new RequestParams();
		params.put("qqId", id+"");
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
					AndroidQqUser qqusers= gson.fromJson(arg1.toString(), AndroidQqUser.class);
					selqquser=qqusers;
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
	@Override
	public void onClick(View v) {
		finish();
	}
}


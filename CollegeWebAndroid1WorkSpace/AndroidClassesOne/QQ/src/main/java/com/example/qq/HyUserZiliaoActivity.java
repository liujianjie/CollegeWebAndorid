package com.example.qq;

import java.util.List;

import org.json.JSONObject;

import com.example.qq.bean.AndroidQqHy;
import com.example.qq.bean.AndroidQqUser;
import com.example.qq.constant.URI_IP;
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

public class HyUserZiliaoActivity extends FragmentActivity implements OnClickListener{
	
	private List<AndroidQqHy> hylist = Applications.getHyList();//所有的好友列表
	
	//所有控件
	private ImageView layout2_tv_touxiang;
	private TextView layout2_tv2_name;
	private TextView layout2_tv3_zhanghao;
	private TextView layout2_tv4_sex;
	private TextView layout2_tv5_address;
	private TextView layout2_tv6_phone;
	private TextView layout2_tv7_mark;
	
	//按钮
	private LinearLayout layout3;
	private Button layout3_btn1;
	private Button layout3_btn2;
	
	private AndroidQqUser selqquser;
	private AndroidQqUser qquser;
	
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
				//判断要不要显示layout3
				visibles();
				break;
			case 2:
				Toast.makeText(HyUserZiliaoActivity.this, "网络连接失败", 0).show();
				break;
			case 3://发起添加成功
				Toast.makeText(HyUserZiliaoActivity.this, "成功发起申请,等待对方审核", 0).show();
				//重新用一个list封装
				break;
			case 4://发起添加失败
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
		qquser = Applications.getqquser();
		setContentView(R.layout.activity_hyuserziliao);
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
		
		//layout3
		layout3 = (LinearLayout) this.findViewById(R.id.layout3);
		layout3_btn1 = (Button) this.findViewById(R.id.layout3_btn1);
		layout3_btn2 = (Button) this.findViewById(R.id.layout3_btn2);
		layout3_btn2.setOnClickListener(this);
		layout3_btn1.setOnClickListener(this);
	}
	public void visibles(){
		//查询好友列表
		if(selqquser.getQqId()==qquser.getQqId()){
			layout3.setVisibility(View.GONE);
		}
		//判断这个按钮显示的值，如果在好友列表存在，则不显示添加
		//三个值 myqq selqq hylist
		if(hylist!=null){
			for(int i=0;i<hylist.size();i++){
				AndroidQqHy qqhylist = hylist.get(i);
				if(qqhylist.getHyqqId().equals(selqquser.getQqId())&&qqhylist.getMyqqId().equals(qquser.getQqId())){
					layout3.setVisibility(View.GONE);
				}
				if(qqhylist.getMyqqId().equals(selqquser.getQqId())&&qqhylist.getHyqqId().equals(qquser.getQqId())){
					layout3.setVisibility(View.GONE);
				}
			}
		}
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
		int id = v.getId();
		if(id == R.id.layout3_btn2){//添加
			addRen(selqquser);
		}
		finish();
	}
	//添加好友 发起添加数据就行
	public void addRen(AndroidQqUser hyuser){
		AsyncHttpClient client = new AsyncHttpClient();
		String uri =URI_IP.URI+"Android_Service/QQ/becomeQqhy";
		RequestParams params = new RequestParams();
		//qqhy 信息
		params.put("qqhy.myqqId",qquser.getQqId()+"");
		params.put("qqhy.myqqZhanghao",qquser.getQqZhanghao());
		params.put("qqhy.myqqName",qquser.getQqName());
		params.put("qqhy.myqqTouxiang",qquser.getQqTouxiang());
		params.put("qqhy.myqqMark",qquser.getQqMark());
		params.put("qqhy.myqqStatu",qquser.getQqStatu()+"");//在线还是下线
		params.put("qqhy.myqqFengzu", 0+"");//默认好友
		params.put("qqhy.hyqqId",hyuser.getQqId()+"");
		params.put("qqhy.hyqqZhanghao",hyuser.getQqZhanghao());
		params.put("qqhy.hyqqName",hyuser.getQqName());
		params.put("qqhy.hyqqTouxiang",hyuser.getQqTouxiang());
		params.put("qqhy.hyqqMark",hyuser.getQqMark());
		params.put("qqhy.hyqqStatu",hyuser.getQqStatu()+"");
		params.put("qqhy.hyqqFengzu", 0+"");//默认分组在好友，等下移动
		params.put("qqhy.hyStatu",0+"");
		//并给所有的好友增加一个新值
//		AndroidQqHy qqhy = new AndroidQqHy();
//		qqhy.setMyqqId(qquser.getQqId());
////		qqhy.setMyqqZhanghao(qquser.getQqZhanghao());
////		qqhy.setMyqqName(qquser.getQqName());
////		qqhy.setMyqqTouxiang(qquser.getQqTouxiang());
//		qqhy.setHyqqId(hyuser.getQqId());
////		qqhy.setHyqqZhanghao(hyuser.getQqZhanghao());
////		qqhy.setHyqqName(hyuser.getQqName());
////		qqhy.setHyqqTouxiang(hyuser.getQqTouxiang());
////		qqhy.setHyqqMark(hyuser.getQqMark());
//		List<AndroidQqHy> lists= Applications.getAllhylist();
//		lists.add(qqhy);
//		Applications.setAllhylist(lists);
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


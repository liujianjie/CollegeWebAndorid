package com.example.qq;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONObject;

import com.example.qq.basadpter.ChartBasadpter;
import com.example.qq.bean.AndroidQqHy;
import com.example.qq.bean.AndroidQqMessage;
import com.example.qq.bean.AndroidQqMessageList;
import com.example.qq.bean.AndroidQqUser;
import com.example.qq.constant.URI_IP;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
//Date date = new Date(results.getMsg().get(0).getMDate());
//String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
//String strs = str;
public class ChartActivity extends FragmentActivity implements TextWatcher,OnClickListener{
	private ListView listview;//listview
	private TextView chart_tv1;//昵称
	private ImageView chart_iv;//tup
	private TextView chart_tv2_count;//back
	//聊天列表
	private List<AndroidQqMessage> chartlist;
	//消息列表
	private List<AndroidQqMessage> msglist;
	//发送消息和接收消息的对象
	AndroidQqMessage sendmsg;//我发送的是直接赋值的
	
	AndroidQqMessage qqmessage;//消息列表发送过来的
	
	int flag;//flag
	
	//adpter
	ChartBasadpter ap;
	//文本框
	private EditText edit;
	//发送
	private Button send;
	//好友与自己信息
	private AndroidQqHy qqhy;
	//好友的名字
	private String qqname;
	
	//停止在获取
	private boolean bln;
	
	//自己这个对象 在basadpter好辨认
	private AndroidQqUser qquser;
	private Handler handler = new Handler(){
		@Override
		public void handleMessage(Message msg) {
			int what = msg.what;
			switch (what) {
			case 0://发送消息失败
				break;
			case 1://发送成功添加到list
				chartlist.add(sendmsg);
				//刷新
				notifylist();
				//如果是第一条还要显示在消息列表中 和 我是发送者则显示 用广播和全局的msglist 用sendmsg和msglist比较
				//checkifExit(sendmsg);
				break;
			case 2://网络
				Toast.makeText(ChartActivity.this, "网络连接失败", 0).show();
				break;
			case 3:
				//显示在聊天列表
				notifylist();
				break;
			case 4:
				Toast.makeText(ChartActivity.this, "网络连接失败", 0).show();
				break;
			case 5://无消息
				handler.sendEmptyMessageDelayed(6, 12000);
				//new chartlist
				chartlist = new ArrayList<AndroidQqMessage>();
				break;
			case 6:
				getMsgOfdate();
				break;
			default:
				break;
			}
		}
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_chatmain);
		findView();
		//判断是哪里传过来的 消息列表还是好友列表?传过来的 好友表和消息表都有 id 头像 账号 昵称
		getIntents();
		setAdapter();
		bln=true;
		getMsgOfdate();//获取消息
	}
	@Override
	protected void onPause() {
		// TODO 自动生成的方法存根
		super.onPause();
		bln=false;
	}
	
	public void findView(){
		listview = (ListView)this.findViewById(R.id.chart_lv);
		//名称
		chart_tv1 = (TextView) this.findViewById(R.id.chart_tv1);
		edit = (EditText) this.findViewById(R.id.chart_bottom_ll_et);
		chart_iv = (ImageView) this.findViewById(R.id.chart_iv);
		chart_tv2_count = (TextView) this.findViewById(R.id.chart_tv2_count);
		
		chart_tv2_count.setOnClickListener(this);
		chart_iv.setOnClickListener(this);
		edit.addTextChangedListener(this);
		send = (Button) this.findViewById(R.id.chart_bottom_ll_btn);
	}
	public void setAdapter(){
		ap = new ChartBasadpter(ChartActivity.this);
		ap.setData(chartlist,qquser);
		listview.setAdapter(ap);
	}
	public void getIntents(){
		Intent intent = this.getIntent();
		qqname=intent.getStringExtra("qqname");
		chart_tv1.setText(qqname);
		//自己这个对象
		qquser=Applications.getqquser();
		flag=intent.getIntExtra("flag", -1);
		if(flag==1){//好友
			//好友对象
			qqhy=(AndroidQqHy)intent.getSerializableExtra("qqhy");
		}else if(flag==2){
			//消息对象
			qqmessage = (AndroidQqMessage) intent.getSerializableExtra("qqmessage");
		}
		
	}
	//检查是否存在了这条消息记录 没有创建 有不做什么
	/************************************************/
//	public void checkifExit(AndroidQqMessage sendmsg){
//		msglist = Applications.getMsgList();
//		boolean bln=false;
//		if(msglist!=null){
//			for(int i=0;i<msglist.size();i++){
//				AndroidQqMessage msg = msglist.get(i);
//				//判断在消息列表中 接受者是我 和发送者为好友的列表是否存在
//				//不存在添加，存在不添加
//				//这里是判断从是否有发送者发过来的消息
//				if(!(msg.getMJsid().equals(sendmsg.getQqId())&&msg.getQqId().equals(sendmsg.getMJsid()))){
//					bln=true;
//				//这里是获取手动添加的是否存在
//				}if(msg.getMJsid().equals(sendmsg.getMJsid())&&msg.getQqId().equals(sendmsg.getQqId())){
//					bln = false;
//				}
//			}
//		}else{
//			msglist=new ArrayList<AndroidQqMessage>();
//			bln=true;
//		}
//		//发送广播
//		if(bln){
//			msglist.add(sendmsg);
//			Applications.setMsgList(msglist);
//			Intent intent= new Intent();
//			intent.setAction("broadcast.xiaoxifragment");
//			sendBroadcast(intent);
//		}
//	}
	/************************************************/
	public void notifylist(){
		ap.setData(chartlist,qquser);
		ap.notifyDataSetChanged();
		//保持在底部
		listview.setSelection(chartlist.size());
		//一直获取信息
		if(bln){
			handler.sendEmptyMessageDelayed(6, 12000);
		}
			
	}
	//发送消息成流水线 两个线路
	public void sendMsg(View view){
		String str=edit.getText().toString();
		//发送消息并清空
		if(flag==1){
			sendMsgTodateOfHy(str);
		}else if(flag==2){
			sendMsgTodateOfMsg(str);
		}
		edit.setText("");
	}
	//发送消息
	public void sendMsgTodateOfHy(String str){
		sendmsg=new AndroidQqMessage(); 
		//日期
		Date date=new Date();//显示在列表 在数据库的是另一个在服务器中有
		AsyncHttpClient client = new AsyncHttpClient();
		String uri =URI_IP.URI+"Android_Service/QQ/sendMessage";
		RequestParams params = new RequestParams();
		if(qqname.equals(qqhy.getHyqqName())){//发送者是好友表的我
			params.put("msg.qqId", qqhy.getMyqqId()+"");
			params.put("msg.qqZhanghao", qqhy.getMyqqZhanghao());
			params.put("msg.qqName", qqhy.getMyqqName());
			params.put("msg.qqTouxiang", qqhy.getMyqqTouxiang());
			params.put("msg.MJsid", qqhy.getHyqqId()+"");
			params.put("msg.MZhanghao", qqhy.getHyqqZhanghao());
			params.put("msg.MName", qqhy.getHyqqName());
			params.put("msg.MTouxiang", qqhy.getHyqqTouxiang());
			sendmsg.setQqId(qqhy.getMyqqId());
			sendmsg.setQqZhanghao(qqhy.getMyqqZhanghao());
			sendmsg.setQqName(qqhy.getMyqqName());
			sendmsg.setQqTouxiang(qqhy.getMyqqTouxiang());
			sendmsg.setMJsid(qqhy.getHyqqId());
			sendmsg.setMZhanghao(qqhy.getHyqqZhanghao());
			sendmsg.setMName(qqhy.getHyqqName());
			sendmsg.setMTouxiang(qqhy.getHyqqTouxiang());
		}else{//发送者是好友表的好友
			params.put("msg.qqId", qqhy.getHyqqId()+"");
			params.put("msg.qqZhanghao", qqhy.getHyqqZhanghao());
			params.put("msg.qqName", qqhy.getHyqqName());
			params.put("msg.qqTouxiang", qqhy.getHyqqTouxiang());
			params.put("msg.MJsid", qqhy.getMyqqId()+"");
			params.put("msg.MZhanghao",  qqhy.getMyqqZhanghao());
			params.put("msg.MName", qqhy.getMyqqName());
			params.put("msg.MTouxiang", qqhy.getMyqqTouxiang());
			sendmsg.setQqId(qqhy.getHyqqId());
			sendmsg.setQqZhanghao(qqhy.getHyqqZhanghao());
			sendmsg.setQqName(qqhy.getHyqqName());
			sendmsg.setQqTouxiang(qqhy.getHyqqTouxiang());
			sendmsg.setMJsid(qqhy.getMyqqId());
			sendmsg.setMZhanghao(qqhy.getMyqqZhanghao());
			sendmsg.setMName(qqhy.getMyqqName());
			sendmsg.setMTouxiang(qqhy.getMyqqTouxiang());
		}
		params.put("msg.MMessage", str);
		params.put("msg.MStatu", 0+"");
		sendmsg.setMMessage(str);
		sendmsg.setMDate(date.getTime());
		sendmsg.setMStatu((long)0);
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
	//发送消息用 消息对象 设置发送人 和接受人
	public void sendMsgTodateOfMsg(String str){
		//这里判断 反正我是发送者 首先要发送时判断我是发送者还是接收者 （1） 是接受者者则变发送者，发送者 变为接收者
		//											(2)	  是发送者变为我还是发送者，接收者还是接受者
		sendmsg=new AndroidQqMessage(); 
		//日期
		Date date=new Date();//显示在列表 在数据库的是另一个在服务器中有
		AsyncHttpClient client = new AsyncHttpClient();
		String uri =URI_IP.URI+"Android_Service/QQ/sendMessage";
		RequestParams params = new RequestParams();
		//1.我变发送者 发送者变接收者
		if(qquser.getQqId().equals(qqmessage.getMJsid())){
			params.put("msg.qqId", qqmessage.getMJsid()+"");
			params.put("msg.qqZhanghao", qqmessage.getMZhanghao());
			params.put("msg.qqName", qqmessage.getMName());
			params.put("msg.qqTouxiang", qqmessage.getMTouxiang());
			params.put("msg.MJsid", qqmessage.getQqId()+"");
			params.put("msg.MZhanghao", qqmessage.getQqZhanghao());
			params.put("msg.MName", qqmessage.getQqName());
			params.put("msg.MTouxiang", qqmessage.getQqTouxiang());
			sendmsg.setQqId(qqmessage.getMJsid());
			sendmsg.setQqZhanghao(qqmessage.getMZhanghao());
			sendmsg.setQqName(qqmessage.getMName());
			sendmsg.setQqTouxiang(qqmessage.getMTouxiang());
			sendmsg.setMJsid(qqmessage.getQqId());
			sendmsg.setMZhanghao(qqmessage.getQqZhanghao());
			sendmsg.setMName(qqmessage.getQqName());
			sendmsg.setMTouxiang(qqmessage.getQqTouxiang());
		}else if(qquser.getQqId().equals(qqmessage.getQqId())){//如果我为发送者 我还是发送者
			params.put("msg.qqId", qqmessage.getQqId()+"");
			params.put("msg.qqZhanghao", qqmessage.getQqZhanghao());
			params.put("msg.qqName", qqmessage.getQqName());
			params.put("msg.qqTouxiang", qqmessage.getQqTouxiang());
			params.put("msg.MJsid", qqmessage.getMJsid()+"");
			params.put("msg.MZhanghao",  qqmessage.getMZhanghao());
			params.put("msg.MName", qqmessage.getMName());
			params.put("msg.MTouxiang", qqmessage.getMTouxiang());
			sendmsg.setQqId(qqmessage.getQqId());
			sendmsg.setQqZhanghao(qqmessage.getQqZhanghao());
			sendmsg.setQqName(qqmessage.getQqName());
			sendmsg.setQqTouxiang(qqmessage.getQqTouxiang());
			sendmsg.setMJsid(qqmessage.getMJsid());
			sendmsg.setMZhanghao(qqmessage.getMZhanghao());
			sendmsg.setMName(qqmessage.getMName());
			sendmsg.setMTouxiang(qqmessage.getMTouxiang());
		}
		params.put("msg.MMessage", str);
		params.put("msg.MStatu", 0+"");
		sendmsg.setMMessage(str);
		sendmsg.setMDate(date.getTime());
		sendmsg.setMStatu((long)0);
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
	
	//查询消息也分两种查 一个是好友 赋值 一个消息列表赋值
	public void getMsgOfdate(){
		AsyncHttpClient client = new AsyncHttpClient();
		String uri =URI_IP.URI+"Android_Service/QQ/receiveMessage";
		RequestParams params = new RequestParams();
		//好像获取消息不用什么判断，因为这条消息是固定 两个值而已(查询语句写的好)，只需在apdter里面判断是不是我发送的就行
		if(flag==2){
			params.put("qqId", qqmessage.getQqId()+"");
			params.put("hyId", qqmessage.getMJsid()+"");
		}else if(flag==1){
			params.put("qqId", qqhy.getHyqqId()+"");
			params.put("hyId", qqhy.getMyqqId()+"");
		}
		client.post(uri,params,new JsonHttpResponseHandler(){
			@Override
			public void onStart() {       
			}
			@Override
			public void onFailure(Throwable arg0, String arg1) {
				//登录失败-网络问题
				handler.sendEmptyMessage(4);
			}
			@Override
			public void onSuccess(int arg0, JSONObject arg1) {
				//如果Jsonobject获取的值不正确（jsonview）是不会继续下去的
				int result=arg1.optInt("result");
				if(result==1){
					Gson gson = new Gson();
					AndroidQqMessageList results= gson.fromJson(arg1.toString(), AndroidQqMessageList.class);
					
					chartlist=results.getMsg();
					handler.sendEmptyMessage(3);
				}else{
					handler.sendEmptyMessage(5);
				}
			}
			@Override
			public void onFinish() {
			}
		});
	}

	@Override
	public void beforeTextChanged(CharSequence s, int start, int count, int after) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {
		String str=edit.getText().toString();
		if(!str.equals("")){
			send.setEnabled(true);
		}else{
			send.setEnabled(false);
		}
	}

	@Override
	public void afterTextChanged(Editable s) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void onClick(View v) {
		int id = v.getId();
		if(id ==R.id.chart_tv2_count){
			finish();
		}else if(id == R.id.chart_iv){
			if(flag==1){//haoyou
				if(qquser.getQqId().equals(qqhy.getHyqqId())){//发送者是好友表的我
					Applications.setNeedid(Integer.parseInt(qqhy.getMyqqId()+""));
				}else{
					Applications.setNeedid(Integer.parseInt(qqhy.getHyqqId()+""));
				}
			}else if(flag==2){//xiaoxi
				if(qquser.getQqId().equals(qqmessage.getMJsid())){
					Applications.setNeedid(Integer.parseInt(qqmessage.getQqId()+""));
				}else{
					Applications.setNeedid(Integer.parseInt(qqmessage.getMJsid()+""));
				}
			}
			Intent intent = new Intent(ChartActivity.this,HyUserZiliaoActivity3.class);
			startActivity(intent);
			finish();
		}
	}
}

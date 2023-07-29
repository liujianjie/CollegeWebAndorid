package com.example.qq;

import java.util.List;

import org.json.JSONObject;

import com.example.qq.basadpter.DtBasicAdpdter;
import com.example.qq.bean.AndroidQqDynamic;
import com.example.qq.bean.AndroidQqDynamicList;
import com.example.qq.bean.AndroidQqHyList;
import com.example.qq.bean.AndroidQqUser;
import com.example.qq.constant.URI_IP;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class DongTaiActivity extends FragmentActivity{
	
	//上面
    private RelativeLayout space_rl;
	//添加和返回
	private ImageView space_rl1_iv1;
	private TextView space_rl1_tv1;
	
	private ListView listdtview;//动态
	private List<AndroidQqDynamic> hydtlist;//好友动态列表
	public static int PageCount=5;//动态一页多少个
	public static int CurrPage=1;//页数
	
	private AndroidQqUser qquser = Applications.getqquser();
	
	DtBasicAdpdter ap;
	
	boolean bln = true;
	boolean coutinue=true;//控制是否要继续获取下一页
	
	private Handler handler = new Handler(){
		@Override
		public void handleMessage(Message msg) {
			int what = msg.what;
			switch (what) {
			case 0:
				break;
			case 1:
				//如果为空还是去死吧
				NotifDontTai();
				break;
			case 2:
				Toast.makeText(DongTaiActivity.this, "网络失败", 0).show();
				break;
			case 3:
				break;
			default:
				break;
			}
		}
	};
	DynamicBroadCast dynamic;
	//是否添加列表
	private class DynamicBroadCast extends BroadcastReceiver{
		@Override
		public void onReceive(Context context, Intent intent) {
			getDongtai();
		}
	}
	//绑定广播

	//解绑
	@Override
	protected void onDestroy() {
		// TODO 自动生成的方法存根
		super.onDestroy();
		//main.unregisterReceiver(broadcast);
	}
	@Override
	protected void onCreate(Bundle arg0) {
		// TODO 自动生成的方法存根
		super.onCreate(arg0);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_space);
		findView();
		setlisteners();
		setDontTai();
		getDongtai();
		
		dynamic = new DynamicBroadCast();
		IntentFilter intentfilter = new IntentFilter("broadcast.dynamicfragment");
		this.registerReceiver(dynamic, intentfilter);
	}
	public void findView(){
		listdtview=(ListView)this.findViewById(R.id.space_lv);
		space_rl1_iv1 = (ImageView) this.findViewById(R.id.space_rl1_iv1);
		space_rl1_tv1 = (TextView) this.findViewById(R.id.space_rl1_tv1);
		space_rl = (RelativeLayout) this.findViewById(R.id.space_rl);
		
		//获取跳转
		space_rl1_iv1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(DongTaiActivity.this,AddDynamicActivity.class);
				startActivity(intent);
			}
		});
		//销毁
		space_rl1_tv1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
	}
	public void setDontTai(){
		//开始
		ap = new DtBasicAdpdter(this,this);
		ap.setData(hydtlist);
		listdtview.setAdapter(ap);
	}
	//setlistviewlistener
	public void setlisteners(){
		//滑动监听
		listdtview.setOnScrollListener(new OnScrollListener() {
			int headerHeight=0;
			@Override
			public void onScrollStateChanged(AbsListView view, int scrollState) {
				// TODO 自动生成的方法存根
			}
			@Override
			public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
				if(firstVisibleItem+visibleItemCount>= totalItemCount){
//					if(coutinue){
//						//再获取动态 第二页 一直会叠加 想办法停止 或者获取第一次再从新赋值
//						CurrPage+=1;
//						coutinue=false;
//						getDongtai();
//					}
				}else{
				}
				//背景
//	            int top = -(space_rl.getTop());  
//	            headerHeight = space_rl.getHeight()-50;  
//	            if (top > 0 && top <= headerHeight && firstVisibleItem==1) {  
//	                float scale = (float) top / headerHeight;  
//	                float alpha = (255 * scale);  
//	                space_rl.getBackground().setAlpha((int)alpha);  
//	            }else if(top == 0){  
//	            	space_rl.getBackground().setAlpha(0);  
//	            }else if(firstVisibleItem > 1){  
//	            	space_rl.getBackground().setAlpha(255);  
//	            }  
			}
		});
	}
	public void NotifDontTai(){
		ap.setData(hydtlist);
		ap.notifyDataSetChanged();
	}
	//获取动态 传入自己id 一次获取5个动态 再叠加
	public void getDongtai(){
		AsyncHttpClient client = new AsyncHttpClient();
		String uri =URI_IP.URI+"Android_Service/QQ/dynamic";
		RequestParams params = new RequestParams();
		params.put("qqId", qquser.getQqId()+"");
		params.put("CurrPage", CurrPage+"");
		params.put("PageCount", PageCount+"");
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
					AndroidQqDynamicList results = gson.fromJson(arg1.toString(), AndroidQqDynamicList.class);
//					if(CurrPage==1){
//						hydtlist=results.getQqdt();
//						handler.sendEmptyMessage(1);//获取页面
//					}else{
						//因为是分页 所以还是要叠加的好
//						List<AndroidQqDynamic> list = results.getQqdt();
//						if(list.size()!=0){
//							for(int i=0;i<list.size();i++){
//								AndroidQqDynamic dy= list.get(i);
//								hydtlist.add(dy);//叠加
//							}
							hydtlist=results.getQqdt();
							handler.sendEmptyMessage(1);//刷新页面
//						}else{//没有了动态了
//							handler.sendEmptyMessage(3);//
//						}
//					}
				}else{
					handler.sendEmptyMessage(0);
				}
			}
			@Override
			public void onFinish() {
			}
		});
	}
	
}

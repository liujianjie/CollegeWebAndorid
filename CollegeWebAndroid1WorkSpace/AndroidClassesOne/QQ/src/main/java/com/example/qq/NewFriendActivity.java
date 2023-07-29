package com.example.qq;

import java.util.List;

import org.json.JSONObject;

import com.example.qq.basadpter.NewFriendsBaseApdater;
import com.example.qq.bean.AndroidQqHy;
import com.example.qq.bean.AndroidQqHyList;
import com.example.qq.constant.URI_IP;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class NewFriendActivity extends FragmentActivity{
	
	private TextView newfriends_rl_tv3_add;//���
	
	private ListView newfriends_lv;//listview
	
	private TextView newfriends_rl_tv1_lxr;//��ϵ��
	
	private TextView newfriends_rl_tv2_xpy;
	
	NewFriendsBaseApdater newfriendsapdater;
	
	//�б�
	private List<AndroidQqHy> newhylist;
	
	NewFriendBroadcast broadcast;
	
	private Handler handler = new Handler(){
		@Override
		public void handleMessage(Message msg) {
			int what = msg.what;
			switch (what) {
			case 0:
				break;
			case 1:
				//ˢ��list �����͹㲥
				notifyadpter();
				sendBroasts();
				break;
			case 2:
				Toast.makeText(NewFriendActivity.this, "��������ʧ��", 0).show();
				break;
			default:
				break;
			}
		}
	};
	//ע��㲥notify
	private class NewFriendBroadcast extends BroadcastReceiver{
		@Override
		public void onReceive(Context context, Intent intent) {
			newhylist = Applications.getNewhylist();
			notifyadpter();
		}
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO �Զ����ɵķ������
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);//�ޱ���
		newhylist = Applications.getNewhylist();
		setContentView(R.layout.activity_newfriends);
		findView();
		setadpter();
		
		//�㲥
		broadcast = new NewFriendBroadcast();
		IntentFilter intentfilter = new IntentFilter("broadcast.newfriendbroadcast");
		this.registerReceiver(broadcast, intentfilter);
	}
	@Override
	protected void onDestroy() {
		// TODO �Զ����ɵķ������
		super.onDestroy();
		//unregisterReceiver(broadcast);
	}
	public void findView(){
		newfriends_rl_tv2_xpy = (TextView) this.findViewById(R.id.newfriends_rl_tv2_xpy);
		newfriends_lv = (ListView) this.findViewById(R.id.newfriends_lv);
		newfriends_rl_tv3_add=(TextView) this.findViewById(R.id.newfriends_rl_tv3_add);
		newfriends_rl_tv3_add.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(NewFriendActivity.this,AddHaoYouActivity.class);
				startActivity(intent);
			}
		});
		newfriends_rl_tv1_lxr = (TextView) this.findViewById(R.id.newfriends_rl_tv1_lxr);
		newfriends_rl_tv1_lxr.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				NewFriendActivity.this.finish();
			}
		});
	}
	public void setadpter(){
		newfriendsapdater = new NewFriendsBaseApdater(this);
		newfriendsapdater.setDate(this,newhylist);
		newfriends_lv.setAdapter(newfriendsapdater);
	}
	public void notifyadpter(){
		newfriendsapdater.setDate(this, newhylist);
		newfriendsapdater.notifyDataSetChanged();
	}
	public void sendBroasts(){
		Intent intent = new Intent();
		intent.setAction("broadcast.lianxirenfragment");
		sendBroadcast(intent);
	}
	public void agree(Long hyid,int position){
		//ȥ��
		newhylist.remove(position);
		AsyncHttpClient client = new AsyncHttpClient();
		String uri =URI_IP.URI+"Android_Service/QQ/UpdHaoYou";
		RequestParams params = new RequestParams();
		params.put("hyId", hyid+"");
		params.put("hystatu", 1+"");
		client.post(uri,params,new JsonHttpResponseHandler(){
			@Override
			public void onStart() {       
			}
			@Override
			public void onFailure(Throwable arg0, String arg1) {
				//��¼ʧ��-��������
				handler.sendEmptyMessage(2);
			}
			@Override
			public void onSuccess(int arg0, JSONObject arg1) {
				//���Jsonobject��ȡ��ֵ����ȷ��jsonview���ǲ��������ȥ��
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
}

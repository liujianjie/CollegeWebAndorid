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
				Toast.makeText(MoveFenZuActivity.this, "��������ʧ��", 0).show();
				break;
			case 3:
				//�㲥 �ر�
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
		// TODO �Զ����ɵķ������
		super.onCreate(arg0);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);//�ޱ���
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
				if(qquser.getQqId().equals(hyqquser.getHyqqId())){//�������Ǻ��ѱ����
					hyqquser.setMyqqFengzu((long)position);
				}else{
					hyqquser.setHyqqFengzu((long)position);
				}
				handler.sendEmptyMessage(1);//ˢ��
			}
		});
		layout1_tv2_ok =(TextView) this.findViewById(R.id.layout1_tv2_ok);
		layout1_tv2_ok.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO �Զ����ɵķ������
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
		list.add("�ҵĺ���");
		list.add("����");
		list.add("ͬѧ");
		list.add("����");
		move= new MoveFenzuAdpdter(this);
		move.setDate(list);
		fenzu_lv.setAdapter(move);
	}
	public void notifys(){
		move.setDate(list);
		move.notifyDataSetChanged();
	}
	//��ȡ������Ѷ���
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
				//��¼ʧ��-��������
				handler.sendEmptyMessage(2);
			}
			@Override
			public void onSuccess(int arg0, JSONObject arg1) {
				//���Jsonobject��ȡ��ֵ����ȷ��jsonview���ǲ��������ȥ��
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
	//�����������
	public void savehy(){
		AsyncHttpClient client = new AsyncHttpClient();
		String uri =URI_IP.URI+"Android_Service/QQ/savehaoyou";
		RequestParams params = new RequestParams();
		params.put("hyId", hyqquser.getHyId()+"");//����
		if(qquser.getQqId().equals(hyqquser.getHyqqId())){//�������Ǻ��ѱ����
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
				//��¼ʧ��-��������
				handler.sendEmptyMessage(2);
			}
			@Override
			public void onSuccess(int arg0, JSONObject arg1) {
				//���Jsonobject��ȡ��ֵ����ȷ��jsonview���ǲ��������ȥ��
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

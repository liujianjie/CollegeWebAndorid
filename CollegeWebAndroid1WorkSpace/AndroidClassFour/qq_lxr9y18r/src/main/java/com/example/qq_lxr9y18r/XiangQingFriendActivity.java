package com.example.qq_lxr9y18r;

import java.util.List;

import org.json.JSONObject;

import com.example.qq_lxr9y18r.basadpter.NewFriendsBaseApdater;
import com.example.qq_lxr9y18r.bean.AndroidQqHy;
import com.example.qq_lxr9y18r.bean.AndroidQqHyList;
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
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class XiangQingFriendActivity extends FragmentActivity implements OnClickListener{
	private Button newfriendsxq_ll_choose_no;
	private Button newfriendsxq_ll_choose_yes;
	
	private RelativeLayout newfriendsxq_rl_xq;
	private ImageView newfriendsxq_rl_user_touxiang;
	private TextView newfriendsxq_rl_user_name;//��
	private TextView newfriendsxq_rl_user_xq;//����
	//����
	private TextView newfriendsxq_rl_tv1_back;
	//�б�
	private List<AndroidQqHy> newhylist = Applications.getNewhylist();
	
	int position;
	private Handler handler = new Handler(){
		@Override
		public void handleMessage(Message msg) {
			int what = msg.what;
			switch (what) {
			case 0:
				break;
			case 1:
				//���͹㲥
				sendBroasts();
				break;
			case 2:
				Toast.makeText(XiangQingFriendActivity.this, "��������ʧ��", 0).show();
				break;
			default:
				break;
			}
		}
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO �Զ����ɵķ������
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);//�ޱ���
		setContentView(R.layout.activity_newfriendsxqs);
		findView();
		getPosition();
		setValue();
	}
	public void findView(){
		newfriendsxq_rl_user_touxiang = (ImageView) this.findViewById(R.id.newfriendsxq_rl_user_touxiang);
		newfriendsxq_rl_xq = (RelativeLayout) this.findViewById(R.id.newfriendsxq_rl_xq);
		newfriendsxq_rl_user_name=(TextView) this.findViewById(R.id.newfriendsxq_rl_user_name);
		newfriendsxq_rl_user_xq=(TextView) this.findViewById(R.id.newfriendsxq_rl_user_xq);
		newfriendsxq_ll_choose_no = (Button) this.findViewById(R.id.newfriendsxq_ll_choose_no);
		newfriendsxq_ll_choose_yes = (Button) this.findViewById(R.id.newfriendsxq_ll_choose_yes);
		newfriendsxq_rl_tv1_back = (TextView) this.findViewById(R.id.newfriendsxq_rl_tv1_back);
		
		newfriendsxq_rl_tv1_back.setOnClickListener(this);
		newfriendsxq_rl_xq.setOnClickListener(this);
		newfriendsxq_ll_choose_no.setOnClickListener(this);
		newfriendsxq_ll_choose_yes.setOnClickListener(this);
	}
	public void getPosition(){
		Intent intent = this.getIntent();
		position = intent.getIntExtra("flag", -1);
	}
	public void setValue(){
		AndroidQqHy qquser = newhylist.get(position);
		//��ʱ�������Ҿ�����ô��Ϊ��
		Picasso.with(this).load(URI_IP.URI+"Android_Service/image/"+qquser.getMyqqTouxiang()+"").into(newfriendsxq_rl_user_touxiang);
		newfriendsxq_rl_user_name.setText(qquser.getMyqqName());
		newfriendsxq_rl_user_xq.setText(qquser.getMyqqMark());
	}
	public void sendBroasts(){
		//�Ƴ�list
		newhylist.remove(position);
		Applications.setNewhylist(newhylist);
		Intent intent = new Intent();
		intent.setAction("broadcast.lianxirenfragment");
		sendBroadcast(intent);//����
		Intent intent2 = new Intent();
		intent2.setAction("broadcast.newfriendbroadcast");
		sendBroadcast(intent2);//�б�
		//����
		finish();
	}
	@Override
	public void onClick(View v) {
		int id = v.getId();
		if(id == R.id.newfriendsxq_rl_xq){
			//�Է�Ϊ��
			Long myqqids = newhylist.get(position).getMyqqId();
			Applications.setNeedid(Integer.parseInt(myqqids+""));
			Intent intent = new Intent(this,HyUserZiliaoActivity2.class);
			startActivity(intent);
		}if(id ==R.id.newfriendsxq_ll_choose_no){
			agree(2);
			
		}if(id ==R.id.newfriendsxq_ll_choose_yes){
			agree(1);
			//�Ƴ�list
		}if(id==R.id.newfriendsxq_rl_tv1_back){
			finish();
		}
	}
	public void agree(int id){
		Long hyid = newhylist.get(position).getHyId();
		AsyncHttpClient client = new AsyncHttpClient();
		String uri =URI_IP.URI+"Android_Service/QQ/UpdHaoYou";
		RequestParams params = new RequestParams();
		params.put("hyId", hyid+"");
		params.put("hystatu", id+"");
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

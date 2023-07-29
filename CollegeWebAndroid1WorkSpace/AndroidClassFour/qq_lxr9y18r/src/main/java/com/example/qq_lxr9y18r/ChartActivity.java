package com.example.qq_lxr9y18r;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONObject;

import com.example.qq_lxr9y18r.basadpter.ChartBasadpter;
import com.example.qq_lxr9y18r.bean.AndroidQqHy;
import com.example.qq_lxr9y18r.bean.AndroidQqMessage;
import com.example.qq_lxr9y18r.bean.AndroidQqMessageList;
import com.example.qq_lxr9y18r.bean.AndroidQqShowMessage;
import com.example.qq_lxr9y18r.bean.AndroidQqUser;
import com.example.qq_lxr9y18r.constant.URI_IP;
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
	private TextView chart_tv1;//�ǳ�
	private ImageView chart_iv;//tup
	private TextView chart_tv2_count;//back
	//�����б�
	private List<AndroidQqMessage> chartlist;
	//��Ϣ�б�
	private List<AndroidQqMessage> msglist;
	//������Ϣ�ͽ�����Ϣ�Ķ���
	AndroidQqMessage sendmsg;//�ҷ��͵���ֱ�Ӹ�ֵ��
	
	AndroidQqShowMessage qqshowmsg;//��Ϣ�б��͹�����
	
	int flag;//flag
	
	//adpter
	ChartBasadpter ap;
	//�ı���
	private EditText edit;
	//����
	private Button send;
	//�������Լ���Ϣ
	private AndroidQqHy qqhy;
	//���ѵ�����
	private String qqname;
	
	//ֹͣ�ڻ�ȡ
	private boolean bln;
	
	//�Լ�������� ��basadpter�ñ���
	private AndroidQqUser qquser;
	private Handler handler = new Handler(){
		@Override
		public void handleMessage(Message msg) {
			int what = msg.what;
			switch (what) {
			case 0://������Ϣʧ��
				break;
			case 1://���ͳɹ���ӵ�list
				chartlist.add(sendmsg);
				//ˢ��
				notifylist();
				// ���ͳɹ� ����Ҫ��ӵ���Ϣ�б��У������ڵ�ʱ��
				// 1.������Ϣ�б������
				// 2.��ӵ���Ϣ�б�
				// 3.ˢ����Ϣ�б�ѣ��ù㲥
				sendBroasts();
				break;
			case 2://����
				Toast.makeText(ChartActivity.this, "��������ʧ��", 0).show();
				break;
			case 3:
				//��ʾ�������б�
				notifylist();
				break;
			case 4:
				Toast.makeText(ChartActivity.this, "��������ʧ��", 0).show();
				break;
			case 5://����Ϣ
				handler.sendEmptyMessageDelayed(6, 6000);
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
	// ���͸���Ϣ�б�Ĺ㲥
	public void sendBroasts(){
		Intent intent = new Intent();
		intent.setAction("broadcast.xiaoxifragment");
		sendBroadcast(intent);
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_chatmain);
		findView();
		//�ж������ﴫ������ ��Ϣ�б��Ǻ����б�?�������� ���ѱ����Ϣ���� id ͷ�� �˺� �ǳ�
		getIntents();
		setAdapter();
		bln=true;
		getMsgOfdate();//��ȡ��Ϣ
	}
	@Override
	protected void onPause() {
		// TODO �Զ����ɵķ������
		super.onPause();
		bln=false;
	}
	
	public void findView(){
		listview = (ListView)this.findViewById(R.id.chart_lv);
		//����
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
		//�Լ��������
		qquser=Applications.getqquser();
		flag=intent.getIntExtra("flag", -1);
		if(flag==1){//����
			//���Ѷ���
			qqhy=(AndroidQqHy)intent.getSerializableExtra("qqhy");
		}else if(flag==2){
			//��Ϣ����
			qqshowmsg = (AndroidQqShowMessage) intent.getSerializableExtra("showmsg");
		}
		
	}
	//����Ƿ������������Ϣ��¼ û�д��� �в���ʲô
	/************************************************/
//	public void checkifExit(AndroidQqMessage sendmsg){
//		msglist = Applications.getMsgList();
//		boolean bln=false;
//		if(msglist!=null){
//			for(int i=0;i<msglist.size();i++){
//				AndroidQqMessage msg = msglist.get(i);
//				//�ж�����Ϣ�б��� ���������� �ͷ�����Ϊ���ѵ��б��Ƿ����
//				//��������ӣ����ڲ����
//				//�������жϴ��Ƿ��з����߷���������Ϣ
//				if(!(msg.getMJsid().equals(sendmsg.getQqId())&&msg.getQqId().equals(sendmsg.getMJsid()))){
//					bln=true;
//				//�����ǻ�ȡ�ֶ���ӵ��Ƿ����
//				}if(msg.getMJsid().equals(sendmsg.getMJsid())&&msg.getQqId().equals(sendmsg.getQqId())){
//					bln = false;
//				}
//			}
//		}else{
//			msglist=new ArrayList<AndroidQqMessage>();
//			bln=true;
//		}
//		//���͹㲥
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
		//�����ڵײ�
		listview.setSelection(chartlist.size());
		//һֱ��ȡ��Ϣ
		if(bln){
			handler.sendEmptyMessageDelayed(6, 6000);
		}
			
	}
	//������Ϣ����ˮ�� ������·
	public void sendMsg(View view){
		String str=edit.getText().toString();
		//������Ϣ�����
		if(flag==1){
			sendMsgTodateOfHy(str);
		}else if(flag==2){
			sendMsgTodateOfMsg(str);
		}
		edit.setText("");
	}
	//������Ϣ
	public void sendMsgTodateOfHy(String str){
		sendmsg=new AndroidQqMessage(); 
		//����
		Date date=new Date();//��ʾ���б� �����ݿ������һ���ڷ���������
		AsyncHttpClient client = new AsyncHttpClient();
		String uri =URI_IP.URI+"Android_Service/QQ/sendMessage";
		RequestParams params = new RequestParams();
		if(qqname.equals(qqhy.getHyqqName())){//�������Ǻ��ѱ����
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
		}else{//�������Ǻ��ѱ�ĺ���
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
	//������Ϣ�� ��Ϣ���� ���÷����� �ͽ�����
	public void sendMsgTodateOfMsg(String str){
		//�����ж� �������Ƿ����� ����Ҫ����ʱ�ж����Ƿ����߻��ǽ����� ��1�� �ǽ���������䷢���ߣ������� ��Ϊ������
		//											(2)	  �Ƿ����߱�Ϊ�һ��Ƿ����ߣ������߻��ǽ�����
		sendmsg=new AndroidQqMessage(); 
		//����
		Date date=new Date();//��ʾ���б� �����ݿ������һ���ڷ���������
		AsyncHttpClient client = new AsyncHttpClient();
		String uri =URI_IP.URI+"Android_Service/QQ/sendMessage";
		RequestParams params = new RequestParams();
		//1.��ǰ��¼��������Ϣ�б��е� �ҵ�id �����߾����ң��������Ǻ���
		if(qquser.getQqId().equals(qqshowmsg.getQqId())){
			params.put("msg.qqId", qqshowmsg.getQqId()+"");
			params.put("msg.qqZhanghao", qqshowmsg.getQqZhanghao());
			params.put("msg.qqName", qqshowmsg.getQqName());
			params.put("msg.qqTouxiang", qqshowmsg.getQqTouxiang());
			params.put("msg.MJsid", qqshowmsg.getHyId()+"");
			params.put("msg.MZhanghao", qqshowmsg.getHyZhanghao());
			params.put("msg.MName", qqshowmsg.getHyName());
			params.put("msg.MTouxiang", qqshowmsg.getHyTouxiang());
			sendmsg.setQqId(qqshowmsg.getQqId());
			sendmsg.setQqZhanghao(qqshowmsg.getQqZhanghao());
			sendmsg.setQqName(qqshowmsg.getQqName());
			sendmsg.setQqTouxiang(qqshowmsg.getQqTouxiang());
			sendmsg.setMJsid(qqshowmsg.getHyId());
			sendmsg.setMZhanghao(qqshowmsg.getHyZhanghao());
			sendmsg.setMName(qqshowmsg.getHyName());
			sendmsg.setMTouxiang(qqshowmsg.getHyTouxiang());
		}else if(qquser.getQqId().equals(qqshowmsg.getHyId())){// ��ǰ��½��������Ϣ�б��еĺ��ѣ���ô�������Ǻ���id
			params.put("msg.qqId", qqshowmsg.getHyId()+"");
			params.put("msg.qqZhanghao", qqshowmsg.getHyZhanghao());
			params.put("msg.qqName", qqshowmsg.getHyName());
			params.put("msg.qqTouxiang", qqshowmsg.getHyTouxiang());
			params.put("msg.MJsid", qqshowmsg.getQqId()+"");
			params.put("msg.MZhanghao",  qqshowmsg.getQqZhanghao());
			params.put("msg.MName", qqshowmsg.getQqName());
			params.put("msg.MTouxiang", qqshowmsg.getQqTouxiang());
			sendmsg.setQqId(qqshowmsg.getHyId());
			sendmsg.setQqZhanghao(qqshowmsg.getHyZhanghao());
			sendmsg.setQqName(qqshowmsg.getHyName());
			sendmsg.setQqTouxiang(qqshowmsg.getHyTouxiang());
			sendmsg.setMJsid(qqshowmsg.getQqId());
			sendmsg.setMZhanghao(qqshowmsg.getQqZhanghao());
			sendmsg.setMName(qqshowmsg.getQqName());
			sendmsg.setMTouxiang(qqshowmsg.getQqTouxiang());
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
	
	//��ѯ��ϢҲ�����ֲ� һ���Ǻ��� ��ֵ һ����Ϣ�б�ֵ
	public void getMsgOfdate(){
		AsyncHttpClient client = new AsyncHttpClient();
		String uri =URI_IP.URI+"Android_Service/QQ/receiveMessage";
		RequestParams params = new RequestParams();
		//�����ȡ��Ϣ����ʲô�жϣ���Ϊ������Ϣ�ǹ̶� ����ֵ����(��ѯ���д�ĺ�)��ֻ����apdter�����ж��ǲ����ҷ��͵ľ���
		if(flag==2){
			params.put("qqId", qqshowmsg.getQqId()+"");
			params.put("hyId", qqshowmsg.getHyId()+"");
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
				//��¼ʧ��-��������
				handler.sendEmptyMessage(4);
			}
			@Override
			public void onSuccess(int arg0, JSONObject arg1) {
				//���Jsonobject��ȡ��ֵ����ȷ��jsonview���ǲ��������ȥ��
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
		// TODO �Զ����ɵķ������
		
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
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public void onClick(View v) {
		int id = v.getId();
		if(id ==R.id.chart_tv2_count){
			finish();
		}else if(id == R.id.chart_iv){
			if(flag==1){//haoyou
				if(qquser.getQqId().equals(qqhy.getHyqqId())){//�������Ǻ��ѱ����
					Applications.setNeedid(Integer.parseInt(qqhy.getMyqqId()+""));
				}else{
					Applications.setNeedid(Integer.parseInt(qqhy.getHyqqId()+""));
				}
			}else if(flag==2){//xiaoxi
				if(qquser.getQqId().equals(qqshowmsg.getHyId())){
					Applications.setNeedid(Integer.parseInt(qqshowmsg.getQqId()+""));
				}else{
					Applications.setNeedid(Integer.parseInt(qqshowmsg.getHyId()+""));
				}
			}
			Intent intent = new Intent(ChartActivity.this,HyUserZiliaoActivity3.class);
			startActivity(intent);
			finish();
		}
	}
}

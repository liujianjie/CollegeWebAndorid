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
	
	//����
    private RelativeLayout space_rl;
	//��Ӻͷ���
	private ImageView space_rl1_iv1;
	private TextView space_rl1_tv1;
	
	private ListView listdtview;//��̬
	private List<AndroidQqDynamic> hydtlist;//���Ѷ�̬�б�
	public static int PageCount=5;//��̬һҳ���ٸ�
	public static int CurrPage=1;//ҳ��
	
	private AndroidQqUser qquser = Applications.getqquser();
	
	DtBasicAdpdter ap;
	
	boolean bln = true;
	boolean coutinue=true;//�����Ƿ�Ҫ������ȡ��һҳ
	
	private Handler handler = new Handler(){
		@Override
		public void handleMessage(Message msg) {
			int what = msg.what;
			switch (what) {
			case 0:
				break;
			case 1:
				//���Ϊ�ջ���ȥ����
				NotifDontTai();
				break;
			case 2:
				Toast.makeText(DongTaiActivity.this, "����ʧ��", 0).show();
				break;
			case 3:
				break;
			default:
				break;
			}
		}
	};
	DynamicBroadCast dynamic;
	//�Ƿ�����б�
	private class DynamicBroadCast extends BroadcastReceiver{
		@Override
		public void onReceive(Context context, Intent intent) {
			getDongtai();
		}
	}
	//�󶨹㲥

	//���
	@Override
	protected void onDestroy() {
		// TODO �Զ����ɵķ������
		super.onDestroy();
		//main.unregisterReceiver(broadcast);
	}
	@Override
	protected void onCreate(Bundle arg0) {
		// TODO �Զ����ɵķ������
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
		
		//��ȡ��ת
		space_rl1_iv1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(DongTaiActivity.this,AddDynamicActivity.class);
				startActivity(intent);
			}
		});
		//����
		space_rl1_tv1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
	}
	public void setDontTai(){
		//��ʼ
		ap = new DtBasicAdpdter(this,this);
		ap.setData(hydtlist);
		listdtview.setAdapter(ap);
	}
	//setlistviewlistener
	public void setlisteners(){
		//��������
		listdtview.setOnScrollListener(new OnScrollListener() {
			int headerHeight=0;
			@Override
			public void onScrollStateChanged(AbsListView view, int scrollState) {
				// TODO �Զ����ɵķ������
			}
			@Override
			public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
				if(firstVisibleItem+visibleItemCount>= totalItemCount){
//					if(coutinue){
//						//�ٻ�ȡ��̬ �ڶ�ҳ һֱ����� ��취ֹͣ ���߻�ȡ��һ���ٴ��¸�ֵ
//						CurrPage+=1;
//						coutinue=false;
//						getDongtai();
//					}
				}else{
				}
				//����
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
	//��ȡ��̬ �����Լ�id һ�λ�ȡ5����̬ �ٵ���
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
				//��¼ʧ��-��������
				handler.sendEmptyMessage(2);
			}
			@Override
			public void onSuccess(int arg0, JSONObject arg1) {
				//���Jsonobject��ȡ��ֵ����ȷ��jsonview���ǲ��������ȥ��
				int result=arg1.optInt("result");
				if(result==1){
					Gson gson = new Gson();
					AndroidQqDynamicList results = gson.fromJson(arg1.toString(), AndroidQqDynamicList.class);
//					if(CurrPage==1){
//						hydtlist=results.getQqdt();
//						handler.sendEmptyMessage(1);//��ȡҳ��
//					}else{
						//��Ϊ�Ƿ�ҳ ���Ի���Ҫ���ӵĺ�
//						List<AndroidQqDynamic> list = results.getQqdt();
//						if(list.size()!=0){
//							for(int i=0;i<list.size();i++){
//								AndroidQqDynamic dy= list.get(i);
//								hydtlist.add(dy);//����
//							}
							hydtlist=results.getQqdt();
							handler.sendEmptyMessage(1);//ˢ��ҳ��
//						}else{//û���˶�̬��
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

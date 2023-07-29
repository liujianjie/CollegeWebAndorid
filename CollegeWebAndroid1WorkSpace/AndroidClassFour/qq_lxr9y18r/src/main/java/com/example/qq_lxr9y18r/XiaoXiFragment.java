package com.example.qq_lxr9y18r;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import com.example.qq_lxr9y18r.basadpter.XiaoXiBasadpter;
import com.example.qq_lxr9y18r.bean.AndroidQqMessage;
import com.example.qq_lxr9y18r.bean.AndroidQqMessageList;
import com.example.qq_lxr9y18r.bean.AndroidQqShowMessage;
import com.example.qq_lxr9y18r.bean.AndroidQqShowMessageList;
import com.example.qq_lxr9y18r.bean.AndroidQqUser;
import com.example.qq_lxr9y18r.constant.URI_IP;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.squareup.picasso.Picasso;

import android.app.ActionBar.LayoutParams;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.PopupWindow.OnDismissListener;


//186hang һ��msglist�� �����ᱻ���� 
//��Ϣ
public class XiaoXiFragment extends Fragment implements OnClickListener{
	private MainActivity main;
	private TextView xx_tv_jia;//��ͼƬ
	
	private ListView xiaoxi_lv;//lv
	
	private List<AndroidQqShowMessage> showmsglist;
	
	private XiaoXiBasadpter adp;
	
	private XiaoXiBroadCast broadcast;
	
	private AndroidQqUser qquser;
	
	private ImageView xiaoxi_rl_iv;//ͷ��
	
	private boolean bln;
	
	private boolean isstillsel;//��Ҫ�ڻ�ȡ��
	
	private Handler handler = new Handler(){
		@Override
		public void handleMessage(Message msg) {
			int what = msg.what;
			switch (what) {
			case 0:
				Toast.makeText(main, "��������", Toast.LENGTH_SHORT).show();
				//����ϢҲѭ��  ѭ������ ������ù㲥
				//handler.sendEmptyMessageDelayed(3, 8000);
				//����Ϣ Ҳ���õ�application�� ����Ҫ�Ȼ�ȡ
				//Ҫ�Ȼ�ȡ /������ȡ��Ϣ�Ѿ�������ֵ��
				/************************/
				//Applications.setMsgList(msglist);
				break;
			case 1:
				//��ȡ ��Ӧ��list
				notifyAdpter();// ˢ���б�
				break;
			case 2://����
				if(bln){
					Toast.makeText(main, "��������", Toast.LENGTH_SHORT).show();
					bln=false;
				}
				break;
			case 3:// ������ȡ��Ϣ�б�
				getShowMsgList();
				break;
			case 4://��ȡ�б�
				notifyAdpter();
				break;
			default:
				break;
			}
		}
	};
	public XiaoXiFragment(MainActivity con){
		this.main=con;
	}
	// �㲥��������ˢ���б��
	private class XiaoXiBroadCast extends BroadcastReceiver{
		@Override
		public void onReceive(Context context, Intent intent) {
			// ���»�ȡ��Ϣ�б� ˢ�µ���˼
			getShowMsgList();
		}
	}
	//�󶨹㲥
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO �Զ����ɵķ������
		super.onCreate(savedInstanceState);
		broadcast = new XiaoXiBroadCast();
		IntentFilter intentfilter = new IntentFilter("broadcast.xiaoxifragment");
		main.registerReceiver(broadcast, intentfilter);
		bln=true;
	}
	//���
	@Override
	public void onDestroy() {
		// TODO �Զ����ɵķ������
		super.onDestroy();
		//main.unregisterReceiver(broadcast);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		View view = inflater.inflate(R.layout.activity_xiaoxifragment, null);
		qquser = Applications.getqquser();
		findView(view);
		setAdpter();
		getShowMsgList();
		isstillsel=true;
		
		return view;
	}
	// ��ͣ��ʱ��Ҫ
	@Override
	public void onPause() {
		// TODO �Զ����ɵķ������
		super.onPause();
		isstillsel=false;
		
	}
	public void findView(View view){
		xiaoxi_rl_iv = (ImageView) view.findViewById(R.id.xiaoxi_rl_iv);
		Picasso.with(main).load(URI_IP.URI+"Android_Service/image/"+qquser.getQqTouxiang()+"").into(xiaoxi_rl_iv);
		//�������Ͻ���
		xiaoxi_rl_iv.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(main,PersonZiliaoActivity.class);
				startActivity(intent);
			}
		});
		xx_tv_jia = (TextView) view.findViewById(R.id.xx_tv_jia);
		xx_tv_jia.setOnClickListener(this);
		xiaoxi_lv=(ListView) view.findViewById(R.id.xiaoxi_lv);
		//�������
		xiaoxi_lv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				AndroidQqShowMessage showmsg = showmsglist.get(position);
				//������idΪ qqmesage�е�qqid ������idΪqquser�����
				Intent intent = new Intent(main,ChartActivity.class);
				intent.putExtra("flag", 2);
				intent.putExtra("qqname", showmsg.getQqName());
				//���Լ�����Ҳ����ȥ
				intent.putExtra("qquser", qquser);
				//�Ѻ��Ѷ���Ҳ����ȥ
				intent.putExtra("showmsg", showmsg);
				
				startActivity(intent);
			}
		});
	}
	public void setAdpter(){
		adp = new XiaoXiBasadpter(main,main);
		adp.setData(showmsglist);
		xiaoxi_lv.setAdapter(adp);
	}
	public void notifyAdpter(){
		adp.setData(showmsglist);
		adp.notifyDataSetChanged();
		//����application�� Ϊ��ʹ��
		//Applications.setMsgList(msglist);
		//����ˢ�»�ȡ����Ϣ 6sһ��.ֻ�е�ҳ�������ʱ���Ҫһֱ��ȡ
		if(isstillsel){
			handler.sendEmptyMessageDelayed(3, 6000);
		}
	}
	//��ȡչʾ��Ϣ�б� ����id
	public void getShowMsgList(){
		AsyncHttpClient client = new AsyncHttpClient();
		String uri =URI_IP.URI+"Android_Service/QQ/selMessageList";
		RequestParams params = new RequestParams();
		params.put("qqId", main.qquser.getQqId()+"");
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
				int result=arg1.optInt("result");
				if(result==1){
					Gson gson = new Gson();
					AndroidQqShowMessageList results= gson.fromJson(arg1.toString(), AndroidQqShowMessageList.class);
					//���Է�����Ϣ������ ��ѷ�����Ϊ�ĸ��ǳɽ��������ҵ��ˣ�����Ҳ�ã�����Ϣ�ж��� �����������ǲ��ǽ����߶���Ӱ��
					showmsglist = results.getMsg();
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
		if(id == R.id.xx_tv_jia){
			//���ֵ���
			//���ֱ���ɫ
			WindowManager.LayoutParams ip = main.getWindow().getAttributes();
			ip.alpha = 0.7f;//alphaͨ�� ����͸����
			main.getWindow().setAttributes(ip);
			popupwindow();
		}
	}
	//���ֵ���
	public void popupwindow(){
		View view = LayoutInflater.from(main.getBaseContext()).inflate(R.layout.activity_xiaoxijia, null);
		PopupWindow pop = new PopupWindow(view,LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
		pop.setFocusable(true);
		pop.setBackgroundDrawable(new BitmapDrawable());//���õ�������ط�����ʧ
		//������ʧ�¼�
		pop.setOnDismissListener(new OnDismissListener() {
			@Override
			public void onDismiss() {
				//����Ļ�ָ�
				WindowManager.LayoutParams ip = main.getWindow().getAttributes();
				ip.alpha = 1f;//alphaͨ�� ����͸����
				main.getWindow().setAttributes(ip);
			}
		});
		pop.showAsDropDown(xx_tv_jia,0,30);
	}

	/*
	public void getShowMsgList(){
		AsyncHttpClient client = new AsyncHttpClient();
		String uri =URI_IP.URI+"Android_Service/QQ/selMessageList";
		RequestParams params = new RequestParams();
		params.put("qqId", main.qquser.getQqId()+"");
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
//					ArrayList<AndroidQqMessage> msgs = gson.fromJson(arg1.optString("msg"),
//							new TypeToken<List<AndroidQqMessage>>() {}.getType());
					AndroidQqMessageList results = gson.fromJson(arg1.toString(), AndroidQqMessageList.class);
					//���Է�����Ϣ������ ��ѷ�����Ϊ�ĸ��ǳɽ��������ҵ��ˣ�����Ҳ�ã�����Ϣ�ж��� �����������ǲ��ǽ����߶���Ӱ��
					msglist = results.getMsg();
//					List<AndroidQqMessage> msglists=results.getMsg();
//					for(int i=0;i<msglists.size();i++){
//						//�ж϶Է���û�з���Ϣ����
//						AndroidQqMessage mgs = msglists.get(i);
//						if(msglist!=null){
//							for(int j=0;j<msglist.size();j++){
//								AndroidQqMessage mg = msglist.get(i);
//								if(!(mg.getQqId().equals(mgs.getMJsid())&&mg.getMJsid().equals(mgs.getQqId()))){
//									msglist.add(mgs);
//								}
//							}
//						}else{
//							msglist = new ArrayList<AndroidQqMessage>();
//							msglist.add(mgs);
//						}
//					}
					handler.sendEmptyMessage(1);
				}else{
					handler.sendEmptyMessage(0);
				}
			}
			@Override
			public void onFinish() {
			}
		});
	}*/
}

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


//186hang 一个msglist从 反正会被覆盖 
//消息
public class XiaoXiFragment extends Fragment implements OnClickListener{
	private MainActivity main;
	private TextView xx_tv_jia;//加图片
	
	private ListView xiaoxi_lv;//lv
	
	private List<AndroidQqShowMessage> showmsglist;
	
	private XiaoXiBasadpter adp;
	
	private XiaoXiBroadCast broadcast;
	
	private AndroidQqUser qquser;
	
	private ImageView xiaoxi_rl_iv;//头像
	
	private boolean bln;
	
	private boolean isstillsel;//不要在获取了
	
	private Handler handler = new Handler(){
		@Override
		public void handleMessage(Message msg) {
			int what = msg.what;
			switch (what) {
			case 0:
				Toast.makeText(main, "请检查网络", Toast.LENGTH_SHORT).show();
				//无消息也循环  循环不好 最好是用广播
				//handler.sendEmptyMessageDelayed(3, 8000);
				//无消息 也设置到application中 但是要先获取
				//要先获取 /持续获取信息已经付好了值了
				/************************/
				//Applications.setMsgList(msglist);
				break;
			case 1:
				//获取 对应的list
				notifyAdpter();// 刷新列表
				break;
			case 2://网络
				if(bln){
					Toast.makeText(main, "请检查网络", Toast.LENGTH_SHORT).show();
					bln=false;
				}
				break;
			case 3:// 继续获取消息列表
				getShowMsgList();
				break;
			case 4://获取列表
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
	// 广播用来重新刷新列表的
	private class XiaoXiBroadCast extends BroadcastReceiver{
		@Override
		public void onReceive(Context context, Intent intent) {
			// 重新获取消息列表 刷新的意思
			getShowMsgList();
		}
	}
	//绑定广播
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		broadcast = new XiaoXiBroadCast();
		IntentFilter intentfilter = new IntentFilter("broadcast.xiaoxifragment");
		main.registerReceiver(broadcast, intentfilter);
		bln=true;
	}
	//解绑
	@Override
	public void onDestroy() {
		// TODO 自动生成的方法存根
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
	// 暂停的时候不要
	@Override
	public void onPause() {
		// TODO 自动生成的方法存根
		super.onPause();
		isstillsel=false;
		
	}
	public void findView(View view){
		xiaoxi_rl_iv = (ImageView) view.findViewById(R.id.xiaoxi_rl_iv);
		Picasso.with(main).load(URI_IP.URI+"Android_Service/image/"+qquser.getQqTouxiang()+"").into(xiaoxi_rl_iv);
		//个人资料界面
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
		//聊天界面
		xiaoxi_lv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				AndroidQqShowMessage showmsg = showmsglist.get(position);
				//发送者id为 qqmesage中的qqid 接受者id为qquser里面的
				Intent intent = new Intent(main,ChartActivity.class);
				intent.putExtra("flag", 2);
				intent.putExtra("qqname", showmsg.getQqName());
				//把自己对象也闯过去
				intent.putExtra("qquser", qquser);
				//把好友对象也闯过去
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
		//存在application中 为了使用
		//Applications.setMsgList(msglist);
		//持续刷新获取新信息 6s一次.只有当页面是这个时候就要一直获取
		if(isstillsel){
			handler.sendEmptyMessageDelayed(3, 6000);
		}
	}
	//获取展示消息列表 传入id
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
				//登录失败-网络问题
				handler.sendEmptyMessage(2);
			}
			@Override
			public void onSuccess(int arg0, JSONObject arg1) {
				int result=arg1.optInt("result");
				if(result==1){
					Gson gson = new Gson();
					AndroidQqShowMessageList results= gson.fromJson(arg1.toString(), AndroidQqShowMessageList.class);
					//当对方发消息过来后 会把发送者为的覆盖成接受者是我的了，这样也好，发消息判断了 所以无论我是不是接受者都不影响
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
			//出现弹框
			//出现背景色
			WindowManager.LayoutParams ip = main.getWindow().getAttributes();
			ip.alpha = 0.7f;//alpha通道 设置透明度
			main.getWindow().setAttributes(ip);
			popupwindow();
		}
	}
	//出现弹框
	public void popupwindow(){
		View view = LayoutInflater.from(main.getBaseContext()).inflate(R.layout.activity_xiaoxijia, null);
		PopupWindow pop = new PopupWindow(view,LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
		pop.setFocusable(true);
		pop.setBackgroundDrawable(new BitmapDrawable());//设置点击其它地方会消失
		//设置消失事件
		pop.setOnDismissListener(new OnDismissListener() {
			@Override
			public void onDismiss() {
				//让屏幕恢复
				WindowManager.LayoutParams ip = main.getWindow().getAttributes();
				ip.alpha = 1f;//alpha通道 设置透明度
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
				//登录失败-网络问题
				handler.sendEmptyMessage(2);
			}
			@Override
			public void onSuccess(int arg0, JSONObject arg1) {
				//如果Jsonobject获取的值不正确（jsonview）是不会继续下去的
				int result=arg1.optInt("result");
				if(result==1){
					Gson gson = new Gson();
//					ArrayList<AndroidQqMessage> msgs = gson.fromJson(arg1.optString("msg"),
//							new TypeToken<List<AndroidQqMessage>>() {}.getType());
					AndroidQqMessageList results = gson.fromJson(arg1.toString(), AndroidQqMessageList.class);
					//当对方发消息过来后 会把发送者为的覆盖成接受者是我的了，这样也好，发消息判断了 所以无论我是不是接受者都不影响
					msglist = results.getMsg();
//					List<AndroidQqMessage> msglists=results.getMsg();
//					for(int i=0;i<msglists.size();i++){
//						//判断对方有没有发消息过来
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

package com.example.qq_lxr9y18r;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import com.example.qq_lxr9y18r.basadpter.LxrExpandableListViewaAdapter;
import com.example.qq_lxr9y18r.bean.AndroidQqHy;
import com.example.qq_lxr9y18r.bean.AndroidQqHyList;
import com.example.qq_lxr9y18r.bean.AndroidQqUser;
import com.example.qq_lxr9y18r.constant.URI_IP;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.squareup.picasso.Picasso;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;

//联系人
public class LianXiRenFragment extends Fragment {
	private MainActivity main;
	
	LxrExpandableListViewaAdapter ap;
	private ExpandableListView listview;//好友
	private List<String>  groupArray;//组列表
	private List<List<AndroidQqHy>> childArray;//子列表
	//好友列表
	private List<AndroidQqHy> hylist;
	//新朋友申请列表
	private List<AndroidQqHy> newhylist;
	
	boolean bln = true;//是否获取好友 只有添加好友再去获取和一开获取
	
	private TextView lianxiren_rl_tv2;
	
	//top1
	private ImageView lianxiren_rl_ig;
	
	//top3
	private TextView lianxiren_ll2_tv1_count;
	private ImageView lianxiren_ll2_iv1_xpy;
	
	//广播
	private LianXiRenBroadCast broadcast;
	
	//自己
	private AndroidQqUser qquser;
	
	private Handler handler = new Handler(){
		@Override
		public void handleMessage(Message msg) {
			int what = msg.what;
			switch (what) {
			case 0://没有好友
				//保存在全局
				Applications.setHyList(hylist);
				bln = false;
				addInfo();
				notifyApder();
				break;
			case 1://成功
				//保存在全局
				Applications.setHyList(hylist);
				bln = false;
				addInfo();//给childlist附上值
				notifyApder();
				break;
			case 2://网络
				Toast.makeText(main, "网络连接失败", 0).show();
				break;
			case 3:
				//显示数量
				showCount();
				//保存在application
				Applications.setNewhylist(newhylist);
				break;
			case 4:
				//空
				showCount();
				Applications.setNewhylist(newhylist);
				break;
			default:
				break;
			}
		}
	};
	public LianXiRenFragment(MainActivity con){
		this.main=con;
	}
	//是否添加列表
	private class LianXiRenBroadCast extends BroadcastReceiver{
		@Override
		public void onReceive(Context context, Intent intent) {
			//重新获取
			bln=true;
			getHaoYou();
			//刷新好友count
			getNewHaoyou();
		}
	}
	//绑定广播
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		bln=true;
		broadcast = new LianXiRenBroadCast();
		IntentFilter intentfilter = new IntentFilter("broadcast.lianxirenfragment");
		main.registerReceiver(broadcast, intentfilter);
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
		View view = inflater.inflate(R.layout.activity_lianxirenfragment, null);
		qquser = Applications.getqquser();
		findView(view);
		setHaoYou();
		getHaoYou();
		getNewHaoyou();//每次打开这个页面再获取有没有申请好友吧
		return view;
	}
	public void findView(View view){
		//Top1 头像
		lianxiren_rl_ig =(ImageView) view.findViewById(R.id.lianxiren_rl_ig);
		Picasso.with(main).load(URI_IP.URI+"Android_Service/image/"+qquser.getQqTouxiang()+"").into(lianxiren_rl_ig);
		lianxiren_rl_ig.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(main,PersonZiliaoActivity.class);
				startActivity(intent);
			}
		});
		//Top3 	数量，新朋友 ， 群聊，公众号
		lianxiren_ll2_tv1_count=(TextView) view.findViewById(R.id.lianxiren_ll2_tv1_count);
		lianxiren_ll2_iv1_xpy=(ImageView) view.findViewById(R.id.lianxiren_ll2_iv1_xpy);
		//新朋友界面
		lianxiren_ll2_iv1_xpy.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(main,NewFriendActivity.class);
				startActivity(intent);
			}
		});
		//去添加好友界面
		lianxiren_rl_tv2 = (TextView) view.findViewById(R.id.lianxiren_rl_tv2_add);
		lianxiren_rl_tv2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(main,AddHaoYouActivity.class);
				startActivity(intent);
			}
		});
				
		//联系人listview
		listview=(ExpandableListView)view.findViewById(R.id.lianxiren_lv);
		//设置箭头样式
		listview.setGroupIndicator(this.getResources().getDrawable(R.drawable.expandablelistview_selector));
		//给item设置监听
		listview.setOnChildClickListener(new OnChildClickListener() {
			@Override
			public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
				AndroidQqHy user = childArray.get(groupPosition).get(childPosition);
				Intent intent = new Intent(main,ChartActivity.class);
				if(main.qquser.getQqId()==user.getMyqqId()){//我是我
					intent.putExtra("qqname", user.getHyqqName());
				}else{
					intent.putExtra("qqname", user.getMyqqName());
				}
				//这里是从好友列表到聊天界面的 
				intent.putExtra("flag", 1);
				//把这个好友信息 对象也传过去 传输的方法一样但是获取不一样
				intent.putExtra("qqhy", user);
				startActivity(intent);
				
				return false;
			}
		});
	}
	public void setHaoYou(){
		//开始 //这里要判断我是好友还是我是我
        ap = new LxrExpandableListViewaAdapter(main);
        ap.setDate(groupArray, childArray,main.qquser);
        listview.setAdapter(ap);
	}
	public void addInfo() {
    	groupArray =new ArrayList<String>();
        childArray = new ArrayList<List<AndroidQqHy>>();//重新复制
    	List<AndroidQqHy> hychild =new ArrayList<AndroidQqHy>();//好友item
    	List<AndroidQqHy> jrchild =new ArrayList<AndroidQqHy>();//家人item
    	List<AndroidQqHy> txchild =new ArrayList<AndroidQqHy>();//同学item
    	List<AndroidQqHy> pychild =new ArrayList<AndroidQqHy>();//朋友item
    	//好友数量
    	if(hylist!=null){
	    	for(int i=0;i<hylist.size();i++){
	    		//获取单个
	    		AndroidQqHy qqhy = hylist.get(i);
	    		//判断我是我还是我是好友
	    		if(main.qquser.getQqId().equals(qqhy.getMyqqId())){
	    			if(qqhy.getHyqqFengzu()==0){//对方的分组为是好友
	        			hychild.add(qqhy);
	        		}else if(qqhy.getHyqqFengzu()==1){//分组为家人
	        			jrchild.add(qqhy);
	        		}else if(qqhy.getHyqqFengzu()==2){//分组为同学
	        			txchild.add(qqhy);
	        		}else if(qqhy.getHyqqFengzu()==3){//分组为朋友
	        			pychild.add(qqhy);
	        		}
	    		}else if(main.qquser.getQqId().equals(qqhy.getHyqqId())){
	    			if(qqhy.getMyqqFengzu()==0){//对方的分组为是好友
	        			hychild.add(qqhy);
	        		}else if(qqhy.getMyqqFengzu()==1){//分组为家人
	        			jrchild.add(qqhy);
	        		}else if(qqhy.getHyqqFengzu()==2){//分组为同学
	        			txchild.add(qqhy);
	        		}else if(qqhy.getHyqqFengzu()==3){//分组为朋友
	        			pychild.add(qqhy);
	        		}
	    		}
	    	}
    	}
//		if(hychild.size()!=0){
			groupArray.add("我的好友");
			childArray.add(hychild);
//		}if(jrchild.size()!=0){
			groupArray.add("家人");
			childArray.add(jrchild);
//		}if(txchild.size()!=0){
			groupArray.add("同学");
			childArray.add(txchild);
//		}if(pychild.size()!=0){
			groupArray.add("朋友");
			childArray.add(pychild);
//		}
	}
	public void notifyApder(){
		ap.setDate(groupArray, childArray,main.qquser);
		ap.notifyDataSetChanged();
	}
	public void showCount(){
		if(newhylist!=null){
			if(newhylist.size()!=0){
				lianxiren_ll2_tv1_count.setText(newhylist.size()+"");
			}else{
				lianxiren_ll2_tv1_count.setText("");
			}
		}
	}
	//获取好友列表
	public void getHaoYou(){
		if(bln){
			AsyncHttpClient client = new AsyncHttpClient();
			String uri =URI_IP.URI+"Android_Service/QQ/selhaoyou";
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
						AndroidQqHyList results = gson.fromJson(arg1.toString(), AndroidQqHyList.class);
						hylist=results.getQqhy();//
						handler.sendEmptyMessage(1);
					}else{
						handler.sendEmptyMessage(0);
						hylist=null;
					}
				}
				@Override
				public void onFinish() {
				}
			});
		}
	}
	//获取新朋友。。。 点击这个面板就获取
	public void getNewHaoyou(){
		AsyncHttpClient client = new AsyncHttpClient();
		String uri =URI_IP.URI+"Android_Service/QQ/selhaoyouOfmy";
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
					AndroidQqHyList results = gson.fromJson(arg1.toString(), AndroidQqHyList.class);
					newhylist=results.getQqhy();//
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

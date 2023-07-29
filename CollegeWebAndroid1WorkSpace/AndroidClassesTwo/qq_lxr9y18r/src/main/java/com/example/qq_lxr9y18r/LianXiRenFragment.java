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

//��ϵ��
public class LianXiRenFragment extends Fragment {
	private MainActivity main;
	
	LxrExpandableListViewaAdapter ap;
	private ExpandableListView listview;//����
	private List<String>  groupArray;//���б�
	private List<List<AndroidQqHy>> childArray;//���б�
	//�����б�
	private List<AndroidQqHy> hylist;
	//�����������б�
	private List<AndroidQqHy> newhylist;
	
	boolean bln = true;//�Ƿ��ȡ���� ֻ����Ӻ�����ȥ��ȡ��һ����ȡ
	
	private TextView lianxiren_rl_tv2;
	
	//top1
	private ImageView lianxiren_rl_ig;
	
	//top3
	private TextView lianxiren_ll2_tv1_count;
	private ImageView lianxiren_ll2_iv1_xpy;
	
	//�㲥
	private LianXiRenBroadCast broadcast;
	
	//�Լ�
	private AndroidQqUser qquser;
	
	private Handler handler = new Handler(){
		@Override
		public void handleMessage(Message msg) {
			int what = msg.what;
			switch (what) {
			case 0://û�к���
				//������ȫ��
				Applications.setHyList(hylist);
				bln = false;
				addInfo();
				notifyApder();
				break;
			case 1://�ɹ�
				//������ȫ��
				Applications.setHyList(hylist);
				bln = false;
				addInfo();//��childlist����ֵ
				notifyApder();
				break;
			case 2://����
				Toast.makeText(main, "��������ʧ��", 0).show();
				break;
			case 3:
				//��ʾ����
				showCount();
				//������application
				Applications.setNewhylist(newhylist);
				break;
			case 4:
				//��
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
	//�Ƿ�����б�
	private class LianXiRenBroadCast extends BroadcastReceiver{
		@Override
		public void onReceive(Context context, Intent intent) {
			//���»�ȡ
			bln=true;
			getHaoYou();
			//ˢ�º���count
			getNewHaoyou();
		}
	}
	//�󶨹㲥
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO �Զ����ɵķ������
		super.onCreate(savedInstanceState);
		bln=true;
		broadcast = new LianXiRenBroadCast();
		IntentFilter intentfilter = new IntentFilter("broadcast.lianxirenfragment");
		main.registerReceiver(broadcast, intentfilter);
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
		View view = inflater.inflate(R.layout.activity_lianxirenfragment, null);
		qquser = Applications.getqquser();
		findView(view);
		setHaoYou();
		getHaoYou();
		getNewHaoyou();//ÿ�δ����ҳ���ٻ�ȡ��û��������Ѱ�
		return view;
	}
	public void findView(View view){
		//Top1 ͷ��
		lianxiren_rl_ig =(ImageView) view.findViewById(R.id.lianxiren_rl_ig);
		Picasso.with(main).load(URI_IP.URI+"Android_Service/image/"+qquser.getQqTouxiang()+"").into(lianxiren_rl_ig);
		lianxiren_rl_ig.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(main,PersonZiliaoActivity.class);
				startActivity(intent);
			}
		});
		//Top3 	������������ �� Ⱥ�ģ����ں�
		lianxiren_ll2_tv1_count=(TextView) view.findViewById(R.id.lianxiren_ll2_tv1_count);
		lianxiren_ll2_iv1_xpy=(ImageView) view.findViewById(R.id.lianxiren_ll2_iv1_xpy);
		//�����ѽ���
		lianxiren_ll2_iv1_xpy.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(main,NewFriendActivity.class);
				startActivity(intent);
			}
		});
		//ȥ��Ӻ��ѽ���
		lianxiren_rl_tv2 = (TextView) view.findViewById(R.id.lianxiren_rl_tv2_add);
		lianxiren_rl_tv2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(main,AddHaoYouActivity.class);
				startActivity(intent);
			}
		});
				
		//��ϵ��listview
		listview=(ExpandableListView)view.findViewById(R.id.lianxiren_lv);
		//���ü�ͷ��ʽ
		listview.setGroupIndicator(this.getResources().getDrawable(R.drawable.expandablelistview_selector));
		//��item���ü���
		listview.setOnChildClickListener(new OnChildClickListener() {
			@Override
			public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
				AndroidQqHy user = childArray.get(groupPosition).get(childPosition);
				Intent intent = new Intent(main,ChartActivity.class);
				if(main.qquser.getQqId()==user.getMyqqId()){//������
					intent.putExtra("qqname", user.getHyqqName());
				}else{
					intent.putExtra("qqname", user.getMyqqName());
				}
				//�����ǴӺ����б��������� 
				intent.putExtra("flag", 1);
				//�����������Ϣ ����Ҳ����ȥ ����ķ���һ�����ǻ�ȡ��һ��
				intent.putExtra("qqhy", user);
				startActivity(intent);
				
				return false;
			}
		});
	}
	public void setHaoYou(){
		//��ʼ //����Ҫ�ж����Ǻ��ѻ���������
        ap = new LxrExpandableListViewaAdapter(main);
        ap.setDate(groupArray, childArray,main.qquser);
        listview.setAdapter(ap);
	}
	public void addInfo() {
    	groupArray =new ArrayList<String>();
        childArray = new ArrayList<List<AndroidQqHy>>();//���¸���
    	List<AndroidQqHy> hychild =new ArrayList<AndroidQqHy>();//����item
    	List<AndroidQqHy> jrchild =new ArrayList<AndroidQqHy>();//����item
    	List<AndroidQqHy> txchild =new ArrayList<AndroidQqHy>();//ͬѧitem
    	List<AndroidQqHy> pychild =new ArrayList<AndroidQqHy>();//����item
    	//��������
    	if(hylist!=null){
	    	for(int i=0;i<hylist.size();i++){
	    		//��ȡ����
	    		AndroidQqHy qqhy = hylist.get(i);
	    		//�ж������һ������Ǻ���
	    		if(main.qquser.getQqId().equals(qqhy.getMyqqId())){
	    			if(qqhy.getHyqqFengzu()==0){//�Է��ķ���Ϊ�Ǻ���
	        			hychild.add(qqhy);
	        		}else if(qqhy.getHyqqFengzu()==1){//����Ϊ����
	        			jrchild.add(qqhy);
	        		}else if(qqhy.getHyqqFengzu()==2){//����Ϊͬѧ
	        			txchild.add(qqhy);
	        		}else if(qqhy.getHyqqFengzu()==3){//����Ϊ����
	        			pychild.add(qqhy);
	        		}
	    		}else if(main.qquser.getQqId().equals(qqhy.getHyqqId())){
	    			if(qqhy.getMyqqFengzu()==0){//�Է��ķ���Ϊ�Ǻ���
	        			hychild.add(qqhy);
	        		}else if(qqhy.getMyqqFengzu()==1){//����Ϊ����
	        			jrchild.add(qqhy);
	        		}else if(qqhy.getHyqqFengzu()==2){//����Ϊͬѧ
	        			txchild.add(qqhy);
	        		}else if(qqhy.getHyqqFengzu()==3){//����Ϊ����
	        			pychild.add(qqhy);
	        		}
	    		}
	    	}
    	}
//		if(hychild.size()!=0){
			groupArray.add("�ҵĺ���");
			childArray.add(hychild);
//		}if(jrchild.size()!=0){
			groupArray.add("����");
			childArray.add(jrchild);
//		}if(txchild.size()!=0){
			groupArray.add("ͬѧ");
			childArray.add(txchild);
//		}if(pychild.size()!=0){
			groupArray.add("����");
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
	//��ȡ�����б�
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
					//��¼ʧ��-��������
					handler.sendEmptyMessage(2);
				}
				@Override
				public void onSuccess(int arg0, JSONObject arg1) {
					//���Jsonobject��ȡ��ֵ����ȷ��jsonview���ǲ��������ȥ��
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
	//��ȡ�����ѡ����� ���������ͻ�ȡ
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
				//��¼ʧ��-��������
				handler.sendEmptyMessage(2);
			}
			@Override
			public void onSuccess(int arg0, JSONObject arg1) {
				//���Jsonobject��ȡ��ֵ����ȷ��jsonview���ǲ��������ȥ��
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

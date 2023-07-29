package com.example.qq_lxr9y18r.basadpter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONObject;

import com.example.qq_lxr9y18r.Applications;
import com.example.qq_lxr9y18r.MainActivity;
import com.example.qq_lxr9y18r.R;
import com.example.qq_lxr9y18r.bean.AndroidQqMessage;
import com.example.qq_lxr9y18r.bean.AndroidQqShowMessage;
import com.example.qq_lxr9y18r.bean.AndroidQqUser;
import com.example.qq_lxr9y18r.bean.LiaoTianBean;
import com.example.qq_lxr9y18r.constant.URI_IP;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.squareup.picasso.Picasso;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class XiaoXiBasadpter extends BaseAdapter{

	private static final String TAG = XiaoXiBasadpter.class.getSimpleName();
	
	private LayoutInflater layout;
	private List<AndroidQqShowMessage> showmsglist;//展示消息列表;
	private AndroidQqShowMessage showmsg;
	private AndroidQqUser qquser = Applications.getqquser();
	private MainActivity main;
	
	public XiaoXiBasadpter(Context con,MainActivity main) {
		layout = LayoutInflater.from(con);
		this.main=main;
	}
	public void setData(List<AndroidQqShowMessage> msg){
		this.showmsglist=msg;
	}
	
	@Override
	public int getCount() {
		if(showmsglist!=null){
			return showmsglist.size();
		}
		return 0;
	}

	@Override
	public Object getItem(int position) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO 自动生成的方法存根
		return 0;
	}

	String touxiang;
	String name;
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = null;
		AndroidQqShowMessage showmsg = showmsglist.get(position);
		ViewHolder viewholder=null;
		if(convertView == null){
			viewholder=new ViewHolder();
			view = layout.inflate((R.layout.activity_xiaoxiitem),null);
			viewholder.xiaoxiitem_ig=(ImageView) view.findViewById(R.id.xiaoxiitem_ig);
			viewholder.xiaoxiitem_tv_name=(TextView) view.findViewById(R.id.xiaoxiitem_tv_name);
			viewholder.xiaoxiitem_tv_content=(TextView) view.findViewById(R.id.xiaoxiitem_tv_content);
			viewholder.xiaoxiitem_tv_date=(TextView) view.findViewById(R.id.xiaoxiitem_tv_date);
			view.setTag(viewholder);
		}else{
			view = convertView;
			viewholder = (ViewHolder) view.getTag();
		}
		// 判断
		if(qquser.getQqId() == showmsg.getQqId()){
			name = showmsg.getQqName();
			touxiang = showmsg.getQqTouxiang();
		}else{
			name = showmsg.getHyName();
			touxiang = showmsg.getHyTouxiang();
		}
		viewholder.xiaoxiitem_tv_name.setText(name);
		Picasso.with(main).load(URI_IP.URI+"Android_Service/image/"+touxiang+"").into(viewholder.xiaoxiitem_ig);

		Date date = new Date(showmsg.getSmDate());
		String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
		Date date2 = new Date();
		String str2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date2);;
		if(str2.substring(5, 10).equals(str.substring(5,10))){
			str =str.substring(str.indexOf(" "),(str.length()-3));
		}else {
			str =str.substring(0,10);
		}
		viewholder.xiaoxiitem_tv_content.setText(showmsg.getSmContent()+"");
		viewholder.xiaoxiitem_tv_date.setText(str);
		return view;
	}
	class ViewHolder{
		public ImageView xiaoxiitem_ig;
		public TextView xiaoxiitem_tv_name;
		public TextView xiaoxiitem_tv_content;
		public TextView xiaoxiitem_tv_date;
	}
	
}

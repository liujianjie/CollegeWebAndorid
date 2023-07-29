package com.example.qq.basadpter;

import java.util.ArrayList;
import java.util.List;

import com.example.qq.R;
import com.example.qq.bean.AndroidQqMessage;
import com.example.qq.bean.AndroidQqUser;
import com.example.qq.bean.LiaoTianBean;
import com.example.qq.constant.URI_IP;
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

public class ChartBasadpter extends BaseAdapter{

	private static final String TAG = ChartBasadpter.class.getSimpleName();
	
	private LayoutInflater layout;
	private List<AndroidQqMessage> liaotian;
	private int screenwidth;//适应屏幕大小的宽度
	private AndroidQqUser qquser;
	private Context con;
	public ChartBasadpter(Context con) {
		this.con=con;
		layout = LayoutInflater.from(con);
		//先获取一个窗口
		DisplayMetrics outmetrics = new DisplayMetrics();
		((Activity)con).getWindowManager().getDefaultDisplay().getMetrics(outmetrics);
		screenwidth = (int)(outmetrics.widthPixels*0.64);
	}
	public void setData(List<AndroidQqMessage> msg,AndroidQqUser qquser){
		this.liaotian=msg;
		this.qquser=qquser;
	}
	
	@Override
	public int getCount() {
		if(liaotian!=null){
			return liaotian.size();
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

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = null;
		AndroidQqMessage lt = liaotian.get(position);
		LViewHolder vh=null;
		RViewHolder rh=null;
		if(convertView == null){
			//判断发送者是不是自己 
			if(qquser.getQqId().equals(lt.getMJsid())){//
				//这是新建的左边item
				view=createLeftItemfuzhi(vh, lt, view);
			}else{//是在右边
				//这是新建的右边item
				view=createRightItemfuzhi(rh, lt, view);
			}
		}else{
			Object obview = convertView.getTag();
			//先判断滑出去的是不是左边的view 再判断这条信息是不是左边的 如果是重用，不是创建
			if(obview instanceof LViewHolder){
				//好友消息是不是左边的 如果是左边的直接拿covertivew使用不过要设值
				if(qquser.getQqId().equals(lt.getMJsid())){//看实现
					//让它使用covertivew不用new
					view = convertView;
					//还需设值
					vh=(LViewHolder)view.getTag();
					vh=setLeftValue(vh, lt);
				}else{
					//如果不是左边而是右边则要相对的创建并负责
					view=createRightItemfuzhi(rh,lt,view);
				}
			}
			if(obview instanceof RViewHolder){
				//消息是不是右边的
				if(qquser.getQqId().equals(lt.getQqId())){
					//让它使用covertivew不用new
					view=convertView;
					//还需设值
					rh=(RViewHolder)view.getTag();
					rh=setRightValue(rh, lt);
				}else{
					//创建
					view=createLeftItemfuzhi(vh, lt, view);
				}
			}
		}
		return view;
	}
	
	//创建左边item并赋值 主要有 找到item和赋值 
	private View createLeftItemfuzhi(LViewHolder vh,AndroidQqMessage msg,View view){
		vh=new LViewHolder();
		view = layout.inflate(R.layout.activity_chatitem, null);
		vh.zig=(ImageView)view.findViewById(R.id.item_ivz);
		vh.ztx=(TextView)view.findViewById(R.id.item_ivz_text);
		Picasso.with(con).load(URI_IP.URI+"Android_Service/image/"+msg.getQqTouxiang()+"").into(vh.zig);
		vh.ztx.setText(msg.getMMessage());
		vh.ztx.setBackgroundResource(R.drawable.selector_liaotianz);
		vh.ztx.setMaxWidth(screenwidth);
		view.setTag(vh);
		return view;
	}
	//创建右边item并赋值 主要有 找到item和赋值
	private View createRightItemfuzhi(RViewHolder rh,AndroidQqMessage lt,View view){
		rh=new RViewHolder();
		view = layout.inflate(R.layout.activity_chatitem, null);
		rh.yig=(ImageView)view.findViewById(R.id.item_ivy);
		rh.ytx=(TextView)view.findViewById(R.id.item_ivy_text);
		Picasso.with(con).load(URI_IP.URI+"Android_Service/image/"+qquser.getQqTouxiang()+"").into(rh.yig);
//		Picasso.with(con).load(URI_IP.URI+"Android_Service/image/"+qquser.getQqTouxiang()+"").placeholder(R.drawable.touxiang).into(rh.yig);
		rh.ytx.setText(lt.getMMessage());
		rh.ytx.setBackgroundResource(R.drawable.selector_liaotiany);
		rh.ytx.setMaxWidth(screenwidth);
		view.setTag(rh);
		return view;
	}
	//不用创建view只需设值
	private LViewHolder setLeftValue(LViewHolder vh,AndroidQqMessage lt){
		Picasso.with(con).load(URI_IP.URI+"Android_Service/image/"+lt.getQqTouxiang()+"").into(vh.zig);
		vh.ztx.setText(lt.getMMessage());
		vh.ztx.setBackgroundResource(R.drawable.selector_liaotianz);
		vh.ztx.setMaxWidth(screenwidth);
		return vh;
	}
	private RViewHolder setRightValue(RViewHolder rh,AndroidQqMessage lt){
		Picasso.with(con).load(URI_IP.URI+"Android_Service/image/"+qquser.getQqTouxiang()+"").into(rh.yig);
		rh.ytx.setText(lt.getMMessage());
		rh.ytx.setBackgroundResource(R.drawable.selector_liaotiany);
		rh.ytx.setMaxWidth(screenwidth);
		return rh;
	}	
	class LViewHolder{
		public ImageView zig;
		public TextView ztx;
	}
	class RViewHolder{
		public ImageView yig;
		public TextView ytx;
	}
}

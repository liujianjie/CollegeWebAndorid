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
	private int screenwidth;//��Ӧ��Ļ��С�Ŀ��
	private AndroidQqUser qquser;
	private Context con;
	public ChartBasadpter(Context con) {
		this.con=con;
		layout = LayoutInflater.from(con);
		//�Ȼ�ȡһ������
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
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO �Զ����ɵķ������
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = null;
		AndroidQqMessage lt = liaotian.get(position);
		LViewHolder vh=null;
		RViewHolder rh=null;
		if(convertView == null){
			//�жϷ������ǲ����Լ� 
			if(qquser.getQqId().equals(lt.getMJsid())){//
				//�����½������item
				view=createLeftItemfuzhi(vh, lt, view);
			}else{//�����ұ�
				//�����½����ұ�item
				view=createRightItemfuzhi(rh, lt, view);
			}
		}else{
			Object obview = convertView.getTag();
			//���жϻ���ȥ���ǲ�����ߵ�view ���ж�������Ϣ�ǲ�����ߵ� ��������ã����Ǵ���
			if(obview instanceof LViewHolder){
				//������Ϣ�ǲ�����ߵ� �������ߵ�ֱ����covertivewʹ�ò���Ҫ��ֵ
				if(qquser.getQqId().equals(lt.getMJsid())){//��ʵ��
					//����ʹ��covertivew����new
					view = convertView;
					//������ֵ
					vh=(LViewHolder)view.getTag();
					vh=setLeftValue(vh, lt);
				}else{
					//���������߶����ұ���Ҫ��ԵĴ���������
					view=createRightItemfuzhi(rh,lt,view);
				}
			}
			if(obview instanceof RViewHolder){
				//��Ϣ�ǲ����ұߵ�
				if(qquser.getQqId().equals(lt.getQqId())){
					//����ʹ��covertivew����new
					view=convertView;
					//������ֵ
					rh=(RViewHolder)view.getTag();
					rh=setRightValue(rh, lt);
				}else{
					//����
					view=createLeftItemfuzhi(vh, lt, view);
				}
			}
		}
		return view;
	}
	
	//�������item����ֵ ��Ҫ�� �ҵ�item�͸�ֵ 
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
	//�����ұ�item����ֵ ��Ҫ�� �ҵ�item�͸�ֵ
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
	//���ô���viewֻ����ֵ
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

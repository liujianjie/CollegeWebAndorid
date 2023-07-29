package com.example.qq.basadpter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.example.qq.AddDynamicActivity;
import com.example.qq.DongTaiActivity;
import com.example.qq.MainActivity;
import com.example.qq.R;
import com.example.qq.StartActivity;
import com.example.qq.bean.AndroidQqDynamic;
import com.example.qq.constant.URI_IP;
import com.squareup.picasso.Picasso;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class DtBasicAdpdter extends BaseAdapter{

	private LayoutInflater layout;
	
	private List<AndroidQqDynamic> hydylist;
	
	private Context main;
	private DongTaiActivity dtay;
	
	public DtBasicAdpdter(Context con,DongTaiActivity dtay) {
		layout = LayoutInflater.from(con);
		main=con;
		this.dtay=dtay;
	}
	public void setData(List<AndroidQqDynamic> list){
		this.hydylist=list;
	}
	@Override
	public int getCount() {
		if(hydylist!=null){
			return hydylist.size();
		}else{
			return 0;
		}
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
		View view=null;
		ViewHolder viewholder =null;
		if(convertView == null){
			viewholder=new ViewHolder();
			view = layout.inflate(R.layout.activity_spaceitem, null);
			viewholder.spaceitem_tv2_name=(TextView) view.findViewById(R.id.spaceitem_tv2_name);
			viewholder.spaceitem_tv3_date=(TextView) view.findViewById(R.id.spaceitem_tv3_date);
			viewholder.spaceitem_tv4_content=(TextView) view.findViewById(R.id.spaceitem_tv4_content);
			viewholder.spaceitem_tv1_touxiang = (ImageView) view.findViewById(R.id.spaceitem_tv1_touxiang);
			view.setTag(viewholder);
		}else{
			view = convertView;
			viewholder=(ViewHolder) convertView.getTag();
		}
		AndroidQqDynamic dongtai = hydylist.get(position);
		String name =  dongtai.getQqName();
		String content =  dongtai.getDyContent();
		viewholder.spaceitem_tv2_name.setText(name);
		String strs = dongtai.getDyDate().substring(0, (dongtai.getDyDate().length()-3));
		viewholder.spaceitem_tv3_date.setText(strs);
		viewholder.spaceitem_tv4_content.setText(content);
		Picasso.with(main).load(URI_IP.URI+"Android_Service/image/"+dongtai.getQqTouxiang()+"").into(viewholder.spaceitem_tv1_touxiang);
		//图片
		GridView gv = (GridView) view.findViewById(R.id.spaceitem_gv);
		try{
			if(!dongtai.getDyPhotos().equals("")){
				String photos[] = dongtai.getDyPhotos().split(",");
				if(photos.length==1){//有值
					gv.setVisibility(view.VISIBLE);
					gv.setNumColumns(1);
					GridBasicAdpdter2 ap = new GridBasicAdpdter2(main);
					ap.setDate(photos);
					gv.setAdapter(ap);
					ap.notifyDataSetChanged();
				}else if(photos.length%3==0){
					gv.setVisibility(view.VISIBLE);
					gv.setNumColumns(3);
					GridBasicAdpdter2 ap = new GridBasicAdpdter2(main);
					ap.setDate(photos);
					gv.setAdapter(ap);
					ap.notifyDataSetChanged();
				}else if(photos.length%2==0){
					gv = (GridView) view.findViewById(R.id.spaceitem_gv);
					gv.setVisibility(view.VISIBLE);
					gv.setNumColumns(2);
					GridBasicAdpdter2 ap = new GridBasicAdpdter2(main);
					ap.setDate(photos);
					gv.setAdapter(ap);
					ap.notifyDataSetChanged();
				}else{
					gv.setVisibility(view.GONE);
				}
			}else{
				gv.setVisibility(view.GONE);
			}
		}catch(Exception e){
			gv.setVisibility(view.GONE);
		}
		//隐藏
		RelativeLayout rl = (RelativeLayout) view.findViewById(R.id.space_rl1);
		LinearLayout l1 = (LinearLayout) view.findViewById(R.id.space_ll1);
		if(position!=0){
			rl.setVisibility(View.GONE);
		}
		if(position==0){
			l1.getBackground().setAlpha(30);
			rl.setVisibility(View.VISIBLE);
		}
		
		return view;
	}
	class ViewHolder{
		ImageView spaceitem_tv1_touxiang;
		TextView spaceitem_tv2_name;
		TextView spaceitem_tv3_date;
		TextView spaceitem_tv4_content;
	}
}

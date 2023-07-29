package com.example.qq_lxr9y18r.basadpter;

import java.util.List;

import com.example.qq_lxr9y18r.Applications;
import com.example.qq_lxr9y18r.R;
import com.example.qq_lxr9y18r.bean.AndroidQqHy;
import com.example.qq_lxr9y18r.bean.AndroidQqUser;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MoveFenzuAdpdter extends BaseAdapter{

	private List<String> list;
	private LayoutInflater layout;
	
	//好友userlist
	private AndroidQqHy hyqquser;
	private AndroidQqUser qquser=Applications.getqquser();
	
	public MoveFenzuAdpdter(Context con){
		layout=LayoutInflater.from(con);
	}
	public void setDate(List<String> list){
		this.list=list;
		hyqquser=Applications.getHyqquser();
	}
	@Override
	public int getCount() {
		if(list!=null){
			return list.size();
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
		View view = null;
		view = layout.inflate(R.layout.activity_fenzuitem, null);
		TextView tv = (TextView) view.findViewById(R.id.fenzuitem_tv);
		tv.setText(list.get(position));
		if(hyqquser!=null){
			//判断了
			if(qquser.getQqId().equals(hyqquser.getHyqqId())){//发送者是好友表的我
				if(position==hyqquser.getMyqqFengzu()){
					ImageView fenzuitem_iv  = (ImageView)view.findViewById(R.id.fenzuitem_iv);
					fenzuitem_iv.setVisibility(view.VISIBLE);
				}
			}else{
				if(position==hyqquser.getHyqqFengzu()){
					ImageView fenzuitem_iv  = (ImageView)view.findViewById(R.id.fenzuitem_iv);
					fenzuitem_iv.setVisibility(view.VISIBLE);
				}
			}
		}
		return view;
	}

}

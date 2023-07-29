package com.example.qq_lxr9y18r.basadpter;

import java.util.List;

import com.example.qq_lxr9y18r.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class AddHaoYouAdpdter extends BaseAdapter{

	private List<String> list;
	private LayoutInflater layout;
	
	public AddHaoYouAdpdter(Context con){
		layout=LayoutInflater.from(con);
	}
	public void setDate(List<String> list){
		this.list=list;
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
		view = layout.inflate(R.layout.activity_addhaoyouitem, null);
		TextView tv = (TextView) view.findViewById(R.id.addhyitem_tv);
		tv.setText(list.get(position));
		return view;
	}

}

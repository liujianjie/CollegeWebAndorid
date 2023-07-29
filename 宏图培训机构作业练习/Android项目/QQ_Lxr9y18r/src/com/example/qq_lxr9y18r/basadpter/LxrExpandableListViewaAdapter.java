package com.example.qq_lxr9y18r.basadpter;

import java.util.List;

import com.example.qq_lxr9y18r.MainActivity;
import com.example.qq_lxr9y18r.R;
import com.example.qq_lxr9y18r.bean.AndroidQqHy;
import com.example.qq_lxr9y18r.bean.AndroidQqUser;
import com.example.qq_lxr9y18r.constant.URI_IP;
import com.squareup.picasso.Picasso;

import android.app.Activity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class LxrExpandableListViewaAdapter extends BaseExpandableListAdapter {
	private List<String>  groupArray;//组列表
	private List<List<AndroidQqHy>> childArray;//子列表
	private MainActivity main;
	
	private AndroidQqUser qquser;
	
	private LayoutInflater layout;
	
	public LxrExpandableListViewaAdapter(MainActivity main){
		this.main=main;
		layout = layout.from(main.getBaseContext());
	}
	public void setDate(List<String> groupArray,List<List<AndroidQqHy>> childArray,AndroidQqUser qquser){
		this.groupArray = groupArray;
		this.childArray = childArray;
		this.qquser=qquser;
	}
	/*-----------------Child */
	@Override
	public Object getChild(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return childArray.get(groupPosition).get(childPosition);
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return childPosition;
	}

	//view
	@Override
	public View getChildView(int groupPosition, int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {
		AndroidQqHy user = childArray.get(groupPosition).get(childPosition);
		View view =null;
		Viewholder viewholder=null;
		if(convertView==null){
			view = layout.inflate(R.layout.activity_lxrchilditem, null);
			viewholder=new Viewholder();
			viewholder.item_rl_iv=(ImageView)view.findViewById(R.id.item_rl_iv);
			viewholder.item_rl_tv1 = (TextView)view.findViewById(R.id.item_rl_tv1);
			viewholder.item_rl_tv2= (TextView)view.findViewById(R.id.item_rl_tv2);
			view.setTag(viewholder);
		}else{
			view=convertView;
			viewholder = (Viewholder) view.getTag();
		}
		//这里要判断我是好友还是我是我 还要
		if(user.getMyqqId()==qquser.getQqId()){//我是我 我不是好友
			viewholder.item_rl_iv.setImageResource(R.drawable.head_1);
			viewholder.item_rl_tv1.setText(user.getHyqqName());
			viewholder.item_rl_tv2.setText(user.getHyqqMark());
			Picasso.with(main).load(URI_IP.URI+"Android_Service/image/"+user.getHyqqTouxiang()+"").into(viewholder.item_rl_iv);
		}else{//我是好友
			viewholder.item_rl_iv.setImageResource(R.drawable.head_1);//backgroundR
			viewholder.item_rl_tv1.setText(user.getMyqqName());
			viewholder.item_rl_tv2.setText(user.getMyqqMark());
			Picasso.with(main).load(URI_IP.URI+"Android_Service/image/"+user.getMyqqTouxiang()+"").into(viewholder.item_rl_iv);
		}
		return view;
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		if(childArray!=null){
			return childArray.get(groupPosition).size();
		}else{
			return 0;
		}
	}
   /* ----------------------------Group */
	@Override
	public Object getGroup(int groupPosition) {
		// TODO Auto-generated method stub
		return getGroup(groupPosition);
	}

	@Override
	public int getGroupCount() {
		if(groupArray!=null){
			return groupArray.size();
		}else{
			return 0;
		}
	}

	@Override
	public long getGroupId(int groupPosition) {
		// TODO Auto-generated method stub
		return groupPosition;
	}
	//view
	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {
	   View view=layout.inflate(R.layout.activity_lxrgroupitem, null);
	   TextView tv = (TextView) view.findViewById(R.id.lxrgroupitem_tv);
       String string=groupArray.get(groupPosition);
       tv.setText(string);
       return view;
	}

	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) 
	{
		// TODO Auto-generated method stub
		return true;
	}
	
	//子类
	private class Viewholder{
		ImageView item_rl_iv;
		TextView item_rl_tv1;
		TextView item_rl_tv2;
	}
	
}

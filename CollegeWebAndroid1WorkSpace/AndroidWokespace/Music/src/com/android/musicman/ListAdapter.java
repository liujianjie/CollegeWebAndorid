package com.android.musicman;
 
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.List;

public class ListAdapter extends BaseAdapter{
	private LayoutInflater mInflater;
	private static List<MusicInfo> mlistData;
	private static SimpleDateFormat nowTimeFormat = null;
	
    public ListAdapter(Context context, List<MusicInfo> list){
    	mInflater = LayoutInflater.from(context);
    	mlistData = list;
    }
    
    public int getCount(){
    	return mlistData.size();
    }
    
    public Object getItem(int position){
    	return mlistData.get(position);
    }
    
    public long getItemId(int position){
    	return position;
    }
    
    public View getView(int position, View view, ViewGroup parent){
    	ViewHolder holder = null;
    	
    	//用缓存创建一个新的item
    	if(view == null){
    		view = mInflater.inflate(R.layout.music_list, null);
    		holder = new ViewHolder();
    
    		holder.img = (ImageView) view.findViewById(R.id.mp3);
    		holder.textItem = (TextView) view.findViewById(R.id.itemText);
    		holder.textItem1 = (TextView) view.findViewById(R.id.itemText1);
    		holder.textItem2 = (TextView) view.findViewById(R.id.itemText2);

        	view.setTag(holder);
        	
    	}else{
    		holder = (ViewHolder)view.getTag();
    	}
    	
		int nowTime = mlistData.get(position).getDuration();
    	nowTimeFormat = new SimpleDateFormat("mm:ss");
    	String ms1 = nowTimeFormat.format(nowTime); 
    	
    	//获得position位置的信息
    	holder.img.setImageResource(R.drawable.mp31);
    	holder.textItem.setText(mlistData.get(position).getMusicTitle());
    	holder.textItem1.setText(mlistData.get(position).getMusicSinger());
    	holder.textItem2.setText(ms1);
    	
//    	System.out.println(mlistData.get(i).getMusicTitle());
//    	System.out.println(mlistData.get(i).getMusicSinger());
        return view;
    }
    
    public final class ViewHolder{
    	public ImageView img;
    	public TextView textItem;
    	public TextView textItem1;
    	public TextView textItem2;
    }
    
}

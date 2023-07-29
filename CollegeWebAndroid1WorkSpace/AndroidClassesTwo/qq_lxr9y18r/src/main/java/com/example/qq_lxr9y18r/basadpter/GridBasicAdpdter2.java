package com.example.qq_lxr9y18r.basadpter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.qq_lxr9y18r.AddDynamicActivity;
import com.example.qq_lxr9y18r.MainActivity;
import com.example.qq_lxr9y18r.R;
import com.example.qq_lxr9y18r.constant.URI_IP;
import com.example.qq_lxr9y18r.dialog.AddDtDialog;
import com.squareup.picasso.Picasso;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GridBasicAdpdter2 extends BaseAdapter{
	private LayoutInflater layout;
	private Context con;
	private String photos[];
	public GridBasicAdpdter2(Context con){
		layout = LayoutInflater.from(con);
		this.con= con;
	}
	public void setDate(String photos[]){
		this.photos=photos;
	}
	@Override
	public int getCount() {
		if(photos.length>0){
			return photos.length;
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
		View view = layout.inflate(R.layout.activity_photosdongtaiitem, null);
		ImageView iv = (ImageView) view.findViewById(R.id.adddtitem_iv);
		Picasso.with(con).load(URI_IP.URI+"Android_Service/image/"+photos[position]).into(iv);
		return view;
	}

}

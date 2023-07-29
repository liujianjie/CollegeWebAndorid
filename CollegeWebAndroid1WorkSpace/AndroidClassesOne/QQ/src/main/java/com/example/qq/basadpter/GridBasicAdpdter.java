package com.example.qq.basadpter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.qq.AddDynamicActivity;
import com.example.qq.R;
import com.example.qq.dialog.AddDtDialog;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GridBasicAdpdter extends BaseAdapter{
	private LayoutInflater layout;
	private ArrayList<Bitmap>  list;
	private Map<String,Bitmap> bitmap;
	private Context con;
	private AddDynamicActivity dt;
	public GridBasicAdpdter(Context con){
		layout = LayoutInflater.from(con);
		this.con= con;
	}
	public void setData(AddDynamicActivity dt,Map<String,Bitmap> bitmap){
		this.bitmap = bitmap;
		this.dt = dt;
	}
	@Override
	public int getCount() {
		// TODO 自动生成的方法存根
		if(bitmap!=null){
			return bitmap.size();
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
		View view = layout.inflate(R.layout.activity_adddongtaiitem, null);
		ImageView iv = (ImageView) view.findViewById(R.id.adddtitem_iv);
		iv.setImageBitmap(bitmap.get(position+""));
		ImageView adddtitem_mriv = (ImageView) view.findViewById(R.id.adddtitem_mriv);//图片选择
		if(position==0){
			adddtitem_mriv.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					//出现弹框
					AddDtDialog dialogs = new AddDtDialog(dt,R.style.custom_dialog,dt);
					dialogs.show();
				}
			});
		}else{
			adddtitem_mriv.setVisibility(view.GONE);
		}
		return view;
	}

}

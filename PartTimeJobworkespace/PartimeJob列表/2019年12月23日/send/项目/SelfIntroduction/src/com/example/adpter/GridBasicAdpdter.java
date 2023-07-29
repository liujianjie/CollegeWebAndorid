package com.example.adpter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.qq_lxr9y18r.dialog.PhotoDialog;
import com.example.selfintroduction.PhotoActivity;
import com.example.selfintroduction.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class GridBasicAdpdter extends BaseAdapter {
	private LayoutInflater layout;
	private List<Bitmap> bitmap;
	private PhotoActivity photoactivity;

	public GridBasicAdpdter(PhotoActivity con) {
		layout = LayoutInflater.from(con);
		this.photoactivity = con;
	}

	public void setData(List<Bitmap> bitmap) {
		this.bitmap = bitmap;
	}

	@Override
	public int getCount() {
		// TODO �Զ����ɵķ������
		if (bitmap != null) {
			return bitmap.size();
		} else {
			return 0;
		}
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
	public View getView(final int position, View convertView, ViewGroup parent) {
		View view = layout.inflate(R.layout.photo_item, null);
		// ����ͼƬ
		ImageView iv = (ImageView) view.findViewById(R.id.photoitem_img);
		iv.setImageBitmap(bitmap.get(position));
		// ���һ�Ŵ�ССһ��
		return view;
	}

}

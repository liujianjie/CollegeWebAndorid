package com.example.dialog;

import com.example.selfintroduction.PhotoActivity;
import com.example.selfintroduction.PhotoDetailActivity;
import com.example.selfintroduction.R;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PhotoDelDialog extends Dialog {
	private Button tv1;
	private Button tv2;
	private Button tv0;
	Context co;
	PhotoActivity photo;
	int position;

	public PhotoDelDialog(Context context, int view,int position) {
		super(context, view);
		setContentView(R.layout.photodel_dialog);
		co = context;
		photo = (PhotoActivity)co;
		findView();
		this.position = position;
	}

	public void findView() {
		tv0 = (Button)this.findViewById(R.id.delphoto_tv0);
		tv1 = (Button) this.findViewById(R.id.delphoto_tv1);
		tv2 = (Button) this.findViewById(R.id.delphoto_tv2);

		tv0.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// 放大
				Intent in = new Intent(photo, PhotoDetailActivity.class);
				in.putExtra("img",position);
				photo.startActivity(in);
				PhotoDelDialog.this.dismiss();
			}
		});

		tv1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
			    if(position > 2){
                    photo.removePhoto(position);
                    PhotoDelDialog.this.dismiss();
                }else{
                    Toast.makeText(photo,"不能删除默认图片",Toast.LENGTH_SHORT).show();
                }
			}
		});
		tv2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				PhotoDelDialog.this.dismiss();
			}
		});
	}
}

package com.example.qq_lxr9y18r.dialog;

import com.example.selfintroduction.PhotoActivity;
import com.example.selfintroduction.R;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;

public class PhotoDelDialog extends Dialog {
	private Button tv1;
	private Button tv2;
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
		tv1 = (Button) this.findViewById(R.id.delphoto_tv1);
		tv2 = (Button) this.findViewById(R.id.delphoto_tv2);
		tv1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				photo.removePhoto(position);
				PhotoDelDialog.this.dismiss();
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

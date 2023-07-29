package com.example.qq_lxr9y18r.dialog;

import com.example.selfintroduction.PhotoActivity;
import com.example.selfintroduction.R;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;

public class PhotoDialog extends Dialog{
	private Button tv1;
	private Button tv2;
	Context co;
	PhotoActivity photo;
	
	public PhotoDialog(Context context,int view) {
		super(context,view);
		setContentView(R.layout.photoadd_dialog);
		co = context;
		findView();
		photo = (PhotoActivity)context;
	}
	public void findView(){
		tv1 = (Button) this.findViewById(R.id.chooseimage_tv1);
		tv2 = (Button) this.findViewById(R.id.chooseimage_tv2);
		tv1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				photo.camera();
				PhotoDialog.this.dismiss();
			}
		});
		tv2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				photo.photos();
				PhotoDialog.this.dismiss();
			}
		});
	}
}

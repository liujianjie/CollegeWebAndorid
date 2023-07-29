package com.example.qq.dialog;

import com.example.qq.AddDynamicActivity;
import com.example.qq.R;
import com.example.qq.ZhuCeActivity;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;

public class AddDtDialog extends Dialog{
	private Button tv1;
	private Button tv2;
	Context co;
	AddDynamicActivity dt;
	public AddDtDialog(Context context,AddDynamicActivity dt) {
		super(context);
		setContentView(R.layout.zhuce_dialog);
		co=context;
		findView();
		this.dt = dt;
	}
	public AddDtDialog(Context context,int view,AddDynamicActivity dt) {
		super(context,view);
		setContentView(R.layout.zhuce_dialog);
		co=context;
		findView();
		this.dt = dt;
	}
	public void findView(){
		tv1 = (Button) this.findViewById(R.id.chooseimage_tv1);
		tv2 = (Button) this.findViewById(R.id.chooseimage_tv2);
		tv1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				dt.camera();
				AddDtDialog.this.dismiss();
			}
		});
		tv2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				dt.photos();
				AddDtDialog.this.dismiss();
			}
		});
	}
}

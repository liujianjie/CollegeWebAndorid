package com.example.qq_lxr9y18r.dialog;

import com.example.qq_lxr9y18r.R;
import com.example.qq_lxr9y18r.ZhuCeActivity;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;

public class ZhuceDialog extends Dialog{
	private Button tv1;
	private Button tv2;
	Context co;
	ZhuCeActivity zhuce;
	public ZhuceDialog(Context context,ZhuCeActivity zhuces) {
		super(context);
		setContentView(R.layout.zhuce_dialog);
		co=context;
		findView();
		zhuce = zhuces;
	}
	public ZhuceDialog(Context context,int view,ZhuCeActivity zhuces) {
		super(context,view);
		setContentView(R.layout.zhuce_dialog);
		co=context;
		findView();
		zhuce = zhuces;
	}
	public void findView(){
		tv1 = (Button) this.findViewById(R.id.chooseimage_tv1);
		tv2 = (Button) this.findViewById(R.id.chooseimage_tv2);
		tv1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				zhuce.camera();
				ZhuceDialog.this.dismiss();
			}
		});
		tv2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				zhuce.photos();
				ZhuceDialog.this.dismiss();
			}
		});
	}
}

package com.example.qq_lxr9y18r.dialog;

import com.example.qq_lxr9y18r.AddDynamicActivity;
import com.example.qq_lxr9y18r.R;
import com.example.qq_lxr9y18r.ZhuCeActivity;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;

public class AddDtOfDelDialog extends Dialog{
	private Button tv1;
	private Button tv2;
	Context co;
	AddDynamicActivity dt;
	int position;
	public AddDtOfDelDialog(Context context,AddDynamicActivity dt,int position) {
		super(context);
		setContentView(R.layout.delphoto_dialog);
		co=context;
		findView();
		this.dt = dt;
		this.position=position;
	}
	public AddDtOfDelDialog(Context context,int view,AddDynamicActivity dt,int position) {
		super(context,view);
		setContentView(R.layout.delphoto_dialog);
		co=context;
		findView();
		this.dt = dt;
		this.position=position;
	}
	public void findView(){
		tv1 = (Button) this.findViewById(R.id.delphoto_tv1);
		tv2 = (Button) this.findViewById(R.id.delphoto_tv2);
		tv1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				dt.remove(position);
				AddDtOfDelDialog.this.dismiss();
			}
		});
		tv2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				AddDtOfDelDialog.this.dismiss();
			}
		});
	}
}

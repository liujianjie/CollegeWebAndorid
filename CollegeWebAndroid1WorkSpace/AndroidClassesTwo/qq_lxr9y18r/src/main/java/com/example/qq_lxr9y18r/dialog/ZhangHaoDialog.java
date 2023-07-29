package com.example.qq_lxr9y18r.dialog;

import com.example.qq_lxr9y18r.R;
import com.example.qq_lxr9y18r.ZhuCeActivity;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ZhangHaoDialog extends Dialog{
	private TextView tv1;
	Context co;
	String zhanghao;
	public ZhangHaoDialog(Context context,String zhanghao) {
		super(context);
		setContentView(R.layout.zhanghao_dialog);
		co=context;
		this.zhanghao = zhanghao; 
		findView();
	}
	public ZhangHaoDialog(Context context,int view,String zhanghao) {
		super(context,view);
		setContentView(R.layout.zhanghao_dialog);
		this.zhanghao = zhanghao; 
		co=context;
		findView();
	}
	public void findView(){
		tv1 = (TextView) this.findViewById(R.id.zhanghao);
		tv1.setText("你的账号为:"+zhanghao+"请妥善保管！");
	}
}

package com.example.testdialogcus;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.AlteredCharSequence;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class Mydialog extends Dialog implements View.OnClickListener{
	Button cusConfirm, cusCancel;
	private TextView tvResult, tvMsg;
	private String msg;
	public Mydialog(Context context, View view, String msg) {
		super(context);
		// TODO Auto-generated constructor stub
		tvResult = (TextView)view;
		this.msg = msg;
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.dialog_cus);
		tvMsg = (TextView)findViewById(R.id.cus_tvmsg);
		cusConfirm = (Button)findViewById(R.id.cus_confirm);
		cusCancel = (Button)findViewById(R.id.cus_cancel);
		cusConfirm.setOnClickListener(this);
		cusCancel.setOnClickListener(this);
		
		tvMsg.setText(msg);
	}
	@Override
	public void onClick(View arg0) {
		switch (arg0.getId()) {
		case R.id.cus_confirm:
			tvResult.setText("这是自定义对话框的操作");
			dismiss();
			break;
		case R.id.cus_cancel:
			dismiss();
			break;
		default:
			break;
		}
		
	}
}

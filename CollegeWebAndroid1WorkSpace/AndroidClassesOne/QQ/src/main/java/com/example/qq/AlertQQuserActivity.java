package com.example.qq;

import com.example.qq.bean.AndroidQqUser;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class AlertQQuserActivity extends Activity implements OnClickListener{
	
	private TextView alertuser_rl_top_name;//名字
	private EditText alertuser_rl2_ed;//控件
	private TextView alertuser_rl_top_ok;//保存
	private RelativeLayout alertuser_rl_top_back;//返回
	
	private AndroidQqUser qquser = Applications.getqquser();
	
	String choose;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);//无标题
		setContentView(R.layout.activity_alertqquser);
		findView();
		getIntents();
	}
	public void findView(){
		alertuser_rl_top_name = (TextView) this.findViewById(R.id.alertuser_rl_top_name);
		alertuser_rl2_ed = (EditText) this.findViewById(R.id.alertuser_rl2_ed);
		alertuser_rl_top_ok = (TextView) this.findViewById(R.id.alertuser_rl_top_ok);
		alertuser_rl_top_ok.setOnClickListener(this);
		alertuser_rl_top_back = (RelativeLayout) this.findViewById(R.id.alertuser_rl_top_back);
		alertuser_rl_top_back.setOnClickListener(this);
	}
	public void getIntents(){
		Intent intent = this.getIntent();
		choose = intent.getStringExtra("flag");
		if(choose.equals("name")){
			alertuser_rl_top_name.setText("修改昵称");
			alertuser_rl2_ed.setText(qquser.getQqName());
		}else if(choose.equals("zhanghao")){
			
		}else if(choose.equals("sex")){
			alertuser_rl_top_name.setText("修改性别");
			alertuser_rl2_ed.setText(qquser.getQqSex());
		}else if(choose.equals("address")){
			alertuser_rl_top_name.setText("修改地址");
			alertuser_rl2_ed.setText(qquser.getQqAddress());
		}else if(choose.equals("phone")){
			alertuser_rl_top_name.setText("修改电话");
			alertuser_rl2_ed.setText(qquser.getQqPhone());
		}else if(choose.equals("mark")){
			alertuser_rl_top_name.setText("修改个性签名");
			alertuser_rl2_ed.setText(qquser.getQqMark());
		}else if(choose.equals("touxiang")){
			
		}
	}
	@Override
	public void onClick(View v) {
		int id = v.getId();
		if(id==R.id.alertuser_rl_top_ok){
			Intent intent  = new Intent(AlertQQuserActivity.this,PersonZiliaoActivity.class);
			String text = alertuser_rl2_ed.getText().toString();
			intent.putExtra("flags", text);
			if(choose.equals("name")){
				qquser.setQqName(text);
				setResult(2, intent);
				finish();
			}else if(choose.equals("zhanghao")){
				
			}else if(choose.equals("sex")){
				qquser.setQqSex(text);
				setResult(4, intent);
				finish();
			}else if(choose.equals("address")){
				qquser.setQqAddress(text);
				setResult(5, intent);
				finish();
			}else if(choose.equals("phone")){
				qquser.setQqPhone(text);
				setResult(6, intent);
				finish();
			}else if(choose.equals("mark")){
				qquser.setQqMark(text);
				setResult(7, intent);
				finish();
			}else if(choose.equals("touxiang")){
				//1 setResult(1);
			}
		}else if(id==R.id.alertuser_rl_top_back){
			finish();
		}
		
	}
}

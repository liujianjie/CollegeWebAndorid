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
	
	private TextView alertuser_rl_top_name;//����
	private EditText alertuser_rl2_ed;//�ؼ�
	private TextView alertuser_rl_top_ok;//����
	private RelativeLayout alertuser_rl_top_back;//����
	
	private AndroidQqUser qquser = Applications.getqquser();
	
	String choose;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO �Զ����ɵķ������
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);//�ޱ���
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
			alertuser_rl_top_name.setText("�޸��ǳ�");
			alertuser_rl2_ed.setText(qquser.getQqName());
		}else if(choose.equals("zhanghao")){
			
		}else if(choose.equals("sex")){
			alertuser_rl_top_name.setText("�޸��Ա�");
			alertuser_rl2_ed.setText(qquser.getQqSex());
		}else if(choose.equals("address")){
			alertuser_rl_top_name.setText("�޸ĵ�ַ");
			alertuser_rl2_ed.setText(qquser.getQqAddress());
		}else if(choose.equals("phone")){
			alertuser_rl_top_name.setText("�޸ĵ绰");
			alertuser_rl2_ed.setText(qquser.getQqPhone());
		}else if(choose.equals("mark")){
			alertuser_rl_top_name.setText("�޸ĸ���ǩ��");
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

package com.example.qq;

import org.apache.http.protocol.RequestUserAgent;
import org.json.JSONObject;

import com.example.qq.bean.AndroidQqHyList;
import com.example.qq.bean.AndroidQqUser;
import com.example.qq.constant.URI_IP;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.squareup.picasso.Picasso;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Window;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class PersonZiliaoActivity extends Activity implements OnClickListener{
	
	//所有控件
	private ImageView layout2_tv_touxiang;
	private TextView layout2_tv2_name;
	private TextView layout2_tv3_zhanghao;
	private TextView layout2_tv4_sex;
	private TextView layout2_tv5_address;
	private TextView layout2_tv6_phone;
	private TextView layout2_tv7_mark;
	//行
	private RelativeLayout layout2_rl1;
	private RelativeLayout layout2_rl2;
	private RelativeLayout layout2_rl3;
	private RelativeLayout layout2_rl4;
	private RelativeLayout layout2_rl5;
	private RelativeLayout layout2_rl6;
	private RelativeLayout layout2_rl7;
	
	private TextView back;
	
	private AndroidQqUser qquser;
	
	public Handler handler = new Handler(){
		@Override
		public void handleMessage(Message msg) {
			int what = msg.what;
			switch (what) {
			case 0:
				break;
			case 1:
				break;
			case 2:
				Toast.makeText(PersonZiliaoActivity.this, "网络连接失败", 0).show();
				break;
			default:
				break;
			}
		}
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);//无标题
		setContentView(R.layout.activity_personziliao);
		qquser = Applications.getqquser();
		findView();
		setValues();
	}
	public void findView(){
		back = (TextView) this.findViewById(R.id.back);
		layout2_tv_touxiang = (ImageView) this.findViewById(R.id.layout2_tv_touxiang);
		layout2_tv2_name = (TextView) this.findViewById(R.id.layout2_tv2_name);
		layout2_tv3_zhanghao = (TextView) this.findViewById(R.id.layout2_tv3_zhanghao);
		layout2_tv4_sex = (TextView) this.findViewById(R.id.layout2_tv4_sex);
		layout2_tv5_address = (TextView) this.findViewById(R.id.layout2_tv5_address);
		layout2_tv6_phone = (TextView) this.findViewById(R.id.layout2_tv6_phone);
		layout2_tv7_mark = (TextView) this.findViewById(R.id.layout2_tv7_mark);
		layout2_rl1 = (RelativeLayout) this.findViewById(R.id.layout2_rl);
		layout2_rl2 = (RelativeLayout) this.findViewById(R.id.layout2_rl2);
		layout2_rl3 = (RelativeLayout) this.findViewById(R.id.layout2_rl3);
		layout2_rl4 = (RelativeLayout) this.findViewById(R.id.layout2_rl4);
		layout2_rl5 = (RelativeLayout) this.findViewById(R.id.layout2_rl5);
		layout2_rl6 = (RelativeLayout) this.findViewById(R.id.layout2_rl6);
		layout2_rl7 = (RelativeLayout) this.findViewById(R.id.layout2_rl7);
		layout2_rl1.setOnClickListener(this);
		layout2_rl2.setOnClickListener(this);
		layout2_rl3.setOnClickListener(this);
		layout2_rl4.setOnClickListener(this);
		layout2_rl5.setOnClickListener(this);
		layout2_rl6.setOnClickListener(this);
		layout2_rl7.setOnClickListener(this);
	}
	public void setValues(){
		Picasso.with(this).load(URI_IP.URI+"Android_Service/image/"+qquser.getQqTouxiang()+"").placeholder(R.drawable.touxiang).into(layout2_tv_touxiang);
		layout2_tv2_name.setText(qquser.getQqName());
		layout2_tv3_zhanghao.setText(qquser.getQqZhanghao());
		layout2_tv4_sex.setText(qquser.getQqSex());
		layout2_tv5_address.setText(qquser.getQqAddress());
		layout2_tv6_phone.setText(qquser.getQqPhone());
		layout2_tv7_mark.setText(qquser.getQqMark());
	}
	@Override
	public void onClick(View v) {
		int id = v.getId();
		if(id == R.id.layout2_rl){
			
		}else if(id == R.id.layout2_rl2){
			Intent intent = new Intent(this,AlertQQuserActivity.class);
			intent.putExtra("flag", "name");
			startActivityForResult(intent, 2);
		}else if(id == R.id.layout2_rl3){//账号
			
		}else if(id == R.id.layout2_rl4){
			Intent intent = new Intent(this,AlertQQuserActivity.class);
			intent.putExtra("flag", "sex");
			startActivityForResult(intent, 4);
		}else if(id == R.id.layout2_rl5){
			Intent intent = new Intent(this,AlertQQuserActivity.class);
			intent.putExtra("flag", "address");
			startActivityForResult(intent, 5);
		}else if(id == R.id.layout2_rl6){
			Intent intent = new Intent(this,AlertQQuserActivity.class);
			intent.putExtra("flag", "phone");
			startActivityForResult(intent, 6);
		}else if(id == R.id.layout2_rl7){
			Intent intent = new Intent(this,AlertQQuserActivity.class);
			intent.putExtra("flag", "mark");
			startActivityForResult(intent, 7);
		}else if(id == R.id.back){
			finish();
		}
		
	}
	//返回值
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		String str="";
		try{
			str = data.getStringExtra("flags");
		}catch(Exception e){
			
		}
		if(str.equals("")||str!=null){
			if(requestCode==2&&resultCode==2){
				layout2_tv2_name.setText(str);
			}else if(requestCode==4&&resultCode==4){
				layout2_tv4_sex.setText(str);
			}else if(requestCode==5&&resultCode==5){
				layout2_tv5_address.setText(str);
			}else if(requestCode==6&&resultCode==6){
				layout2_tv6_phone.setText(str);
			}else if(requestCode==7&&resultCode==7){
				layout2_tv7_mark.setText(str);
			}
		}
	}
	public void alertQQuer(){
		qquser=Applications.getqquser();
		AsyncHttpClient client = new AsyncHttpClient();
		String uri =URI_IP.URI+"Android_Service/QQ/alertqquser";
		RequestParams params = new RequestParams();
		params.put("qquser.qqId", qquser.getQqId()+"");
		params.put("qquser.qqTouxiang", qquser.getQqTouxiang());
		params.put("qquser.qqPhone", qquser.getQqPhone());
		params.put("qquser.qqName", qquser.getQqName());
		params.put("qquser.qqMima", qquser.getQqMima());
		params.put("qquser.qqSex", qquser.getQqSex());
		params.put("qquser.qqAddress", qquser.getQqAddress());
		params.put("qquser.qqMark", qquser.getQqMark());
		params.put("qquser.qqStatu", 0+"");//状态为0 未上线
		params.put("qquser.qqZhanghao", qquser.getQqZhanghao());//账号 9个 还有一个自增id
		client.post(uri,params,new JsonHttpResponseHandler(){
			@Override
			public void onStart() {       
			}
			@Override
			public void onFailure(Throwable arg0, String arg1) {
				//登录失败-网络问题
				handler.sendEmptyMessage(2);
			}
			@Override
			public void onSuccess(int arg0, JSONObject arg1) {
				//如果Jsonobject获取的值不正确（jsonview）是不会继续下去的
				int result=arg1.optInt("result");
				if(result==1){
					handler.sendEmptyMessage(1);
				}else{
					handler.sendEmptyMessage(0);
				}
			}
			@Override
			public void onFinish() {
			}
		});
	}
	//修改用户
	@Override
	protected void onDestroy() {
		// TODO 自动生成的方法存根
		super.onDestroy();
		alertQQuer();
	}
}


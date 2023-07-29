package com.example.qq_lxr9y18r;

import org.json.JSONObject;

import com.example.qq_lxr9y18r.bean.AndroidQqUser;
import com.example.qq_lxr9y18r.constant.URI_IP;
import com.example.qq_lxr9y18r.dialog.ZhangHaoDialog;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.squareup.picasso.Picasso;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends Activity implements OnClickListener,TextWatcher{
	
	private static final String TAG = LoginActivity.class.getSimpleName();
	
	private Button but;
	private TextView zhuce;
	private EditText login_et_zh;
	private EditText login_et_mm;
	private String zhanghao;
	private String mima;
	private TextView login_logining;
	
	//ͷ��
	private ImageView login_ig_tu;

	private WindowManager.LayoutParams ip ;
	private PopupWindow pop;
	
	private AnimationDrawable anim;
	
	String zhanghaos;
	
	private Handler handler = new Handler(){
		@Override
		public void handleMessage(Message msg) {
			int what = msg.what;
			switch (what) {
			case 1://�˺��������
				Toast.makeText(LoginActivity.this, "�˺Ż����������", 0).show();
				noloading();
				break;
			case 2://�������Ӵ���
				Toast.makeText(LoginActivity.this, "������������", 0).show();
				noloading();
				break;
			default:
				break;
			}
		}
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);//�ޱ���
		setContentView(R.layout.activity_login);
		findView();
		setOnclicks();
	}
	public void findView(){
		but=(Button)this.findViewById(R.id.login_but_dr);
		zhuce=(TextView)this.findViewById(R.id.login_tv_zhuce);
		login_et_zh=(EditText)this.findViewById(R.id.login_et_zh);
		login_et_mm=(EditText)this.findViewById(R.id.login_et_mm);
		login_logining=(TextView) this.findViewById(R.id.login_logining);
		login_ig_tu = (ImageView) this.findViewById(R.id.login_ig_tu);
	}
	public void setOnclicks(){
		but.setOnClickListener(this);
		zhuce.setOnClickListener(this);
		login_et_zh.addTextChangedListener(this);
	}
	//���ü���
	public void loading(){
		ip = getWindow().getAttributes();
		ip.alpha = 0.7f;//alphaͨ�� ����͸����
		getWindow().setAttributes(ip);
		
		//�Ȼ�ȡһ������
		DisplayMetrics outmetrics = new DisplayMetrics();
		(this).getWindowManager().getDefaultDisplay().getMetrics(outmetrics);
		int width = (int)(outmetrics.widthPixels);
		int screenwidth = (int)(outmetrics.widthPixels*0.95);
		//���ó��ֵȴ���ʽ
		View view = LayoutInflater.from(this).inflate(R.layout.activity_logining, null);
		LinearLayout logining_ll=(LinearLayout) view.findViewById(R.id.logining_ll);
		logining_ll.getBackground().setAlpha(190);
		//������ת
		ImageView logining_iv = (ImageView) view.findViewById(R.id.logining_iv);
		Resources rs = this.getResources();
		anim = (AnimationDrawable) rs.getDrawable(R.drawable.loginingiv_anim);
		logining_iv.setImageDrawable(anim);
		anim.start();
		//���ó��ֵ�λ��
		pop = new PopupWindow(view,screenwidth,80);
		//�����ļ�
		
		int oxff = (width-screenwidth)/2;
		pop.showAsDropDown(login_logining,oxff,0);
	 
	}
	
	//ȡ������
	public void noloading(){
		anim.stop();//ͼƬֹͣ
		ip.alpha = 1f;//alphaͨ�� ����͸����
		getWindow().setAttributes(ip);
		pop.dismiss();
	}
	public void yanzheng(){
		AsyncHttpClient client = new AsyncHttpClient();
		String uri =URI_IP.URI+"Android_Service/QQ/execute?zhanghao="+zhanghao+"&mima="+mima+"";
		client.get(uri,new JsonHttpResponseHandler(){
			@Override
			public void onStart() {       
			}
			@Override
			public void onFailure(Throwable arg0, String arg1) {
				//��¼ʧ��-��������
				handler.sendEmptyMessage(2);
			}
			@Override
			public void onSuccess(int arg0, JSONObject arg1) {
				int result=arg1.optInt("result");
				if(result==1){
					//��¼�ɹ� 
					noloading();
					//������application
					Gson gson = new Gson();
					AndroidQqUser qquser = gson.fromJson(arg1.toString(), AndroidQqUser.class);
					Applications.setQquser(qquser);
					//��ʼ��ת
					Intent intent=new Intent();
					intent.setClass(LoginActivity.this, MainActivity.class);
					startActivity(intent);
					LoginActivity.this.finish();
				}else{
					//��¼ʧ�� -�˺����벻ƥ��
					handler.sendEmptyMessage(1);
				}
			}
			@Override
			public void onFinish() {
			}
		});
	}
	@Override
	public void onClick(View v) {
		int viewid=v.getId();
		if(viewid==R.id.login_but_dr){
			//��ȡ��ֵ ȥ��̨ƥ��
			zhanghao = login_et_zh.getText().toString();
			mima = login_et_mm.getText().toString();
			if(zhanghao.equals("")){
				Toast.makeText(this, "�������˺�", 0).show();
				return;
			}
			if(mima.equals("")){
				Toast.makeText(this, "����������", 0).show();
				return;
			}
			loading();
			yanzheng();
			
		}else if(viewid == R.id.login_tv_zhuce){
			Intent intent = new Intent(LoginActivity.this,ZhuCeActivity.class);
			startActivityForResult(intent, 1);
		}
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if(requestCode==1&&resultCode==1){
			zhanghaos=data.getStringExtra("zhanghao");
			if(zhanghaos!=null&&!zhanghaos.equals("")){
				ZhangHaoDialog zhu = new ZhangHaoDialog(this,R.style.custom_dialog,zhanghaos);
				zhu.show();
				login_et_zh.setText(zhanghaos);
				Picasso.with(this).load(URI_IP.URI+"Android_Service/image/"+zhanghaos+"touxiang.png").placeholder(R.drawable.gco).into(login_ig_tu);
			}
		}
	}
	@Override
	public void afterTextChanged(Editable arg0) {
		// TODO �Զ����ɵķ������
		}
	@Override
	public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
		// TODO �Զ����ɵķ������
		
	}
	@Override
	public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
		//������ȡ
		String str = login_et_zh.getText().toString();
		Picasso.with(this).load(URI_IP.URI+"Android_Service/image/"+str+"touxiang.png").placeholder(R.drawable.gco). into(login_ig_tu);
	}

}

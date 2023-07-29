package com.example.qq_lxr9y18r;


import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Random;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import com.example.qq_lxr9y18r.constant.URI_IP;
import com.example.qq_lxr9y18r.dialog.ZhangHaoDialog;
import com.example.qq_lxr9y18r.dialog.ZhuceDialog;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.squareup.picasso.Picasso;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

public class ZhuCeActivity extends Activity implements OnClickListener{
	String txs;//1.ͷ��
	String phone;//2.�绰
	String nicheng;//3.�ǳ�
	String mima;//4.����
	String qurenmima;//5.ȷ������
	String sex="��";//6.�Ա�Ĭ����
	String address;//7.��ַ
	String mark;//8.����ǩ��
	String zhanghao;//��ʾ���˺�
	//1��ͷ��
	private ImageView qqtx;
	//2.�ֻ�����
	private EditText qqphone;
	//3.�ǳ�
	private EditText qqnicheng;
	//4.����
	private EditText qqmima;
	//5.ȷ������
	private EditText qqcheckmima;
	//6.�Ա�
	private RadioGroup qqsexgroup;
	private RadioButton qqsexrdb1;
	private RadioButton qqsexrdb2;
	//7.��ַ
	private EditText qqaddress;
	//8.����ǩ��
	private EditText qqmark;
	//9.ע��
	private Button zhuce;
	
	public Handler handler = new Handler(){
		@Override
		public void handleMessage(Message msg) {
			int what = msg.what;
			switch (what) {
			case 0:
				Toast.makeText(ZhuCeActivity.this, "��Ϣ��д����������쳣", 0).show();
				break;
			case 1:
				Intent intent = new Intent(ZhuCeActivity.this, LoginActivity.class);
				intent.putExtra("zhanghao", zhanghao);
				setResult(1,intent);
				finish();
				break;
			case 2:
				//��ʾͼ��
				setImageView();
				break;
			case 3:
				Toast.makeText(ZhuCeActivity.this, "�����쳣,ѡ��ͷ��ʧ��", 0).show();
				break;
			default:
				break;
			}
		}
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO �Զ����ɵķ������
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);//�ޱ���
		setContentView(R.layout.activity_zhuce);
		findView();
		zhanghao=getQQzhanghao();//һ������ȡ�˺ţ�����ͷ���� �Ż��ĵط��ڻ�ȡ
	}
	public void findView(){
		qqtx = (ImageView)this.findViewById(R.id.rl1_ig1_tx);//1
		qqphone = (EditText)this.findViewById(R.id.rl2_et1_phone);//2
		qqnicheng = (EditText)this.findViewById(R.id.rl3_et1_name);//3
		qqmima = (EditText)this.findViewById(R.id.rl4_et1_mima);//4
		qqcheckmima  =(EditText)this.findViewById(R.id.rl5_et1_qurenmima);//5
		qqsexgroup = (RadioGroup)this.findViewById(R.id.rl6_rg_sex);//6
		qqsexrdb1=(RadioButton) this.findViewById(R.id.rl6_rb1_nan);
		qqsexrdb2=(RadioButton) this.findViewById(R.id.rl6_rb2_nv);
		qqaddress = (EditText)this.findViewById(R.id.rl7_et1_address);//7
		qqmark = (EditText)this.findViewById(R.id.rl8_et1_gxqm);//8
		zhuce = (Button)this.findViewById(R.id.rl9_bt1_zhuce);//9
		zhuce.setOnClickListener(this);
		//��ѡ��
		qqsexgroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				if(checkedId==qqsexrdb1.getId()){//ѡ����
					sex="��";
				}else if(checkedId==qqsexrdb2.getId()){//ѡ��Ů
					sex="Ů";
				}
			}
		});
	}
	@Override
	public void onClick(View v) {
		//��ȡֵ
		//1.ͷ�� �л�ȡ��
		phone=qqphone.getText().toString();//2.�绰
		nicheng=qqnicheng.getText().toString();//3.�ǳ�
		mima=qqmima.getText().toString();//4.����
		qurenmima=qqcheckmima.getText().toString();//5.ȷ������
		address=qqaddress.getText().toString();//7.��ַ
		mark=qqmark.getText().toString();//8.����ǩ��
		if(!mima.equals(qurenmima)){
			Toast.makeText(this, "�������벻��ȷ", 0).show();
			return;
		}
		//post����
		startzhuce();
	}
	public void setImageView(){
		Picasso.with(this).load(URI_IP.URI+"Android_Service/image/"+zhanghao+"touxiang.png").placeholder(R.drawable.touxiang).into(qqtx);
	}
	public String getQQzhanghao(){//�Ż�Ҫ���Ƿ�������˺���
		Random r = new Random();
		int i=r.nextInt(1400000000)+1000000;
		return i+"";
	}
	public void startzhuce(){
		String url=URI_IP.URI+"Android_Service/QQ/zhuce";
		AsyncHttpClient client = new AsyncHttpClient();
		RequestParams params = new RequestParams();
		try {
			params.put("qquser.qqTouxiang", zhanghao+"touxiang.png");
			params.put("qquser.qqPhone", phone);
			params.put("qquser.qqName", nicheng);
			params.put("qquser.qqMima", mima);
			params.put("qquser.qqSex", sex);
			params.put("qquser.qqAddress", address);
			params.put("qquser.qqMark", mark);
			params.put("qquser.qqStatu", 0+"");//״̬Ϊ0 δ����
			params.put("qquser.qqZhanghao", zhanghao);//�˺� 9�� ����һ������id
			//get��������롣����
			client.post(url,params, new JsonHttpResponseHandler(){
				@Override
				public void onFailure(Throwable arg0, JSONObject arg1) {
					//��������ʧ��
					handler.sendEmptyMessage(1);
				}
				@Override
				public void onSuccess(int arg0, JSONObject arg1) {
					int result= arg1.optInt("result");
					if(result==1){
						//�ɹ�
						handler.sendEmptyMessage(1);
					}else{
						//ʧ��
						handler.sendEmptyMessage(0);
					}
				}
				@Override
				public void onFinish() {
					// TODO �Զ����ɵķ������
					super.onFinish();
				}
				@Override
				public void onStart() {
					// TODO �Զ����ɵķ������
					super.onStart();
				}
				
			});
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
	public void ShowDialogOfImage(View v){
		ZhuceDialog dialogs = new ZhuceDialog(this,R.style.custom_dialog,this);
		dialogs.show();
	}
	//����
	public void camera(){
		Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);//�������Ҫ��action ��MediaStore����
		startActivityForResult(intent, 1);
	}
	public void photos(){
		Intent intent = new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI);//��һ��Ҳ����ͼ�⣬�ڶ�����ͼƬ��uri
		startActivityForResult(intent, 2);
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		//dataӦ���Ǳ�����ͼƬ��Bitmap
		//ͼƬ��data��ȡ
		if(requestCode==1){
			try {
				Bitmap bit = (Bitmap) data.getExtras().get("data");
				if(bit!=null){
					//ͨ��bit�õ�����ͼƬ��Ӧ�ð�
					File file = saveImage(bit);
					//���ص�File�ϴ���tomcat
					UpdFile(file);
				}
			} catch (Exception e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}else if(requestCode==2){//ͼ��ѡ��һ����Ƭ�Ĳ���
			try {
				//�����ͼ�����õĻ� �õ�ͼƬ��uri
				Uri photouri = data.getData();
				//ͨ��uri��ȡͼƬλͼ ���Ա�����Ӧ��
				Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), photouri);//
				//saveImage(bitmap);//��һ��Ҫд
				//ͼƬ��Ϣ��·���ֶ��� 
				//���DATAӦ����ͼƬ·�����ֶ�
				String photopath[] = {MediaStore.Images.Media.DATA};
				//�����ֶ�����ͼƬ��uri��ȡͼƬ������·��
				Cursor cursor = this.getContentResolver().query(photouri, photopath, "", null, "");
				cursor.moveToNext();
				//��ȡ·��
				String path=cursor.getString(cursor.getColumnIndex(photopath[0]));
				//tx=path;ֻ�ǻ�ȡ���˾���·��
				//�����ļ�
				File file = new File(path);
//				tx=file.getName();//�����ȡ������ļ����ļ�������ͼƬ��
				//tx��ȡ�ļ����ĺ�׺ ��qq��+��׺ �����ظ�
//				tx=tx.substring(tx.indexOf("."), tx.length());
				//�ϴ�ͼƬ
				UpdFile(file);
			} catch (Exception e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
	}
	//���汾�ز��ܱ���ȡΪfile����
	public File saveImage(Bitmap bit){
		String path = Environment.getExternalStorageDirectory().getAbsolutePath()+"/"+System.currentTimeMillis()+".png";
		File file = new File(path);//������ļ���������������Ҫ������
		try {
			if(!file.exists()){
				file.createNewFile();
			}
			FileOutputStream fo = new FileOutputStream(file);
			bit.compress(CompressFormat.PNG, 100, fo);//100Ϊ����ͼƬ����Ķ��� �����Ȱɡ�����
			
			fo.flush();
			fo.close();
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return file;
	}
	public void UpdFile(File file){
		AsyncHttpClient client = new AsyncHttpClient();
		RequestParams params = new RequestParams();
		try {
			params.put("file", file);//�ļ�
			params.put("qq_touxiang", zhanghao+"touxiang.png");//�ļ���
			client.post(URI_IP.URI+"Android_Service/QQ/updfile",params, new JsonHttpResponseHandler(){
				@Override
				public void onFailure(Throwable arg0, JSONObject arg1) {
					handler.sendEmptyMessage(3);
				}
				@Override
				public void onSuccess(int arg0, JSONObject arg1) {
					handler.sendEmptyMessage(2);
				}
				@Override
				public void onFinish() {
					// TODO �Զ����ɵķ������
					super.onFinish();
				}
				@Override
				public void onStart() {
					// TODO �Զ����ɵķ������
					super.onStart();
				}
				
			});
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
}

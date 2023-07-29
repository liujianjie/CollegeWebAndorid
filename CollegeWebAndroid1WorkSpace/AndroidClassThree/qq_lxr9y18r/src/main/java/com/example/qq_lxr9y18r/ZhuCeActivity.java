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
	String txs;//1.头像
	String phone;//2.电话
	String nicheng;//3.昵称
	String mima;//4.密码
	String qurenmima;//5.确认密码
	String sex="男";//6.性别默认男
	String address;//7.地址
	String mark;//8.个性签名
	String zhanghao;//显示的账号
	//1。头像
	private ImageView qqtx;
	//2.手机号码
	private EditText qqphone;
	//3.昵称
	private EditText qqnicheng;
	//4.密码
	private EditText qqmima;
	//5.确认密码
	private EditText qqcheckmima;
	//6.性别
	private RadioGroup qqsexgroup;
	private RadioButton qqsexrdb1;
	private RadioButton qqsexrdb2;
	//7.地址
	private EditText qqaddress;
	//8.个性签名
	private EditText qqmark;
	//9.注册
	private Button zhuce;
	
	public Handler handler = new Handler(){
		@Override
		public void handleMessage(Message msg) {
			int what = msg.what;
			switch (what) {
			case 0:
				Toast.makeText(ZhuCeActivity.this, "信息填写错误或网络异常", 0).show();
				break;
			case 1:
				Intent intent = new Intent(ZhuCeActivity.this, LoginActivity.class);
				intent.putExtra("zhanghao", zhanghao);
				setResult(1,intent);
				finish();
				break;
			case 2:
				//显示图像
				setImageView();
				break;
			case 3:
				Toast.makeText(ZhuCeActivity.this, "网络异常,选择头像失败", 0).show();
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
		setContentView(R.layout.activity_zhuce);
		findView();
		zhanghao=getQQzhanghao();//一进来获取账号，来做头像名 优化的地方在获取
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
		//单选框
		qqsexgroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				if(checkedId==qqsexrdb1.getId()){//选择男
					sex="男";
				}else if(checkedId==qqsexrdb2.getId()){//选择女
					sex="女";
				}
			}
		});
	}
	@Override
	public void onClick(View v) {
		//获取值
		//1.头像 有获取了
		phone=qqphone.getText().toString();//2.电话
		nicheng=qqnicheng.getText().toString();//3.昵称
		mima=qqmima.getText().toString();//4.密码
		qurenmima=qqcheckmima.getText().toString();//5.确认密码
		address=qqaddress.getText().toString();//7.地址
		mark=qqmark.getText().toString();//8.个性签名
		if(!mima.equals(qurenmima)){
			Toast.makeText(this, "两次密码不正确", 0).show();
			return;
		}
		//post请求
		startzhuce();
	}
	public void setImageView(){
		Picasso.with(this).load(URI_IP.URI+"Android_Service/image/"+zhanghao+"touxiang.png").placeholder(R.drawable.touxiang).into(qqtx);
	}
	public String getQQzhanghao(){//优化要做是否有这个账号了
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
			params.put("qquser.qqStatu", 0+"");//状态为0 未上线
			params.put("qquser.qqZhanghao", zhanghao);//账号 9个 还有一个自增id
			//get请求会乱码。。。
			client.post(url,params, new JsonHttpResponseHandler(){
				@Override
				public void onFailure(Throwable arg0, JSONObject arg1) {
					//网络连接失败
					handler.sendEmptyMessage(1);
				}
				@Override
				public void onSuccess(int arg0, JSONObject arg1) {
					int result= arg1.optInt("result");
					if(result==1){
						//成功
						handler.sendEmptyMessage(1);
					}else{
						//失败
						handler.sendEmptyMessage(0);
					}
				}
				@Override
				public void onFinish() {
					// TODO 自动生成的方法存根
					super.onFinish();
				}
				@Override
				public void onStart() {
					// TODO 自动生成的方法存根
					super.onStart();
				}
				
			});
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	public void ShowDialogOfImage(View v){
		ZhuceDialog dialogs = new ZhuceDialog(this,R.style.custom_dialog,this);
		dialogs.show();
	}
	//照相
	public void camera(){
		Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);//打开照相机要用action 用MediaStore就行
		startActivityForResult(intent, 1);
	}
	public void photos(){
		Intent intent = new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI);//第一个也许是图库，第二个是图片的uri
		startActivityForResult(intent, 2);
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		//data应该是保存了图片的Bitmap
		//图片用data获取
		if(requestCode==1){
			try {
				Bitmap bit = (Bitmap) data.getExtras().get("data");
				if(bit!=null){
					//通过bit拿到保存图片到应用吧
					File file = saveImage(bit);
					//返回的File上传到tomcat
					UpdFile(file);
				}
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}else if(requestCode==2){//图库选择一个照片的操作
			try {
				//这个从图库里拿的话 拿到图片的uri
				Uri photouri = data.getData();
				//通过uri获取图片位图 可以保存在应用
				Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), photouri);//
				//saveImage(bitmap);//不一定要写
				//图片信息的路径字段名 
				//这个DATA应该是图片路径的字段
				String photopath[] = {MediaStore.Images.Media.DATA};
				//根据字段名和图片的uri获取图片真正的路径
				Cursor cursor = this.getContentResolver().query(photouri, photopath, "", null, "");
				cursor.moveToNext();
				//获取路径
				String path=cursor.getString(cursor.getColumnIndex(photopath[0]));
				//tx=path;只是获取到了绝对路径
				//创建文件
				File file = new File(path);
//				tx=file.getName();//这个获取到这个文件的文件名就是图片名
				//tx获取文件名的后缀 在qq号+后缀 避免重复
//				tx=tx.substring(tx.indexOf("."), tx.length());
				//上传图片
				UpdFile(file);
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}
	//保存本地才能被读取为file类型
	public File saveImage(Bitmap bit){
		String path = Environment.getExternalStorageDirectory().getAbsolutePath()+"/"+System.currentTimeMillis()+".png";
		File file = new File(path);//而这个文件不存在所以我们要创建它
		try {
			if(!file.exists()){
				file.createNewFile();
			}
			FileOutputStream fo = new FileOutputStream(file);
			bit.compress(CompressFormat.PNG, 100, fo);//100为这张图片传输的多少 清晰度吧。。。
			
			fo.flush();
			fo.close();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return file;
	}
	public void UpdFile(File file){
		AsyncHttpClient client = new AsyncHttpClient();
		RequestParams params = new RequestParams();
		try {
			params.put("file", file);//文件
			params.put("qq_touxiang", zhanghao+"touxiang.png");//文件名
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
					// TODO 自动生成的方法存根
					super.onFinish();
				}
				@Override
				public void onStart() {
					// TODO 自动生成的方法存根
					super.onStart();
				}
				
			});
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}

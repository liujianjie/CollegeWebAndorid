package com.example.qq_lxr9y18r;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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

import com.example.qq_lxr9y18r.basadpter.GridBasicAdpdter;
import com.example.qq_lxr9y18r.bean.AndroidQqUser;
import com.example.qq_lxr9y18r.constant.URI_IP;
import com.example.qq_lxr9y18r.dialog.AddDtOfDelDialog;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import android.R.color;
import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.Layout;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("ResourceAsColor")
public class AddDynamicActivity extends FragmentActivity implements OnClickListener,TextWatcher{
	
	private TextView adddt_rl_tv1;
	private TextView adddt_rl_tv3;
	private EditText adddt_rl2_et1;
	private GridView adddt_gv_tps;
	
	private AndroidQqUser qquser;
	
	private Map<String,Bitmap> bitmap = new HashMap<String,Bitmap>();
	
	GridBasicAdpdter ap;
	
	private File[] file = new File[10];//文件
	private String[] dynamicnamephoto=new String[10];//文件名 保存的
	private String dyPhotos="";//保存在数据库的
	
	private boolean bln1 = false;//条件1
	private boolean bln2 = false;//条件2
	
	private Handler handler = new Handler(){
		@Override
		public void handleMessage(Message msg) {
			int what = msg.what;
			switch (what) {
			case 0:
				break;
			case 1:
				bln1 = true;
				//
				finishs();
				break;
			case 2:
				Toast.makeText(AddDynamicActivity.this, "网络失败", 0).show();
				break;
			case 3:
				bln2 = true;
				finishs();
				break;
			case 4:
				Toast.makeText(AddDynamicActivity.this, "上传图片失败", 0).show();
				break;
			default:
				break;
			}
		}
	};
	
	@Override
	protected void onCreate(Bundle arg0) {
		// TODO 自动生成的方法存根
		super.onCreate(arg0);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_adddongtai);
		getqquser();
		findView();
		setAdpter();
	}
	public void finishs(){
		if(bln1==true&&bln2==true){
			//发送广播
			Intent intent = new Intent();
			intent.setAction("broadcast.dynamicfragment");
			sendBroadcast(intent);
			finish();
		}
	}
	public void getqquser(){
		qquser = Applications.getqquser();
	}
	public void findView(){
		adddt_rl_tv1 = (TextView) this.findViewById(R.id.adddt_rl_tv1);//取消
		adddt_rl_tv3 = (TextView) this.findViewById(R.id.adddt_rl_tv3);//发表
		adddt_rl2_et1 = (EditText) this.findViewById(R.id.adddt_rl2_et1);//写说说
		
		adddt_gv_tps = (GridView) this.findViewById(R.id.adddt_gv_tps);//图片列表
		
		adddt_rl_tv1.setOnClickListener(this);
		adddt_rl_tv3.setOnClickListener(this);
		adddt_rl2_et1.addTextChangedListener(this);
		
		//添加默认图片
		bitmap.put("0", null);
	}
	@Override
	public void onClick(View v) {
		int id = v.getId();
		if(id == R.id.adddt_rl_tv1){
			this.finish();
		}else if(id == R.id.adddt_rl_tv3){
			add();
			sendPhotos();
		}
	}
	//图片gridview
	public void setAdpter(){
		ap = new GridBasicAdpdter(this);
		ap.setData(this,bitmap);
		adddt_gv_tps.setAdapter(ap);
		adddt_gv_tps.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// 删除图片
				if(position!=0){
					AddDtOfDelDialog del = new AddDtOfDelDialog(AddDynamicActivity.this,R.style.custom_dialog, AddDynamicActivity.this, position);
					del.show();
				}
			}
		});
	}
	//remove
	public void remove(int position){
		//也要前进吗？bitmap
		int size = bitmap.size();
		for(int i=position;i<size;i++){
			bitmap.put(i+"", bitmap.get((i+1)+""));//重新赋值，将后面的赋给前面的
			//最后一个
			if(i==size-1){
				bitmap.remove((i)+"");
				bitmap.remove((i+1)+"");
			}
		}
		notifys();
		//file和filename都要删掉  file用remove  filename也用remove并后面的前进
		for(int i=position-1;i<file.length;i++){
			if(i==file.length-1){
				file[i]=null;//最后一个
				dynamicnamephoto[i]="";
				break;
			}
			file[i] = file[i+1];
			dynamicnamephoto[i]=dynamicnamephoto[i+1];
		}
	}
	//notify
	public void notifys(){
		ap.setData(this,bitmap);
		ap.notifyDataSetChanged();
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
					//判断了 是map
					bitmap.put(bitmap.size()+"", bit);
					notifys();//刷新
					//通过bit拿到保存图片到应用吧
					for(int i=0;i<file.length;i++){
						File fil = file[i];
						if(fil==null){
							file[i] = saveImage(bit);
							i=file.length;
						}
					}
					
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
				Bitmap bitmaps = MediaStore.Images.Media.getBitmap(this.getContentResolver(), photouri);//
				bitmap.put(bitmap.size()+"", bitmaps);
				notifys();//刷新
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
				File files = new File(path);
				for(int i=0;i<dynamicnamephoto.length;i++){
					Object obj = dynamicnamephoto[i];
					if(obj==null){
						file[i] = files;//文件
						dynamicnamephoto[i]=qquser.getQqId()+"dt"+files.getName();//文件名
						i=dynamicnamephoto.length;
					}
				}
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}
	//保存本地才能被读取为file类型
	public File saveImage(Bitmap bit){
		String path = Environment.getExternalStorageDirectory().getAbsolutePath()+"/"+System.currentTimeMillis()+".png";
		File files = new File(path);//而这个文件不存在所以我们要创建它
		//只要后缀 文件名叫qq+dt+文件名
		for(int i=0;i<dynamicnamephoto.length;i++){
			Object obj = dynamicnamephoto[i];
			if(obj==null){
				dynamicnamephoto[i]=qquser.getQqId()+"dt"+files.getName();//文件名
				i=dynamicnamephoto.length;
			}
		}
		try {
			if(!files.exists()){
				files.createNewFile();
			}
			FileOutputStream fo = new FileOutputStream(files);
			bit.compress(CompressFormat.PNG, 100, fo);//100为这张图片传输的多少 清晰度吧。。。
			
			fo.flush();
			fo.close();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return files;
	}
	//网络请求如下 添加
	public void add(){
		Date date = new Date();
		AsyncHttpClient client = new AsyncHttpClient();
		String uri=URI_IP.URI+"Android_Service/QQ/adddynamic";
		RequestParams params = new RequestParams();
		params.put("qqdynamic.qqId", qquser.getQqId()+"");
		params.put("qqdynamic.qqZhanghao", qquser.getQqZhanghao());
		params.put("qqdynamic.qqName", qquser.getQqName());
		params.put("qqdynamic.qqTouxiang", qquser.getQqTouxiang());
		params.put("qqdynamic.dyDate",date.toLocaleString());
		params.put("qqdynamic.dyContent",adddt_rl2_et1.getText().toString());
		for(int i=0;i<dynamicnamephoto.length;i++){
			Object obj = dynamicnamephoto[i];
			if(obj!=null){
				dyPhotos+=dynamicnamephoto[i]+",";//数据库字符串
			}else{
				i=dynamicnamephoto.length;
			}
		}
		params.put("qqdynamic.dyPhotos", dyPhotos+"");//多张图片用，号隔开 取也是。。。 这个文件名需要重新定义在组成这个
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
	public void sendPhotos(){
		for(int i=0;i<file.length;i++){
			if(file[i]!=null){
				AsyncHttpClient client = new AsyncHttpClient();
				String uri=URI_IP.URI+"Android_Service/QQ/saveDtPhotos";
				RequestParams params = new RequestParams();
				try {
					params.put("file", file[i]);//用数组
				} catch (Exception e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				params.put("dynamicnamephoto",dynamicnamephoto[i]);//用数组保存自定义文件名
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
							handler.sendEmptyMessage(3);
						}else{
							handler.sendEmptyMessage(4);
						}
					}
					@Override
					public void onFinish() {
					}
				});
			}else{
				i=file.length;
			}
		}
		handler.sendEmptyMessage(3);
	}
	
	
	
	@Override
	public void beforeTextChanged(CharSequence s, int start, int count, int after) {
		// TODO 自动生成的方法存根
		
	}
	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {
		String str = adddt_rl2_et1.getText().toString();
		if(str.equals("")){
			adddt_rl_tv3.setEnabled(false);
		}else{
			adddt_rl_tv3.setEnabled(true);
		}
	}
	@Override
	public void afterTextChanged(Editable s) {
		// TODO 自动生成的方法存根
		
	}

}

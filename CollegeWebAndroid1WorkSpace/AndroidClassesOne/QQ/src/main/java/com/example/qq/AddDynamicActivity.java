package com.example.qq;

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

import com.example.qq.basadpter.GridBasicAdpdter;
import com.example.qq.bean.AndroidQqUser;
import com.example.qq.constant.URI_IP;
import com.example.qq.dialog.AddDtOfDelDialog;
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
import android.support.v4.media.MediaMetadataCompat.BitmapKey;
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
	
	private File[] file = new File[10];//�ļ�
	private String[] dynamicnamephoto=new String[10];//�ļ��� �����
	private String dyPhotos="";//���������ݿ��
	
	private boolean bln1 = false;//����1
	private boolean bln2 = false;//����2
	
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
				Toast.makeText(AddDynamicActivity.this, "����ʧ��", 0).show();
				break;
			case 3:
				bln2 = true;
				finishs();
				break;
			case 4:
				Toast.makeText(AddDynamicActivity.this, "�ϴ�ͼƬʧ��", 0).show();
				break;
			default:
				break;
			}
		}
	};
	
	@Override
	protected void onCreate(Bundle arg0) {
		// TODO �Զ����ɵķ������
		super.onCreate(arg0);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_adddongtai);
		getqquser();
		findView();
		setAdpter();
	}
	public void finishs(){
		if(bln1==true&&bln2==true){
			//���͹㲥
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
		adddt_rl_tv1 = (TextView) this.findViewById(R.id.adddt_rl_tv1);//ȡ��
		adddt_rl_tv3 = (TextView) this.findViewById(R.id.adddt_rl_tv3);//����
		adddt_rl2_et1 = (EditText) this.findViewById(R.id.adddt_rl2_et1);//д˵˵
		
		adddt_gv_tps = (GridView) this.findViewById(R.id.adddt_gv_tps);//ͼƬ�б�
		
		adddt_rl_tv1.setOnClickListener(this);
		adddt_rl_tv3.setOnClickListener(this);
		adddt_rl2_et1.addTextChangedListener(this);
		
		//���Ĭ��ͼƬ
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
	//ͼƬgridview
	public void setAdpter(){
		ap = new GridBasicAdpdter(this);
		ap.setData(this,bitmap);
		adddt_gv_tps.setAdapter(ap);
		adddt_gv_tps.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// ɾ��ͼƬ
				if(position!=0){
					AddDtOfDelDialog del = new AddDtOfDelDialog(AddDynamicActivity.this,R.style.custom_dialog, AddDynamicActivity.this, position);
					del.show();
				}
			}
		});
	}
	//remove
	public void remove(int position){
		//ҲҪǰ����bitmap
		int size = bitmap.size();
		for(int i=position;i<size;i++){
			bitmap.put(i+"", bitmap.get((i+1)+""));//���¸�ֵ��������ĸ���ǰ���
			//���һ��
			if(i==size-1){
				bitmap.remove((i)+"");
				bitmap.remove((i+1)+"");
			}
		}
		notifys();
		//file��filename��Ҫɾ��  file��remove  filenameҲ��remove�������ǰ��
		for(int i=position-1;i<file.length;i++){
			if(i==file.length-1){
				file[i]=null;//���һ��
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
					//�ж��� ��map
					bitmap.put(bitmap.size()+"", bit);
					notifys();//ˢ��
					//ͨ��bit�õ�����ͼƬ��Ӧ�ð�
					for(int i=0;i<file.length;i++){
						File fil = file[i];
						if(fil==null){
							file[i] = saveImage(bit);
							i=file.length;
						}
					}
					
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
				Bitmap bitmaps = MediaStore.Images.Media.getBitmap(this.getContentResolver(), photouri);//
				bitmap.put(bitmap.size()+"", bitmaps);
				notifys();//ˢ��
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
				File files = new File(path);
				for(int i=0;i<dynamicnamephoto.length;i++){
					Object obj = dynamicnamephoto[i];
					if(obj==null){
						file[i] = files;//�ļ�
						dynamicnamephoto[i]=qquser.getQqId()+"dt"+files.getName();//�ļ���
						i=dynamicnamephoto.length;
					}
				}
			} catch (Exception e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
	}
	//���汾�ز��ܱ���ȡΪfile����
	public File saveImage(Bitmap bit){
		String path = Environment.getExternalStorageDirectory().getAbsolutePath()+"/"+System.currentTimeMillis()+".png";
		File files = new File(path);//������ļ���������������Ҫ������
		//ֻҪ��׺ �ļ�����qq+dt+�ļ���
		for(int i=0;i<dynamicnamephoto.length;i++){
			Object obj = dynamicnamephoto[i];
			if(obj==null){
				dynamicnamephoto[i]=qquser.getQqId()+"dt"+files.getName();//�ļ���
				i=dynamicnamephoto.length;
			}
		}
		try {
			if(!files.exists()){
				files.createNewFile();
			}
			FileOutputStream fo = new FileOutputStream(files);
			bit.compress(CompressFormat.PNG, 100, fo);//100Ϊ����ͼƬ����Ķ��� �����Ȱɡ�����
			
			fo.flush();
			fo.close();
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return files;
	}
	//������������ ���
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
				dyPhotos+=dynamicnamephoto[i]+",";//���ݿ��ַ���
			}else{
				i=dynamicnamephoto.length;
			}
		}
		params.put("qqdynamic.dyPhotos", dyPhotos+"");//����ͼƬ�ã��Ÿ��� ȡҲ�ǡ����� ����ļ�����Ҫ���¶�����������
		client.post(uri,params,new JsonHttpResponseHandler(){
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
				//���Jsonobject��ȡ��ֵ����ȷ��jsonview���ǲ��������ȥ��
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
					params.put("file", file[i]);//������
				} catch (Exception e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
				params.put("dynamicnamephoto",dynamicnamephoto[i]);//�����鱣���Զ����ļ���
				client.post(uri,params,new JsonHttpResponseHandler(){
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
						//���Jsonobject��ȡ��ֵ����ȷ��jsonview���ǲ��������ȥ��
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
		// TODO �Զ����ɵķ������
		
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
		// TODO �Զ����ɵķ������
		
	}

}

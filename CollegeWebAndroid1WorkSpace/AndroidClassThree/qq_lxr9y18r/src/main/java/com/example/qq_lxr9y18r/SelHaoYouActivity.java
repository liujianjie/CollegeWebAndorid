package com.example.qq_lxr9y18r;

import java.util.List;

import org.json.JSONObject;

import com.example.qq_lxr9y18r.basadpter.SelHyBaseApdater;
import com.example.qq_lxr9y18r.bean.AndroidQqHy;
import com.example.qq_lxr9y18r.bean.AndroidQqHyList;
import com.example.qq_lxr9y18r.bean.AndroidQqUser;
import com.example.qq_lxr9y18r.bean.AndroidQqUserList;
import com.example.qq_lxr9y18r.constant.URI_IP;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import android.app.Activity;
import android.content.Intent;
import android.opengl.Visibility;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class SelHaoYouActivity extends FragmentActivity implements OnClickListener,TextWatcher{
	
	private String selxinxi;

	private ListView listview;
	
	private List<AndroidQqUser> userlist;
	
	private AndroidQqUser qquser = Applications.getqquser();
	
	SelHyBaseApdater hyapdater;
	
	//����
	private TextView selhy_rl_tv1;
	
	//����
	private TextView selhy_rl_ll_tv2;
	
	//edittext
	private EditText selhy_rl_ll_ed;
	
	private String xinselxinxi;
	
	private Handler handler = new Handler(){
		@Override
		public void handleMessage(Message msg) {
			int what = msg.what;
			switch (what) {
			case 0://û�к���
				Toast.makeText(SelHaoYouActivity.this, "û���ҵ���ؽ��", 0).show();
				break;
			case 1://�ɹ�
				//�ɹ�ˢ��
				notifyAdpter();
				break;
			case 2://����
				Toast.makeText(SelHaoYouActivity.this, "��������ʧ��", 0).show();
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
		setContentView(R.layout.activity_selhaoyou);
		getXinXi();
		findView();
		setadapter();
		//��ȡ�˵���Ϣ ������adpter
		getRen(selxinxi);
	}
	public void getXinXi(){
		Intent intent = this.getIntent();
		selxinxi=intent.getStringExtra("name");
	}
	public void findView(){
		listview = (ListView) this.findViewById(R.id.selhy_lv);
		listview.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Long myqqids = userlist.get(position).getQqId();
				Applications.setNeedid(Integer.parseInt(myqqids+""));
				Intent intent = new Intent(SelHaoYouActivity.this,HyUserZiliaoActivity.class);
				startActivity(intent);
			}
		});
		selhy_rl_tv1 = (TextView) this.findViewById(R.id.selhy_rl_tv1);
		selhy_rl_tv1.setOnClickListener(this);
		selhy_rl_ll_tv2 = (TextView) this.findViewById(R.id.selhy_rl_ll_tv2);
		selhy_rl_ll_tv2.setOnClickListener(this);
		selhy_rl_ll_ed = (EditText) this.findViewById(R.id.selhy_rl_ll_ed);
		selhy_rl_ll_ed.addTextChangedListener(this);
	}
	//����adapter
	public void setadapter(){
		hyapdater = new SelHyBaseApdater(this);
		hyapdater.setDate(userlist);
		listview.setAdapter(hyapdater);
	}
	//ˢ��
	public void notifyAdpter(){
		hyapdater.setDate(userlist);
		hyapdater.notifyDataSetChanged();
	}
	//���ݲ�����Ϣ������
	public void getRen(String xinxi){
		AsyncHttpClient client = new AsyncHttpClient();
		String uri =URI_IP.URI+"Android_Service/QQ/seluserlist";
		RequestParams params = new RequestParams();
		params.put("xinxi", xinxi);
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
					Gson gson = new Gson();
					AndroidQqUserList results = gson.fromJson(arg1.toString(), AndroidQqUserList.class);
					userlist=results.getQquser();//��ȡ���� �����롣����ȫ�Բ���
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
	@Override
	public void onClick(View v) {
		int id = v.getId();
		if(id == R.id.selhy_rl_tv1){
			finish();
		}else if(id ==R.id.selhy_rl_ll_tv2){//����
			getRen(xinselxinxi);
		}
	}
	@Override
	public void beforeTextChanged(CharSequence s, int start, int count, int after) {
		// TODO �Զ����ɵķ������
		
	}
	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {
		xinselxinxi = selhy_rl_ll_ed.getText().toString();
	}
	@Override
	public void afterTextChanged(Editable s) {
		// TODO �Զ����ɵķ������
		
	}

}

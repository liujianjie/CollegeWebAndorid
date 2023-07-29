package com.example.qq_lxr9y18r;

import java.util.ArrayList;
import java.util.List;

import com.example.qq_lxr9y18r.basadpter.AddHaoYouAdpdter;

import android.app.Activity;
import android.content.Intent;
import android.opengl.Visibility;
import android.os.Bundle;
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

public class AddHaoYouActivity extends Activity implements TextWatcher,OnClickListener{
	private EditText edit;
	private TextView quxiao;
	
	private List<String> list ;
	ListView  addhy_lv;
	String str;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);//无标题
		setContentView(R.layout.activity_addhaoyou);
		findView();
	}
	public void findView(){
		edit = (EditText) this.findViewById(R.id.addhy_rl_ed1);
		edit.addTextChangedListener(this);
		quxiao = (TextView) this.findViewById(R.id.addhy_rl_tv);
		quxiao.setOnClickListener(this);
		addhy_lv = (ListView) this.findViewById(R.id.addhy_lv);
		addhy_lv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				//str 跳转
				Intent intent = new Intent(AddHaoYouActivity.this,SelHaoYouActivity.class);
				intent.putExtra("name", str);
				startActivity(intent);
			}
		});
	}
	@Override
	public void beforeTextChanged(CharSequence s, int start, int count, int after) {
		// TODO 自动生成的方法存根
		
	}
	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {
		str = edit.getText().toString();
		if(!str.equals("")){
			list = new ArrayList<String>(2);
			list.add("找人:"+str);
			AddHaoYouAdpdter ap = new AddHaoYouAdpdter(this);
			ap.setDate(list);
			addhy_lv.setAdapter(ap);
		}else{
			list = new ArrayList<String>(0);
			AddHaoYouAdpdter ap = new AddHaoYouAdpdter(this);
			ap.setDate(list);
			addhy_lv.setAdapter(ap);
		}
	}
	@Override
	public void afterTextChanged(Editable s) {
		// TODO 自动生成的方法存根
		
	}
	@Override
	public void onClick(View v) {
		int id = v.getId();
		if(id==R.id.addhy_rl_tv){
			AddHaoYouActivity.this.finish();
		}
		
	}
	
}

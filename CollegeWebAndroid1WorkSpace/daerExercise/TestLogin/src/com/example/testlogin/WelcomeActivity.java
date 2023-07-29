package com.example.testlogin;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class WelcomeActivity extends Activity{
	private TextView wel_tx;
	private LinearLayout linear;
	private SharedPreferences spLogin;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);
		setTextToview();
		
		spLogin = getSharedPreferences("login", MODE_PRIVATE);
	}
	public void setTextToview(){
		wel_tx = findViewById(R.id.wel_tx);
		Intent in = getIntent();
		String name = in.getStringExtra("name");
		wel_tx.setText("欢迎您："+name+",登录成功");
		
		linear = findViewById(R.id.wel_linear);
		// 绑定菜单
		registerForContextMenu(linear);
	}
	// （4）创建选项菜单，可以注销登录和退出程序。
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		super.onCreateContextMenu(menu, v, menuInfo);
		
		MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.contextmenu, menu);
	}
	// 菜单点击事件
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
			case R.id.menu_zhuxiao:
				// 实现注销用户
				SharedPreferences.Editor edtLogin = spLogin.edit();
				edtLogin.putString("name", null);
				edtLogin.putString("pwd", null);
				edtLogin.putBoolean("isSave", false);
				edtLogin.putBoolean("isAuto", false);
				edtLogin.commit();
				
				Toast.makeText(this, "注销用户成功", Toast.LENGTH_SHORT).show();
				break;
			case R.id.menu_exit:
				// 退出
				finish();
				break;	
			default:
				break;
		}
		return super.onOptionsItemSelected(item);
	}
}

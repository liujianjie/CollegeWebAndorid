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
		wel_tx.setText("��ӭ����"+name+",��¼�ɹ�");
		
		linear = findViewById(R.id.wel_linear);
		// �󶨲˵�
		registerForContextMenu(linear);
	}
	// ��4������ѡ��˵�������ע����¼���˳�����
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		super.onCreateContextMenu(menu, v, menuInfo);
		
		MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.contextmenu, menu);
	}
	// �˵�����¼�
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
			case R.id.menu_zhuxiao:
				// ʵ��ע���û�
				SharedPreferences.Editor edtLogin = spLogin.edit();
				edtLogin.putString("name", null);
				edtLogin.putString("pwd", null);
				edtLogin.putBoolean("isSave", false);
				edtLogin.putBoolean("isAuto", false);
				edtLogin.commit();
				
				Toast.makeText(this, "ע���û��ɹ�", Toast.LENGTH_SHORT).show();
				break;
			case R.id.menu_exit:
				// �˳�
				finish();
				break;	
			default:
				break;
		}
		return super.onOptionsItemSelected(item);
	}
}

package com.example.testlogining;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnClickListener{
	private EditText edtName, edtPwd;
	private CheckBox ckbSave, ckbAuto;
	private Button btnLogin;
	private SharedPreferences spLogin, spAccess;
	private String sName, sPwd;
	private boolean bSave, bAuto;
	private int count;
	
	// welcome�����
	private TextView wel_tx;
	private LinearLayout linear;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		spLogin = getSharedPreferences("login", MODE_PRIVATE);
		spAccess = getSharedPreferences("access", MODE_PRIVATE);
		initView();
		getInfoTo();// ��shared�ж�ȡ��Ϣ��������
		showCount();// ��ʾ�ڼ��ε�¼
		selectUserInfo();// �Զ���ʾ֮ǰ�������Ϣ
		isAutoLogin();// �����¼ֱ�ӽ��뻶ӭҳ��
	}
	public void initView(){
		edtName = (EditText) findViewById(R.id.edt_name);
		edtPwd = (EditText) findViewById(R.id.edt_pwd);
		ckbSave = (CheckBox) findViewById(R.id.ckb_save);
		ckbAuto = (CheckBox) findViewById(R.id.ckb_auto);
		btnLogin = (Button) findViewById(R.id.btn_login);
		btnLogin.setOnClickListener(this);
	}
	// ��ȡ��Ϣ
	public void getInfoTo(){
		sName = spLogin.getString("name", null);
		sPwd = spLogin.getString("pwd", null);
		bSave = spLogin.getBoolean("isSave", false);
		bAuto = spLogin.getBoolean("isAuto", false);
		count = spAccess.getInt("count", 0);// ����һ�ν����ʱ���0
	}
	// ��1�������û��������룬������¼��ť����ת����ӭҳ�棬ͬʱ���û��������뱣�浽��ѡ���ļ�login�С�
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		sName = edtName.getText().toString();
		sPwd = edtPwd.getText().toString();
		bSave = ckbSave.isChecked();
		bAuto = ckbAuto.isChecked();
		
		SharedPreferences.Editor edtLogin = spLogin.edit();
		edtLogin.putString("name", sName);
		edtLogin.putString("pwd", sPwd);
		edtLogin.putBoolean("isSave", bSave);
		edtLogin.putBoolean("isAuto", bAuto);
		edtLogin.commit();
		
		Toast.makeText(this, "������ӭҳ��", Toast.LENGTH_SHORT).show();
		toWelcome();// ȥ��ӭҳ��
	}
	// ��2����ѡ�С���ס���롱��ѡ�����ٴν������ʱ�û�������������Զ���ʾ֮ǰ�������Ϣ�������������롣
	public void selectUserInfo(){
		if(bSave){
			edtName.setText(sName);
			edtPwd.setText(sPwd);
		}
		// ���ø�ѡ���Ƿ�ѡ��
		ckbSave.setChecked(bSave);
		ckbAuto.setChecked(bAuto);
	}
	// ��3����ѡ�С��Զ���¼����ѡ�����ٴν������ʱ�����¼ֱ�ӽ��뻶ӭҳ�档
	public void isAutoLogin(){
		if(bAuto){
			toWelcome();
		}
	}
	public void toWelcome(){
		setContentView(R.layout.activity_welcome);
		wel_tx = (TextView) findViewById(R.id.wel_tx);
		wel_tx.setText("��ӭ����"+sName+",��¼�ɹ�");
		
		linear = (LinearLayout) findViewById(R.id.wel_linear);
		// �󶨲˵�
		registerForContextMenu(linear);
	}
	
	// ��5��ÿ�ν�����򣬵����Ի�����ʾ���ʳ�����ܴ����������ݱ�������ѡ���ļ�access�С�
	public void showCount(){
		count++;// ��ǰ����Ĵ���
		// ��������ʾ
		Toast.makeText(this, "��ӭ��,���ǵ�"+count+"�η��ʣ�", Toast.LENGTH_SHORT).show();
		// �����±�����sharedPreference�ļ���
		SharedPreferences.Editor edtAcess = spAccess.edit();
		edtAcess.putInt("count", count);
		edtAcess.commit();
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

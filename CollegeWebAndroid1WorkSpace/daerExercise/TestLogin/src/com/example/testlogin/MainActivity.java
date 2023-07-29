package com.example.testlogin;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{
	private EditText edtName, edtPwd;
	private CheckBox ckbSave, ckbAuto;
	private Button btnLogin;
	private SharedPreferences spLogin, spAccess;
	private String sName, sPwd;
	private boolean bSave, bAuto;
	private int count;
	
	// welcome�����
	private TextView wel_tx;
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
		edtName = findViewById(R.id.edt_name);
		edtPwd = findViewById(R.id.edt_pwd);
		ckbSave = findViewById(R.id.ckb_save);
		ckbAuto = findViewById(R.id.ckb_auto);
		btnLogin = findViewById(R.id.btn_login);
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
		wel_tx = findViewById(R.id.wel_tx);
		wel_tx.setText("��ӭ����"+sName+",��¼�ɹ�");
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
}

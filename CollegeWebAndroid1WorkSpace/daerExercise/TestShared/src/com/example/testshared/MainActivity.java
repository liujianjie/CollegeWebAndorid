package com.example.testshared;


import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private EditText edtIn;
    private TextView tvOut;
    private Button btnWrite,btnRead;
    private CheckBox ckbBack;
    
    private SharedPreferences sp;
    SharedPreferences.Editor ed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        sp = this.getSharedPreferences("ys", MODE_PRIVATE);
        ed = sp.edit();
        boolean ischeck = sp.getBoolean("isBack", false);
        ckbBack.setChecked(ischeck);
        setBack(ischeck);
    }

    private void initView(){
        edtIn=findViewById(R.id.edt_in);
        tvOut=findViewById(R.id.tv_out);
        btnWrite=findViewById(R.id.btn_write);
        btnRead=findViewById(R.id.btn_read);
        ckbBack=findViewById(R.id.ckb_back);
        btnWrite.setOnClickListener(this);
        btnRead.setOnClickListener(this);
        ckbBack.setOnCheckedChangeListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_write:
                // TODO: ���༭�����������д����ѡ���ļ�(SharedPreferences)��
            	String it = edtIn.getText().toString();
            	ed.putString("test", it);
            	ed.commit();
                break;
            case R.id.btn_read:
                // TODO: ����ѡ���ļ�(SharedPreferences)�ж�ȡ������ʾ���ı�����
            	String it2 = sp.getString("test", null);
            	tvOut.setText(it2);
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        // TODO: ���ݱ�����ѡ���ѡ��״̬�޸��ı���ı�����ɫ����ѡ���ѡ��״̬��������ѡ���ļ�
        //  �����������ʱ�Զ�����״̬��Ϣ
    	setBack(isChecked);
    	ed.putBoolean("isBack", isChecked);
    	ed.commit();
    }
    
    public void setBack(boolean bln){
    	if(bln){
    		tvOut.setBackgroundColor(Color.GRAY);
    	}else{
    		tvOut.setBackgroundColor(Color.WHITE);
    	}
    		
    }
}

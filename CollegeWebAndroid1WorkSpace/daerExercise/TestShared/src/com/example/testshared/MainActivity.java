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
                // TODO: 将编辑框输入的内容写入首选项文件(SharedPreferences)中
            	String it = edtIn.getText().toString();
            	ed.putString("test", it);
            	ed.commit();
                break;
            case R.id.btn_read:
                // TODO: 从首选项文件(SharedPreferences)中读取数据显示在文本框中
            	String it2 = sp.getString("test", null);
            	tvOut.setText(it2);
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        // TODO: 依据背景复选框的选中状态修改文本框的背景颜色，复选框的选中状态保存至首选项文件
        //  并且在启动活动时自动加载状态信息
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

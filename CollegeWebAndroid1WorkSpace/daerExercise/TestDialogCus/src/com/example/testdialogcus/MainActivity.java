package com.example.testdialogcus;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {
    private Button btnAlert,btnSingle,btnList,btnDiy;
    private TextView tvShow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView(){
        btnAlert=findViewById(R.id.btn_alert);
        btnSingle=findViewById(R.id.btn_single);
        btnList=findViewById(R.id.btn_list);
        btnDiy=findViewById(R.id.btn_diy);
        tvShow=findViewById(R.id.tv_show);
        btnAlert.setOnClickListener(this);
        btnSingle.setOnClickListener(this);
        btnList.setOnClickListener(this);
        btnDiy.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_alert:

                break;
            case R.id.btn_single:

                break;
            case R.id.btn_list:

                break;
            case R.id.btn_diy:
            	Mydialog myd = new Mydialog(this, tvShow, tvShow.getText().toString());
            	myd.show();
                break;
        }
    }
}

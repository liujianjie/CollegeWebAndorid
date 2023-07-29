package com.example.administrator.myapplication;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText edtIn;
    private Button btnWrite, btnRead;
    private TextView tvOut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    private void initView(){
        edtIn = findViewById(R.id.edt_in);
        btnWrite = findViewById(R.id.btn_write);
        btnRead = findViewById(R.id.btn_read);
        tvOut = findViewById(R.id.tv_out);
        btnWrite.setOnClickListener(this);
        btnRead.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_write:
                // �����
                FileOutputStream fos;
                try{
                    fos = openFileOutput("test.txt",Context.MODE_PRIVATE);
                    String stIn = edtIn.getText().toString().trim();
                    byte byIn[] = stIn.getBytes();
                    fos.write(byIn);
                    fos.close();

                    Toast.makeText(this,"�ļ���ȡ�ɹ�",Toast.LENGTH_SHORT).show();;
                }catch (Exception e){
                    Toast.makeText(this,"�ļ���ȡʧ��",Toast.LENGTH_SHORT).show();;
                }
                break;
            case R.id.btn_read:
                // ������
                FileInputStream fis;
                try{
                    fis = openFileInput("test.txt");
                    byte[] buffer = new byte[fis.available()];
                    fis.read(buffer);
                    fis.close();
                    // �ֽ�����ת���ַ���
                    tvOut.setText(new String(buffer));
                    Toast.makeText(this,"��ȡ�ļ��ɹ�",Toast.LENGTH_SHORT).show();;
                }catch (Exception e){
                    Toast.makeText(this,"��ȡ�ļ�ʧ��",Toast.LENGTH_SHORT).show();;
                }
                break;
        }
    }
}

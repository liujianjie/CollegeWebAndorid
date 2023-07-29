package com.example.sixteentask;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{
    private MyHelper dbHelper;
    private SQLiteDatabase db;
    private EditText txuser, txpwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new MyHelper(this, "db_stu2", null, 1);
        db = dbHelper.getWritableDatabase();// 创建数据库 并且创建了表
        findView();
    }
    protected  void findView(){
        txuser = (EditText)findViewById(R.id.tx_user);
        txpwd = (EditText)findViewById(R.id.tx_pwd);

    }
}

package com.example.fourteenone;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{
    private Button btncreate, btnupdgrade;
    private MyHelper dbHelper;
    private SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btncreate = (Button)findViewById(R.id.btn_create);
        btnupdgrade = (Button)findViewById(R.id.btn_updgrade);
        btncreate.setOnClickListener(this);
        btnupdgrade.setOnClickListener(this);
    }
    // 创建数据库
    protected  void createData(){
        // 实例化
        dbHelper = new MyHelper(this, "db_test", null, 1);
        db = dbHelper.getWritableDatabase();//获取数据库对象
    }
    // 升级数据库
    protected  void updData(){
        dbHelper = new MyHelper(this, "db_test", null, 2);
        db = dbHelper.getWritableDatabase();//获取数据库对象
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_create:
                createData();
                break;
            case R.id.btn_updgrade:
                updData();
                break;
        }
    }
}

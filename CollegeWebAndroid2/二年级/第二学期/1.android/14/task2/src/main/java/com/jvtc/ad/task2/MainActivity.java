package com.jvtc.ad.task2;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private MyHelper dbHelper;
    private SQLiteDatabase db;
    private EditText txuser, txpwd;
    private Button btreg,btlog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new MyHelper(this, "db_stu", null, 1);
        db = dbHelper.getWritableDatabase();// 创建数据库 并且创建了表
        findView();
    }
    protected  void findView(){
        txuser = (EditText)findViewById(R.id.tx_user);
        txpwd = (EditText)findViewById(R.id.tx_pwd);
        btreg = (Button)findViewById(R.id.bt_reg);
        btlog = (Button)findViewById(R.id.bt_log);

        btreg.setOnClickListener(this);
        btlog.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        String stName = txuser.getText().toString();
        String stPwd = txpwd.getText().toString();
        if(stName.equals("") || stPwd.equals("") || stName.equals("请输入用户名") || stPwd.equals("请输入用户名")){
            Toast.makeText(MainActivity.this, "用户名和密码不能位空",Toast.LENGTH_SHORT).show();
            return;
        }
        switch (v.getId()){
            case R.id.bt_reg:
                String stSql = "insert into user(name, pwd) values('"+stName+"','"+stPwd+"')";
                //db执行sql语句
                db.execSQL(stSql);
                Toast.makeText(MainActivity.this, "注册成功",Toast.LENGTH_SHORT).show();
                txuser.setText("");
                txpwd.setText("");
                break;
            case R.id.bt_log:
                // 根据输入的用户名与密码与数据库匹配，若有一条数据就登录成功，否则失败
                Cursor c = db.rawQuery("select * from user where name=? and pwd=?", new String[]{stName, stPwd});
                if(c.moveToFirst()){
                    Toast.makeText(MainActivity.this, "登录成功",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "登录失败",Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}

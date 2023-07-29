package com.android.musicman;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity implements View.OnClickListener {

    private EditText field_username;
    private EditText field_password;
    private Button btn_login;
    private Button btn_register;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        initView();

        dbHelper = new DBHelper(this);

    }

    private void initView() {
        field_username = (EditText) findViewById(R.id.field_username);
        field_password = (EditText) findViewById(R.id.field_password);
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_register = (Button) findViewById(R.id.btn_register);

        btn_login.setOnClickListener(this);
        btn_register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:

                login();

                break;
            case R.id.btn_register:

                startActivity(new Intent(this, RegisterActivity.class));

                break;
        }
    }

    private void login() {
        // validate
        String username = field_username.getText().toString().trim();
        if (TextUtils.isEmpty(username)) {
            Toast.makeText(this, "请输入电话", Toast.LENGTH_SHORT).show();
            return;
        }

        String password = field_password.getText().toString().trim();
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
            return;
        }

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String sql = "select * from userinformation where telphone=? and pwd=?";
        Cursor cursor = db.rawQuery(sql, new String[]{username, password});

        if (cursor.moveToNext()) {
            Toast.makeText(LoginActivity.this, "成功", Toast.LENGTH_SHORT).show();

            Intent intent1 = new Intent(LoginActivity.this, MainActivity.class);
            intent1.putExtra("nickname", cursor.getString(cursor.getColumnIndex("nickname")));
            startActivity(intent1);
            cursor.close();


        } else {
            Toast.makeText(LoginActivity.this, "用户名或者密码错误", Toast.LENGTH_SHORT).show();

        }
        db.close();


    }
}

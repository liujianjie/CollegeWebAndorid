package com.android.musicman;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends Activity implements View.OnClickListener {

    private EditText field_username;
    private EditText field_password;
    private EditText field_nick;
    private EditText field_sex;
    private Button btn_register;
    private Button btn_login;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_register);
        initView();

        dbHelper = new DBHelper(this);
    }

    private void initView() {
        field_username = (EditText) findViewById(R.id.field_username);
        field_password = (EditText) findViewById(R.id.field_password);
        field_nick = (EditText) findViewById(R.id.field_nick);
        field_sex = (EditText) findViewById(R.id.field_sex);
        btn_register = (Button) findViewById(R.id.btn_register);
        btn_login = (Button) findViewById(R.id.btn_login);

        btn_register.setOnClickListener(this);
        btn_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_register:

                register();

                break;
            case R.id.btn_login:

                finish();

                break;
        }
    }

    private void register() {
        // validate
        String username = field_username.getText().toString().trim();
        if (TextUtils.isEmpty(username)) {
            Toast.makeText(this, "电话", Toast.LENGTH_SHORT).show();
            return;
        }

        String password = field_password.getText().toString().trim();
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "密码", Toast.LENGTH_SHORT).show();
            return;
        }

        String nick = field_nick.getText().toString().trim();
        if (TextUtils.isEmpty(nick)) {
            Toast.makeText(this, "昵称", Toast.LENGTH_SHORT).show();
            return;
        }
        String sex = field_sex.getText().toString().trim();


        if (check(username)) {
            Toast.makeText(RegisterActivity.this, "该手机已注册", Toast.LENGTH_SHORT).show();
            return;
        }

        ContentValues contentValues = new ContentValues();
        contentValues.put("telphone", username);
        contentValues.put("pwd", password);
        contentValues.put("nickname", nick);
        contentValues.put("sex", sex);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.insert("userinformation", null, contentValues);
        db.close();
        Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
        finish();

    }

    public boolean check(String telphone) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String sql = "select * from userinformation where telphone=?";
        Cursor cursor = db.rawQuery(sql, new String[]{telphone});
        if (cursor.getCount() != 0) {
            cursor.close();
            return true;
        }
        return false;
    }
}

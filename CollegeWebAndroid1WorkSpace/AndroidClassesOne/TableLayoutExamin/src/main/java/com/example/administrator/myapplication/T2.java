package com.example.administrator.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T2 extends AppCompatActivity {

    private TextView tvar[][] = new TextView[5][2];
    private List<Map<String,String>> li = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t2);
        findView();
        giveval();
        settvview();
    }
    private void findView(){
        int tvidar[][]={{R.id.tv00,R.id.tv01},{R.id.tv10,R.id.tv11},{R.id.tv20,R.id.tv21},{R.id.tv30,R.id.tv31},{R.id.tv40,R.id.tv41}};
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 2; j++){
                tvar[i][j] =  (TextView)findViewById(tvidar[i][j]);
            }
        }
    }
    private void giveval(){
        String strval[][] = {{"Android程序设计","85"},{"JAVA程序设计","98"},{"JS程序设计","76"},{"体育与健康","60"},{"毛概","100"}};
        for(int i = 0; i < 5; i++){
            Map<String,String> map = new HashMap<>();
            map.put("km",strval[i][0]);
            map.put("cj",strval[i][1]);
            li.add(map);
        }
    }
    private void settvview(){
        // 再给控件
        for(int i = 0; i < 5; i++){
            tvar[i][0].setText(li.get(i).get("km"));
            tvar[i][1].setText(li.get(i).get("cj"));
        }
    }
}

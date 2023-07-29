package com.example.orderdish;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button order,add;
    private Spinner sp1,sp2,sp3,sp4;
    private EditText ed1,ed2,ed3,ipt1;
    //
    List<String> li1 = new ArrayList<String>();
    List<String> li2 = new ArrayList<String>();
    List<String> li3 = new ArrayList<String>();
    List<String> li4 = new ArrayList<String>();

    ArrayAdapter<String> ad1;
    ArrayAdapter<String> ad2;
    ArrayAdapter<String> ad3;
    ArrayAdapter<String> ad4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        find();
        shuju();
        addlis();
    }
    private void shuju(){
        li1.add("红烧排骨");
        li1.add("九江鱼块");
        li1.add("小炒肉");;
        li1.add("爆炒猪肝");;
        li1.add("干锅花菜");

        li2.add("酸菜土豆丝");
        li2.add("清炒时蔬");
        li2.add("油淋生菜");
        li2.add("鱼香茄子");

        li3.add("猪肝汤");
        li3.add("青菜汤");
        li3.add("紫菜蛋汤");

        li4.add("荤菜");
        li4.add("素菜");
        li4.add("配汤");

        ad1 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,li1);
        ad2 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,li2);
        ad3 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,li3);
        ad4 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,li4);

        sp1.setAdapter(ad1);
        sp2.setAdapter(ad2);
        sp3.setAdapter(ad3);
        sp4.setAdapter(ad4);
    }
    private void find(){
        order = (Button) findViewById(R.id.order);
        add = (Button) findViewById(R.id.add);
        sp1 = (Spinner) findViewById(R.id.sp1);
        sp2 = (Spinner) findViewById(R.id.sp2);
        sp3 = (Spinner) findViewById(R.id.sp3);
        sp4 = (Spinner) findViewById(R.id.sp4);
        ed1 = (EditText) findViewById(R.id.yxtv1);
        ed2 = (EditText) findViewById(R.id.yxtv2);
        ed3 = (EditText) findViewById(R.id.yxtv3);
        ipt1 = (EditText) findViewById(R.id.ipt1);

    }
    private void addlis(){
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v == add){
                    int mode = sp4.getSelectedItemPosition();

                    String news = ipt1.getText().toString();
                    if(!news.equals("")){
                        switch (mode){
                            case 0:
                                if(!li1.contains(news)){
                                    li1.add(news);
                                }else{
                                    Toast.makeText(MainActivity.this,"已存在",Toast.LENGTH_SHORT).show();
                                }
                                break;
                            case 1:
                                if(!li2.contains(news)){
                                    li2.add(news);
                                }else{
                                    Toast.makeText(MainActivity.this,"已存在",Toast.LENGTH_SHORT).show();
                                }
                                break;
                            case 2:
                                if(!li3.contains(news)){
                                    li3.add(news);
                                }else{
                                    Toast.makeText(MainActivity.this,"已存在",Toast.LENGTH_SHORT).show();
                                }
                                break;
                        }
                    }else {
                        Toast.makeText(MainActivity.this,"不能为空",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        order.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(v == order){
                    ed1.setText(sp1.getSelectedItem().toString());
                    ed2.setText(sp2.getSelectedItem().toString());
                    ed3.setText(sp3.getSelectedItem().toString());
                }
            }
        });
    }

}

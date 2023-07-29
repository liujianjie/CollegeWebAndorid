package com.example.administrator.testscrollandhor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private ListView listview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
    }
    public void findView(){
        listview = (ListView)this.findViewById(R.id.listView1);
        //baseadapter
        TestBaseApdater ap = new TestBaseApdater(this, R.layout.item);
        listview.setAdapter(ap);
    }
}

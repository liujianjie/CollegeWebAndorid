package com.example.test5frg;

import java.util.Random;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends FragmentActivity  implements OnClickListener{
	AFragment afrg;
	BFragment bfrg;
	CFragment cfrg;
	DFragment dfrg;
	
	Button btn1, btn2;
	
	Random ran = new Random();
	Fragment fragarr[] = new Fragment[4];// 碎片数组
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initFrag();
		initView();
	}
	void initFrag(){
		afrg = new AFragment();
		bfrg = new BFragment();
		cfrg = new CFragment();
		dfrg = new DFragment();
		fragarr[0] = afrg;
		fragarr[1] = bfrg;
		fragarr[2] = cfrg;
		fragarr[3] = dfrg;
	}
	void initView()
	{
		btn1 = findViewById(R.id.main_bt1);
		
		btn1.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View arg0) {
		FragmentManager fragmanager = getSupportFragmentManager();
		FragmentTransaction fragtrans = fragmanager.beginTransaction();
		// TODO Auto-generated method stub
		fragtrans.replace(R.id.main_fraglayout,fragarr[ran.nextInt(fragarr.length)]);// 使用随机数实现随机碎片
		
		fragtrans.commit();
	}
}

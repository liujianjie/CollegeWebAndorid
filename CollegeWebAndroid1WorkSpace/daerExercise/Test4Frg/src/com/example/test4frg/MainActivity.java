package com.example.test4frg;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends FragmentActivity implements OnClickListener{

	AFragment afrg;
	BFragment bfrg;
	
	Button btn1, btn2;
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
	}
	void initView()
	{
		btn1 = findViewById(R.id.main_bt1);
		btn2 = findViewById(R.id.main_bt2);
		
		btn1.setOnClickListener(this);
		btn2.setOnClickListener(this);
	}
	@Override
	public void onClick(View arg0) {
		FragmentManager fragmanager = getSupportFragmentManager();
		FragmentTransaction fragtrans = fragmanager.beginTransaction();
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
			case R.id.main_bt1:
				fragtrans.replace(R.id.main_fraglayout, new AFragment());
				break;
			case R.id.main_bt2:
				fragtrans.replace(R.id.main_fraglayout, bfrg);
				break;
			default:
				break;
		}
		fragtrans.commit();
	}
	
}

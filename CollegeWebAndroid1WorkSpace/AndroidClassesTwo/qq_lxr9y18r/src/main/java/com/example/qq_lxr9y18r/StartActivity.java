package com.example.qq_lxr9y18r;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

public class StartActivity extends Activity{
	private Intent intent;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);//无标题
		setContentView(R.layout.activity_start);
		//LoginActivity  HttpClientgetActivity	HttpClientkuanjiaActivity  HttpClientpostActivity
		intent= new Intent(StartActivity.this,LoginActivity.class);
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {  
		    @Override  
		    public void run() {   
		    	startActivity(intent); //执行  
		    	finish();
		    } 
		 };
		 timer.schedule(task, 1000 * 1); //10秒后
	}
}

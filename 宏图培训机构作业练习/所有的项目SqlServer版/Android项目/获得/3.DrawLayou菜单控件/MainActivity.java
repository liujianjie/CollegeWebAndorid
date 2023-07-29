package com.example.viewpagers;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.DrawerLayout.DrawerListener;
import android.view.View;

public class MainActivity extends Activity{	
	
	DrawerLayout layout;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		layout = (DrawerLayout) this.findViewById(R.id.drlayout);
		layout.setDrawerListener(new DrawerListener() {
			@Override  
            public void onDrawerStateChanged(int newState) {  
                // 状态改变时回调  
                  
            }  
              
            @Override  
            public void onDrawerSlide(View drawerView, float slideOffset) {  
                // 滑动时不断的回调  
                // 在这里可以实现很多功能 比如说菜单的缩放  
            }  
              
            @Override  
            public void onDrawerOpened(View drawerView) {  
                // 打开  
                  
            }  
              
            @Override  
            public void onDrawerClosed(View drawerView) {  
                // 关闭  
                  
            } 
		});
	}
}
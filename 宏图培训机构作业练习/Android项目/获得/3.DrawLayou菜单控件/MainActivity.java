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
		// TODO �Զ����ɵķ������
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		layout = (DrawerLayout) this.findViewById(R.id.drlayout);
		layout.setDrawerListener(new DrawerListener() {
			@Override  
            public void onDrawerStateChanged(int newState) {  
                // ״̬�ı�ʱ�ص�  
                  
            }  
              
            @Override  
            public void onDrawerSlide(View drawerView, float slideOffset) {  
                // ����ʱ���ϵĻص�  
                // ���������ʵ�ֺܶ๦�� ����˵�˵�������  
            }  
              
            @Override  
            public void onDrawerOpened(View drawerView) {  
                // ��  
                  
            }  
              
            @Override  
            public void onDrawerClosed(View drawerView) {  
                // �ر�  
                  
            } 
		});
	}
}
package com.example.testmenu;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
	TextView tvShow;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		
		FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.fab);
		fab.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
			}
		});
		tvShow = (TextView)findViewById(R.id.tv_show);
		tvShow.setTextColor(Color.RED);
		registerForContextMenu(tvShow);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// 
		int id = item.getItemId();
		switch (id) {
			case R.id.action_fes:
				Toast.makeText(MainActivity.this, "节日", Toast.LENGTH_SHORT).show();
			
			break;
			case R.id.action_delete:
				Toast.makeText(MainActivity.this, "删除", Toast.LENGTH_SHORT).show();
			
			break;
			case R.id.action_settings:
				Toast.makeText(MainActivity.this, "设置", Toast.LENGTH_SHORT).show();
			
			break;
			case R.id.action_red:
				Toast.makeText(MainActivity.this, "红色", Toast.LENGTH_SHORT).show();
				tvShow.setTextColor(Color.RED);
				item.setCheckable(true);
			break;
			case R.id.action_blue:
				Toast.makeText(MainActivity.this, "蓝色", Toast.LENGTH_SHORT).show();
				tvShow.setTextColor(Color.BLUE);
				item.setCheckable(true);
			break;	
			case R.id.action_green:
				Toast.makeText(MainActivity.this, "绿色", Toast.LENGTH_SHORT).show();
				tvShow.setTextColor(Color.GREEN);
				item.setCheckable(true);
			break;			
		default:
			break;
		}
		return true;
	}
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {

		getMenuInflater().inflate(R.menu.context_tvshow, menu);
		super.onCreateContextMenu(menu, v, menuInfo);
	}
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.action_1:
			Toast.makeText(MainActivity.this, "菜单一", Toast.LENGTH_SHORT).show();
			break;
		case R.id.action_2:
			Toast.makeText(MainActivity.this, "菜单二", Toast.LENGTH_SHORT).show();
			break;	
		default:
			break;
		}
		return true;
	}
}

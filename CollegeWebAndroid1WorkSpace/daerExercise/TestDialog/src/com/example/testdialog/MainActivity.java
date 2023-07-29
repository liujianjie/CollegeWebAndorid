package com.example.testdialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.text.AlteredCharSequence;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{
	TextView tvshow;
	Button bt1, bt2, bt3, bt4, bt5;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findTag();
	}
	void findTag(){
		tvshow = findViewById(R.id.tv_show);
		bt1 = findViewById(R.id.btn1);
		bt2 = findViewById(R.id.btn2);
		bt3 = findViewById(R.id.btn3);
		bt4 = findViewById(R.id.btn4);
		bt5 = findViewById(R.id.btn5);
		
		bt1.setOnClickListener(this);
		bt2.setOnClickListener(this);
		bt3.setOnClickListener(this);
		bt4.setOnClickListener(this);
		bt5.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
			case  R.id.btn1:
				createconfirmDialog();
			break;
			case  R.id.btn2:
				createSingleChoiceDialog();
				break;
			case  R.id.btn3:
				createItemsDialog();
				break;
			case  R.id.btn4:
				createCustomsDialog();
				break;
			case R.id.btn5:
				creatStateDialog();
				break;
		default:
			break;
		}
	}
	// 创建对话框
	public void createconfirmDialog(){
		AlertDialog.Builder di = new AlertDialog.Builder(this);
		di.setTitle("确定退出？");
		di.setIcon(R.drawable.exit);
		di.setMessage("你确定退出程序吗？");
		di.setPositiveButton("确定", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				// TODO Auto-generated method stub
				tvshow.setText("单击了确定按钮");
			}
		});
		di.setNegativeButton("取消", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				// TODO Auto-generated method stub
				tvshow.setText("单击了取消按钮");
			}
		});
		di.create().show();
	}
	int idex;
	int Colorarr[] = {Color.RED, Color.YELLOW, Color.BLUE, Color.GREEN};
	// 单选对话框
	public void createSingleChoiceDialog(){
		String stitems[] = {"红色","黄色","蓝色","绿色"};
		AlertDialog.Builder dis = new AlertDialog.Builder(this);
		dis.setTitle("设置字体颜色");
		dis.setSingleChoiceItems(stitems, idex, new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface arg0, int which) {
				// TODO Auto-generated method stub
				idex = which;
			}
		});
		dis.setPositiveButton("确定", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				// TODO Auto-generated method stub
				tvshow.setTextColor(Colorarr[idex]);
			}
		});
		dis.create().show();
	}
	// 列表对话框
	public void createItemsDialog(){
		String stitems[] = {"列表1","列表2","列表3","列表4"};
		AlertDialog.Builder dis = new AlertDialog.Builder(this);
		dis.setTitle("列表对话框");
		dis.setItems(stitems, new DialogInterface.OnClickListener(){
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "选择列表", 300).show();;
			}
		});
		dis.show();
	}
	// 自定义对话框
	public void createCustomsDialog(){
		final Dialog dis = new Dialog(this);
		dis.requestWindowFeature(Window.FEATURE_NO_TITLE);
		dis.setContentView(R.layout.confirm_dialog);
		Button cfbt = dis.findViewById(R.id.confirmbt);
		Button cabt = dis.findViewById(R.id.cancelbt);
		cfbt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				dis.dismiss();
			}
		});
		cabt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				dis.dismiss();
			}
		});
		dis.show();
	}
	
	/* 练习QQ状态代码开始 */
	// 加载自定义输入的QQ状态对话框
	public void createCustomState(){
		// 先加载自定义的布局文件
		View newview = LayoutInflater.from(this).inflate(R.layout.instate_dialog, null, false);
		AlertDialog.Builder dialog = new AlertDialog.Builder(this);
		dialog.setTitle("请输入你的状态");
		dialog.setView(newview);
		
		// 设置监听的东西
		final EditText ed = newview.findViewById(R.id.state_edit);
		dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				// TODO Auto-generated method stub
				if(!ed.getText().toString().equals("")){
					tvshow.setText(ed.getText().toString());
				}
			}
		});
		dialog.create().show();
	}
	AlertDialog dia = null;
	int stateidex;
	String stitems[] = {"在线","隐身","离开","忙绿","离线","其它"};
	// 状态选择框
	public void creatStateDialog(){
		// 先给予单选项
		final AlertDialog.Builder dis = new AlertDialog.Builder(this);
		
		dis.setTitle("请选择您的状态");
		dis.setSingleChoiceItems(stitems, stateidex, new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface arg0, int which) {
				// TODO Auto-generated method stub
				if(which != stitems.length - 1){
					stateidex = which;
				}else{
					// 关闭 当前对话框
					dia.dismiss();
					// 出现新对话框
					createCustomState();
				}
			}
		});
		dis.setPositiveButton("确定", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				// TODO Auto-generated method stub
				tvshow.setText(stitems[stateidex]);
			}
		});
		dia = dis.create();
		dia.show();
		
		
	}
	/* 练习QQ状态代码结束 */
}

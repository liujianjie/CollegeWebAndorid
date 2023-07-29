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
	// �����Ի���
	public void createconfirmDialog(){
		AlertDialog.Builder di = new AlertDialog.Builder(this);
		di.setTitle("ȷ���˳���");
		di.setIcon(R.drawable.exit);
		di.setMessage("��ȷ���˳�������");
		di.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				// TODO Auto-generated method stub
				tvshow.setText("������ȷ����ť");
			}
		});
		di.setNegativeButton("ȡ��", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				// TODO Auto-generated method stub
				tvshow.setText("������ȡ����ť");
			}
		});
		di.create().show();
	}
	int idex;
	int Colorarr[] = {Color.RED, Color.YELLOW, Color.BLUE, Color.GREEN};
	// ��ѡ�Ի���
	public void createSingleChoiceDialog(){
		String stitems[] = {"��ɫ","��ɫ","��ɫ","��ɫ"};
		AlertDialog.Builder dis = new AlertDialog.Builder(this);
		dis.setTitle("����������ɫ");
		dis.setSingleChoiceItems(stitems, idex, new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface arg0, int which) {
				// TODO Auto-generated method stub
				idex = which;
			}
		});
		dis.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				// TODO Auto-generated method stub
				tvshow.setTextColor(Colorarr[idex]);
			}
		});
		dis.create().show();
	}
	// �б�Ի���
	public void createItemsDialog(){
		String stitems[] = {"�б�1","�б�2","�б�3","�б�4"};
		AlertDialog.Builder dis = new AlertDialog.Builder(this);
		dis.setTitle("�б�Ի���");
		dis.setItems(stitems, new DialogInterface.OnClickListener(){
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "ѡ���б�", 300).show();;
			}
		});
		dis.show();
	}
	// �Զ���Ի���
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
	
	/* ��ϰQQ״̬���뿪ʼ */
	// �����Զ��������QQ״̬�Ի���
	public void createCustomState(){
		// �ȼ����Զ���Ĳ����ļ�
		View newview = LayoutInflater.from(this).inflate(R.layout.instate_dialog, null, false);
		AlertDialog.Builder dialog = new AlertDialog.Builder(this);
		dialog.setTitle("���������״̬");
		dialog.setView(newview);
		
		// ���ü����Ķ���
		final EditText ed = newview.findViewById(R.id.state_edit);
		dialog.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {
			
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
	String stitems[] = {"����","����","�뿪","æ��","����","����"};
	// ״̬ѡ���
	public void creatStateDialog(){
		// �ȸ��赥ѡ��
		final AlertDialog.Builder dis = new AlertDialog.Builder(this);
		
		dis.setTitle("��ѡ������״̬");
		dis.setSingleChoiceItems(stitems, stateidex, new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface arg0, int which) {
				// TODO Auto-generated method stub
				if(which != stitems.length - 1){
					stateidex = which;
				}else{
					// �ر� ��ǰ�Ի���
					dia.dismiss();
					// �����¶Ի���
					createCustomState();
				}
			}
		});
		dis.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				// TODO Auto-generated method stub
				tvshow.setText(stitems[stateidex]);
			}
		});
		dia = dis.create();
		dia.show();
		
		
	}
	/* ��ϰQQ״̬������� */
}

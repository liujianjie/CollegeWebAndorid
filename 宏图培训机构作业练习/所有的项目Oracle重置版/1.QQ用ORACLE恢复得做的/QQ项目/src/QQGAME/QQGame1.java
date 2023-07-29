package QQGAME;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.sun.awt.AWTUtilities;

import QQ数据库信息.QQgame;
import QQ数据库信息.QQuser;

public class QQGame1 extends JFrame{
	int a=0;
	JLabel bg,title,dian1,dian2,dian3;
	QQgame qqgame;
	public QQGame1(QQgame myq){
		super();
		this.qqgame=myq;
		Container con=getContentPane();//不能有布局
		// 窗口图片
		setIconImage(new ImageIcon("gameimg/tubiao.jpg").getImage());
		this.setUndecorated(true);//无边框
		
		title=new JLabel("载入中");
		title.setFont(new Font("宋体",Font.BOLD,40));
		title.setForeground(new Color(192,192,192));
		title.setBounds(400,50,130,180);
		con.add(title);
		
		dian1=new JLabel(".");
		dian1.setFont(new Font("宋体",Font.BOLD,40));
		dian1.setForeground(new Color(192,192,192));
		dian1.setBounds(550,50,140,180);
		con.add(dian1);
		
		dian2=new JLabel();
		dian2.setFont(new Font("宋体",Font.BOLD,40));
		dian2.setForeground(new Color(192,192,192));
		dian2.setBounds(590,50,140,180);
		con.add(dian2);
		
		dian3=new JLabel();
		dian3.setFont(new Font("宋体",Font.BOLD,40));
		dian3.setForeground(new Color(192,192,192));
		dian3.setBounds(630,50,140,180);
		con.add(dian3);
		
		A a=new A();
		a.start();
		
		bg=new JLabel(new ImageIcon("gameimg/qqgame3.jpg"));
		con.add(bg);
		setSize(1024,576);
		setVisible(true);
		setLocationRelativeTo(null);
	}
	class A extends Thread{
		public void run() {
			// 通过循环更新任务完成百分比
			for (int i = 0; i <4; i++) {
				try {
					Thread.sleep(350);
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				dian2.setText(".");
				try {
					Thread.sleep(350);
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				dian3.setText(".");
				try {
					Thread.sleep(450);
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				dian3.setText("");
				dian2.setText("");
				//顺序背景图片
				String str[]={"gameimg/qqgame3.jpg","gameimg/qqgame2.jpg","gameimg/qqgame1.jpg"};
				if(a==0){
					bg.setIcon(new ImageIcon(str[0]));
				}
				if(a==1){
					bg.setIcon(new ImageIcon(str[1]));
					
				}
				if(a==2||a==3){
					bg.setIcon(new ImageIcon(str[2]));
	
				}
				a++;
			}
			//(窗口消失的方法)设置窗口的透明度
			for(int ii=100;ii>=0;ii--){
				//设置透明度，1~0之间，0就是透明了，看不到窗口
				AWTUtilities.setWindowOpacity(QQGame1.this, 0.01f*ii);
				try {
					Thread.sleep(30);
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}				
			}
			//这里结束
			QQGame1.this.dispose();
			new QQGame(qqgame);
		}
	}
	
	
	public static void main(String[] args) {
		//new QQGame1();
	}
}

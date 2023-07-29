package QQLGO;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import QQmain.qqmain;
import QQ数据库信息.QQuser;
import 接口.QQuserInterface;
import 方法实现接口.QQuserimp;

public class QQfind2 extends JFrame{
	JLabel close,biao,name,sheng,di,bg;
	JTextField names,years,month,day,country,province,city;
	JButton xia;
	QQuserInterface qserive=new QQuserimp();
	public QQfind2(){
		super("");
		Container con=getContentPane();
		//con.setLayout(null);
		this.setUndecorated(true);//无边框
		//设置界面可以拖动的方法
		setDragable();
		
		con.setBackground(new Color(255,255,255));
		
		biao=new JLabel("找回密码");
		biao.setBounds(150,40,150,30);
		biao.setFont(new Font("宋体",Font.BOLD,26));
		con.add(biao);
		
		close=new JLabel(new ImageIcon("img/close1.png"));
		close.setBounds(370,0,29,28);
		close.setCursor(new Cursor(Cursor.HAND_CURSOR));//手型
		con.add(close);
		
		name=new JLabel("姓名:");
		name.setBounds(70,120,50,30);
		name.setFont(new Font("宋体",Font.PLAIN,15));
		con.add(name);
		
		String str="你的真实姓名";
	//	Font f=new Font("宋体",Font.PLAIN,10);	
		names=new JTextField(str);
		names.setBounds(120,120,200,30);
		con.add(names);
		
		sheng=new JLabel("出生日期:");
		sheng.setBounds(40,200,100,30);
		sheng.setFont(new Font("宋体",Font.PLAIN,15));
		con.add(sheng);

		years=new JTextField("年");
		years.setBounds(120,200,60,30);
		con.add(years);

		month=new JTextField("月");
		month.setBounds(190,200,60,30);
		con.add(month);
		
		day=new JTextField("日");
		day.setBounds(260,200,60,30);
		con.add(day);
		
		di=new JLabel("所在地:");
		di.setBounds(48,280,100,30);
		di.setFont(new Font("宋体",Font.PLAIN,15));
		con.add(di);

		country=new JTextField("国家");
		country.setBounds(120,280,60,30);
		con.add(country);

		province=new JTextField("省份");
		province.setBounds(190,280,60,30);
		con.add(province);
		
		city=new JTextField("城市");
		city.setBounds(260,280,60,30);
		con.add(city);
		
		xia=new JButton("下一步");
		xia.setBounds(150,380,120,30);
		con.add(xia);
		
		bg=new JLabel(new ImageIcon("img/zhuce2_副本.png"));
		con.add(bg);
		//监听
		xia.addMouseListener(new A());
		close.addMouseListener(new A());
		setSize(400,450);
		setVisible(true);
		setLocationRelativeTo(null);
	}

	
	
	class A extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {
			if(e.getSource()==close){//关闭
				dispose();	
			}
			if(e.getSource()==xia){
				QQuser quser=new QQuser();
				quser.setYears(years.getText().trim());//将文本框内容拿出来
				quser.setMonths(month.getText().trim());//将文本框内容拿出来
				quser.setDprivate(day.getText().trim());//将文本框内容拿出来
				quser.setCountry(country.getText().trim());//将文本框内容拿出来
				quser.setProvince(province.getText().trim());//将文本框内容拿出来
				quser.setCity(city.getText().trim());//将文本框内容拿出来
				QQuser qq=qserive.chkqqziliao(quser);//将值传入方法中 对比
				if(qq==null){
					JOptionPane.showMessageDialog(null, "用户信息不正确");
					return;
				}else{
					//信息正确
					JOptionPane.showMessageDialog(null, "你的密码为："+quser.getPwd()+"，请妥善保管！");
					QQfind2.this.dispose();
				}
			}
			
		}	
		public void mouseEntered(MouseEvent e){
			if(e.getSource()==close){
				close.setIcon(new ImageIcon("img/loginclose.png"));
				
			}
		}
		public void mouseExited(MouseEvent e){
			
			if(e.getSource()==close){
				close.setIcon(new ImageIcon("img/close1.png"));//原来的图片
				
			}
		}
	}	
	

	/***********/
	//设置界面可以拖动的方法
	
	Point loc = null;
	Point tmp = null;
	boolean isDragged = false;	
	private void setDragable() {
		this.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseReleased(java.awt.event.MouseEvent e) {
				isDragged = false;
				QQfind2.this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			public void mousePressed(java.awt.event.MouseEvent e) {
				tmp = new Point(e.getX(), e.getY());

				isDragged = true;
				QQfind2.this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		this.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
			public void mouseDragged(java.awt.event.MouseEvent e) {
				if (isDragged) {
					loc = new Point(QQfind2.this.getLocation().x + e.getX() - tmp.x,
							QQfind2.this.getLocation().y + e.getY() - tmp.y);
					QQfind2.this.setLocation(loc);
				}
			}
		});
	}
	/***********/	
}

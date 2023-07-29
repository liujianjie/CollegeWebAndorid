package QQLGO;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Font;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JPopupMenu;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import QQ数据库信息.Contants;
import QQ数据库信息.QQgame;
import QQ数据库信息.QQuser;
import QQ数据库信息.QQhistory;
import QQcloudlet.QQweiyun;
import 接口.QQuserInterface;
import 方法实现接口.QQuserimp;
import 注册类.注册窗口;

public class QQlogin extends JFrame{
	QQuserInterface qserive=new QQuserimp();
	JLabel xiao,close,bg,xia;
	JLabel zhu,wang,log,zt;//注册 忘记密码 记住密码 自动登入
	JComboBox t1;//文本宽
	JPasswordField p1;//密码
	JLabel face;//头像
	JCheckBox ch1,ch2;//复选框
	String str[];//账号框内容
	List list;
	JPopupMenu pop;//弹出式菜单
	JMenuItem it1,it2,it3,it4;
	
	public QQlogin(){
		super("");
		//设置组件样式
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf."
					+ "windows.WindowsLookAndFeel");
		} catch (Exception e) {
			
		}
				
		Container con=getContentPane();
		this.History();
		// 窗口图片
		setIconImage(new ImageIcon("img/touxiang1.png").getImage());
		this.setUndecorated(true);//无边框
		//设置界面可以拖动的方法
		setDragable();

		xiao=new JLabel();
		xiao.setBounds(370,0,29,28);
		con.add(xiao);
		xiao.setCursor(new Cursor(Cursor.HAND_CURSOR));//手型
		
		close=new JLabel();
		close.setBounds(400,0,29,28);
		con.add(close);
		close.setCursor(new Cursor(Cursor.HAND_CURSOR));//手型
		
		xia=new JLabel();
		xia.setBounds(340,0,29,28);
		con.add(xia);
		close.setCursor(new Cursor(Cursor.HAND_CURSOR));//手型
	
		//在线状态
		zt=new JLabel(new ImageIcon("img/s_online.png"));
		zt.setBounds(97,235,15,15);
		con.add(zt);
		
		face=new JLabel(new ImageIcon("img/touxiang1.png"));
		face.setBounds(50, 190, 60, 60);
		con.add(face);
		//弹出框
		pop=new JPopupMenu();
		it1=new JMenuItem("我在线上",new ImageIcon("img/s_online.png"));//我在线上
		it2=new JMenuItem("隐身",new ImageIcon("img/s_hide.png"));
		it3=new JMenuItem("忙碌",new ImageIcon("img/s_busy.png"));
		it4=new JMenuItem("离开",new ImageIcon("img/s_leave.png"));
		pop.add(it1);
		pop.addSeparator();
		pop.add(it2);
		pop.addSeparator();
		pop.add(it3);
		pop.addSeparator();
		pop.add(it4);
	
		t1=new JComboBox(str);
		t1.setBounds(135,190,190,20);
		con.add(t1);
		t1.setEditable(true);
		t1.setFont(new Font("",Font.PLAIN,14));
		
		
		p1=new JPasswordField();
		p1.setBounds(135, 215, 190, 20);
		con.add(p1);
		p1.setFont(new Font("",Font.PLAIN,14));
		
		
		//灰色
		Color myc=new Color(90,90,90);
		ch1=new JCheckBox("记住密码");
		ch1.setBounds(130, 235, 80, 20);
		ch1.setForeground(myc);
		con.add(ch1);
		
		ch2=new JCheckBox("自动登录");
		ch2.setBounds(255, 235, 80, 20);
		ch2.setForeground(myc);
		con.add(ch2);
		
		Color mycolor=new Color(15,177,255);//自定义颜色
		zhu=new JLabel("注册账号");
		zhu.setBounds(340, 190, 60, 20);
		con.add(zhu);
		zhu.setForeground(mycolor);
		zhu.setCursor(new Cursor(Cursor.HAND_CURSOR));//手
		
		wang=new JLabel("忘记密码");
		wang.setBounds(340, 215, 190, 20);
		con.add(wang);
		wang.setForeground(mycolor);
		wang.setCursor(new Cursor(Cursor.HAND_CURSOR));//手
		
		ImageIcon ima=new ImageIcon("img/login1.png");
		log=new JLabel(ima);
		log.setBounds(110, 255, 232, 40);
		con.add(log);
		
		//监听
		
		xiao.addMouseListener(new A());
		close.addMouseListener(new A());
		wang.addMouseListener(new A());
		xia.addMouseListener(new A());
		t1.addMouseListener(new A());
		p1.addMouseListener(new A());
		zhu.addMouseListener(new A());
		log.addMouseListener(new A());
		t1.addItemListener(new C());	
		zt.addMouseListener(new A());
		it1.addActionListener(new B());
		it2.addActionListener(new B());
		it3.addActionListener(new B());
		it4.addActionListener(new B());
		/* 背景图片 */
		ImageIcon images = new ImageIcon("img/bg3111.png");
		JLabel jl = new JLabel(images);// 图片标签
		con.add(jl);
		bg=new JLabel();
		setSize(430,310);
		setVisible(true);
		setLocationRelativeTo(null);
		//密码不为空
		pwdnonull();
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	class B implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==it1){//点击菜单项改变这个用户的状态
				//改变图片
				zt.setIcon(new ImageIcon("img/s_online.png"));
			//	qserive.updstate(qqnum, Contants.STATE_DownLINE);		
				
			}else if(e.getSource()==it2){
				zt.setIcon(new ImageIcon("img/s_hide.png"));
				
			}else if(e.getSource()==it3){
				zt.setIcon(new ImageIcon("img/s_busy.png"));
				
			}else if(e.getSource()==it4){
				zt.setIcon(new ImageIcon("img/s_leave.png"));
				
			}
		}
	}
	public void pwdnonull(){
		if(t1.getSelectedItem()==null){
			return;
		}
		String a=qserive.mimanull(t1.getSelectedItem().toString());
		if(a!=null){//密码不为空 就打印进去 并且 记住密码选中
			p1.setText(a);
			if(a.equals("")||a==null){
				ch1.setSelected(false);//选中
			}else{
				ch1.setSelected(true);//选中
			}
		}
	}
	class A extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {
			if(e.getSource()==zt){
				pop.show(zt, e.getX(), e.getY());
				
			}
			else if(e.getSource()==xiao){//最小化
				QQlogin.this.setExtendedState(QQlogin.this.ICONIFIED);//静态值
				
			}else if(e.getSource()==close){//关闭
				System.exit(0);
				
			}else if(e.getSource()==zhu){
				new 注册窗口();
				
			}else if(e.getSource()==wang){
				new QQfind();
			}else if(e.getSource()==log){
				if(t1.getSelectedItem().toString().trim().equals("")){//账号是否为空
					JOptionPane.showMessageDialog(null, "请您输入账号后再登录");
					t1.requestFocus();
					return;
				}else if(p1.getText().trim().equals("")){
					JOptionPane.showMessageDialog(null, "请您输入密码后再登录");
					p1.requestFocus();
					return;
				}
				//用户信息是否存在 
				QQuser quser=new QQuser();
				quser.setQqnum(t1.getSelectedItem().toString());//将文本框内容拿出来
				quser.setPwd(p1.getText());//密码
				QQuser qq=qserive.chkuser(quser);//将值传入方法中 对比
				if(qq==null){
					//登入失败 信息匹配不和
					JOptionPane.showMessageDialog(null, "你输入的账号或密码有误！登录失败");
					t1.requestFocus();
					return;
				}else{
				//登入成功
					//System.out.println("登入成功");
					//改变状态
					String path=zt.getIcon().toString();
					if(path.indexOf("online")>-1){//点击菜单项改变这个用户的状态
						qserive.updstate(quser.getQqnum(), Contants.on_line);
						//qq.setStatus(Contants.on_line);
						qserive.updstate(qq.getQqnum(),Contants.on_line);
						qq.setStatus(Contants.on_line);
					}else if(path.indexOf("hide")>-1){
						qserive.updstate(quser.getQqnum(), Contants.HIDE);
						//qq.setStatus(Contants.HIDE);
						qserive.updstate(qq.getQqnum(),Contants.HIDE);
						qq.setStatus(Contants.HIDE);
					}else if(path.indexOf("busy")>-1){
						qserive.updstate(quser.getQqnum(), Contants.busy);
						//qq.setStatus(Contants.busy);
						qserive.updstate(qq.getQqnum(),Contants.busy);
						qq.setStatus(Contants.busy);
					}else if(path.indexOf("leave")>-1){
						qserive.updstate(quser.getQqnum(), Contants.Off_line);
						//qq.setStatus(Contants.Off_line);
						qserive.updstate(qq.getQqnum(),Contants.Off_line);
						qq.setStatus(Contants.Off_line);
					}
					//qserive.upduserStatu(quser );
					//保存历史记录
					
					QQhistory qqh=new QQhistory();
					qqh.setQqnum(t1.getSelectedItem().toString());//qq号		
					if(ch1.isSelected()){//如果勾选了就保存密码
						qqh.setQqpwd(p1.getText());//密码
					}else{
						qqh.setQqpwd("");
					}
					
					qqh.setQqface(qq.getFace());//从原来的头像获取到历史头像
					qserive.addhistory(qqh);//添加到历史记录
					//-------游戏记录
					QQgame qqgame=new QQgame();
					qqgame.setQqnum(t1.getSelectedItem().toString());//将文本框内容拿出来就是QQ号
					//微云
					QQweiyun wy=new QQweiyun();
					wy.setQqnum(t1.getSelectedItem().toString());//将文本框内容拿出来就是QQ号
					try {
						new QQloginin(qq,qqgame);
					} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
							| UnsupportedLookAndFeelException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}
					QQlogin.this.dispose();//关闭登入
					
				}	
			}
		}
		public void mouseEntered(MouseEvent e){
			if(e.getSource()==xiao){
				xiao.setIcon(new ImageIcon("img/loginxiao.png"));
				
			}
			if(e.getSource()==close){
				close.setIcon(new ImageIcon("img/loginclose.png"));
				
			}
			if(e.getSource()==xia){
				xia.setIcon(new ImageIcon("img/loginxia.png"));
				
			}
		}
		public void mouseExited(MouseEvent e){
			if(e.getSource()==xiao){
				xiao.setIcon(new ImageIcon(""));//空为原来的图片
				
			}
			
			if(e.getSource()==close){
				close.setIcon(new ImageIcon(""));
				
			}
			if(e.getSource()==xia){
				xia.setIcon(new ImageIcon(""));
				
			}
		}
		
	}
	
	class C implements ItemListener{
		public void itemStateChanged(ItemEvent e) {
			int index=t1.getSelectedIndex();
			if(index<0){//防止报错
				return;
			}
			QQhistory qqh=(QQhistory)list.get(index);//历史下标
			p1.setText(qqh.getQqpwd());//获取密码
			face.setIcon(new ImageIcon(qqh.getQqface()));//获取头像
			if(!qqh.getQqpwd().equals("")){//不为空
				ch1.setSelected(true);//选中
			}else{
				ch1.setSelected(false);
			}
		}
	}
	
	//给文本框赋值
	public void History(){
		list=qserive.selhi();
		str=new String[list.size()];//大小
		for(int i=0;i<list.size();i++){
			QQhistory qqh=(QQhistory)list.get(i);//第一列
			str[i]=qqh.getQqnum();//赋值QQ号
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
				QQlogin.this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			public void mousePressed(java.awt.event.MouseEvent e) {
				tmp = new Point(e.getX(), e.getY());

				isDragged = true;
				QQlogin.this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		this.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
			public void mouseDragged(java.awt.event.MouseEvent e) {
				if (isDragged) {
					loc = new Point(QQlogin.this.getLocation().x + e.getX() - tmp.x,
							QQlogin.this.getLocation().y + e.getY() - tmp.y);
					QQlogin.this.setLocation(loc);
				}
			}
		});
	}
	/**
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException *********/
	public static void main(String[] args){
		new QQlogin();
	}
}

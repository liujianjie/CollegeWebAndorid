package QQGAME;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import QQ数据库信息.QQGAME;
import QQ数据库信息.QQuser;
import 接口.QQuserInterface;
import 推箱子.*;
import 方法实现接口.QQuserimp;
import QQGAME.Test而已;
import QQGAME.dzgame;
import QQGAME.GameApp;
	//布局是个问题
	public class paihangbang  extends JFrame{
		JLabel xiao,close,tubiao1,tubiao2,nitu,wangguo,caini,geren,shu,shu1,zhu,bg;//图片标签
		JLabel qname,xxk,xxk1,xxk2,xxk3,xxk4,xxk5,xxk6,xxk7,xxk8,xxk9,xxk10,xxk11,xxk12;//昵称标签,选项卡
		JLabel hengg,weizhi,weizhitishi,weizhitishi2;
		JLabel yxtu,yxtishi,yxtishi2,yxtishi3,yxstart,yxpaihangbang;
		JPanel p1,p2,p3,p4;
		static QQGAME qquser;
		QQuserInterface qservice=new QQuserimp();//返回蛇的分数和昵称
		Vector<Vector> vv=new Vector<Vector>();
		Vector tilte,datas;//标题 数据
		DefaultTableModel tab;
		JTable table;
		public paihangbang(QQGAME qquser){
			super();
			this.qquser=qquser;
			//设置组件样式
			try {
				UIManager.setLookAndFeel("com.sun.java.swing.plaf."
						+ "windows.WindowsLookAndFeel");
			} catch (Exception e) {
				
			}
			Container con=getContentPane();//不能有布局
		//	con.setLayout(null);
			con.setBackground(new Color(249,249,249));
			// 窗口图片
			setIconImage(new ImageIcon("img/tubiao.jpg").getImage());
			this.setUndecorated(true);//无边框
			//设置界面可以拖动的方法
			setDragable();
			
			xiao=new JLabel(new ImageIcon("img/xiao1.png"));
			xiao.setBounds(740, 0, 29, 28);
			con.add(xiao);
			xiao.setCursor(new Cursor(Cursor.HAND_CURSOR));//手型
			
			close=new JLabel(new ImageIcon("img/close1.png"));
			close.setBounds(770, 0, 29, 28);
			con.add(close);
			close.setCursor(new Cursor(Cursor.HAND_CURSOR));//手型
			
			p1=new JPanel();
			p2=new JPanel();
			p3=new JPanel();
			
			p1.setLayout(null);
			p1.setBackground(new Color(246,246,246));//背景颜色
			tubiao1=new JLabel(new ImageIcon("gameimg/qqgametubiao1.jpg"));
			tubiao1.setBounds(5, 0, 80, 50);
			p1.add(tubiao1);
			
			tubiao2=new JLabel(new ImageIcon("gameimg/qqgametubiao2.png"));
			tubiao2.setBounds(62, 0, 140, 50);
			p1.add(tubiao2);
			
			nitu=new JLabel(new ImageIcon("gameimg/nitu.png"));
			nitu.setBounds(280, 0, 100, 50);
			p1.add(nitu);
			
			qname=new JLabel(qquser.getQqname());
			qname.setBounds(350,0,65,50);
			qname.setToolTipText(qquser.getQqname());
			p1.add(qname);

			zhu=new JLabel("注销");
			zhu.setBounds(415,0,40,50);
			p1.add(zhu);
			zhu.setCursor(new Cursor(Cursor.HAND_CURSOR));//手型
			
			shu=new JLabel(new ImageIcon("gameimg/竖.png"));
			shu.setBounds(440,0,25,50);
			p1.add(shu);
			
			geren=new JLabel("个人中心");
			geren.setBounds(460,0,90,50);
			p1.add(geren);
			geren.setCursor(new Cursor(Cursor.HAND_CURSOR));//手型
			
			shu1=new JLabel(new ImageIcon("gameimg/竖.png"));
			shu1.setBounds(515,0,25,50);
			p1.add(shu1);
			
			wangguo=new JLabel(new ImageIcon("gameimg/wowan.png"));
			wangguo.setBounds(510,0,140,50);
			p1.add(wangguo);
			wangguo.setCursor(new Cursor(Cursor.HAND_CURSOR));//手型
			
			caini=new JLabel(new ImageIcon("gameimg/xihuan.png"));
			caini.setBounds(620,0,140,50);
			p1.add(caini);
			caini.setCursor(new Cursor(Cursor.HAND_CURSOR));//手型
			
			p1.setBounds(25,30,750,46);
			con.add(p1);
			
			p2.setLayout(null);
		//	p2.setBackground(new Color(246,246,246));//背景颜色
			xxk=new JLabel(new ImageIcon("gameimg/选项卡.png"));
			p2.add(xxk);
			xxk.setBounds(0,0,750,36);
			xxk.setCursor(new Cursor(Cursor.HAND_CURSOR));//手型
			
			xxk1=new JLabel();xxk2=new JLabel();xxk3=new JLabel();xxk4=new JLabel();xxk5=new JLabel();xxk6=new JLabel();xxk7=new JLabel();xxk8=new JLabel();xxk9=new JLabel();xxk11=new JLabel();xxk12=new JLabel();
			p2.add(xxk1);p2.add(xxk2);p2.add(xxk3);p2.add(xxk4);p2.add(xxk5);p2.add(xxk6);p2.add(xxk7);p2.add(xxk8);p2.add(xxk9);p2.add(xxk11);p2.add(xxk12);
			xxk1.setBounds(9,6,37,25);xxk2.setBounds(57,6,37,25);xxk3.setBounds(105,6,37,25);xxk4.setBounds(153,6,37,25);xxk5.setBounds(201,6,37,25);xxk6.setBounds(249,6,37,25);xxk7.setBounds(297,6,37,25);
			xxk8.setBounds(345,6,37,25);xxk9.setBounds(393,6,37,25);xxk11.setBounds(489,6,37,25);xxk12.setBounds(537,6,37,25);//间隔48
			
			p2.setBounds(25,85,750,36);
			con.add(p2);
			
			p3.setLayout(null);
			//	p2.setBackground(new Color(246,246,246));//背景颜色
			hengg=new JLabel(new ImageIcon("gameimg/横广告.png"));
			hengg.setBounds(0,0,750,41);
			p3.add(hengg);
			hengg.setCursor(new Cursor(Cursor.HAND_CURSOR));//手型
			
			p3.setBounds(25,128,750,41);
			con.add(p3);
			
			weizhi=new JLabel(new ImageIcon("gameimg/位置图标.png"));
			weizhi.setBounds(30,185,24,24);
			con.add(weizhi);
			
			weizhitishi=new JLabel("首页");
			weizhitishi.setBounds(65,170,60,50);
			weizhitishi.setFont(new Font("宋体",Font.PLAIN,12));
			weizhitishi.setForeground(new Color(100,255,100));
			con.add(weizhitishi);
			weizhitishi.setCursor(new Cursor(Cursor.HAND_CURSOR));//手型
			
			weizhitishi2=new JLabel("- 贪吃蛇");
			weizhitishi2.setBounds(95,170,60,50);
			weizhitishi2.setFont(new Font("宋体",Font.PLAIN,12));
			weizhitishi2.setForeground(new Color(100,255,100));
			con.add(weizhitishi2);
			weizhitishi.setCursor(new Cursor(Cursor.HAND_CURSOR));//手型
			
			p4=new JPanel();
			p4.setLayout(null);
			p4.setBackground(new Color(246,246,246));//背景颜色
			
			yxtu=new JLabel(new ImageIcon("gameimg/tcsgame2.png"));
			p4.add(yxtu);
			yxtu.setBounds(25, 70, 250, 250);
			
			yxstart=new JLabel(new ImageIcon("gameimg/开始游戏.png"));
			p4.add(yxstart);
			yxstart.setBounds(70, 350, 166, 50);
			
			yxtishi=new JLabel(new ImageIcon("gameimg/简介2.png"));
			p4.add(yxtishi);
			yxtishi.setBounds(280,45,250,300);
			
			
			yxpaihangbang=new JLabel(new ImageIcon("gameimg/排行榜.png"));
			p4.add(yxpaihangbang);
			yxpaihangbang.setBounds(550,5,170,65);
			
			//表格的列
			Vector title=new Vector();
			title.add("昵称");
			title.add("分数");
			this.tilte=title;
			
			Vector datas=new Vector();
			tab=new DefaultTableModel();
			tab.setDataVector(datas, title);
			table=new JTable(tab);
			//返回结果集
			tab.setRowCount(0);
			vv=qservice.selscore();
			for(int i=0;i<vv.size();i++){
				Vector<Vector> us=vv.get(i);//读取
				tab.addRow(us);//加入数据中
			}
			table.setFont(new Font("宋体",Font.BOLD,18));
			table.setForeground(new Color(179,102,102));
			table.setBackground(new Color(255,255,255));
			//滚动条
			JScrollPane sp1=new JScrollPane(table);
			p4.add(sp1);
			sp1.setBounds(540,70,200,250);
			
			p4.setBounds(25,180,750,600);
			p4.setBackground(new Color(255,255,255));
			//JScrollPane sp1=new JScrollPane(p4);
			con.add(p4);
			
			//背景图片
			bg=new JLabel(new ImageIcon("img/QQgamebg.jpg"));
			bg.setBounds(0,0,800,650);
			con.add(bg);
			//监听
			weizhitishi.addMouseListener(new A());
			yxstart.addMouseListener(new A());
			xxk1.addMouseListener(new A());
			xxk2.addMouseListener(new A());
			xxk3.addMouseListener(new A());
			xxk4.addMouseListener(new A());
			xxk5.addMouseListener(new A());
			xxk6.addMouseListener(new A());
			xxk7.addMouseListener(new A());
			xxk8.addMouseListener(new A());
			xxk9.addMouseListener(new A());
			xxk11.addMouseListener(new A());
			xxk12.addMouseListener(new A());
			xiao.addMouseListener(new A());
			close.addMouseListener(new A());
			setSize(800,650);
			setVisible(true);
			setLocationRelativeTo(null);
		}
		class A extends MouseAdapter{
			public void mouseClicked(MouseEvent e) {
				//监听标签
				if(e.getSource()==weizhitishi){
					dispose();
					
				}else if(e.getSource()==yxstart){
					new Test而已(qquser,false);
					
				}
			
				if(e.getSource()==xiao){//最小化
					paihangbang.this.setExtendedState(paihangbang.this.ICONIFIED);//静态值
					
				}else if(e.getSource()==close){//关闭
					dispose();
					
				}else if(e.getSource()==xxk1){//选项卡
					xxk.setIcon(new ImageIcon("gameimg/选项卡.png"));
					
				}else if(e.getSource()==xxk2){//选项卡
					xxk.setIcon(new ImageIcon("gameimg/选项卡2.png"));;
					
				}else if(e.getSource()==xxk3){//选项卡
					xxk.setIcon(new ImageIcon("gameimg/选项卡3.png"));;
					
				}else if(e.getSource()==xxk4){//选项卡
					xxk.setIcon(new ImageIcon("gameimg/选项卡4.png"));;
					
				}else if(e.getSource()==xxk5){//选项卡
					xxk.setIcon(new ImageIcon("gameimg/选项卡5.png"));;
					
				}else if(e.getSource()==xxk6){//选项卡
					xxk.setIcon(new ImageIcon("gameimg/选项卡6.png"));;
					
				}else if(e.getSource()==xxk7){//选项卡
					xxk.setIcon(new ImageIcon("gameimg/选项卡7.png"));;
					
				}else if(e.getSource()==xxk8){//选项卡
					xxk.setIcon(new ImageIcon("gameimg/选项卡8.png"));;
					
				}else if(e.getSource()==xxk9){//选项卡
					xxk.setIcon(new ImageIcon("gameimg/选项卡9.png"));;
					
				}else if(e.getSource()==xxk11){//选项卡
					xxk.setIcon(new ImageIcon("gameimg/选项卡11.png"));;
					
				}else if(e.getSource()==xxk12){//选项卡
					xxk.setIcon(new ImageIcon("gameimg/选项卡12.png"));;
					
				}
			}
			public void mouseEntered(MouseEvent e){
				if(e.getSource()==xiao){
					xiao.setIcon(new ImageIcon("img/loginxiao.png"));
					
				}
				if(e.getSource()==close){
					close.setIcon(new ImageIcon("img/loginclose.png"));
					
				}
		
			}
			public void mouseExited(MouseEvent e){
				if(e.getSource()==xiao){
					xiao.setIcon(new ImageIcon("img/xiao1.png"));
					
				}
				
				if(e.getSource()==close){
					close.setIcon(new ImageIcon("img/close1.png"));
					
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
					paihangbang.this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}

				public void mousePressed(java.awt.event.MouseEvent e) {
					tmp = new Point(e.getX(), e.getY());

					isDragged = true;
					paihangbang.this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}
			});
			this.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
				public void mouseDragged(java.awt.event.MouseEvent e) {
					if (isDragged) {
						loc = new Point(paihangbang.this.getLocation().x + e.getX() - tmp.x,
								paihangbang.this.getLocation().y + e.getY() - tmp.y);
						paihangbang.this.setLocation(loc);
					}
				}
			});
		}
		/***********/
}

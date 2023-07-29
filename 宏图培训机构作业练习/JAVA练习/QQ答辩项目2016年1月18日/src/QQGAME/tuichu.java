package QQGAME;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

import QQGAME.fenshu.A;
import QQLGO.QQfind;
import QQVIP.QQvipmain;
import QQ数据库信息.QQGAME;
import 接口.QQuserInterface;
import 方法实现接口.QQuserimp;

public class tuichu extends JFrame{
	QQuserInterface qser=new QQuserimp();
	JLabel guan,hui;
	Test而已 t;
	QQuserInterface qserive=new QQuserimp();
	JPopupMenu pop;
	JMenuItem it1,it2;//菜单项
	QQGAME qquser;
	public tuichu(Test而已 t,QQGAME qquser){
		super();
		this.qquser=qquser;
		this.t=t;
		Container con=getContentPane();
		setLayout(null);
		this.setUndecorated(true);//无边框
		JLabel tou=new JLabel("退出成功");
		tou.setFont(new Font("宋体",Font.BOLD,28));
		tou.setBounds(135,50,200,40);
		tou.setForeground(Color.red);
		con.add(tou);

		JLabel user=new JLabel("用户:");
		user.setBounds(140, 120, 100,50);
		user.setFont(new Font("宋体",Font.BOLD,20));
		con.add(user);
		
		JLabel user1=new JLabel(""+qquser.getQqname());
		user1.setBounds(190, 120, 100,50);
		user1.setFont(new Font("宋体",Font.BOLD,20));
		con.add(user1);
		
		JLabel fen=new JLabel("分数:");
		fen.setBounds(140,200, 100,50);
		fen.setFont(new Font("宋体",Font.BOLD,20));
		con.add(fen);
		
		int a=t.node-2;//蛇节即使分数
		int b=a*20;
		//分数
		if(b>qquser.getShescore()){
			qser.addscore(qquser.getQqname(), b);//保存分数
		}
		JLabel fen1=new JLabel(""+b);
		fen1.setBounds(210,200, 100,50);
		fen1.setFont(new Font("宋体",Font.BOLD,20));
		con.add(fen1);

		//菜单
		hui=new JLabel("会员专享");
		hui.setBounds(140,280,200,50);
		hui.setFont(new Font("宋体",Font.BOLD,20));
		con.add(hui);
		hui.setForeground(Color.blue);
		hui.setCursor(new Cursor(Cursor.HAND_CURSOR));//手型
		
		guan=new JLabel("关 闭");
		guan.setBounds(140, 345, 150,50);
		guan.setFont(new Font("宋体",Font.BOLD,25));
		guan.setForeground(Color.green);
		con.add(guan);
		guan.setCursor(new Cursor(Cursor.HAND_CURSOR));//手型
		
		//菜单
		pop=new JPopupMenu();
		it1=new JMenuItem("保存进度");
		it2=new JMenuItem("载入进度");
		pop.add(it1);
		pop.addSeparator();
		pop.add(it2);
		
		pop.addMouseListener(new A());
		it1.addActionListener(new B());
		it2.addActionListener(new B());
		guan.addMouseListener(new A());
		hui.addMouseListener(new A());
		setSize(400,400);
		setVisible(true);
		setLocationRelativeTo(null);
	}
	class A extends MouseAdapter{

		public void mouseClicked(MouseEvent e) {
			if(e.getSource()==guan){
				dispose();
				
			}else if(e.getSource()==hui){
				//判断是不是会员
				QQGAME hui=new QQGAME();
				boolean shi=qserive.chekhui(t.game.getQqnum());
				if(shi){
					//保持历史进度 弹框选择
					pop.show(guan, e.getX(), e.getY()-100);
				}else{
					//不是 就进入充值会员界面
					JOptionPane.showMessageDialog(null, "对不起!你不是QQ会员");
					new QQvipmain();
				}
			}
		}

	}
	class B implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==it1){
				//弹出选择框
				String message="提示："+t.game.getQqname()+"用户的以前记录会被覆盖";
				int	j=JOptionPane.showConfirmDialog(null, message, "警告", JOptionPane.OK_CANCEL_OPTION);
				//保存蛇节
				if(j==0){//如果选择的是确定
					qserive.updshenode(t.game.getQqnum(), t.node);
				}else{
					
				}
				
				
			}else if(e.getSource()==it2){
				//载入蛇节
				//改变boolean值判断是否载入蛇节
				dispose();
				new Test而已(qquser,true);//载入蛇节
			}
			
		}
		
		
		
	}
//	public static void main(String[] args) {
//		new tuichu();
//	}
}

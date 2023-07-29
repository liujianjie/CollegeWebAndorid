package QQGAME;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

import QQ数据库信息.QQgame;
import QQ数据库信息.QQuser;
import 接口.QQuserInterface;
import 方法实现接口.QQuserimp;

public class fenshu extends JFrame{
	JLabel guan;
	QQuserInterface qser=new QQuserimp();
	QQuserInterface qseriver=new QQuserimp();
	public fenshu(Test而已 t){
		super();
		Container con=getContentPane();
		setLayout(null);
		this.setUndecorated(true);//无边框
		JLabel tou=new JLabel("GAME OVER!!");
		tou.setFont(new Font("宋体",Font.BOLD,28));
		tou.setBounds(125,50,200,40);
		tou.setForeground(Color.red);
		con.add(tou);
		//用户
		//QQGAME qq=new QQGAME();
		//qq.setQqname("小小");
		JLabel user=new JLabel("用户:");
		user.setBounds(80, 120, 100,50);
		user.setFont(new Font("宋体",Font.BOLD,20));
		con.add(user);
		
		JLabel user1=new JLabel(""+t.game.getQqname());
		user1.setBounds(130, 120, 100,50);
		user1.setFont(new Font("宋体",Font.BOLD,20));
		con.add(user1);
		
		JLabel ge=new JLabel("个数:");
		ge.setBounds(80,200, 100,50);
		ge.setFont(new Font("宋体",Font.BOLD,20));
		con.add(ge);
		
		int a=t.node-2;//蛇节-2
		JLabel ge1=new JLabel(""+a);
		ge1.setBounds(130,200, 100,50);
		ge1.setFont(new Font("宋体",Font.BOLD,20));
		con.add(ge1);
		
		JLabel fen=new JLabel("分数:");
		fen.setBounds(80, 280, 100,50);
		fen.setFont(new Font("宋体",Font.BOLD,20));
		con.add(fen);
		
		int score=a*20;
		//分数
//		System.out.println(t.game.getShescore()+" test 1");
//		System.out.println(t.game.getShescore()+" test 2");
		if(score>t.game.getShescore()){
			qser.addscore(t.game.getQqnum(), score);
		}
		JLabel fen1=new JLabel(""+score);
		fen1.setBounds(130, 280, 100,50);
		fen1.setFont(new Font("宋体",Font.BOLD,20));
		con.add(fen1);
		
		guan=new JLabel("关 闭");
		guan.setBounds(150, 345, 150,50);
		guan.setFont(new Font("宋体",Font.BOLD,25));
		guan.setForeground(Color.green);
		con.add(guan);
		guan.setCursor(new Cursor(Cursor.HAND_CURSOR));//手型
		
		guan.addMouseListener(new A());
	//	System.out.println(t.count);
		setSize(400,400);
		setVisible(true);
		setLocationRelativeTo(null);	
	}
	class A extends MouseAdapter{

		public void mouseClicked(MouseEvent e) {
			if(e.getSource()==guan){
				dispose();
				
			}
		}

	}
}

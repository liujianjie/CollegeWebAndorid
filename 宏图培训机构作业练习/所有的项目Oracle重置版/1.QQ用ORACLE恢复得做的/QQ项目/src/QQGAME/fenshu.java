package QQGAME;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

import QQ���ݿ���Ϣ.QQgame;
import QQ���ݿ���Ϣ.QQuser;
import �ӿ�.QQuserInterface;
import ����ʵ�ֽӿ�.QQuserimp;

public class fenshu extends JFrame{
	JLabel guan;
	QQuserInterface qser=new QQuserimp();
	QQuserInterface qseriver=new QQuserimp();
	public fenshu(Test���� t){
		super();
		Container con=getContentPane();
		setLayout(null);
		this.setUndecorated(true);//�ޱ߿�
		JLabel tou=new JLabel("GAME OVER!!");
		tou.setFont(new Font("����",Font.BOLD,28));
		tou.setBounds(125,50,200,40);
		tou.setForeground(Color.red);
		con.add(tou);
		//�û�
		//QQGAME qq=new QQGAME();
		//qq.setQqname("СС");
		JLabel user=new JLabel("�û�:");
		user.setBounds(80, 120, 100,50);
		user.setFont(new Font("����",Font.BOLD,20));
		con.add(user);
		
		JLabel user1=new JLabel(""+t.game.getQqname());
		user1.setBounds(130, 120, 100,50);
		user1.setFont(new Font("����",Font.BOLD,20));
		con.add(user1);
		
		JLabel ge=new JLabel("����:");
		ge.setBounds(80,200, 100,50);
		ge.setFont(new Font("����",Font.BOLD,20));
		con.add(ge);
		
		int a=t.node-2;//�߽�-2
		JLabel ge1=new JLabel(""+a);
		ge1.setBounds(130,200, 100,50);
		ge1.setFont(new Font("����",Font.BOLD,20));
		con.add(ge1);
		
		JLabel fen=new JLabel("����:");
		fen.setBounds(80, 280, 100,50);
		fen.setFont(new Font("����",Font.BOLD,20));
		con.add(fen);
		
		int score=a*20;
		//����
//		System.out.println(t.game.getShescore()+" test 1");
//		System.out.println(t.game.getShescore()+" test 2");
		if(score>t.game.getShescore()){
			qser.addscore(t.game.getQqnum(), score);
		}
		JLabel fen1=new JLabel(""+score);
		fen1.setBounds(130, 280, 100,50);
		fen1.setFont(new Font("����",Font.BOLD,20));
		con.add(fen1);
		
		guan=new JLabel("�� ��");
		guan.setBounds(150, 345, 150,50);
		guan.setFont(new Font("����",Font.BOLD,25));
		guan.setForeground(Color.green);
		con.add(guan);
		guan.setCursor(new Cursor(Cursor.HAND_CURSOR));//����
		
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

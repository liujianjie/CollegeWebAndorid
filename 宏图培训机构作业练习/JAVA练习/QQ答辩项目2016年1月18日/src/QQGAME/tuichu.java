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
import QQ���ݿ���Ϣ.QQGAME;
import �ӿ�.QQuserInterface;
import ����ʵ�ֽӿ�.QQuserimp;

public class tuichu extends JFrame{
	QQuserInterface qser=new QQuserimp();
	JLabel guan,hui;
	Test���� t;
	QQuserInterface qserive=new QQuserimp();
	JPopupMenu pop;
	JMenuItem it1,it2;//�˵���
	QQGAME qquser;
	public tuichu(Test���� t,QQGAME qquser){
		super();
		this.qquser=qquser;
		this.t=t;
		Container con=getContentPane();
		setLayout(null);
		this.setUndecorated(true);//�ޱ߿�
		JLabel tou=new JLabel("�˳��ɹ�");
		tou.setFont(new Font("����",Font.BOLD,28));
		tou.setBounds(135,50,200,40);
		tou.setForeground(Color.red);
		con.add(tou);

		JLabel user=new JLabel("�û�:");
		user.setBounds(140, 120, 100,50);
		user.setFont(new Font("����",Font.BOLD,20));
		con.add(user);
		
		JLabel user1=new JLabel(""+qquser.getQqname());
		user1.setBounds(190, 120, 100,50);
		user1.setFont(new Font("����",Font.BOLD,20));
		con.add(user1);
		
		JLabel fen=new JLabel("����:");
		fen.setBounds(140,200, 100,50);
		fen.setFont(new Font("����",Font.BOLD,20));
		con.add(fen);
		
		int a=t.node-2;//�߽ڼ�ʹ����
		int b=a*20;
		//����
		if(b>qquser.getShescore()){
			qser.addscore(qquser.getQqname(), b);//�������
		}
		JLabel fen1=new JLabel(""+b);
		fen1.setBounds(210,200, 100,50);
		fen1.setFont(new Font("����",Font.BOLD,20));
		con.add(fen1);

		//�˵�
		hui=new JLabel("��Աר��");
		hui.setBounds(140,280,200,50);
		hui.setFont(new Font("����",Font.BOLD,20));
		con.add(hui);
		hui.setForeground(Color.blue);
		hui.setCursor(new Cursor(Cursor.HAND_CURSOR));//����
		
		guan=new JLabel("�� ��");
		guan.setBounds(140, 345, 150,50);
		guan.setFont(new Font("����",Font.BOLD,25));
		guan.setForeground(Color.green);
		con.add(guan);
		guan.setCursor(new Cursor(Cursor.HAND_CURSOR));//����
		
		//�˵�
		pop=new JPopupMenu();
		it1=new JMenuItem("�������");
		it2=new JMenuItem("�������");
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
				//�ж��ǲ��ǻ�Ա
				QQGAME hui=new QQGAME();
				boolean shi=qserive.chekhui(t.game.getQqnum());
				if(shi){
					//������ʷ���� ����ѡ��
					pop.show(guan, e.getX(), e.getY()-100);
				}else{
					//���� �ͽ����ֵ��Ա����
					JOptionPane.showMessageDialog(null, "�Բ���!�㲻��QQ��Ա");
					new QQvipmain();
				}
			}
		}

	}
	class B implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==it1){
				//����ѡ���
				String message="��ʾ��"+t.game.getQqname()+"�û�����ǰ��¼�ᱻ����";
				int	j=JOptionPane.showConfirmDialog(null, message, "����", JOptionPane.OK_CANCEL_OPTION);
				//�����߽�
				if(j==0){//���ѡ�����ȷ��
					qserive.updshenode(t.game.getQqnum(), t.node);
				}else{
					
				}
				
				
			}else if(e.getSource()==it2){
				//�����߽�
				//�ı�booleanֵ�ж��Ƿ������߽�
				dispose();
				new Test����(qquser,true);//�����߽�
			}
			
		}
		
		
		
	}
//	public static void main(String[] args) {
//		new tuichu();
//	}
}

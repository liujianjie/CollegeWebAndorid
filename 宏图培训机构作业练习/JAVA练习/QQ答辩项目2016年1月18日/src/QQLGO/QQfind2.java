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
import QQ���ݿ���Ϣ.QQuser;
import �ӿ�.QQuserInterface;
import ����ʵ�ֽӿ�.QQuserimp;

public class QQfind2 extends JFrame{
	JLabel close,biao,name,sheng,di,bg;
	JTextField names,years,month,day,country,province,city;
	JButton xia;
	QQuserInterface qserive=new QQuserimp();
	public QQfind2(){
		super("");
		Container con=getContentPane();
		//con.setLayout(null);
		this.setUndecorated(true);//�ޱ߿�
		//���ý�������϶��ķ���
		setDragable();
		
		con.setBackground(new Color(255,255,255));
		
		biao=new JLabel("�һ�����");
		biao.setBounds(150,40,150,30);
		biao.setFont(new Font("����",Font.BOLD,26));
		con.add(biao);
		
		close=new JLabel(new ImageIcon("img/close1.png"));
		close.setBounds(370,0,29,28);
		close.setCursor(new Cursor(Cursor.HAND_CURSOR));//����
		con.add(close);
		
		name=new JLabel("����:");
		name.setBounds(70,120,50,30);
		name.setFont(new Font("����",Font.PLAIN,15));
		con.add(name);
		
		String str="�����ʵ����";
	//	Font f=new Font("����",Font.PLAIN,10);	
		names=new JTextField(str);
		names.setBounds(120,120,200,30);
		con.add(names);
		
		sheng=new JLabel("��������:");
		sheng.setBounds(40,200,100,30);
		sheng.setFont(new Font("����",Font.PLAIN,15));
		con.add(sheng);

		years=new JTextField("��");
		years.setBounds(120,200,60,30);
		con.add(years);

		month=new JTextField("��");
		month.setBounds(190,200,60,30);
		con.add(month);
		
		day=new JTextField("��");
		day.setBounds(260,200,60,30);
		con.add(day);
		
		di=new JLabel("���ڵ�:");
		di.setBounds(48,280,100,30);
		di.setFont(new Font("����",Font.PLAIN,15));
		con.add(di);

		country=new JTextField("����");
		country.setBounds(120,280,60,30);
		con.add(country);

		province=new JTextField("ʡ��");
		province.setBounds(190,280,60,30);
		con.add(province);
		
		city=new JTextField("����");
		city.setBounds(260,280,60,30);
		con.add(city);
		
		xia=new JButton("��һ��");
		xia.setBounds(150,380,120,30);
		con.add(xia);
		
		bg=new JLabel(new ImageIcon("img/zhuce2_����.png"));
		con.add(bg);
		//����
		xia.addMouseListener(new A());
		close.addMouseListener(new A());
		setSize(400,450);
		setVisible(true);
		setLocationRelativeTo(null);
	}

	
	
	class A extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {
			if(e.getSource()==close){//�ر�
				dispose();	
			}
			if(e.getSource()==xia){
				QQuser quser=new QQuser();
				quser.setYears(years.getText().trim());//���ı��������ó���
				quser.setMonths(month.getText().trim());//���ı��������ó���
				quser.setDprivate(day.getText().trim());//���ı��������ó���
				quser.setCountry(country.getText().trim());//���ı��������ó���
				quser.setProvince(province.getText().trim());//���ı��������ó���
				quser.setCity(city.getText().trim());//���ı��������ó���
				QQuser qq=qserive.chkqqziliao(quser);//��ֵ���뷽���� �Ա�
				if(qq==null){
					JOptionPane.showMessageDialog(null, "�û���Ϣ����ȷ");
					return;
				}else{
					//��Ϣ��ȷ
					JOptionPane.showMessageDialog(null, "�������Ϊ��"+quser.getPwd()+"�������Ʊ��ܣ�");
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
				close.setIcon(new ImageIcon("img/close1.png"));//ԭ����ͼƬ
				
			}
		}
	}	
	

	/***********/
	//���ý�������϶��ķ���
	
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

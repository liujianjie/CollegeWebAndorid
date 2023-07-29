package QQmain;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;

import QQmain.QQbiaoqingpane2.A;

public class QQbiaoqingpane extends JFrame implements FocusListener{
	// ͼƬ����
	Icon bqs[] = new ImageIcon[91];
	JLabel bq[] = new JLabel[91];
	JLabel pane1,pane2,pane3;
	QQchat chat;
	JPanel p1;
	public QQbiaoqingpane(QQchat chat) {
		super();
		//���������ʽ
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf."
					+ "windows.WindowsLookAndFeel");
		} catch (Exception e) {
			
		}
		this.chat=chat;
		Container con = getContentPane();
		con.setLayout(null);
		this.setUndecorated(true);// �ޱ߿�

		// ����
		for (int i = 0; i <= 90; i++) {
			bqs[i] = new ImageIcon("bq/" + i + ".gif");
		}
		// ���
		p1 = new JPanel();
	//	p1.setLayout(new FlowLayout(FlowLayout.LEFT,8,4));
		p1.setLayout(new GridLayout(13,7));
		p1.setBackground(new Color(255,255,255));
		for (int i = 0; i < 90; i++) {
			bq[i] = new JLabel(bqs[i+1]);// ѭ��ͼƬ
			// �ӱ߿�
			bq[i].setBorder(BorderFactory.createLineBorder(Color.WHITE, 0));
			bq[i].addMouseListener(new A());
			p1.add(bq[i]);
		}
		
		JPanel p2=new JPanel();
		p2.setBackground(new Color(235,235,235));
		p2.setLayout(new FlowLayout(FlowLayout.LEFT,2,0));
		
		pane1=new JLabel(new ImageIcon("img/biaoqingpane11.png"));
		p2.add(pane1);
		
		pane2=new JLabel(new ImageIcon("img/QQbiaoqing3.png"));
		p2.add(pane2);
		
		pane3=new JLabel(new ImageIcon("img/QQbiaoqing4.png"));
		p2.add(pane3);
		
		p2.setBounds(0,200,435,36);
		con.add(p2);
		
		JScrollPane sp1=new JScrollPane(p1);
		sp1.setBounds(0, 0, 435, 200);
		//sp1.add(p1);
		con.add(sp1);
		//����
		addFocusListener(this);
		pane2.addMouseListener(new A());
		pane3.addMouseListener(new A());
		setSize(435, 236);
		setVisible(true);
		setLocation(chat.getX(),chat.getY()+116);

	}

	// ����ƶ�
	class A extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			for (int i = 0; i <= 90; i++) {
				if (e.getSource() == bq[i]) {
					chat.t2.insertIcon(bq[i].getIcon());//��ѡ�еı�����뵽���촰�ڵķ��Ϳ�
					QQbiaoqingpane.this.dispose();
					//���������ݿ���
					
					break;
				}
			}
			if(e.getSource()==pane2){
				new QQbiaoqingpane2(chat);
				
			}
			if(e.getSource()==pane3){
				new QQbiaoqingpane3(chat);
				
			}
			
		}
		//������ĳ���ؼ�����
		public void mouseEntered(MouseEvent e) {
			for(int i=0;i<=90;i++){
				if(e.getSource()==bq[i]){
					//������ڸñ�������ʱ���߿���ɫ��Ϊ��ɫ
					bq[i].setBorder(BorderFactory.createLineBorder(Color.BLUE,1));
					break;
				}
			}
			if(e.getSource()==pane2){
				pane2.setIcon(new ImageIcon("img/QQbiaoqing33.png"));
			}
			if(e.getSource()==pane3){
				pane3.setIcon(new ImageIcon("img/QQbiaoqing44.png"));
			}
		}
		//����뿪ĳ���ؼ�����
		public void mouseExited(MouseEvent e) {
			for(int i=0;i<=90;i++){
				if(e.getSource()==bq[i]){
					//������뿪�ñ���ʱ���߿���ɫ�ָ�Ϊ��ɫ
					bq[i].setBorder(BorderFactory.createLineBorder(Color.WHITE,0));
					break;
				}
			}
			if(e.getSource()==pane2){
				pane2.setIcon(new ImageIcon("img/QQbiaoqing3.png"));
			}
			if(e.getSource()==pane3){
				pane3.setIcon(new ImageIcon("img/QQbiaoqing4.png"));
			}
		}
	}

	public static void main(String[] args) {
	//	new QQbiaoqingpane(4, 6,chat);
	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		QQbiaoqingpane.this.dispose();
		
	}
}

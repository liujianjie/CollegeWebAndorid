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
import QQ���ݿ���Ϣ.Contants;
import QQ���ݿ���Ϣ.QQgame;
import QQ���ݿ���Ϣ.QQuser;
import QQ���ݿ���Ϣ.QQhistory;
import QQcloudlet.QQweiyun;
import �ӿ�.QQuserInterface;
import ����ʵ�ֽӿ�.QQuserimp;
import ע����.ע�ᴰ��;

public class QQlogin extends JFrame{
	QQuserInterface qserive=new QQuserimp();
	JLabel xiao,close,bg,xia;
	JLabel zhu,wang,log,zt;//ע�� �������� ��ס���� �Զ�����
	JComboBox t1;//�ı���
	JPasswordField p1;//����
	JLabel face;//ͷ��
	JCheckBox ch1,ch2;//��ѡ��
	String str[];//�˺ſ�����
	List list;
	JPopupMenu pop;//����ʽ�˵�
	JMenuItem it1,it2,it3,it4;
	
	public QQlogin(){
		super("");
		//���������ʽ
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf."
					+ "windows.WindowsLookAndFeel");
		} catch (Exception e) {
			
		}
				
		Container con=getContentPane();
		this.History();
		// ����ͼƬ
		setIconImage(new ImageIcon("img/touxiang1.png").getImage());
		this.setUndecorated(true);//�ޱ߿�
		//���ý�������϶��ķ���
		setDragable();

		xiao=new JLabel();
		xiao.setBounds(370,0,29,28);
		con.add(xiao);
		xiao.setCursor(new Cursor(Cursor.HAND_CURSOR));//����
		
		close=new JLabel();
		close.setBounds(400,0,29,28);
		con.add(close);
		close.setCursor(new Cursor(Cursor.HAND_CURSOR));//����
		
		xia=new JLabel();
		xia.setBounds(340,0,29,28);
		con.add(xia);
		close.setCursor(new Cursor(Cursor.HAND_CURSOR));//����
	
		//����״̬
		zt=new JLabel(new ImageIcon("img/s_online.png"));
		zt.setBounds(97,235,15,15);
		con.add(zt);
		
		face=new JLabel(new ImageIcon("img/touxiang1.png"));
		face.setBounds(50, 190, 60, 60);
		con.add(face);
		//������
		pop=new JPopupMenu();
		it1=new JMenuItem("��������",new ImageIcon("img/s_online.png"));//��������
		it2=new JMenuItem("����",new ImageIcon("img/s_hide.png"));
		it3=new JMenuItem("æµ",new ImageIcon("img/s_busy.png"));
		it4=new JMenuItem("�뿪",new ImageIcon("img/s_leave.png"));
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
		
		
		//��ɫ
		Color myc=new Color(90,90,90);
		ch1=new JCheckBox("��ס����");
		ch1.setBounds(130, 235, 80, 20);
		ch1.setForeground(myc);
		con.add(ch1);
		
		ch2=new JCheckBox("�Զ���¼");
		ch2.setBounds(255, 235, 80, 20);
		ch2.setForeground(myc);
		con.add(ch2);
		
		Color mycolor=new Color(15,177,255);//�Զ�����ɫ
		zhu=new JLabel("ע���˺�");
		zhu.setBounds(340, 190, 60, 20);
		con.add(zhu);
		zhu.setForeground(mycolor);
		zhu.setCursor(new Cursor(Cursor.HAND_CURSOR));//��
		
		wang=new JLabel("��������");
		wang.setBounds(340, 215, 190, 20);
		con.add(wang);
		wang.setForeground(mycolor);
		wang.setCursor(new Cursor(Cursor.HAND_CURSOR));//��
		
		ImageIcon ima=new ImageIcon("img/login1.png");
		log=new JLabel(ima);
		log.setBounds(110, 255, 232, 40);
		con.add(log);
		
		//����
		
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
		/* ����ͼƬ */
		ImageIcon images = new ImageIcon("img/bg3111.png");
		JLabel jl = new JLabel(images);// ͼƬ��ǩ
		con.add(jl);
		bg=new JLabel();
		setSize(430,310);
		setVisible(true);
		setLocationRelativeTo(null);
		//���벻Ϊ��
		pwdnonull();
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	class B implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==it1){//����˵���ı�����û���״̬
				//�ı�ͼƬ
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
		if(a!=null){//���벻Ϊ�� �ʹ�ӡ��ȥ ���� ��ס����ѡ��
			p1.setText(a);
			if(a.equals("")||a==null){
				ch1.setSelected(false);//ѡ��
			}else{
				ch1.setSelected(true);//ѡ��
			}
		}
	}
	class A extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {
			if(e.getSource()==zt){
				pop.show(zt, e.getX(), e.getY());
				
			}
			else if(e.getSource()==xiao){//��С��
				QQlogin.this.setExtendedState(QQlogin.this.ICONIFIED);//��ֵ̬
				
			}else if(e.getSource()==close){//�ر�
				System.exit(0);
				
			}else if(e.getSource()==zhu){
				new ע�ᴰ��();
				
			}else if(e.getSource()==wang){
				new QQfind();
			}else if(e.getSource()==log){
				if(t1.getSelectedItem().toString().trim().equals("")){//�˺��Ƿ�Ϊ��
					JOptionPane.showMessageDialog(null, "���������˺ź��ٵ�¼");
					t1.requestFocus();
					return;
				}else if(p1.getText().trim().equals("")){
					JOptionPane.showMessageDialog(null, "��������������ٵ�¼");
					p1.requestFocus();
					return;
				}
				//�û���Ϣ�Ƿ���� 
				QQuser quser=new QQuser();
				quser.setQqnum(t1.getSelectedItem().toString());//���ı��������ó���
				quser.setPwd(p1.getText());//����
				QQuser qq=qserive.chkuser(quser);//��ֵ���뷽���� �Ա�
				if(qq==null){
					//����ʧ�� ��Ϣƥ�䲻��
					JOptionPane.showMessageDialog(null, "��������˺Ż��������󣡵�¼ʧ��");
					t1.requestFocus();
					return;
				}else{
				//����ɹ�
					//System.out.println("����ɹ�");
					//�ı�״̬
					String path=zt.getIcon().toString();
					if(path.indexOf("online")>-1){//����˵���ı�����û���״̬
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
					//������ʷ��¼
					
					QQhistory qqh=new QQhistory();
					qqh.setQqnum(t1.getSelectedItem().toString());//qq��		
					if(ch1.isSelected()){//�����ѡ�˾ͱ�������
						qqh.setQqpwd(p1.getText());//����
					}else{
						qqh.setQqpwd("");
					}
					
					qqh.setQqface(qq.getFace());//��ԭ����ͷ���ȡ����ʷͷ��
					qserive.addhistory(qqh);//��ӵ���ʷ��¼
					//-------��Ϸ��¼
					QQgame qqgame=new QQgame();
					qqgame.setQqnum(t1.getSelectedItem().toString());//���ı��������ó�������QQ��
					//΢��
					QQweiyun wy=new QQweiyun();
					wy.setQqnum(t1.getSelectedItem().toString());//���ı��������ó�������QQ��
					try {
						new QQloginin(qq,qqgame);
					} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
							| UnsupportedLookAndFeelException e1) {
						// TODO �Զ����ɵ� catch ��
						e1.printStackTrace();
					}
					QQlogin.this.dispose();//�رյ���
					
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
				xiao.setIcon(new ImageIcon(""));//��Ϊԭ����ͼƬ
				
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
			if(index<0){//��ֹ����
				return;
			}
			QQhistory qqh=(QQhistory)list.get(index);//��ʷ�±�
			p1.setText(qqh.getQqpwd());//��ȡ����
			face.setIcon(new ImageIcon(qqh.getQqface()));//��ȡͷ��
			if(!qqh.getQqpwd().equals("")){//��Ϊ��
				ch1.setSelected(true);//ѡ��
			}else{
				ch1.setSelected(false);
			}
		}
	}
	
	//���ı���ֵ
	public void History(){
		list=qserive.selhi();
		str=new String[list.size()];//��С
		for(int i=0;i<list.size();i++){
			QQhistory qqh=(QQhistory)list.get(i);//��һ��
			str[i]=qqh.getQqnum();//��ֵQQ��
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

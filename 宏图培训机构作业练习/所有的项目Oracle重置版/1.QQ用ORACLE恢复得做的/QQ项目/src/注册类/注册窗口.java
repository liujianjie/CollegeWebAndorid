package ע����;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import QQ���ݿ���Ϣ.QQgame;
import QQ���ݿ���Ϣ.QQuser;
import QQcloudlet.QQweiyun;
import QQcloudlet.QQweiyunfafang;
import �ӿ�.QQuserInterface;
import ����ʵ�ֽӿ�.QQuserimp;

public class ע�ᴰ�� extends JFrame{
	QQuserInterface qqinterface = new QQuserimp();
	QQweiyunfafang qservice=new QQweiyunfafang();
	JButton b1, b2;// ������ť

	JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14,xiao,close;// 8����ǩ

	JTextField t1, t2, t3, t4, t5, t6, t7;// 1���ı���

	JPasswordField paw1, paw2;// ���������

	JRadioButton r1, r2;// ������ѡ��

	JTextArea te1;// һ���ı���
	ButtonGroup g;// �Ա���
	JComboBox co1, co2, co3, co4;// ����������
	String st1[] = { "����", "ũ��" };// Ϊ�������������
	//String st2[] = { "һ��", "����", "����", "����", "����", "����", "����", "����", "����", "ʮ��", "ʮһ��", "ʮ����" };// Ϊ�������������
	String st3[] = { "������", "��ţ��", "˫����", "��з��", "ʨ����", "��Ů��", "�����", "��Ы��", "������", "ˮƿ��", "ħ����", "˫����" };
	String st4[] = { "����", "����", "ά�����", "����", "���� ", "����", "׳��", "������", "����", "ˮƿ��", "����", "���" };
	// ������ ת��ͼƬ
	// ����ͼƬ
	ImageIcon img[] = { new ImageIcon("img/0.png"), // 0
			new ImageIcon("img/1.png"), // 1
			new ImageIcon("img/2.png"), // 2
			new ImageIcon("img/3.png"), // 3
			new ImageIcon("img/4.png"), // 4
			new ImageIcon("img/5.png"), // 51
			new ImageIcon("img/6.png"), // 6
			new ImageIcon("img/7.png"), // 7
			new ImageIcon("img/8.png"), // 8
			new ImageIcon("img/9.png"), // 9
			new ImageIcon("img/10.png") };// 10

	public ע�ᴰ��() {
		super("QQ2015ע�ᴰ��");
		Container con = getContentPane();
		con.setLayout(null);// 
		this.setUndecorated(true);//�ޱ߿�
		
		xiao=new JLabel(new ImageIcon("img/xiao1.png"));
		xiao.setBounds(340,0,29,28);
		con.add(xiao);
		xiao.setCursor(new Cursor(Cursor.HAND_CURSOR));//����
		
		close=new JLabel(new ImageIcon("img/close1.png"));
		close.setBounds(370,0,29,28);
		con.add(close);
		close.setCursor(new Cursor(Cursor.HAND_CURSOR));//����
		
		xiao.addMouseListener(new B());
		close.addMouseListener(new B());
		setDragable();//�����ק
		
		l1 = new JLabel("QQע��", JLabel.CENTER);// �����������
		Font f = new Font("����", Font.BOLD, 30);// ����
		l1.setFont(f);
		l1.setForeground(Color.red);// ��ɫ
		l1.setBounds(140, 45, 150, 40);
		con.add(l1);

		l2 = new JLabel("�ǳ�");
		l2.setBounds(70, 115, 30, 20);
		con.add(l2);

		t1 = new JTextField();
		t1.setBounds(120, 115, 200, 20);
		con.add(t1);

		l3 = new JLabel("����");
		l3.setBounds(70, 155, 30, 20);
		con.add(l3);

		paw1 = new JPasswordField();
		paw1.setBounds(120, 155, 200, 20);
		con.add(paw1);

		l4 = new JLabel("ȷ������");
		l4.setBounds(45, 195, 70, 20);
		con.add(l4);

		paw2 = new JPasswordField();
		paw2.setBounds(120, 195, 200, 20);
		con.add(paw2);

		l5 = new JLabel("�Ա�");
		l5.setBounds(70, 245, 30, 20);
		con.add(l5);

		r1 = new JRadioButton("��");
		r1.setBounds(120, 245, 44, 20);
		con.add(r1);

		// ��ѡ��Ĭ��ѡ��
		r1.setSelected(true);
		r2 = new JRadioButton("Ů");
		r2.setBounds(160, 245, 44, 20);
		con.add(r2);

		// ��������ѡ���Ϊһ����
		g = new ButtonGroup();
		g.add(r1);
		g.add(r2);

		// ��ͷ��
		l11 = new JLabel("ͷ��");
		l11.setBounds(205, 245, 60, 20);
		con.add(l11);

		co1 = new JComboBox(img);
		co1.setBounds(250, 220, 80, 60);
		con.add(co1);

		l7 = new JLabel("����");
		l7.setBounds(70, 280, 30, 20);
		con.add(l7);

		co2 = new JComboBox(st1);
		co2.setBounds(120, 285, 60, 20);
		con.add(co2);

		t2 = new JTextField("2016��");
		t2.setBounds(185, 285, 50, 20);
		con.add(t2);

		t3 = new JTextField("1��");
		t3.setBounds(235, 285, 45, 20);
		con.add(t3);

		t4 = new JTextField("1��");
		t4.setBounds(280, 285, 50, 20);
		con.add(t4);

		l8 = new JLabel("���ڵ�");
		l8.setBounds(60, 325, 80, 20);
		con.add(l8);

		t5 = new JTextField("�й�");
		t5.setBounds(120, 325, 70, 20);
		con.add(t5);

		t6 = new JTextField("����");
		t6.setBounds(190, 325, 70, 20);
		con.add(t6);

		t7 = new JTextField("����");
		t7.setBounds(260, 325, 70, 20);
		con.add(t7);

		l9 = new JLabel("����");
		l9.setBounds(70, 365, 30, 20);
		con.add(l9);

		co3 = new JComboBox(st3);
		co3.setBounds(120, 365, 70, 20);
		co3.setEditable(false);
		con.add(co3);

		l9 = new JLabel("����");
		l9.setBounds(200, 365, 30, 20);
		con.add(l9);

		co4 = new JComboBox(st4);
		co4.setBounds(240, 365, 70, 20);
		con.add(co4);

		l10 = new JLabel("����˵��");
		l10.setBounds(45,405, 80, 20);
		con.add(l10);

		te1 = new JTextArea();
		te1.setBounds(120, 405, 200, 100);
		con.add(te1);

		b1 = new JButton("ע��");
		b1.setBounds(120, 535, 70, 30);
		con.add(b1);

		b2 = new JButton("���");
		b2.setBounds(220, 535, 70, 30);
		con.add(b2);
		b1.addActionListener(new A());// ��Ȩ
		b2.addActionListener(new A());
		// ����ͼƬ
		setIconImage(new ImageIcon("img/touxiang1.png").getImage());
		/* ����ͼƬ */
		ImageIcon images = new ImageIcon("img/af9ce732beceb3e16b516a432a1d06173c91fe1b94c8-Dw3z14_fw554.jpg");
		JLabel jl = new JLabel(images);// ͼƬ��ǩ
		jl.setBounds(0, 0, 400, 600);
		con.add(jl);

		setSize(400, 600);// ��С
		setVisible(true);
		setLocationRelativeTo(null);// ����һ��ʼ���ֵ�λ��
	//	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// �ر�

	}
	class A  implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO �Զ����ɵķ������
		if (e.getSource() == b1) {
			if (t1.getText().trim() == null || t1.getText().trim().equals("")) {
				JOptionPane.showMessageDialog(null, "�������ǳ�");
				t1.requestFocus();// ���󽹵�
				return;
			} else if (paw1.getText() == null || paw1.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "����������");
				paw1.requestFocus();// ���󽹵�
				return;
			} else if (!paw1.getText().equals(paw2.getText())) {
				JOptionPane.showMessageDialog(null, "�������벻һ��");
				paw2.requestFocus();// ���󽹵�
				return;
			} else {
				// �ύ����
				QQuser qquer�ύ = new QQuser();
				qquer�ύ.setQqnum(qqnum());// qq��
				qquer�ύ.setQqname(t1.getText());// �ǳ�
				qquer�ύ.setPwd(paw1.getText());// ����
				// �Ա�
				if (r1.isSelected()) {// �Ƿ�ѡ��
					qquer�ύ.setSex("��");
				} else if (r2.isSelected()) {// �Ƿ�ѡ��
					qquer�ύ.setSex("Ů");
				}
				qquer�ύ.setFace("img/" + co1.getSelectedIndex() + ".png");// ͷ��
				qquer�ύ.setDate(co2.getSelectedItem().toString());// ����ũ��
				qquer�ύ.setYears(t2.getText());// ��
				qquer�ύ.setMonths(t3.getText());// ��
				qquer�ύ.setDprivate(t4.getText());// ��
				qquer�ύ.setCountry(t5.getText());// ����
				qquer�ύ.setProvince(t6.getText());// ʡ��
				qquer�ύ.setCity(t7.getText());// ����
				qquer�ύ.setStar(co3.getSelectedItem().toString());// ����
				qquer�ύ.setNation(co4.getSelectedItem().toString());// ����
				qquer�ύ.setMark(te1.getText());// ����˵��
				qquer�ύ.setIpadd("127.0.0.1");
				qquer�ύ.setPort(port());
				boolean bl = qqinterface.add(qquer�ύ);
				//�ȿ�����qqgame�˺ţ����У��ͽ������������ ���ã���Ϊ��ע�ᣬqqgame��������û��qqgame�˺�
				//int count = qqinterface.selQqgameAcount(String);
				//QQ��Ϸ�˺�
				QQgame qqgame=new QQgame();
				//Ҫ��ͬ
				qqgame.setQqnum(qquer�ύ.getQqnum());
				qqgame.setQqname(t1.getText());	
				qqgame.setVip("����");
				qqgame.setShenode(2);
				qqgame.setTxzgk(1);
				boolean bl2=qqinterface.addQqgame(qqgame);
				if (bl&bl2) {
					JOptionPane.showMessageDialog(null,
							"ע��ɹ�,ע���QQ�˺�Ϊ��" + qquer�ύ.getQqnum()+ ",����Ϊ��" + paw1.getText() + ",�����Ʊ���");
					t1.setText("");
					paw1.setText("");
					paw2.setText("");
					te1.setText("");
					t2.setText("2016��");
					t3.setText("1��");
					t4.setText("1��");
				} else {
					JOptionPane.showMessageDialog(null, "�������쳣");
				}
			}
		}
		if (e.getSource() == b2) {
			t1.setText("");
			paw1.setText("");
			paw2.setText("");
			te1.setText("");
			t2.setText("2016��");
			t3.setText("1��");
			t4.setText("1��");
			// c1.isSelected()�ж������Ƿ�ѡ��
			JOptionPane.showMessageDialog(null, "����ɹ�");

		}

	}
	}
	//�˿ڷ���
	public int port() {
		Random r = new Random();
		int i = r.nextInt(10000) + 10000;
		return i;
	}
	//�����
	class B extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {
			if(e.getSource()==xiao){//��С��
				dispose();
				
			}else if(e.getSource()==close){//�ر�
				dispose();
				
			}
			
		}
		public void mouseEntered(MouseEvent e){
			if(e.getSource()==xiao){
				xiao.setIcon(new ImageIcon("img/��ɫ����ͼƬ.png"));
				
			}
			if(e.getSource()==close){
				close.setIcon(new ImageIcon("img/loginclose.png"));
				
			}
		}
		public void mouseExited(MouseEvent e){
			if(e.getSource()==xiao){
				xiao.setIcon(new ImageIcon("img/xiao1.png"));//ԭ����ͼƬ
				
			}
			
			if(e.getSource()==close){
				close.setIcon(new ImageIcon("img/close1.png"));//ԭ����ͼƬ
				
			}
		}
		
	}
	//����ͼƬ����

	/***********/
	//���ý�������϶��ķ���
	
	Point loc = null;
	Point tmp = null;
	boolean isDragged = false;
	
	private void setDragable() {
		this.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseReleased(java.awt.event.MouseEvent e) {
				isDragged = false;
				ע�ᴰ��.this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			public void mousePressed(java.awt.event.MouseEvent e) {
				tmp = new Point(e.getX(), e.getY());

				isDragged = true;
				ע�ᴰ��.this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		this.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
			public void mouseDragged(java.awt.event.MouseEvent e) {
				if (isDragged) {
					loc = new Point(ע�ᴰ��.this.getLocation().x + e.getX() - tmp.x,
							ע�ᴰ��.this.getLocation().y + e.getY() - tmp.y);
					ע�ᴰ��.this.setLocation(loc);
				}
			}
		});
	}
	/***********/
	public String qqnum() {
		Random r = new Random();
		int i = r.nextInt(10000) + 1000;
		while (qqinterface.QQID(i + "")) {
			i = r.nextInt(10000) + 1000;// ����
		}
		return i + "";
	}

	public static void main(String dsf[]) {
		new ע�ᴰ��();
	}
}

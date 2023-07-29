package QQFind;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import com.sun.xml.internal.ws.client.SenderException;

import QQmain.QqfriendInfo;
import QQmain.SendMsg;
import QQ���ݿ���Ϣ.Contants;
import QQ���ݿ���Ϣ.QQMSG;
import QQ���ݿ���Ϣ.QQuser;
import �ӿ�.QQuserInterface;
import ����ʵ�ֽӿ�.QQuserimp;

public class QQfind extends JFrame{
	JLabel xiao,close,l1,l2,l3,l4;
	JTextField t1,t2,t3;
	String sexs[]={"-����-","��","Ů"};
	JButton j1,j2,j3,j4;
	JComboBox c1;
	Vector tilte,datas;//���� ����
	DefaultTableModel tab;
	JTable table;
	QQuserInterface qservice=new QQuserimp();//���غ�����Ϣ
	QQuser myuser;
	Vector<Vector> vv=new Vector<Vector>();
	public QQfind(QQuser myuser){
		super();
		this.myuser=myuser;
		//���������ʽ
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf."
					+ "windows.WindowsLookAndFeel");
		} catch (Exception e) {
			
		}
		Container con=getContentPane();//�����в���
		//con.setLayout(null);
		// ����ͼƬ
		setIconImage(new ImageIcon("img/touxiang1.png").getImage());
		this.setUndecorated(true);//�ޱ߿�
		//���ý�������϶��ķ���
		setDragable();
		
		xiao=new JLabel(new ImageIcon("img/xiao1.png"));
		xiao.setBounds(640, 0, 29, 28);
		con.add(xiao);
		xiao.setCursor(new Cursor(Cursor.HAND_CURSOR));//����
		
		close=new JLabel(new ImageIcon("img/close1.png"));
		close.setBounds(670, 0, 29, 28);
		con.add(close);
		close.setCursor(new Cursor(Cursor.HAND_CURSOR));//����
		
		//���
		JPanel top=new JPanel();
		top.setLayout(new FlowLayout());//FlowLayout.CENTER,20,3)
		
		l1=new JLabel("QQ��:");
		top.add(l1);
		
		t1=new JTextField(25);
		top.add(t1);
		
		l2=new JLabel("�ǳ�:");
		top.add(l2);
		
		t2=new JTextField(25);
		top.add(t2);
		
		l3=new JLabel("����:");
		top.add(l3);
		
		t3=new JTextField(5);
		top.add(t3);
		
		l4=new JLabel("�Ա�:");
		top.add(l4);
		
		c1=new JComboBox(sexs);
		top.add(c1);
		
		j1=new JButton("����");
		top.add(j1);
		con.add(top);
		top.setBounds(0, 30, 700, 30);
		
		//������
		Vector title=new Vector();
		title.add("QQ����");
		title.add("�ǳ�");
		title.add("����");
		title.add("�Ա�");
		title.add("����");	
		title.add("�ȼ�");
		title.add("����ǩ��...");
		this.tilte=title;
		
		Vector datas=new Vector();
		UIManager.put("TabbedPane.contentOpaque", false);
		tab=new DefaultTableModel();
		tab.setDataVector(datas, title);
		table=new JTable(tab);
		//������
		JScrollPane sp1=new JScrollPane(table);
		con.add(sp1);
		sp1.setBounds(0,80,700,280);
		
		//���
		j4=new JButton("�鿴����");
		con.add(j4);
		j4.setBounds(400,370,100,25);
		
		j2=new JButton("���ѡ�еĺ���");
		con.add(j2);
		j2.setBounds(500,370,120,25);
		
		j3=new JButton("ȡ��");
		con.add(j3);
		j3.setBounds(620,370,60,25);
		//����ͼƬ
		JLabel bg=new JLabel(new ImageIcon("img/QQfindbg.jpg"));
		con.add(bg);
		
		//����
		xiao.addMouseListener(new A());
		close.addMouseListener(new A());
		j1.addActionListener(new B());
		j2.addActionListener(new B());
		j3.addActionListener(new B());
		j4.addActionListener(new B());
		setSize(700,400);
		setVisible(true);
		setLocationRelativeTo(null);
		
	}
	class B implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource()==j1){
				//��ѡ�е��������������
				QQuser user=new QQuser();
				String qqnum=t1.getText().trim();
				String qqname=t2.getText().trim();
				String agestr=t3.getText().trim();
				int age=0;
				if(!agestr.equals("")){//��Ϊ�վ�ǿ��ת��
					age=Integer.parseInt(agestr);
				}
				String sex="";
				if(c1.getSelectedIndex()==1){
					sex="��";
					
				}else if(c1.getSelectedIndex()==2){
					sex="Ů";
				}
				user.setQqnum(qqnum);//����QQ�Ų�ѯ
				user.setQqname(qqname);//�����ѯ
				user.setAge(age);//�����ѯ
				user.setSex(sex);//�����ѯ
				//���ؽ����
				tab.setRowCount(0);
				vv=qservice.selusers(user);
				for(int i=0;i<vv.size();i++){
					Vector us=vv.get(i);//��ȡ
					tab.addRow(us);//����������
				}
				table.setFont(new Font("����",Font.BOLD,18));
				table.setForeground(new Color(179,102,102));
				table.setBackground(new Color(255,255,255));
			}
			
			if(e.getSource()==j2){
				//�ж��Ƿ�ѡ�е���
				if(table.getSelectedRow()>-1){
					//�ж��Ƿ�Ϊ�Լ�
					Vector user=vv.get(table.getSelectedRow());//ѡ�е�����
					String qqnum=user.get(0).toString();//��һ�е�QQ��
					if(qqnum.equals(myuser.getQqnum())){
						JOptionPane.showMessageDialog(null, "�㲻�ܰ��Լ����Ϊ���ѣ�");
						return;
					}
					//�ж��Ƿ��к���
					boolean bln=qservice.selhy(myuser.getQqnum(), qqnum);
					if(!bln){//�����ھ���Ӻ���
						JOptionPane.showMessageDialog(null, "������֤��Ϣ�ѷ���,��ȴ��ظ�");
						//����ʼ������Ϣ ��Ӻ�����Ϣ
						QQMSG msg=new QQMSG();
						msg.setCmd(Contants.CMD_ADDFRIEND);
						msg.setMyuser(myuser);
						//����ѡ�еĶ���
						QQuser hyuser=qservice.selQQuserbyfind(qqnum);
						msg.setFruser(hyuser);
						new SendMsg().send(msg);//����֪ͨ
					}else{//��
						JOptionPane.showMessageDialog(null, "�Է��Ѿ���������");
						return;
					}
				}
				
			}
			if(e.getSource()==j4){//�鿴ѡ�е�����
				Vector user=vv.get(table.getSelectedRow());//ѡ�е�����
				String qqnum=user.get(0).toString();//��һ�е�QQ��
				QQuser hyuser=qservice.selQQuserbyfind(qqnum);
				new QqfriendInfo(hyuser);
				
			}
			
		}
		
	}
	class A extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {
			if(e.getSource()==xiao){//��С��
				QQfind.this.setExtendedState(QQfind.this.ICONIFIED);//��ֵ̬
				
			}else if(e.getSource()==close){//�ر�		
				dispose();
			}
		}	
		public void mouseEntered(MouseEvent e){
			if(e.getSource()==xiao){
				xiao.setIcon(new ImageIcon("img/xiao1.png"));
				
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
	/***********/
	//���ý�������϶��ķ���
	
	Point loc = null;
	Point tmp = null;
	boolean isDragged = false;
	
	private void setDragable() {
		this.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseReleased(java.awt.event.MouseEvent e) {
				isDragged = false;
				QQfind.this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			public void mousePressed(java.awt.event.MouseEvent e) {
				tmp = new Point(e.getX(), e.getY());

				isDragged = true;
				QQfind.this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		this.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
			public void mouseDragged(java.awt.event.MouseEvent e) {
				if (isDragged) {
					loc = new Point(QQfind.this.getLocation().x + e.getX() - tmp.x,
							QQfind.this.getLocation().y + e.getY() - tmp.y);
					QQfind.this.setLocation(loc);
				}
			}
		});
	}
	/***********/
	public static void main(String[] args) {
		//new QQfind();
	}
}

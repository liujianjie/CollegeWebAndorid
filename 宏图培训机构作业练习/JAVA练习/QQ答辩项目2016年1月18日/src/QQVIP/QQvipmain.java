package QQVIP;

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

import QQLGO.QQfind;
import QQLGO.QQfind2;
import QQ���ݿ���Ϣ.QQuser;
import �ӿ�.QQuserInterface;
import ����ʵ�ֽӿ�.QQuserimp;

public class QQvipmain extends JFrame{
	JLabel biao,xiao,close,zhanghao,yan,tishi,num,genghuang,bg,bankid,time;
	JTextField t1,t2,t3,yan1,bankid1,time1;
	JTextArea yanzheng;
	JButton xia;
	QQuserInterface qserive=new QQuserimp();
	public QQvipmain(){
		super();
		Container con=getContentPane();
		//con.setLayout(null);
		this.setUndecorated(true);//�ޱ߿�
		//���ý�������϶��ķ���
		setDragable();
		biao = new JLabel("QQ��Աע��", JLabel.CENTER);// �����������
		Font f = new Font("����", Font.BOLD, 30);// ����
		biao.setFont(f);
		biao.setForeground(Color.red);// ��ɫ
		biao.setBounds(120, 45, 200, 40);
		con.add(biao);
		
		close=new JLabel(new ImageIcon("img/close1.png"));
		close.setBounds(370,0,29,28);
		close.setCursor(new Cursor(Cursor.HAND_CURSOR));//����
		con.add(close);
		
		zhanghao=new JLabel("�˺�:");
		zhanghao.setBounds(70,120,50,30);
		zhanghao.setFont(new Font("����",Font.PLAIN,15));
		con.add(zhanghao);
		
		t1=new JTextField();
		t1.setBounds(120,125,200,20);
		con.add(t1);
		
		bankid=new JLabel("���п���:");
		bankid.setBounds(40,170,80,30);
		bankid.setFont(new Font("����",Font.PLAIN,15));
		con.add(bankid);
		
		bankid1=new JTextField();
		bankid1.setBounds(120,175,200,20);
		con.add(bankid1);
		
		time=new JLabel("ʱ��:");
		time.setBounds(70,220,80,30);
		time.setFont(new Font("����",Font.PLAIN,15));
		con.add(time);
		
		time1=new JTextField("��");
		time1.setBounds(120,225,50,20);
		con.add(time1);
		
		yan=new JLabel("��֤��:");
		yan.setBounds(60,280,80,30);
		yan.setFont(new Font("����",Font.PLAIN,15));
		con.add(yan);
		
		yan1=new JTextField();
		yan1.setBounds(120,285,200,20);
		con.add(yan1);	
		
		tishi=new JLabel("���������µ��ַ�,�����ִ�Сд");
		tishi.setBounds(120,310,205,30);
		tishi.setFont(new Font("����",Font.PLAIN,10));
		con.add(tishi);
		
		yanzheng=new JTextArea();
		yanzheng.setFont(new Font("����",Font.BOLD,40));
		yanzheng.setEditable(false);//���ɱ༭
		yanzheng.setBounds(120,340,100,50);
		con.add(yanzheng);
		
		genghuang=new JLabel("��һ��");
		genghuang.setFont(new Font("����",Font.BOLD,13));
		genghuang.setForeground(Color.blue);
		genghuang.setBounds(230,358,50,30);
		con.add(genghuang);
		genghuang.setCursor(new Cursor(Cursor.HAND_CURSOR));//����
		
		xia=new JButton("ע��");
		xia.setBounds(140,440,120,30);
		con.add(xia);
		suiji();//����
		
		bg=new JLabel(new ImageIcon("img/vipͼƬ.jpg"));
		con.add(bg);
		//����
		xia.addMouseListener(new A());
		genghuang.addMouseListener(new A());
		close.addMouseListener(new A());
	
		setSize(400,500);
		setVisible(true);
		setLocationRelativeTo(null);
	}
	//�����֤
	public void suiji(){
		int a,b,c,d;
		String ch[]={"2","3","4","5","1","6","7","d","f","g","a","e","c","g","h","i","8","9","s","z","x","b","n"};
		a=new Random().nextInt(22);
		b=new Random().nextInt(22);
		c=new Random().nextInt(22);
		d=new Random().nextInt(22);
		String s=ch[a]+ch[b]+ch[c]+ch[d];
		yanzheng.setText(s);
	}
	
	
	class A extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {
			if(e.getSource()==close){//�ر�
				dispose();	
			}else if(e.getSource()==genghuang){
				suiji();
				
			}
			if(e.getSource()==xia){
				if(t1.getText().trim().equals("")||t1.getText().trim()==null){
					JOptionPane.showMessageDialog(null, "�������˺ţ�");
					return;
				}else if(yan1.getText().trim().equals("")||yan1.getText().trim()==null){
					JOptionPane.showMessageDialog(null, "��������֤�룡");
					return;
				}else if(!yan1.getText().equals(yanzheng.getText())){
					JOptionPane.showMessageDialog(null, "��֤������");
					suiji();
					yan1.setText("");
					return;
				}
				//�˺��Ƿ����
				QQuser quser=new QQuser();
				quser.setQqnum(t1.getText());//���ı��������ó���
				QQuser qq=qserive.chkqqnum(quser);//��ֵ���뷽���� �Ա�
				if(qq==null){
					JOptionPane.showMessageDialog(null, "�û������ڣ���˶Ժ�������");
					return;
				}else{
					//��Ϣ��ȷ�µĴ���
					boolean a=qserive.vipzhuce(t1.getText());
					if(a){
						JOptionPane.showMessageDialog(null, "ע��ɹ�");
					}
					dispose();
					
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
				QQvipmain.this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			public void mousePressed(java.awt.event.MouseEvent e) {
				tmp = new Point(e.getX(), e.getY());

				isDragged = true;
				QQvipmain.this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		this.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
			public void mouseDragged(java.awt.event.MouseEvent e) {
				if (isDragged) {
					loc = new Point(QQvipmain.this.getLocation().x + e.getX() - tmp.x,
							QQvipmain.this.getLocation().y + e.getY() - tmp.y);
					QQvipmain.this.setLocation(loc);
				}
			}
		});
	}
	/***********/	
	public static void main(String[] args) {
		new QQvipmain();
	}
}

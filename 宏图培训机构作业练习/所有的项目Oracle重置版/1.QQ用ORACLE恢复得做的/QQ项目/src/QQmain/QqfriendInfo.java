package QQmain;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import QQ���ݿ���Ϣ.QQuser;

//������һ����� 
public class QqfriendInfo extends JFrame{
	JLabel xiao,close,qqname,face,qqnum,level,mark;
	JLabel zhanghao,nicheng,beizhu,fengzu,gerenshuo,geren,guxiang,suozaidi;
	JLabel zhang,ni,bei,feng,gerens,ge,gu,suo;
	JPanel p1,p2,p3,p4,p5,p6;
	JLabel zltu;
	public QqfriendInfo(QQuser qqhy){
		super();
		Container con=getContentPane();
		
		this.setUndecorated(true);//�ޱ߿�
		
		xiao=new JLabel(new ImageIcon("img/xiao1.png"));
		xiao.setBounds(400,0,29,28);
		con.add(xiao);
		xiao.setCursor(new Cursor(Cursor.HAND_CURSOR));//����
		
		close=new JLabel(new ImageIcon("img/close1.png"));
		close.setBounds(430,0,29,28);
		con.add(close);
		close.setCursor(new Cursor(Cursor.HAND_CURSOR));//����
		
		face=new JLabel(new ImageIcon(qqhy.getFace()));
		face.setBounds(10, 100, 60, 60);
		con.add(face);
		
		qqname=new JLabel(qqhy.getQqname());
		qqname.setBounds(80,90,150,30);
		qqname.setFont(new Font("����", Font.BOLD, 25));
		qqname.setForeground(Color.white);
		con.add(qqname);
		
		qqnum=new JLabel(qqhy.getQqnum());
		qqnum.setBounds(220,93,300,30);
		qqnum.setFont(new Font("����",Font.PLAIN,15));
		qqnum.setForeground(Color.white);
		con.add(qqnum);
		
		level=new JLabel("LEV"+qqhy.getLevels());
		level.setBounds(80,115,100,30);
		level.setFont(new Font("����",Font.PLAIN,15));
		level.setForeground(Color.white);
		con.add(level);
		
		mark=new JLabel(qqhy.getMark());
		mark.setBounds(80,140,300,30);
		mark.setForeground(Color.white);
		mark.setFont(new Font("����",Font.PLAIN,15));
		con.add(mark);
		
		//ѡ�
		p1=new JPanel();
		JTabbedPane tab = new JTabbedPane();
		//�½����
		p1=new JPanel();
		p2=new JPanel();
		p3=new JPanel();
		p4=new JPanel();
		p5=new JPanel();
		p6=new JPanel();
		
		p1.setLayout(null);
		zhanghao=new JLabel("��    ��:");
		zhanghao.setBounds(15,60,100,30);
		p1.add(zhanghao);
		
		zhang=new JLabel(qqhy.getQqnum());
		zhang.setBounds(80,60,200,30);
		p1.add(zhang);
		
		nicheng=new JLabel("��    ��:");
		nicheng.setBounds(15,110,100,30);
		p1.add(nicheng);
		
		ni=new JLabel(qqhy.getQqname());
		ni.setBounds(80,110,200,30);
		p1.add(ni);
		
		beizhu=new JLabel("��    ע:");
		beizhu.setBounds(15,160,100,30);
		p1.add(beizhu);
		
		bei=new JLabel("��");
		bei.setBounds(80,160,200,30);
		p1.add(bei);
		
		fengzu=new JLabel("��    ��:");
		fengzu.setBounds(15,210,100,30);
		p1.add(fengzu);
		
		feng=new JLabel("����");
		feng.setBounds(80,210,200,30);
		p1.add(feng);
		
		gerenshuo=new JLabel("����˵��");
		gerenshuo.setBounds(15,260,100,30);
		p1.add(gerenshuo);
		
		gerens=new JLabel(qqhy.getMark());
		gerens.setBounds(80,260,200,30);
		p1.add(gerens);
		
		geren=new JLabel("��    ��:");
		geren.setBounds(15,310,100,30);
		p1.add(geren);
		
		ge=new JLabel(qqhy.getSex()+" "+qqhy.getYears()+qqhy.getMonths()+qqhy.getDprivate()+" "+qqhy.getStar());
		ge.setBounds(80,310,200,30);
		p1.add(ge);
		
		guxiang=new JLabel("��    ��:");
		guxiang.setBounds(15,360,100,30);
		p1.add(guxiang);
		
		gu=new JLabel(qqhy.getCountry()+" "+qqhy.getProvince()+" "+qqhy.getCity());
		gu.setBounds(80,360,200,30);
		p1.add(gu);
		
		
		tab.add("  ����  ",p1);
		tab.add("  ���  ",p2);
		tab.add("  ��̬  ",p3);
		tab.add("  ���ܶ�  ",p4);
		tab.add("  ��ǩ  ",p5);
		tab.add("  ��Ϸ  ",p6);
	//	JScrollPane spane=new JScrollPane(tab);//�������ӹ���
		tab.setBounds(0,185,460,420);
		con.add(tab);
		
		zltu=new JLabel(new ImageIcon("img/qqziliao1.png"));
		zltu.setBounds(0,605,255,30);
		con.add(zltu);
		//����
		xiao.addMouseListener(new B());
		close.addMouseListener(new B());
		setDragable();//�����ק
		
		//����ͼƬ
		String a=beitu();
		JLabel jl = new JLabel(new ImageIcon(a));// ͼƬ��ǩ
		//jl.setBounds(0, 0, 400, 600);
		con.add(jl);
		setSize(460,680);
		setVisible(true);
		setLocationRelativeTo(null);
	}
	public String beitu(){
		//���ͼƬ ֻ����һ��
		String chuangzhi="��ʼ��";
		Random beitu=new Random();
		String a[]={"img/bei1.jpg","img/bei2.jpg","img/bei3.jpg","img/bei4.jpg","img/bei5.jpg","img/bei8.jpg","img/bei9.jpg","img/bei10.jpg"};
		int b=beitu.nextInt(8);
		chuangzhi=a[b];
		return chuangzhi;
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
				xiao.setIcon(new ImageIcon("img/loginxiao.png"));
				
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
				QqfriendInfo.this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			public void mousePressed(java.awt.event.MouseEvent e) {
				tmp = new Point(e.getX(), e.getY());

				isDragged = true;
				QqfriendInfo.this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		this.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
			public void mouseDragged(java.awt.event.MouseEvent e) {
				if (isDragged) {
					loc = new Point(QqfriendInfo.this.getLocation().x + e.getX() - tmp.x,
							QqfriendInfo.this.getLocation().y + e.getY() - tmp.y);
					QqfriendInfo.this.setLocation(loc);
				}
			}
		});
	}
	/***********/
}

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
import QQ数据库信息.Contants;
import QQ数据库信息.QQMSG;
import QQ数据库信息.QQuser;
import 接口.QQuserInterface;
import 方法实现接口.QQuserimp;

public class QQfind extends JFrame{
	JLabel xiao,close,l1,l2,l3,l4;
	JTextField t1,t2,t3;
	String sexs[]={"-不限-","男","女"};
	JButton j1,j2,j3,j4;
	JComboBox c1;
	Vector tilte,datas;//标题 数据
	DefaultTableModel tab;
	JTable table;
	QQuserInterface qservice=new QQuserimp();//返回好友信息
	QQuser myuser;
	Vector<Vector> vv=new Vector<Vector>();
	public QQfind(QQuser myuser){
		super();
		this.myuser=myuser;
		//设置组件样式
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf."
					+ "windows.WindowsLookAndFeel");
		} catch (Exception e) {
			
		}
		Container con=getContentPane();//不能有布局
		//con.setLayout(null);
		// 窗口图片
		setIconImage(new ImageIcon("img/touxiang1.png").getImage());
		this.setUndecorated(true);//无边框
		//设置界面可以拖动的方法
		setDragable();
		
		xiao=new JLabel(new ImageIcon("img/xiao1.png"));
		xiao.setBounds(640, 0, 29, 28);
		con.add(xiao);
		xiao.setCursor(new Cursor(Cursor.HAND_CURSOR));//手型
		
		close=new JLabel(new ImageIcon("img/close1.png"));
		close.setBounds(670, 0, 29, 28);
		con.add(close);
		close.setCursor(new Cursor(Cursor.HAND_CURSOR));//手型
		
		//面板
		JPanel top=new JPanel();
		top.setLayout(new FlowLayout());//FlowLayout.CENTER,20,3)
		
		l1=new JLabel("QQ号:");
		top.add(l1);
		
		t1=new JTextField(25);
		top.add(t1);
		
		l2=new JLabel("昵称:");
		top.add(l2);
		
		t2=new JTextField(25);
		top.add(t2);
		
		l3=new JLabel("年龄:");
		top.add(l3);
		
		t3=new JTextField(5);
		top.add(t3);
		
		l4=new JLabel("性别:");
		top.add(l4);
		
		c1=new JComboBox(sexs);
		top.add(c1);
		
		j1=new JButton("查找");
		top.add(j1);
		con.add(top);
		top.setBounds(0, 30, 700, 30);
		
		//表格的列
		Vector title=new Vector();
		title.add("QQ号码");
		title.add("昵称");
		title.add("年龄");
		title.add("性别");
		title.add("名族");	
		title.add("等级");
		title.add("个性签名...");
		this.tilte=title;
		
		Vector datas=new Vector();
		UIManager.put("TabbedPane.contentOpaque", false);
		tab=new DefaultTableModel();
		tab.setDataVector(datas, title);
		table=new JTable(tab);
		//滚动条
		JScrollPane sp1=new JScrollPane(table);
		con.add(sp1);
		sp1.setBounds(0,80,700,280);
		
		//添加
		j4=new JButton("查看资料");
		con.add(j4);
		j4.setBounds(400,370,100,25);
		
		j2=new JButton("添加选中的好友");
		con.add(j2);
		j2.setBounds(500,370,120,25);
		
		j3=new JButton("取消");
		con.add(j3);
		j3.setBounds(620,370,60,25);
		//背景图片
		JLabel bg=new JLabel(new ImageIcon("img/QQfindbg.jpg"));
		con.add(bg);
		
		//监听
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
				//把选中的条件存入对象里
				QQuser user=new QQuser();
				String qqnum=t1.getText().trim();
				String qqname=t2.getText().trim();
				String agestr=t3.getText().trim();
				int age=0;
				if(!agestr.equals("")){//不为空就强制转换
					age=Integer.parseInt(agestr);
				}
				String sex="";
				if(c1.getSelectedIndex()==1){
					sex="男";
					
				}else if(c1.getSelectedIndex()==2){
					sex="女";
				}
				user.setQqnum(qqnum);//传入QQ号查询
				user.setQqname(qqname);//传入查询
				user.setAge(age);//传入查询
				user.setSex(sex);//传入查询
				//返回结果集
				tab.setRowCount(0);
				vv=qservice.selusers(user);
				for(int i=0;i<vv.size();i++){
					Vector us=vv.get(i);//读取
					tab.addRow(us);//加入数据中
				}
				table.setFont(new Font("宋体",Font.BOLD,18));
				table.setForeground(new Color(179,102,102));
				table.setBackground(new Color(255,255,255));
			}
			
			if(e.getSource()==j2){
				//判断是否选中的行
				if(table.getSelectedRow()>-1){
					//判断是否为自己
					Vector user=vv.get(table.getSelectedRow());//选中的数据
					String qqnum=user.get(0).toString();//第一列的QQ号
					if(qqnum.equals(myuser.getQqnum())){
						JOptionPane.showMessageDialog(null, "你不能把自己添加为好友！");
						return;
					}
					//判断是否有好友
					boolean bln=qservice.selhy(myuser.getQqnum(), qqnum);
					if(!bln){//不存在就添加好友
						JOptionPane.showMessageDialog(null, "好友验证信息已发送,请等待回复");
						//并开始发送消息 添加好友信息
						QQMSG msg=new QQMSG();
						msg.setCmd(Contants.CMD_ADDFRIEND);
						msg.setMyuser(myuser);
						//查找选中的对象
						QQuser hyuser=qservice.selQQuserbyfind(qqnum);
						msg.setFruser(hyuser);
						new SendMsg().send(msg);//发送通知
					}else{//有
						JOptionPane.showMessageDialog(null, "对方已经是您好友");
						return;
					}
				}
				
			}
			if(e.getSource()==j4){//查看选中的资料
				Vector user=vv.get(table.getSelectedRow());//选中的数据
				String qqnum=user.get(0).toString();//第一列的QQ号
				QQuser hyuser=qservice.selQQuserbyfind(qqnum);
				new QqfriendInfo(hyuser);
				
			}
			
		}
		
	}
	class A extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {
			if(e.getSource()==xiao){//最小化
				QQfind.this.setExtendedState(QQfind.this.ICONIFIED);//静态值
				
			}else if(e.getSource()==close){//关闭		
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
				xiao.setIcon(new ImageIcon("img/xiao1.png"));//原来的图片
				
			}
			
			if(e.getSource()==close){
				close.setIcon(new ImageIcon("img/close1.png"));//原来的图片
				
			}
		}
	}
	/***********/
	//设置界面可以拖动的方法
	
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

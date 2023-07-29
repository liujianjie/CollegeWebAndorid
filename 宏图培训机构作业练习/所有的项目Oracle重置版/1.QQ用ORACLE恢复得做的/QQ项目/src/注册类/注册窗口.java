package 注册类;

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

import QQ数据库信息.QQgame;
import QQ数据库信息.QQuser;
import QQcloudlet.QQweiyun;
import QQcloudlet.QQweiyunfafang;
import 接口.QQuserInterface;
import 方法实现接口.QQuserimp;

public class 注册窗口 extends JFrame{
	QQuserInterface qqinterface = new QQuserimp();
	QQweiyunfafang qservice=new QQweiyunfafang();
	JButton b1, b2;// 两个按钮

	JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14,xiao,close;// 8个标签

	JTextField t1, t2, t3, t4, t5, t6, t7;// 1个文本框

	JPasswordField paw1, paw2;// 两个密码框

	JRadioButton r1, r2;// 两个单选框

	JTextArea te1;// 一个文本域
	ButtonGroup g;// 性别组
	JComboBox co1, co2, co3, co4;// 三个下拉框
	String st1[] = { "公历", "农历" };// 为下拉框添加内容
	//String st2[] = { "一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月" };// 为下拉框添加内容
	String st3[] = { "白羊座", "金牛座", "双子座", "巨蟹座", "狮子座", "处女座", "天秤座", "天蝎座", "射手座", "水瓶座", "魔羯座", "双鱼座" };
	String st4[] = { "汉族", "回族", "维吾尔族", "藏族", "苗族 ", "彝族", "壮族", "朝鲜族", "满族", "水瓶座", "侗族", "畲族" };
	// 下拉框 转载图片
	// 引入图片
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

	public 注册窗口() {
		super("QQ2015注册窗口");
		Container con = getContentPane();
		con.setLayout(null);// 
		this.setUndecorated(true);//无边框
		
		xiao=new JLabel(new ImageIcon("img/xiao1.png"));
		xiao.setBounds(340,0,29,28);
		con.add(xiao);
		xiao.setCursor(new Cursor(Cursor.HAND_CURSOR));//手型
		
		close=new JLabel(new ImageIcon("img/close1.png"));
		close.setBounds(370,0,29,28);
		con.add(close);
		close.setCursor(new Cursor(Cursor.HAND_CURSOR));//手型
		
		xiao.addMouseListener(new B());
		close.addMouseListener(new B());
		setDragable();//鼠标拖拽
		
		l1 = new JLabel("QQ注册", JLabel.CENTER);// 所在区域居中
		Font f = new Font("宋体", Font.BOLD, 30);// 字体
		l1.setFont(f);
		l1.setForeground(Color.red);// 颜色
		l1.setBounds(140, 45, 150, 40);
		con.add(l1);

		l2 = new JLabel("昵称");
		l2.setBounds(70, 115, 30, 20);
		con.add(l2);

		t1 = new JTextField();
		t1.setBounds(120, 115, 200, 20);
		con.add(t1);

		l3 = new JLabel("密码");
		l3.setBounds(70, 155, 30, 20);
		con.add(l3);

		paw1 = new JPasswordField();
		paw1.setBounds(120, 155, 200, 20);
		con.add(paw1);

		l4 = new JLabel("确认密码");
		l4.setBounds(45, 195, 70, 20);
		con.add(l4);

		paw2 = new JPasswordField();
		paw2.setBounds(120, 195, 200, 20);
		con.add(paw2);

		l5 = new JLabel("性别");
		l5.setBounds(70, 245, 30, 20);
		con.add(l5);

		r1 = new JRadioButton("男");
		r1.setBounds(120, 245, 44, 20);
		con.add(r1);

		// 单选框默认选中
		r1.setSelected(true);
		r2 = new JRadioButton("女");
		r2.setBounds(160, 245, 44, 20);
		con.add(r2);

		// 把两个单选框何为一个组
		g = new ButtonGroup();
		g.add(r1);
		g.add(r2);

		// 加头像
		l11 = new JLabel("头像");
		l11.setBounds(205, 245, 60, 20);
		con.add(l11);

		co1 = new JComboBox(img);
		co1.setBounds(250, 220, 80, 60);
		con.add(co1);

		l7 = new JLabel("生日");
		l7.setBounds(70, 280, 30, 20);
		con.add(l7);

		co2 = new JComboBox(st1);
		co2.setBounds(120, 285, 60, 20);
		con.add(co2);

		t2 = new JTextField("2016年");
		t2.setBounds(185, 285, 50, 20);
		con.add(t2);

		t3 = new JTextField("1月");
		t3.setBounds(235, 285, 45, 20);
		con.add(t3);

		t4 = new JTextField("1日");
		t4.setBounds(280, 285, 50, 20);
		con.add(t4);

		l8 = new JLabel("所在地");
		l8.setBounds(60, 325, 80, 20);
		con.add(l8);

		t5 = new JTextField("中国");
		t5.setBounds(120, 325, 70, 20);
		con.add(t5);

		t6 = new JTextField("江西");
		t6.setBounds(190, 325, 70, 20);
		con.add(t6);

		t7 = new JTextField("赣州");
		t7.setBounds(260, 325, 70, 20);
		con.add(t7);

		l9 = new JLabel("星座");
		l9.setBounds(70, 365, 30, 20);
		con.add(l9);

		co3 = new JComboBox(st3);
		co3.setBounds(120, 365, 70, 20);
		co3.setEditable(false);
		con.add(co3);

		l9 = new JLabel("名族");
		l9.setBounds(200, 365, 30, 20);
		con.add(l9);

		co4 = new JComboBox(st4);
		co4.setBounds(240, 365, 70, 20);
		con.add(co4);

		l10 = new JLabel("个人说明");
		l10.setBounds(45,405, 80, 20);
		con.add(l10);

		te1 = new JTextArea();
		te1.setBounds(120, 405, 200, 100);
		con.add(te1);

		b1 = new JButton("注册");
		b1.setBounds(120, 535, 70, 30);
		con.add(b1);

		b2 = new JButton("清除");
		b2.setBounds(220, 535, 70, 30);
		con.add(b2);
		b1.addActionListener(new A());// 授权
		b2.addActionListener(new A());
		// 窗口图片
		setIconImage(new ImageIcon("img/touxiang1.png").getImage());
		/* 背景图片 */
		ImageIcon images = new ImageIcon("img/af9ce732beceb3e16b516a432a1d06173c91fe1b94c8-Dw3z14_fw554.jpg");
		JLabel jl = new JLabel(images);// 图片标签
		jl.setBounds(0, 0, 400, 600);
		con.add(jl);

		setSize(400, 600);// 大小
		setVisible(true);
		setLocationRelativeTo(null);// 窗口一开始出现的位置
	//	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 关闭

	}
	class A  implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if (e.getSource() == b1) {
			if (t1.getText().trim() == null || t1.getText().trim().equals("")) {
				JOptionPane.showMessageDialog(null, "请输入昵称");
				t1.requestFocus();// 请求焦点
				return;
			} else if (paw1.getText() == null || paw1.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "请输入密码");
				paw1.requestFocus();// 请求焦点
				return;
			} else if (!paw1.getText().equals(paw2.getText())) {
				JOptionPane.showMessageDialog(null, "两次密码不一致");
				paw2.requestFocus();// 请求焦点
				return;
			} else {
				// 提交数据
				QQuser qquer提交 = new QQuser();
				qquer提交.setQqnum(qqnum());// qq号
				qquer提交.setQqname(t1.getText());// 昵称
				qquer提交.setPwd(paw1.getText());// 密码
				// 性别
				if (r1.isSelected()) {// 是否选中
					qquer提交.setSex("男");
				} else if (r2.isSelected()) {// 是否选中
					qquer提交.setSex("女");
				}
				qquer提交.setFace("img/" + co1.getSelectedIndex() + ".png");// 头像
				qquer提交.setDate(co2.getSelectedItem().toString());// 公历农历
				qquer提交.setYears(t2.getText());// 年
				qquer提交.setMonths(t3.getText());// 月
				qquer提交.setDprivate(t4.getText());// 日
				qquer提交.setCountry(t5.getText());// 国家
				qquer提交.setProvince(t6.getText());// 省份
				qquer提交.setCity(t7.getText());// 城市
				qquer提交.setStar(co3.getSelectedItem().toString());// 星座
				qquer提交.setNation(co4.getSelectedItem().toString());// 名族
				qquer提交.setMark(te1.getText());// 个性说明
				qquer提交.setIpadd("127.0.0.1");
				qquer提交.setPort(port());
				boolean bl = qqinterface.add(qquer提交);
				//先看有无qqgame账号，若有，就结束不用添加了 不用，因为是注册，qqgame里面铁定没有qqgame账号
				//int count = qqinterface.selQqgameAcount(String);
				//QQ游戏账号
				QQgame qqgame=new QQgame();
				//要相同
				qqgame.setQqnum(qquer提交.getQqnum());
				qqgame.setQqname(t1.getText());	
				qqgame.setVip("不是");
				qqgame.setShenode(2);
				qqgame.setTxzgk(1);
				boolean bl2=qqinterface.addQqgame(qqgame);
				if (bl&bl2) {
					JOptionPane.showMessageDialog(null,
							"注册成功,注册的QQ账号为：" + qquer提交.getQqnum()+ ",密码为：" + paw1.getText() + ",请妥善保管");
					t1.setText("");
					paw1.setText("");
					paw2.setText("");
					te1.setText("");
					t2.setText("2016年");
					t3.setText("1月");
					t4.setText("1日");
				} else {
					JOptionPane.showMessageDialog(null, "服务器异常");
				}
			}
		}
		if (e.getSource() == b2) {
			t1.setText("");
			paw1.setText("");
			paw2.setText("");
			te1.setText("");
			t2.setText("2016年");
			t3.setText("1月");
			t4.setText("1日");
			// c1.isSelected()判断设置是否选中
			JOptionPane.showMessageDialog(null, "清除成功");

		}

	}
	}
	//端口方法
	public int port() {
		Random r = new Random();
		int i = r.nextInt(10000) + 10000;
		return i;
	}
	//鼠标点击
	class B extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {
			if(e.getSource()==xiao){//最小化
				dispose();
				
			}else if(e.getSource()==close){//关闭
				dispose();
				
			}
			
		}
		public void mouseEntered(MouseEvent e){
			if(e.getSource()==xiao){
				xiao.setIcon(new ImageIcon("img/灰色背景图片.png"));
				
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
	//窗口图片更换

	/***********/
	//设置界面可以拖动的方法
	
	Point loc = null;
	Point tmp = null;
	boolean isDragged = false;
	
	private void setDragable() {
		this.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseReleased(java.awt.event.MouseEvent e) {
				isDragged = false;
				注册窗口.this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			public void mousePressed(java.awt.event.MouseEvent e) {
				tmp = new Point(e.getX(), e.getY());

				isDragged = true;
				注册窗口.this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		this.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
			public void mouseDragged(java.awt.event.MouseEvent e) {
				if (isDragged) {
					loc = new Point(注册窗口.this.getLocation().x + e.getX() - tmp.x,
							注册窗口.this.getLocation().y + e.getY() - tmp.y);
					注册窗口.this.setLocation(loc);
				}
			}
		});
	}
	/***********/
	public String qqnum() {
		Random r = new Random();
		int i = r.nextInt(10000) + 1000;
		while (qqinterface.QQID(i + "")) {
			i = r.nextInt(10000) + 1000;// 生成
		}
		return i + "";
	}

	public static void main(String dsf[]) {
		new 注册窗口();
	}
}

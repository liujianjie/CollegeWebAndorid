package QQmain;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.Point;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Vector;

import javax.swing.AbstractListModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

import QQFind.QQfind;
import QQGAME.QQGame1;
import QQUPuser.QQupuser;
import QQcloudlet.QQcloudletmain;
import QQ数据库信息.Contants;
import QQ数据库信息.QQGAME;
import QQ数据库信息.QQMSG;
import QQ数据库信息.QQuser;
import QQcloudlet.QQweiyun;
import 接口.QQuserInterface;
import 方法实现接口.QQuserimp;
//面板的颜色是个问题 还有 找回密码 个人资料卡显示 空间 游戏中心 等等
public class qqmain extends JFrame{
	public JLabel xiao,close,xia,zt,fond,face,nicheng,levels,weiyun,text;
	JList list1,list2,list3,list4;
	Vector<QQuser> vec1,vec2,vec3,vec4;
	QQuserInterface qservice=new QQuserimp();//返回好友信息
	public QQuser qquser,fruser;//好友信息
	public QQGAME qqusergame;
	JPopupMenu popmenu,popmenu2;
	JMenuItem it1,it2,it3,it4,it5,it7,it6,it9,it8;//菜单项
	//唯一的聊天窗口 qq好 和聊天窗口
	Map<String, QQchat> chats=new HashMap<String,QQchat>();
	JPopupMenu pop,traypop2;//弹出式菜单
	JMenuItem itt1,itt2,itt3,itt4;
	JLabel mainxia,pifu,youxi,bg1,music;
	TrayIcon tray;//托盘图标
	PopupMenu traypop;
	MenuItem tt1,tt2,tt3,tt4,tt5,tt6;
	JTextArea ta1;
//	JMenuItem tt11,tt22,tt33,tt44;
	public qqmain(QQuser qqh,QQGAME qqusergame){
		super();
		//设置组件样式
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf."
					+ "windows.WindowsLookAndFeel");
		} catch (Exception e) {
			
		}
		/***********/
		this.qquser=qqh;//丫的 这句话一定要有 有有
		this.qqusergame=qqusergame;
		//------------------------------------------
		//把账号的昵称创过去
		qqusergame.setQqname(qqh.getQqname());
		qqusergame.setQqnum(qqh.getQqnum());
		Container con=getContentPane();//不能有布局
		// 窗口图片
		setIconImage(new ImageIcon("img/touxiang1.png").getImage());
		this.setUndecorated(true);//无边框
		//设置界面可以拖动的方法
		setDragable();
		caidan();//好友管理菜单项
		
//		traypop2();
		
		xiao=new JLabel(new ImageIcon("img/xiao1.png"));
		xiao.setBounds(220, 0, 29, 28);
		con.add(xiao);
		xiao.setCursor(new Cursor(Cursor.HAND_CURSOR));//手型
		
		close=new JLabel(new ImageIcon("img/close1.png"));
		close.setBounds(250, 0, 29, 28);
		con.add(close);
		close.setCursor(new Cursor(Cursor.HAND_CURSOR));//手型
		
		face=new JLabel(new ImageIcon(qqh.getFace()));//从数据库中获取头像 qqh这个形参
		face.setBounds(10, 50,60 ,60 );
		con.add(face);
		face.setCursor(new Cursor(Cursor.HAND_CURSOR));//手型
		
		//在线状态
		zt=new JLabel(new ImageIcon("img/s_online.png"));
		zt.setBounds(140,46,15,15);
		con.add(zt);
				
		nicheng=new JLabel(qqh.getQqname());//从数据库中获取昵称 qqh这个形参
		nicheng.setBounds(80, 40, 60,30);
		nicheng.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		con.add(nicheng);
		nicheng.setToolTipText(qqh.getQqname());
		nicheng.setForeground(Color.WHITE);//颜色
		
		//弹出框
		pop=new JPopupMenu();
		itt1=new JMenuItem("我在线上",new ImageIcon("img/s_online.png"));//我在线上
		itt2=new JMenuItem("隐身",new ImageIcon("img/s_hide.png"));
		itt3=new JMenuItem("忙碌",new ImageIcon("img/s_busy.png"));
		itt4=new JMenuItem("离开",new ImageIcon("img/s_leave.png"));
		pop.add(itt1);
		pop.addSeparator();
		pop.add(itt2);
		pop.addSeparator();
		pop.add(itt3);
		pop.addSeparator();
		pop.add(itt4);
		
		
		levels=new JLabel("LV" + qqh.getLevels());//从数据库中获取等级qqh这个形参
		levels.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		levels.setBounds(80, 55, 100, 50);
		con.add(levels);
		levels.setForeground(Color.yellow);//颜色
		
		text=new JLabel(qqh.getMark());//从数据库中获取个性签名qqh这个形参
		text.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		text.setBounds(80, 80, 200, 50);
		con.add(text);
		text.setForeground(Color.WHITE);//颜色
		//选项卡
		JTabbedPane tab = new JTabbedPane();
		//新建列表
		list1=new JList();
		list2=new JList();
		list3=new JList();
		list4=new JList();
		//改变列表信息 
		this.brush();
		tab.add("  好友  ",list1 );
		tab.add("  家人  ",list2);
		tab.add("  同学  ",list3);
		tab.add("  黑名单  ",list4);
		//tab.setForeground(Color.BLUE);
		tab.setBounds(0,135,280,430);
		con.add(tab);
		
		//查找好友
		fond=new JLabel(new ImageIcon());
		fond.setBounds(157,570,50,17);
		con.add(fond);
		fond.setCursor(new Cursor(Cursor.HAND_CURSOR));//手型
		//游戏和皮肤 还有下面
		pifu=new JLabel(new ImageIcon("img/pif.png"));
		pifu.setBounds(250, 110, 20, 20);
		con.add(pifu);
		pifu.setCursor(new Cursor(Cursor.HAND_CURSOR));//手型
		
		youxi=new JLabel(new ImageIcon("img/qqyouxi.png"));
		youxi.setBounds(215, 105, 28, 28);
		con.add(youxi);
		youxi.setCursor(new Cursor(Cursor.HAND_CURSOR));//手型
		
		music=new JLabel(new ImageIcon("img/QQmusic2.png"));
		music.setBounds(180, 110, 20, 20);
		con.add(music);
		music.setCursor(new Cursor(Cursor.HAND_CURSOR));//手型
		
		weiyun=new JLabel(new ImageIcon("img/weiyun2.png"));
		weiyun.setBounds(145, 110, 20, 20);
		con.add(weiyun);
		weiyun.setCursor(new Cursor(Cursor.HAND_CURSOR));//手型
		
		mainxia=new JLabel(new ImageIcon("img/QQmainxia.png"));
		mainxia.setBounds(0,565,280,35);
		con.add(mainxia);
		
		//监听
		weiyun.addMouseListener(new A());
		music.addMouseListener(new A());
		face.addMouseListener(new A());
		pifu.addMouseListener(new A());
		youxi.addMouseListener(new A());
		fond.addMouseListener(new A());
		xiao.addMouseListener(new A());
		close.addMouseListener(new A());
		list1.addMouseListener(new A());
		list2.addMouseListener(new A());
		list3.addMouseListener(new A());
		list4.addMouseListener(new A());//这list加的是弹出菜单监听
		this.addWindowListener(new window());
		zt.addMouseListener(new A());
		itt1.addActionListener(new Action());
		itt2.addActionListener(new Action());
		itt3.addActionListener(new Action());
		itt4.addActionListener(new Action());//这4个是菜单项选择监听
//		
//		System.out.println(wy.getQqnum());
		//屏幕大小
		Toolkit tk=Toolkit.getDefaultToolkit();
		int x=(int)tk.getScreenSize().width;
		setSize(280,600);
		//背景图片
		bg1=new JLabel(new ImageIcon("img/man6.png"));
		con.add(bg1);
		
		setVisible(true);
		setLocation(x-320,50);
		
		new D().start();//线程
		if(qquser.getStatus()==Contants.on_line){//在线
			this.notic(Contants.CMD_INLINE);//上线通知
			zt.setIcon(new ImageIcon("img/s_online.png"));
		}else if(qquser.getStatus()==Contants.HIDE){//隐身
			//不需要
			zt.setIcon(new ImageIcon("img/s_hide.png"));
		}else if(qquser.getStatus()==Contants.busy){//忙碌
			this.notic(Contants.CMD_BUSY);//上线通知
			zt.setIcon(new ImageIcon("img/s_busy.png"));
		}else if(qquser.getStatus()==Contants.Off_line){//离开
			this.notic(Contants.CMD_LEAVE);//上线通知
			zt.setIcon(new ImageIcon("img/s_leave.png"));
		}
		
	}	
	//状态改变值 应该通知哪些人？ 好友 同学 家人
	public void notic(int cmd){
		for(int i=0;i<vec1.size();i++){
			QQuser qq=vec1.get(i);
			if(qq.getStatus()!=Contants.STATE_DownLINE){//不是离线的
				QQMSG msg=new QQMSG();
				msg.setCmd(cmd);
				msg.setMyuser(qquser);//我自己
				msg.setFruser(qq);//所有人
				new SendMsg().send(msg);
			}
			
		}
		for(int i=0;i<vec2.size();i++){
			QQuser qq=vec2.get(i);
			if(qq.getStatus()!=Contants.STATE_DownLINE){//不是离线的
				QQMSG msg=new QQMSG();
				msg.setCmd(cmd);
				msg.setMyuser(qquser);//我自己
				msg.setFruser(qq);//所有人
				new SendMsg().send(msg);
			}
			
		}
		for(int i=0;i<vec3.size();i++){
			QQuser qq=vec3.get(i);
			if(qq.getStatus()!=Contants.STATE_DownLINE){//不是离线的
				QQMSG msg=new QQMSG();
				msg.setCmd(cmd);
				msg.setMyuser(qquser);//我自己
				msg.setFruser(qq);//所有人
				new SendMsg().send(msg);
			}
		}
		for(int i=0;i<vec4.size();i++){
			QQuser qq=vec4.get(i);
			if(qq.getStatus()!=Contants.STATE_DownLINE){//不是离线的
				QQMSG msg=new QQMSG();
				msg.setCmd(cmd);
				msg.setMyuser(qquser);//我自己
				msg.setFruser(qq);//所有人
				new SendMsg().send(msg);
			}
			
		}
	}
	
	//创建托盘图片方法
	public void createTrayIcon(){
		traypop();//托盘菜单项
		Image img=new ImageIcon(qquser.getFace()).getImage();
		tray=new TrayIcon(img,"QQ:"+qquser.getQqname()
					+"("+qquser.getQqnum()+")",traypop);
		tray.setImageAutoSize(true);
		tray.addMouseListener(new A());
	}
	//正在关闭
	class window extends WindowAdapter{
		@Override
		public void windowIconified(WindowEvent e) {
			SystemTray sys=SystemTray.getSystemTray();
			if(tray!=null){
				sys.remove(tray);//移除
				
			}
			createTrayIcon();
			try {
				sys.add(tray);
				qqmain.this.setVisible(false);
			} catch (AWTException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
			
		}
		@Override
		public void windowClosing(WindowEvent e) {
			qservice.updstate(qquser.getQqnum(), Contants.STATE_DownLINE);//离线
			//发送离线
			notic(Contants.CMD_OFFLINE);//发送离线消息
		}

	}
	//托盘菜单项
	public void traypop(){
		traypop=new PopupMenu();
		tt5=new MenuItem("打开主面板");
		tt6=new MenuItem("退出");
		traypop.add(tt5);
		traypop.add(tt6);
		tt5.addActionListener(new Action());
		tt6.addActionListener(new Action());//这6个是托盘项选择监听
	}
	//弹出式菜单
	public void caidan(){
		popmenu=new JPopupMenu();//菜单
		popmenu2=new JPopupMenu();//菜单
		it1=new JMenuItem("发送即时消息");
		it2=new JMenuItem("删除好友");
		it3=new JMenuItem("好友资料");
		it4=new JMenuItem("移至好友");
		it5=new JMenuItem("移至家人");
		it6=new JMenuItem("移至同学");
		it7=new JMenuItem("移至黑名单");
		it8=new JMenuItem("查看个人资料");
		it9=new JMenuItem("修改资料");
		popmenu2.add(it8);
		popmenu2.add(it9);
		popmenu.add(it1);
		popmenu.add(it2);
		popmenu.add(it3);
		popmenu.add(it4);
		popmenu.add(it5);
		popmenu.add(it6);
		popmenu.add(it7);	
	//	popmenu.addMouseListener(new A());
		it1.addActionListener(new Action());
		it2.addActionListener(new Action());
		it3.addActionListener(new Action());
		it4.addActionListener(new Action());
		it5.addActionListener(new Action());
		it6.addActionListener(new Action());
		it7.addActionListener(new Action());//这7个是菜单项选择监听
		it8.addActionListener(new Action());
		it9.addActionListener(new Action());//这7个是菜单项选择监听
	}
	//打开聊天窗口的方法
	public QQchat openchat(String frqqnum,QQMSG msg){
		QQchat chat=chats.get(frqqnum);//获取键值判断是否存在
		if(chat==null){//没有
			if(msg==null){//自己打开的聊天类 main中  不是弹出来的
				//弹出普通本main中的聊天窗口
				chat=new QQchat(qquser,fruser);//正常的
			}else{
				//弹出 自动弹出的聊天窗口 我变成好友
				chat=new QQchat(msg.getFruser(),msg.getMyuser());//更换的
			}
			chats.put(frqqnum,chat);//放入键值中
		}
		if(!chat.isVisible()){//如果它是隐藏的
			chat.setVisible(true);//显示
			chat.t1.setText("");//清空
		}
		return chat;
	}
	
	//我的ip和端口
	class D extends Thread{//线程 一直接收消息
		public void run() {
			try {
				int port=qquser.getPort();
				DatagramSocket ds=new DatagramSocket(port);//构建服务器
				while(true){
					byte[] b=new byte[1024*80];//每次接收80字节 40字
					DatagramPacket dp=new DatagramPacket(b, b.length);//接收信息			
					ds.receive(dp);//接收
					//转换
					ByteArrayInputStream bis=new ByteArrayInputStream(b,0,dp.getLength());
					ObjectInputStream bos=new ObjectInputStream(bis);
					//得到消息对象
					QQMSG msg=(QQMSG)bos.readObject();
					int cmd=msg.cmd;
					//判断为什么消息类型
					if(cmd==Contants.CMD_FLUSH){//资料修改
						brush();
						System.out.println("sdfdsf");
					}
					else if(cmd==Contants.CMD_CHAT){//聊天通知
						//弹出聊天窗口 在QQ好友的面板上弹出聊天框 以我的QQ号存储信息
						QQchat chat=openchat(msg.myuser.getQqnum(),msg);//以QQ号存储信息
						//内容显示在聊天窗口上 此时 我变成QQ好友 ，信息
						chat.appendView(msg.myuser.getQqname(),msg.doc);
					}else if(cmd==Contants.CMD_SHKAE){//抖动通知
						QQchat chat=openchat(msg.myuser.getQqnum(),msg);
						chat.shake();
						chat.appendView(msg.myuser.getQqname(),msg.doc);
	
					}else if(cmd==Contants.CMD_ADDFRIEND){//添加好友通知
						//添加声音
						new Sound("system.wav");
						String message=msg.getMyuser().getQqname()+"添加您为好友，是否添加?";
						int	j=JOptionPane.showConfirmDialog(null, message, "添加好友", JOptionPane.OK_CANCEL_OPTION);
						QQMSG mm=new QQMSG();
						mm.setMyuser(msg.getFruser());
						mm.setFruser(msg.getMyuser());
						if(j==0){
							//确定 同意 向好友表添加两条好友数据
							qservice.addfrid(msg.getMyuser().getQqnum(), msg.getFruser().getQqnum(), "好友");
							//默认添加到好友中 可以在是否添加时移动分组
							brush();
							mm.setCmd(Contants.CMD_AGRRN);//同意的消息
							
						}else if(j==2){
							mm.setCmd(Contants.CMD_NO);//拒绝的消息
							
						}
						new SendMsg().send(mm);
					}else if(cmd==Contants.CMD_INLINE){//上线通知
						new Sound("Global.wav");//声音
						brush();//刷新面板
						new TipUi(msg.getMyuser());//弹框
						
					}else if(cmd==Contants.CMD_OFFLINE){//离线通知
						brush();//刷新面板
						
					}else if(cmd==Contants.CMD_BUSY){//忙碌通知
						brush();
						
					}else if(cmd==Contants.CMD_LEAVE){//离开通知
						brush();
						
					}else if(cmd==Contants.CMD_HIDE){//隐身通知
						brush();
						
					}else if(cmd==Contants.CMD_NO){//拒绝添加
						JOptionPane.showMessageDialog(null, msg.getMyuser()+"拒绝了你");
					}else if(cmd==Contants.CMD_AGRRN){//同意添加
						JOptionPane.showMessageDialog(null, msg.getMyuser().getQqname()+"同意将你添加好友");
						brush();
					}else if(cmd==Contants.CMD_DELFRIEND){//删除好友
						brush();
						
					}else if(cmd==Contants.CMD_SENDFILE){//发送文件
						int j=JOptionPane.showConfirmDialog(null, msg.getMyuser().getQqname()+"向你发送了"+msg.getFilename()+"文件是否接受？","接受文件",JOptionPane.OK_CANCEL_OPTION);
						QQMSG mm=new QQMSG();
						mm.setMyuser(msg.getFruser());//
						mm.setFruser(msg.getMyuser());//
						//同意拒绝
						if(j==0){
							FileDialog fd=new FileDialog(qqmain.this,"接收文件",FileDialog.SAVE);//保存文件
							fd.setFile(msg.getFilename());//默认名字
							fd.show();
							String filename=fd.getDirectory()+"\\"+fd.getFile();
							File f=new File(filename);
							if(!f.exists()){
								f.createNewFile();//创建
								
							}
							FileOutputStream fout=new FileOutputStream(f);
							//循环接收
							//循环读取文件
							//while(fout.write(msg.getB())!=-1){
							
							fout.write(msg.getB());
							
							fout.close();
							//发送同意通知
							mm.setCmd(Contants.CMD_FILEAGRRN);
						}else if(j==2){
							//发送拒绝通知
							mm.setCmd(Contants.CMD_FILENO);
						}
						new SendMsg().send(mm);
					}else if(cmd==Contants.CMD_FILEAGRRN){//同意接受文件
						JOptionPane.showMessageDialog(null, msg.getMyuser().getQqname()+"接收了您的文件");
						
					}else if(cmd==Contants.CMD_FILENO){//拒绝接受文件
						JOptionPane.showConfirmDialog(null, msg.getMyuser().getQqname()+"拒绝接收您的文件");
						
					}
				
				}
			} catch (Exception e) {

			}
		}
		
	}

	class Action implements ActionListener{
		//是否点击菜单项
		public void actionPerformed(ActionEvent e) {
			//托盘图标
			
			if(e.getSource()==tt5){
				qqmain.this.setVisible(true);
				qqmain.this.setState(JFrame.NORMAL);//默认状态
	
			}
			else if(e.getSource()==tt6){
				qservice.updstate(qquser.getQqnum(), Contants.STATE_DownLINE);//离线
				//发送离线
				notic(Contants.CMD_OFFLINE);//放松消息
				System.exit(0);
	
			}
			
			if(e.getSource()==itt1){//点击菜单项改变这个用户的状态
				QQuser jieshou=qservice.selzt(qquser.getQqnum());
				//改变图片
				zt.setIcon(new ImageIcon("img/s_online.png"));
				if(jieshou.getStatus()!=Contants.on_line){//不让用户一直为上线状态
				qservice.updstate(qquser.getQqnum(),Contants.on_line);
				notic(Contants.CMD_INLINE);//在线		
				System.out.println(qquser.getStatus());
				}
			}else if(e.getSource()==itt2){
				zt.setIcon(new ImageIcon("img/s_hide.png"));
				qservice.updstate(qquser.getQqnum(),Contants.HIDE);
				notic(Contants.CMD_HIDE);//隐身
			}else if(e.getSource()==itt3){
				zt.setIcon(new ImageIcon("img/s_busy.png"));
				qservice.updstate(qquser.getQqnum(),Contants.busy);
				notic(Contants.CMD_BUSY);//忙碌
			}else if(e.getSource()==itt4){
				zt.setIcon(new ImageIcon("img/s_leave.png"));
				qservice.updstate(qquser.getQqnum(),Contants.Off_line);
			//	System.out.println("离开状态");
				notic(Contants.CMD_LEAVE);//离开
			}
			
			
			if(e.getSource()==it1){
				openchat(fruser.getQqnum(),null);//打开聊天窗口 记录的QQ号为好友的
			}else if(e.getSource()==it2){
				//删除好友
				qservice.upfrid(qquser.getQqnum(), fruser.getQqnum());
				brush();
				//发送通知 删除好友
				QQMSG mm=new QQMSG();
				mm.setMyuser(qquser);
				mm.setFruser(fruser);
				mm.setCmd(Contants.CMD_DELFRIEND);
				new SendMsg().send(mm);
			}else if(e.getSource()==it3){
				new QqfriendInfo(fruser);
				
			}else if(e.getSource()==it4){
				qservice.movegroup(qquser.getQqnum(), fruser.getQqnum(), "好友");
				brush();
			}else if(e.getSource()==it5){
				qservice.movegroup(qquser.getQqnum(), fruser.getQqnum(), "家人");
				brush();
			}else if(e.getSource()==it6){
				qservice.movegroup(qquser.getQqnum(), fruser.getQqnum(), "同学");
				brush();
			}else if(e.getSource()==it7){
				qservice.movegroup(qquser.getQqnum(), fruser.getQqnum(), "黑名单");
				brush();
			}else if(e.getSource()==it8){
				new QqfriendInfo(qquser);
			}else if(e.getSource()==it9){
				new QQupuser(qquser,qqmain.this);
			}

		}
	}
	class A extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {
			if(e.getSource()==face){
//				new QQupuser(qquser,qqmain.this);
				popmenu2.show(face, e.getX(), e.getY());
			}
			//点击窗口图标显示main
			if(e.getSource()==tray&&e.getButton()==1){
				qqmain.this.setVisible(true);
				qqmain.this.setState(JFrame.NORMAL);//默认状态
				
			}
			//main中功能
			if(e.getSource()==weiyun){
				new QQcloudletmain(qquser);
				
			}else if(e.getSource()==music){
				String url = "E:/宏图课程/JAVA上课列子/QQ/qq皮肤/酷狗音乐";
				java.net.URI uri = java.net.URI.create(url);
				// 获取当前系统桌面扩展
				java.awt.Desktop dp = java.awt.Desktop.getDesktop();
				// 判断系统桌面是否支持要执行的功能
				if (dp.isSupported(java.awt.Desktop.Action.BROWSE)) {
					try {
						dp.browse(uri);
					} catch (Exception e1) {

					}// 获取系统默认浏览器打开链接
				}
				
			}else if(e.getSource()==fond){
				new QQfind(qquser);
			}else if(e.getSource()==pifu){//皮肤
				//随机图片
				Random r=new Random();
				int i=r.nextInt(5);//0-4
				String str[]={"img/main2.jpg","img/main3.jpg","img/main4.jpg","img/main5.jpg","img/man6.png"};
				bg1.setIcon(new ImageIcon(str[i]));//下标
			}else if(e.getSource()==youxi){//游戏
				new QQGame1(qqusergame);
			}
			if(e.getSource()==zt){
				pop.show(zt, e.getX(), e.getY());
				
			}
			else if(e.getSource()==xiao){//最小化
				qqmain.this.setExtendedState(qqmain.this.ICONIFIED);//静态值
				
			}else if(e.getSource()==close){//关闭		
				qservice.updstate(qquser.getQqnum(), Contants.STATE_DownLINE);//离线
				//发送离线
				notic(Contants.CMD_OFFLINE);//放松消息
				System.exit(0);
			}
			//弹出菜单
			if(e.getSource()==list1){//列表
				if(list1.getSelectedIndex()>=0){
				fruser=vec1.get(list1.getSelectedIndex());
				if(e.getButton()==3){//右键
					popmenu.show(list1, e.getX(), e.getY());
					
				}
				//双击左键
				if(e.getButton()==1&&e.getClickCount()==2){
					openchat(fruser.getQqnum(),null);//打开聊天窗口 QQ号为好友的
				}
				}
			}
			
			if(e.getSource()==list2){//列表
				if(list2.getSelectedIndex()>=0){
				fruser=vec2.get(list2.getSelectedIndex());
				if(e.getButton()==3){//右键
					popmenu.show(list2, e.getX(), e.getY());
					
				}
				//双击左键
				if(e.getButton()==1&&e.getClickCount()==2){
					openchat(fruser.getQqnum(),null);//打开聊天窗口 QQ号为好友的
				}
				}
			}
			
			if(e.getSource()==list3){//列表
				if(list3.getSelectedIndex()>=0){
				fruser=vec3.get(list3.getSelectedIndex());
				if(e.getButton()==3){//右键
					popmenu.show(list3, e.getX(), e.getY());
					
				}
				//双击左键
				if(e.getButton()==1&&e.getClickCount()==2){
					openchat(fruser.getQqnum(),null);//打开聊天窗口 QQ号为好友的
				}
				}
			}
			
			if(e.getSource()==list4){//列表
				if(list4.getSelectedIndex()>=0){
				fruser=vec4.get(list4.getSelectedIndex());
				if(e.getButton()==3){//右键
					popmenu.show(list4, e.getX(), e.getY());
					
				}
				//双击左键
				if(e.getButton()==1&&e.getClickCount()==2){
					openchat(fruser.getQqnum(),null);//打开聊天窗口 QQ号为好友的
				}
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
	public void brush(){
		vec1=qservice.selectusergroupname(qquser.getQqnum(),Contants.friend);//好友
		//vec1=qservice.selectusergroupname("6208","好友");//好友
		vec2=qservice.selectusergroupname(qquser.getQqnum(),Contants.family);//家人
		vec3=qservice.selectusergroupname(qquser.getQqnum(),Contants.schoolmate);//同学
		vec4=qservice.selectusergroupname(qquser.getQqnum(),Contants.blacklist);//黑名单
		//这里调用 有好友列表信息的代码
		list1.setModel(new B(vec1));
		list1.setCellRenderer(new C(vec1));
		
		list2.setModel(new B(vec2));
		list2.setCellRenderer(new C(vec2));
		
		list3.setModel(new B(vec3));
		list3.setCellRenderer(new C(vec3));
		
		list4.setModel(new B(vec4));
		list4.setCellRenderer(new C(vec4));
		
	}
	
	//列表模型
	class B extends AbstractListModel{
		Vector<QQuser> vv=new Vector<QQuser>();
		//构造方法
		public B(Vector<QQuser> users){
			this.vv=users;	
		}
		@Override
		public int getSize() {
			// TODO 自动生成的方法存根
			return vv.size();//返回好友多少的大小
		}

		@Override
		public Object getElementAt(int index) {
			// TODO 自动生成的方法存根
			return null;
		}
	}
	//动态改变list好友 列表的值
	class C extends DefaultListCellRenderer{
		Vector<QQuser> datas=new Vector<QQuser>();
		public C(Vector<QQuser> users){
			this.datas=users;
			
		}
		//真正的方法
		public Component getListCellRendererComponent(JList list, Object value,
				int index, boolean isSelected, boolean cellHasFocus){
			//JList 有数据才进去
		//	System.out.println("傻逼");
			if(index>=0&&index<=datas.size()){
				QQuser quser=datas.get(index);
				String icon=quser.getFace();//图片路径
			//	System.out.println("傻逼");
				//设置头像
				//根据status来改变图像状态
				if(quser.getStatus()==Contants.STATE_DownLINE||
						quser.getStatus()==Contants.HIDE){//离线或隐身
					icon=icon.substring(0, icon.indexOf("."));
					icon=icon+"_h.png";
				//	System.out.println("hhhhhhhhh");
				}else if(quser.getStatus()==Contants.on_line){
					//在线不判断
				}else if(quser.getStatus()==Contants.busy){
					//忙碌 不要打捞
					icon=icon.substring(0,icon.indexOf("."));
					icon=icon+"_w.png";
				}else if(quser.getStatus()==Contants.Off_line){
					//离开
					icon=icon.substring(0,icon.indexOf("."));
					icon=icon+"_l.png";
					//System.out.println("hhe");
				}
				//设置图片
				setIcon(new ImageIcon(icon));
				// 给jlist设置QQ号和签名
				setText(quser.getQqname() + "(" + quser.getQqnum() + ")\n"
						+ quser.getMark());
			}
			//设置鼠标经过的样式
			if (isSelected) {// 如果被选中了
				setBackground(list.getSelectionBackground());
				setForeground(list.getSelectionForeground());
			}
			else {
				setBackground(list.getBackground());
				setForeground(list.getForeground());
			}
			setEnabled(list.isEnabled());
			setFont(list.getFont());
			return this;
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
				qqmain.this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			public void mousePressed(java.awt.event.MouseEvent e) {
				tmp = new Point(e.getX(), e.getY());

				isDragged = true;
				qqmain.this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		this.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
			public void mouseDragged(java.awt.event.MouseEvent e) {
				if (isDragged) {
					loc = new Point(qqmain.this.getLocation().x + e.getX() - tmp.x,
							qqmain.this.getLocation().y + e.getY() - tmp.y);
					qqmain.this.setLocation(loc);
				}
			}
		});
	}
	/***********/

}

package QQmain;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;


import javax.swing.text.Element;

import QQ数据库信息.Contants;
import QQ数据库信息.QQMSG;
import QQ数据库信息.QQuser;

public class QQchat extends JFrame{
	QQuser myq;
	QQuser hyq;
	JLabel xiao,close,bg,face,qname,mark,myqqx,hyqqx,biaoqing,dd,pane,A,jietu,cancel,send;
	JLabel chatad;
	JLabel sendfile;
	// 文本面板
	JTextPane t1, t2,ddtext;
	
	Icon bqs[]=new ImageIcon[96];
	QQbiaoqingpane a;
	QQzitipane b;
	Container con;
	//来个判断 要不要关了表情
	boolean s=false;
	public QQchat(QQuser myq,QQuser hyq){
		super();
		this.myq=myq;
		this.hyq=hyq;
		con=getContentPane();
		con.setLayout(null);
		con.setBackground(new Color(236,240,238));
		//窗口图标
		setIconImage(new ImageIcon(myq.getFace()).getImage()); 
		this.setUndecorated(true);//无边框
		//设置界面可以拖动的方法
		setDragable();

		xiao=new JLabel(new ImageIcon("img/xiao1.png"));
		xiao.setBounds(528, 0, 29, 28);
		con.add(xiao);
		xiao.setCursor(new Cursor(Cursor.HAND_CURSOR));//手型
		
		close=new JLabel(new ImageIcon("img/close1.png"));
		close.setBounds(558, 0, 29, 28);
		con.add(close);
		close.setCursor(new Cursor(Cursor.HAND_CURSOR));//手型
		
		face=new JLabel(new ImageIcon(hyq.getFace()));
		face.setBounds(0, 0, 60, 60);
		con.add(face);
		
		qname=new JLabel(hyq.getQqname());
		qname.setBounds(65, 3, 200, 38);
		qname.setFont(new Font("宋体",Font.PLAIN,20));
		con.add(qname);
		
		mark=new JLabel(hyq.getMark());
		mark.setBounds(65, 35, 200, 30);
		con.add(mark);
		
		t1=new JTextPane();
		t1.setBackground(new Color(236,240,238));
		JScrollPane pan1 = new JScrollPane(t1);
//		pan1.setOpaque(false);
//		pan1.getViewport().setOpaque(false);
		pan1.setBackground(new Color(0, 0, 0, 0));
		pan1.setBounds(0, 62, 445, 290);
		con.add(pan1);
//		t1.setEditable(false);
//		t1.setOpaque(false);
//		t1.setBackground(new Color(0, 0, 0, 0));
		pan1.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		//好友QQ秀
		String qqx1="img/qqxboy.jpg";
		if(hyq.getSex().equals("女")){
			qqx1="img/qqxgirl.jpg";;
		}
		hyqqx=new JLabel(new ImageIcon(qqx1));
		hyqqx.setBounds(445, 63, 140, 220);
		con.add(hyqqx);
		
		//QQ秀
		String qqx2="img/qqxboy.jpg";
		if(myq.getSex().equals("女")){
			qqx2="img/qqxgirl.jpg";;
		}
		myqqx=new JLabel(new ImageIcon(qqx2));
		myqqx.setBounds(445, 285, 140, 220);
		con.add(myqqx);
		//中间面板
		JPanel p1=new JPanel();
		p1.setLayout(new FlowLayout(FlowLayout.LEFT,10,1));
		p1.setBackground(new Color(233,243,243));
		//字体图片
		A=new JLabel(new ImageIcon("img/ziti.png"));
		p1.add(A);
		
		//表情
		biaoqing=new JLabel(new ImageIcon("img/biaoqing.png"));
		p1.add(biaoqing);
		
		//抖动
		dd=new JLabel(new ImageIcon("img/dd.png"));
		p1.add(dd);
		dd.setToolTipText("向好友发送窗口抖动");
		
		//截图
		jietu=new JLabel(new ImageIcon("img/截图图片.png"));
		p1.add(jietu);
		
		// 发送文件
		sendfile=new JLabel(new ImageIcon("img/wenjian.png"));
		sendfile.setToolTipText("向好友发送文件");
		p1.add(sendfile);
			
		p1.setBounds(0, 352, 445, 24);
		con.add(p1);
		
		//下面
		t2=new JTextPane();
		JScrollPane pan2 = new JScrollPane(t2);
		
//		pan2.setOpaque(false);
//		pan2.getViewport().setOpaque(false);
//		pan2.setBackground(new Color(0, 0, 0, 0));
		t2.setBackground(new Color(236,240,238));
		pan2.setBounds(0,376, 445, 104);
		con.add(pan2);
		t2.setOpaque(false);
		t2.setBackground(new Color(0, 0, 0, 0));
		pan2.setBorder(BorderFactory.createLineBorder(Color.WHITE, 0));
		
		//下面面板
		JPanel p3=new JPanel();
//		p3.setOpaque(false);
		p3.setLayout(new FlowLayout(FlowLayout.RIGHT,5,5));
//		p3.setBackground(new Color(0, 0, 0, 0));
		// 取消
		cancel = new JLabel(new ImageIcon("img/cancel.png"));
		p3.add(cancel);

		// 发送
		send = new JLabel(new ImageIcon("img/send.png"));
		p3.add(send);
		
		//监听
		sendfile.addMouseListener(new A());
		xiao.addMouseListener(new A());
		close.addMouseListener(new A());
		dd.addMouseListener(new A());
		cancel.addMouseListener(new A());
		send.addMouseListener(new A());
		biaoqing.addMouseListener(new A());
		jietu.addMouseListener(new A());
		A.addMouseListener(new A());

		p3.setBounds(0,480,445,30);
		con.add(p3);
		/* 背景图片 */
		ImageIcon images = new ImageIcon("img/bgimagetou.png");
		JLabel jl = new JLabel(images);// 图片标签
		jl.setBounds(0,0,588,510);
		con.add(jl);
		t2.addKeyListener(new C());
		setSize(588,510);//526
		setVisible(true);
		setLocationRelativeTo(null);
	}


	//窗口抖动方法
	public void shake(){
		Point p=QQchat.this.getLocationOnScreen();
		for(int i=0;i<20;i++){
			if(i%2==0){
				QQchat.this.setLocation(p.x-5,p.y-5);
			}else{
				QQchat.this.setLocation(p.x+5,p.y+5);
			}
			try {
				Thread.sleep(50);
			} catch (InterruptedException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
		}
	}
	class C implements KeyListener{

		@Override
		public void keyTyped(KeyEvent e) {
				if(e.getKeyCode() == e.VK_ENTER){
//					send.doclik();
				}
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO 自动生成的方法存根
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO 自动生成的方法存根
			
		}
		
		
	}
	//鼠标移动
	class A extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {
			//文件
			if(e.getSource()==sendfile){
				FileDialog fd=new FileDialog(QQchat.this,"选择文件",FileDialog.LOAD);//读取文件
				fd.show();
				String filepath=fd.getDirectory()+"\\"+fd.getFile();//文件路径
				//判断
				if(fd.getFile()!=null){
					File file=new File(filepath);
					byte b[]=new byte[(int)file.length()];//80k
					try {
						FileInputStream finput=new FileInputStream(file);
						//循环读取文件
						//while(finput.read(b)!=-1){
							
						//}
						if(file.length()>1024*64){//64k
							JOptionPane.showMessageDialog(null, "文件超大");
						//}
						}else{
							finput.read(b);
						}
						finput.close();
						
					} catch (Exception e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}
					//发送文件消息通知
					QQMSG msg=new QQMSG();
					msg.setCmd(Contants.CMD_SENDFILE);
					msg.setMyuser(myq);//我自己
					msg.setFruser(hyq);//所有人
					msg.setB(b);
					msg.setFilename(fd.getFile());
					new SendMsg().send(msg);

				}
			}
			
			if(e.getSource()==xiao){//最小化
				QQchat.this.setExtendedState(QQchat.this.ICONIFIED);//静态值
				
			}else if(e.getSource()==close){//关闭
			//	dispose();
				QQchat.this.setVisible(false);//隐藏
			}else if(e.getSource()==dd){
			//抖动
				shake();
				QQMSG msg=new QQMSG();
				ddtext=new JTextPane();
				ddtext.setText("  我给你发送了一个抖动");
				ddtext.setFont(new Font("微软雅黑",Font.BOLD,18));
				msg.cmd=Contants.CMD_SHKAE;
				msg.fruser=hyq;
				msg.myuser=myq;
				msg.doc=ddtext.getStyledDocument();
				new SendMsg().send(msg);
			}
			//表情
			if(e.getSource()==biaoqing){
				a=new QQbiaoqingpane(QQchat.this);//有必要
			}
			//字体
			if(e.getSource()==A){
				b=new QQzitipane(e.getXOnScreen()-25, e.getYOnScreen()-42,QQchat.this); 
				
			}
			//截图
			if(e.getSource()==jietu){
				QQjietu a=new QQjietu();
				a.doStart();
			}
			if(e.getSource()==cancel){
				QQchat.this.setVisible(false);//隐藏
				
			}else if(e.getSource()==send){
				//显示在自己的面板上
				appendView(myq.getQqname(), t2.getStyledDocument());
				
				//给好友框发送内容
				QQMSG msg=new QQMSG();
				msg.cmd=Contants.CMD_CHAT;//设置消息内容
				msg.doc=t2.getStyledDocument();
				msg.myuser=myq;
				msg.fruser=hyq;
				new SendMsg().send(msg);//发送消息
				//清空发送框
				t2.setText("");
				//焦点
				t2.requestFocus();
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
	
	// 把发送框的内容提交到接收框 (自己的昵称，发送框的内容)
	public void appendView(String name, StyledDocument xx) {
			try {
				//我应该为左边 第一句话
			//	int wo=3;
				// 获取接收框的文档（内容）
				StyledDocument vdoc = t1.getStyledDocument();// 获取接收框的内容

				// 格式化时间
				Date date = new Date();// 获取系统当前时间
				SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss"); // 设置显示时分秒的格式
				String time = sdf.format(date);// 获取时分秒
				// 创建一个属性集合
				SimpleAttributeSet as = new SimpleAttributeSet();
				// 显示谁说
				// vdoc.getLength()获取接收框中的原来内容的长度
				String s = name + "  " + time + "\n";
				// saveRecord(name,s);//保存聊天记录
				// 显示到接收框
				vdoc.insertString(vdoc.getLength(), s, as);
				int end = 0;
				// 处理显示的内容
				while (end < xx.getLength()) {
					// 获得一个元素
					Element e0 = xx.getCharacterElement(end);
					// 获取对应的风格，
					SimpleAttributeSet as1 = new SimpleAttributeSet();
					StyleConstants.setForeground(as1, StyleConstants
							.getForeground(e0.getAttributes()));
					StyleConstants.setFontSize(as1, StyleConstants.getFontSize(e0
							.getAttributes()));
					StyleConstants.setFontFamily(as1, StyleConstants
							.getFontFamily(e0.getAttributes()));
					// 获取该元素的内容
					s = e0.getDocument().getText(end, e0.getEndOffset() - end);
					// 将元素加到浏览窗中
					if ("icon".equals(e0.getName())) {
						vdoc.insertString(vdoc.getLength(), s, e0.getAttributes());
					} else {
						vdoc.insertString(vdoc.getLength(), s, as1);
						// saveRecord(name,s+"\n");//保存聊天记录
					}
					// getEndOffset（）函数就是获取当前元素的长度
					end = e0.getEndOffset();
				}
				// 输入一个换行————————————————————这是输出
				vdoc.insertString(vdoc.getLength(), "\n\n", as);
				// 设置显示视图加字符的位置到文档结尾，以便视图滚动
				t1.setCaretPosition(vdoc.getLength());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
				QQchat.this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			public void mousePressed(java.awt.event.MouseEvent e) {
				tmp = new Point(e.getX(), e.getY());

				isDragged = true;
				QQchat.this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		this.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
			public void mouseDragged(java.awt.event.MouseEvent e) {
				if (isDragged) {
					loc = new Point(QQchat.this.getLocation().x + e.getX() - tmp.x,
							QQchat.this.getLocation().y + e.getY() - tmp.y);
					QQchat.this.setLocation(loc);
				}
			}
		});
	}
	/***********/
}

package QQLGO;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Point;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import QQmain.qqmain;
import QQ数据库信息.QQgame;
import QQ数据库信息.QQuser;
import QQcloudlet.QQweiyun;
import 接口.QQuserInterface;
import 方法实现接口.QQuserimp;
//进度条源代码在  23 11 光盘上
public class QQloginin extends JFrame{
	QQuserInterface qserive=new QQuserimp();
	JLabel xiao,close,bg,xia;
	JLabel face;//头像
	QQuser qq;//传入用户信息
	QQgame qqgame;//游戏信息
	private static final long serialVersionUID = 1L;
	public QQloginin(QQuser qq,QQgame qqgame) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException{
		super("");
		this.qq=qq;
		this.qqgame=qqgame;
		//设置组件样式
		UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		Container con=getContentPane();
		// 窗口图片
		setIconImage(new ImageIcon("img/tubiao.jpg").getImage());
		this.setUndecorated(true);//无边框
		//设置界面可以拖动的方法
		setDragable();

		xiao=new JLabel();
		xiao.setBounds(370,0,29,28);
		con.add(xiao);
		xiao.setCursor(new Cursor(Cursor.HAND_CURSOR));//手型
		
		close=new JLabel();
		close.setBounds(400,0,29,28);
		con.add(close);
		close.setCursor(new Cursor(Cursor.HAND_CURSOR));//手型
		
		xia=new JLabel();
		xia.setBounds(340,0,29,28);
		con.add(xia);
		close.setCursor(new Cursor(Cursor.HAND_CURSOR));//手型
	
		
		face=new JLabel(new ImageIcon(qq.getFace()));
		face.setBounds(180, 190, 60, 60);
		con.add(face);
		
		JProgressBar progressBar = new JProgressBar();// 创建进度条对象
		progressBar.setStringPainted(true);// 设置显示提示信息
		progressBar.setIndeterminate(true);// 设置采用不确定进度条
		progressBar.setString("登录中...");// 设置提示信息
		GridBagConstraints gridBagConstraints_1 = new GridBagConstraints();
		gridBagConstraints_1.insets = new Insets(5, 0, 0, 0);
		gridBagConstraints_1.gridy = 1;
		gridBagConstraints_1.gridx = 0;
		progressBar.setBounds(160,265,100,25);
		
		final JButton button = new JButton();
		final GridBagConstraints gridBagConstraints_2 = new GridBagConstraints();
		gridBagConstraints_2.insets = new Insets(5, 0, 0, 0);
		gridBagConstraints_2.gridy = 2;
		gridBagConstraints_2.gridx = 1;
		new Progress(progressBar, button).start();// 利用线程模拟一个在线升级任务
		con.add(progressBar);
		
		
		//监听
		xiao.addMouseListener(new A());
		close.addMouseListener(new A());
		xia.addMouseListener(new A());
		/* 背景图片 */
		ImageIcon images = new ImageIcon("img/bg3111.png");
		JLabel jl = new JLabel(images);// 图片标签
		con.add(jl);
		bg=new JLabel();
		setSize(430,310);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	class Progress extends Thread {// 利用线程模拟一个在线升级任务
		private final int[] progressValue = { 6, 18, 27, 39, 51, 66, 81,
				100 };// 模拟任务完成百分比
		private JProgressBar progressBar;// 进度条对象
		private JButton button;// 完成按钮对象
		
		public Progress(JProgressBar progressBar, JButton button) {
			this.progressBar = progressBar;
			this.button = button;
		}
		
		public void run() {
			// 通过循环更新任务完成百分比
			for (int i = 0; i <progressValue.length; i++) {
				try {
					Thread.sleep(200);// 令线程休眠1秒
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				progressBar.setValue(progressValue[i]);// 设置任务完成百分比
			}
			progressBar.setIndeterminate(false);// 设置采用确定进度条
			progressBar.setString("登录成功！");// 设置提示信息
			//	z这里进度条结束
			
			QQloginin.this.dispose();//关闭登入
			new qqmain(qq,qqgame);//用户信息
			}			
	}
	class A extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {
			if(e.getSource()==xiao){//最小化
				QQloginin.this.setExtendedState(QQloginin.this.ICONIFIED);//静态值
				
			}else if(e.getSource()==close){//关闭
				System.exit(0);
				
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
				xiao.setIcon(new ImageIcon(""));//空为原来的图片
				
			}
			
			if(e.getSource()==close){
				close.setIcon(new ImageIcon(""));
				
			}
			if(e.getSource()==xia){
				xia.setIcon(new ImageIcon(""));
				
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
				QQloginin.this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			public void mousePressed(java.awt.event.MouseEvent e) {
				tmp = new Point(e.getX(), e.getY());

				isDragged = true;
				QQloginin.this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		this.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
			public void mouseDragged(java.awt.event.MouseEvent e) {
				if (isDragged) {
					loc = new Point(QQloginin.this.getLocation().x + e.getX() - tmp.x,
							QQloginin.this.getLocation().y + e.getY() - tmp.y);
					QQloginin.this.setLocation(loc);
				}
			}
		});
	}
	/***********/

	//public static void main(String[] args) {
	//	new QQloginin(qq);
//	}
}

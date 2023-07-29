package QQmain;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.sun.awt.AWTUtilities;

import QQ数据库信息.QQuser;


public class TipUi extends JFrame{
	
	public TipUi(QQuser self) {
		
		//去掉窗口标题栏
		setUndecorated(true);
		setSize(257, 100);
		//获取屏幕的宽度
		int width=getToolkit().getScreenSize().width;
//		获取屏幕的高度
		int height=getToolkit().getScreenSize().height-30;
		width = width-this.getWidth();
		Container c = getContentPane();
		
		//头像
		JLabel face=new JLabel(new ImageIcon(self.getFace()));
		c.add(face);
		face.setBounds(2, 20, 60, 60);
		
		JLabel text=new JLabel("您的好友("+self.getQqname()+")上线了!");
		c.add(text);
		text.setBounds(80, 40, 160, 20);
		text.setFont(new Font("微软雅黑",Font.PLAIN,12));
		
		//背景图片
		JLabel bgimg=new JLabel(new ImageIcon("img/notic.png"));
		c.add(bgimg);
		
		this.addMouseListener(new MyMouseListener());
		setVisible(true);
		setAlwaysOnTop(true);//窗口显示在最前面
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		try{
			
			
			//(窗口出现的代码)改变窗口坐标
			for(int i=1;i<=75;i++){
				setLocation(width, height-(int)(i*1.5));
				Thread.sleep(10);
			}
			//(窗口消失的方法)设置窗口的透明度
			for(int i=100;i>=1;i--){
				//设置透明度，1~0之间，0就是透明了，看不到窗口
				AWTUtilities.setWindowOpacity(this, 0.01f*i);
				Thread.sleep(20);
			}
			//关闭窗口
			dispose();
		}catch(Exception e){
			
		}
	}
	
	//窗口监听
	class MyMouseListener extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			//关闭窗口
			dispose();
		}
	}
//	
//	public static void main(String[] args) {
//		QQuser quser=new QQuser();
//		quser.setQqnum("1232435");
//		quser.setQqname("小三");
//		quser.setFace("imgs/0.png");
//		new TipUi(quser);
//	}
}

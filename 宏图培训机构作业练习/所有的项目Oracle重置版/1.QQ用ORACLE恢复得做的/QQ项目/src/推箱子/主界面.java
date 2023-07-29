package 推箱子;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import QQ数据库信息.QQgame;
import 接口.QQuserInterface;
import 方法实现接口.QQuserimp;
import QQLGO.QQfind;
import QQVIP.QQvipmain;
import Game2.*;
public class 主界面 extends JFrame {
	int hua=1;
	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9;
	JComboBox cmmusic;
	String musicfile[]={"flourish.mid","guang.mid","popo.mid","eyes on me.mid","qin.mid"};//音乐文件
	String st[]={"默认","灌篮高手","泡泡堂","eyes on me","琴箫合奏"};//为下拉框添加内容
	JPanel dong;
	Sound sound;//声音
	Container con;
	JLabel close;
	QQgame qqgame;
	中心面板 zhong;//调用中心面板
	QQuserInterface qserive=new QQuserimp();
	public 主界面(QQgame qqusergame){
		super("推箱子2015");
		//qqusergame里只有
		this.qqgame=qqusergame;
		zhong=new 中心面板(qqgame);
		//窗口图片
		setIconImage(new ImageIcon("img1/9.GIF").getImage());
		
		//音乐文件
		sound=new Sound();
		sound.mystop();//关闭音乐
		
		con=getContentPane();
		setLayout(new BorderLayout());
		
		dong=new JPanel();
		dong.setLayout(null);
		zhong.setLayout(null);
		dong.setPreferredSize(new Dimension(100,600));//自定义偏好大小
		zhong.setPreferredSize(new Dimension(600,600));
		
		//这里不应该直接是LEVEL:1 应该设置数据库的关卡 拼接字符串 一开始的关卡，不涉及接下来过关选关的表现关卡
		//应该以中心面板中的level为主，会随着改变而改变，而这里的qqgame.get方法 是最一开始传过来的值，并不能随之改变
//		String levelstr = "LEVEL:"+qqgame.getTxzgk();//txgk默认为1 应该不用再修改添加判断了吧
//		System.out.println("主界面"+zhong.level);
		zhong.l1 = new JLabel("LEVEL:"+zhong.level);
		dong.add(zhong.l1);
		zhong.l1.setBounds(0,20,100,30);
		
		Font f=new Font("宋体",Font.PLAIN,24);
		zhong.l1.setFont(f);
		zhong.l1.setForeground(Color.red);
		
		b1=new JButton("重来");
		dong.add(b1);
		b1.setBounds(10,70,80,20);
		
		b2=new JButton("悔一步");
		dong.add(b2);
		b2.setBounds(10,120,80,20);
		
		b3=new JButton("第一关");
		dong.add(b3);
		b3.setBounds(10,170,80,20);
		
		b4=new JButton("上一关");
		dong.add(b4);
		b4.setBounds(10,220,80,20);
		
		b5=new JButton("下一关");
		dong.add(b5);
		b5.setBounds(10,270,80,20);
		
		b6=new JButton("最终关");
		dong.add(b6);
		b6.setBounds(10,320,80,20);
		
		b7=new JButton("选关");
		dong.add(b7);
		b7.setBounds(10,370,80,20);
		
		b8=new JButton("帮助");
		dong.add(b8);
		b8.setBounds(10,420,80,20);
		
		b9=new JButton("音乐开");
		dong.add(b9);
		b9.setBounds(10,470,80,20);
		b9.setActionCommand("music开关");//设置提交内容 要不然用不了
		
		cmmusic=new JComboBox(st);
		cmmusic.setBounds(10,520,80,20);
		dong.add(cmmusic);
		
		ImageIcon z=new ImageIcon("img1/aaaa1.jpg");
		JLabel jl=new JLabel(z);
		jl.setBounds(0,0,100,600);//添加背景图片
		dong.add(jl);
		
		ImageIcon x=new ImageIcon("img1/aaaa.jpg");
		JLabel j2=new JLabel(x);
		j2.setBounds(0,0,600,600);//添加背景图片
		zhong.add(j2);
		
		close=new JLabel();
		close.setBounds(670,0,30,30);
		con.add(close);
		
		//授权
		close.addMouseListener(new B());
		b1.addActionListener(new A());
		b2.addActionListener(new A());
		b3.addActionListener(new A());
		b4.addActionListener(new A());
		b5.addActionListener(new A());
		b6.addActionListener(new A());
		b7.addActionListener(new A());
		b8.addActionListener(new A());
		b9.addActionListener(new A());
		cmmusic.addItemListener(new E());//在当前类实现
		con.add(dong,BorderLayout.EAST);
		con.add(zhong,BorderLayout.CENTER);
		addWindowListener(new C());
		pack();
		//setSize(700,600);
		setVisible(true);
		setLocationRelativeTo(null);
	}
	public static void main(String dsf[]){
		//new 主界面();
		
	}
	class C extends WindowAdapter{
		public void windowClosing(WindowEvent e) {
			// TODO 自动生成的方法存根
			//保存关卡数
			qserive.savetxzgk(qqgame.getQqnum(),zhong.level);
			dispose();
		}
	}
	class B extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getSource()==close){
				
				dispose();
			}
		}
		
	}
	class A implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO 自动生成的方法存根
			if(e.getActionCommand().equals("重来")){
				int level=zhong.level;//获取当前关卡接收
				zhong.setlevel(level);//传值
				zhong.requestFocus();
			}else if(e.getActionCommand().equals("悔一步")){
				zhong.huiyibu();
				zhong.requestFocus();
			}else if(e.getActionCommand().equals("第一关")){
				zhong.setlevel(1);
				zhong.l1.setText("LEVEL:1");
				zhong.requestFocus();
			}else if(e.getActionCommand().equals("上一关")){
				int level=zhong.level;//获取当前关卡接收
				if(level<=1){
					JOptionPane.showMessageDialog(null, "没有关卡可以往前了！");
					
				}else{
					zhong.setlevel(level-1);
					zhong.l1.setText("LEVEL:"+(level-1));
				}
				zhong.requestFocus();
			}else if(e.getActionCommand().equals("下一关")){
				int level=zhong.level;//获取当前关卡接收
				//会员检测
				boolean shi=qserive.chekhui(qqgame.getQqnum());
				if(shi){
					if(level>=11){
						JOptionPane.showMessageDialog(null, "没有关卡可以往后了！");
					
					}else{
						zhong.setlevel(level+1);
						zhong.l1.setText("LEVEL:"+(level+1));
					}
				}else{
					JOptionPane.showMessageDialog(null, "对不起，你不是会员");
					//new 
					return;
				}
				zhong.requestFocus();
			}else if(e.getActionCommand().equals("最终关")){
				//会员检测
				boolean shi=qserive.chekhui(qqgame.getQqnum());
				if(shi){
					zhong.setlevel(11);
					zhong.l1.setText("LEVEL:11");
				}else{
					JOptionPane.showMessageDialog(null,"对不起！你不是会员");
					return;
				}
				zhong.requestFocus();
			}else if(e.getActionCommand().equals("选关")){
				//会员检测
				boolean shi=qserive.chekhui(qqgame.getQqnum());
				if(shi){
					int level=zhong.level;//获取当前关卡接收
					String str=JOptionPane.showInputDialog(null, "请输入1-11的关卡");
					try{
						level=Integer.parseInt(str);
					}catch(NumberFormatException e1){
						//e.printStackTrace();//打印错误信息
						JOptionPane.showMessageDialog(null, "你输入的关卡无效！");//针对字符
						return;
					}
					if(level>=1&&level<=12){
						zhong.setlevel(level);
						zhong.l1.setText("LEVEL:"+(level));
						if(level==12){
							dispose();//关闭当前
							new 主界面2();
						}
					}else{
						JOptionPane.showMessageDialog(null, "请输入1-12的关卡数");//针对数字
					}
					
				}else{
					JOptionPane.showMessageDialog(null, "对不起！你不是会员");
					new QQvipmain();
				}
				zhong.requestFocus();
			}else if(e.getActionCommand().equals("帮助")){
				new Help();
			}else if(e.getActionCommand().equals("music开关")){//提交内容。。。。。
				String title=b9.getText();
				if(title.equals("音乐关")){
					sound.mystop();//关闭音乐
					b9.setText("音乐开");
				}else{
					sound.loadSound();//关闭音乐
					b9.setText("音乐关");
					
				}
				zhong.requestFocus();
			}
			
		}
		
	}
	class E implements ItemListener {
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO 自动生成的方法存根
		int index=cmmusic.getSelectedIndex();//获取索引 0,1,2,3
		sound.setmusic(musicfile[index]);//与索引对应文件0,1,2,3
		if(sound.isplay()){//声音是否在放，在放为false，不再放为true 对很难搞的逻辑
			sound.mystop();//判断是否再放 在放就关掉 
		}else{
			sound.loadSound();//首先播放索引0 默认的 
			zhong.requestFocus();
		}
	}
	}
}
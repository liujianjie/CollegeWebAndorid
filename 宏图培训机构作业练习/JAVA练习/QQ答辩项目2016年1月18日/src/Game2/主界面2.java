package Game2;

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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class 主界面2 extends JFrame {
	int hua=1;
	JLabel close;
	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9;
	JComboBox cmmusic;
	String musicfile[]={"flourish.mid","guang.mid","popo.mid","eyes on me.mid","qin.mid"};//音乐文件
	String st[]={"默认","灌篮高手","泡泡堂","eyes on me","琴箫合奏"};//为下拉框添加内容
	JPanel dong;
	中心面板 zhong=new 中心面板();//调用中心面板
	Sound sound;//声音
	Container con;
	 
	public 主界面2(){
		super("推箱子2015");
		//窗口图片
		setIconImage(new ImageIcon("img1/9.GIF").getImage());
		
		//音乐文件
		//sound=new Sound();
		
		con=getContentPane();
		setLayout(new BorderLayout());
		
		dong=new JPanel();
		dong.setLayout(null);
		zhong.setLayout(null);
		dong.setPreferredSize(new Dimension(100,600));//自定义偏好大小
		zhong.setPreferredSize(new Dimension(600,600));
		close=new JLabel();
		close.setBounds(670,0,30,30);
		con.add(close);
		
		zhong.l1=new JLabel("LEVEL:1");
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
		
		b9=new JButton("音乐关");
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
		
		//授权
		b1.addActionListener(new A());
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
		pack();
		//setSize(700,600);
		setVisible(true);
		setLocationRelativeTo(null);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	class B extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getSource()==close){
				
				dispose();
			}
		}
		
	}
	public static void main(String dsf[]){
		new 主界面2();
		
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
				if(level>=12){
					JOptionPane.showMessageDialog(null, "没有关卡可以往后了！");
					
				}else{
					zhong.setlevel(level+1);
					zhong.l1.setText("LEVEL:"+(level+1));
				}
				zhong.requestFocus();
			}else if(e.getActionCommand().equals("最终关")){
				zhong.setlevel(12);
				zhong.l1.setText("LEVEL:12");
				zhong.requestFocus();
			}else if(e.getActionCommand().equals("选关")){
				int level=zhong.level;//获取当前关卡接收
				String str=JOptionPane.showInputDialog(null, "请输入1-12的关卡");
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
				}else{
					JOptionPane.showMessageDialog(null, "请输入1-12的关卡数");//针对数字
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
		if(sound.isplay()){
			sound.mystop();//判断是否再放 在放就关掉
		}
		sound.loadSound();//首先播放索引0 默认的
		zhong.requestFocus();
	}
	}
}
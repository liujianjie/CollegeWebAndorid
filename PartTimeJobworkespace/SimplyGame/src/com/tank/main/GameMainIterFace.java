package com.tank.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameMainIterFace extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton b1,b2,b3;
	private JPanel east;
	GameMainPanel panel=new GameMainPanel(this);//调用中心面板
	GameOverPanel gov = new GameOverPanel();
	private Container con;
	private JLabel close;
	
	public static int GAME_WIDTH = 1000;
	public static int GAME_HEIGHT = 700;
	
	public GameMainIterFace(){
		super("SimplyTankGame");
		//窗口图片
		setIconImage(new ImageIcon("img/white.gif").getImage());
		
		this.setUndecorated(true);//无边框
		setDragable();
		
		con=getContentPane();
		setLayout(new BorderLayout());
		
		east = new JPanel();
		east.setLayout(null);
		panel.setLayout(null);
		
		east.setPreferredSize(new Dimension(100,700));//自定义偏好大小
		panel.setPreferredSize(new Dimension(600,700));
		gov.setPreferredSize(new Dimension(600,700));
		
//		gov.jl = new JLabel("GAME OVER!YOU GET POINTS:");
//		gov.jl.setBounds(0,70,100,30);
//		Font f2 = new Font("宋体",Font.PLAIN,54);
//		gov.jl.setFont(f2);
//		gov.jl.setForeground(Color.red);
//		gov.add(jl);
		
		panel.JPoint=new JLabel("POINT:0");
		east.add(panel.JPoint);
		panel.JPoint.setBounds(0,20,100,30);
		Font f=new Font("宋体",Font.PLAIN,18);
		panel.JPoint.setFont(f);
		panel.JPoint.setForeground(Color.red);
		
		b1=new JButton("START");
		east.add(b1);
		b1.setBounds(10,70,80,20);
		
		b2=new JButton("EXIT");
		east.add(b2);
		b2.setBounds(10,120,80,20);
		
		b3=new JButton("RESET");
		east.add(b3);
		b3.setBounds(10,170,80,20);
		
		
		close=new JLabel();
		close.setBounds(670,0,30,30);
		con.add(close);
		//授权
		close.addMouseListener(new B());
		b1.addActionListener(new A());
		b2.addActionListener(new A());
		b3.addActionListener(new A());
		con.add(east,BorderLayout.EAST);
		con.add(gov,BorderLayout.CENTER);
		con.add(panel,BorderLayout.CENTER);
		con.addKeyListener(new KeyEvents());
//		pack();
		setSize(1000,700);
		setVisible(true);
		setLocationRelativeTo(null);
	}
	public void setGameOver(int point){
//		con.remove(panel);
		gov.setGameOVerString(point);
		con.add(gov,BorderLayout.CENTER);
	}
	public void removeGameOver(){
		con.remove(gov);
	}
	public void setGamePanel(){
//		con.remove(comp);(panel,BorderLayout.CENTER);
	}
	public static void main(String dsf[]){
		new GameMainIterFace();
		
	}
	class B extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getSource()==close){
				dispose();
			}
		}
		
	}
	class KeyEvents extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
			//相当于按任意键开始
			if(e.getKeyCode() == 27){
				System.exit(0);
			}
		}
	}
	class A implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO 自动生成的方法存根
			if(e.getActionCommand().equals("RESET")){
				panel.setPoint(0);//传值
				panel.reset();
				panel.requestFocus();
			}else if(e.getActionCommand().equals("START")){
				panel.gamestart();
				panel.requestFocus();
			}else if(e.getActionCommand().equals("EXIT")){
				System.exit(0);
			}
		}
		
	}
	
	Point loc = null;
	Point tmp = null;
	boolean isDragged = false;
	private void setDragable() {
		this.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseReleased(java.awt.event.MouseEvent e) {
				isDragged = false;
				GameMainIterFace.this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			public void mousePressed(java.awt.event.MouseEvent e) {
				tmp = new Point(e.getX(), e.getY());

				isDragged = true;
				GameMainIterFace.this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		this.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
			public void mouseDragged(java.awt.event.MouseEvent e) {
				if (isDragged) {
					loc = new Point(GameMainIterFace.this.getLocation().x + e.getX() - tmp.x,
							GameMainIterFace.this.getLocation().y + e.getY() - tmp.y);
					GameMainIterFace.this.setLocation(loc);
				}
			}
		});
	}
}

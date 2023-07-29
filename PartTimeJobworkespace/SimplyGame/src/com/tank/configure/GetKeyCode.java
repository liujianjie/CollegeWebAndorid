package com.tank.configure;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

/**
 * Author:
 * DataTime:
 * Effect:测试键值
 * */
//上38 下40 左37 右39
//w87 s83 a65 d68
public class GetKeyCode  extends JFrame implements KeyListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public GetKeyCode(){
		addKeyListener(this);
		setSize(400,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);//可见
		setLocationRelativeTo(null);//出现在中心位置
	}
	public static void main(String dsf[]){
		new GetKeyCode();
		//授权
	}
	
	public void keyPressed(KeyEvent e) {
		  e.getKeyCode();
		  System.out.println(e.getKeyCode());
	  }


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO 自动生成的方法存根
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO 自动生成的方法存根
		
	}
}

package com.tank.configure;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

/**
 * Author:
 * DataTime:
 * Effect:���Լ�ֵ
 * */
//��38 ��40 ��37 ��39
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
		setVisible(true);//�ɼ�
		setLocationRelativeTo(null);//����������λ��
	}
	public static void main(String dsf[]){
		new GetKeyCode();
		//��Ȩ
	}
	
	public void keyPressed(KeyEvent e) {
		  e.getKeyCode();
		  System.out.println(e.getKeyCode());
	  }


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO �Զ����ɵķ������
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO �Զ����ɵķ������
		
	}
}

package com.snake.interfaces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.snake.config.GsnInterfaceParam;
import com.snake.mgame.GsnMainGameJPanel;
import com.snake.mgame.GsnMainGameScoreJPanel;

// ������Ϸ���
public class GsnCenterInterface extends JPanel{
	// ������Ϸ���
	public GsnMainGameJPanel gsnmaingameJPanel;
	// ����ͳ�����
	public GsnMainGameScoreJPanel gsnmaingamescroeJpanel;
	public GsnCenterInterface(){
		setLayout(null);
		
		gsnmaingameJPanel = new GsnMainGameJPanel();
		gsnmaingameJPanel.setBounds(20, 50, gsnmaingameJPanel.getWidth(), gsnmaingameJPanel.getHeight());
		
		gsnmaingamescroeJpanel = new GsnMainGameScoreJPanel();
		gsnmaingamescroeJpanel.setBounds(20, 10, gsnmaingamescroeJpanel.getWidth(), gsnmaingamescroeJpanel.getHeight());
		
		add(gsnmaingameJPanel);
		add(gsnmaingamescroeJpanel);
		this.setBackground(Color.CYAN);
		this.setSize(new Dimension(GsnInterfaceParam.INTERFACEWIDTH, GsnInterfaceParam.INTERFACEHEIGHT));// 640 * 480 �̶���С
	}
	// ���ô�С
	public void setnewSize(int width, int height){
		this.setSize(new Dimension(width, height));
		this.repaint();
	}
}

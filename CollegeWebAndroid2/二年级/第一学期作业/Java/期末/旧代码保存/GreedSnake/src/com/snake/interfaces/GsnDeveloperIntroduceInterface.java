package com.snake.interfaces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.snake.config.GsnInterfaceParam;



// 开发者介绍
public class GsnDeveloperIntroduceInterface extends JPanel{
	
	JPanel centerpanel;
	
	JPanel labeljp[];
	
	JLabel infoLabel1[],infoLabel2[],infoLabel3[],infoLabel4[];
	
	Font f;
	public GsnDeveloperIntroduceInterface(){
		setLayout(null);
		
		centerpanel = new JPanel();
		centerpanel.setOpaque(false);
		centerpanel.setLayout(new GridLayout(4, 1));
		initfont();
		giveSpace();
		addCom();
		
		centerpanel.setBounds((GsnInterfaceParam.INTERFACEWIDTH - 350) / 2, (GsnInterfaceParam.INTERFACEHEIGHT - 350) / 2, 350, 350);
		add(centerpanel);
		this.setBackground(Color.orange);
		this.setSize(new Dimension(GsnInterfaceParam.INTERFACEWIDTH, GsnInterfaceParam.INTERFACEHEIGHT));// 640 * 480 固定大小
		
		// 监听事件
		this.addKeyListener(new GsnDeveloperKeyLis());
	}
	public void initfont(){
		f = new Font("楷体", 1, 22);
	}
	public void giveSpace(){
		labeljp = new JPanel[4];
		for(int i = 0; i < labeljp.length; i++){
			labeljp[i] = new JPanel();
			labeljp[i].setOpaque(false);
			centerpanel.add(labeljp[i]);
		}
		
		infoLabel1 = new JLabel[2];
		infoLabel2 = new JLabel[2];
		infoLabel3 = new JLabel[2];
		infoLabel4 = new JLabel[2];
		for(int i = 0; i < infoLabel1.length; i++){
			infoLabel1[i] = new JLabel();
			infoLabel1[i].setFont(f);
		}
		for(int i = 0; i < infoLabel2.length; i++){
			infoLabel2[i] = new JLabel();
			infoLabel2[i].setFont(f);
		}
		for(int i = 0; i < infoLabel3.length; i++){
			infoLabel3[i] = new JLabel();
			infoLabel3[i].setFont(f);
		}
		for(int i = 0; i < infoLabel4.length; i++){
			infoLabel4[i] = new JLabel();
			infoLabel4[i].setFont(f);
		}
		
		infoLabel1[0].setText("游戏名称：");
		infoLabel1[1].setText("贪吃蛇");
		
		infoLabel2[0].setText("完成时间：");
		infoLabel2[1].setText("2019年12月17日");
		
		infoLabel3[0].setText("作者名称：");
		infoLabel3[1].setText("LIUJIANJIE");
		
		infoLabel4[0].setText("联系方式：");
		infoLabel4[1].setText("1219277604");
	}
	public void addCom(){
		labeljp[0].add(infoLabel1[0]);
		labeljp[0].add(infoLabel1[1]);
		
		labeljp[1].add(infoLabel2[0]);
		labeljp[1].add(infoLabel2[1]);
		
		labeljp[2].add(infoLabel3[0]);
		labeljp[2].add(infoLabel3[1]);
		
		labeljp[3].add(infoLabel4[0]);
		labeljp[3].add(infoLabel4[1]);
		
	}
	// 键盘监听 
	class GsnDeveloperKeyLis extends KeyAdapter{
		@Override
		public void keyReleased(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_1){
				System.out.println("GsnDeveloperKeyLis按下1键");
			}else if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
				GsnBottomLayerInterface.backLastJPanel();
				System.out.println("GsnLevelKeyLis按下VK_ESCAPE键");
			}
		}
	}
}
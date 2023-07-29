package com.snake.mgame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.snake.config.GsnInterfaceParam;
import com.snake.mgameconfig.GsnMainGameConstants;

public class GsnMainGameScoreJPanel extends JPanel{
	JPanel lizijp[];
	JLabel lizisan[][];
	boolean isliziStart[];
	// 先简单的：
	JLabel leveljl,playertag1,playertag2;
	JLabel liziscore[];
	Font levelfont;// 等级字体
	Font scorefont;// 成绩字体
	
	JPanel allcomjp;
	public GsnMainGameScoreJPanel(){
		setLayout(null);
		initFont();
		givespace();
		initComp();
		setComBouns();
		addComp();
		this.setBackground(Color.YELLOW);
		this.setSize(new Dimension(GsnInterfaceParam.GAMESCOREWIDTH,GsnInterfaceParam.GAMESCOREHEIGHT));
	}
	public void givespace(){
		
		lizijp = new JPanel[4];
		isliziStart = new boolean[4];
		liziscore = new JLabel[4];
		
		lizisan = new JLabel[4][0];
		
		for(int i = 0; i < lizijp.length; i++){
			lizijp[i] = new JPanel();
			lizijp[i].setLayout(null);
			lizijp[i].setBackground(Color.YELLOW);
		}
		for(int i = 0; i < liziscore.length; i++){
			liziscore[i] = new JLabel("0");
			liziscore[i].setFont(scorefont);
		}
		changescore = new int[4];
	}
	//初始化字体
	public void initFont(){
		levelfont = new Font("楷体", 0, 18);
		scorefont = new Font("楷体", 0, 18);
	}
	// 初始化控件
	public void initComp(){
		allcomjp = new JPanel();
		allcomjp.setLayout(null);
		allcomjp.setBackground(Color.YELLOW);
		
		leveljl = new JLabel("LEVEL:"+GsnMainGameConstants.currLevel);//添加等级
		playertag1 = new JLabel("PLAYER1:");
		playertag2 = new JLabel("PLAYER2:");
		
		leveljl.setFont(levelfont);
		playertag1.setFont(scorefont);
		playertag2.setFont(scorefont);
	}
	// 添加控件
	public void addComp(){
		this.add(leveljl);
		allcomjp.add(playertag1);
		
		lizijp[0].add(liziscore[0]);
		allcomjp.add(lizijp[0]);
		
		allcomjp.add(playertag2);

		lizijp[1].add(liziscore[1]);
		allcomjp.add(lizijp[1]);
		
		this.add(allcomjp);
	}
	// 设置位置
	public void setComBouns(){
		allcomjp.setBounds(5, 5, GsnInterfaceParam.GAMESCOREWIDTH, GsnInterfaceParam.GAMESCOREHEIGHT - 10);
		
//		// 设置
		leveljl.setBounds(10, 5, 70, GsnInterfaceParam.GAMESCOREHEIGHT - 10);
		
		playertag1.setBounds(90, 0, 80, GsnInterfaceParam.GAMESCOREHEIGHT - 10);
		lizijp[0].setBounds(170, 0, 40, GsnInterfaceParam.GAMESCOREHEIGHT - 10);
		liziscore[0].setBounds(0, 0, 40, GsnInterfaceParam.GAMESCOREHEIGHT - 10);
		
		playertag2.setBounds(210, 0, 80, GsnInterfaceParam.GAMESCOREHEIGHT - 10);
		lizijp[1].setBounds(290, 0, 40, GsnInterfaceParam.GAMESCOREHEIGHT - 10);
		liziscore[1].setBounds(0, 0, 40, GsnInterfaceParam.GAMESCOREHEIGHT - 10);
	}
	// 改变等级
	public void changeLevel(){
		leveljl.setText("LEVEL:"+GsnMainGameConstants.currLevel);
	}
	
	int changescore[];
	// 改变分数
	public void changeScore(int player,int score, int tag){
		player = player - 1;// 因为。。。
		changescore[player] = score;
		
		if(score == 0 || tag == 0){
			liziscore[player].setText(score+"");// 直接设置分数，并且如果是减分也是
		}else{
			// 开始
			liziscore[player].setText("");// 先设空
				if(!isliziStart[player]){
					generateJlabel(player);
				}
		}
	}
	int palen[] = new int[4];
	public void generateJlabel(int player){
		runmove[player] = true;
		// 再开始不要进
		isliziStart[player] = true;
		// 生成点
		palen[player] = ran.nextInt(10) + 20;// 20 - 30
		
		lizisan[player] = new JLabel[palen[player]];
		Font f = new Font("楷体", 0, 5);
		for(int i = 0; i < palen[player]; i++){
			lizisan[player][i] = new JLabel(".",JLabel.CENTER);
			// 为面板的中心
			lizisan[player][i].setBounds((liziscore[player].getWidth()) / 2 - 8, (liziscore[player].getHeight()) / 2, 3, 3);
			// 设置颜色
			lizisan[player][i].setFont(f);
			lizisan[player][i].setForeground(Color.BLACK);
			lizijp[player].add(lizisan[player][i]);
		}
		lizijp[player].updateUI();
		for(int i = 0; i < palen[player]; i++){
			MyThread my = new MyThread(i,player);
			my.start();
		}
	}
	int count[] = new int[4];
	Random ran = new Random();
	// 粒子线程
	boolean runmove[] = new boolean[4];
	class MyThread extends Thread{
		int lbid;
		int player;
		public MyThread(int id, int player){
			lbid = id;
			this.player = player;
		}
		boolean isout = false;
		@Override
		public void run() {
			// 1.生成 xy
			int x = Math.random() > 0.5 ? ran.nextInt(5) * 1 : ran.nextInt(5) * (-1);
			int y = Math.random() > 0.5 ? ran.nextInt(5) * 1 : ran.nextInt(5) * (-1);
			int speed = ran.nextInt(30) + 20;// 速度 20 - 50；
			while(runmove[player]){
				// 待在原地的 就是 x y是0 的
				if(x == 0 && y == 0){
					lizijp[player].remove(lizisan[player][lbid]);
					break;
				}
				int yx = (int) (lizisan[player][lbid].getX() + x);
				int yy =(int) (lizisan[player][lbid].getY() + y);
				// 给予一直移动 根据方向 
				lizisan[player][lbid].setBounds(yx, yy, 3, 3);
				try {
					Thread.sleep(speed);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				lizijp[player].updateUI();
				// 有的没有完全退出
				if(yx > liziscore[player].getWidth() - 8 || yy > liziscore[player].getHeight()
						|| yx < 0 || yy < 0){
					lizijp[player].remove(lizisan[player][lbid]);
					break;
				}
			}
			lizijp[player].updateUI();
			count[player]++;// 出来了就+1
			if(count[player] >= palen[player] - 5){// 全部粒子出来，或者 出来很多，只剩一两个没出来，就设置分数
				count[player] = 0;
				// 全部去除
				lizijp[player].removeAll();
				// 再添加回分数
				lizijp[player].add(liziscore[player]);
				// 设置分数
				liziscore[player].setText(changescore[player]+"");
				lizijp[player].updateUI();
				isliziStart[player] = false;
				runmove[player] = false;
			}
		}
	}
}

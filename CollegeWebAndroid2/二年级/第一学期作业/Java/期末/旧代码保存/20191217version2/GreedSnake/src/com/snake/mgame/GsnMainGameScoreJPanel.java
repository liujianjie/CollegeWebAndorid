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
	// �ȼ򵥵ģ�
	JLabel leveljl,playertag1,playertag2, playertag3,playertag4;
	JLabel liziscore[];
	Font levelfont;// �ȼ�����
	Font scorefont;// �ɼ�����
	
	JPanel allcomjp;
	public GsnMainGameScoreJPanel(){
		setLayout(null);
		initFont();
		givespace();
		initComp();
		setComBouns();
		addComp();
		
		// Ĭ����ʾΪ����
		setComModeOfOne();
		this.setBackground(Color.YELLOW);
		this.setSize(new Dimension(GsnInterfaceParam.GAMESCOREWIDTH,GsnInterfaceParam.GAMESCOREHEIGHT));
	}
	public void givespace(){
		
		lizijp = new JPanel[4];
		isliziStart = new boolean[4];
		liziscore = new JLabel[4];
		
		lizisan = new JLabel[5][100];
		
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
	//��ʼ������
	public void initFont(){
		levelfont = new Font("����", 0, 18);
		scorefont = new Font("����", 0, 18);
	}
	// ��ʼ���ؼ�
	public void initComp(){
		allcomjp = new JPanel();
		allcomjp.setLayout(null);
		allcomjp.setBackground(Color.YELLOW);
		
		leveljl = new JLabel("LEVEL:"+GsnMainGameConstants.currLevel);//��ӵȼ�
		playertag1 = new JLabel("PLAYER1:");
		playertag2 = new JLabel("PLAYER2:");
		playertag3 = new JLabel("COMTER2:");
		playertag4 = new JLabel("COMTER3:");
		
		leveljl.setFont(levelfont);
		playertag1.setFont(scorefont);
		playertag2.setFont(scorefont);
		playertag3.setFont(scorefont);
		playertag4.setFont(scorefont);
	}
	// ��ӿؼ�
	public void addComp(){
		this.add(leveljl);
		allcomjp.add(playertag1);
		
		lizijp[0].add(liziscore[0]);
		allcomjp.add(lizijp[0]);
		
		allcomjp.add(playertag2);

		lizijp[1].add(liziscore[1]);
		allcomjp.add(lizijp[1]);
		
		allcomjp.add(playertag3);

		lizijp[2].add(liziscore[2]);
		allcomjp.add(lizijp[2]);
		
		allcomjp.add(playertag4);

		lizijp[3].add(liziscore[3]);
		allcomjp.add(lizijp[3]);
		
		this.add(allcomjp);
	}
	// ����λ��
	public void setComBouns(){
		allcomjp.setBounds(5, 5, GsnInterfaceParam.GAMESCOREWIDTH, GsnInterfaceParam.GAMESCOREHEIGHT - 10);
		
//		// ����
		leveljl.setBounds(10, 5, 70, GsnInterfaceParam.GAMESCOREHEIGHT - 10);
		
		playertag1.setBounds(90, 0, 80, GsnInterfaceParam.GAMESCOREHEIGHT - 10);
		lizijp[0].setBounds(170, 0, 40, GsnInterfaceParam.GAMESCOREHEIGHT - 10);
		liziscore[0].setBounds(0, 0, 40, GsnInterfaceParam.GAMESCOREHEIGHT - 10);
		
		playertag2.setBounds(210, 0, 80, GsnInterfaceParam.GAMESCOREHEIGHT - 10);
		lizijp[1].setBounds(290, 0, 40, GsnInterfaceParam.GAMESCOREHEIGHT - 10);
		liziscore[1].setBounds(0, 0, 40, GsnInterfaceParam.GAMESCOREHEIGHT - 10);
		
		playertag3.setBounds(330, 0, 80, GsnInterfaceParam.GAMESCOREHEIGHT - 10);
		lizijp[2].setBounds(410, 0, 40, GsnInterfaceParam.GAMESCOREHEIGHT - 10);
		liziscore[2].setBounds(0, 0, 40, GsnInterfaceParam.GAMESCOREHEIGHT - 10);
		
		playertag4.setBounds(460, 0, 80, GsnInterfaceParam.GAMESCOREHEIGHT - 10);
		lizijp[3].setBounds(540, 0, 40, GsnInterfaceParam.GAMESCOREHEIGHT - 10);
		liziscore[3].setBounds(0, 0, 40, GsnInterfaceParam.GAMESCOREHEIGHT - 10);
	}
	// �ı�ȼ�
	public void changeLevel(){
		leveljl.setText("LEVEL:"+GsnMainGameConstants.currLevel);
	}
	public void alterComText(){
		switch (GsnMainGameConstants.gamemode) {
			case 1:
				setComModeOfOne();
				break;
			case 2:
				setComModeOfTwo();
				break;
			case 3:
				setComModeOfThree();
				break;
		default:
			break;
		}
	}
	// ģʽ1�� ֻ��һ������
	public void setComModeOfOne(){
		playertag1.setVisible(true);
		playertag2.setVisible(false);
		playertag3.setVisible(false);
		playertag4.setVisible(false);
		
		lizijp[0].setVisible(true);
		lizijp[1].setVisible(false);
		lizijp[2].setVisible(false);
		lizijp[3].setVisible(false);
	}
	// ģʽ2�� ����
	public void setComModeOfTwo(){
		playertag1.setVisible(true);
		playertag2.setVisible(true);
		playertag3.setVisible(false);
		playertag4.setVisible(false);
		
		playertag2.setText("PLAYER2:");
		lizijp[0].setVisible(true);
		lizijp[1].setVisible(true);
		lizijp[2].setVisible(false);
		lizijp[3].setVisible(false);
	}
	// ģʽ3�£����ݶ��ٸ�����
	public void setComModeOfThree(){
		playertag1.setVisible(true);
		lizijp[0].setVisible(true);
		
		for(int i = 0; i < GsnMainGameConstants.snakecomputercount; i++){
			if( i == 0 ){
				playertag2.setText("COMTER1:");
				playertag2.setVisible(true);
				lizijp[1].setVisible(true);
			}
			if(i == 1){
				playertag3.setVisible(true);
				lizijp[2].setVisible(true);
			}
			if(i == 2){
				playertag4.setVisible(true);
				lizijp[3].setVisible(true);
			}
		}
	}
	int changescore[];
	// �ı����
	public void changeScore(int player,int score, int tag){
		player = player - 1;// ��Ϊ������
		changescore[player] = score;
		
		if(score == 0 || tag == 0){
			liziscore[player].setText(score+"");// ֱ�����÷�������������Ǽ���Ҳ��
		}else{
			// ��ʼ
			liziscore[player].setText("");// �����
				if(!isliziStart[player]){
					generateJlabel(player);
				}
		}
	}
	int palen[] = new int[4];
	public void generateJlabel(int player){
		runmove[player] = true;
		// �ٿ�ʼ��Ҫ��
		isliziStart[player] = true;
		// ���ɵ�
		palen[player] = ran.nextInt(10) + 25;// 25 - 30
		
//		lizisan = new JLabel[4][50];
//		lizisan[player] = new JLabel[palen[player] + 2];// Ϊ�˲�ҪԽ��
		Font f = new Font("����", 0, 5);
		for(int i = 0; i < palen[player]; i++){
			lizisan[player][i] = new JLabel(".",JLabel.CENTER);
			// Ϊ��������
			lizisan[player][i].setBounds((liziscore[player].getWidth()) / 2 - 8, (liziscore[player].getHeight()) / 2, 3, 3);
			// ������ɫ
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
	// �����߳�
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
			try{
				// 1.���� xy
				int x = Math.random() > 0.5 ? ran.nextInt(5) * 1 : ran.nextInt(5) * (-1);
				int y = Math.random() > 0.5 ? ran.nextInt(5) * 1 : ran.nextInt(5) * (-1);
				int speed = ran.nextInt(30) + 25;// �ٶ� 25 - 55��
				while(runmove[player]){
					// ����ԭ�ص� ���� x y��0 ��
					if(x == 0 && y == 0){
						lizijp[player].remove(lizisan[player][lbid]);
						break;
					}
					int yx = (int) (lizisan[player][lbid].getX() + x);
					int yy =(int) (lizisan[player][lbid].getY() + y);
					// ����һֱ�ƶ� ���ݷ��� 
					lizisan[player][lbid].setBounds(yx, yy, 3, 3);
					try {
						Thread.sleep(speed);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					lizijp[player].updateUI();
					// �е�û����ȫ�˳�
					if(yx > liziscore[player].getWidth() - 8 || yy > liziscore[player].getHeight()
							|| yx < 0 || yy < 0){
						lizijp[player].remove(lizisan[player][lbid]);
						break;
					}
				}
				lizijp[player].updateUI();
				count[player]++;// �����˾�+1
				if(count[player] >= palen[player] - 5){// ȫ�����ӳ��������� �����ֻܶ࣬ʣһ����û�����������÷���
					count[player] = 0;
					// ȫ��ȥ��
					lizijp[player].removeAll();
					// ����ӻط���
					lizijp[player].add(liziscore[player]);
					// ���÷���
					liziscore[player].setText(changescore[player]+"");
					lizijp[player].updateUI();
					isliziStart[player] = false;
					runmove[player] = false;
				}
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
}

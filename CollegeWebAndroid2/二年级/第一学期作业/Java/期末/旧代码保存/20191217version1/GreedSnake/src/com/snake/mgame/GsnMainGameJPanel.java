package com.snake.mgame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import com.snake.bean.GsnMapCrossNodeBean;
import com.snake.bean.GsnMapSnakeBean;
import com.snake.computer.GsnSnakeComputerPlayer;
import com.snake.config.GsnInterfaceParam;
import com.snake.interfaces.GsnBottomLayerInterface;
import com.snake.mgameconfig.GsnMainGameConstants;

// ��Ҫ��Ϸ��壬��GsnCenterInterface�������
public class GsnMainGameJPanel extends JPanel{
	public boolean controlRun = true;
	public boolean startlevel;
	
	// Ĭ��2����
	GsnSnake gsnsnake[];
	// ʳ����Զ�һ��
	public int MainGamefoodlength;// ����ʳ��������������¹ؿ���ʱ��Ż滭
	public GsnFood gsnfood[];
	// �Ƿ����У�һ��ʼΪԤ��
	boolean isPlay;
	
	// ���б�����
	public List<GsnMainGameMoveBarrier> gsnmgmbarlis;
	public int MainGameMoveBarrierlength;// �ϰ��ﳤ��
	
	// ��Խ�ڵ��б�
	public List<GsnCrossNodeDraw> gsnmgmcrossnodelis;
	int crossnodelength;// 
	
	// AI
	GsnSnakeComputerPlayer snakeAi[];
	
	public GsnMainGameJPanel(){
		firststart();// �ȳ�ʼ����
		initAiSnake();
		// �߳�
		MyThread my = new MyThread();
		my.start();
		this.setBackground(Color.WHITE);
		// width��height��Ҫ��1��Ϊ �滭�ľ���ռ����
		this.setSize(new Dimension(GsnInterfaceParam.GAMEIWIDTH + 1,GsnInterfaceParam.GAMEIHEIGHT + 1));
		// �����¼�
		this.addKeyListener(new GsnMainGameKeyLis());
		isPlay = false;
	}
	// Ai�� ������Ԥ�����֣�����ϷģʽΪ3 ��ʱ������ 
	public void initAiSnake(){
		snakeAi = new GsnSnakeComputerPlayer[2];
		for(int i = 0 ; i < snakeAi.length; i++){
			// �����߳�ʼ��Ϣ
			snakeAi[i] = new GsnSnakeComputerPlayer(gsnsnake[i],this);
		}
		
	}
	// ���ô�С
	public void setnewSize(int width, int height){
		this.setSize(new Dimension(width, height));
		this.repaint();
	}
	// ����ռ�
	public void firststart(){
		gsnsnake = new GsnSnake[2];
		for(int i = 0 ; i < gsnsnake.length; i++){
			// �����߳�ʼ��Ϣ
			gsnsnake[i] = new GsnSnake(this,i + 1);
			gsnsnake[i].start();// �����߳�
		}
	}
	// ��ʼ�� ��ͼ �� �ߵ���Ϣ
	public void initGame(){
		// ��ͼ ��Ϣ
		for(int m = 0; m < 41; m++){
			// ��� 
			GsnMainGameConstants.dynamicmapdata[m] = (GsnMainGameConstants.gsngamemap[GsnMainGameConstants.currLevel - 1].mapdata[m]).clone();
			GsnMainGameConstants.yuanshimapdata[m] = (GsnMainGameConstants.gsngamemap[GsnMainGameConstants.currLevel - 1].mapdata[m]).clone();
		}
		snakeBean();
	}
	public void snakeBean(){
		// �ߵĵ�ͼ��Ϣ ����ǳ���� ��Ҫ�ǳ�ʼλ�õ������鷳
		for(int i = 0; i < 2; i++){
			GsnMainGameConstants.yuanshisnakebean[i] = new GsnMapSnakeBean();
			GsnMainGameConstants.dynamicsnakebean[i] = new GsnMapSnakeBean();
		}
		// ��ʼ��λ��
		GsnMainGameConstants.yuanshisnakebean = GsnMainGameConstants.gsngamemap[GsnMainGameConstants.currLevel - 1].gsmsnakebean.clone();
		GsnMainGameConstants.dynamicsnakebean = GsnMainGameConstants.gsngamemap[GsnMainGameConstants.currLevel - 1].gsmsnakebean.clone();
	}
	// ������ʱ��
	public void initSnakeInfo(){
		// ���¸����ߵĳ�ʼλ��
		for(int i = 0 ; i < gsnsnake.length; i++){
			gsnsnake[i].ReStart(GsnMainGameConstants.yuanshisnakebean[i]);
		}
	}
	// 
	public void PassLevelinitSnakeInfo(int back){
		// ���¸����ߵĳ�ʼλ��
		for(int i = 0 ; i < gsnsnake.length; i++){
			gsnsnake[i].PassLevelReStart(GsnMainGameConstants.yuanshisnakebean[i]);
			if(back == 1){
				gsnsnake[i].score = 0;
			}
		}
	}
	public void initFoodInfo(){
		// ���ֶ���ʳ�� ��Ϊÿ����ͼʳ�ﲻһ��
		MainGamefoodlength = GsnMainGameConstants.gsngamemap[GsnMainGameConstants.currLevel - 1].gsmfoodbean.foodlength;
		// ��֪��ÿ�δ򿪹ؿ��ʹ����̶߳��������᲻����ɺܶ��ڴ�ռ�ã���������������������������������������
		gsnfood = new GsnFood[MainGamefoodlength];
		for(int i = 0 ; i < gsnfood.length; i++){
			gsnfood[i] = new GsnFood();
			gsnfood[i].start();
			gsnfood[i].deadUpdate();// ����ʳ�� ��Ϊ�ȵ�ͼ������ʱ������ж��Ƿ�������ϰ����С�
		}
	}
	public void initBarInfo(){
		// ��ȡ��ͼ�ж����ϰ���
		MainGameMoveBarrierlength = GsnMainGameConstants.gsngamemap[GsnMainGameConstants.currLevel - 1].gsminfobean.barcount;
		gsnmgmbarlis = new ArrayList<GsnMainGameMoveBarrier>(MainGameMoveBarrierlength);
		for(int i = 0 ; i < MainGameMoveBarrierlength; i++){
			GsnMainGameMoveBarrier gsnmgmb = new GsnMainGameMoveBarrier();
			gsnmgmb.init(GsnMainGameConstants.gsngamemap[GsnMainGameConstants.currLevel - 1].gsmbmbean[i]);
			gsnmgmb.start();
			gsnmgmbarlis.add(gsnmgmb);
		}
	}
	// ���ô�Խ�ڵ�start--------------
	public void initCrossNodeList(){
		crossnodelength = GsnMainGameConstants.gsngamemap[GsnMainGameConstants.currLevel - 1].gsminfobean.crossnodecount;
		gsnmgmcrossnodelis = new ArrayList<GsnCrossNodeDraw>(crossnodelength);
		for(int i = 0 ; i < crossnodelength; i++){
			GsnCrossNodeDraw gsncn = new GsnCrossNodeDraw();
			gsncn.setValueToBean(GsnMainGameConstants.gsngamemap[GsnMainGameConstants.currLevel - 1].gsmcrossnodebeanlist.get(i));
			gsnmgmcrossnodelis.add(gsncn);
		}
	}
	public void commonWayOfStartAndView(){
		// ����ת�عؿ�
		initGame();
		// �߳�ʼλ��
		initSnakeInfo();
		// ʳ��
		initFoodInfo();
		// �ϰ���
		initBarInfo();
		// ��Խ
		initCrossNodeList();
		// AI״̬
//		clearAiData();
	}
	// Ԥ���ؿ� ���� �մ򿪹ؿ���ʱ�� ��Ҫ�����߳̾���
	public void Preview(){
		commonWayOfStartAndView();
		this.repaint();
	}
	// ֱ������
	public void restart(){
		// 
		snakeBean();
		// �߳�ʼλ��
		PassLevelinitSnakeInfo(0);
		// ʳ��
		initFoodInfo();
		// �ϰ���
		initBarInfo();
		initCrossNodeList();
		startDraw();
		// AI״̬
		clearAiData();
		this.repaint();
	}
	public void startDraw(){
		gsnsnake[0].startMove();
		if(GsnMainGameConstants.gamemode == 2 ){
			gsnsnake[1].startMove();// ģʽ2  �ſ�ʼ
			snakeAi[1].stopRun();// ����ֹͣ
		}
		for(int i = 0 ; i < MainGamefoodlength; i++){
			gsnfood[i].startUpdate();// ��ʼ����
		}
		for(int i = 0 ; i < MainGameMoveBarrierlength; i++){
			gsnmgmbarlis.get(i).startMove();
		}
		// �ж��Ƿ�ģʽ3
		if(GsnMainGameConstants.gamemode == 3){
			gsnsnake[1].endMove();// ���ֹͣ  
			// ���� �ȵڶ���
			snakeAi[1].startRun();
		}
	}
	public void endDraw(){
		for(int i = 0 ; i < gsnsnake.length; i++){
			gsnsnake[i].endMove();
		}
		for(int i = 0 ; i < MainGamefoodlength; i++){
			gsnfood[i].endUpdate();// ��ʼ����
		}
		for(int i = 0 ; i < MainGameMoveBarrierlength; i++){
			gsnmgmbarlis.get(i).endMove();
		}
		// �ж��Ƿ�ģʽ3
		if(GsnMainGameConstants.gamemode == 3){
			// ���� �ȵڶ���
			snakeAi[1].stopRun();
		}
	}
	// �����߳�
	public void endThread(){
		// �ߵ��̲߳�Ҫ���� ��Ϊ����ѡ�ؿ�û�и����µĶ��� ֹֻͣ�Ϳ���
		for(int i = 0 ; i < gsnsnake.length; i++){
			gsnsnake[i].endMove();
		}
		for(int i = 0 ; i < MainGamefoodlength; i++){
			gsnfood[i].endThread();
		}
		for(int i = 0 ; i < MainGameMoveBarrierlength; i++){
			gsnmgmbarlis.get(i).endThread();
		}
		// �ж��Ƿ�ģʽ3
		if(GsnMainGameConstants.gamemode == 3){
			// ���� �ȵڶ���
			snakeAi[1].stopRun();
		}
	}
	// ��Ϸ��ض���------------
	// ��������ײ ��ͷ��ײ3 ��2ҧ��1 return1 ����1ҧ��2 return2��û��ײ 0
	public void checkCCAnother(){
		// ��ͷײ��
		if(gsnsnake[0].snactuali[0] == gsnsnake[1].snactuali[0] &&
				gsnsnake[0].snactualj[0] == gsnsnake[1].snactualj[0]){
			
			// ����
			gsnsnake[0].cutHalfOfNode();
			gsnsnake[1].cutHalfOfNode();
			// ����
			gsnsnake[0].cutDownScore();
			gsnsnake[1].cutDownScore();
			// ����
			gsnsnake[0].relive();
			gsnsnake[1].relive();
			
			gsnsnake[0].cutSpeed();
			gsnsnake[1].cutSpeed();
		}
		// ��2��ʼ ��Ȼ 1���߽ں��ѿ�
		for(int i = 2; i < gsnsnake[0].node; i++){
			if(gsnsnake[0].snactuali[i] == gsnsnake[1].snactuali[0] &&
					gsnsnake[0].snactualj[i] == gsnsnake[1].snactualj[0]){
				// ��2����ͷҧ����1������1
				// ����
				gsnsnake[0].node = i;
				// ����
				gsnsnake[0].cutDownScore();
				gsnsnake[0].cutSpeed();
				// ����ҧ���߽�Ϊ-1��������
				for(;i < gsnsnake[0].node; i++){
					gsnsnake[0].snactuali[i] = -1;
					gsnsnake[0].snactualj[i] = -1;
				}
				break;
			}
		}
		for(int i = 2 ; i < gsnsnake[1].node; i++){
			if(gsnsnake[1].snactuali[i] == gsnsnake[0].snactuali[0] &&
					gsnsnake[1].snactualj[i] == gsnsnake[0].snactualj[0]){
				// ��1����ͷҧ����2������2
				// ����
				gsnsnake[1].node = i;
				// ����
				gsnsnake[1].cutDownScore();
				gsnsnake[1].cutSpeed();
				// ����ҧ���߽�Ϊ-1��������
				for(;i < gsnsnake[1].node; i++){
					gsnsnake[1].snactuali[i] = -1;
					gsnsnake[1].snactualj[i] = -1;
				}
				break;
			}
		}
		// ����
		this.repaint();
	}
	// �������
	public void delScore(){
		for(int i = 0 ; i < gsnsnake.length; i++){
			gsnsnake[i].delScore();
		}
	}
	
	// ��Ϸ��ض���-----
	// ���̼��� 
	class GsnMainGameKeyLis extends KeyAdapter{
		private int keycode;//
		// ���ڲ����ߣ�Ӧ���ǰ��¾͸ı䣬��Ҫ�������ڸı� ��˳��
		@Override
		public void keyPressed(KeyEvent e) {
			if(isPlay){
				keycode = e.getKeyCode();
				// ��һ����
				if(gsnsnake[0].isfinishcurState){
					if(keycode == KeyEvent.VK_1){
						System.out.println("GsnMainGameKeyLis����1��");
					}else if(keycode == KeyEvent.VK_UP && gsnsnake[0].direction != 1){
						gsnsnake[0].direction = 0;
					}else if(keycode == KeyEvent.VK_DOWN && gsnsnake[0].direction != 0){
						gsnsnake[0].direction = 1;
					}else if(keycode == KeyEvent.VK_LEFT && gsnsnake[0].direction != 3){
						gsnsnake[0].direction = 2;
					}else if(keycode == KeyEvent.VK_RIGHT && gsnsnake[0].direction != 2){
						gsnsnake[0].direction = 3;
					} 
					gsnsnake[0].isfinishcurState = false;
				}
				
				// �ڶ�����
				if(GsnMainGameConstants.gamemode == 2){
					if(gsnsnake[1].isfinishcurState){
						if(keycode == KeyEvent.VK_W && gsnsnake[1].direction != 1){
							gsnsnake[1].direction = 0;
						}else if(keycode == KeyEvent.VK_S && gsnsnake[1].direction != 0){
							gsnsnake[1].direction = 1;
						}else if(keycode == KeyEvent.VK_A && gsnsnake[1].direction != 3){
							gsnsnake[1].direction = 2;
						}else if(keycode == KeyEvent.VK_D && gsnsnake[1].direction != 2){
							gsnsnake[1].direction = 3;
						} 
						gsnsnake[1].isfinishcurState = false;
					}
				}
			}
		}
		@Override
		public void keyReleased(KeyEvent e) {
			keycode = e.getKeyCode();
			if(keycode == KeyEvent.VK_ESCAPE){
				// ֹͣ �ƶ����߳�  ʳ�� �ϰ���
				// ���������
				endThread();
				// ģʽ3 �����
				if(GsnMainGameConstants.gamemode == 3){
					SetResultPanel();
					// ���ý������ ��Ҫ����ջ��
					GsnBottomLayerInterface.updateJPanelNotSave(GsnBottomLayerInterface.gameCenterJpanel,GsnBottomLayerInterface.gameResultAndScoreJpanel);
					GsnBottomLayerInterface.gameResultAndScoreJpanel.requestFocus();
					// ������
					GsnBottomLayerInterface.gameResultAndScoreJpanel.inputnamejf.requestFocus();
				}else{
					// Ҫ�� �滭��С ���û��� 5 Ϊ��Ԥ���ؿ�
					GsnMainGameConstants.setDrawSize(5);
					// ѡ��ؿ�
					GsnBottomLayerInterface.gameLevelJpanel.backSetSelctAndView(0);
					GsnBottomLayerInterface.backLastJPanel();
					System.out.println("GsnMainGameKeyLis����VK_ESCAPE��");
				}
				delScore();
			}else if(keycode == KeyEvent.VK_ENTER){// ��ʼ ���� ��ͣ
//				System.out.println("GsnMainGameKeyLis����VK_ENTER��");
				if(!isPlay){// �������� �Ϳ�ʼ
					startDraw();
					isPlay = true;
				}else{// �����У�����ͣ
					endDraw();
					isPlay = false;
				}
			}
		}
	}
	// ai��ʼ״̬
	public void clearAiData(){
		for(int i = 0; i < snakeAi.length; i++){
			snakeAi[i].cleardata();
		}
	}
	// �滭
	@Override
	public void paint(Graphics g) {
		// TODO �Զ����ɵķ������
		super.paint(g);// ��д��� �ͻ�����һ���ı���
		Color yuan = g.getColor();
		for(int m = 0; m < 41; m++){
			for(int n = 0; n < 60; n++){
				if(GsnMainGameConstants.dynamicmapdata[m][n] == 1){
					g.setColor(Color.DARK_GRAY);
					g.fillRect(n * GsnMainGameConstants.drawSize, m * GsnMainGameConstants.drawSize, GsnMainGameConstants.drawSize, GsnMainGameConstants.drawSize);
				}
			}
		}
		// ��Խ�ڵ�
		for(int i = 0; i < crossnodelength; i++ ){
			if(gsnmgmcrossnodelis.get(i) != null){// �е����Ϊnull ���ܻ滭��
				g.setColor(GsnMainGameConstants.crosscolor[i]);// �Ѿ����ú���
				gsnmgmcrossnodelis.get(i).draw(g);
			}
		}	
		// �滭�ؿ�ʱ����
		if(!startlevel){
			// �滭ʳ��
			g.setColor(Color.PINK);
			for(int i = 0; i < MainGamefoodlength; i++){
				gsnfood[i].draw(g);
			}
			g.setColor(Color.BLACK);
			// �滭�ϰ���
			for(int i = 0; i < MainGameMoveBarrierlength; i++){
				gsnmgmbarlis.get(i).draw(g);
			}
		}
		// �滭��
		g.setColor(Color.RED);
		gsnsnake[0].draw(g);
		// ��ģʽ2 3 ��ʱ�򲻻���
		if(GsnMainGameConstants.gamemode == 2 || GsnMainGameConstants.gamemode == 3){
			g.setColor(Color.GREEN);
			gsnsnake[1].draw(g);
		}
		g.setColor(yuan);
		GsnMainGameJPanel.this.repaint();
		
		// ��������ײ ֻ��Ҫһ������ײ��� �����˰� 
		// 20191130����ײ�ͳ�ʳ��Ĵ���������ﲻ֪���ò���
		if(GsnMainGameConstants.gamemode == 2 || GsnMainGameConstants.gamemode == 3){
//			checkCCAnother();
		}
	}
	
	// ͨ�ش���
	int gamescore;//ͳ�Ƶ�ǰ�ؿ����˶��ٷ�
	public void giveGamePanleScore(){
		// ����ģʽ�鿴
		if(gsnsnake[0].currlevelscore > gsnsnake[1].currlevelscore){
			gamescore = gsnsnake[0].currlevelscore;
		}else{
			gamescore = gsnsnake[1].currlevelscore;
		}
	}
	// ���� �������� ������ ����ؿ� ����ʳ��
	public void passLevel(){
		// ����Ƿ����
		if(gamescore >= GsnMainGameConstants.PASSLEVELNEEDSCORE){
			// �����
			gamescore = 0;
			gsnsnake[0].currlevelscore = 0;
			gsnsnake[1].currlevelscore = 0;
			
			// �ؿ���1
			if(GsnMainGameConstants.currLevel + 1 <= GsnMainGameConstants.gsngamemap.length){
				GsnMainGameConstants.currLevel = GsnMainGameConstants.currLevel + 1;
				// ��ֹͣ
				endThread();
				// �����߳�
				startLevel();
				// 
//				restart();
			}else{
				// ֹͣ �ƶ����߳�  ʳ�� �ϰ���
				endThread();
				if(GsnMainGameConstants.gamemode != 1){
					SetResultPanel();
				}else{// ͨ��1
					SetSingleDeadResultPanel(0);
				}
				// ��շ���
				gsnsnake[0].setScoreZero();
				gsnsnake[1].setScoreZero();
				// ���ý������ ��Ҫ����ջ��
				GsnBottomLayerInterface.updateJPanelNotSave(GsnBottomLayerInterface.gameCenterJpanel,GsnBottomLayerInterface.gameResultAndScoreJpanel);
				GsnBottomLayerInterface.gameResultAndScoreJpanel.requestFocus();
				// ������
				GsnBottomLayerInterface.gameResultAndScoreJpanel.inputnamejf.requestFocus();
			}
		}
	}
	// ���ص�ͨ�����ý�����
	public void SetResultPanel(){
		// ͨ�أ����÷������
		String s1 = "CONGRATULATIONS", s2 = "WINNER:PLAYER1 SCORE:"+gsnsnake[0].score;
		if(GsnMainGameConstants.gamemode == 2){
			if(gsnsnake[0].score < gsnsnake[1].score){
				s2 = "WINNER:PLAYER2 SCORE:"+gsnsnake[1].score;
			}
		}else if(GsnMainGameConstants.gamemode == 3){
			if(gsnsnake[0].score < snakeAi[1].gsnake.score){
				s1 = "Unfortunately";
				s2 = "WINNER:COMPUTER SCORE:"+gsnsnake[1].score;
				// ģʽ3 �������ʤ�� ��
				GsnBottomLayerInterface.gameResultAndScoreJpanel.jin();
			}
		}
		if(gsnsnake[0].score == gsnsnake[1].score){
			s1 = "It ends in a draw";
			s2 = "SCORE:"+gsnsnake[0].score;
			// ƽ��
			GsnBottomLayerInterface.gameResultAndScoreJpanel.jin();
		}
		GsnBottomLayerInterface.gameResultAndScoreJpanel.setResultString(s1, s2);
	}
	//����ģʽ����
	public void SetSingleDeadResultPanel(int dead){// 1����
		// ͨ�أ����÷������
		String s1, s2;
		if(dead == 1){
			 s1 = "GAME OVER"; 
			 s2 = "SCORE:"+gsnsnake[0].score;
		}else{
			 s1 = "CONGRATULATIONS"; 
			 s2 = "SCORE:"+gsnsnake[0].score;
		}
		
		GsnBottomLayerInterface.gameResultAndScoreJpanel.setResultString(s1, s2);
	}
	public void startLevel(){
		startlevel = true;
	}
	public void endGame(){
		controlRun = false;
		startlevel = false;
	}
	// Ϊ���ӳ�ˢ�������߳�
	class MyThread extends Thread{
		@Override
		public void run() {
			while(controlRun){
				System.out.print("");
				if(startlevel){
					// ��ͼ ��Ϣ
					// ��������
					for(int n = 0; n < 60; n++){
						try {
							Thread.sleep(25);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						for(int m = 0; m < 41; m++){
							// ��� 
							GsnMainGameConstants.dynamicmapdata[m][n] = (GsnMainGameConstants.gsngamemap[GsnMainGameConstants.currLevel - 1].mapdata[m][n]);
							GsnMainGameConstants.yuanshimapdata[m][n] = (GsnMainGameConstants.gsngamemap[GsnMainGameConstants.currLevel - 1].mapdata[m][n]);
							// �ú���һ��Ϊǽ
							if(n + 2 < 60){
								GsnMainGameConstants.dynamicmapdata[m][n + 2] = 1;
							}
						}
						// ����һ�� ˢ��һ��
						GsnMainGameJPanel.this.repaint();
					}
					// �����¿���
					// ֹͣ��ǰ���߳�
					restart();
					// ���ҽ����߳� �����ں��棡����
					startlevel = false;
				}
			}
		}
	}
}

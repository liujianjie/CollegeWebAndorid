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
		
		// �ǽ� snake�������� ��ai����
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
		snakeAi = new GsnSnakeComputerPlayer[3];
		for(int i = 0 ; i < snakeAi.length; i++){
			// �����߳�ʼ��Ϣ
			snakeAi[i] = new GsnSnakeComputerPlayer(gsnsnake[i + 1],this);// ���1���ɿ�
		}
		
	}
	// ���ô�С
	public void setnewSize(int width, int height){
		this.setSize(new Dimension(width, height));
		this.repaint();
	}
	// ����ռ�
	public void firststart(){
		gsnsnake = new GsnSnake[4];
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
		snakeBeanFromMap();
	}
	public void snakeBeanFromMap(){
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
		for(int i = 0 ; i < 2; i++){// ǰ��2��Ĭ��λ��
			gsnsnake[i].ReStart(GsnMainGameConstants.yuanshisnakebean[i]);
		}
		initAisnakeInfo();
	}
	// ��λai��λ��
	public void initAisnakeInfo(){
		GsnMapSnakeBean gsnmapsankebean;
		for(int i = 2 ; i < 4; i++){// ����2�� ��û���ϰ����λ��
			gsnmapsankebean = isMapDataSuitAiSnake(i);
			gsnmapsankebean.snnode = 2;
			gsnsnake[i].ReStart(gsnmapsankebean);
		}
	}
	// �ӵ�ͼ�ж� ��ǰλ���Ƿ���ԣ����Ծͷ���
	public GsnMapSnakeBean isMapDataSuitAiSnake(int tag){
		GsnMapSnakeBean gsnmapsankebean = new GsnMapSnakeBean();
		if(tag == 2){// ������
			gsnmapsankebean.snmapdirection = 3;
			// �ȴ����½� ���϶�λͷ���
			int n = 0;
			for(int m = 40; m >= 0; m--){
				if(GsnMainGameConstants.dynamicmapdata[m][n] == 0){
					gsnmapsankebean.CalSecondNodeByDir(m,n);
					if(GsnMainGameConstants.dynamicmapdata[gsnmapsankebean.snmapi[1]][gsnmapsankebean.snmapj[1]] == 0){
						return gsnmapsankebean;
					}
				}
				n++;
			}
		}else if(tag == 3){// ������
			gsnmapsankebean.snmapdirection = 2;
			// �ȴ����Ͻ� ���¶�λͷ���
			int n = 59;
			for(int m = 0; m < 41; m++){
				if(GsnMainGameConstants.dynamicmapdata[m][n] == 0){
					gsnmapsankebean.CalSecondNodeByDir(m,n);
					if(GsnMainGameConstants.dynamicmapdata[gsnmapsankebean.snmapi[1]][gsnmapsankebean.snmapj[1]] == 0){
						return gsnmapsankebean;
					}
				}
				n--;
			}
		}
		return gsnmapsankebean;
	}
	// 
	public void PassLevelinitSnakeInfo(int back){
		// ���¸����ߵĳ�ʼλ��
		for(int i = 0 ; i < 2; i++){// ֻ��2��
			gsnsnake[i].PassLevelReStart(GsnMainGameConstants.yuanshisnakebean[i]);
			if(back == 1){
				gsnsnake[i].score = 0;
			}
		}
		initAisnakeInfo();
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
			GsnMainGameMoveBarrier gsnmgmb = new GsnMainGameMoveBarrier(this);
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
		// ʳ��
		initFoodInfo();
		// �ϰ���
		initBarInfo();
		// �߳�ʼλ��
		initSnakeInfo();
		// ��Խ
		initCrossNodeList();
	}
	// Ԥ���ؿ� ���� �մ򿪹ؿ���ʱ�� ��Ҫ�����߳̾���
	public void Preview(int i){
		commonWayOfStartAndView();
		if(i == 1){
			clearAiData();
		}
		this.repaint();
	}
	// ֱ������
	public void restart(){
		// ��ͼ���߳������ 
		// ����snakeλ��
		snakeBeanFromMap();
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
	// ����ֹͣ
	public void computerEndThread(){
		for(int i = 0; i < GsnMainGameConstants.snakecomputercount; i++){
			snakeAi[i].stopRun();// ����ֹͣ
		}
	}
	public void computerStart(){
		for(int i = 0; i < GsnMainGameConstants.snakecomputercount; i++){
			snakeAi[i].startRun();// ����
		}
	}
	public void computerStop(){
		for(int i = 0; i < GsnMainGameConstants.snakecomputercount; i++){
			snakeAi[i].stopRun();// ����ֹͣ
		}
	}
	
	public void startDraw(){
		gsnsnake[0].startMove();
		if(GsnMainGameConstants.gamemode == 2 ){
			gsnsnake[1].startMove();// ģʽ2  �ſ�ʼ
			computerStop();
		}
		for(int i = 0 ; i < MainGamefoodlength; i++){
			gsnfood[i].startUpdate();// ��ʼ����
		}
		for(int i = 0 ; i < MainGameMoveBarrierlength; i++){
			gsnmgmbarlis.get(i).startMove();
		}
		// �ж��Ƿ�ģʽ3
		if(GsnMainGameConstants.gamemode == 3){
			gsnsnake[1].endMove();// ���2ֹͣ  
			
			computerStart();
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
			computerStop();
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
			computerEndThread();
		}
	}
	// ��Ϸ��ض���start------------
	public void snakeRelive(int tag){
		// ����
		gsnsnake[tag].cutHalfOfNode();
		this.repaint();
		// ����
		gsnsnake[tag].cutDownScore();
		// ����
		gsnsnake[tag].relive();
		
		gsnsnake[tag].cutSpeed();
	}
	public void cutNodeAnSpeed(int tag, int i){
		// ����
		gsnsnake[tag].node = i;
		// ����
		gsnsnake[tag].cutDownScore();
		gsnsnake[tag].cutSpeed();
		// ����ҧ���߽�Ϊ-1��������
		for(;i < gsnsnake[tag].node; i++){
			gsnsnake[tag].snactuali[i] = -1;
			gsnsnake[tag].snactualj[i] = -1;
		}
		this.repaint();
	}
	// �ж��������Ƿ�ײ����
	public boolean isCollHeadTwo(int one, int two){
		// ��ͷײ��
		if(gsnsnake[one].snactuali[0] == gsnsnake[two].snactuali[0] &&
				gsnsnake[one].snactualj[0] == gsnsnake[two].snactualj[0]){
			snakeRelive(one);// ����
			snakeRelive(two);
			// ����
			this.repaint();
			return true;
		}
		return false;
	}
	// ģʽ2�µ�
	public void checkCCAnother(){
		// ��ͷײ��
		if(isCollHeadTwo(0 , 1)){
			// ����
			this.repaint();
			return;
		}
		// ��2��ʼ ��Ȼ 1���߽ں��ѿ�
		for(int i = 2; i < gsnsnake[0].node; i++){
			if(gsnsnake[0].snactuali[i] == gsnsnake[1].snactuali[0] &&
					gsnsnake[0].snactualj[i] == gsnsnake[1].snactualj[0]){
				// ��2����ͷҧ����1������1
				cutNodeAnSpeed(0, i);
				break;
			}
		}
		for(int i = 2 ; i < gsnsnake[1].node; i++){
			if(gsnsnake[1].snactuali[i] == gsnsnake[0].snactuali[0] &&
					gsnsnake[1].snactualj[i] == gsnsnake[0].snactualj[0]){
				// ��1����ͷҧ����2������2
				cutNodeAnSpeed(1, i);
				break;
			}
		}
		// ����
		this.repaint();
	}
	// ģʽ3��
	public void commonPan(int one, int two){
		// ��ͷײ��
		if(isCollHeadTwo(one, two)){
			// ����
			this.repaint();
			return;
		}
		// ��2��ʼ ��Ȼ 1���߽ں��ѿ�
		for(int i = 2; i < gsnsnake[one].node; i++){
			if(gsnsnake[one].snactuali[i] == gsnsnake[two].snactuali[0] &&
					gsnsnake[one].snactualj[i] == gsnsnake[two].snactualj[0]){
				// ��2����ͷҧ����1������1
				cutNodeAnSpeed(one, i);
				break;
			}
		}
		for(int i = 2 ; i < gsnsnake[two].node; i++){
			if(gsnsnake[two].snactuali[i] == gsnsnake[one].snactuali[0] &&
					gsnsnake[two].snactualj[i] == gsnsnake[one].snactualj[0]){
				// ��1����ͷҧ����2������2
				cutNodeAnSpeed(two, i);
				break;
			}
		}
		// ����
		this.repaint();
	}
	public void checkCCAnotherfromcount(){
		// 1�� 2��ͷײ��
		switch (GsnMainGameConstants.snakecomputercount) {// �ֶ� ��û��ô���ˡ���ʱ��
			case 1:
				commonPan(0, 1);
				break;
			case 2:
				commonPan(0, 1);
				commonPan(0, 2);
				commonPan(1, 2);
				break;
			case 3:
				commonPan(0, 1);
				commonPan(0, 2);
				commonPan(0, 3);
				
				commonPan(1, 2);
				commonPan(1, 3);
				
				commonPan(2, 3);
				break;
			default:
				break;
		}
	}
	// ��Ϸ��ض���end------------
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
				if(GsnMainGameConstants.drawSize == 10){
					g.drawImage(GsnMainGameConstants.imgresourceten[0], n * GsnMainGameConstants.drawSize, m * GsnMainGameConstants.drawSize, this);
					if(GsnMainGameConstants.dynamicmapdata[m][n] == 1){
						g.drawImage(GsnMainGameConstants.imgresourceten[1], n * GsnMainGameConstants.drawSize, m * GsnMainGameConstants.drawSize, this);
					}
				}else{
					g.drawImage(GsnMainGameConstants.imgresourcefive[0], n * GsnMainGameConstants.drawSize, m * GsnMainGameConstants.drawSize, this);
					if(GsnMainGameConstants.dynamicmapdata[m][n] == 1){
						g.drawImage(GsnMainGameConstants.imgresourcefive[1], n * GsnMainGameConstants.drawSize, m * GsnMainGameConstants.drawSize, this);
					}
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
		gsnsnake[0].draw(g);
		// ��ģʽ2 3 ��ʱ�����
		if(GsnMainGameConstants.gamemode == 2){
			gsnsnake[1].draw(g);
		}
		// ģʽ3���ж��ٸ�����
		if(GsnMainGameConstants.gamemode == 3){
			for(int i = 0; i < GsnMainGameConstants.snakecomputercount; i++){
				gsnsnake[i + 1].draw(g);
			}
		}
		g.setColor(yuan);
		GsnMainGameJPanel.this.repaint();
		
		// ��������ײ ֻ��Ҫһ������ײ��� �����˰� 
		// 20191130����ײ�ͳ�ʳ��Ĵ���������ﲻ֪���ò���
		if(GsnMainGameConstants.gamemode == 2 ){// ģʽ2��ʱ��ֻҪ�ж���������
			checkCCAnother();
		}
		if(GsnMainGameConstants.gamemode == 3){// ģʽ3��ʱ��Ҫ�ж϶��
			checkCCAnotherfromcount();
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
			// ��������
			int maxscore = -1 << 30;
			for(int i = 0; i < GsnMainGameConstants.snakecomputercount; i++){
				if(gsnsnake[0].score < snakeAi[i].gsnake.score){
					s1 = "Unfortunately";
					// ģʽ3 �������ʤ�� ��
					GsnBottomLayerInterface.gameResultAndScoreJpanel.jin();
					
					maxscore = snakeAi[i].gsnake.score;
					s2 = "WINNER:COMPUTER SCORE:"+maxscore;
				}
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

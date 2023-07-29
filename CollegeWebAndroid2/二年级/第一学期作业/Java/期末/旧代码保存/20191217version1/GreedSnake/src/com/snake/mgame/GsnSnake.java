package com.snake.mgame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;

import com.snake.bean.GsnMapCrossNodeBean;
import com.snake.bean.GsnMapSnakeBean;
import com.snake.editmap.GsnEditMapMainGameAreaJPanel;
import com.snake.editmap.GsnEditmapInterface;
import com.snake.interfaces.GsnBottomLayerInterface;
import com.snake.mgameconfig.GsnMainGameConstants;

public class GsnSnake extends Thread{
	// ����
	public GsnMapSnakeBean gsnmapsankebean;
	
	// �µ�����
	public long snspeed;// �ٶ�
	public boolean controlStart;//���ƿ�ʼ
	public boolean isRun;// �Ƿ����
	public int N;// �߽�
	// ��Ϸ��ӵ�е��߽�����������
	public int snactuali[];// 0����ͷ��i
	public int snactualj[];// 0����ͷ��j
	public int node;// ��Ϸ���߽�
	public int direction;//0123 �������� ��Ϸ�ķ���
//	public int headcurri,headcurrj;
	public boolean isfinishcurState;// �Ƿ���ɵ�ǰ��ָ��
	public int score;// ����
	public int currlevelscore;// ��ǰ�ؿ�����
	public int playertag;// ��ʶ �����1 ���� ���2
	
	GsnEditMapMainGameAreaJPanel gsneditmapmainareainter;
	GsnMainGameJPanel gsnmgjpanel;
	
	public int tag;// 1���ڱ����ͼ�У�0�������
	
	// clone
	public GsnSnake(GsnSnake gs){
		snactuali = gs.snactuali.clone();
		snactualj = gs.snactualj.clone();
		
	}
	// ��ʼ����Ϣ
	public GsnSnake(GsnEditMapMainGameAreaJPanel gsneditmapmainareainter,int playertag){
		// �����Ϣ
		gsnmapsankebean = new GsnMapSnakeBean();
		this.playertag = playertag;
		this.gsneditmapmainareainter = gsneditmapmainareainter;
		N = 500;
		snactuali = new int[N];
		snactualj = new int[N];
		controlStart = true;
		
		score = 0;
		isRun = false;
		snspeed = GsnMainGameConstants.SnakeMoveSpeedMax;
		isfinishcurState = false;// �Ƿ���ɵ�ǰ��ָ��
	}
	// ��շ�
	public void delScore(){
		score = 0;
	}
	public void InitBySnakeBean(GsnMapSnakeBean snakebean){
		snspeed = GsnMainGameConstants.SnakeMoveSpeedMax;
		this.gsnmapsankebean = snakebean;
		direction = gsnmapsankebean.snmapdirection;
		node = gsnmapsankebean.snnode;
		snactuali[0] = gsnmapsankebean.snmapi[0];
		snactualj[0] = gsnmapsankebean.snmapj[0];
		snactuali[1] = gsnmapsankebean.snmapi[1];
		snactualj[1] = gsnmapsankebean.snmapj[1] ;
	}
	public GsnSnake(GsnMainGameJPanel gsnmgjpanel, int playertag){
		// �����Ϣ
		this.playertag = playertag;
		this.gsnmgjpanel = gsnmgjpanel;
		N = 500;
		snactuali = new int[N];
		snactualj = new int[N];
		controlStart = true;
		snspeed = GsnMainGameConstants.SnakeMoveSpeedMax;
	}
	
	// �޸ĵ�ͼʱ�����ֶ�λ
//	public void initOfNumber(int n, int d, int i, int j){
//		score = 0;
//		isRun = false;
//		snspeed = GsnMainGameConstants.SnakeMoveSpeedMax;
//		isfinishcurState = false;// �Ƿ���ɵ�ǰ��ָ��
//		
//		// Ĭ����Ϣ ��һ��ͼû�г�ʼ��Ϣ
//		node = n;
//		direction = d;
//		snactuali[0] = i;
//		snactualj[0] = j;
//	}
	// ��ʼλ����Ϣ ������ node ��Ϸ�е��߽�����Ϸ����
	public void InitPosFromSnakeBean(GsnMapSnakeBean gmb){
		direction = gmb.snmapdirection;
		for(int i = 0; i < gmb.snnode; i++){
			snactuali[i] = gmb.snmapi[i];
			snactualj[i] = gmb.snmapj[i];
		}
	} 
	public void ReStart(GsnMapSnakeBean gmb){
		addScore(score, 0);
		gsnmapsankebean = gmb;
		node = gmb.snnode;
		// �ٶ�ҲҪ��ʼ��
		snspeed = GsnMainGameConstants.SnakeMoveSpeedMax;
		// �ӵ�ͼ�ϸ��赱ǰ
		InitPosFromSnakeBean(gsnmapsankebean);
		// ���Ϊ�� ֻ���Լ�������
		if(gmb.snnode == 0){
			gsnmapsankebean = new GsnMapSnakeBean(2, 1, 3, 5, 2, 5);
//			initForEditMap(2, 1, 3, 5, 2, 5);
//			gsnsnake[0].initForEditMap(2, 1, 3, 5, 2, 5);
//			gsnsnake[1].initForEditMap(2, 0, 37, 55, 38, 55);// ����ͼ��û������Ϣֻ���Լ���ʼ����
		}
	}
	// ����ʱ�� �߽ڱ���
	public void PassLevelReStart(GsnMapSnakeBean gmb){
		addScore(score ,0);
		gsnmapsankebean = gmb;
		// �ӵ�ͼ�ϸ��赱ǰ
		InitPosFromSnakeBean(gsnmapsankebean);
		// ����2���߽��� �����߽� ҲΪ��2���߽�λ��
		for(int i = 2; i < node ;i++){
			snactuali[i] = snactuali[1];
			snactualj[i] = snactualj[1];
		}
	}
	// ���������
	public void setScoreZero(){
		score = 0;
		currlevelscore = 0;
	}
	// ����
	public void relive(){
		// �߳�ʼλ��
		InitPosFromSnakeBean(gsnmapsankebean);
	}
	// ��ʼ�߳�
	public void startMove(){
		isRun = true;// ��ʼ�߳�
	}
	public void endMove(){// ʧ�� ���� �����������
		isRun = false;
	}
	public void endThread(){// �˳�
		controlStart = false;
		isRun = false;
//		stop();
	}
	public void move(){
		// ǰһ���߽ڸ�����һ���߽�
		for(int i = node - 1; i > 0; i--){
			snactuali[i] = snactuali[i - 1];
			snactualj[i] = snactualj[i - 1];
		}
		// ������ͷ
		switch (direction) {
			case 0:
				snactuali[0] -= 1;
				break;
			case 1:
				snactuali[0] += 1;
				break;
			case 2:
				snactualj[0] -= 1;
				break;
			case 3:
				snactualj[0] += 1;
			break;

			default:
				break;
		}
		touchBoundary();
		// �Ƿ������˴�Խ�ڵ�
//		isCollCrossNode();
//		CalHeadXY();
	}
	// ������ͷ������ ������
	public void CalHeadXY(){
//		snactuali[0] = headcurri;
//		snactualj[0] = headcurrj;
//		headcurri = snactuali[0];
//		headcurrj = snactualj[0];
	}
	// �߽��⣬�Ƿ�Խ���߽� �����޸���ͷλ�� 
	public void touchBoundary(){
		// ���� 0~40
		if(snactuali[0] >= 41){// ��ⳬ���߽��Ҫ��1
			snactuali[0] = 0;
		}else if(snactuali[0] < 0){// Ҫ���� 0 
			snactuali[0] = 40;//  
		}
		// ����0~59
		if(snactualj[0] >= 60){// ��ⳬ���߽��Ҫ��1
			snactualj[0] = 0;
		}else if(snactualj[0] < 0){// Ҫ���� 0 
			snactualj[0] = 59;// 
		}
	}
	// ��ײ��� �Լ�ҧ�Լ� ������� ײǽ
	public boolean checkComeCrossWar(){// ��ǽ
		// Ҫ�������ĸ� �����������Ϸ ���� �༭��ͼԤ�� ������dynadata ������
		// ÿ���߽ڶ��ü��
		for(int i = 0; i < node; i++){
			if(GsnMainGameConstants.dynamicmapdata[snactuali[i]][snactualj[i]] == 1 ||
					GsnMainGameConstants.dynamicmapdata[snactuali[i]][snactualj[i]] == 56){// ���ƶ��ϰ�
				return true;
			}
		}
		return false;
	}
	// �Լ�ҧ���Լ�
	public boolean bitSelf(){
		for(int i = 1; i < node; i++ ){
			if(snactuali[i] == snactuali[0] && snactualj[i] == snactualj[0]){
				node = i;// ��ҧ����߽ڲ�Ҫ�ˣ�Ϊ��ģʽ2 ģʽ3 ģʽ1ֱ����ת
				return true;
			}
		}
		return false;
	}
	public void collisionCheck(){
		boolean penqiang = checkComeCrossWar();
		boolean bitselfbln = bitSelf();
		
		// ����Ǳ༭��ͼԤ���ͼ򵥵����� �ٶ�Ҳ��
		if(gsneditmapmainareainter != null){
			if(penqiang || bitselfbln){
				relive();
				cutHalfOfNode();
				return;// ��������ȥ��
			}
		}
		
		// ģʽ1 Ϊ��Ϸ����
		if(GsnMainGameConstants.gamemode == 1){
			if(penqiang || bitselfbln){
				// ֹͣ �߳�  ʳ�� �ϰ���
				gsnmgjpanel.endThread();
				// ���ý�������
				gsnmgjpanel.SetSingleDeadResultPanel(1);
				if(score == 0 && playertag == 1){
					GsnBottomLayerInterface.gameResultAndScoreJpanel.jin();
				}
				setScoreZero();
				// ���ý������ ��Ҫ����ջ��
				GsnBottomLayerInterface.updateJPanelNotSave(GsnBottomLayerInterface.gameCenterJpanel,GsnBottomLayerInterface.gameResultAndScoreJpanel);
				GsnBottomLayerInterface.gameResultAndScoreJpanel.requestFocus();
				// ������
				GsnBottomLayerInterface.gameResultAndScoreJpanel.inputnamejf.requestFocus();

				// ��ײ���� �͸��»��� 
				gsnmgjpanel.repaint();
			}
		}
		// ģʽ2 Ϊ���¸�����������߽ڼ�
		if(GsnMainGameConstants.gamemode == 2){
			if(penqiang){// ��ǽ���� 
				// �ȼ����߽���Щ
				relive();
				cutHalfOfNode();
				cutDownScore();
				cutSpeed();
				// ��ײ���� �͸��»��� 
				gsnmgjpanel.repaint();
			}
			if(bitselfbln){// ҧ�Լ����� ���� ���߽�
				// 
				cutDownScore();
				cutSpeed();
				// ��ײ���� �͸��»��� 
				gsnmgjpanel.repaint();
			}
//			System.out.println("���ٷ��� �����߽� ���¸����ʼλ��");
		}
		// ģʽ3 Ϊ���¸�����������߽ڼ�
		if(GsnMainGameConstants.gamemode == 3){
			if(penqiang){// ��ǽ���� 
				relive();
				cutHalfOfNode();
				cutDownScore();
				cutSpeed();
				// ��ײ���� �͸��»��� 
				gsnmgjpanel.repaint();
			}
			if(bitselfbln){// ҧ�Լ����� ���� ���߽�
				cutDownScore();
				cutSpeed();
				// ��ײ���� �͸��»��� 
				gsnmgjpanel.repaint();
			}
//			System.out.println("���ٷ��� �����߽� ���¸����ʼλ��");
		}
	}
	
	// �滭
	public void draw(Graphics g){
//		Color c = g.getColor();
//		g.setColor(Color.black);
//		g.fillRect(snactualj[0] * GsnMainGameConstants.drawSize,snactuali[0] * GsnMainGameConstants.drawSize, GsnMainGameConstants.drawSize, GsnMainGameConstants.drawSize);// Ҫ������Ϊx,y
//		g.setColor(c);
		for(int i = 0; i < node; i++){
			g.fillRect(snactualj[i] * GsnMainGameConstants.drawSize,snactuali[i] * GsnMainGameConstants.drawSize, GsnMainGameConstants.drawSize, GsnMainGameConstants.drawSize);// Ҫ������Ϊx,y
//			System.out.println(snactuali[i]+" "+snactualj[i]);
		}
	}
	
	// add score�ӷ� ,tage 0 ���ֻ������ã�1�ӷ�
	public void addScore(int sc, int tag){
		GsnBottomLayerInterface.gameCenterJpanel.gsnmaingamescroeJpanel.changeScore(playertag, sc, tag);
	}
	// ���� �����ȼ�10 �ٿ� һ��  ż����һ��
	public void cutDownScore(){
		if(score > 10){// 
			if((score / 10) % 2 == 0){// 20 40
				score /= 2;
			}else{// 30 50
				score = (score - 10) / 2;
			}
		}else{
			score = 0;
		}
		addScore(score, 0);
		currlevelscore = score;
	}
	// ���߽�
	public void cutDownNode(){
		if(node > 2){
			node--;
		}
	}
	// ��һ���߽� ���� ��-1 /2 ż�� /2
	public void cutHalfOfNode(){
		// ԭ��node
		int yuannode = node;
		if(node > 2){
			if(node % 2 == 0 && node != 2){//  4 
				node /= 2;
			}else{// 3 5
				if(node - 1 != 2){
					node = (node - 1) / 2;
				}else{
					node = (node - 1);
				}
			}
			// ������Ľڵ�Ϊ-1
			for(int i = node; i < yuannode; i++){
				snactuali[i] = -1;
				snactualj[i] = -1;
			}
		}
		if(node < 2){
			node = 2;
		}
	}
	// ���ٶ�
	public void addSpeed(){
		// ����ģʽ�� �ٶȸ���
		if(GsnMainGameConstants.gamemode == 1){
			// С����С�ٶȾͲ�����
			if(snspeed - GsnMainGameConstants.SnakeChangeSpeedUp  < GsnMainGameConstants.SnakeSinMoveSpeedMin){
				snspeed = GsnMainGameConstants.SnakeSinMoveSpeedMin;
			}else{
				snspeed -= GsnMainGameConstants.SnakeChangeSpeedUp;
			}
		}else{
			// С����С�ٶȾͲ�����
			if(snspeed - GsnMainGameConstants.SnakeChangeSpeedUp  < GsnMainGameConstants.SnakeMoveSpeedMin){
				snspeed = GsnMainGameConstants.SnakeMoveSpeedMin;
			}else{
				snspeed -= GsnMainGameConstants.SnakeChangeSpeedUp;
			}
		}
	}
	// ���ٶ�
	public void cutSpeed(){
		// ��һ���ٶ�
		if(snspeed + GsnMainGameConstants.SnakeChangeSpeedCut < GsnMainGameConstants.SnakeMoveSpeedMax){
			snspeed += GsnMainGameConstants.SnakeChangeSpeedCut;
		}else{// ���� �������е������
			snspeed = GsnMainGameConstants.SnakeMoveSpeedMax;
		}
	}
	public void isCollCrossNode(){
		GsnMapCrossNodeBean cs;
		if(gsnmgjpanel != null){
			for(int i = 0; i < gsnmgjpanel.crossnodelength; i++){
				cs = gsnmgjpanel.gsnmgmcrossnodelis.get(i).gsncnbean;
				// �����ڵ�
				// ������һ��
				if(cs.firstpos[0] == snactuali[0] && cs.firstpos[1] == snactualj[0]){
					snactuali[0] = cs.secondpos[0];
					snactualj[0] = cs.secondpos[1];
					return;
				}
				// �����ڶ���
				if(cs.secondpos[0] == snactuali[0] && cs.secondpos[1] == snactualj[0]){
					snactuali[0] = cs.firstpos[0];
					snactualj[0] = cs.firstpos[1];
					return;
				}
			}
		}else{
			for(int i = 0; i < gsneditmapmainareainter.crossnodelength; i++){
				cs = gsneditmapmainareainter.gsnmgmcrossnodelis.get(i).gsncnbean;
				// �����ڵ�
				// ������һ��
				if(cs.firstpos[0] == snactuali[0] && cs.firstpos[1] == snactualj[0]){
					snactuali[0] = cs.secondpos[0];
					snactualj[0] = cs.secondpos[1];
					return;
				}
				// �����ڶ���
				if(cs.secondpos[0] == snactuali[0] && cs.secondpos[1] == snactualj[0]){
					snactuali[0] = cs.firstpos[0];
					snactualj[0] = cs.firstpos[1];
					return;
				}
			}
		}
	}
	public void eatFood(){
		// �����
		for(int i = 0; i < gsnmgjpanel.MainGamefoodlength; i++){
			if(gsnmgjpanel.gsnfood[i].curi == snactuali[0] && gsnmgjpanel.gsnfood[i].curj == snactualj[0]){
				// ʳ����������
				gsnmgjpanel.gsnfood[i].deadUpdate();
				node++;
				// ��Ϊ���������ƶ��������߽ڻ滭������Ϊ00 �ȴ�������
				snactuali[node - 1] = -1;
				snactualj[node - 1] = -1;
				score += GsnMainGameConstants.SNAKEEATFOODADDSCORE;
				currlevelscore += GsnMainGameConstants.SNAKEEATFOODADDSCORE;
				addScore(score, 1);
				addSpeed();
				// ����Ϸ������ �����ж��Ƿ����
				gsnmgjpanel.giveGamePanleScore();
				gsnmgjpanel.passLevel();
				return;
			}
		}
	}
	// �߳��ƶ� 
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(controlStart){
			System.out.print("");// Ҫ�����Ȼ�����
			if(isRun){
				try {
					Thread.sleep(snspeed);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(isRun){
					move();
					isfinishcurState = true;// �Ѿ���ɵ�ǰת�壬���Լ�����һ��ת����
					RunWay();
					// �ŵ�����Ϸ����ж���
					// ��������ײ ֻ��Ҫһ������ײ��� �����˰� 
//					if(playertag == 1 && (GsnMainGameConstants.gamemode == 2 || GsnMainGameConstants.gamemode == 3)){
//						gsnmgjpanel.checkCCAnother();
//					}
				}
			}
		}
//		System.out.println("��ֹͣ������������������������");
	}
	// �ƶ���ʱ�����������
	public void RunWay(){
		// �Ƿ��������ϰ� �����߶�Ҫ 
		collisionCheck();
		// �Ƿ������˴�Խ�ڵ�
		isCollCrossNode();
		if(gsnmgjpanel != null){
			eatFood();// ��
		}
	}
}

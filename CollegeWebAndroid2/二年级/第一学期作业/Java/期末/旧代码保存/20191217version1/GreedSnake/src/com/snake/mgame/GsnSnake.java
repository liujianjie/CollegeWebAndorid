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
	// 属性
	public GsnMapSnakeBean gsnmapsankebean;
	
	// 新的属性
	public long snspeed;// 速度
	public boolean controlStart;//控制开始
	public boolean isRun;// 是否继续
	public int N;// 蛇节
	// 游戏中拥有的蛇节数量和坐标
	public int snactuali[];// 0是蛇头的i
	public int snactualj[];// 0是舌头的j
	public int node;// 游戏的蛇节
	public int direction;//0123 上下左右 游戏的方向
//	public int headcurri,headcurrj;
	public boolean isfinishcurState;// 是否完成当前的指令
	public int score;// 分数
	public int currlevelscore;// 当前关卡分数
	public int playertag;// 标识 是玩家1 还是 玩家2
	
	GsnEditMapMainGameAreaJPanel gsneditmapmainareainter;
	GsnMainGameJPanel gsnmgjpanel;
	
	public int tag;// 1是在编基地图中，0是面板中
	
	// clone
	public GsnSnake(GsnSnake gs){
		snactuali = gs.snactuali.clone();
		snactualj = gs.snactualj.clone();
		
	}
	// 初始化信息
	public GsnSnake(GsnEditMapMainGameAreaJPanel gsneditmapmainareainter,int playertag){
		// 玩家信息
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
		isfinishcurState = false;// 是否完成当前的指令
	}
	// 清空分
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
		// 玩家信息
		this.playertag = playertag;
		this.gsnmgjpanel = gsnmgjpanel;
		N = 500;
		snactuali = new int[N];
		snactualj = new int[N];
		controlStart = true;
		snspeed = GsnMainGameConstants.SnakeMoveSpeedMax;
	}
	
	// 修改地图时候数字定位
//	public void initOfNumber(int n, int d, int i, int j){
//		score = 0;
//		isRun = false;
//		snspeed = GsnMainGameConstants.SnakeMoveSpeedMax;
//		isfinishcurState = false;// 是否完成当前的指令
//		
//		// 默认信息 万一地图没有初始信息
//		node = n;
//		direction = d;
//		snactuali[0] = i;
//		snactualj[0] = j;
//	}
	// 初始位置信息 不包含 node 游戏中的蛇节由游戏决定
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
		// 速度也要初始把
		snspeed = GsnMainGameConstants.SnakeMoveSpeedMax;
		// 从地图上给予当前
		InitPosFromSnakeBean(gsnmapsankebean);
		// 如果为空 只有自己设置了
		if(gmb.snnode == 0){
			gsnmapsankebean = new GsnMapSnakeBean(2, 1, 3, 5, 2, 5);
//			initForEditMap(2, 1, 3, 5, 2, 5);
//			gsnsnake[0].initForEditMap(2, 1, 3, 5, 2, 5);
//			gsnsnake[1].initForEditMap(2, 0, 37, 55, 38, 55);// 当地图上没有蛇信息只有自己初始化了
		}
	}
	// 过关时候 蛇节保存
	public void PassLevelReStart(GsnMapSnakeBean gmb){
		addScore(score ,0);
		gsnmapsankebean = gmb;
		// 从地图上给予当前
		InitPosFromSnakeBean(gsnmapsankebean);
		// 除了2个蛇节外 其它蛇节 也为第2节蛇节位置
		for(int i = 2; i < node ;i++){
			snactuali[i] = snactuali[1];
			snactualj[i] = snactualj[1];
		}
	}
	// 将数据清空
	public void setScoreZero(){
		score = 0;
		currlevelscore = 0;
	}
	// 重生
	public void relive(){
		// 蛇初始位置
		InitPosFromSnakeBean(gsnmapsankebean);
	}
	// 开始线程
	public void startMove(){
		isRun = true;// 开始线程
	}
	public void endMove(){// 失败 或者 调用其它面板
		isRun = false;
	}
	public void endThread(){// 退出
		controlStart = false;
		isRun = false;
//		stop();
	}
	public void move(){
		// 前一节蛇节赋予下一节蛇节
		for(int i = node - 1; i > 0; i--){
			snactuali[i] = snactuali[i - 1];
			snactualj[i] = snactualj[i - 1];
		}
		// 重置蛇头
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
		// 是否碰到了穿越节点
//		isCollCrossNode();
//		CalHeadXY();
	}
	// 计算蛇头的坐标 无意义
	public void CalHeadXY(){
//		snactuali[0] = headcurri;
//		snactualj[0] = headcurrj;
//		headcurri = snactuali[0];
//		headcurrj = snactualj[0];
	}
	// 边界检测，是否越过边界 并且修改蛇头位置 
	public void touchBoundary(){
		// 上下 0~40
		if(snactuali[0] >= 41){// 检测超过边界就要加1
			snactuali[0] = 0;
		}else if(snactuali[0] < 0){// 要穿过 0 
			snactuali[0] = 40;//  
		}
		// 左右0~59
		if(snactualj[0] >= 60){// 检测超过边界就要加1
			snactualj[0] = 0;
		}else if(snactualj[0] < 0){// 要穿过 0 
			snactualj[0] = 59;// 
		}
	}
	// 碰撞检测 自己咬自己 遇到玩家 撞墙
	public boolean checkComeCrossWar(){// 碰墙
		// 要区别是哪个 是中心面板游戏 还是 编辑地图预览 设置了dynadata 不用了
		// 每个蛇节都得检测
		for(int i = 0; i < node; i++){
			if(GsnMainGameConstants.dynamicmapdata[snactuali[i]][snactualj[i]] == 1 ||
					GsnMainGameConstants.dynamicmapdata[snactuali[i]][snactualj[i]] == 56){// 是移动障碍
				return true;
			}
		}
		return false;
	}
	// 自己咬到自己
	public boolean bitSelf(){
		for(int i = 1; i < node; i++ ){
			if(snactuali[i] == snactuali[0] && snactualj[i] == snactualj[0]){
				node = i;// 被咬后的蛇节不要了，为了模式2 模式3 模式1直接跳转
				return true;
			}
		}
		return false;
	}
	public void collisionCheck(){
		boolean penqiang = checkComeCrossWar();
		boolean bitselfbln = bitSelf();
		
		// 如果是编辑地图预览就简单的重生 速度也减
		if(gsneditmapmainareainter != null){
			if(penqiang || bitselfbln){
				relive();
				cutHalfOfNode();
				return;// 不进行下去了
			}
		}
		
		// 模式1 为游戏结束
		if(GsnMainGameConstants.gamemode == 1){
			if(penqiang || bitselfbln){
				// 停止 线程  食物 障碍物
				gsnmgjpanel.endThread();
				// 设置结束话语
				gsnmgjpanel.SetSingleDeadResultPanel(1);
				if(score == 0 && playertag == 1){
					GsnBottomLayerInterface.gameResultAndScoreJpanel.jin();
				}
				setScoreZero();
				// 调用结束面板 不要存在栈中
				GsnBottomLayerInterface.updateJPanelNotSave(GsnBottomLayerInterface.gameCenterJpanel,GsnBottomLayerInterface.gameResultAndScoreJpanel);
				GsnBottomLayerInterface.gameResultAndScoreJpanel.requestFocus();
				// 给监听
				GsnBottomLayerInterface.gameResultAndScoreJpanel.inputnamejf.requestFocus();

				// 碰撞到了 就更新画面 
				gsnmgjpanel.repaint();
			}
		}
		// 模式2 为重新复活，分数减，蛇节减
		if(GsnMainGameConstants.gamemode == 2){
			if(penqiang){// 碰墙复活 
				// 先计算蛇节这些
				relive();
				cutHalfOfNode();
				cutDownScore();
				cutSpeed();
				// 碰撞到了 就更新画面 
				gsnmgjpanel.repaint();
			}
			if(bitselfbln){// 咬自己减分 减速 减蛇节
				// 
				cutDownScore();
				cutSpeed();
				// 碰撞到了 就更新画面 
				gsnmgjpanel.repaint();
			}
//			System.out.println("减少分数 减少蛇节 重新赋予初始位置");
		}
		// 模式3 为重新复活，分数减，蛇节减
		if(GsnMainGameConstants.gamemode == 3){
			if(penqiang){// 碰墙复活 
				relive();
				cutHalfOfNode();
				cutDownScore();
				cutSpeed();
				// 碰撞到了 就更新画面 
				gsnmgjpanel.repaint();
			}
			if(bitselfbln){// 咬自己减分 减速 减蛇节
				cutDownScore();
				cutSpeed();
				// 碰撞到了 就更新画面 
				gsnmgjpanel.repaint();
			}
//			System.out.println("减少分数 减少蛇节 重新赋予初始位置");
		}
	}
	
	// 绘画
	public void draw(Graphics g){
//		Color c = g.getColor();
//		g.setColor(Color.black);
//		g.fillRect(snactualj[0] * GsnMainGameConstants.drawSize,snactuali[0] * GsnMainGameConstants.drawSize, GsnMainGameConstants.drawSize, GsnMainGameConstants.drawSize);// 要反，因为x,y
//		g.setColor(c);
		for(int i = 0; i < node; i++){
			g.fillRect(snactualj[i] * GsnMainGameConstants.drawSize,snactuali[i] * GsnMainGameConstants.drawSize, GsnMainGameConstants.drawSize, GsnMainGameConstants.drawSize);// 要反，因为x,y
//			System.out.println(snactuali[i]+" "+snactualj[i]);
		}
	}
	
	// add score加分 ,tage 0 减分或者重置，1加分
	public void addScore(int sc, int tag){
		GsnBottomLayerInterface.gameCenterJpanel.gsnmaingamescroeJpanel.changeScore(playertag, sc, tag);
	}
	// 减分 奇数先减10 再扣 一半  偶数扣一半
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
	// 减蛇节
	public void cutDownNode(){
		if(node > 2){
			node--;
		}
	}
	// 减一半蛇节 奇数 减-1 /2 偶数 /2
	public void cutHalfOfNode(){
		// 原本node
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
			// 给后面的节点为-1
			for(int i = node; i < yuannode; i++){
				snactuali[i] = -1;
				snactualj[i] = -1;
			}
		}
		if(node < 2){
			node = 2;
		}
	}
	// 加速度
	public void addSpeed(){
		// 单人模式下 速度更慢
		if(GsnMainGameConstants.gamemode == 1){
			// 小于最小速度就不减了
			if(snspeed - GsnMainGameConstants.SnakeChangeSpeedUp  < GsnMainGameConstants.SnakeSinMoveSpeedMin){
				snspeed = GsnMainGameConstants.SnakeSinMoveSpeedMin;
			}else{
				snspeed -= GsnMainGameConstants.SnakeChangeSpeedUp;
			}
		}else{
			// 小于最小速度就不减了
			if(snspeed - GsnMainGameConstants.SnakeChangeSpeedUp  < GsnMainGameConstants.SnakeMoveSpeedMin){
				snspeed = GsnMainGameConstants.SnakeMoveSpeedMin;
			}else{
				snspeed -= GsnMainGameConstants.SnakeChangeSpeedUp;
			}
		}
	}
	// 减速度
	public void cutSpeed(){
		// 减一半速度
		if(snspeed + GsnMainGameConstants.SnakeChangeSpeedCut < GsnMainGameConstants.SnakeMoveSpeedMax){
			snspeed += GsnMainGameConstants.SnakeChangeSpeedCut;
		}else{// 挂满 。。。有点过。。
			snspeed = GsnMainGameConstants.SnakeMoveSpeedMax;
		}
	}
	public void isCollCrossNode(){
		GsnMapCrossNodeBean cs;
		if(gsnmgjpanel != null){
			for(int i = 0; i < gsnmgjpanel.crossnodelength; i++){
				cs = gsnmgjpanel.gsnmgmcrossnodelis.get(i).gsncnbean;
				// 两个节点
				// 碰到第一个
				if(cs.firstpos[0] == snactuali[0] && cs.firstpos[1] == snactualj[0]){
					snactuali[0] = cs.secondpos[0];
					snactualj[0] = cs.secondpos[1];
					return;
				}
				// 碰到第二个
				if(cs.secondpos[0] == snactuali[0] && cs.secondpos[1] == snactualj[0]){
					snactuali[0] = cs.firstpos[0];
					snactualj[0] = cs.firstpos[1];
					return;
				}
			}
		}else{
			for(int i = 0; i < gsneditmapmainareainter.crossnodelength; i++){
				cs = gsneditmapmainareainter.gsnmgmcrossnodelis.get(i).gsncnbean;
				// 两个节点
				// 碰到第一个
				if(cs.firstpos[0] == snactuali[0] && cs.firstpos[1] == snactualj[0]){
					snactuali[0] = cs.secondpos[0];
					snactualj[0] = cs.secondpos[1];
					return;
				}
				// 碰到第二个
				if(cs.secondpos[0] == snactuali[0] && cs.secondpos[1] == snactualj[0]){
					snactuali[0] = cs.firstpos[0];
					snactualj[0] = cs.firstpos[1];
					return;
				}
			}
		}
	}
	public void eatFood(){
		// 蛇外层
		for(int i = 0; i < gsnmgjpanel.MainGamefoodlength; i++){
			if(gsnmgjpanel.gsnfood[i].curi == snactuali[0] && gsnmgjpanel.gsnfood[i].curj == snactualj[0]){
				// 食物重新生成
				gsnmgjpanel.gsnfood[i].deadUpdate();
				node++;
				// 因为先休眠再移动，最后的蛇节绘画的坐标为00 先处理这样
				snactuali[node - 1] = -1;
				snactualj[node - 1] = -1;
				score += GsnMainGameConstants.SNAKEEATFOODADDSCORE;
				currlevelscore += GsnMainGameConstants.SNAKEEATFOODADDSCORE;
				addScore(score, 1);
				addSpeed();
				// 给游戏面板分数 并且判断是否过关
				gsnmgjpanel.giveGamePanleScore();
				gsnmgjpanel.passLevel();
				return;
			}
		}
	}
	// 线程移动 
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(controlStart){
			System.out.print("");// 要输出不然会挂起
			if(isRun){
				try {
					Thread.sleep(snspeed);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(isRun){
					move();
					isfinishcurState = true;// 已经完成当前转体，可以继续下一个转体了
					RunWay();
					// 放到了游戏面板判断了
					// 两条蛇相撞 只需要一条蛇碰撞检测 就行了吧 
//					if(playertag == 1 && (GsnMainGameConstants.gamemode == 2 || GsnMainGameConstants.gamemode == 3)){
//						gsnmgjpanel.checkCCAnother();
//					}
				}
			}
		}
//		System.out.println("蛇停止！！！！！！！！！！！！");
	}
	// 移动的时候遇到的情况
	public void RunWay(){
		// 是否碰到了障碍 两条蛇都要 
		collisionCheck();
		// 是否遇到了穿越节点
		isCollCrossNode();
		if(gsnmgjpanel != null){
			eatFood();// 吃
		}
	}
}

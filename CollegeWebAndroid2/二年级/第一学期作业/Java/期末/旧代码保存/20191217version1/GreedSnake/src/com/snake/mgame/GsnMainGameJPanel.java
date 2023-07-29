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

// 主要游戏面板，是GsnCenterInterface的子面板
public class GsnMainGameJPanel extends JPanel{
	public boolean controlRun = true;
	public boolean startlevel;
	
	// 默认2条蛇
	GsnSnake gsnsnake[];
	// 食物，可以多一点
	public int MainGamefoodlength;// 控制食物出现数量，更新关卡的时候才绘画
	public GsnFood gsnfood[];
	// 是否运行，一开始为预览
	boolean isPlay;
	
	// 用列表试试
	public List<GsnMainGameMoveBarrier> gsnmgmbarlis;
	public int MainGameMoveBarrierlength;// 障碍物长度
	
	// 穿越节点列表
	public List<GsnCrossNodeDraw> gsnmgmcrossnodelis;
	int crossnodelength;// 
	
	// AI
	GsnSnakeComputerPlayer snakeAi[];
	
	public GsnMainGameJPanel(){
		firststart();// 先初始化蛇
		initAiSnake();
		// 线程
		MyThread my = new MyThread();
		my.start();
		this.setBackground(Color.WHITE);
		// width和height需要加1因为 绘画的矩形占像素
		this.setSize(new Dimension(GsnInterfaceParam.GAMEIWIDTH + 1,GsnInterfaceParam.GAMEIHEIGHT + 1));
		// 监听事件
		this.addKeyListener(new GsnMainGameKeyLis());
		isPlay = false;
	}
	// Ai蛇 不属于预览部分，当游戏模式为3 的时候运行 
	public void initAiSnake(){
		snakeAi = new GsnSnakeComputerPlayer[2];
		for(int i = 0 ; i < snakeAi.length; i++){
			// 给予蛇初始信息
			snakeAi[i] = new GsnSnakeComputerPlayer(gsnsnake[i],this);
		}
		
	}
	// 设置大小
	public void setnewSize(int width, int height){
		this.setSize(new Dimension(width, height));
		this.repaint();
	}
	// 给予空间
	public void firststart(){
		gsnsnake = new GsnSnake[2];
		for(int i = 0 ; i < gsnsnake.length; i++){
			// 给予蛇初始信息
			gsnsnake[i] = new GsnSnake(this,i + 1);
			gsnsnake[i].start();// 启动线程
		}
	}
	// 初始化 地图 和 蛇的信息
	public void initGame(){
		// 地图 信息
		for(int m = 0; m < 41; m++){
			// 深拷贝 
			GsnMainGameConstants.dynamicmapdata[m] = (GsnMainGameConstants.gsngamemap[GsnMainGameConstants.currLevel - 1].mapdata[m]).clone();
			GsnMainGameConstants.yuanshimapdata[m] = (GsnMainGameConstants.gsngamemap[GsnMainGameConstants.currLevel - 1].mapdata[m]).clone();
		}
		snakeBean();
	}
	public void snakeBean(){
		// 蛇的地图信息 还是浅拷贝 主要是初始位置的数组麻烦
		for(int i = 0; i < 2; i++){
			GsnMainGameConstants.yuanshisnakebean[i] = new GsnMapSnakeBean();
			GsnMainGameConstants.dynamicsnakebean[i] = new GsnMapSnakeBean();
		}
		// 初始化位置
		GsnMainGameConstants.yuanshisnakebean = GsnMainGameConstants.gsngamemap[GsnMainGameConstants.currLevel - 1].gsmsnakebean.clone();
		GsnMainGameConstants.dynamicsnakebean = GsnMainGameConstants.gsngamemap[GsnMainGameConstants.currLevel - 1].gsmsnakebean.clone();
	}
	// 启动的时候
	public void initSnakeInfo(){
		// 重新给予蛇的初始位置
		for(int i = 0 ; i < gsnsnake.length; i++){
			gsnsnake[i].ReStart(GsnMainGameConstants.yuanshisnakebean[i]);
		}
	}
	// 
	public void PassLevelinitSnakeInfo(int back){
		// 重新给予蛇的初始位置
		for(int i = 0 ; i < gsnsnake.length; i++){
			gsnsnake[i].PassLevelReStart(GsnMainGameConstants.yuanshisnakebean[i]);
			if(back == 1){
				gsnsnake[i].score = 0;
			}
		}
	}
	public void initFoodInfo(){
		// 出现多少食物 因为每个地图食物不一样
		MainGamefoodlength = GsnMainGameConstants.gsngamemap[GsnMainGameConstants.currLevel - 1].gsmfoodbean.foodlength;
		// 不知道每次打开关卡就创建线程对象并启动会不会造成很多内存占用！！！！！！！！！！！！！！！！！！！！
		gsnfood = new GsnFood[MainGamefoodlength];
		for(int i = 0 ; i < gsnfood.length; i++){
			gsnfood[i] = new GsnFood();
			gsnfood[i].start();
			gsnfood[i].deadUpdate();// 创建食物 因为等地图出来的时候才能判断是否出现在障碍物中。
		}
	}
	public void initBarInfo(){
		// 获取地图有多少障碍物
		MainGameMoveBarrierlength = GsnMainGameConstants.gsngamemap[GsnMainGameConstants.currLevel - 1].gsminfobean.barcount;
		gsnmgmbarlis = new ArrayList<GsnMainGameMoveBarrier>(MainGameMoveBarrierlength);
		for(int i = 0 ; i < MainGameMoveBarrierlength; i++){
			GsnMainGameMoveBarrier gsnmgmb = new GsnMainGameMoveBarrier();
			gsnmgmb.init(GsnMainGameConstants.gsngamemap[GsnMainGameConstants.currLevel - 1].gsmbmbean[i]);
			gsnmgmb.start();
			gsnmgmbarlis.add(gsnmgmb);
		}
	}
	// 设置穿越节点start--------------
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
		// 重新转载关卡
		initGame();
		// 蛇初始位置
		initSnakeInfo();
		// 食物
		initFoodInfo();
		// 障碍物
		initBarInfo();
		// 穿越
		initCrossNodeList();
		// AI状态
//		clearAiData();
	}
	// 预览关卡 或者 刚打开关卡的时候 不要启动线程就行
	public void Preview(){
		commonWayOfStartAndView();
		this.repaint();
	}
	// 直接运行
	public void restart(){
		// 
		snakeBean();
		// 蛇初始位置
		PassLevelinitSnakeInfo(0);
		// 食物
		initFoodInfo();
		// 障碍物
		initBarInfo();
		initCrossNodeList();
		startDraw();
		// AI状态
		clearAiData();
		this.repaint();
	}
	public void startDraw(){
		gsnsnake[0].startMove();
		if(GsnMainGameConstants.gamemode == 2 ){
			gsnsnake[1].startMove();// 模式2  才开始
			snakeAi[1].stopRun();// 电脑停止
		}
		for(int i = 0 ; i < MainGamefoodlength; i++){
			gsnfood[i].startUpdate();// 开始更新
		}
		for(int i = 0 ; i < MainGameMoveBarrierlength; i++){
			gsnmgmbarlis.get(i).startMove();
		}
		// 判断是否模式3
		if(GsnMainGameConstants.gamemode == 3){
			gsnsnake[1].endMove();// 玩家停止  
			// 启动 先第二条
			snakeAi[1].startRun();
		}
	}
	public void endDraw(){
		for(int i = 0 ; i < gsnsnake.length; i++){
			gsnsnake[i].endMove();
		}
		for(int i = 0 ; i < MainGamefoodlength; i++){
			gsnfood[i].endUpdate();// 开始更新
		}
		for(int i = 0 ; i < MainGameMoveBarrierlength; i++){
			gsnmgmbarlis.get(i).endMove();
		}
		// 判断是否模式3
		if(GsnMainGameConstants.gamemode == 3){
			// 启动 先第二条
			snakeAi[1].stopRun();
		}
	}
	// 结束线程
	public void endThread(){
		// 蛇的线程不要结束 因为重新选关卡没有给予新的对象 只停止就可以
		for(int i = 0 ; i < gsnsnake.length; i++){
			gsnsnake[i].endMove();
		}
		for(int i = 0 ; i < MainGamefoodlength; i++){
			gsnfood[i].endThread();
		}
		for(int i = 0 ; i < MainGameMoveBarrierlength; i++){
			gsnmgmbarlis.get(i).endThread();
		}
		// 判断是否模式3
		if(GsnMainGameConstants.gamemode == 3){
			// 启动 先第二条
			snakeAi[1].stopRun();
		}
	}
	// 游戏相关动作------------
	// 两条蛇相撞 蛇头相撞3 蛇2咬蛇1 return1 ，蛇1咬蛇2 return2，没有撞 0
	public void checkCCAnother(){
		// 两头撞到
		if(gsnsnake[0].snactuali[0] == gsnsnake[1].snactuali[0] &&
				gsnsnake[0].snactualj[0] == gsnsnake[1].snactualj[0]){
			
			// 减节
			gsnsnake[0].cutHalfOfNode();
			gsnsnake[1].cutHalfOfNode();
			// 减分
			gsnsnake[0].cutDownScore();
			gsnsnake[1].cutDownScore();
			// 复活
			gsnsnake[0].relive();
			gsnsnake[1].relive();
			
			gsnsnake[0].cutSpeed();
			gsnsnake[1].cutSpeed();
		}
		// 换2开始 不然 1条蛇节很难看
		for(int i = 2; i < gsnsnake[0].node; i++){
			if(gsnsnake[0].snactuali[i] == gsnsnake[1].snactuali[0] &&
					gsnsnake[0].snactualj[i] == gsnsnake[1].snactualj[0]){
				// 蛇2的蛇头咬到蛇1的身子1
				// 减节
				gsnsnake[0].node = i;
				// 减分
				gsnsnake[0].cutDownScore();
				gsnsnake[0].cutSpeed();
				// 将被咬的蛇节为-1，不绘制
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
				// 蛇1的蛇头咬到蛇2的身子2
				// 减节
				gsnsnake[1].node = i;
				// 减分
				gsnsnake[1].cutDownScore();
				gsnsnake[1].cutSpeed();
				// 将被咬的蛇节为-1，不绘制
				for(;i < gsnsnake[1].node; i++){
					gsnsnake[1].snactuali[i] = -1;
					gsnsnake[1].snactualj[i] = -1;
				}
				break;
			}
		}
		// 更新
		this.repaint();
	}
	// 分数情况
	public void delScore(){
		for(int i = 0 ; i < gsnsnake.length; i++){
			gsnsnake[i].delScore();
		}
	}
	
	// 游戏相关动作-----
	// 键盘监听 
	class GsnMainGameKeyLis extends KeyAdapter{
		private int keycode;//
		// 对于操纵蛇，应该是按下就改变，不要等松手在改变 更顺手
		@Override
		public void keyPressed(KeyEvent e) {
			if(isPlay){
				keycode = e.getKeyCode();
				// 第一条蛇
				if(gsnsnake[0].isfinishcurState){
					if(keycode == KeyEvent.VK_1){
						System.out.println("GsnMainGameKeyLis按下1键");
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
				
				// 第二条蛇
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
				// 停止 移动吧线程  食物 障碍物
				// 将分数清空
				endThread();
				// 模式3 到结果
				if(GsnMainGameConstants.gamemode == 3){
					SetResultPanel();
					// 调用结束面板 不要存在栈中
					GsnBottomLayerInterface.updateJPanelNotSave(GsnBottomLayerInterface.gameCenterJpanel,GsnBottomLayerInterface.gameResultAndScoreJpanel);
					GsnBottomLayerInterface.gameResultAndScoreJpanel.requestFocus();
					// 给监听
					GsnBottomLayerInterface.gameResultAndScoreJpanel.inputnamejf.requestFocus();
				}else{
					// 要把 绘画大小 设置回来 5 为了预览关卡
					GsnMainGameConstants.setDrawSize(5);
					// 选择关卡
					GsnBottomLayerInterface.gameLevelJpanel.backSetSelctAndView(0);
					GsnBottomLayerInterface.backLastJPanel();
					System.out.println("GsnMainGameKeyLis按下VK_ESCAPE键");
				}
				delScore();
			}else if(keycode == KeyEvent.VK_ENTER){// 开始 或者 暂停
//				System.out.println("GsnMainGameKeyLis按下VK_ENTER键");
				if(!isPlay){// 不在运行 就开始
					startDraw();
					isPlay = true;
				}else{// 在运行，就暂停
					endDraw();
					isPlay = false;
				}
			}
		}
	}
	// ai初始状态
	public void clearAiData(){
		for(int i = 0; i < snakeAi.length; i++){
			snakeAi[i].cleardata();
		}
	}
	// 绘画
	@Override
	public void paint(Graphics g) {
		// TODO 自动生成的方法存根
		super.paint(g);// 不写这个 就还是上一级的背景
		Color yuan = g.getColor();
		for(int m = 0; m < 41; m++){
			for(int n = 0; n < 60; n++){
				if(GsnMainGameConstants.dynamicmapdata[m][n] == 1){
					g.setColor(Color.DARK_GRAY);
					g.fillRect(n * GsnMainGameConstants.drawSize, m * GsnMainGameConstants.drawSize, GsnMainGameConstants.drawSize, GsnMainGameConstants.drawSize);
				}
			}
		}
		// 穿越节点
		for(int i = 0; i < crossnodelength; i++ ){
			if(gsnmgmcrossnodelis.get(i) != null){// 有点会置为null 不能绘画了
				g.setColor(GsnMainGameConstants.crosscolor[i]);// 已经设置好了
				gsnmgmcrossnodelis.get(i).draw(g);
			}
		}	
		// 绘画关卡时候不用
		if(!startlevel){
			// 绘画食物
			g.setColor(Color.PINK);
			for(int i = 0; i < MainGamefoodlength; i++){
				gsnfood[i].draw(g);
			}
			g.setColor(Color.BLACK);
			// 绘画障碍物
			for(int i = 0; i < MainGameMoveBarrierlength; i++){
				gsnmgmbarlis.get(i).draw(g);
			}
		}
		// 绘画蛇
		g.setColor(Color.RED);
		gsnsnake[0].draw(g);
		// 当模式2 3 的时候不绘制
		if(GsnMainGameConstants.gamemode == 2 || GsnMainGameConstants.gamemode == 3){
			g.setColor(Color.GREEN);
			gsnsnake[1].draw(g);
		}
		g.setColor(yuan);
		GsnMainGameJPanel.this.repaint();
		
		// 两条蛇相撞 只需要一条蛇碰撞检测 就行了吧 
		// 20191130把碰撞和吃食物的代码放在这里不知道好不好
		if(GsnMainGameConstants.gamemode == 2 || GsnMainGameConstants.gamemode == 3){
//			checkCCAnother();
		}
	}
	
	// 通关代码
	int gamescore;//统计当前关卡得了多少分
	public void giveGamePanleScore(){
		// 单人模式查看
		if(gsnsnake[0].currlevelscore > gsnsnake[1].currlevelscore){
			gamescore = gsnsnake[0].currlevelscore;
		}else{
			gamescore = gsnsnake[1].currlevelscore;
		}
	}
	// 过关 重新启动 重设蛇 重设关卡 重设食物
	public void passLevel(){
		// 检测是否过关
		if(gamescore >= GsnMainGameConstants.PASSLEVELNEEDSCORE){
			// 重设分
			gamescore = 0;
			gsnsnake[0].currlevelscore = 0;
			gsnsnake[1].currlevelscore = 0;
			
			// 关卡加1
			if(GsnMainGameConstants.currLevel + 1 <= GsnMainGameConstants.gsngamemap.length){
				GsnMainGameConstants.currLevel = GsnMainGameConstants.currLevel + 1;
				// 先停止
				endThread();
				// 开启线程
				startLevel();
				// 
//				restart();
			}else{
				// 停止 移动吧线程  食物 障碍物
				endThread();
				if(GsnMainGameConstants.gamemode != 1){
					SetResultPanel();
				}else{// 通关1
					SetSingleDeadResultPanel(0);
				}
				// 清空分数
				gsnsnake[0].setScoreZero();
				gsnsnake[1].setScoreZero();
				// 调用结束面板 不要存在栈中
				GsnBottomLayerInterface.updateJPanelNotSave(GsnBottomLayerInterface.gameCenterJpanel,GsnBottomLayerInterface.gameResultAndScoreJpanel);
				GsnBottomLayerInterface.gameResultAndScoreJpanel.requestFocus();
				// 给监听
				GsnBottomLayerInterface.gameResultAndScoreJpanel.inputnamejf.requestFocus();
			}
		}
	}
	// 过关的通用设置结果面板
	public void SetResultPanel(){
		// 通关，设置分数面板
		String s1 = "CONGRATULATIONS", s2 = "WINNER:PLAYER1 SCORE:"+gsnsnake[0].score;
		if(GsnMainGameConstants.gamemode == 2){
			if(gsnsnake[0].score < gsnsnake[1].score){
				s2 = "WINNER:PLAYER2 SCORE:"+gsnsnake[1].score;
			}
		}else if(GsnMainGameConstants.gamemode == 3){
			if(gsnsnake[0].score < snakeAi[1].gsnake.score){
				s1 = "Unfortunately";
				s2 = "WINNER:COMPUTER SCORE:"+gsnsnake[1].score;
				// 模式3 如果电脑胜利 禁
				GsnBottomLayerInterface.gameResultAndScoreJpanel.jin();
			}
		}
		if(gsnsnake[0].score == gsnsnake[1].score){
			s1 = "It ends in a draw";
			s2 = "SCORE:"+gsnsnake[0].score;
			// 平局
			GsnBottomLayerInterface.gameResultAndScoreJpanel.jin();
		}
		GsnBottomLayerInterface.gameResultAndScoreJpanel.setResultString(s1, s2);
	}
	//单人模式死亡
	public void SetSingleDeadResultPanel(int dead){// 1死亡
		// 通关，设置分数面板
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
	// 为了延迟刷新面板的线程
	class MyThread extends Thread{
		@Override
		public void run() {
			while(controlRun){
				System.out.print("");
				if(startlevel){
					// 地图 信息
					// 从左往右
					for(int n = 0; n < 60; n++){
						try {
							Thread.sleep(25);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						for(int m = 0; m < 41; m++){
							// 深拷贝 
							GsnMainGameConstants.dynamicmapdata[m][n] = (GsnMainGameConstants.gsngamemap[GsnMainGameConstants.currLevel - 1].mapdata[m][n]);
							GsnMainGameConstants.yuanshimapdata[m][n] = (GsnMainGameConstants.gsngamemap[GsnMainGameConstants.currLevel - 1].mapdata[m][n]);
							// 让后面一列为墙
							if(n + 2 < 60){
								GsnMainGameConstants.dynamicmapdata[m][n + 2] = 1;
							}
						}
						// 拷贝一次 刷新一次
						GsnMainGameJPanel.this.repaint();
					}
					// 再重新开启
					// 停止先前的线程
					restart();
					// 并且结束线程 必须在后面！！！
					startlevel = false;
				}
			}
		}
	}
}

package com.snake.computer;

import java.util.ArrayList;
import java.util.List;

import com.snake.mgame.GsnFood;
import com.snake.mgame.GsnMainGameJPanel;
import com.snake.mgame.GsnSnake;
import com.snake.mgameconfig.GsnMainGameConstants;

public class GsnSnakeComputerPlayer {
	// 一直运行
	boolean stillRun = true;
	boolean isRun = false;
	// 当前状态
	int curstate;
	
	// 操纵的蛇
	public GsnSnake gsnake;
	
	// 目标食物
	GsnFood gsngoalfood;
	
	// 面板
	GsnMainGameJPanel gsngamepanel;
	
	// BFs
	GsnSnakeBfs gsnsnakebfs;
	
	int dis[][];// 数组保存步数,就是保存走了哪个地图下标i和j
	int vis[][];// 用来记录map是否走过的数组，因为走过的不要再走，以免循环
	int pre[];// 上一个的i
	int prechar[];// 记录是怎么走的上下左右
	int fourdir[][] = { 
							{-1, 0},
							{1, 0},
							{0, -1},
							{0, 1}};//四个方向的位置行列 计算的值 上 下左右
	int fdir[] = { 0, 1, 2, 3 };// 上下左右顺序寻找，要与上一个对应，并且对应playerdirection的图片
	
	// 用List保存路
	List<Integer> bfslist = new ArrayList<Integer>();
	
	MoveThread m;
	public GsnSnakeComputerPlayer(GsnSnake s, GsnMainGameJPanel gpanel){
		gsnake = s;
		
		gsngamepanel = gpanel;
		curstate = 0;// 默认闲逛
		
		m = new MoveThread();
		m.start();
		
		gsnsnakebfs = new GsnSnakeBfs(this);
		
		// bfs
		dis = new int[100 * 100][2];
		vis = new int[41 + 2][60 + 2];// 放大一点，+2
		pre = new int[100 * 100];
		prechar = new int[100 * 100];
		
		curgoalfood = new CurGoalFood();
		
	}
	// 清楚数据 为了 过关 或者 换关
	public void cleardata(){
		curstate = 0;
		
		// 还有重新计算移动的范围
		gsnsnakebfs.calBarArea();
	}
	// 控制线程
	public void startRun(){
		isRun = true;
	}
	public void stopRun(){
		isRun = false;
	}
	public void endThread(){
		stillRun = false;
		m.stop();
	}
	CurGoalFood curgoalfood;
	// 保存目标食物属性
	class CurGoalFood{
		int curi;
		int curj;
		int curcount;
		public void setValue(GsnFood g){
			curi = g.curi;
			curj = g.curj;
			curcount = g.curCount;
		}
	}
	
	// 需要一个记录当前走了多少步的list，为了制定正确的路线，因为bfs寻找的时候，当前蛇在移动，所以要记录
	
	// 当计算bfs没完成却移动了，就不要找当前的！
	boolean isbfs;
	boolean iscalbfs;
	int bfsmovecount;
	class MoveThread extends Thread{
		@Override
		public void run() {
			try{
				while(stillRun){
					System.out.print("");
					if(isRun){
						if(curstate == 0){// 0是闲逛
							// 最初前方有障碍物换方向，需判断换方向是否还是在危险中
//							xianGuan();
							// 闲逛中发现食物位置,要最接近的 
							boolean isfound = foundIngFoodByDistance();
							if(isfound){
//								System.out.println("发现食物");
								curstate = 1;
								isbfs = true;
							}
						}
						else if(curstate == 1){// 1是发现食物后制定路线
							// 最初前方有障碍物换方向，需判断换方向是否还是在危险中
//							xianGuan();
							// 当前已经在找路线，不用重复
							if(isbfs){
//								System.out.println("bfs开始计算");
								// 情空list 放这里为了bfs快点把。。
								gsnsnakebfs.bfslist.clear();
								gsnsnakebfs.startCal();
								isbfs = false;
								bfsmovecount = 0;
							}
						}
						Thread.sleep(gsnake.snspeed);
						if(isRun){
//							System.out.println("------------初始方向："+gsnake.direction+"----------");
							// 放这里是 当蛇移动下一个位置时bfs计算出来了就直接拿出方向
							if(curstate == 2){// 2是制定好了路线在路上
								// 在bfs的时候 是否计算慢了
								if(bfsmovecount == 0){
									// 1.当没有到达食物位置就继续走，到达食物位置就回状态0 闲逛
									if(gsnsnakebfs.bfslist.size() != 0){
										int yuandir = gsnake.direction;
										gsnake.direction = gsnsnakebfs.bfslist.get(0);// 获取第一个
										gsnsnakebfs.bfslist.remove(0);//再删除
										
										// 为了判断当前方向是否会撞到墙 咬到自己，撞上移动障碍，会的话 重新找过食物
										
										// 很严重问题，我改变了方向就去检测有没有危险，但是蛇却没有实际移动，却去检测改变方向的危险，不行，要回归原本方向再改变方向
										if(dirfromListIsDanger()){// 当前方向是否有危险，主要是bfs没有判断咬到自己的判断，因为太难，就取出来的时候再判断的好
											// 变回
											gsnake.direction = yuandir;
											System.out.println("因为bfs的方向有其它东西，原本方向变回："+yuandir);
//											System.out.println("有障碍物，放弃当前路线！！！！！！！！！");
											// 有危险 并且改变了方向 就重新为寻找食物状态
											curstate = 0;
										}
										// 判断当前目标食物 是否改变位置了，改了就重新找
										if(gsngoalfood.curCount != curgoalfood.curcount){
//											System.out.println("食物换位置了！！！！！！！");
											curstate = 0;
										}
										// 当新出的食物距离更近就放弃当前路径，重新制定
										if(foundNewFoodDistance(gsnsnakebfs.bfslist.size())){
											// 重新制定
//											System.out.println("重新指定新食物 直接1");
											curstate = 1;
											isbfs = true;
										}
									}else{
										curstate = 0;
									}
								}else{
									System.out.println("bfs时移动了!!!!!!!!!!!!!!!!!!!!!!!!!!!");
									curstate = 0;// 重新找过
								}
							}
//							Thread.sleep(10);
							
							if(xianGuan()){
//								System.out.println("无目标时有危险改变了方向，"+gsnake.direction);
								curstate = 0;
							}
//							Thread.sleep(10);
							gsnake.move();// 移动
							// 当移动了却还没计算玩bfs 
							if(iscalbfs){
								bfsmovecount++;
							}
							// 路上遇到的
							gsnake.RunWay();
						}
					}
				}
			}catch(Exception e){
				e.printStackTrace();
				System.out.println();
			}
		}
	}
	// 闲逛得让自己不会撞墙死 咬自己
	public boolean xianGuan(){
		// 根据前方危险调整方向
		// 1.先发现危险
		// 2.找没有危险的方向
		int changepos[] = new int[2];
		switch (gsnake.direction) {
			case 0:
				changepos[0] = gsnake.snactuali[0] - 1;
				changepos[1] = gsnake.snactualj[0];
				changepos = CheckBorderChangePos(changepos[0],changepos[1]);
				if(GsnMainGameConstants.dynamicmapdata[changepos[0]][changepos[1]] == 1 || chagneDirIsBitself(changepos)
						|| GsnMainGameConstants.dynamicmapdata[changepos[0]][changepos[1]] == 56 ||
						gsnsnakebfs.isInMoveBarrierArea(changepos)){// 不要进入障碍物区域
					System.out.println("0有危险");
					FindNotDangerDir(0);	
					return true;// 有危险
				}
			break;
			case 1:
				changepos[0] = gsnake.snactuali[0] + 1;
				changepos[1] = gsnake.snactualj[0];
				changepos = CheckBorderChangePos(changepos[0],changepos[1]);
				if(GsnMainGameConstants.dynamicmapdata[changepos[0]][changepos[1]] == 1|| chagneDirIsBitself(changepos)
						|| GsnMainGameConstants.dynamicmapdata[changepos[0]][changepos[1]] == 56||
						gsnsnakebfs.isInMoveBarrierArea(changepos)){// 不要进入障碍物区域){
					System.out.println("1有危险");
					FindNotDangerDir(1);
					return true;// 有危险
				}
			break;
			case 2:
				changepos[0] = gsnake.snactuali[0];
				changepos[1] = gsnake.snactualj[0] - 1;
				changepos = CheckBorderChangePos(changepos[0],changepos[1]);
				if(GsnMainGameConstants.dynamicmapdata[changepos[0]][changepos[1]] == 1|| chagneDirIsBitself(changepos)
						|| GsnMainGameConstants.dynamicmapdata[changepos[0]][changepos[1]] == 56||
						gsnsnakebfs.isInMoveBarrierArea(changepos)){// 不要进入障碍物区域){
					System.out.println("2有危险");
					FindNotDangerDir(2);	
					return true;// 有危险
				}
			break;
			case 3:
				changepos[0] = gsnake.snactuali[0];
				changepos[1] = gsnake.snactualj[0] + 1;
				changepos = CheckBorderChangePos(changepos[0],changepos[1]);
				if(GsnMainGameConstants.dynamicmapdata[changepos[0]][changepos[1]] == 1|| chagneDirIsBitself(changepos)
						|| GsnMainGameConstants.dynamicmapdata[changepos[0]][changepos[1]] == 56||
						gsnsnakebfs.isInMoveBarrierArea(changepos)){// 不要进入障碍物区域){
					System.out.println("3有危险");
					FindNotDangerDir(3);
					return true;// 
				}
			break;			
		}
		return false;
	}
	// 找没有 危险的方向变化
	public void FindNotDangerDir(int dir){
//		checkCurDirIsWall(dir);
		// 会越界得解决
		int changepos[] = new int[2];
		// 4个方向查找
		for(int i = 0; i < 4; i++){
			if(i != dir){// 当前方向不能继续下去
				// 上不能是下
				if(i == 0 && dir != 1){
					System.out.println("检测0方向");
					changepos[0] = gsnake.snactuali[0] - 1;
					changepos[1] = gsnake.snactualj[0];
					changepos = CheckBorderChangePos(changepos[0],changepos[1]);
					if(GsnMainGameConstants.dynamicmapdata[changepos[0]][changepos[1]] != 1 && !chagneDirIsBitself(changepos)
							&& GsnMainGameConstants.dynamicmapdata[changepos[0]][changepos[1]] != 56 && 
							!gsnsnakebfs.isInMoveBarrierArea(changepos)){
						gsnake.direction = i;
						System.out.println("改变方向"+i);
						return;
					}
				}else if(i == 1&& dir != 0){
					System.out.println("检测1方向");
					changepos[0] = gsnake.snactuali[0] + 1;
					changepos[1] = gsnake.snactualj[0];
					changepos = CheckBorderChangePos(changepos[0],changepos[1]);
					if(GsnMainGameConstants.dynamicmapdata[changepos[0]][changepos[1]] != 1 && !chagneDirIsBitself(changepos)
							&& GsnMainGameConstants.dynamicmapdata[changepos[0]][changepos[1]] != 56&& 
									!gsnsnakebfs.isInMoveBarrierArea(changepos)){
						gsnake.direction = i;	
						System.out.println("改变方向"+i);
						return;
					}
				}else if(i == 2&& dir != 3){
					System.out.println("检测2方向");
					changepos[0] = gsnake.snactuali[0];
					changepos[1] = gsnake.snactualj[0] - 1;
					changepos = CheckBorderChangePos(changepos[0],changepos[1]);
					if(GsnMainGameConstants.dynamicmapdata[changepos[0]][changepos[1]] != 1 && !chagneDirIsBitself(changepos)
							&& GsnMainGameConstants.dynamicmapdata[changepos[0]][changepos[1]] != 56&& 
									!gsnsnakebfs.isInMoveBarrierArea(changepos)){
						gsnake.direction = i;	
						System.out.println("改变方向"+i);
						return;
					}
				}else if(i == 3&& dir != 2){
					System.out.println("检测3方向");
					changepos[0] = gsnake.snactuali[0];
					changepos[1] = gsnake.snactualj[0] + 1;
					changepos = CheckBorderChangePos(changepos[0],changepos[1]);
					if(GsnMainGameConstants.dynamicmapdata[changepos[0]][changepos[1]] != 1 && !chagneDirIsBitself(changepos)
							&& GsnMainGameConstants.dynamicmapdata[changepos[0]][changepos[1]] != 56&& 
									!gsnsnakebfs.isInMoveBarrierArea(changepos)){
						gsnake.direction = i;	
						System.out.println("改变方向"+i);
						return;
					}
				}
			}
		}
	}
	// 从bfs中读取的方向是否有危险
	public boolean dirfromListIsDanger(){
		int changepos[] = new int[2];
		switch (gsnake.direction) {
			case 0:
				changepos[0] = gsnake.snactuali[0] - 1;
				changepos[1] = gsnake.snactualj[0];
				changepos = CheckBorderChangePos(changepos[0],changepos[1]);
//				if(GsnMainGameConstants.dynamicmapdata[changepos[0]][changepos[1]] == 1 || chagneDirIsBitself(changepos)
//						|| GsnMainGameConstants.dynamicmapdata[changepos[0]][changepos[1]] == 56){
				if(chagneDirIsBitself(changepos) || gsnsnakebfs.isInMoveBarrierArea(changepos)){
					System.out.println("bfs0有危险");
					return true;// 有危险
				}
			break;
			case 1:
				changepos[0] = gsnake.snactuali[0] + 1;
				changepos[1] = gsnake.snactualj[0];
				changepos = CheckBorderChangePos(changepos[0],changepos[1]);
//				if(GsnMainGameConstants.dynamicmapdata[changepos[0]][changepos[1]] == 1|| chagneDirIsBitself(changepos)
//						|| GsnMainGameConstants.dynamicmapdata[changepos[0]][changepos[1]] == 56){
					if(chagneDirIsBitself(changepos) || gsnsnakebfs.isInMoveBarrierArea(changepos)){
					System.out.println("bfs1有危险");
					return true;// 有危险
				}
			break;
			case 2:
				changepos[0] = gsnake.snactuali[0];
				changepos[1] = gsnake.snactualj[0] - 1;
				changepos = CheckBorderChangePos(changepos[0],changepos[1]);
//				if(GsnMainGameConstants.dynamicmapdata[changepos[0]][changepos[1]] == 1|| chagneDirIsBitself(changepos)
//						|| GsnMainGameConstants.dynamicmapdata[changepos[0]][changepos[1]] == 56){
					if(chagneDirIsBitself(changepos) || gsnsnakebfs.isInMoveBarrierArea(changepos)){
					System.out.println("bfs2有危险");
					return true;// 有危险
				}
			break;
			case 3:
				changepos[0] = gsnake.snactuali[0];
				changepos[1] = gsnake.snactualj[0] + 1;
				changepos = CheckBorderChangePos(changepos[0],changepos[1]);
//				if(GsnMainGameConstants.dynamicmapdata[changepos[0]][changepos[1]] == 1|| chagneDirIsBitself(changepos)
//						|| GsnMainGameConstants.dynamicmapdata[changepos[0]][changepos[1]] == 56){
				if(chagneDirIsBitself(changepos) || gsnsnakebfs.isInMoveBarrierArea(changepos)){
					System.out.println("bfs3有危险");
					return true;// 
				}
			break;			
		}
		return false;
	}
	// 是否越界 返回对应的越界位置
	public int[] CheckBorderChangePos(int i, int j){
		if(i < 0){
			i = 40;
		}
		if(i > 40){
			i = 0;
		}
		if(j < 0){
			j = 59;
		}
		if(j > 59){
			j = 0;
		}
		int shu[] = {i, j};
		return shu;
	}
	// 改变的方向是否会咬到自己 true会咬自己
	public boolean chagneDirIsBitself(int headpos[]){
		for(int i = 1; i < gsnake.node; i++ ){
			// 很严重 很严重 这里竟然 写错 把 headpos[1]写错 headpos[0]
			if(gsnake.snactuali[i] == headpos[0] && gsnake.snactualj[i] == headpos[1]){
//				System.out.println("会咬到自己");
				return true;
			}
		}
		return false;
	}
	// 根据每个食物离自己距离 首排 ij
	public boolean foundIngFoodByDistance(){
		boolean isfound = false;
		int mindist = 1 << 30;
		GsnFood gsnf;
		for(int i = 0; i < gsngamepanel.MainGamefoodlength; i++){
			gsnf = gsngamepanel.gsnfood[i];
			int mid = Math.abs(gsnake.snactuali[0] - gsnf.curi) +  Math.abs(gsnake.snactualj[0] - gsnf.curj);
			if(mindist > mid){
				gsngoalfood = gsnf; // 目标食物
				mindist = mid;
				isfound = true;
				// 设置当前目标食物
				curgoalfood.setValue(gsngoalfood);
			}
		}
		return isfound;
	}
	// 新出食物判断
	public boolean foundNewFoodDistance(int yuanshidis){// 传入当前有多少大小就是距离多远
		boolean isfoundnew = false;
		GsnFood gsnf;
		for(int i = 0; i < gsngamepanel.MainGamefoodlength; i++){
			gsnf = gsngamepanel.gsnfood[i];
			if(gsnf.curi == gsngoalfood.curi && gsnf.curj == gsngoalfood.curj){
				
			}else{
				int mid = Math.abs(gsnake.snactuali[0] - gsnf.curi) +  Math.abs(gsnake.snactualj[0] - gsnf.curj);
				if(yuanshidis > mid){
					yuanshidis = mid;
					isfoundnew = true;
					gsngoalfood = gsnf; // 目标食物
					// 设置当前目标食物
					curgoalfood.setValue(gsngoalfood);
				}
			}
		}
		return isfoundnew;
	}
}

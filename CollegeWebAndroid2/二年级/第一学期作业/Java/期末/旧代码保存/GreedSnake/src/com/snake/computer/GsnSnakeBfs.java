package com.snake.computer;

import java.util.ArrayList;
import java.util.List;

import com.snake.bean.GsnMapCrossNodeBean;
import com.snake.bean.GsnMapSnakeBean;
import com.snake.mgame.GsnCrossNodeDraw;
import com.snake.mgame.GsnFood;
import com.snake.mgame.GsnMainGameMoveBarrier;
import com.snake.mgame.GsnSnake;
import com.snake.mgameconfig.GsnMainGameConstants;

// 电脑的bfs拆开来
public class GsnSnakeBfs {
	// 是否开启线程
	public boolean stillRun = true;
	public boolean isRun = false;
	
	public void startCal(){
		isRun = true;
	}
	public void stopCal(){
		isRun = false;
	}
	// bfs的
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
	
	// 是哪个电脑类的附属
	GsnSnakeComputerPlayer gsncomputer;
	
	CalThread calth;
	public GsnSnakeBfs(GsnSnakeComputerPlayer gsncs){
		gsncomputer = gsncs;
		// bfs
		dis = new int[100 * 50][2];
		vis = new int[41 + 2][60 + 2];// 放大一点，+2
		pre = new int[100 * 100];
		prechar = new int[100 * 100];
		
		calth = new CalThread();
		calth.start();
		
		gsnsnakeandfoodcopy = new curCalSankeAndFood();
	}
	
	List<int[]> barlefttoplist = new ArrayList<int[]>(); 
	List<int[]> barrightbottomlist = new ArrayList<int[]>(); 
	// 计算移动障碍的范围，为了bfs中省时间
	public void calBarArea(){
		// 先清，每次关卡的时候需要
		barlefttoplist.clear();
		barrightbottomlist.clear();
		
		GsnMainGameMoveBarrier gsnm;
		// 计算左上和右下 在这个范围就不要进
		int topleft[] = new int[2];
		int bottomright[] = new int[2];
		for(int i = 0; i < gsncomputer.gsngamepanel.gsnmgmbarlis.size(); i++){
			// 得放在这里新建，不然数组引用，会最后一个为主
			topleft = new int[2];
			bottomright = new int[2];
			gsnm = gsncomputer.gsngamepanel.gsnmgmbarlis.get(i);
			switch (gsnm.gsnmbarbean.bardir) {
				case 0:
					topleft[0] = gsnm.gsnmbarbean.bari - gsnm.gsnmbarbean.barwide;
					topleft[1] = gsnm.gsnmbarbean.barj;
					
					bottomright[0] = gsnm.gsnmbarbean.bari + gsnm.gsnmbarbean.barheight;
					bottomright[1] = gsnm.gsnmbarbean.barj + gsnm.gsnmbarbean.barwidth;
					break;
				case 1:
					topleft[0] = gsnm.gsnmbarbean.bari;
					topleft[1] = gsnm.gsnmbarbean.barj;
					
					bottomright[0] = gsnm.gsnmbarbean.bari + gsnm.gsnmbarbean.barheight + gsnm.gsnmbarbean.barwide;
					bottomright[1] = gsnm.gsnmbarbean.barj + gsnm.gsnmbarbean.barwidth ;
					break;
				case 2:
					topleft[0] = gsnm.gsnmbarbean.bari;
					topleft[1] = gsnm.gsnmbarbean.barj - gsnm.gsnmbarbean.barwide;
					
					bottomright[0] = gsnm.gsnmbarbean.bari + gsnm.gsnmbarbean.barheight;
					bottomright[1] = gsnm.gsnmbarbean.barj + gsnm.gsnmbarbean.barwidth;
					break;
				case 3:
					topleft[0] = gsnm.gsnmbarbean.bari;
					topleft[1] = gsnm.gsnmbarbean.barj;
					
					bottomright[0] = gsnm.gsnmbarbean.bari + gsnm.gsnmbarbean.barheight;
					bottomright[1] = gsnm.gsnmbarbean.barj + gsnm.gsnmbarbean.barwidth  + gsnm.gsnmbarbean.barwide;
					break;				
			}
			barlefttoplist.add(topleft);
			barrightbottomlist.add(bottomright);
		}
	}
	//
	curCalSankeAndFood gsnsnakeandfoodcopy;
	class curCalSankeAndFood{
		int snakedirection;
		int snakeheadi;
		int snakeheadj;
		
		int foodi;
		int foodj;
		int foodcount;// 标记食物的更新多少个
		public void setValue(GsnSnake gs, GsnFood gf){
			snakedirection = gs.direction;
			snakeheadi = gs.snactuali[0];
			snakeheadj = gs.snactualj[0];
			
			foodi = gf.curi;
			foodj = gf.curj;
			foodcount = gf.curCount;
		}
	}
	public boolean bfs() {
		// 开始bfs的时候 给予目标 蛇 和 食物
		gsnsnakeandfoodcopy.setValue(gsncomputer.gsnake, gsncomputer.gsngoalfood);
		// 需要初始值 都没有走过了
		vis = new int[41 + 2][60 + 2];// 放大一点，+2 是新建内存更快，还是循环赋予0更快。。。 新建内存更快吧，因为内存换时间
		int ns[] = new int[2];
		int head = 0;
		int tail = 1;
		// 蛇的位置
		dis[0][0] = gsnsnakeandfoodcopy.snakeheadi;
		dis[0][1] = gsnsnakeandfoodcopy.snakeheadj;
		int x, y, i;
		int xx, yy;// 扩散的步
		
		while (head < tail) {// 找不到了的
			// 越界 找不到
			if(head > dis.length){
				break;
			}
			x = dis[head][0];// 行
			y = dis[head][1];// 列
			
			if(x == gsnsnakeandfoodcopy.foodi && y == gsnsnakeandfoodcopy.foodj){
				print(head);
				return true;
			}
			// 往4个方向扩散
			for (i = 0; i < 4; i++) {
				// 不能倒车，就是当时蛇位置如果是方向0 不能 1 是2 不能3 相反也是,用这个很慢 会减少速度吧？
				if (gsnsnakeandfoodcopy.snakedirection == 0 && i == 1) {
					continue;
				}
				if (gsnsnakeandfoodcopy.snakedirection == 1 && i == 0) {
					continue;
				}
				if (gsnsnakeandfoodcopy.snakedirection == 2 && i == 3) {
					continue;
				}
				if (gsnsnakeandfoodcopy.snakedirection == 3 && i == 2) {
					continue;
				}
				xx = x + fourdir[i][0];
				yy = y + fourdir[i][1];
				// 更换边界值
				if(xx > 40){// 检测超过边界就要加1
					xx = 0;
				}else if(xx < 0){// 要穿过 0 
					xx = 40;//  
				}
				// 左右0~59
				if(yy > 59){// 检测超过边界就要加1
					yy = 0;
				}else if(yy < 0){// 要穿过 0 
					yy = 59;// 
				}
				ns[0] = xx;
				ns[1] = yy;
				// 跟换穿越点值
				checkCrossNode(ns);
				xx = ns[0];
				yy = ns[1];
				
				// 不能咬自己，只是初始状态，不能判断跟随头的迁移而判断。。
				if(chagneDirIsBitself(ns)){
					continue;
				}
				
				// 不要走移动障碍范围
				if(isInMoveBarrierArea(ns)){
					continue;
				}
				
				// 没有走过
				// 不能是墙的位置 就是0平地，后期会变把
				if (vis[xx][yy] == 0 && 
						(GsnMainGameConstants.dynamicmapdata[xx][yy] == 0)
						) {
						// 记录走过，下次是从dis中获取这个xx，yy再4个方向扩散 不能回去x ，y
						vis[xx][yy] = 1;
						// 记录新步数
						dis[tail][0] = xx;
						dis[tail][1] = yy;
						// 书上记录步数 将上一个指针指向head记录是从哪个head扩散的
						pre[tail] = head;
						prechar[tail] = fdir[i];// 记录是上下左右哪个方向
						// 将尾指针上调
						tail++;
				}
			}
			head++;
		}
		return false;
	}
	// 打印记录的方向
	public  void print(int t) {
		int last = pre[t];
		if (last == 0) {// 步数
			bfslist.add(prechar[t]);//			System.out.print(prechar[t]);
			return;
		} else {
			print(last);// 继续
		}
		// 回溯时候存储
		bfslist.add(prechar[t]);//		System.out.print(prechar[t]);
	}
	// 检查边界位置, 越界了就返回false
	public boolean CheckBorder(int xx, int yy){
		return !(xx < 0 || xx > 40 || yy < 0 || yy > 59);
	}
	// 跟换穿越点值
	public void checkCrossNode(int ns[]){
		GsnMapCrossNodeBean cs;
		for(int i = 0; i < gsncomputer.gsngamepanel.gsnmgmcrossnodelis.size(); i++){
			// 不为空
			if(gsncomputer.gsngamepanel.gsnmgmcrossnodelis.get(i) != null){
				//
				cs = gsncomputer.gsngamepanel.gsnmgmcrossnodelis.get(i).gsncnbean;
				// 两个节点
				// 碰到第一个
				if(cs.firstpos[0] == ns[0] && cs.firstpos[1] == ns[1]){
					ns[0] = cs.secondpos[0];
					ns[1] = cs.secondpos[1];
					return;
				}
				// 碰到第二个
				if(cs.secondpos[0] == ns[0] && cs.secondpos[1] == ns[1]){
					ns[0] = cs.firstpos[0];
					ns[1] = cs.firstpos[1];
					return;
				}
			}
		}
	}
	public boolean chagneDirIsBitself(int headpos[]){
		for(int i = 1; i < gsncomputer.gsnake.node; i++ ){
			if(gsncomputer.gsnake.snactuali[i] == headpos[0] && gsncomputer.gsnake.snactualj[i] == headpos[1]){
//				System.out.println("会咬到自己");
				return true;
			}
		}
		return false;
	}
	// 不要路过障碍物范围把，简单的判断 不能实时的
	// 太麻烦了，得判断移动障碍的方向然后得到移动范围，不要进 有点麻烦。用范围也许不错
	public boolean isInMoveBarrierArea(int headpos[]){
		int topleft[] = new int[2];
		int bottomright[] = new int[2];
		for(int i = 0; i < barlefttoplist.size(); i++){
			topleft = barlefttoplist.get(i);
			bottomright = barrightbottomlist.get(i);
			if(topleft[0] <= headpos[0] && topleft[1]  <= headpos[1] &&
					bottomright[0] >= headpos[0] && bottomright[1] >= headpos[1]){
//				System.out.println("在移动范围内 不要去");
				return true;
			}
		}
		return false;
	}
	// 线程计算
	class CalThread extends Thread{
		@Override
		public void run() {
			while(stillRun){
				System.out.print("");
				if(isRun){
					// 再找的时候 为true
					gsncomputer.iscalbfs = true;
					boolean isok = bfs();
					// 找到了
					if(isok){
//						System.out.println("找到路线");
						gsncomputer.curstate = 2;
					}else{
//						System.out.println("没找到路线");
						gsncomputer.curstate = 0;
					}
					isRun = false;// 计算完
					gsncomputer.iscalbfs = false;// 计算完
//					System.out.println("bfs结束计算");
				}
			}
		}
	}
}

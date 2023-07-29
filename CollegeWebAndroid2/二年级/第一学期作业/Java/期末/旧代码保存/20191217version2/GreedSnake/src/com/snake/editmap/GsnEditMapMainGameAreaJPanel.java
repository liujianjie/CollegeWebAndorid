package com.snake.editmap;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.snake.bean.GsnMapBarrierMoveBean;
import com.snake.bean.GsnMapBean;
import com.snake.bean.GsnMapCrossNodeBean;
import com.snake.bean.GsnMapSnakeBean;
import com.snake.config.GsnInterfaceParam;
import com.snake.interfaces.GsnBottomLayerInterface;
import com.snake.mgame.GsnCrossNodeDraw;
import com.snake.mgame.GsnFood;
import com.snake.mgame.GsnMainGameMoveBarrier;
//import com.snake.mgame.GsnMainGameMoveBarrier;
import com.snake.mgame.GsnSnake;
import com.snake.mgameconfig.GsnMainGameConstants;

// 主要游戏面板，是GsnCenterInterface的子面板
public class GsnEditMapMainGameAreaJPanel extends JPanel{
	// 修改地图变量
	public GsnEditmapInterface gsneminter;// 具体实施对象
	
	// 给予jpanel吧
	// 这个只是为了预览的时候作用，其它时候都不用
	GsnSnake gsnsnake[];
	// 食物，可以多一点
	int MainGamefoodlength = 2;// 控制食物出现数量，更新关卡的时候才绘画 默认2个
	public GsnFood gsnfood[];
	// 是否运行，一开始为预览
	boolean isPlay;
	// 是否 重新绘画
	boolean isRepeatPaintBar;
	
	// 障碍物
	// 用列表试试
	List<GsnMainGameMoveBarrier> gsnmgmbarlis;
//	GsnMainGameMoveBarrier2 gsnmgmbar[];
	int MainGameMoveBarrierlength;// 障碍物长度
	
	// 穿越节点列表
	public List<GsnCrossNodeDraw> gsnmgmcrossnodelis;
	public int crossnodelength;// 
	
	// 目前正在绘画的地图
	public byte [][] currmapdata = new byte[41][60];
	public boolean ischoose;// 是否选择了区域
	
	// 绘画定位
	public GsnEditMapOrderLine gsnorderline;
	public boolean startPosLineDraw = false;
	public GsnEditMapMainGameAreaJPanel(GsnEditmapInterface gsneminter){
		this.gsneminter = gsneminter;

		gsnorderline = new GsnEditMapOrderLine(this);
		
		this.setBackground(Color.WHITE);
		
		firststart();
		
		MainGamefoodlength = 2;
		MainGameMoveBarrierlength = 0;
		crossnodelength = 0;
		
		commonWayOfStartAndView();
		
		isPlay = false;
		// width和height需要加1因为 绘画的矩形占像素
		this.setSize(new Dimension(GsnInterfaceParam.GAMEIWIDTH + 1,GsnInterfaceParam.GAMEIHEIGHT + 1));
		// 监听事件
		this.addKeyListener(new GsnMainGameKeyLis());
		// 点击事件 为了预选
		GsnEditMapMainGameMouseLis gsn = new GsnEditMapMainGameMouseLis();
		// 鼠标按键
		this.addMouseListener(gsn);
		// 鼠标移动
		this.addMouseMotionListener(gsn);
		
	}
	public void commonWayOfStartAndView(){
		// 重新转载关卡
		initGame();
		// 蛇初始位置
		setRunSnakePos();
		// 食物
		initFoodInfo();
		// 障碍物
		initBarInfo();
		// 穿越
		initCrossNodeList();
	}
	// 设置大小
	public void setnewSize(int width, int height){
		this.setSize(new Dimension(width, height));
		this.repaint();
	}
	// 清楚蛇原来的位置 为了更新
	public void deleteSnakeYuanZhi(int player){
		for(int j = 0; j < gsnsnake[player].node; j++){
			if(gsneminter.gsneditmapbean.mapdata[gsnsnake[player].snactuali[j]][gsnsnake[player].snactualj[j]] != 0){// 2为player1 3 为palyer2){
				gsneminter.gsneditmapbean.mapdata[gsnsnake[player].snactuali[j]][gsnsnake[player].snactualj[j]] = 0;
			}
		}
	}
	
	// 根据 中心面板蛇的位置 来设置地图值
	public void fromSnakePosSetVal(){
		// 两条
		for(int i = 0; i < gsnsnake.length; i++){
			// 根据蛇节
			for(int j = 0; j < gsnsnake[i].node; j++){
				gsneminter.gsneditmapbean.mapdata[gsneminter.gsneditmapbean.gsmsnakebean[i].snmapi[j]][gsneminter.gsneditmapbean.gsmsnakebean[i].snmapj[j]] = (byte)(i + 2);// 2为player1 3 为palyer2
			}
		}
		// 拷贝一份
		gsneminter.copyOneMapData();
		// 给予curr
		initMapData();
	}
	// 给蛇  为运行时候的初始位置，根据editmap的蛇bean
	public void setRunSnakePos(){
		gsnsnake[0].InitBySnakeBean(gsneminter.gsneditmapbean.gsmsnakebean[0]);
		gsnsnake[1].InitBySnakeBean(gsneminter.gsneditmapbean.gsmsnakebean[1]);
	}
	// 给予蛇空间
	public void firststart(){
		gsnsnake = new GsnSnake[2];
		for(int i = 0 ; i < gsnsnake.length; i++){
			// 给予蛇初始信息
			gsnsnake[i] = new GsnSnake(this,i + 1);
			gsnsnake[i].start();// 启动线程
		}
	}
	// 地图值
	public void initMapData(){
		// 地图 信息
		for(int m = 0; m < 41; m++){
			// 深拷贝
			currmapdata[m] = gsneminter.gsneditmapbean.mapdata[m].clone(); 
		}
	}
	// 初始化 地图 和 蛇的信息
	public void initGame(){
		// 给蛇初始信息
		setRunSnakePos();
		// 地图
		initMapData();
	}
	// 启动的时候
	public void initFoodInfo(){
		// 不知道每次打开关卡就创建线程对象并启动会不会造成很多内存占用！！！！！！！！！！！！！！！！！！！！
		// 给予2 个食物，等待开启时 用maingamefoodelength开启多少个可以运行
		gsnfood = new GsnFood[MainGamefoodlength];
		for(int i = 0 ; i < gsnfood.length; i++){
			gsnfood[i] = new GsnFood();
			gsnfood[i].start();
			gsnfood[i].deadUpdate();// 创建食物 因为等地图出来的时候才能判断是否出现在障碍物中。
		}
	}
	public void initBarInfo(){
		// 创建list而已
		MainGameMoveBarrierlength = gsneminter.gsneditmapbean.gsminfobean.barcount;
		gsnmgmbarlis = new ArrayList<GsnMainGameMoveBarrier>(MainGameMoveBarrierlength);
		for(int i = 0 ; i < MainGameMoveBarrierlength; i++){
			GsnMainGameMoveBarrier gsnmgmb = new GsnMainGameMoveBarrier();
			gsnmgmb.init(gsneminter.gsneditmapbean.gsmbmbean[i]);
			gsnmgmb.start();
			gsnmgmbarlis.add(gsnmgmb);
		}
	}
	// 给list添加一个移动障碍物  设置参数，并且运行
	public void addOneBarTolist(GsnMapBarrierMoveBean bean){
		GsnMainGameMoveBarrier gsnmgmb = new GsnMainGameMoveBarrier();
		gsnmgmb.init(bean);
		gsnmgmb.start();
		gsnmgmbarlis.add(gsnmgmb);
		gsnmgmb.startMove();// 开始移动
	}
	// 根据下标暂停 并且恢复原来位置？
	public void setPauseOrRun(int index, boolean bln){
		// 有时候会删除
		if(gsnmgmbarlis.get(index) != null){
			// 并要回到最初位置
			gsnmgmbarlis.get(index).init(gsnmgmbarlis.get(index).gsnmbarbean);// 自己初始化自己
			gsnmgmbarlis.get(index).isRun = bln;
		}
	}
	// 根据下标来设置颜色 开始 也需要恢复 当取消的时候
	public void setisDrawColorForBar(int index, boolean bln){
		// 有时候会删除
		// 有时候因为上一个是有下标的，但是重新修改的时候再进来。。。所以要初始值 ，这里也判断下吧
		if(index < gsnmgmbarlis.size()){
			if(gsnmgmbarlis.get(index) != null){
				gsnmgmbarlis.get(index).isChoose = bln;
			}
		}
		
	}
	// 根据下标修改
	public void alterOneBarList(GsnMapBarrierMoveBean bean, int index){
		GsnMainGameMoveBarrier gsn = gsnmgmbarlis.get(index);
		// 判断是不是 已经被删除了 是就组成新的
		if(gsn == null){
			gsn = new GsnMainGameMoveBarrier();
			gsnmgmbarlis.remove(index);
			gsn.init(bean);
			gsn.start();
			gsn.startMove();
			// 要设置选中
			gsn.isChoose = true;
			gsnmgmbarlis.add(index, gsn);
		}else{
			gsn.init(bean);// 初始化
		}
	}
	// 给list删除 也不是删除，给为null 就是先停止，然后给予null
	public void giveNullBarTolist(int index){
		// 如果已经是空的就不用操作了
		if(gsnmgmbarlis.get(index) != null){
			gsnmgmbarlis.get(index).endThread();
			gsnmgmbarlis.remove(index);
			// 再加？
			gsnmgmbarlis.add(index,  null);
		}
//		System.out.println(gsnmgmbarlis.size());
	}
	// 判断当前下标是否为null
	public boolean isNullOfBarListByindex(int index){
		if(gsnmgmbarlis.get(index) == null){
			return true;
		}
		return false;
	}
	// 根据下标设置障碍物移动
	public void setBarOneMoveByIndex(int index){
		// 有bug 直接
		if(index < gsnmgmbarlis.size()){
			if(gsnmgmbarlis.get(index) != null){
				gsnmgmbarlis.get(index).startMove();
			}
		}
	}
	// 获取list的节点
	public GsnMainGameMoveBarrier getNodeByIndexOfBarList(int index){
		if(index < 0){
			return null;
		}
		return gsnmgmbarlis.get(index);
	}
	// 根据list 来遍历所有的障碍物并判断是否选中了这个障碍物
	public GsnMainGameMoveBarrier itBarlistIsCheck(int m, int n){
		for(int i = 0; i < MainGameMoveBarrierlength; i++){
			if(gsnmgmbarlis.get(i) != null){
				if(gsnmgmbarlis.get(i).isMeByIJ(m, n)){
					return gsnmgmbarlis.get(i);
				}
			}
		}
		return null;
	}
	// 全部都不选
	public void allBarCancelChoose(){
		for(int i = 0 ; i < MainGameMoveBarrierlength; i++){
			if(gsnmgmbarlis.get(i) != null){
				gsnmgmbarlis.get(i).isChoose = false;
			}
		}
	}
	// 全部运行
	public void allBarlisRun(){
		// 设置要不要更新绘画 
		gsneminter.gsnedmmgajpanel.isRepeatPaintBar = true;
		for(int i = 0 ; i < MainGameMoveBarrierlength; i++){
			if(gsnmgmbarlis.get(i) != null){
				// 开始移动
				gsnmgmbarlis.get(i).init(gsnmgmbarlis.get(i).gsnmbarbean);
				gsnmgmbarlis.get(i).startMove();
				// 那么也就选择不了
//				gsnmgmbarlis.get(i).isChoose = false;
			}
		}
		gsneminter.gsnedmmgajpanel.repaint();
	}
	// 全部暂停
	public void allBarlisPause(){
		// 设置一
		gsneminter.gsnedmmgajpanel.isRepeatPaintBar = false;
		for(int i = 0 ; i < MainGameMoveBarrierlength; i++){
			if(gsnmgmbarlis.get(i) != null){
				// 要先全部恢复原来位置的吗?
				gsnmgmbarlis.get(i).init(gsnmgmbarlis.get(i).gsnmbarbean);
				gsnmgmbarlis.get(i).endMove();
			}
		}
		gsneminter.gsnedmmgajpanel.repaint();
	}
	// 全部删除
	public void allBarlisDelete(){
		// 设置一
		gsneminter.gsnedmmgajpanel.isRepeatPaintBar = false;
		for(int i = 0 ; i < MainGameMoveBarrierlength; i++){
			if(gsnmgmbarlis.get(i) != null){
				giveNullBarTolist(i);
			}
		}
	}
	// 根据GsnMainGameMoveBarrier2 判断自己的下标
	public int findBarlistIndexBy(GsnMainGameMoveBarrier g){
		return gsnmgmbarlis.indexOf(g);
	}
	// 找寻不是为空值的障碍物数量
	public int notNullBarListCount(){
		int count = 0;
		for(int i = 0 ; i < gsnmgmbarlis.size(); i++){
			if(gsnmgmbarlis.get(i) != null){
				count++;
			}
		}
		return count;
	}
	public void startDraw(){
		gsnsnake[0].startMove();
		if(GsnMainGameConstants.gamemode == 2 || GsnMainGameConstants.gamemode == 3){
			gsnsnake[1].startMove();// 模式2 3 才开始
		}
		for(int i = 0 ; i < MainGamefoodlength; i++){
			gsnfood[i].startUpdate();// 开始更新
		}
		for(int i = 0 ; i < MainGameMoveBarrierlength; i++){
			if(gsnmgmbarlis.get(i) != null){
				gsnmgmbarlis.get(i).startMove();
			}
		}
	}
	public void endDraw(){
		for(int i = 0 ; i < gsnsnake.length; i++){
			gsnsnake[i].endMove();
		}
		for(int i = 0 ; i < MainGamefoodlength; i++){
			gsnfood[i].endUpdate();
		}
		for(int i = 0 ; i < MainGameMoveBarrierlength; i++){
			if(gsnmgmbarlis.get(i) != null){
				gsnmgmbarlis.get(i).endMove();
			}
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
			if(gsnmgmbarlis.get(i) != null){
				gsnmgmbarlis.get(i).endThread();
			}
		}
	}
	// 游戏相关动作------------
	// 两条蛇相撞 蛇头相撞3 蛇2咬蛇1 return1 ，蛇1咬蛇2 return2，没有撞 0
	public void checkCCAnother(){
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
				gsnsnake[1].cutSpeed();
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
				gsnsnake[0].cutSpeed();
				gsnsnake[1].cutSpeed();
			}
		}
	}
	// 拖动蛇 player拖动的吧,当前拖动蛇的蛇头 碰到任何一个其它蛇就不要继续下去
	public boolean isTouchOtherSnake(int player, int ai[],int aj[]){
		// 所有蛇
		for(int j = 0; j < gsnsnake.length; j++){
			if(j != player){
				// 任何一个节点不能重合
				for(int i = 0; i < gsnsnake[j].node; i++){
					for(int z = 0; z < gsnsnake[player].node; z++){
						if(gsnsnake[j].snactuali[i] == ai[z] &&
								gsnsnake[j].snactualj[i] == aj[z]){
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	// 是否进入墙
	public boolean isHaveWall(int ai[],int aj[]){
		for(int i = 0; i < ai.length; i++){
			if(gsneminter.gsneditmapbean.mapdata[ai[i]][aj[i]] == 1){
				return true;
			}
		}
		return false;
	}
	// 根据当前方向计算蛇节
	public void dragSnakePos(int player,int headi, int headj, int dir){
		int ai[] = new int[2];
		int aj[] = new int[2];
		// 先保存
		ai[0] = headi;
		aj[0] = headj;
		switch (dir) {
			case 0:
				ai[1] = headi + 1;
				aj[1] = headj;
			break;
			case 1:
				ai[1] = headi - 1;
				aj[1] = headj;
			break;
			case 2:
				ai[1] = headi;
				aj[1] = headj + 1;
			break;
			case 3:
				ai[1] = headi;
				aj[1] = headj - 1;
			break;			
		default:
			break;
		}
		// 判断是否越界
		if(ai[0] < 0 || ai[0] > 40 || ai[1] < 0 || ai[1] > 40 ||
				aj[0] < 0 || aj[0] > 59 || aj[1] < 0 || aj[1] > 59){
			// 为false
			isDragSnake1 =false;
			isDragSnake2 =false;
			// 为了不绘画预选
			start[0] = -1;// 0是列
			start[1] = -1;
		}else if(isTouchOtherSnake(player, ai, aj)){// 判断是否与另外的蛇碰撞
			// 为false
			isDragSnake1 =false;
			isDragSnake2 =false;
			// 为了不绘画预选
			start[0] = -1;// 0是列
			start[1] = -1;
		}else if(isHaveWall(ai,aj)){// 判断是否进入了墙里
			// 为false
			isDragSnake1 =false;
			isDragSnake2 =false;
			// 为了不绘画预选
			start[0] = -1;// 0是列
			start[1] = -1;
		}else{
			GsnMapSnakeBean gsnamapsnake = new GsnMapSnakeBean();
			gsnamapsnake.snmapdirection = dir;
			gsnamapsnake.snmapi[0] = ai[0];
			gsnamapsnake.snmapj[0] = aj[0];
			gsnamapsnake.snmapi[1] = ai[1];
			gsnamapsnake.snmapj[1] = aj[1];
			// 很严重的错误！！！！！！！！蛇节没有设置 导致错误！
			gsnamapsnake.snnode = 2;
			// 中心面
			gsneminter.gsneditmapbean.gsmsnakebean[player] = gsnamapsnake;
			// 清楚地图中原来的位置
			gsneminter.gsnedmmgajpanel.deleteSnakeYuanZhi(player);
			// 赋予 游戏面板 位置
			gsneminter.gsnedmmgajpanel.setRunSnakePos();
			// 更新地图值
			gsneminter.gsnedmmgajpanel.fromSnakePosSetVal();
			// 重新绘画
			gsneminter.gsnedmmgajpanel.repaint();
			
			// 设置右边文本框值
			gsneminter.gsnedmrojpanel.setSnakeTextValue();
		}
	}
	// 公共的定位鼠标
	public void posMouse(MouseEvent e){
		if(startPosLineDraw){
			pos4 = e.getPoint();
			
			drawLinepos[0] = pos4.x / 10;
			drawLinepos[1] = pos4.y / 10;
			
			gsnorderline.setPos(drawLinepos);
			this.repaint();
		}
	}
	// 是否定位鼠标
	public void setIsPosMouse(){
		if(startPosLineDraw){
			startPosLineDraw = false;
			// 重新绘画
			this.repaint();
		}else{
			startPosLineDraw = true;
		}
	}
	Point pos1;// 开始位置
	Point pos2;// 拖动的时候
	Point pos3;// 结束位置
	int start[] = new int[2];
	int end[] = new int[2];
	int mid[] = new int[2];
	
	// 保留当前选择哪一个障碍物
	GsnMainGameMoveBarrier gsmm;
	
	// 是否拖动蛇
	boolean isDragSnake1 = false;
	boolean isDragSnake2 = false;
	
	Point pos4;// 
	int drawLinepos[] = new int[2];
	// int 
	// 监听左键选择区域
	class GsnEditMapMainGameMouseLis extends MouseAdapter{
		// 新增功能 
		// 鼠标移动 当按下了并且在拖动 就持续绘画 
		@Override
		public void mouseDragged(MouseEvent e) {
			isstartControl = false;// 拖着就
			crossnodequ.clear();
//			System.out.println("mouseDragged");
			// 先获取当前左键左击不松开的位置
			pos3 = e.getPoint();
			
			end[0] = pos3.x / 10;
			end[1] = pos3.y / 10;
			
			// 拖动snake
			if(isDragSnake1 && !gsneminter.mapTest){
				dragSnakePos(0, end[1], end[0], gsneminter.gsneditmapbean.gsmsnakebean[0].snmapdirection);
			}else if(isDragSnake2 && !gsneminter.mapTest){
				dragSnakePos(1, end[1], end[0], gsneminter.gsneditmapbean.gsmsnakebean[1].snmapdirection);
			}else{
	//			// 当行比一开始的位置要小的时候 就要重新恢复原值 再绘画当前。
				if(end[1] < mid[1]){
					gsneminter.recoverMapDataFromData();
				}
				// 还有当列也比一开始小的的时候
				if(end[0] < mid[0]){
					gsneminter.recoverMapDataFromData();
				}
	//			System.out.println(pos3.x+" "+pos3.y);
				gsneminter.setStillDraw(start, end);
				// 设置新值 并且绘画
				initMapData();
				GsnEditMapMainGameAreaJPanel.this.repaint();
				
				// 保存上一个右下角的点
				mid[0] = pos3.x / 10;
				mid[1] = pos3.y / 10;
			}
			posMouse(e);
		}
		
		// 预选
		@Override
		public void mousePressed(MouseEvent e) {
//			System.out.println("mousePressed");
			// 获取监听
			GsnEditMapMainGameAreaJPanel.this.requestFocus();
			// 先获取当前左键左击不松开的位置
			pos1 = e.getPoint();
			// 行列
			start[0] = pos1.x / 10;// 0是列
			start[1] = pos1.y / 10;
//			System.out.println(pos1.x+" "+pos1.y);
			// 当前点击的是蛇的坐标 进行拖动 根据pos1, 是哪条蛇无所谓
			if(gsneminter.gsneditmapbean.mapdata[start[1]][start[0]] == 2){
				isDragSnake1 = true;
			}
			if(gsneminter.gsneditmapbean.mapdata[start[1]][start[0]] == 3){
				isDragSnake2 = true;
			}
		}
		@Override
		public void mouseReleased(MouseEvent e) {
//			System.out.println("mouseReleased");
			pos3 = e.getPoint();
			
			end[0] = pos3.x / 10;
			end[1] = pos3.y / 10;
//			System.out.println(pos1.x+" "+pos1.y);
//			System.out.println(pos3.x+" "+pos3.y);
			
			int crossnodeposfirst[] = new int[2];
			// 行列
			// 一旦超过。。。就是反应不过来 或者被拖着.先放着 一直有问题
			crossnodeposfirst[0] = pos3.y / 10;// 0是行
			crossnodeposfirst[1] = pos3.x / 10;
			boolean isok = false;
			 // 恢复 原来的值。
			if(!isstartControl){
				// 清空？？
				crossnodequ.clear();
//				gsneminter.recoverMapDataFromDataTozero();// 有0恢复4
				gsneminter.recoverMapDataFromData();
				crossnodequ.add(crossnodeposfirst);
			}else{
				if(crossnodequ.size() < 2){
					// 不要选择蛇的位置 也不能是障碍物
					crossnodequ.add(crossnodeposfirst);
				}else{
					System.out.println(crossnodequ.size());
					// 第一个恢复 并且新添加一个 位置 
					// 取出
					int thefirst[] = crossnodequ.poll();
					// 恢复原本
					currmapdata[thefirst[0]][thefirst[1]] = gsneminter.mapdatareservation[thefirst[0]][thefirst[1]];
					crossnodequ.add(crossnodeposfirst);
				}
				// 当前为预先
				currmapdata[crossnodeposfirst[0]][crossnodeposfirst[1]] = 49;
				GsnEditMapMainGameAreaJPanel.this.repaint();
				// 给文本框赋值
				gsneminter.setValueToCrossNode();
			}	
//			allqu();
			if(isDragSnake1 || isDragSnake2|| isstartControl){
				
			}else{
				// 设置的时候
				gsneminter.setReservationArea(start, end);
				// 设置新值 并且绘画
				initMapData();
				GsnEditMapMainGameAreaJPanel.this.repaint();
			}
			// 取消拖动
			isDragSnake1 = false;
			isDragSnake2 = false;
			posMouse(e);
		}
		
		// 障碍物的选择方法 
		@Override
		public void mouseClicked(MouseEvent e) {
//			System.out.println("mouseClicked");
			// 重新点了就恢复运行
			if(gsmm != null){
				gsmm.isChoose = false;
				gsmm.startMove();
			}
			
			// 让障碍物停止 
			// 根据当前选择的行列判断是否在移动障碍物的范围是就获取这个障碍物
			gsmm = itBarlistIsCheck(e.getPoint().y / 10,e.getPoint().x / 10);
			if(gsmm != null){
				// 被选中
				gsmm.init(gsmm.gsnmbarbean);// 恢复原来的位置
				gsmm.isChoose = true;
				// 并且设置障碍物菜单被选中
				gsneminter.gsnedmrojpanel.jtbpane.setSelectedIndex(3);
				// 并且将下拉选中自己 先获取自己的下标
				int index = findBarlistIndexBy(gsmm);
				gsneminter.gsnedmrojpanel.barjcbox.setSelectedIndex(index + 1);
				gsneminter.gsnedmrojpanel.barjcbox.updateUI();
				gsmm.endMove();// 先选中再停止
			}
			posMouse(e);
		}
		// 当 鼠标移动的时候
		public void mouseMoved(MouseEvent e) {
//			System.out.println("mouseMoved");
			posMouse(e);
		}
		@Override
		public void mouseEntered(MouseEvent e) {
//			System.out.println("mouseEntered");
			posMouse(e);
		}
	}
	// 游戏相关动作-----
	// 键盘监听 
	class GsnMainGameKeyLis extends KeyAdapter{
		private int keycode;//
		// 对于操纵蛇，应该是按下就改变，不要等松手在改变 更顺手
		@Override
		public void keyPressed(KeyEvent e) {
			keycode = e.getKeyCode();
			if(gsneminter.mapTest){
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
				if(GsnMainGameConstants.gamemode == 2 || GsnMainGameConstants.gamemode == 3){
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
			
			if(keycode == KeyEvent.VK_CONTROL){
				// 保存当前地图中选择的一个区域，只能有一个，如果没有选的话就。。
				// 不要更新预选
				isstartControl = true;
			}
		}
	
		@Override
		public void keyReleased(KeyEvent e) {
			keycode = e.getKeyCode();
			if(keycode == KeyEvent.VK_ESCAPE){
				// 停止 蛇 和 食物线程还有障碍物 的线程 算销毁吧
				endThread();
				// 清空
				
				// 要把 绘画大小 设置回来 5 为了预览关卡
				GsnMainGameConstants.setDrawSize(5);
				GsnBottomLayerInterface.backLastJPanel();
				System.out.println("GsnMainGameKeyLis按下VK_ESCAPE键");
			}
			if(keycode == KeyEvent.VK_CONTROL){
				isstartControl = false;
			}
		}
	}
	boolean isstartControl;
	public Queue<int[]> crossnodequ = new LinkedList<int[]>();// 保存位置，只能有两个，超过两个 第一个恢复，第二个不变
	public void allqu(){
		int i = 0;
		Iterator<int[]> it = crossnodequ.iterator();
		while(it.hasNext()){
			int z [] = it.next();
			i++;
			System.out.println(i+": "+z[0]+" "+z[1]);
		}
	}
	// 预览的时候 蛇的速度开启会一点
	public void PreviewAddSnakeSpeed(){
		gsnsnake[0].snspeed = GsnMainGameConstants.SnakePreviewMoveSpeed;
		gsnsnake[1].snspeed = GsnMainGameConstants.SnakePreviewMoveSpeed;
	}
	// 修改地图预览 开启绘制 和 恢复
	public void foodDead(){
		// 对于食物来说 应该是死亡
		for(int i = 0 ; i < MainGamefoodlength; i++){
			gsnfood[i].endThread();
		}
	}
	public void foodNew(){// 食物死亡线程 并新建
		initFoodInfo();
	}
	public void EditMapPreviewStartDraw(){
		// 动态地图
		gsneminter.setDynamicMapdata();
		// 游戏蛇的位置也更新为中心面板的初始位置
		setRunSnakePos();
		// 食物要重新加载
		initFoodInfo();
		PreviewAddSnakeSpeed();// 减少蛇速度
		startDraw();
		isPlay = true;
		gsneminter.mapTest = true;
		// 不选所有的障碍物
		allBarCancelChoose();
		// 绘画
		repaint();
		// 设置焦点
		this.requestFocus();
	}
	public void EditMapPreviewStartRecover(){
		gsneminter.setDynamicMapdata();
		endDraw();
		foodDead();
		// 暂停的时候 需要恢复到中心面板的蛇bean
		setRunSnakePos();
		// 障碍物暂停并恢复位置
		allBarlisPause();
		isPlay = false;
		gsneminter.mapTest = false;
		repaint();
	}
	// 游戏相关动作-----end
	// 天加新的移动障碍 有默认值
	public void addNewBarirrLength(){
		// 先添加一个数目
		MainGameMoveBarrierlength++;
		// 再赋予默认值
	}
	// 绘画
	@Override
	public void paint(Graphics g) {
		// TODO 自动生成的方法存根
		super.paint(g);// 不写这个 就还是上一级的背景
		// 如果开启绘制线就绘制 得放前面才不会覆盖其它图像
		if(startPosLineDraw){
			gsnorderline.draw(g);
		}
		Color yuan = g.getColor();
		for(int m = 0; m < 41; m++){
			for(int n = 0; n < 60; n++){
				if(currmapdata[m][n] == 1){
					g.setColor(Color.DARK_GRAY);
					g.fillRect(n * GsnMainGameConstants.drawSize, m * GsnMainGameConstants.drawSize, GsnMainGameConstants.drawSize, GsnMainGameConstants.drawSize);
				}
				// 预选定的
				if(currmapdata[m][n] == 49){
					g.setColor(Color.GREEN);
					g.drawRect(n * GsnMainGameConstants.drawSize, m * GsnMainGameConstants.drawSize, GsnMainGameConstants.drawSize, GsnMainGameConstants.drawSize);
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
		g.setColor(Color.BLACK);
		
//		// 绘画障碍物
		for(int i = 0; i < MainGameMoveBarrierlength; i++){
			if(gsnmgmbarlis.get(i) != null){// 有点会置为null 不能绘画了
				gsnmgmbarlis.get(i).draw(g);
			}
		}
		// 绘画蛇
		g.setColor(Color.RED);
		gsnsnake[0].draw(g);
		g.setColor(Color.GREEN);
		gsnsnake[1].draw(g);
		g.setColor(yuan);
		// 开启测试 绘画食物 
		if(gsneminter.mapTest){
			g.setColor(Color.PINK);
			// 绘画食物
			for(int i = 0; i < MainGamefoodlength; i++){
				gsnfood[i].draw(g);
			}
		}
		// 测试的时候也可以开着 让蛇动
		// 运行障碍物要一直运行
		// 全部暂停的时候??怎么恢复呢。。 直接false就行了吧
		if(isRepeatPaintBar || gsneminter.mapTest){
			// 两条蛇相撞 只需要一条蛇碰撞检测 就行了吧 
			// 20191130把碰撞和吃食物的代码放在这里不知道好不好
			checkCCAnother();
			eatFood();
			
			GsnEditMapMainGameAreaJPanel.this.repaint();
		}
		// 删除了重绘就不会一直绘画
//		GsnEditMapMainGameAreaJPanel.this.repaint();
	}
	// eat
	public void eatFood(){
		// 蛇外层
		for(int si = 0; si < gsnsnake.length; si++){
			for(int i = 0; i < MainGamefoodlength; i++){
				if(gsnfood[i].curi == gsnsnake[si].snactuali[0] && gsnfood[i].curj == gsnsnake[si].snactualj[0]){
					gsnfood[i].deadUpdate();
					gsnsnake[si].node++;
					// 因为先休眠再移动，最后的蛇节绘画的坐标为00 先处理这样
					gsnsnake[si].snactuali[gsnsnake[si].node - 1] = -1;
					gsnsnake[si].snactualj[gsnsnake[si].node - 1] = -1;
					gsnsnake[si].addSpeed();
					// 不加分 
					return;
				}
			}
		}
	}
	
	// 修改关卡的时候设置的值------------------
	// 是修改的就不用set了  就直接从地图信息获取 因为克隆了
	public void setSnakePosByMap(){
		gsnsnake[0].InitBySnakeBean(gsneminter.gsneditmapbean.gsmsnakebean[0]);
		gsnsnake[1].InitBySnakeBean(gsneminter.gsneditmapbean.gsmsnakebean[1]);
		
		fromSnakePosSetVal();// 并且设置地图值
	}
	public void UpdateLevelInitValue(){
		// 食物读取
		MainGamefoodlength = gsneminter.gsneditmapbean.gsmfoodbean.foodlength;
		// 移动障碍数量
		MainGameMoveBarrierlength = gsneminter.gsneditmapbean.gsminfobean.barcount;
		// 穿越节点数量
		crossnodelength = gsneminter.gsneditmapbean.gsminfobean.crossnodecount;
		
		// 读取地图
		initMapData();
		// 蛇
		setSnakePosByMap();
		// 食物
		initFoodInfo();
		// 障碍物
		initBarInfo();
		// 穿越节点
		initCrossNodeList();
		
		// 先停止
		endDraw();
		isPlay = false;
		// 停止运行
		isRepeatPaintBar = false;
	}
	// 修改关卡的时候设置的值------------------
	
	
	// 设置穿越节点start--------------
	public void initCrossNodeList(){
		crossnodelength = gsneminter.gsneditmapbean.gsminfobean.crossnodecount;
		gsnmgmcrossnodelis = new ArrayList<GsnCrossNodeDraw>(crossnodelength);
		for(int i = 0 ; i < crossnodelength; i++){
			GsnCrossNodeDraw gsncn = new GsnCrossNodeDraw();
			gsncn.setValueToBean(gsneminter.gsneditmapbean.gsmcrossnodebeanlist.get(i));
			gsnmgmcrossnodelis.add(gsncn);
		}
	}
	// 给list添加一个  
	public void addOneCrossNodeTolist(GsnMapCrossNodeBean bean){
		GsnCrossNodeDraw gsncn = new GsnCrossNodeDraw();
		gsncn.setValueToBean(bean);
		gsnmgmcrossnodelis.add(gsncn);
	}
	// 数量
	public void addNewCrossListLength(){
		// 先添加一个数目
		crossnodelength++;
		// 再赋予默认值
	}
	// 找寻不是为空值的数量
	public int notNullCrossNodeCount(){
		int count = 0;
		for(int i = 0 ; i < gsnmgmcrossnodelis.size(); i++){
			if(gsnmgmcrossnodelis.get(i) != null){
				count++;
			}
		}
		return count;
	}
	// 修改 直接删除原来的 再添加回去？？ 可能会添加到后面去吧？但有个下标定位
	public void alterOneCrossNodeList(GsnMapCrossNodeBean bean, int index){
		gsnmgmcrossnodelis.remove(index);// 先删再改
		GsnCrossNodeDraw gs = new GsnCrossNodeDraw();
		gs.setValueToBean(bean);
		gsnmgmcrossnodelis.add(index, gs);
	}
	// 给list删除 也不是删除，给为null
	public void giveNullCrossNodeTolist(int index){
		// 如果已经是空的就不用操作了
		if(gsnmgmcrossnodelis.get(index) != null){
			gsnmgmcrossnodelis.remove(index);
			// 再加？
			gsnmgmcrossnodelis.add(index,  null);
		}
	}
	// 获取list的节点
	public GsnCrossNodeDraw getNodeByIndexOfCrossNodeList(int index){
		if(index < 0){
			return null;
		}
		return gsnmgmcrossnodelis.get(index);
	}
	// 判断当前下标是否为null
	public boolean isNullOfCrossListByindex(int index){
		if(gsnmgmcrossnodelis.get(index) == null){
			return true;
		}
		return false;
	}
	// 设置穿越节点end--------------
	
	// 键盘监听 为了穿越start---------------
	// 键盘监听 为了穿越end---------------
}

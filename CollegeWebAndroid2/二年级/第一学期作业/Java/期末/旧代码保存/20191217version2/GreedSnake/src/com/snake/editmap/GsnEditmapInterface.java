package com.snake.editmap;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import com.snake.bean.GsnMapBarrierMoveBean;
import com.snake.bean.GsnMapBean;
import com.snake.bean.GsnMapFoodBean;
import com.snake.bean.GsnMapInFoBean;
import com.snake.bean.GsnMapSnakeBean;
import com.snake.config.GsnInterfaceParam;
import com.snake.interfaces.GsnBottomLayerInterface;
import com.snake.iomap.GsnInputAndOut;
import com.snake.iomap.GsnMapReadAndOut;
import com.snake.mgame.GsnCrossNodeDraw;
import com.snake.mgame.GsnMainGameMoveBarrier;
import com.snake.mgameconfig.GsnMainGameConstants;

// 修改地图界面
public class GsnEditmapInterface extends JPanel{
	public boolean mapTest;// 地图是否测试 
	// 地图面板
	public GsnEditMapMainGameAreaJPanel gsnedmmgajpanel;
	// 右边操作面板
	public GsnEditMapRightOperationJPanel gsnedmrojpanel;
	
	// 初始化一个地图bean
	public GsnMapBean gsneditmapbean;
	// 一个 char字符 的地图
	public boolean isborder;// 是否有边界
	
	GsnMapReadAndOut gsnmaprano;// 输出
	// 标志 是修改还是新建的地图
	public int flag; // 1为新建，2 为修改
	
	// 根据地图
	public GsnEditmapInterface(int flag){
		this.flag = flag;
		setLayout(null);
		init();
		setDefaultMapValue();
		gsnedmmgajpanel = new GsnEditMapMainGameAreaJPanel(this);
		gsnedmrojpanel = new GsnEditMapRightOperationJPanel(this);
		
		gsnedmmgajpanel.setBounds(20, 50, gsnedmmgajpanel.getWidth() , gsnedmmgajpanel.getHeight());
		// 20 间距
		gsnedmrojpanel.setBounds(gsnedmmgajpanel.getWidth() + 40, 50,gsnedmrojpanel.getWidth(), gsnedmmgajpanel.getHeight()  );
		
		add(gsnedmmgajpanel);
		add(gsnedmrojpanel);
		this.setBackground(Color.CYAN);
		this.setSize(new Dimension(GsnInterfaceParam.INTERFACEWIDTH + gsnedmrojpanel.getWidth() + 20 , GsnInterfaceParam.INTERFACEHEIGHT));// 640 * 480 固定大小
	}
	public void init(){
		gsnmaprano = new GsnMapReadAndOut();
		gsneditmapbean = new GsnMapBean();
	}
	// 重新进来的时候 就是新建地图--------------------------------------------------------
	public void Reinit(){
		flag = 1;
		// 自己为新的
		gsneditmapbean = new GsnMapBean();
		// 保存的地图也应该是新的
		copyOneMapData();
		
		// 默认蛇位置 
		setEditMapSnakePos();

		// 设置一份给cur 才不会再才进来是错误的
		gsnedmmgajpanel.initGame();
		gsnedmmgajpanel.initBarInfo();
		gsnedmmgajpanel.initCrossNodeList();
		
		// 设置蛇默认地图值 先是给予游戏面板才可以
		gsnedmmgajpanel.fromSnakePosSetVal();
		
		// 刷新
		gsnedmmgajpanel.repaint();
		// 给框默认为空才能下次新建没错
		gsnedmrojpanel.setDefaultValueToallPanl();
	}
	
	// 给蛇  是新建的时候初始位置 
	public void setEditMapSnakePos(){
		// 先自己组成bean 传给snake,再输出的时候就好说了
		GsnMapSnakeBean gsn1 = new GsnMapSnakeBean(2, 1, 6, 5, 5, 5);
		GsnMapSnakeBean gsn2 = new GsnMapSnakeBean(2, 0, 37, 55, 38, 55);
		gsneditmapbean.gsmsnakebean[0] = gsn1;
		gsneditmapbean.gsmsnakebean[1] = gsn2;
	}
	// 
	// 重新进来的时候-----------------------
	public void setDefaultMapValue(){
		gsneditmapbean.giveSpaceOfBar();
//		System.out.println(gsneditmapbean.toString());
	}
	// 设置修改地图的时候的方法----------------------------------
	public void setMapDataByLevel(){
		// 为修改
		flag = 2;
		// mapdata这里要克隆过去
		//太难了 mapdata不能被浅拷贝 不然修改了以后dynamic会受影响 或者 再一个专门的mapdata对象 来传给dynamic 不要用bean传 
		gsneditmapbean = new GsnMapBean((GsnMainGameConstants.gsngamemap[GsnMainGameConstants.currLevel - 1]));
		// 给curren 给复制
		copyOneMapData();
		mapTest = false;
		
		// 删除障碍物的地图值
		delMapDataOfBar();
		
		// 游戏面板 初始数量这些东西
		gsnedmmgajpanel.UpdateLevelInitValue();
		
		// 右边面板设置
		gsnedmrojpanel.Alter();
	}
	// 设置修改的时候的方法----------------------------------
	// 输出的时候设置地图的属性，有从游戏面板中获取移动障碍和穿越节点
	public void setGsnEditMapBean(GsnMapInFoBean gsnmapinfo, GsnMapFoodBean gsnfood){
		// 先恢复预选的地图值
		recoverMapData();
		// 赋予
		gsneditmapbean.gsminfobean = gsnmapinfo;
		gsneditmapbean.gsmfoodbean = gsnfood;
		
		// barbean 至于移动障碍的话也要 根据list得到数组 然后再给予
		// list的大小已经保存，只要开辟空间 从游戏面板中放入 就行
		giveSpaceAndValuefromListOfBarList(gsnedmmgajpanel.gsnmgmbarlis);
		
		// 得到穿越节点
		giveSpaceAndValuefromListOfCrossNodeList(gsnedmmgajpanel.gsnmgmcrossnodelis);
		
		
		// 还有蛇的bean也要,从游戏面板里获取 这个就不好了 ，应该是这个 类的蛇更改位置 没有变直接获取就好
		
		// 设置 障碍物的地图值
		setMapDataOfBarPos();
	}
	public void giveSpaceAndValuefromListOfBarList(List<GsnMainGameMoveBarrier> ar){
		// 这里很可能报错 注意~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		// 1.先得知道有多少个bean是可用的
		int barcount = gsnedmmgajpanel.notNullBarListCount();
		// 给予空间
		gsneditmapbean.gsmbmbean = new GsnMapBarrierMoveBean[barcount];
		
		int listj = 0;
		for(int i = 0; i < barcount; i++){
			// 主要要操作空的null 所以两个下标是不一样的
			while(ar.get(listj) == null){// 找到下一个不为空的才放入
				listj++;
			}
			gsneditmapbean.gsmbmbean[i] = ar.get(listj).gsnmbarbean;// 是要获取属性
			listj++;// 很重要的一步 这里也要++j
		}
	}
	public void giveSpaceAndValuefromListOfCrossNodeList(List<GsnCrossNodeDraw> ar){
		// 1.先得知道有多少个bean是可用的
//		int count = gsnedmmgajpanel.notNullCrossNodeCount();
		for(int i = 0; i < ar.size(); i++){// 直接不等于空
			if(ar.get(i) != null){
				gsneditmapbean.gsmcrossnodebeanlist.add(ar.get(i).gsncnbean);// 是要获取属性
			}
		}
	}
	// 还有需要对障碍物的位置设置地图值 也许多此一举把 20191202
	public void setMapDataOfBarPos(){
		for(int z = 0; z < gsneditmapbean.gsmbmbean.length; z++){
			// 当前占据的就是56
			for(int i = 0; i < gsneditmapbean.gsmbmbean[z].barheight; i++){
				for(int j = 0; j < gsneditmapbean.gsmbmbean[z].barwidth; j++){
					gsneditmapbean.mapdata[gsneditmapbean.gsmbmbean[z].bari + i][gsneditmapbean.gsmbmbean[z].barj + j] = 56;
				}
			}
		}
	}
	// 对于修改地图的时候 进来的时候就把障碍物的地图值删掉 为了操作后遗留问题
	public void delMapDataOfBar(){
		for(int m = 0; m < 41; m++){
			for(int n = 0; n < 60; n++){
				if(gsneditmapbean.mapdata[m][n] == 56){// 为预选的删除
					gsneditmapbean.mapdata[m][n] = 0;
				}
			}
		}
	}
	public void delWithMapData(){
		for(int m = 0; m < 41; m++){
			for(int n = 0; n < 60; n++){
				if(gsneditmapbean.mapdata[m][n] == 49){// 为预选的删除
					gsneditmapbean.mapdata[m][n] = 0;
				}
			}
		}
	}
	// 输出地图bean
	public void outNewMap(){// 要更新curr数据 以免新建的时候会犯错
		// 对地图预先处理
		delWithMapData();
		gsnmaprano.outNewMap(gsneditmapbean);
		// 输出完了以后就要赋予初值
		Reinit();
		// 输出完 重新读取
		reReadNewMap();
		// 编辑地图的
		// 输出完也要更新坐标预览的
		GsnBottomLayerInterface.gsneditmapleveldisplayJpanel.setEditMapLevelCurLevelForadd();
		
		// 输出完要给更新UI 就是关卡选择
		GsnBottomLayerInterface.gsneditmapleveldisplayJpanel.clearArrayList();
		GsnBottomLayerInterface.gsneditmapleveldisplayJpanel.reAddArraylist();
		//设置最后关卡选中
		GsnBottomLayerInterface.gsneditmapleveldisplayJpanel.gsneditmapleveldisjlist.setSelectedIndex(GsnMainGameConstants.gsngamemap.length - 1);
		GsnBottomLayerInterface.gsneditmapleveldisplayJpanel.gsneditmapleveldisjlist.updateUI();
		
		// 普通地图选择的
		GsnBottomLayerInterface.gameLevelJpanel.clearArrayList();
		GsnBottomLayerInterface.gameLevelJpanel.reAddArraylist();
		//设置第一个关卡选中
		GsnBottomLayerInterface.gameLevelJpanel.gsnleveldisjlist.setSelectedIndex(0);
		GsnBottomLayerInterface.gameLevelJpanel.gsnleveldisjlist.updateUI();
	}
	// 修改地图
	public void alterMap(){
		delWithMapData();// 清楚预选
		gsnmaprano.alterMap(gsneditmapbean);
		// 修改完了以后就要赋予初值
		Reinit();
		// 输出完 重新读取 并且转换
		reReadNewMap();
		// 输出完也要更新坐标预览的关卡数量
		GsnBottomLayerInterface.gsneditmapleveldisplayJpanel.setEditMapLevelCurLevelForAlter();
		
		// 输出完要给更新UI 就是关卡选择
		GsnBottomLayerInterface.gsneditmapleveldisplayJpanel.clearArrayList();
		GsnBottomLayerInterface.gsneditmapleveldisplayJpanel.reAddArraylist();
		//设置当前关卡选中
		GsnBottomLayerInterface.gsneditmapleveldisplayJpanel.gsneditmapleveldisjlist.updateUI();
		// 应该是选中最后一个
		GsnBottomLayerInterface.gsneditmapleveldisplayJpanel.gsneditmapleveldisjlist.setSelectedIndex(GsnMainGameConstants.gsngamemap.length - 1);
		
		// 普通地图选择的
		GsnBottomLayerInterface.gameLevelJpanel.clearArrayList();
		GsnBottomLayerInterface.gameLevelJpanel.reAddArraylist();
		//设置第一个关卡选中
		GsnBottomLayerInterface.gameLevelJpanel.gsnleveldisjlist.setSelectedIndex(0);
		GsnBottomLayerInterface.gameLevelJpanel.gsnleveldisjlist.updateUI();
	}
	// 重新读取地图
	public void reReadNewMap(){
		gsnmaprano.readMapText();
		gsnmaprano.changeMap();
	}
	
	// 设置值
	// 设置边界
	public void setBorder(){
		byte value;
		// 没有边界
		if(!isborder){
			value = 1;
			isborder = true;// 有边界了
		}else{// 有边界
			value = 0;
			isborder = false;// 没有边界了
		}
		// 左右边界
		for(int i = 0; i < 41; i++){
			gsneditmapbean.mapdata[i][0] = value;
			gsneditmapbean.mapdata[i][59] = value;
		}
		// 上下边界
		for(int i = 0; i < 60; i++){
			gsneditmapbean.mapdata[0][i] = value;
			gsneditmapbean.mapdata[40][i] = value;
		}
//		fromByteToChar();
		// 变完以后拷贝一份
		copyOneMapData();
	}
	// 设为选择的为墙
	public void setOrderToWall(int start[] , int end[]){// 调用数组范围的
		for(int m = start[1]; m <= end[1]; m++){// y
			for(int n = start[0]; n <= end[0]; n++){// x
				// 绘画了为预选的就恢复
				if(gsneditmapbean.mapdata[m][n] == 49 && !(mapdatareservation[m][n] == 2 || mapdatareservation[m][n] == 3) ){
					gsneditmapbean.mapdata[m][n] = 1;
				}
			}
		}
		// 变完以后拷贝一份
		copyOneMapData();
	}
	public void setOrderToWall(){
		for(int m = 0; m < 41; m++){
			for(int n = 0; n < 60; n++){
				// 原来地图中 被选择到的蛇不能为墙
				if(gsneditmapbean.mapdata[m][n] == 49 && !(mapdatareservation[m][n] == 2 || mapdatareservation[m][n] == 3) ){
//					System.out.println("mapdatareservation[m][n]:"+mapdatareservation[m][n]);
					gsneditmapbean.mapdata[m][n] = 1;
				}
			}
		}
		// 变完以后拷贝一份
		copyOneMapData();
	}
	// 取消墙
	public void cancelOrderOfWall(){
		for(int m = 0; m < 41; m++){
			for(int n = 0; n < 60; n++){
				// 不会有蛇 因为没有预选到
				if(gsneditmapbean.mapdata[m][n] == 49){
					gsneditmapbean.mapdata[m][n] = 0;
				}
			}
		}
		// 变完以后拷贝一份
		copyOneMapData();
	}
	public void cancelOrderOfWall(int start[] , int end[]){// 调用数组范围的
		for(int m = start[1]; m <= end[1]; m++){// y
			for(int n = start[0]; n <= end[0]; n++){// x
				// 绘画了为预选的就恢复
				if(gsneditmapbean.mapdata[m][n] == 49){
					gsneditmapbean.mapdata[m][n] = 0;
				}
			}
		}
		// 变完以后拷贝一份
		copyOneMapData();
	}
	// 选择的区域设置颜色值
	public void setStillDraw(int start[] , int end[]){
		
		// 每次预选区域前就要保存一份
//		copyOneMapData();// 不要保存 为了恢复
		// x y 处理边界
		// 如果一开始就大于边界就不要选了
		if(start[0] > 59 || start[1] > 40 || end[0] > 59 || end[1] > 40 ||
				start[0] < 0 || start[1] < 0 || end[0] < 0 || end[1] < 0){// start[0] = x start[1] = y
			
		}else{
			// 1.边界处理
			end[0] = end[0] > 59 ? 59 : end[0] ;
			end[1] = end[1] > 40 ? 40 : end[1] ;
			start[0] = start[0] > 59 ? 59 : start[0] ;
			start[1] = start[1] > 40 ? 40 : start[1] ;
			if(start[1] == end[1] && start[0] == end[0]){
				gsneditmapbean.mapdata[start[1]][start[0]] = 49;// a
				setValueTobar(start, end);
			}else{
				int midstart[] = new int[2];
				int midsend[] = new int[2];
				// 开始点在左上方，结束点在右下方 o
				if(start[0] < end[0] && start[1] < end[1]){
					midstart = start;
					midsend = end;
				}
				if(start[0] < end[0] && start[1] == end[1]){
					midstart = start;
					midsend = end;
				}
				//  左下  右上  
				if(start[0] < end[0] && start[1] > end[1]){
					midstart[0] = start[0];
					midstart[1] = end[1];
					midsend[0] = end[0];
					midsend[1] = start[1];
				}
				if(start[0] > end[0] && start[1] == end[1]){
					midstart = end;
					midsend = start;
				}
				// 右上，左下
				if(start[0] > end[0] && start[1] < end[1]){
					midstart[0] = end[0];
					midstart[1] = start[1];
					
					midsend[0] = start[0];
					midsend[1] = end[1];
				}
				if(start[0] == end[0] && start[1] < end[1]){
					midstart = start;
					midsend = end;
				}
				// 右下，坐上 o
				if(start[0] > end[0] && start[1] > end[1]){
					midstart = end;
					
					midsend = start;
				}
				if(start[0] == end[0] && start[1] > end[1]){
					midstart = end;
					midsend = start;
				}
				for(int m = midstart[1]; m <= midsend[1]; m++){// y
					for(int n = midstart[0]; n <= midsend[0]; n++){// x
						// 不要选择蛇的位置
						if( !(gsneditmapbean.mapdata[m][n] == 2 || gsneditmapbean.mapdata[m][n] == 3) ){
							gsneditmapbean.mapdata[m][n] = 49;// a
						}
					}
				}
				setValueTobar(midstart, midsend);
			}
		}
	}
	// 给穿越传值
	public void setValueToCrossNode(){
		// 给予障碍物值，条件是如果当前选择的是0 或者当前选择的为空就穿过去
		int index = gsnedmrojpanel.crossnodejcbox.getSelectedIndex() - 1;
		if(index < 0){
			gsnedmrojpanel.SetCrossTextFromQueue();
		}
		if(index >= 0){
			if(gsnedmmgajpanel.isNullOfCrossListByindex(index)){
				gsnedmrojpanel.SetCrossTextFromQueue();
			}
		}
	}
	// 给障碍物传值
	public void setValueTobar(int start[] , int end[]){
		// 给予障碍物值，条件是如果当前选择的是0 或者当前选择的为空就穿过去
		int index = gsnedmrojpanel.barjcbox.getSelectedIndex() - 1;
		if(index < 0){
			gsnedmrojpanel.SetBarFromOrder(start,end);
		}
		if(index >= 0){
			if(gsnedmmgajpanel.isNullOfBarListByindex(index)){
				gsnedmrojpanel.SetBarFromOrder(start,end);
			}
		}
	}
	// 选择的区域设置颜色值
	public void setReservationArea(int start[] , int end[]){
		// 每次预选区域前就要保存一份
		// 如果是多个就不要
		copyOneMapData();// 先保存一份
	
		// x y 处理边界
		// 如果一开始就大于边界就不要选了
		if(start[0] > 59 || start[1] > 40 || end[0] > 59 || end[1] > 40||
				start[0] < 0 || start[1] < 0 || end[0] < 0 || end[1] < 0){// start[0] = x start[1] = y
			
		}else{
			// 1.边界处理
			end[0] = end[0] > 59 ? 59 : end[0] ;
			end[1] = end[1] > 40 ? 40 : end[1] ;
			start[0] = start[0] > 59 ? 59 : start[0] ;
			start[1] = start[1] > 40 ? 40 : start[1] ;
			// 2. 处理各个角度 
			if(start[1] == end[1] && start[0] == end[0]){
				gsneditmapbean.mapdata[start[1]][start[0]] = 49;// a
				setValueTobar(start, end);
			}else{
				int midstart[] = new int[2];
				int midsend[] = new int[2];
				// 开始点在左上方，结束点在右下方
				if(start[0] < end[0] && start[1] < end[1]){
					midstart = start;
					midsend = end;
				}
				if(start[0] < end[0] && start[1] == end[1]){
					midstart = start;
					midsend = end;
				}
				//  左下  右上 
				if(start[0] < end[0] && start[1] > end[1]){
					midstart[0] = start[0];
					midstart[1] = end[1];
					midsend[0] = end[0];
					midsend[1] = start[1];
				}
				if(start[0] > end[0] && start[1] == end[1]){
					midstart = end;
					midsend = start;
				}
				// 右上，左下
				if(start[0] > end[0] && start[1] < end[1]){
					midstart[0] = end[0];
					midstart[1] = start[1];
					
					midsend[0] = start[0];
					midsend[1] = end[1];
				}
				if(start[0] == end[0] && start[1] < end[1]){
					midstart = start;
					midsend = end;
				}
				// 右下，坐上
				if(start[0] > end[0] && start[1] > end[1]){
					midstart = end;
					
					midsend = start;
				}
				if(start[0] == end[0] && start[1] > end[1]){
					midstart = end;
					midsend = start;
				}
				for(int m = midstart[1]; m <= midsend[1]; m++){// y
					for(int n = midstart[0]; n <= midsend[0]; n++){// x
						// 不要选择蛇的位置 也不能是障碍物
						if( !(gsneditmapbean.mapdata[m][n] == 2 || gsneditmapbean.mapdata[m][n] == 3 ||
								gsneditmapbean.mapdata[m][n] == 56) ){
							gsneditmapbean.mapdata[m][n] = 49;// a
						}
					}
				}
				setValueTobar(midstart, midsend);
			}
		}
	}
	// 恢复原来的值 主要是 gsneditmapbean.map 要变回来，因为currentmap是基于这个来变化的
	// 两个都可以 但是这个更慢
	public void recoverMapData(){
		for(int m = 0; m < 41; m++){
			gsneditmapbean.mapdata[m] = mapdatareservation[m].clone();
		}
	}
	public void recoverMapDataFromData(){// 遍历 有49就复原
		for(int m = 0; m < 41; m++){
			for(int n = 0; n < 60; n++){
				if(gsneditmapbean.mapdata[m][n] == 49){
					gsneditmapbean.mapdata[m][n] = mapdatareservation[m][n];
				}
			}
			
		}
	}
	public void recoverMapDataFromDataTozero(){// 遍历 有49就复原
		for(int m = 0; m < 41; m++){
			for(int n = 0; n < 60; n++){
				if(gsneditmapbean.mapdata[m][n] == 49){
					gsneditmapbean.mapdata[m][n] = 0;
				}
			}
		}
		copyOneMapData();
	}
	// 从预选的地图变回原来地图，从 point为范围 从保存的旧地图中 恢复就行
	public void recoverMapDataFromPoint(int start[] , int end[]){
		for(int m = start[1]; m <= end[1]; m++){// y
			for(int n = start[0]; n <= end[0]; n++){// x
				// 绘画了为预选的就恢复
				if(gsneditmapbean.mapdata[m][n] == 49){
					gsneditmapbean.mapdata[m][n] = mapdatareservation[m][n];
				}
			}
		}
	}
	
	// 拷贝一份地图值给地图值2  失败的代码
	public void copyOneMapData(){
		for(int m = 0; m < 41; m++){
			mapdatareservation[m] = gsneditmapbean.mapdata[m].clone();
		}
	}
	// 设置选择的区域
	public byte[][] mapdatareservation = new byte[41][60];// 保留一份原来的地图
	
	// 设置动态地图值 为了 让预览陈功
	public void setDynamicMapdata(){
		GsnMainGameConstants.setDynamicMapData(gsneditmapbean.mapdata);
	}
	
}
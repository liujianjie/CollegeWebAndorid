package com.snake.mgame;

import java.awt.Color;
import java.awt.Graphics;

import com.snake.bean.GsnMapBarrierMoveBean;
import com.snake.editmap.GsnEditMapMainGameAreaJPanel;
import com.snake.mgameconfig.GsnMainGameConstants;

public class GsnMainGameMoveBarrier extends Thread{
	public GsnMapBarrierMoveBean gsnmbarbean;// 一个对象代表一个障碍
	
	public boolean isRun;
	public boolean controlRun;
	
	// 运行的新属性
	public int curdir;// 当前方向 0123
	// 得到障碍物数组
	public int barmatri[], barmatrj[];// ,先试试传统的二维，再简化为一维数组
	public int heightindex,widthindex;// 高度和宽度的数组下标
	
	// 是否被选择了
	public boolean isChoose;
	
	public GsnMainGameMoveBarrier(GsnMainGameJPanel gamepanel){
		controlRun = true;
		isRun = false;
		this.gamepanel = gamepanel;
	}
	public GsnMainGameMoveBarrier(GsnEditMapMainGameAreaJPanel gamepanel){
		controlRun = true;
		isRun = false;
		this.editmapgamepanel = gamepanel;
	}
	public GsnMainGameJPanel gamepanel;
	GsnEditMapMainGameAreaJPanel editmapgamepanel;
	
	public GsnMainGameMoveBarrier(GsnMapBarrierMoveBean g){
		gsnmbarbean = g;
		
	}
	// 从地图获取过来的
	// 初始位置信息 不包含 node
	public void init(GsnMapBarrierMoveBean g){
		gsnmbarbean = g;
		curdir = gsnmbarbean.bardir; // 方向很重要 因为会改变方向
		// 以 height为行 以 width为列
		barmatri = new int[gsnmbarbean.barheight];
		barmatrj = new int[gsnmbarbean.barwidth];
		heightindex = gsnmbarbean.barheight - 1;
		widthindex = gsnmbarbean.barwidth - 1;
		// 障碍物范围
		getMatrixArea();
		// 修改地图值 第一次需要
		updateMapValue();
	}
	// 获取矩阵的其它行列是多少  根据最左的节点
	public void getMatrixArea(){
		// 获取移动区域范围矩阵
		for(int i = 0; i < gsnmbarbean.barheight; i++){
			barmatri[i] = gsnmbarbean.bari + i;// 左上角节点的i
			for(int j = 0; j < gsnmbarbean.barwidth; j++){
				barmatrj[j] = gsnmbarbean.barj + j ;// 坐上节点的j  
			}
		}
	}
	// 由长度  方向 头的位置 计算障碍物范围
	public void getArea(){

	}
	// 
	// 移动 根据上下左右方向 ，先根据方向得到蛇头是第一行还是最后一行还是第一列，还是最后一列 再进行换坐标
	public void move(){
		// 记录移动的 一行或者一列恢复为0
		int rei,rej;// 记住i j
		// 移动头结点位置
		switch (curdir) {
			case 0:// 上, 蛇头在第一行 更改第一行的蛇头
				// 从下往上移
				// 记住最后一行
				rei =  barmatri[heightindex];
				// 这一行设置恢复
				for(int j = gsnmbarbean.barj; j < gsnmbarbean.barj + gsnmbarbean.barwidth; j++){
					// 原始是 0 才能为0
					if(GsnMainGameConstants.yuanshimapdata[rei][j] == 0){
						GsnMainGameConstants.dynamicmapdata[rei][j]= 0;
					}
				}
				for(int i = heightindex; i > 0; i--){
					barmatri[i] = barmatri[i - 1];
				}
				// 第一行的话就 减
				barmatri[0] = barmatri[0] - 1;
				break;
			case 1:// 从上往下移动
				// 记住第1行
				rei =  barmatri[0];
				// 这一行设置恢复
				for(int j = gsnmbarbean.barj; j < gsnmbarbean.barj + gsnmbarbean.barwidth; j++){
					// 原始是 0 才能为0
					if(GsnMainGameConstants.yuanshimapdata[rei][j] == 0){
						GsnMainGameConstants.dynamicmapdata[rei][j]= 0;
					}
				}
				for(int i = 0; i < heightindex; i++){
					barmatri[i] = barmatri[i + 1];
				}
				// 最后一行的的话就 加
				barmatri[heightindex] = barmatri[heightindex] + 1;
				break;
			case 2:// 从右到左移
				// 记住第最后1列
				rej =  barmatrj[widthindex];
				// 这一行设置恢复
				for(int i = gsnmbarbean.bari; i < gsnmbarbean.bari + gsnmbarbean.barheight; i++){
					// 原始是 0 才能为0
					if(GsnMainGameConstants.yuanshimapdata[i][rej] == 0){
						GsnMainGameConstants.dynamicmapdata[i][rej] = 0;
					}
				}
				for(int j = widthindex; j > 0 ; j--){
					barmatrj[j] = barmatrj[j - 1];
				}
				barmatrj[0] = barmatrj[0] - 1; 
				break;
			case 3:// 从左到右移
				// 记住第1列
				rej =  barmatrj[0];
				// 这一行设置恢复
				for(int i = gsnmbarbean.bari; i < gsnmbarbean.bari + gsnmbarbean.barheight; i++){
					// 原始是 0 才能为0
					if(GsnMainGameConstants.yuanshimapdata[i][rej] == 0){
						GsnMainGameConstants.dynamicmapdata[i][rej]= 0;
					}
				}
				for(int j = 0; j < widthindex; j++){
					barmatrj[j] = barmatrj[j + 1];
				}
				barmatrj[widthindex] = barmatrj[widthindex] + 1; 
				break;
		default:
			break;
		}
		ischangeDir();
	}
	// 是否改变方向 了
	public void ischangeDir(){
		int istand,jstand;// 移动到的行 列边界
		// 当到达宽度 以左上角初始位置算
		switch(gsnmbarbean.bardir){// 以原始移动方向为准
			case 0:// 原本是上方向
				// 原本是上方向 但是当前方向有上下可选
				switch (curdir) {
					// 当前是上
					case 0:
						if(barmatri[0] == gsnmbarbean.bari - gsnmbarbean.barwide){
							curdir = 1;
						}
						break;
					// 当前是下 以最后一条线为准
					case 1:
						if(barmatri[0] == gsnmbarbean.bari){
							curdir = 0;
						}
						break;
				}
			break;
			case 1:
				// 原本是下方向 但是当前方向有上下可选
				switch (curdir) {
					// 当前是上
					case 0:
						// 以第一行为界限
						if(barmatri[0] == gsnmbarbean.bari){
							curdir = 1;
						}
						break;
					case 1:
						// 当前是下 最下面为界限
						if(barmatri[heightindex] == gsnmbarbean.bari + heightindex + gsnmbarbean.barwide){
							curdir = 0;
						}
						break;
				}
			break;
			case 2:
				// 原本是左方向 但是当前方向有左右可选
				switch (curdir) {
					case 2:
						// 当前是左
						if(barmatrj[0] == gsnmbarbean.barj - gsnmbarbean.barwide){
							curdir = 3;
						}
						break;
					// 当前是右 
					case 3:
						if(barmatrj[0] == gsnmbarbean.barj){
							curdir = 2;
						}
						break;
				}
			break;
			case 3:
				// 原本是右方向 但是当前方向有左右可选
				switch (curdir) {
					// 当前是左
					case 2:
						// 以第一行为界限
						if(barmatrj[0] == gsnmbarbean.barj){
							curdir = 3;
						}
						break;
					case 3:
						// 当前是右  最下面为界限
						if(barmatrj[widthindex] == gsnmbarbean.barj + widthindex + gsnmbarbean.barwide){
							curdir = 2;
						}
						break;
				}
			break;			
		}
	}
	// 判断当前的ij是不是自己当前占据的
	public boolean isMeByIJ(int ii, int jj){
		for(int i = 0; i < gsnmbarbean.barheight; i++){
			for(int j = 0; j < gsnmbarbean.barwidth; j++){
				if(barmatri[i] == ii && barmatrj[j] == jj){
					return true;
				}
			}
		}
		return false;//返回空
	}
	// 更新动态地图值，它的范围是0 并且没有墙的情况下
	public void updateMapValue(){
		// 当前占据的就是56
		for(int i = 0; i < gsnmbarbean.barheight; i++){
			for(int j = 0; j < gsnmbarbean.barwidth; j++){
				GsnMainGameConstants.dynamicmapdata[barmatri[i]][barmatrj[j]] = 56;
			}
		}
	}
	public void startMove(){
		isRun = true;// 开始线程
	}
	public void endMove(){
		isRun = false;// 开始线程
	}
	public void endThread(){// 退出
		controlRun = false;
		isRun = false;
//		stop();
	}
	// 绘画可以画很多形状
	Color yuan;
	public void draw(Graphics g){
		if(isChoose){
			yuan = g.getColor();
		}
		// 开始绘画
		for(int i = 0; i < gsnmbarbean.barheight; i++){
			for(int j = 0; j < gsnmbarbean.barwidth; j++){
				if(isChoose){
					g.setColor(new Color(255,0,0));
				}
				if(gamepanel != null){
					if(GsnMainGameConstants.drawSize == 10){
						g.drawImage(GsnMainGameConstants.imgresourceten[1], barmatrj[j] * GsnMainGameConstants.drawSize, barmatri[i] * GsnMainGameConstants.drawSize, gamepanel);
					}else{
						g.drawImage(GsnMainGameConstants.imgresourcefive[1], barmatrj[j] * GsnMainGameConstants.drawSize, barmatri[i] * GsnMainGameConstants.drawSize, gamepanel);	
					}
				}else if(editmapgamepanel != null){
					if(GsnMainGameConstants.drawSize == 10){
						g.drawImage(GsnMainGameConstants.imgresourceten[1], barmatrj[j] * GsnMainGameConstants.drawSize, barmatri[i] * GsnMainGameConstants.drawSize, gamepanel);
					}else{
						g.drawImage(GsnMainGameConstants.imgresourcefive[1], barmatrj[j] * GsnMainGameConstants.drawSize, barmatri[i] * GsnMainGameConstants.drawSize, gamepanel);	
					}
				}
//				g.fillRect(barmatrj[j] * GsnMainGameConstants.drawSize, barmatri[i] * GsnMainGameConstants.drawSize, GsnMainGameConstants.drawSize, GsnMainGameConstants.drawSize);
			}
		}
		if(isChoose){
			g.setColor(yuan);
		}
	}
	@Override
	public void run() {
		while(controlRun){
			System.out.print("");
			if(isRun && gsnmbarbean.barwide != 0){// 范围不能为0 不然一直走
				try {
					Thread.sleep(gsnmbarbean.barspeed);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// 是为了让地图值为1 碰到了会死。可以把值改变一下 移动后再设置吧
				if(isRun){
					move();
					updateMapValue();// 放着可能会卡
				}
			}
		}
//		System.out.println("障碍物停止！！！！！！！！！！！！");
	}
}

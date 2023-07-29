package com.snake.mgameconfig;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;

import com.snake.bean.GsnMapBean;
import com.snake.bean.GsnMapSnakeBean;
import com.snake.bean.GsnRankBean;

public class GsnMainGameConstants {
	public static GsnMapBean gsngamemap[];// 所有关卡属性对象
	public static GsnMapSnakeBean[] yuanshisnakebean = new GsnMapSnakeBean[2];// 原始蛇的信息
	public static GsnMapSnakeBean[] dynamicsnakebean = new GsnMapSnakeBean[2];// 动态蛇的信息
	public static byte yuanshimapdata[][] = new byte[41][60];// 当前游戏地图数据
	public static byte dynamicmapdata[][] = new byte[41][60];// 动态游戏地图数据
	// 当前关卡等级
	public static int currLevel = 1;
	// 当前游戏模式
	public static int gamemode;// 1单人，2双人，3vsc
	
	// 电脑数量多少个
	public static int snakecomputercount = 1;// 默认一条
	
	// 游戏面板最多的食物数量
	public static int Maxfoodlength = 20;
	// 游戏面板最多的障碍物数量
	public static int MaxBarlength = 20;	
	
	// 游戏面板绘画图形的大小 默认10，可以改变
	public static int drawSize = 10;
	
	// 蛇延迟多少s
	public static long SnakeMoveSpeedMin = 50;
	public static long SnakeMoveSpeedMax = 300;
	public static long SnakePreviewMoveSpeed = 200;// 编辑地图测试时候的初始速度
	// 每次加减速度减多少
	public static long SnakeChangeSpeedUp = 50;
	public static long SnakeChangeSpeedCut = 100;
	
	// 单人模式下最低延迟
	public static long SnakeSinMoveSpeedMin = 200;
	
	// 游戏关卡通过要多少分 
	public static int PASSLEVELNEEDSCORE = 400;
	
	// 蛇吃普通食物 加多少分
	public static int SNAKEEATFOODADDSCORE = 10;

	public static int getDrawSize() {
		return drawSize;
	}


	public static void setDrawSize(int drawSize) {
		GsnMainGameConstants.drawSize = drawSize;
	}
	
	// 设置当前地图值，为了预览地图 
	public static void setDynamicMapData(byte[][] news){
		for(int m = 0; m < 41; m++){
			// 深拷贝
			dynamicmapdata[m] = news[m].clone(); 
		}
	}
	// 排行榜
	public static GsnRankBean[] gsnrankbeanarr  = new GsnRankBean[0];
	
	// 穿越节点的开始和起止 测试
	public static int crossnodestart = 66;
	public static int crossnodeend = 74;
	
	// 穿越颜色
	public static Color[] crosscolor = {
			new Color(12,128,128),new Color(0,128,0),new Color(64,128,128),
			new Color(255,255,128),new Color(128,255,128),new Color(128,255,255),
			new Color(0,128,255),new Color(64,0,64),new Color(128,0,255),
			new Color(30,39,255),new Color(64,230,64),new Color(111,20,255),
			new Color(30,0,255),new Color(164,0,64),new Color(23,30,255),
			new Color(30,128,255),new Color(64,0,164),new Color(128,04,255)};
	
	// 蛇的颜色
	public static Color[] snakeColor = {new Color(255,87,90), new Color(83,183,31),  new Color(247,208,53), new Color(71,117,255)};
	
	// 图片资源
	static String imgpath = "img10";
	static String imgpathfive = "img5";
	// 中心面板的图片
    public static Image imgresourceten[]={new ImageIcon(imgpath+"/caodi.png").getImage(),
			new ImageIcon(imgpath+"/wall.png").getImage(),
			};
    public static Image imgresourcefive[]={new ImageIcon(imgpathfive+"/caodi.png").getImage(),
 			new ImageIcon(imgpathfive+"/wall.png").getImage(),
 			};
     
    // 4个方向
    public static Image snakeimgresourceten[][]={
    		{new ImageIcon(imgpath+"/00.png").getImage(),
			new ImageIcon(imgpath+"/01.png").getImage(),
			new ImageIcon(imgpath+"/02.png").getImage(),
			new ImageIcon(imgpath+"/03.png").getImage()},
    		{new ImageIcon(imgpath+"/10.png").getImage(),
				new ImageIcon(imgpath+"/11.png").getImage(),
				new ImageIcon(imgpath+"/12.png").getImage(),
				new ImageIcon(imgpath+"/13.png").getImage()},
    		{new ImageIcon(imgpath+"/20.png").getImage(),
					new ImageIcon(imgpath+"/21.png").getImage(),
					new ImageIcon(imgpath+"/22.png").getImage(),
					new ImageIcon(imgpath+"/23.png").getImage()},
    		{new ImageIcon(imgpath+"/30.png").getImage(),
						new ImageIcon(imgpath+"/31.png").getImage(),
						new ImageIcon(imgpath+"/32.png").getImage(),
						new ImageIcon(imgpath+"/33.png").getImage()},};
    public static Image snakeimgresourcefive[][]={
    		{new ImageIcon(imgpathfive+"/00.png").getImage(),
			new ImageIcon(imgpathfive+"/01.png").getImage(),
			new ImageIcon(imgpathfive+"/02.png").getImage(),
			new ImageIcon(imgpathfive+"/03.png").getImage()},
    		{new ImageIcon(imgpathfive+"/10.png").getImage(),
				new ImageIcon(imgpathfive+"/11.png").getImage(),
				new ImageIcon(imgpathfive+"/12.png").getImage(),
				new ImageIcon(imgpathfive+"/13.png").getImage()},
    		{new ImageIcon(imgpathfive+"/20.png").getImage(),
					new ImageIcon(imgpathfive+"/21.png").getImage(),
					new ImageIcon(imgpathfive+"/22.png").getImage(),
					new ImageIcon(imgpathfive+"/23.png").getImage()},
    		{new ImageIcon(imgpathfive+"/30.png").getImage(),
						new ImageIcon(imgpathfive+"/31.png").getImage(),
						new ImageIcon(imgpathfive+"/32.png").getImage(),
						new ImageIcon(imgpathfive+"/33.png").getImage()},};
}

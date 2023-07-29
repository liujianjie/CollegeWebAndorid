package com.snake.config;

// 界面面板的常量属性
public class GsnInterfaceParam {
	// 屏幕分辨率大小
	public static int allwidth;
	public static int allheight;
	// 高宽
	public static int INTERFACEWIDTH = 640;
	public static int INTERFACEHEIGHT = 480;
	
	// 主要游戏面板的大小
	public static int GAMEIWIDTH = 600;
	public static int GAMEIHEIGHT = 410;
	
	// 主要游戏面板预览的大小
	public static int GAMEPRIVEWIDTH = 300;
	public static int GAMEPRIVEHEIGHT = 205;
	
	// 主要游戏面板的分数统计
	public static int GAMESCOREWIDTH = 600;
	public static int GAMESCOREHEIGHT = 40;
	
	// 地图信息面板的大小
	public static int GAMEMAPINFOWIDTH = 300;
	public static int GAMEMAPINFOHEIGHT = 185;
	
	// 修改地图的右边面包大小
	public static int EDITMAPRIGHTPANELWIDTH = 260;
	public static int EDITMAPRIGHTPANELHEIGHT = 410;
	
	// 根据用户选取的大小进行修改
	public static void SetInterFaceValue(int inwidth, int inheight){
		INTERFACEWIDTH = inwidth;
		INTERFACEHEIGHT = inheight;
	}
	public static void SetGameValue(int gamewidht, int gameheight){
		GAMEIWIDTH = gamewidht;
		GAMEIHEIGHT = gameheight;
	}
	public static void SetGameScoreValue(int gswidth, int gsheight){
		GAMESCOREWIDTH = gswidth;
		gswidth = gsheight;
	}
}

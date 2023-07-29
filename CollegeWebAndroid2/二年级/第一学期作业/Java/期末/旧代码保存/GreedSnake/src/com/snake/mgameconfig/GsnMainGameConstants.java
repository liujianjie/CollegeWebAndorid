package com.snake.mgameconfig;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;

import com.snake.bean.GsnMapBean;
import com.snake.bean.GsnMapSnakeBean;
import com.snake.bean.GsnRankBean;

public class GsnMainGameConstants {
	public static GsnMapBean gsngamemap[];// ���йؿ����Զ���
	public static GsnMapSnakeBean[] yuanshisnakebean = new GsnMapSnakeBean[2];// ԭʼ�ߵ���Ϣ
	public static GsnMapSnakeBean[] dynamicsnakebean = new GsnMapSnakeBean[2];// ��̬�ߵ���Ϣ
	public static byte yuanshimapdata[][] = new byte[41][60];// ��ǰ��Ϸ��ͼ����
	public static byte dynamicmapdata[][] = new byte[41][60];// ��̬��Ϸ��ͼ����
	// ��ǰ�ؿ��ȼ�
	public static int currLevel = 1;
	// ��ǰ��Ϸģʽ
	public static int gamemode;// 1���ˣ�2˫�ˣ�3vsc
	
	// �����������ٸ�
	public static int snakecomputercount = 1;// Ĭ��һ��
	
	// ��Ϸ�������ʳ������
	public static int Maxfoodlength = 20;
	// ��Ϸ��������ϰ�������
	public static int MaxBarlength = 20;	
	
	// ��Ϸ���滭ͼ�εĴ�С Ĭ��10�����Ըı�
	public static int drawSize = 10;
	
	// ���ӳٶ���s
	public static long SnakeMoveSpeedMin = 50;
	public static long SnakeMoveSpeedMax = 300;
	public static long SnakePreviewMoveSpeed = 200;// �༭��ͼ����ʱ��ĳ�ʼ�ٶ�
	// ÿ�μӼ��ٶȼ�����
	public static long SnakeChangeSpeedUp = 50;
	public static long SnakeChangeSpeedCut = 100;
	
	// ����ģʽ������ӳ�
	public static long SnakeSinMoveSpeedMin = 200;
	
	// ��Ϸ�ؿ�ͨ��Ҫ���ٷ� 
	public static int PASSLEVELNEEDSCORE = 400;
	
	// �߳���ͨʳ�� �Ӷ��ٷ�
	public static int SNAKEEATFOODADDSCORE = 10;

	public static int getDrawSize() {
		return drawSize;
	}


	public static void setDrawSize(int drawSize) {
		GsnMainGameConstants.drawSize = drawSize;
	}
	
	// ���õ�ǰ��ͼֵ��Ϊ��Ԥ����ͼ 
	public static void setDynamicMapData(byte[][] news){
		for(int m = 0; m < 41; m++){
			// ���
			dynamicmapdata[m] = news[m].clone(); 
		}
	}
	// ���а�
	public static GsnRankBean[] gsnrankbeanarr  = new GsnRankBean[0];
	
	// ��Խ�ڵ�Ŀ�ʼ����ֹ ����
	public static int crossnodestart = 66;
	public static int crossnodeend = 74;
	
	// ��Խ��ɫ
	public static Color[] crosscolor = {
			new Color(12,128,128),new Color(0,128,0),new Color(64,128,128),
			new Color(255,255,128),new Color(128,255,128),new Color(128,255,255),
			new Color(0,128,255),new Color(64,0,64),new Color(128,0,255),
			new Color(30,39,255),new Color(64,230,64),new Color(111,20,255),
			new Color(30,0,255),new Color(164,0,64),new Color(23,30,255),
			new Color(30,128,255),new Color(64,0,164),new Color(128,04,255)};
	
	// �ߵ���ɫ
	public static Color[] snakeColor = {new Color(255,87,90), new Color(83,183,31),  new Color(247,208,53), new Color(71,117,255)};
	
	// ͼƬ��Դ
	static String imgpath = "img10";
	static String imgpathfive = "img5";
	// ��������ͼƬ
    public static Image imgresourceten[]={new ImageIcon(imgpath+"/caodi.png").getImage(),
			new ImageIcon(imgpath+"/wall.png").getImage(),
			};
    public static Image imgresourcefive[]={new ImageIcon(imgpathfive+"/caodi.png").getImage(),
 			new ImageIcon(imgpathfive+"/wall.png").getImage(),
 			};
     
    // 4������
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

package com.snake.config;

// �������ĳ�������
public class GsnInterfaceParam {
	// ��Ļ�ֱ��ʴ�С
	public static int allwidth;
	public static int allheight;
	// �߿�
	public static int INTERFACEWIDTH = 640;
	public static int INTERFACEHEIGHT = 480;
	
	// ��Ҫ��Ϸ���Ĵ�С
	public static int GAMEIWIDTH = 600;
	public static int GAMEIHEIGHT = 410;
	
	// ��Ҫ��Ϸ���Ԥ���Ĵ�С
	public static int GAMEPRIVEWIDTH = 300;
	public static int GAMEPRIVEHEIGHT = 205;
	
	// ��Ҫ��Ϸ���ķ���ͳ��
	public static int GAMESCOREWIDTH = 600;
	public static int GAMESCOREHEIGHT = 40;
	
	// ��ͼ��Ϣ���Ĵ�С
	public static int GAMEMAPINFOWIDTH = 300;
	public static int GAMEMAPINFOHEIGHT = 185;
	
	// �޸ĵ�ͼ���ұ������С
	public static int EDITMAPRIGHTPANELWIDTH = 260;
	public static int EDITMAPRIGHTPANELHEIGHT = 410;
	
	// �����û�ѡȡ�Ĵ�С�����޸�
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

package com.snake.computer;

import java.util.ArrayList;
import java.util.List;

import com.snake.mgame.GsnFood;
import com.snake.mgame.GsnMainGameJPanel;
import com.snake.mgame.GsnSnake;
import com.snake.mgameconfig.GsnMainGameConstants;

public class GsnSnakeComputerPlayer {
	// һֱ����
	boolean stillRun = true;
	boolean isRun = false;
	// ��ǰ״̬
	int curstate;
	
	// ���ݵ���
	public GsnSnake gsnake;
	
	// Ŀ��ʳ��
	GsnFood gsngoalfood;
	
	// ���
	GsnMainGameJPanel gsngamepanel;
	
	// BFs
	GsnSnakeBfs gsnsnakebfs;
	
	int dis[][];// ���鱣�沽��,���Ǳ��������ĸ���ͼ�±�i��j
	int vis[][];// ������¼map�Ƿ��߹������飬��Ϊ�߹��Ĳ�Ҫ���ߣ�����ѭ��
	int pre[];// ��һ����i
	int prechar[];// ��¼����ô�ߵ���������
	int fourdir[][] = { 
							{-1, 0},
							{1, 0},
							{0, -1},
							{0, 1}};//�ĸ������λ������ �����ֵ �� ������
	int fdir[] = { 0, 1, 2, 3 };// ��������˳��Ѱ�ң�Ҫ����һ����Ӧ�����Ҷ�Ӧplayerdirection��ͼƬ
	
	// ��List����·
	List<Integer> bfslist = new ArrayList<Integer>();
	
	MoveThread m;
	public GsnSnakeComputerPlayer(GsnSnake s, GsnMainGameJPanel gpanel){
		gsnake = s;
		
		gsngamepanel = gpanel;
		curstate = 0;// Ĭ���й�
		
		m = new MoveThread();
		m.start();
		
		gsnsnakebfs = new GsnSnakeBfs(this);
		
		// bfs
		dis = new int[100 * 100][2];
		vis = new int[41 + 2][60 + 2];// �Ŵ�һ�㣬+2
		pre = new int[100 * 100];
		prechar = new int[100 * 100];
		
		curgoalfood = new CurGoalFood();
		
	}
	// ������� Ϊ�� ���� ���� ����
	public void cleardata(){
		curstate = 0;
		
		// �������¼����ƶ��ķ�Χ
		gsnsnakebfs.calBarArea();
	}
	// �����߳�
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
	// ����Ŀ��ʳ������
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
	
	// ��Ҫһ����¼��ǰ���˶��ٲ���list��Ϊ���ƶ���ȷ��·�ߣ���ΪbfsѰ�ҵ�ʱ�򣬵�ǰ�����ƶ�������Ҫ��¼
	
	// ������bfsû���ȴ�ƶ��ˣ��Ͳ�Ҫ�ҵ�ǰ�ģ�
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
						if(curstate == 0){// 0���й�
							// ���ǰ�����ϰ��ﻻ�������жϻ������Ƿ�����Σ����
//							xianGuan();
							// �й��з���ʳ��λ��,Ҫ��ӽ��� 
							boolean isfound = foundIngFoodByDistance();
							if(isfound){
//								System.out.println("����ʳ��");
								curstate = 1;
								isbfs = true;
							}
						}
						else if(curstate == 1){// 1�Ƿ���ʳ����ƶ�·��
							// ���ǰ�����ϰ��ﻻ�������жϻ������Ƿ�����Σ����
//							xianGuan();
							// ��ǰ�Ѿ�����·�ߣ������ظ�
							if(isbfs){
//								System.out.println("bfs��ʼ����");
								// ���list ������Ϊ��bfs���ѡ���
								gsnsnakebfs.bfslist.clear();
								gsnsnakebfs.startCal();
								isbfs = false;
								bfsmovecount = 0;
							}
						}
						Thread.sleep(gsnake.snspeed);
						if(isRun){
//							System.out.println("------------��ʼ����"+gsnake.direction+"----------");
							// �������� �����ƶ���һ��λ��ʱbfs��������˾�ֱ���ó�����
							if(curstate == 2){// 2���ƶ�����·����·��
								// ��bfs��ʱ�� �Ƿ��������
								if(bfsmovecount == 0){
									// 1.��û�е���ʳ��λ�þͼ����ߣ�����ʳ��λ�þͻ�״̬0 �й�
									if(gsnsnakebfs.bfslist.size() != 0){
										int yuandir = gsnake.direction;
										gsnake.direction = gsnsnakebfs.bfslist.get(0);// ��ȡ��һ��
										gsnsnakebfs.bfslist.remove(0);//��ɾ��
										
										// Ϊ���жϵ�ǰ�����Ƿ��ײ��ǽ ҧ���Լ���ײ���ƶ��ϰ�����Ļ� �����ҹ�ʳ��
										
										// ���������⣬�Ҹı��˷����ȥ�����û��Σ�գ�������ȴû��ʵ���ƶ���ȴȥ���ı䷽���Σ�գ����У�Ҫ�ع�ԭ�������ٸı䷽��
										if(dirfromListIsDanger()){// ��ǰ�����Ƿ���Σ�գ���Ҫ��bfsû���ж�ҧ���Լ����жϣ���Ϊ̫�ѣ���ȡ������ʱ�����жϵĺ�
											// ���
											gsnake.direction = yuandir;
											System.out.println("��Ϊbfs�ķ���������������ԭ�������أ�"+yuandir);
//											System.out.println("���ϰ��������ǰ·�ߣ�����������������");
											// ��Σ�� ���Ҹı��˷��� ������ΪѰ��ʳ��״̬
											curstate = 0;
										}
										// �жϵ�ǰĿ��ʳ�� �Ƿ�ı�λ���ˣ����˾�������
										if(gsngoalfood.curCount != curgoalfood.curcount){
//											System.out.println("ʳ�ﻻλ���ˣ�������������");
											curstate = 0;
										}
										// ���³���ʳ���������ͷ�����ǰ·���������ƶ�
										if(foundNewFoodDistance(gsnsnakebfs.bfslist.size())){
											// �����ƶ�
//											System.out.println("����ָ����ʳ�� ֱ��1");
											curstate = 1;
											isbfs = true;
										}
									}else{
										curstate = 0;
									}
								}else{
									System.out.println("bfsʱ�ƶ���!!!!!!!!!!!!!!!!!!!!!!!!!!!");
									curstate = 0;// �����ҹ�
								}
							}
//							Thread.sleep(10);
							
							if(xianGuan()){
//								System.out.println("��Ŀ��ʱ��Σ�ոı��˷���"+gsnake.direction);
								curstate = 0;
							}
//							Thread.sleep(10);
							gsnake.move();// �ƶ�
							// ���ƶ���ȴ��û������bfs 
							if(iscalbfs){
								bfsmovecount++;
							}
							// ·��������
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
	// �й�����Լ�����ײǽ�� ҧ�Լ�
	public boolean xianGuan(){
		// ����ǰ��Σ�յ�������
		// 1.�ȷ���Σ��
		// 2.��û��Σ�յķ���
		int changepos[] = new int[2];
		switch (gsnake.direction) {
			case 0:
				changepos[0] = gsnake.snactuali[0] - 1;
				changepos[1] = gsnake.snactualj[0];
				changepos = CheckBorderChangePos(changepos[0],changepos[1]);
				if(GsnMainGameConstants.dynamicmapdata[changepos[0]][changepos[1]] == 1 || chagneDirIsBitself(changepos)
						|| GsnMainGameConstants.dynamicmapdata[changepos[0]][changepos[1]] == 56 ||
						gsnsnakebfs.isInMoveBarrierArea(changepos)){// ��Ҫ�����ϰ�������
					System.out.println("0��Σ��");
					FindNotDangerDir(0);	
					return true;// ��Σ��
				}
			break;
			case 1:
				changepos[0] = gsnake.snactuali[0] + 1;
				changepos[1] = gsnake.snactualj[0];
				changepos = CheckBorderChangePos(changepos[0],changepos[1]);
				if(GsnMainGameConstants.dynamicmapdata[changepos[0]][changepos[1]] == 1|| chagneDirIsBitself(changepos)
						|| GsnMainGameConstants.dynamicmapdata[changepos[0]][changepos[1]] == 56||
						gsnsnakebfs.isInMoveBarrierArea(changepos)){// ��Ҫ�����ϰ�������){
					System.out.println("1��Σ��");
					FindNotDangerDir(1);
					return true;// ��Σ��
				}
			break;
			case 2:
				changepos[0] = gsnake.snactuali[0];
				changepos[1] = gsnake.snactualj[0] - 1;
				changepos = CheckBorderChangePos(changepos[0],changepos[1]);
				if(GsnMainGameConstants.dynamicmapdata[changepos[0]][changepos[1]] == 1|| chagneDirIsBitself(changepos)
						|| GsnMainGameConstants.dynamicmapdata[changepos[0]][changepos[1]] == 56||
						gsnsnakebfs.isInMoveBarrierArea(changepos)){// ��Ҫ�����ϰ�������){
					System.out.println("2��Σ��");
					FindNotDangerDir(2);	
					return true;// ��Σ��
				}
			break;
			case 3:
				changepos[0] = gsnake.snactuali[0];
				changepos[1] = gsnake.snactualj[0] + 1;
				changepos = CheckBorderChangePos(changepos[0],changepos[1]);
				if(GsnMainGameConstants.dynamicmapdata[changepos[0]][changepos[1]] == 1|| chagneDirIsBitself(changepos)
						|| GsnMainGameConstants.dynamicmapdata[changepos[0]][changepos[1]] == 56||
						gsnsnakebfs.isInMoveBarrierArea(changepos)){// ��Ҫ�����ϰ�������){
					System.out.println("3��Σ��");
					FindNotDangerDir(3);
					return true;// 
				}
			break;			
		}
		return false;
	}
	// ��û�� Σ�յķ���仯
	public void FindNotDangerDir(int dir){
//		checkCurDirIsWall(dir);
		// ��Խ��ý��
		int changepos[] = new int[2];
		// 4���������
		for(int i = 0; i < 4; i++){
			if(i != dir){// ��ǰ�����ܼ�����ȥ
				// �ϲ�������
				if(i == 0 && dir != 1){
					System.out.println("���0����");
					changepos[0] = gsnake.snactuali[0] - 1;
					changepos[1] = gsnake.snactualj[0];
					changepos = CheckBorderChangePos(changepos[0],changepos[1]);
					if(GsnMainGameConstants.dynamicmapdata[changepos[0]][changepos[1]] != 1 && !chagneDirIsBitself(changepos)
							&& GsnMainGameConstants.dynamicmapdata[changepos[0]][changepos[1]] != 56 && 
							!gsnsnakebfs.isInMoveBarrierArea(changepos)){
						gsnake.direction = i;
						System.out.println("�ı䷽��"+i);
						return;
					}
				}else if(i == 1&& dir != 0){
					System.out.println("���1����");
					changepos[0] = gsnake.snactuali[0] + 1;
					changepos[1] = gsnake.snactualj[0];
					changepos = CheckBorderChangePos(changepos[0],changepos[1]);
					if(GsnMainGameConstants.dynamicmapdata[changepos[0]][changepos[1]] != 1 && !chagneDirIsBitself(changepos)
							&& GsnMainGameConstants.dynamicmapdata[changepos[0]][changepos[1]] != 56&& 
									!gsnsnakebfs.isInMoveBarrierArea(changepos)){
						gsnake.direction = i;	
						System.out.println("�ı䷽��"+i);
						return;
					}
				}else if(i == 2&& dir != 3){
					System.out.println("���2����");
					changepos[0] = gsnake.snactuali[0];
					changepos[1] = gsnake.snactualj[0] - 1;
					changepos = CheckBorderChangePos(changepos[0],changepos[1]);
					if(GsnMainGameConstants.dynamicmapdata[changepos[0]][changepos[1]] != 1 && !chagneDirIsBitself(changepos)
							&& GsnMainGameConstants.dynamicmapdata[changepos[0]][changepos[1]] != 56&& 
									!gsnsnakebfs.isInMoveBarrierArea(changepos)){
						gsnake.direction = i;	
						System.out.println("�ı䷽��"+i);
						return;
					}
				}else if(i == 3&& dir != 2){
					System.out.println("���3����");
					changepos[0] = gsnake.snactuali[0];
					changepos[1] = gsnake.snactualj[0] + 1;
					changepos = CheckBorderChangePos(changepos[0],changepos[1]);
					if(GsnMainGameConstants.dynamicmapdata[changepos[0]][changepos[1]] != 1 && !chagneDirIsBitself(changepos)
							&& GsnMainGameConstants.dynamicmapdata[changepos[0]][changepos[1]] != 56&& 
									!gsnsnakebfs.isInMoveBarrierArea(changepos)){
						gsnake.direction = i;	
						System.out.println("�ı䷽��"+i);
						return;
					}
				}
			}
		}
	}
	// ��bfs�ж�ȡ�ķ����Ƿ���Σ��
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
					System.out.println("bfs0��Σ��");
					return true;// ��Σ��
				}
			break;
			case 1:
				changepos[0] = gsnake.snactuali[0] + 1;
				changepos[1] = gsnake.snactualj[0];
				changepos = CheckBorderChangePos(changepos[0],changepos[1]);
//				if(GsnMainGameConstants.dynamicmapdata[changepos[0]][changepos[1]] == 1|| chagneDirIsBitself(changepos)
//						|| GsnMainGameConstants.dynamicmapdata[changepos[0]][changepos[1]] == 56){
					if(chagneDirIsBitself(changepos) || gsnsnakebfs.isInMoveBarrierArea(changepos)){
					System.out.println("bfs1��Σ��");
					return true;// ��Σ��
				}
			break;
			case 2:
				changepos[0] = gsnake.snactuali[0];
				changepos[1] = gsnake.snactualj[0] - 1;
				changepos = CheckBorderChangePos(changepos[0],changepos[1]);
//				if(GsnMainGameConstants.dynamicmapdata[changepos[0]][changepos[1]] == 1|| chagneDirIsBitself(changepos)
//						|| GsnMainGameConstants.dynamicmapdata[changepos[0]][changepos[1]] == 56){
					if(chagneDirIsBitself(changepos) || gsnsnakebfs.isInMoveBarrierArea(changepos)){
					System.out.println("bfs2��Σ��");
					return true;// ��Σ��
				}
			break;
			case 3:
				changepos[0] = gsnake.snactuali[0];
				changepos[1] = gsnake.snactualj[0] + 1;
				changepos = CheckBorderChangePos(changepos[0],changepos[1]);
//				if(GsnMainGameConstants.dynamicmapdata[changepos[0]][changepos[1]] == 1|| chagneDirIsBitself(changepos)
//						|| GsnMainGameConstants.dynamicmapdata[changepos[0]][changepos[1]] == 56){
				if(chagneDirIsBitself(changepos) || gsnsnakebfs.isInMoveBarrierArea(changepos)){
					System.out.println("bfs3��Σ��");
					return true;// 
				}
			break;			
		}
		return false;
	}
	// �Ƿ�Խ�� ���ض�Ӧ��Խ��λ��
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
	// �ı�ķ����Ƿ��ҧ���Լ� true��ҧ�Լ�
	public boolean chagneDirIsBitself(int headpos[]){
		for(int i = 1; i < gsnake.node; i++ ){
			// ������ ������ ���ﾹȻ д�� �� headpos[1]д�� headpos[0]
			if(gsnake.snactuali[i] == headpos[0] && gsnake.snactualj[i] == headpos[1]){
//				System.out.println("��ҧ���Լ�");
				return true;
			}
		}
		return false;
	}
	// ����ÿ��ʳ�����Լ����� ���� ij
	public boolean foundIngFoodByDistance(){
		boolean isfound = false;
		int mindist = 1 << 30;
		GsnFood gsnf;
		for(int i = 0; i < gsngamepanel.MainGamefoodlength; i++){
			gsnf = gsngamepanel.gsnfood[i];
			int mid = Math.abs(gsnake.snactuali[0] - gsnf.curi) +  Math.abs(gsnake.snactualj[0] - gsnf.curj);
			if(mindist > mid){
				gsngoalfood = gsnf; // Ŀ��ʳ��
				mindist = mid;
				isfound = true;
				// ���õ�ǰĿ��ʳ��
				curgoalfood.setValue(gsngoalfood);
			}
		}
		return isfound;
	}
	// �³�ʳ���ж�
	public boolean foundNewFoodDistance(int yuanshidis){// ���뵱ǰ�ж��ٴ�С���Ǿ����Զ
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
					gsngoalfood = gsnf; // Ŀ��ʳ��
					// ���õ�ǰĿ��ʳ��
					curgoalfood.setValue(gsngoalfood);
				}
			}
		}
		return isfoundnew;
	}
}

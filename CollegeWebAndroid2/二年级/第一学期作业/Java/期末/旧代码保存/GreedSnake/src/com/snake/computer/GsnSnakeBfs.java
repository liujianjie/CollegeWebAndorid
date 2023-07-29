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

// ���Ե�bfs����
public class GsnSnakeBfs {
	// �Ƿ����߳�
	public boolean stillRun = true;
	public boolean isRun = false;
	
	public void startCal(){
		isRun = true;
	}
	public void stopCal(){
		isRun = false;
	}
	// bfs��
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
	
	// ���ĸ�������ĸ���
	GsnSnakeComputerPlayer gsncomputer;
	
	CalThread calth;
	public GsnSnakeBfs(GsnSnakeComputerPlayer gsncs){
		gsncomputer = gsncs;
		// bfs
		dis = new int[100 * 50][2];
		vis = new int[41 + 2][60 + 2];// �Ŵ�һ�㣬+2
		pre = new int[100 * 100];
		prechar = new int[100 * 100];
		
		calth = new CalThread();
		calth.start();
		
		gsnsnakeandfoodcopy = new curCalSankeAndFood();
	}
	
	List<int[]> barlefttoplist = new ArrayList<int[]>(); 
	List<int[]> barrightbottomlist = new ArrayList<int[]>(); 
	// �����ƶ��ϰ��ķ�Χ��Ϊ��bfs��ʡʱ��
	public void calBarArea(){
		// ���壬ÿ�ιؿ���ʱ����Ҫ
		barlefttoplist.clear();
		barrightbottomlist.clear();
		
		GsnMainGameMoveBarrier gsnm;
		// �������Ϻ����� �������Χ�Ͳ�Ҫ��
		int topleft[] = new int[2];
		int bottomright[] = new int[2];
		for(int i = 0; i < gsncomputer.gsngamepanel.gsnmgmbarlis.size(); i++){
			// �÷��������½�����Ȼ�������ã������һ��Ϊ��
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
		int foodcount;// ���ʳ��ĸ��¶��ٸ�
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
		// ��ʼbfs��ʱ�� ����Ŀ�� �� �� ʳ��
		gsnsnakeandfoodcopy.setValue(gsncomputer.gsnake, gsncomputer.gsngoalfood);
		// ��Ҫ��ʼֵ ��û���߹���
		vis = new int[41 + 2][60 + 2];// �Ŵ�һ�㣬+2 ���½��ڴ���죬����ѭ������0���졣���� �½��ڴ����ɣ���Ϊ�ڴ滻ʱ��
		int ns[] = new int[2];
		int head = 0;
		int tail = 1;
		// �ߵ�λ��
		dis[0][0] = gsnsnakeandfoodcopy.snakeheadi;
		dis[0][1] = gsnsnakeandfoodcopy.snakeheadj;
		int x, y, i;
		int xx, yy;// ��ɢ�Ĳ�
		
		while (head < tail) {// �Ҳ����˵�
			// Խ�� �Ҳ���
			if(head > dis.length){
				break;
			}
			x = dis[head][0];// ��
			y = dis[head][1];// ��
			
			if(x == gsnsnakeandfoodcopy.foodi && y == gsnsnakeandfoodcopy.foodj){
				print(head);
				return true;
			}
			// ��4��������ɢ
			for (i = 0; i < 4; i++) {
				// ���ܵ��������ǵ�ʱ��λ������Ƿ���0 ���� 1 ��2 ����3 �෴Ҳ��,��������� ������ٶȰɣ�
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
				// �����߽�ֵ
				if(xx > 40){// ��ⳬ���߽��Ҫ��1
					xx = 0;
				}else if(xx < 0){// Ҫ���� 0 
					xx = 40;//  
				}
				// ����0~59
				if(yy > 59){// ��ⳬ���߽��Ҫ��1
					yy = 0;
				}else if(yy < 0){// Ҫ���� 0 
					yy = 59;// 
				}
				ns[0] = xx;
				ns[1] = yy;
				// ������Խ��ֵ
				checkCrossNode(ns);
				xx = ns[0];
				yy = ns[1];
				
				// ����ҧ�Լ���ֻ�ǳ�ʼ״̬�������жϸ���ͷ��Ǩ�ƶ��жϡ���
				if(chagneDirIsBitself(ns)){
					continue;
				}
				
				// ��Ҫ���ƶ��ϰ���Χ
				if(isInMoveBarrierArea(ns)){
					continue;
				}
				
				// û���߹�
				// ������ǽ��λ�� ����0ƽ�أ����ڻ���
				if (vis[xx][yy] == 0 && 
						(GsnMainGameConstants.dynamicmapdata[xx][yy] == 0)
						) {
						// ��¼�߹����´��Ǵ�dis�л�ȡ���xx��yy��4��������ɢ ���ܻ�ȥx ��y
						vis[xx][yy] = 1;
						// ��¼�²���
						dis[tail][0] = xx;
						dis[tail][1] = yy;
						// ���ϼ�¼���� ����һ��ָ��ָ��head��¼�Ǵ��ĸ�head��ɢ��
						pre[tail] = head;
						prechar[tail] = fdir[i];// ��¼�����������ĸ�����
						// ��βָ���ϵ�
						tail++;
				}
			}
			head++;
		}
		return false;
	}
	// ��ӡ��¼�ķ���
	public  void print(int t) {
		int last = pre[t];
		if (last == 0) {// ����
			bfslist.add(prechar[t]);//			System.out.print(prechar[t]);
			return;
		} else {
			print(last);// ����
		}
		// ����ʱ��洢
		bfslist.add(prechar[t]);//		System.out.print(prechar[t]);
	}
	// ���߽�λ��, Խ���˾ͷ���false
	public boolean CheckBorder(int xx, int yy){
		return !(xx < 0 || xx > 40 || yy < 0 || yy > 59);
	}
	// ������Խ��ֵ
	public void checkCrossNode(int ns[]){
		GsnMapCrossNodeBean cs;
		for(int i = 0; i < gsncomputer.gsngamepanel.gsnmgmcrossnodelis.size(); i++){
			// ��Ϊ��
			if(gsncomputer.gsngamepanel.gsnmgmcrossnodelis.get(i) != null){
				//
				cs = gsncomputer.gsngamepanel.gsnmgmcrossnodelis.get(i).gsncnbean;
				// �����ڵ�
				// ������һ��
				if(cs.firstpos[0] == ns[0] && cs.firstpos[1] == ns[1]){
					ns[0] = cs.secondpos[0];
					ns[1] = cs.secondpos[1];
					return;
				}
				// �����ڶ���
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
//				System.out.println("��ҧ���Լ�");
				return true;
			}
		}
		return false;
	}
	// ��Ҫ·���ϰ��ﷶΧ�ѣ��򵥵��ж� ����ʵʱ��
	// ̫�鷳�ˣ����ж��ƶ��ϰ��ķ���Ȼ��õ��ƶ���Χ����Ҫ�� �е��鷳���÷�ΧҲ����
	public boolean isInMoveBarrierArea(int headpos[]){
		int topleft[] = new int[2];
		int bottomright[] = new int[2];
		for(int i = 0; i < barlefttoplist.size(); i++){
			topleft = barlefttoplist.get(i);
			bottomright = barrightbottomlist.get(i);
			if(topleft[0] <= headpos[0] && topleft[1]  <= headpos[1] &&
					bottomright[0] >= headpos[0] && bottomright[1] >= headpos[1]){
//				System.out.println("���ƶ���Χ�� ��Ҫȥ");
				return true;
			}
		}
		return false;
	}
	// �̼߳���
	class CalThread extends Thread{
		@Override
		public void run() {
			while(stillRun){
				System.out.print("");
				if(isRun){
					// ���ҵ�ʱ�� Ϊtrue
					gsncomputer.iscalbfs = true;
					boolean isok = bfs();
					// �ҵ���
					if(isok){
//						System.out.println("�ҵ�·��");
						gsncomputer.curstate = 2;
					}else{
//						System.out.println("û�ҵ�·��");
						gsncomputer.curstate = 0;
					}
					isRun = false;// ������
					gsncomputer.iscalbfs = false;// ������
//					System.out.println("bfs��������");
				}
			}
		}
	}
}

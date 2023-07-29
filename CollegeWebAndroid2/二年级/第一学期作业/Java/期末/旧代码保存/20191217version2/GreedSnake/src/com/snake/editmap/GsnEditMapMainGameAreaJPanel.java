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

// ��Ҫ��Ϸ��壬��GsnCenterInterface�������
public class GsnEditMapMainGameAreaJPanel extends JPanel{
	// �޸ĵ�ͼ����
	public GsnEditmapInterface gsneminter;// ����ʵʩ����
	
	// ����jpanel��
	// ���ֻ��Ϊ��Ԥ����ʱ�����ã�����ʱ�򶼲���
	GsnSnake gsnsnake[];
	// ʳ����Զ�һ��
	int MainGamefoodlength = 2;// ����ʳ��������������¹ؿ���ʱ��Ż滭 Ĭ��2��
	public GsnFood gsnfood[];
	// �Ƿ����У�һ��ʼΪԤ��
	boolean isPlay;
	// �Ƿ� ���»滭
	boolean isRepeatPaintBar;
	
	// �ϰ���
	// ���б�����
	List<GsnMainGameMoveBarrier> gsnmgmbarlis;
//	GsnMainGameMoveBarrier2 gsnmgmbar[];
	int MainGameMoveBarrierlength;// �ϰ��ﳤ��
	
	// ��Խ�ڵ��б�
	public List<GsnCrossNodeDraw> gsnmgmcrossnodelis;
	public int crossnodelength;// 
	
	// Ŀǰ���ڻ滭�ĵ�ͼ
	public byte [][] currmapdata = new byte[41][60];
	public boolean ischoose;// �Ƿ�ѡ��������
	
	// �滭��λ
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
		// width��height��Ҫ��1��Ϊ �滭�ľ���ռ����
		this.setSize(new Dimension(GsnInterfaceParam.GAMEIWIDTH + 1,GsnInterfaceParam.GAMEIHEIGHT + 1));
		// �����¼�
		this.addKeyListener(new GsnMainGameKeyLis());
		// ����¼� Ϊ��Ԥѡ
		GsnEditMapMainGameMouseLis gsn = new GsnEditMapMainGameMouseLis();
		// ��갴��
		this.addMouseListener(gsn);
		// ����ƶ�
		this.addMouseMotionListener(gsn);
		
	}
	public void commonWayOfStartAndView(){
		// ����ת�عؿ�
		initGame();
		// �߳�ʼλ��
		setRunSnakePos();
		// ʳ��
		initFoodInfo();
		// �ϰ���
		initBarInfo();
		// ��Խ
		initCrossNodeList();
	}
	// ���ô�С
	public void setnewSize(int width, int height){
		this.setSize(new Dimension(width, height));
		this.repaint();
	}
	// �����ԭ����λ�� Ϊ�˸���
	public void deleteSnakeYuanZhi(int player){
		for(int j = 0; j < gsnsnake[player].node; j++){
			if(gsneminter.gsneditmapbean.mapdata[gsnsnake[player].snactuali[j]][gsnsnake[player].snactualj[j]] != 0){// 2Ϊplayer1 3 Ϊpalyer2){
				gsneminter.gsneditmapbean.mapdata[gsnsnake[player].snactuali[j]][gsnsnake[player].snactualj[j]] = 0;
			}
		}
	}
	
	// ���� ��������ߵ�λ�� �����õ�ͼֵ
	public void fromSnakePosSetVal(){
		// ����
		for(int i = 0; i < gsnsnake.length; i++){
			// �����߽�
			for(int j = 0; j < gsnsnake[i].node; j++){
				gsneminter.gsneditmapbean.mapdata[gsneminter.gsneditmapbean.gsmsnakebean[i].snmapi[j]][gsneminter.gsneditmapbean.gsmsnakebean[i].snmapj[j]] = (byte)(i + 2);// 2Ϊplayer1 3 Ϊpalyer2
			}
		}
		// ����һ��
		gsneminter.copyOneMapData();
		// ����curr
		initMapData();
	}
	// ����  Ϊ����ʱ��ĳ�ʼλ�ã�����editmap����bean
	public void setRunSnakePos(){
		gsnsnake[0].InitBySnakeBean(gsneminter.gsneditmapbean.gsmsnakebean[0]);
		gsnsnake[1].InitBySnakeBean(gsneminter.gsneditmapbean.gsmsnakebean[1]);
	}
	// �����߿ռ�
	public void firststart(){
		gsnsnake = new GsnSnake[2];
		for(int i = 0 ; i < gsnsnake.length; i++){
			// �����߳�ʼ��Ϣ
			gsnsnake[i] = new GsnSnake(this,i + 1);
			gsnsnake[i].start();// �����߳�
		}
	}
	// ��ͼֵ
	public void initMapData(){
		// ��ͼ ��Ϣ
		for(int m = 0; m < 41; m++){
			// ���
			currmapdata[m] = gsneminter.gsneditmapbean.mapdata[m].clone(); 
		}
	}
	// ��ʼ�� ��ͼ �� �ߵ���Ϣ
	public void initGame(){
		// ���߳�ʼ��Ϣ
		setRunSnakePos();
		// ��ͼ
		initMapData();
	}
	// ������ʱ��
	public void initFoodInfo(){
		// ��֪��ÿ�δ򿪹ؿ��ʹ����̶߳��������᲻����ɺܶ��ڴ�ռ�ã���������������������������������������
		// ����2 ��ʳ��ȴ�����ʱ ��maingamefoodelength�������ٸ���������
		gsnfood = new GsnFood[MainGamefoodlength];
		for(int i = 0 ; i < gsnfood.length; i++){
			gsnfood[i] = new GsnFood();
			gsnfood[i].start();
			gsnfood[i].deadUpdate();// ����ʳ�� ��Ϊ�ȵ�ͼ������ʱ������ж��Ƿ�������ϰ����С�
		}
	}
	public void initBarInfo(){
		// ����list����
		MainGameMoveBarrierlength = gsneminter.gsneditmapbean.gsminfobean.barcount;
		gsnmgmbarlis = new ArrayList<GsnMainGameMoveBarrier>(MainGameMoveBarrierlength);
		for(int i = 0 ; i < MainGameMoveBarrierlength; i++){
			GsnMainGameMoveBarrier gsnmgmb = new GsnMainGameMoveBarrier();
			gsnmgmb.init(gsneminter.gsneditmapbean.gsmbmbean[i]);
			gsnmgmb.start();
			gsnmgmbarlis.add(gsnmgmb);
		}
	}
	// ��list���һ���ƶ��ϰ���  ���ò�������������
	public void addOneBarTolist(GsnMapBarrierMoveBean bean){
		GsnMainGameMoveBarrier gsnmgmb = new GsnMainGameMoveBarrier();
		gsnmgmb.init(bean);
		gsnmgmb.start();
		gsnmgmbarlis.add(gsnmgmb);
		gsnmgmb.startMove();// ��ʼ�ƶ�
	}
	// �����±���ͣ ���һָ�ԭ��λ�ã�
	public void setPauseOrRun(int index, boolean bln){
		// ��ʱ���ɾ��
		if(gsnmgmbarlis.get(index) != null){
			// ��Ҫ�ص����λ��
			gsnmgmbarlis.get(index).init(gsnmgmbarlis.get(index).gsnmbarbean);// �Լ���ʼ���Լ�
			gsnmgmbarlis.get(index).isRun = bln;
		}
	}
	// �����±���������ɫ ��ʼ Ҳ��Ҫ�ָ� ��ȡ����ʱ��
	public void setisDrawColorForBar(int index, boolean bln){
		// ��ʱ���ɾ��
		// ��ʱ����Ϊ��һ�������±�ģ����������޸ĵ�ʱ���ٽ�������������Ҫ��ʼֵ ������Ҳ�ж��°�
		if(index < gsnmgmbarlis.size()){
			if(gsnmgmbarlis.get(index) != null){
				gsnmgmbarlis.get(index).isChoose = bln;
			}
		}
		
	}
	// �����±��޸�
	public void alterOneBarList(GsnMapBarrierMoveBean bean, int index){
		GsnMainGameMoveBarrier gsn = gsnmgmbarlis.get(index);
		// �ж��ǲ��� �Ѿ���ɾ���� �Ǿ�����µ�
		if(gsn == null){
			gsn = new GsnMainGameMoveBarrier();
			gsnmgmbarlis.remove(index);
			gsn.init(bean);
			gsn.start();
			gsn.startMove();
			// Ҫ����ѡ��
			gsn.isChoose = true;
			gsnmgmbarlis.add(index, gsn);
		}else{
			gsn.init(bean);// ��ʼ��
		}
	}
	// ��listɾ�� Ҳ����ɾ������Ϊnull ������ֹͣ��Ȼ�����null
	public void giveNullBarTolist(int index){
		// ����Ѿ��ǿյľͲ��ò�����
		if(gsnmgmbarlis.get(index) != null){
			gsnmgmbarlis.get(index).endThread();
			gsnmgmbarlis.remove(index);
			// �ټӣ�
			gsnmgmbarlis.add(index,  null);
		}
//		System.out.println(gsnmgmbarlis.size());
	}
	// �жϵ�ǰ�±��Ƿ�Ϊnull
	public boolean isNullOfBarListByindex(int index){
		if(gsnmgmbarlis.get(index) == null){
			return true;
		}
		return false;
	}
	// �����±������ϰ����ƶ�
	public void setBarOneMoveByIndex(int index){
		// ��bug ֱ��
		if(index < gsnmgmbarlis.size()){
			if(gsnmgmbarlis.get(index) != null){
				gsnmgmbarlis.get(index).startMove();
			}
		}
	}
	// ��ȡlist�Ľڵ�
	public GsnMainGameMoveBarrier getNodeByIndexOfBarList(int index){
		if(index < 0){
			return null;
		}
		return gsnmgmbarlis.get(index);
	}
	// ����list ���������е��ϰ��ﲢ�ж��Ƿ�ѡ��������ϰ���
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
	// ȫ������ѡ
	public void allBarCancelChoose(){
		for(int i = 0 ; i < MainGameMoveBarrierlength; i++){
			if(gsnmgmbarlis.get(i) != null){
				gsnmgmbarlis.get(i).isChoose = false;
			}
		}
	}
	// ȫ������
	public void allBarlisRun(){
		// ����Ҫ��Ҫ���»滭 
		gsneminter.gsnedmmgajpanel.isRepeatPaintBar = true;
		for(int i = 0 ; i < MainGameMoveBarrierlength; i++){
			if(gsnmgmbarlis.get(i) != null){
				// ��ʼ�ƶ�
				gsnmgmbarlis.get(i).init(gsnmgmbarlis.get(i).gsnmbarbean);
				gsnmgmbarlis.get(i).startMove();
				// ��ôҲ��ѡ����
//				gsnmgmbarlis.get(i).isChoose = false;
			}
		}
		gsneminter.gsnedmmgajpanel.repaint();
	}
	// ȫ����ͣ
	public void allBarlisPause(){
		// ����һ
		gsneminter.gsnedmmgajpanel.isRepeatPaintBar = false;
		for(int i = 0 ; i < MainGameMoveBarrierlength; i++){
			if(gsnmgmbarlis.get(i) != null){
				// Ҫ��ȫ���ָ�ԭ��λ�õ���?
				gsnmgmbarlis.get(i).init(gsnmgmbarlis.get(i).gsnmbarbean);
				gsnmgmbarlis.get(i).endMove();
			}
		}
		gsneminter.gsnedmmgajpanel.repaint();
	}
	// ȫ��ɾ��
	public void allBarlisDelete(){
		// ����һ
		gsneminter.gsnedmmgajpanel.isRepeatPaintBar = false;
		for(int i = 0 ; i < MainGameMoveBarrierlength; i++){
			if(gsnmgmbarlis.get(i) != null){
				giveNullBarTolist(i);
			}
		}
	}
	// ����GsnMainGameMoveBarrier2 �ж��Լ����±�
	public int findBarlistIndexBy(GsnMainGameMoveBarrier g){
		return gsnmgmbarlis.indexOf(g);
	}
	// ��Ѱ����Ϊ��ֵ���ϰ�������
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
			gsnsnake[1].startMove();// ģʽ2 3 �ſ�ʼ
		}
		for(int i = 0 ; i < MainGamefoodlength; i++){
			gsnfood[i].startUpdate();// ��ʼ����
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
	// �����߳�
	public void endThread(){
		// �ߵ��̲߳�Ҫ���� ��Ϊ����ѡ�ؿ�û�и����µĶ��� ֹֻͣ�Ϳ���
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
	// ��Ϸ��ض���------------
	// ��������ײ ��ͷ��ײ3 ��2ҧ��1 return1 ����1ҧ��2 return2��û��ײ 0
	public void checkCCAnother(){
		if(gsnsnake[0].snactuali[0] == gsnsnake[1].snactuali[0] &&
				gsnsnake[0].snactualj[0] == gsnsnake[1].snactualj[0]){
			
			// ����
			gsnsnake[0].cutHalfOfNode();
			gsnsnake[1].cutHalfOfNode();
			// ����
			gsnsnake[0].cutDownScore();
			gsnsnake[1].cutDownScore();
			// ����
			gsnsnake[0].relive();
			gsnsnake[1].relive();
			
			gsnsnake[0].cutSpeed();
			gsnsnake[1].cutSpeed();
		}
		// ��2��ʼ ��Ȼ 1���߽ں��ѿ�
		for(int i = 2; i < gsnsnake[0].node; i++){
			if(gsnsnake[0].snactuali[i] == gsnsnake[1].snactuali[0] &&
					gsnsnake[0].snactualj[i] == gsnsnake[1].snactualj[0]){
				// ��2����ͷҧ����1������1
				// ����
				gsnsnake[0].node = i;
				// ����
				gsnsnake[0].cutDownScore();
				gsnsnake[0].cutSpeed();
				gsnsnake[1].cutSpeed();
			}
		}
		for(int i = 2 ; i < gsnsnake[1].node; i++){
			if(gsnsnake[1].snactuali[i] == gsnsnake[0].snactuali[0] &&
					gsnsnake[1].snactualj[i] == gsnsnake[0].snactualj[0]){
				// ��1����ͷҧ����2������2
				// ����
				gsnsnake[1].node = i;
				// ����
				gsnsnake[1].cutDownScore();
				gsnsnake[0].cutSpeed();
				gsnsnake[1].cutSpeed();
			}
		}
	}
	// �϶��� player�϶��İ�,��ǰ�϶��ߵ���ͷ �����κ�һ�������߾Ͳ�Ҫ������ȥ
	public boolean isTouchOtherSnake(int player, int ai[],int aj[]){
		// ������
		for(int j = 0; j < gsnsnake.length; j++){
			if(j != player){
				// �κ�һ���ڵ㲻���غ�
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
	// �Ƿ����ǽ
	public boolean isHaveWall(int ai[],int aj[]){
		for(int i = 0; i < ai.length; i++){
			if(gsneminter.gsneditmapbean.mapdata[ai[i]][aj[i]] == 1){
				return true;
			}
		}
		return false;
	}
	// ���ݵ�ǰ��������߽�
	public void dragSnakePos(int player,int headi, int headj, int dir){
		int ai[] = new int[2];
		int aj[] = new int[2];
		// �ȱ���
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
		// �ж��Ƿ�Խ��
		if(ai[0] < 0 || ai[0] > 40 || ai[1] < 0 || ai[1] > 40 ||
				aj[0] < 0 || aj[0] > 59 || aj[1] < 0 || aj[1] > 59){
			// Ϊfalse
			isDragSnake1 =false;
			isDragSnake2 =false;
			// Ϊ�˲��滭Ԥѡ
			start[0] = -1;// 0����
			start[1] = -1;
		}else if(isTouchOtherSnake(player, ai, aj)){// �ж��Ƿ������������ײ
			// Ϊfalse
			isDragSnake1 =false;
			isDragSnake2 =false;
			// Ϊ�˲��滭Ԥѡ
			start[0] = -1;// 0����
			start[1] = -1;
		}else if(isHaveWall(ai,aj)){// �ж��Ƿ������ǽ��
			// Ϊfalse
			isDragSnake1 =false;
			isDragSnake2 =false;
			// Ϊ�˲��滭Ԥѡ
			start[0] = -1;// 0����
			start[1] = -1;
		}else{
			GsnMapSnakeBean gsnamapsnake = new GsnMapSnakeBean();
			gsnamapsnake.snmapdirection = dir;
			gsnamapsnake.snmapi[0] = ai[0];
			gsnamapsnake.snmapj[0] = aj[0];
			gsnamapsnake.snmapi[1] = ai[1];
			gsnamapsnake.snmapj[1] = aj[1];
			// �����صĴ��󣡣��������������߽�û������ ���´���
			gsnamapsnake.snnode = 2;
			// ������
			gsneminter.gsneditmapbean.gsmsnakebean[player] = gsnamapsnake;
			// �����ͼ��ԭ����λ��
			gsneminter.gsnedmmgajpanel.deleteSnakeYuanZhi(player);
			// ���� ��Ϸ��� λ��
			gsneminter.gsnedmmgajpanel.setRunSnakePos();
			// ���µ�ͼֵ
			gsneminter.gsnedmmgajpanel.fromSnakePosSetVal();
			// ���»滭
			gsneminter.gsnedmmgajpanel.repaint();
			
			// �����ұ��ı���ֵ
			gsneminter.gsnedmrojpanel.setSnakeTextValue();
		}
	}
	// �����Ķ�λ���
	public void posMouse(MouseEvent e){
		if(startPosLineDraw){
			pos4 = e.getPoint();
			
			drawLinepos[0] = pos4.x / 10;
			drawLinepos[1] = pos4.y / 10;
			
			gsnorderline.setPos(drawLinepos);
			this.repaint();
		}
	}
	// �Ƿ�λ���
	public void setIsPosMouse(){
		if(startPosLineDraw){
			startPosLineDraw = false;
			// ���»滭
			this.repaint();
		}else{
			startPosLineDraw = true;
		}
	}
	Point pos1;// ��ʼλ��
	Point pos2;// �϶���ʱ��
	Point pos3;// ����λ��
	int start[] = new int[2];
	int end[] = new int[2];
	int mid[] = new int[2];
	
	// ������ǰѡ����һ���ϰ���
	GsnMainGameMoveBarrier gsmm;
	
	// �Ƿ��϶���
	boolean isDragSnake1 = false;
	boolean isDragSnake2 = false;
	
	Point pos4;// 
	int drawLinepos[] = new int[2];
	// int 
	// �������ѡ������
	class GsnEditMapMainGameMouseLis extends MouseAdapter{
		// �������� 
		// ����ƶ� �������˲������϶� �ͳ����滭 
		@Override
		public void mouseDragged(MouseEvent e) {
			isstartControl = false;// ���ž�
			crossnodequ.clear();
//			System.out.println("mouseDragged");
			// �Ȼ�ȡ��ǰ���������ɿ���λ��
			pos3 = e.getPoint();
			
			end[0] = pos3.x / 10;
			end[1] = pos3.y / 10;
			
			// �϶�snake
			if(isDragSnake1 && !gsneminter.mapTest){
				dragSnakePos(0, end[1], end[0], gsneminter.gsneditmapbean.gsmsnakebean[0].snmapdirection);
			}else if(isDragSnake2 && !gsneminter.mapTest){
				dragSnakePos(1, end[1], end[0], gsneminter.gsneditmapbean.gsmsnakebean[1].snmapdirection);
			}else{
	//			// ���б�һ��ʼ��λ��ҪС��ʱ�� ��Ҫ���»ָ�ԭֵ �ٻ滭��ǰ��
				if(end[1] < mid[1]){
					gsneminter.recoverMapDataFromData();
				}
				// ���е���Ҳ��һ��ʼС�ĵ�ʱ��
				if(end[0] < mid[0]){
					gsneminter.recoverMapDataFromData();
				}
	//			System.out.println(pos3.x+" "+pos3.y);
				gsneminter.setStillDraw(start, end);
				// ������ֵ ���һ滭
				initMapData();
				GsnEditMapMainGameAreaJPanel.this.repaint();
				
				// ������һ�����½ǵĵ�
				mid[0] = pos3.x / 10;
				mid[1] = pos3.y / 10;
			}
			posMouse(e);
		}
		
		// Ԥѡ
		@Override
		public void mousePressed(MouseEvent e) {
//			System.out.println("mousePressed");
			// ��ȡ����
			GsnEditMapMainGameAreaJPanel.this.requestFocus();
			// �Ȼ�ȡ��ǰ���������ɿ���λ��
			pos1 = e.getPoint();
			// ����
			start[0] = pos1.x / 10;// 0����
			start[1] = pos1.y / 10;
//			System.out.println(pos1.x+" "+pos1.y);
			// ��ǰ��������ߵ����� �����϶� ����pos1, ������������ν
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
			// ����
			// һ���������������Ƿ�Ӧ������ ���߱�����.�ȷ��� һֱ������
			crossnodeposfirst[0] = pos3.y / 10;// 0����
			crossnodeposfirst[1] = pos3.x / 10;
			boolean isok = false;
			 // �ָ� ԭ����ֵ��
			if(!isstartControl){
				// ��գ���
				crossnodequ.clear();
//				gsneminter.recoverMapDataFromDataTozero();// ��0�ָ�4
				gsneminter.recoverMapDataFromData();
				crossnodequ.add(crossnodeposfirst);
			}else{
				if(crossnodequ.size() < 2){
					// ��Ҫѡ���ߵ�λ�� Ҳ�������ϰ���
					crossnodequ.add(crossnodeposfirst);
				}else{
					System.out.println(crossnodequ.size());
					// ��һ���ָ� ���������һ�� λ�� 
					// ȡ��
					int thefirst[] = crossnodequ.poll();
					// �ָ�ԭ��
					currmapdata[thefirst[0]][thefirst[1]] = gsneminter.mapdatareservation[thefirst[0]][thefirst[1]];
					crossnodequ.add(crossnodeposfirst);
				}
				// ��ǰΪԤ��
				currmapdata[crossnodeposfirst[0]][crossnodeposfirst[1]] = 49;
				GsnEditMapMainGameAreaJPanel.this.repaint();
				// ���ı���ֵ
				gsneminter.setValueToCrossNode();
			}	
//			allqu();
			if(isDragSnake1 || isDragSnake2|| isstartControl){
				
			}else{
				// ���õ�ʱ��
				gsneminter.setReservationArea(start, end);
				// ������ֵ ���һ滭
				initMapData();
				GsnEditMapMainGameAreaJPanel.this.repaint();
			}
			// ȡ���϶�
			isDragSnake1 = false;
			isDragSnake2 = false;
			posMouse(e);
		}
		
		// �ϰ����ѡ�񷽷� 
		@Override
		public void mouseClicked(MouseEvent e) {
//			System.out.println("mouseClicked");
			// ���µ��˾ͻָ�����
			if(gsmm != null){
				gsmm.isChoose = false;
				gsmm.startMove();
			}
			
			// ���ϰ���ֹͣ 
			// ���ݵ�ǰѡ��������ж��Ƿ����ƶ��ϰ���ķ�Χ�Ǿͻ�ȡ����ϰ���
			gsmm = itBarlistIsCheck(e.getPoint().y / 10,e.getPoint().x / 10);
			if(gsmm != null){
				// ��ѡ��
				gsmm.init(gsmm.gsnmbarbean);// �ָ�ԭ����λ��
				gsmm.isChoose = true;
				// ���������ϰ���˵���ѡ��
				gsneminter.gsnedmrojpanel.jtbpane.setSelectedIndex(3);
				// ���ҽ�����ѡ���Լ� �Ȼ�ȡ�Լ����±�
				int index = findBarlistIndexBy(gsmm);
				gsneminter.gsnedmrojpanel.barjcbox.setSelectedIndex(index + 1);
				gsneminter.gsnedmrojpanel.barjcbox.updateUI();
				gsmm.endMove();// ��ѡ����ֹͣ
			}
			posMouse(e);
		}
		// �� ����ƶ���ʱ��
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
	// ��Ϸ��ض���-----
	// ���̼��� 
	class GsnMainGameKeyLis extends KeyAdapter{
		private int keycode;//
		// ���ڲ����ߣ�Ӧ���ǰ��¾͸ı䣬��Ҫ�������ڸı� ��˳��
		@Override
		public void keyPressed(KeyEvent e) {
			keycode = e.getKeyCode();
			if(gsneminter.mapTest){
				// ��һ����
				if(gsnsnake[0].isfinishcurState){
					if(keycode == KeyEvent.VK_1){
						System.out.println("GsnMainGameKeyLis����1��");
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
				
				// �ڶ�����
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
				// ���浱ǰ��ͼ��ѡ���һ������ֻ����һ�������û��ѡ�Ļ��͡���
				// ��Ҫ����Ԥѡ
				isstartControl = true;
			}
		}
	
		@Override
		public void keyReleased(KeyEvent e) {
			keycode = e.getKeyCode();
			if(keycode == KeyEvent.VK_ESCAPE){
				// ֹͣ �� �� ʳ���̻߳����ϰ��� ���߳� �����ٰ�
				endThread();
				// ���
				
				// Ҫ�� �滭��С ���û��� 5 Ϊ��Ԥ���ؿ�
				GsnMainGameConstants.setDrawSize(5);
				GsnBottomLayerInterface.backLastJPanel();
				System.out.println("GsnMainGameKeyLis����VK_ESCAPE��");
			}
			if(keycode == KeyEvent.VK_CONTROL){
				isstartControl = false;
			}
		}
	}
	boolean isstartControl;
	public Queue<int[]> crossnodequ = new LinkedList<int[]>();// ����λ�ã�ֻ������������������ ��һ���ָ����ڶ�������
	public void allqu(){
		int i = 0;
		Iterator<int[]> it = crossnodequ.iterator();
		while(it.hasNext()){
			int z [] = it.next();
			i++;
			System.out.println(i+": "+z[0]+" "+z[1]);
		}
	}
	// Ԥ����ʱ�� �ߵ��ٶȿ�����һ��
	public void PreviewAddSnakeSpeed(){
		gsnsnake[0].snspeed = GsnMainGameConstants.SnakePreviewMoveSpeed;
		gsnsnake[1].snspeed = GsnMainGameConstants.SnakePreviewMoveSpeed;
	}
	// �޸ĵ�ͼԤ�� �������� �� �ָ�
	public void foodDead(){
		// ����ʳ����˵ Ӧ��������
		for(int i = 0 ; i < MainGamefoodlength; i++){
			gsnfood[i].endThread();
		}
	}
	public void foodNew(){// ʳ�������߳� ���½�
		initFoodInfo();
	}
	public void EditMapPreviewStartDraw(){
		// ��̬��ͼ
		gsneminter.setDynamicMapdata();
		// ��Ϸ�ߵ�λ��Ҳ����Ϊ�������ĳ�ʼλ��
		setRunSnakePos();
		// ʳ��Ҫ���¼���
		initFoodInfo();
		PreviewAddSnakeSpeed();// �������ٶ�
		startDraw();
		isPlay = true;
		gsneminter.mapTest = true;
		// ��ѡ���е��ϰ���
		allBarCancelChoose();
		// �滭
		repaint();
		// ���ý���
		this.requestFocus();
	}
	public void EditMapPreviewStartRecover(){
		gsneminter.setDynamicMapdata();
		endDraw();
		foodDead();
		// ��ͣ��ʱ�� ��Ҫ�ָ�������������bean
		setRunSnakePos();
		// �ϰ�����ͣ���ָ�λ��
		allBarlisPause();
		isPlay = false;
		gsneminter.mapTest = false;
		repaint();
	}
	// ��Ϸ��ض���-----end
	// ����µ��ƶ��ϰ� ��Ĭ��ֵ
	public void addNewBarirrLength(){
		// �����һ����Ŀ
		MainGameMoveBarrierlength++;
		// �ٸ���Ĭ��ֵ
	}
	// �滭
	@Override
	public void paint(Graphics g) {
		// TODO �Զ����ɵķ������
		super.paint(g);// ��д��� �ͻ�����һ���ı���
		// ������������߾ͻ��� �÷�ǰ��Ų��Ḳ������ͼ��
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
				// Ԥѡ����
				if(currmapdata[m][n] == 49){
					g.setColor(Color.GREEN);
					g.drawRect(n * GsnMainGameConstants.drawSize, m * GsnMainGameConstants.drawSize, GsnMainGameConstants.drawSize, GsnMainGameConstants.drawSize);
				}
			}
		}
		// ��Խ�ڵ�
		for(int i = 0; i < crossnodelength; i++ ){
			if(gsnmgmcrossnodelis.get(i) != null){// �е����Ϊnull ���ܻ滭��
				g.setColor(GsnMainGameConstants.crosscolor[i]);// �Ѿ����ú���
				gsnmgmcrossnodelis.get(i).draw(g);
			}
		}
		g.setColor(Color.BLACK);
		
//		// �滭�ϰ���
		for(int i = 0; i < MainGameMoveBarrierlength; i++){
			if(gsnmgmbarlis.get(i) != null){// �е����Ϊnull ���ܻ滭��
				gsnmgmbarlis.get(i).draw(g);
			}
		}
		// �滭��
		g.setColor(Color.RED);
		gsnsnake[0].draw(g);
		g.setColor(Color.GREEN);
		gsnsnake[1].draw(g);
		g.setColor(yuan);
		// �������� �滭ʳ�� 
		if(gsneminter.mapTest){
			g.setColor(Color.PINK);
			// �滭ʳ��
			for(int i = 0; i < MainGamefoodlength; i++){
				gsnfood[i].draw(g);
			}
		}
		// ���Ե�ʱ��Ҳ���Կ��� ���߶�
		// �����ϰ���Ҫһֱ����
		// ȫ����ͣ��ʱ��??��ô�ָ��ء��� ֱ��false�����˰�
		if(isRepeatPaintBar || gsneminter.mapTest){
			// ��������ײ ֻ��Ҫһ������ײ��� �����˰� 
			// 20191130����ײ�ͳ�ʳ��Ĵ���������ﲻ֪���ò���
			checkCCAnother();
			eatFood();
			
			GsnEditMapMainGameAreaJPanel.this.repaint();
		}
		// ɾ�����ػ�Ͳ���һֱ�滭
//		GsnEditMapMainGameAreaJPanel.this.repaint();
	}
	// eat
	public void eatFood(){
		// �����
		for(int si = 0; si < gsnsnake.length; si++){
			for(int i = 0; i < MainGamefoodlength; i++){
				if(gsnfood[i].curi == gsnsnake[si].snactuali[0] && gsnfood[i].curj == gsnsnake[si].snactualj[0]){
					gsnfood[i].deadUpdate();
					gsnsnake[si].node++;
					// ��Ϊ���������ƶ��������߽ڻ滭������Ϊ00 �ȴ�������
					gsnsnake[si].snactuali[gsnsnake[si].node - 1] = -1;
					gsnsnake[si].snactualj[gsnsnake[si].node - 1] = -1;
					gsnsnake[si].addSpeed();
					// ���ӷ� 
					return;
				}
			}
		}
	}
	
	// �޸Ĺؿ���ʱ�����õ�ֵ------------------
	// ���޸ĵľͲ���set��  ��ֱ�Ӵӵ�ͼ��Ϣ��ȡ ��Ϊ��¡��
	public void setSnakePosByMap(){
		gsnsnake[0].InitBySnakeBean(gsneminter.gsneditmapbean.gsmsnakebean[0]);
		gsnsnake[1].InitBySnakeBean(gsneminter.gsneditmapbean.gsmsnakebean[1]);
		
		fromSnakePosSetVal();// �������õ�ͼֵ
	}
	public void UpdateLevelInitValue(){
		// ʳ���ȡ
		MainGamefoodlength = gsneminter.gsneditmapbean.gsmfoodbean.foodlength;
		// �ƶ��ϰ�����
		MainGameMoveBarrierlength = gsneminter.gsneditmapbean.gsminfobean.barcount;
		// ��Խ�ڵ�����
		crossnodelength = gsneminter.gsneditmapbean.gsminfobean.crossnodecount;
		
		// ��ȡ��ͼ
		initMapData();
		// ��
		setSnakePosByMap();
		// ʳ��
		initFoodInfo();
		// �ϰ���
		initBarInfo();
		// ��Խ�ڵ�
		initCrossNodeList();
		
		// ��ֹͣ
		endDraw();
		isPlay = false;
		// ֹͣ����
		isRepeatPaintBar = false;
	}
	// �޸Ĺؿ���ʱ�����õ�ֵ------------------
	
	
	// ���ô�Խ�ڵ�start--------------
	public void initCrossNodeList(){
		crossnodelength = gsneminter.gsneditmapbean.gsminfobean.crossnodecount;
		gsnmgmcrossnodelis = new ArrayList<GsnCrossNodeDraw>(crossnodelength);
		for(int i = 0 ; i < crossnodelength; i++){
			GsnCrossNodeDraw gsncn = new GsnCrossNodeDraw();
			gsncn.setValueToBean(gsneminter.gsneditmapbean.gsmcrossnodebeanlist.get(i));
			gsnmgmcrossnodelis.add(gsncn);
		}
	}
	// ��list���һ��  
	public void addOneCrossNodeTolist(GsnMapCrossNodeBean bean){
		GsnCrossNodeDraw gsncn = new GsnCrossNodeDraw();
		gsncn.setValueToBean(bean);
		gsnmgmcrossnodelis.add(gsncn);
	}
	// ����
	public void addNewCrossListLength(){
		// �����һ����Ŀ
		crossnodelength++;
		// �ٸ���Ĭ��ֵ
	}
	// ��Ѱ����Ϊ��ֵ������
	public int notNullCrossNodeCount(){
		int count = 0;
		for(int i = 0 ; i < gsnmgmcrossnodelis.size(); i++){
			if(gsnmgmcrossnodelis.get(i) != null){
				count++;
			}
		}
		return count;
	}
	// �޸� ֱ��ɾ��ԭ���� ����ӻ�ȥ���� ���ܻ���ӵ�����ȥ�ɣ����и��±궨λ
	public void alterOneCrossNodeList(GsnMapCrossNodeBean bean, int index){
		gsnmgmcrossnodelis.remove(index);// ��ɾ�ٸ�
		GsnCrossNodeDraw gs = new GsnCrossNodeDraw();
		gs.setValueToBean(bean);
		gsnmgmcrossnodelis.add(index, gs);
	}
	// ��listɾ�� Ҳ����ɾ������Ϊnull
	public void giveNullCrossNodeTolist(int index){
		// ����Ѿ��ǿյľͲ��ò�����
		if(gsnmgmcrossnodelis.get(index) != null){
			gsnmgmcrossnodelis.remove(index);
			// �ټӣ�
			gsnmgmcrossnodelis.add(index,  null);
		}
	}
	// ��ȡlist�Ľڵ�
	public GsnCrossNodeDraw getNodeByIndexOfCrossNodeList(int index){
		if(index < 0){
			return null;
		}
		return gsnmgmcrossnodelis.get(index);
	}
	// �жϵ�ǰ�±��Ƿ�Ϊnull
	public boolean isNullOfCrossListByindex(int index){
		if(gsnmgmcrossnodelis.get(index) == null){
			return true;
		}
		return false;
	}
	// ���ô�Խ�ڵ�end--------------
	
	// ���̼��� Ϊ�˴�Խstart---------------
	// ���̼��� Ϊ�˴�Խend---------------
}

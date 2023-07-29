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

// �޸ĵ�ͼ����
public class GsnEditmapInterface extends JPanel{
	public boolean mapTest;// ��ͼ�Ƿ���� 
	// ��ͼ���
	public GsnEditMapMainGameAreaJPanel gsnedmmgajpanel;
	// �ұ߲������
	public GsnEditMapRightOperationJPanel gsnedmrojpanel;
	
	// ��ʼ��һ����ͼbean
	public GsnMapBean gsneditmapbean;
	// һ�� char�ַ� �ĵ�ͼ
	public boolean isborder;// �Ƿ��б߽�
	
	GsnMapReadAndOut gsnmaprano;// ���
	// ��־ ���޸Ļ����½��ĵ�ͼ
	public int flag; // 1Ϊ�½���2 Ϊ�޸�
	
	// ���ݵ�ͼ
	public GsnEditmapInterface(int flag){
		this.flag = flag;
		setLayout(null);
		init();
		setDefaultMapValue();
		gsnedmmgajpanel = new GsnEditMapMainGameAreaJPanel(this);
		gsnedmrojpanel = new GsnEditMapRightOperationJPanel(this);
		
		gsnedmmgajpanel.setBounds(20, 50, gsnedmmgajpanel.getWidth() , gsnedmmgajpanel.getHeight());
		// 20 ���
		gsnedmrojpanel.setBounds(gsnedmmgajpanel.getWidth() + 40, 50,gsnedmrojpanel.getWidth(), gsnedmmgajpanel.getHeight()  );
		
		add(gsnedmmgajpanel);
		add(gsnedmrojpanel);
		this.setBackground(Color.CYAN);
		this.setSize(new Dimension(GsnInterfaceParam.INTERFACEWIDTH + gsnedmrojpanel.getWidth() + 20 , GsnInterfaceParam.INTERFACEHEIGHT));// 640 * 480 �̶���С
	}
	public void init(){
		gsnmaprano = new GsnMapReadAndOut();
		gsneditmapbean = new GsnMapBean();
	}
	// ���½�����ʱ�� �����½���ͼ--------------------------------------------------------
	public void Reinit(){
		flag = 1;
		// �Լ�Ϊ�µ�
		gsneditmapbean = new GsnMapBean();
		// ����ĵ�ͼҲӦ�����µ�
		copyOneMapData();
		
		// Ĭ����λ�� 
		setEditMapSnakePos();

		// ����һ�ݸ�cur �Ų����ٲŽ����Ǵ����
		gsnedmmgajpanel.initGame();
		gsnedmmgajpanel.initBarInfo();
		gsnedmmgajpanel.initCrossNodeList();
		
		// ������Ĭ�ϵ�ͼֵ ���Ǹ�����Ϸ���ſ���
		gsnedmmgajpanel.fromSnakePosSetVal();
		
		// ˢ��
		gsnedmmgajpanel.repaint();
		// ����Ĭ��Ϊ�ղ����´��½�û��
		gsnedmrojpanel.setDefaultValueToallPanl();
	}
	
	// ����  ���½���ʱ���ʼλ�� 
	public void setEditMapSnakePos(){
		// ���Լ����bean ����snake,�������ʱ��ͺ�˵��
		GsnMapSnakeBean gsn1 = new GsnMapSnakeBean(2, 1, 6, 5, 5, 5);
		GsnMapSnakeBean gsn2 = new GsnMapSnakeBean(2, 0, 37, 55, 38, 55);
		gsneditmapbean.gsmsnakebean[0] = gsn1;
		gsneditmapbean.gsmsnakebean[1] = gsn2;
	}
	// 
	// ���½�����ʱ��-----------------------
	public void setDefaultMapValue(){
		gsneditmapbean.giveSpaceOfBar();
//		System.out.println(gsneditmapbean.toString());
	}
	// �����޸ĵ�ͼ��ʱ��ķ���----------------------------------
	public void setMapDataByLevel(){
		// Ϊ�޸�
		flag = 2;
		// mapdata����Ҫ��¡��ȥ
		//̫���� mapdata���ܱ�ǳ���� ��Ȼ�޸����Ժ�dynamic����Ӱ�� ���� ��һ��ר�ŵ�mapdata���� ������dynamic ��Ҫ��bean�� 
		gsneditmapbean = new GsnMapBean((GsnMainGameConstants.gsngamemap[GsnMainGameConstants.currLevel - 1]));
		// ��curren ������
		copyOneMapData();
		mapTest = false;
		
		// ɾ���ϰ���ĵ�ͼֵ
		delMapDataOfBar();
		
		// ��Ϸ��� ��ʼ������Щ����
		gsnedmmgajpanel.UpdateLevelInitValue();
		
		// �ұ��������
		gsnedmrojpanel.Alter();
	}
	// �����޸ĵ�ʱ��ķ���----------------------------------
	// �����ʱ�����õ�ͼ�����ԣ��д���Ϸ����л�ȡ�ƶ��ϰ��ʹ�Խ�ڵ�
	public void setGsnEditMapBean(GsnMapInFoBean gsnmapinfo, GsnMapFoodBean gsnfood){
		// �Ȼָ�Ԥѡ�ĵ�ͼֵ
		recoverMapData();
		// ����
		gsneditmapbean.gsminfobean = gsnmapinfo;
		gsneditmapbean.gsmfoodbean = gsnfood;
		
		// barbean �����ƶ��ϰ��Ļ�ҲҪ ����list�õ����� Ȼ���ٸ���
		// list�Ĵ�С�Ѿ����棬ֻҪ���ٿռ� ����Ϸ����з��� ����
		giveSpaceAndValuefromListOfBarList(gsnedmmgajpanel.gsnmgmbarlis);
		
		// �õ���Խ�ڵ�
		giveSpaceAndValuefromListOfCrossNodeList(gsnedmmgajpanel.gsnmgmcrossnodelis);
		
		
		// �����ߵ�beanҲҪ,����Ϸ������ȡ ����Ͳ����� ��Ӧ������� ����߸���λ�� û�б�ֱ�ӻ�ȡ�ͺ�
		
		// ���� �ϰ���ĵ�ͼֵ
		setMapDataOfBarPos();
	}
	public void giveSpaceAndValuefromListOfBarList(List<GsnMainGameMoveBarrier> ar){
		// ����ܿ��ܱ��� ע��~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		// 1.�ȵ�֪���ж��ٸ�bean�ǿ��õ�
		int barcount = gsnedmmgajpanel.notNullBarListCount();
		// ����ռ�
		gsneditmapbean.gsmbmbean = new GsnMapBarrierMoveBean[barcount];
		
		int listj = 0;
		for(int i = 0; i < barcount; i++){
			// ��ҪҪ�����յ�null ���������±��ǲ�һ����
			while(ar.get(listj) == null){// �ҵ���һ����Ϊ�յĲŷ���
				listj++;
			}
			gsneditmapbean.gsmbmbean[i] = ar.get(listj).gsnmbarbean;// ��Ҫ��ȡ����
			listj++;// ����Ҫ��һ�� ����ҲҪ++j
		}
	}
	public void giveSpaceAndValuefromListOfCrossNodeList(List<GsnCrossNodeDraw> ar){
		// 1.�ȵ�֪���ж��ٸ�bean�ǿ��õ�
//		int count = gsnedmmgajpanel.notNullCrossNodeCount();
		for(int i = 0; i < ar.size(); i++){// ֱ�Ӳ����ڿ�
			if(ar.get(i) != null){
				gsneditmapbean.gsmcrossnodebeanlist.add(ar.get(i).gsncnbean);// ��Ҫ��ȡ����
			}
		}
	}
	// ������Ҫ���ϰ����λ�����õ�ͼֵ Ҳ����һ�ٰ� 20191202
	public void setMapDataOfBarPos(){
		for(int z = 0; z < gsneditmapbean.gsmbmbean.length; z++){
			// ��ǰռ�ݵľ���56
			for(int i = 0; i < gsneditmapbean.gsmbmbean[z].barheight; i++){
				for(int j = 0; j < gsneditmapbean.gsmbmbean[z].barwidth; j++){
					gsneditmapbean.mapdata[gsneditmapbean.gsmbmbean[z].bari + i][gsneditmapbean.gsmbmbean[z].barj + j] = 56;
				}
			}
		}
	}
	// �����޸ĵ�ͼ��ʱ�� ������ʱ��Ͱ��ϰ���ĵ�ͼֵɾ�� Ϊ�˲�������������
	public void delMapDataOfBar(){
		for(int m = 0; m < 41; m++){
			for(int n = 0; n < 60; n++){
				if(gsneditmapbean.mapdata[m][n] == 56){// ΪԤѡ��ɾ��
					gsneditmapbean.mapdata[m][n] = 0;
				}
			}
		}
	}
	public void delWithMapData(){
		for(int m = 0; m < 41; m++){
			for(int n = 0; n < 60; n++){
				if(gsneditmapbean.mapdata[m][n] == 49){// ΪԤѡ��ɾ��
					gsneditmapbean.mapdata[m][n] = 0;
				}
			}
		}
	}
	// �����ͼbean
	public void outNewMap(){// Ҫ����curr���� �����½���ʱ��᷸��
		// �Ե�ͼԤ�ȴ���
		delWithMapData();
		gsnmaprano.outNewMap(gsneditmapbean);
		// ��������Ժ��Ҫ�����ֵ
		Reinit();
		// ����� ���¶�ȡ
		reReadNewMap();
		// �༭��ͼ��
		// �����ҲҪ��������Ԥ����
		GsnBottomLayerInterface.gsneditmapleveldisplayJpanel.setEditMapLevelCurLevelForadd();
		
		// �����Ҫ������UI ���ǹؿ�ѡ��
		GsnBottomLayerInterface.gsneditmapleveldisplayJpanel.clearArrayList();
		GsnBottomLayerInterface.gsneditmapleveldisplayJpanel.reAddArraylist();
		//�������ؿ�ѡ��
		GsnBottomLayerInterface.gsneditmapleveldisplayJpanel.gsneditmapleveldisjlist.setSelectedIndex(GsnMainGameConstants.gsngamemap.length - 1);
		GsnBottomLayerInterface.gsneditmapleveldisplayJpanel.gsneditmapleveldisjlist.updateUI();
		
		// ��ͨ��ͼѡ���
		GsnBottomLayerInterface.gameLevelJpanel.clearArrayList();
		GsnBottomLayerInterface.gameLevelJpanel.reAddArraylist();
		//���õ�һ���ؿ�ѡ��
		GsnBottomLayerInterface.gameLevelJpanel.gsnleveldisjlist.setSelectedIndex(0);
		GsnBottomLayerInterface.gameLevelJpanel.gsnleveldisjlist.updateUI();
	}
	// �޸ĵ�ͼ
	public void alterMap(){
		delWithMapData();// ���Ԥѡ
		gsnmaprano.alterMap(gsneditmapbean);
		// �޸������Ժ��Ҫ�����ֵ
		Reinit();
		// ����� ���¶�ȡ ����ת��
		reReadNewMap();
		// �����ҲҪ��������Ԥ���Ĺؿ�����
		GsnBottomLayerInterface.gsneditmapleveldisplayJpanel.setEditMapLevelCurLevelForAlter();
		
		// �����Ҫ������UI ���ǹؿ�ѡ��
		GsnBottomLayerInterface.gsneditmapleveldisplayJpanel.clearArrayList();
		GsnBottomLayerInterface.gsneditmapleveldisplayJpanel.reAddArraylist();
		//���õ�ǰ�ؿ�ѡ��
		GsnBottomLayerInterface.gsneditmapleveldisplayJpanel.gsneditmapleveldisjlist.updateUI();
		// Ӧ����ѡ�����һ��
		GsnBottomLayerInterface.gsneditmapleveldisplayJpanel.gsneditmapleveldisjlist.setSelectedIndex(GsnMainGameConstants.gsngamemap.length - 1);
		
		// ��ͨ��ͼѡ���
		GsnBottomLayerInterface.gameLevelJpanel.clearArrayList();
		GsnBottomLayerInterface.gameLevelJpanel.reAddArraylist();
		//���õ�һ���ؿ�ѡ��
		GsnBottomLayerInterface.gameLevelJpanel.gsnleveldisjlist.setSelectedIndex(0);
		GsnBottomLayerInterface.gameLevelJpanel.gsnleveldisjlist.updateUI();
	}
	// ���¶�ȡ��ͼ
	public void reReadNewMap(){
		gsnmaprano.readMapText();
		gsnmaprano.changeMap();
	}
	
	// ����ֵ
	// ���ñ߽�
	public void setBorder(){
		byte value;
		// û�б߽�
		if(!isborder){
			value = 1;
			isborder = true;// �б߽���
		}else{// �б߽�
			value = 0;
			isborder = false;// û�б߽���
		}
		// ���ұ߽�
		for(int i = 0; i < 41; i++){
			gsneditmapbean.mapdata[i][0] = value;
			gsneditmapbean.mapdata[i][59] = value;
		}
		// ���±߽�
		for(int i = 0; i < 60; i++){
			gsneditmapbean.mapdata[0][i] = value;
			gsneditmapbean.mapdata[40][i] = value;
		}
//		fromByteToChar();
		// �����Ժ󿽱�һ��
		copyOneMapData();
	}
	// ��Ϊѡ���Ϊǽ
	public void setOrderToWall(int start[] , int end[]){// �������鷶Χ��
		for(int m = start[1]; m <= end[1]; m++){// y
			for(int n = start[0]; n <= end[0]; n++){// x
				// �滭��ΪԤѡ�ľͻָ�
				if(gsneditmapbean.mapdata[m][n] == 49 && !(mapdatareservation[m][n] == 2 || mapdatareservation[m][n] == 3) ){
					gsneditmapbean.mapdata[m][n] = 1;
				}
			}
		}
		// �����Ժ󿽱�һ��
		copyOneMapData();
	}
	public void setOrderToWall(){
		for(int m = 0; m < 41; m++){
			for(int n = 0; n < 60; n++){
				// ԭ����ͼ�� ��ѡ�񵽵��߲���Ϊǽ
				if(gsneditmapbean.mapdata[m][n] == 49 && !(mapdatareservation[m][n] == 2 || mapdatareservation[m][n] == 3) ){
//					System.out.println("mapdatareservation[m][n]:"+mapdatareservation[m][n]);
					gsneditmapbean.mapdata[m][n] = 1;
				}
			}
		}
		// �����Ժ󿽱�һ��
		copyOneMapData();
	}
	// ȡ��ǽ
	public void cancelOrderOfWall(){
		for(int m = 0; m < 41; m++){
			for(int n = 0; n < 60; n++){
				// �������� ��Ϊû��Ԥѡ��
				if(gsneditmapbean.mapdata[m][n] == 49){
					gsneditmapbean.mapdata[m][n] = 0;
				}
			}
		}
		// �����Ժ󿽱�һ��
		copyOneMapData();
	}
	public void cancelOrderOfWall(int start[] , int end[]){// �������鷶Χ��
		for(int m = start[1]; m <= end[1]; m++){// y
			for(int n = start[0]; n <= end[0]; n++){// x
				// �滭��ΪԤѡ�ľͻָ�
				if(gsneditmapbean.mapdata[m][n] == 49){
					gsneditmapbean.mapdata[m][n] = 0;
				}
			}
		}
		// �����Ժ󿽱�һ��
		copyOneMapData();
	}
	// ѡ�������������ɫֵ
	public void setStillDraw(int start[] , int end[]){
		
		// ÿ��Ԥѡ����ǰ��Ҫ����һ��
//		copyOneMapData();// ��Ҫ���� Ϊ�˻ָ�
		// x y ����߽�
		// ���һ��ʼ�ʹ��ڱ߽�Ͳ�Ҫѡ��
		if(start[0] > 59 || start[1] > 40 || end[0] > 59 || end[1] > 40 ||
				start[0] < 0 || start[1] < 0 || end[0] < 0 || end[1] < 0){// start[0] = x start[1] = y
			
		}else{
			// 1.�߽紦��
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
				// ��ʼ�������Ϸ��������������·� o
				if(start[0] < end[0] && start[1] < end[1]){
					midstart = start;
					midsend = end;
				}
				if(start[0] < end[0] && start[1] == end[1]){
					midstart = start;
					midsend = end;
				}
				//  ����  ����  
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
				// ���ϣ�����
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
				// ���£����� o
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
						// ��Ҫѡ���ߵ�λ��
						if( !(gsneditmapbean.mapdata[m][n] == 2 || gsneditmapbean.mapdata[m][n] == 3) ){
							gsneditmapbean.mapdata[m][n] = 49;// a
						}
					}
				}
				setValueTobar(midstart, midsend);
			}
		}
	}
	// ����Խ��ֵ
	public void setValueToCrossNode(){
		// �����ϰ���ֵ�������������ǰѡ�����0 ���ߵ�ǰѡ���Ϊ�վʹ���ȥ
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
	// ���ϰ��ﴫֵ
	public void setValueTobar(int start[] , int end[]){
		// �����ϰ���ֵ�������������ǰѡ�����0 ���ߵ�ǰѡ���Ϊ�վʹ���ȥ
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
	// ѡ�������������ɫֵ
	public void setReservationArea(int start[] , int end[]){
		// ÿ��Ԥѡ����ǰ��Ҫ����һ��
		// ����Ƕ���Ͳ�Ҫ
		copyOneMapData();// �ȱ���һ��
	
		// x y ����߽�
		// ���һ��ʼ�ʹ��ڱ߽�Ͳ�Ҫѡ��
		if(start[0] > 59 || start[1] > 40 || end[0] > 59 || end[1] > 40||
				start[0] < 0 || start[1] < 0 || end[0] < 0 || end[1] < 0){// start[0] = x start[1] = y
			
		}else{
			// 1.�߽紦��
			end[0] = end[0] > 59 ? 59 : end[0] ;
			end[1] = end[1] > 40 ? 40 : end[1] ;
			start[0] = start[0] > 59 ? 59 : start[0] ;
			start[1] = start[1] > 40 ? 40 : start[1] ;
			// 2. ��������Ƕ� 
			if(start[1] == end[1] && start[0] == end[0]){
				gsneditmapbean.mapdata[start[1]][start[0]] = 49;// a
				setValueTobar(start, end);
			}else{
				int midstart[] = new int[2];
				int midsend[] = new int[2];
				// ��ʼ�������Ϸ��������������·�
				if(start[0] < end[0] && start[1] < end[1]){
					midstart = start;
					midsend = end;
				}
				if(start[0] < end[0] && start[1] == end[1]){
					midstart = start;
					midsend = end;
				}
				//  ����  ���� 
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
				// ���ϣ�����
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
				// ���£�����
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
						// ��Ҫѡ���ߵ�λ�� Ҳ�������ϰ���
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
	// �ָ�ԭ����ֵ ��Ҫ�� gsneditmapbean.map Ҫ���������Ϊcurrentmap�ǻ���������仯��
	// ���������� �����������
	public void recoverMapData(){
		for(int m = 0; m < 41; m++){
			gsneditmapbean.mapdata[m] = mapdatareservation[m].clone();
		}
	}
	public void recoverMapDataFromData(){// ���� ��49�͸�ԭ
		for(int m = 0; m < 41; m++){
			for(int n = 0; n < 60; n++){
				if(gsneditmapbean.mapdata[m][n] == 49){
					gsneditmapbean.mapdata[m][n] = mapdatareservation[m][n];
				}
			}
			
		}
	}
	public void recoverMapDataFromDataTozero(){// ���� ��49�͸�ԭ
		for(int m = 0; m < 41; m++){
			for(int n = 0; n < 60; n++){
				if(gsneditmapbean.mapdata[m][n] == 49){
					gsneditmapbean.mapdata[m][n] = 0;
				}
			}
		}
		copyOneMapData();
	}
	// ��Ԥѡ�ĵ�ͼ���ԭ����ͼ���� pointΪ��Χ �ӱ���ľɵ�ͼ�� �ָ�����
	public void recoverMapDataFromPoint(int start[] , int end[]){
		for(int m = start[1]; m <= end[1]; m++){// y
			for(int n = start[0]; n <= end[0]; n++){// x
				// �滭��ΪԤѡ�ľͻָ�
				if(gsneditmapbean.mapdata[m][n] == 49){
					gsneditmapbean.mapdata[m][n] = mapdatareservation[m][n];
				}
			}
		}
	}
	
	// ����һ�ݵ�ͼֵ����ͼֵ2  ʧ�ܵĴ���
	public void copyOneMapData(){
		for(int m = 0; m < 41; m++){
			mapdatareservation[m] = gsneditmapbean.mapdata[m].clone();
		}
	}
	// ����ѡ�������
	public byte[][] mapdatareservation = new byte[41][60];// ����һ��ԭ���ĵ�ͼ
	
	// ���ö�̬��ͼֵ Ϊ�� ��Ԥ���¹�
	public void setDynamicMapdata(){
		GsnMainGameConstants.setDynamicMapData(gsneditmapbean.mapdata);
	}
	
}
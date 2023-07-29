package com.snake.mgame;

import java.awt.Color;
import java.awt.Graphics;

import com.snake.bean.GsnMapBarrierMoveBean;
import com.snake.editmap.GsnEditMapMainGameAreaJPanel;
import com.snake.mgameconfig.GsnMainGameConstants;

public class GsnMainGameMoveBarrier extends Thread{
	public GsnMapBarrierMoveBean gsnmbarbean;// һ���������һ���ϰ�
	
	public boolean isRun;
	public boolean controlRun;
	
	// ���е�������
	public int curdir;// ��ǰ���� 0123
	// �õ��ϰ�������
	public int barmatri[], barmatrj[];// ,�����Դ�ͳ�Ķ�ά���ټ�Ϊһά����
	public int heightindex,widthindex;// �߶ȺͿ�ȵ������±�
	
	// �Ƿ�ѡ����
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
	// �ӵ�ͼ��ȡ������
	// ��ʼλ����Ϣ ������ node
	public void init(GsnMapBarrierMoveBean g){
		gsnmbarbean = g;
		curdir = gsnmbarbean.bardir; // �������Ҫ ��Ϊ��ı䷽��
		// �� heightΪ�� �� widthΪ��
		barmatri = new int[gsnmbarbean.barheight];
		barmatrj = new int[gsnmbarbean.barwidth];
		heightindex = gsnmbarbean.barheight - 1;
		widthindex = gsnmbarbean.barwidth - 1;
		// �ϰ��ﷶΧ
		getMatrixArea();
		// �޸ĵ�ͼֵ ��һ����Ҫ
		updateMapValue();
	}
	// ��ȡ��������������Ƕ���  ��������Ľڵ�
	public void getMatrixArea(){
		// ��ȡ�ƶ�����Χ����
		for(int i = 0; i < gsnmbarbean.barheight; i++){
			barmatri[i] = gsnmbarbean.bari + i;// ���Ͻǽڵ��i
			for(int j = 0; j < gsnmbarbean.barwidth; j++){
				barmatrj[j] = gsnmbarbean.barj + j ;// ���Ͻڵ��j  
			}
		}
	}
	// �ɳ���  ���� ͷ��λ�� �����ϰ��ﷶΧ
	public void getArea(){

	}
	// 
	// �ƶ� �����������ҷ��� ���ȸ��ݷ���õ���ͷ�ǵ�һ�л������һ�л��ǵ�һ�У��������һ�� �ٽ��л�����
	public void move(){
		// ��¼�ƶ��� һ�л���һ�лָ�Ϊ0
		int rei,rej;// ��סi j
		// �ƶ�ͷ���λ��
		switch (curdir) {
			case 0:// ��, ��ͷ�ڵ�һ�� ���ĵ�һ�е���ͷ
				// ����������
				// ��ס���һ��
				rei =  barmatri[heightindex];
				// ��һ�����ûָ�
				for(int j = gsnmbarbean.barj; j < gsnmbarbean.barj + gsnmbarbean.barwidth; j++){
					// ԭʼ�� 0 ����Ϊ0
					if(GsnMainGameConstants.yuanshimapdata[rei][j] == 0){
						GsnMainGameConstants.dynamicmapdata[rei][j]= 0;
					}
				}
				for(int i = heightindex; i > 0; i--){
					barmatri[i] = barmatri[i - 1];
				}
				// ��һ�еĻ��� ��
				barmatri[0] = barmatri[0] - 1;
				break;
			case 1:// ���������ƶ�
				// ��ס��1��
				rei =  barmatri[0];
				// ��һ�����ûָ�
				for(int j = gsnmbarbean.barj; j < gsnmbarbean.barj + gsnmbarbean.barwidth; j++){
					// ԭʼ�� 0 ����Ϊ0
					if(GsnMainGameConstants.yuanshimapdata[rei][j] == 0){
						GsnMainGameConstants.dynamicmapdata[rei][j]= 0;
					}
				}
				for(int i = 0; i < heightindex; i++){
					barmatri[i] = barmatri[i + 1];
				}
				// ���һ�еĵĻ��� ��
				barmatri[heightindex] = barmatri[heightindex] + 1;
				break;
			case 2:// ���ҵ�����
				// ��ס�����1��
				rej =  barmatrj[widthindex];
				// ��һ�����ûָ�
				for(int i = gsnmbarbean.bari; i < gsnmbarbean.bari + gsnmbarbean.barheight; i++){
					// ԭʼ�� 0 ����Ϊ0
					if(GsnMainGameConstants.yuanshimapdata[i][rej] == 0){
						GsnMainGameConstants.dynamicmapdata[i][rej] = 0;
					}
				}
				for(int j = widthindex; j > 0 ; j--){
					barmatrj[j] = barmatrj[j - 1];
				}
				barmatrj[0] = barmatrj[0] - 1; 
				break;
			case 3:// ��������
				// ��ס��1��
				rej =  barmatrj[0];
				// ��һ�����ûָ�
				for(int i = gsnmbarbean.bari; i < gsnmbarbean.bari + gsnmbarbean.barheight; i++){
					// ԭʼ�� 0 ����Ϊ0
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
	// �Ƿ�ı䷽�� ��
	public void ischangeDir(){
		int istand,jstand;// �ƶ������� �б߽�
		// �������� �����Ͻǳ�ʼλ����
		switch(gsnmbarbean.bardir){// ��ԭʼ�ƶ�����Ϊ׼
			case 0:// ԭ�����Ϸ���
				// ԭ�����Ϸ��� ���ǵ�ǰ���������¿�ѡ
				switch (curdir) {
					// ��ǰ����
					case 0:
						if(barmatri[0] == gsnmbarbean.bari - gsnmbarbean.barwide){
							curdir = 1;
						}
						break;
					// ��ǰ���� �����һ����Ϊ׼
					case 1:
						if(barmatri[0] == gsnmbarbean.bari){
							curdir = 0;
						}
						break;
				}
			break;
			case 1:
				// ԭ�����·��� ���ǵ�ǰ���������¿�ѡ
				switch (curdir) {
					// ��ǰ����
					case 0:
						// �Ե�һ��Ϊ����
						if(barmatri[0] == gsnmbarbean.bari){
							curdir = 1;
						}
						break;
					case 1:
						// ��ǰ���� ������Ϊ����
						if(barmatri[heightindex] == gsnmbarbean.bari + heightindex + gsnmbarbean.barwide){
							curdir = 0;
						}
						break;
				}
			break;
			case 2:
				// ԭ�������� ���ǵ�ǰ���������ҿ�ѡ
				switch (curdir) {
					case 2:
						// ��ǰ����
						if(barmatrj[0] == gsnmbarbean.barj - gsnmbarbean.barwide){
							curdir = 3;
						}
						break;
					// ��ǰ���� 
					case 3:
						if(barmatrj[0] == gsnmbarbean.barj){
							curdir = 2;
						}
						break;
				}
			break;
			case 3:
				// ԭ�����ҷ��� ���ǵ�ǰ���������ҿ�ѡ
				switch (curdir) {
					// ��ǰ����
					case 2:
						// �Ե�һ��Ϊ����
						if(barmatrj[0] == gsnmbarbean.barj){
							curdir = 3;
						}
						break;
					case 3:
						// ��ǰ����  ������Ϊ����
						if(barmatrj[widthindex] == gsnmbarbean.barj + widthindex + gsnmbarbean.barwide){
							curdir = 2;
						}
						break;
				}
			break;			
		}
	}
	// �жϵ�ǰ��ij�ǲ����Լ���ǰռ�ݵ�
	public boolean isMeByIJ(int ii, int jj){
		for(int i = 0; i < gsnmbarbean.barheight; i++){
			for(int j = 0; j < gsnmbarbean.barwidth; j++){
				if(barmatri[i] == ii && barmatrj[j] == jj){
					return true;
				}
			}
		}
		return false;//���ؿ�
	}
	// ���¶�̬��ͼֵ�����ķ�Χ��0 ����û��ǽ�������
	public void updateMapValue(){
		// ��ǰռ�ݵľ���56
		for(int i = 0; i < gsnmbarbean.barheight; i++){
			for(int j = 0; j < gsnmbarbean.barwidth; j++){
				GsnMainGameConstants.dynamicmapdata[barmatri[i]][barmatrj[j]] = 56;
			}
		}
	}
	public void startMove(){
		isRun = true;// ��ʼ�߳�
	}
	public void endMove(){
		isRun = false;// ��ʼ�߳�
	}
	public void endThread(){// �˳�
		controlRun = false;
		isRun = false;
//		stop();
	}
	// �滭���Ի��ܶ���״
	Color yuan;
	public void draw(Graphics g){
		if(isChoose){
			yuan = g.getColor();
		}
		// ��ʼ�滭
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
			if(isRun && gsnmbarbean.barwide != 0){// ��Χ����Ϊ0 ��Ȼһֱ��
				try {
					Thread.sleep(gsnmbarbean.barspeed);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// ��Ϊ���õ�ͼֵΪ1 �����˻��������԰�ֵ�ı�һ�� �ƶ��������ð�
				if(isRun){
					move();
					updateMapValue();// ���ſ��ܻῨ
				}
			}
		}
//		System.out.println("�ϰ���ֹͣ������������������������");
	}
}

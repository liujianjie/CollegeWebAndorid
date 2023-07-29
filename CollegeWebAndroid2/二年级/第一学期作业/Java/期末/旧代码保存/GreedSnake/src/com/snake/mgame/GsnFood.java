package com.snake.mgame;

import java.awt.Graphics;
import java.util.Random;

import com.snake.mgameconfig.GsnMainGameConstants;

public class GsnFood extends Thread{
	public int curi;
	public int curj;
	boolean islive;// �Ƿ񻹴���
	boolean controlStart = true;//���ƿ�ʼ
	boolean isrun;// �Ƿ������߳�
	long updatetime;// ����λ��ʱ��
	int state;// ʲô����ʳ��ж�ʳ��ж�������ʳ���ͨʳ��߼�ʳ��
	
	public int curCount;// ��¼�Ǹ��¶��ٴεģ�Ϊ�˱��bfsʱ���Ƿ������
	
	Random ran = new Random();
	public GsnFood(){
		islive = false;
		isrun = false;
	}
	public void generate(){// ����ʳ��
		if(!islive){
			curi = ran.nextInt(41);
			curj = ran.nextInt(60);// ��һ������
			while(checkNotInOtherShape()){// ��������
				curi = ran.nextInt(41);
				curj = ran.nextInt(60);
			}
//			System.out.println(curi+" "+curj+" testgeneratefoodiandj");
			islive = true;
		}
	}
	public boolean checkNotInOtherShape(){// ����Ƿ�����ƽ����
		if(GsnMainGameConstants.dynamicmapdata[curi][curj] == 0){
			return false;
		}
		return true;
	}
	// �������´���
	public void deadUpdate(){
		islive = false;
		generate();
	}
	public void draw(Graphics g){
		if(islive){
			g.fillRoundRect(curj * GsnMainGameConstants.drawSize, curi * GsnMainGameConstants.drawSize, GsnMainGameConstants.drawSize, GsnMainGameConstants.drawSize
					, 8, 8);
		}
	}
	// ��ʼ����
	public void startUpdate(){// ����
		isrun = true;
	}
	public void endUpdate(){// ������
		isrun = false;
	}
	public void endThread(){
		controlStart = false;
		isrun = false;
//		stop();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(controlStart){
			System.out.print("");
			// ���߶�����������ʳ��λ��
			if(isrun){
				updatetime = (long)ran.nextInt(6000) + 12000;// 12~16s����
//				System.out.println(updatetime);
				try {
					Thread.sleep(updatetime);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				// ��˯�ٸ��� ������˯���������ͣ�ľͲ�Ҫ����
				if(isrun){
					deadUpdate();
					curCount++;
				}
			}
		}
//		System.out.println("ʳ��ֹͣ������������������������");
	}
}

package com.snake.bean;

import java.util.Arrays;

public class GsnMapSnakeBean {
	// Ĭ���ڵ�ͼ��ֻ��2��
	public int snnode;// ��ǰ�ж����߽�
	public int snmapi[] = new int[2];// ��ǰ�ڵ�ͼ�ǵ���
	public int snmapj[] = new int[2];// ��ǰ�ڵ�ͼ�ϵ���
	public int snmapdirection;// ����
	
	public GsnMapSnakeBean(GsnMapSnakeBean gs){
		snmapi = gs.snmapi.clone();
		snmapj = gs.snmapj.clone();
		snnode = gs.snnode;
		snmapdirection = gs.snmapdirection;
	}
	
	public GsnMapSnakeBean(){
		
	}
	public GsnMapSnakeBean(int snnode, int[] snmapi, int[] snmapj, int snmapdirection) {
		super();
		this.snnode = snnode;
		this.snmapi = snmapi;
		this.snmapj = snmapj;
		this.snmapdirection = snmapdirection;
	}
	public GsnMapSnakeBean(int nd, int di, int hi, int hj,int si,int sj){// �߽� ���򣬵�һ���ڵ�ij �ڶ����ڵ�ij
		// Ĭ����Ϣ ��һ��ͼû�г�ʼ��Ϣ
		snnode = nd;
		snmapdirection = di;
		snmapi[0] = hi;
		snmapj[0] = hj;
		snmapi[1] = si;
		snmapj[1] = sj;
	}
	// ���ݷ������ �ڶ����ڵ�
	public void CalSecondNodeByDir(int m ,int n){
		snmapi[0] = m;
		snmapj[0] = n;
		switch (snmapdirection) {
			case 2:
				snmapi[1] = snmapi[0];
				snmapj[1] = snmapj[0] - 1;
				break;
			case 3:
				snmapi[1] = snmapi[0] ;
				snmapj[1] = snmapj[0] + 1;
				break;	
			default:
				break;
		}
	}
	
	@Override
	public String toString() {
		return "snnode:" + snnode + "&snmapi:" + MyArrayToStr(snmapi) + "&snmapj:"
				+ MyArrayToStr(snmapj) + "&snmapdirection:" + snmapdirection + "";
	}
	// ����תstring
	public String MyArrayToStr(int ar[]){
		String str = "";
		for(int i = 0; i < ar.length; i++){
			str += ar[i];
			if(i != ar.length - 1){
				str += ",";
			}
		}
		return str;
	}
	
}

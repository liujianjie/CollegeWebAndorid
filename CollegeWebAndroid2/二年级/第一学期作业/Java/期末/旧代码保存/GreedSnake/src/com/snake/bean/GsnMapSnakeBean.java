package com.snake.bean;

import java.util.Arrays;

public class GsnMapSnakeBean {
	// 默认在地图上只有2节
	public int snnode;// 当前有多少蛇节
	public int snmapi[] = new int[2];// 当前在地图是的行
	public int snmapj[] = new int[2];// 当前在地图上的列
	public int snmapdirection;// 方向
	
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
	public GsnMapSnakeBean(int nd, int di, int hi, int hj,int si,int sj){// 蛇节 方向，第一个节点ij 第二个节点ij
		// 默认信息 万一地图没有初始信息
		snnode = nd;
		snmapdirection = di;
		snmapi[0] = hi;
		snmapj[0] = hj;
		snmapi[1] = si;
		snmapj[1] = sj;
	}
	// 根据方向组成 第二个节点
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
	// 数组转string
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

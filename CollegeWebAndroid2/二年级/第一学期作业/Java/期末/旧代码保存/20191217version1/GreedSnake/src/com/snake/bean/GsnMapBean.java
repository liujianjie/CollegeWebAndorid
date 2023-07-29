package com.snake.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.snake.mgameconfig.GsnMainGameConstants;

// 地图属性
public class GsnMapBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GsnMapInFoBean gsminfobean;

	// 移动障碍物属性
	public GsnMapBarrierMoveBean[] gsmbmbean; 

	public GsnMapFoodBean gsmfoodbean;
	
	// 在地图上蛇的信息
	public GsnMapSnakeBean[] gsmsnakebean;
	
	public byte mapdata[][] = new byte[41][60];//  600 * 410的中心游戏界面
	public List<GsnMapCrossNodeBean> gsmcrossnodebeanlist;
	
	// 修改地图的时候克隆
	public GsnMapBean(GsnMapBean gs){
		gsminfobean = new GsnMapInFoBean(gs.gsminfobean);
		
		gsmbmbean = new GsnMapBarrierMoveBean[gs.gsmbmbean.length];
		gsmbmbean = gs.gsmbmbean.clone();
		
		gsmfoodbean = new GsnMapFoodBean(gs.gsmfoodbean);
		
		gsmsnakebean = new GsnMapSnakeBean[gs.gsmsnakebean.length];
		for(int i = 0; i < gsmsnakebean.length; i++){
			gsmsnakebean[i] = new GsnMapSnakeBean(gs.gsmsnakebean[i]);
		}
		
		for(int m = 0; m < 41; m++){
			// 深拷贝
			mapdata[m] = gs.mapdata[m].clone(); 
		}
		
		// 穿越节点
		gsmcrossnodebeanlist = new ArrayList<GsnMapCrossNodeBean>();
		for(int i = 0; i < gs.gsmcrossnodebeanlist.size(); i++){
			GsnMapCrossNodeBean news = new GsnMapCrossNodeBean(gs.gsmcrossnodebeanlist.get(i));
			if(news != null){// 多余在编辑地图时就去除了吧
				gsmcrossnodebeanlist.add(news);
			}
		}
	}
	public GsnMapBean(){
		gsminfobean = new GsnMapInFoBean();
		gsmfoodbean = new GsnMapFoodBean();
		gsmsnakebean = new GsnMapSnakeBean[2];// 有2条蛇
		for(int j = 0; j < gsmsnakebean.length; j++){
			gsmsnakebean[j] = new GsnMapSnakeBean();
		}
//		giveSpace();
		// 
		gsmcrossnodebeanlist = new ArrayList<GsnMapCrossNodeBean>();
		
	}
	// 当读取了barcount后得到空间
	public void giveSpaceOfBar(){
		gsmbmbean = new GsnMapBarrierMoveBean[gsminfobean.barcount];
		for(int i = 0; i < gsmbmbean.length; i++){
			gsmbmbean[i] = new GsnMapBarrierMoveBean();
		}
	}
	// 我不控制输出行的换行
	@Override
	public String toString() {
		return  gsminfobean 
				+ "\n&关卡信息与关卡地图数据分割符&\n" + BararrToStr()
				+ "\n&关卡信息与关卡地图数据分割符&\n" + gsmfoodbean 
				+ "\n&关卡信息与关卡地图数据分割符&\n" + SnakearrToStr() 
				+ "\n&关卡信息与关卡地图数据分割符&\n" + crossNodeToStr() //穿越节点
				+ "\n&关卡信息与关卡地图数据分割符&\n" + mapToStr() + "";
	}
	// myarr to string
	public String BararrToStr(){
		String str = "";
		for(int i = 0; i < gsmbmbean.length; i++){
			str+=gsmbmbean[i];
			if(i != gsmbmbean.length - 1){
				str += "&&";
			}
		}
		return str;
	}
	// myarr to string
	public String SnakearrToStr(){
		String str = "";
		for(int i = 0; i < gsmsnakebean.length; i++){
			str+=gsmsnakebean[i];
			if(i != gsmsnakebean.length - 1){
				str += "&&";
			}
		}
		return str;
	}
	// 穿越节点
	public String crossNodeToStr(){
		String str = "";
		for(int i = 0; i < gsmcrossnodebeanlist.size(); i++){
			str+=gsmcrossnodebeanlist.get(i);
			if(i != gsmcrossnodebeanlist.size() - 1){
				str += "&&";
			}
		}
		return str;
	}
	// map
	public String mapToStr(){
		StringBuilder sb = new StringBuilder();
		for(int m = 0; m < 41; m++){
			for(int n = 0; n < 60; n++){
				sb.append((char)(mapdata[m][n] + '0'));// 要转换为字符
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		GsnMapBean m = new GsnMapBean();
		m.giveSpaceOfBar();
		System.out.println(m.toString());
	}
}

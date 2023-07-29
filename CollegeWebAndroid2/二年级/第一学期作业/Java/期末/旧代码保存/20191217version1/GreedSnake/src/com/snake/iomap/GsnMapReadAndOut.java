package com.snake.iomap;

import com.snake.bean.GsnMapBean;
import com.snake.bean.GsnMapCrossNodeBean;
import com.snake.bean.GsnMapSnakeBean;
import com.snake.bean.GsnRankBean;
import com.snake.mgame.GsnMainGameJPanel;
import com.snake.mgameconfig.GsnMainGameConstants;

// 地图管理，读取
public class GsnMapReadAndOut {
	// 具体实现io流的类
	GsnInputAndOut ga;
	// 得到的关卡类对象
//	GsnMapBean gsngamemap[];
	
	public GsnMapReadAndOut(){
		ga = new GsnInputAndOut();
	}
//	public void outRank(GsnRankBean gsk){
//		ga.outRank(gsk);
//	}
	// 重新读取地图
	public void readMapText(){
		ga.readMapTxt();// 开始读取了地图数据
	}
	// 从字符转换为地图数据
	public void changeMap(){
		String txtstr = ga.sb.toString();
		String txtarr[] = txtstr.split("&关卡与关卡分割符&");
		// 得到共多少关卡
		int totallevel = txtarr.length;// 最后一个
//		System.out.println(totallevel);
		
		GsnMainGameConstants.gsngamemap = new GsnMapBean[totallevel];
		for(int i = 0; i < GsnMainGameConstants.gsngamemap.length; i++){
			GsnMainGameConstants.gsngamemap[i] = new GsnMapBean();
		}
		
		// 对每个关卡对象设值
		String mapbeanarr[];// 有属性 有地图数据 后期有 移动障碍数据
		String mapbeanstr[];// 地图数据 属性值
		String st3[];
		
		String mapsnakebean[];// 地图 上蛇的初始信息 具体化一个bean
		String mapsnakebeanstr[];// 具体化一个bean的属性
		String mapsnakebeanstrcurij[];// 具体化蛇的i j
		
		// 穿越
		String mapcrossnodebean[];// 具体化一个bean
		String mapcrossnodestr[];// 具体化一个bean的属性
		String mapcrossnodestrij[];// 具体化蛇的i j
		for(int i = 0; i < totallevel; i++){
			mapbeanarr = txtarr[i].split("&关卡信息与关卡地图数据分割符&");// i 
			// 地图信息
			mapbeanstr = mapbeanarr[0].split("&");
			GsnMainGameConstants.gsngamemap[i].gsminfobean.authorname = getStrByfen(mapbeanstr[0]);
			GsnMainGameConstants.gsngamemap[i].gsminfobean.mapname = getStrByfen(mapbeanstr[1]);
			GsnMainGameConstants.gsngamemap[i].gsminfobean.mappwd = getStrByfen(mapbeanstr[2]);
			GsnMainGameConstants.gsngamemap[i].gsminfobean.creationtime = getStrByfen(mapbeanstr[3]);
			GsnMainGameConstants.gsngamemap[i].gsminfobean.tips = getStrByfen(mapbeanstr[4]);
			GsnMainGameConstants.gsngamemap[i].gsminfobean.barcount = getStrByfenToInt(mapbeanstr[5]);// 就是i 
			GsnMainGameConstants.gsngamemap[i].gsminfobean.levelorder = getStrByfenToInt(mapbeanstr[6]);// 就是i 
			GsnMainGameConstants.gsngamemap[i].gsminfobean.crossnodecount = getStrByfenToInt(mapbeanstr[7]);// 就是i
			
			// 障碍物
			GsnMainGameConstants.gsngamemap[i].giveSpaceOfBar();// 空间
			mapbeanstr = mapbeanarr[1].split("&&");
			for(int j = 0; j < GsnMainGameConstants.gsngamemap[i].gsminfobean.barcount; j++){
				st3 = mapbeanstr[j].split("&");
				GsnMainGameConstants.gsngamemap[i].gsmbmbean[j].bari = getStrByfenToInt(st3[0]);
				GsnMainGameConstants.gsngamemap[i].gsmbmbean[j].barj = getStrByfenToInt(st3[1]);
				GsnMainGameConstants.gsngamemap[i].gsmbmbean[j].barwidth = getStrByfenToInt(st3[2]);
				GsnMainGameConstants.gsngamemap[i].gsmbmbean[j].barheight = getStrByfenToInt(st3[3]);
				GsnMainGameConstants.gsngamemap[i].gsmbmbean[j].bardir = getStrByfenToInt(st3[4]);
				GsnMainGameConstants.gsngamemap[i].gsmbmbean[j].barwide = getStrByfenToInt(st3[5]);
				GsnMainGameConstants.gsngamemap[i].gsmbmbean[j].barspeed = getStrByfenToInt(st3[6]);
//				System.out.println(GsnMainGameConstants.gsngamemap[i].gsmbmbean[j].barspeed);
			}
			
			// 食物多少
			GsnMainGameConstants.gsngamemap[i].gsmfoodbean.foodlength = getStrByfenToInt(mapbeanarr[2]);
			
			// 地图上蛇的信息 很麻烦。 决定将蛇的初始化信息放置在文件中
			mapsnakebean = mapbeanarr[3].split("&&");
//			System.out.println(mapsnakebean.length);
			for(int j = 0; j < mapsnakebean.length; j++){
				mapsnakebeanstr = mapsnakebean[j].split("&");
				GsnMainGameConstants.gsngamemap[i].gsmsnakebean[j].snnode = getStrByfenToInt(mapsnakebeanstr[0]); 
				
				// 两个蛇节的i坐标
				mapsnakebeanstrcurij = getStrByfen(mapsnakebeanstr[1]).split(",");
				GsnMainGameConstants.gsngamemap[i].gsmsnakebean[j].snmapi[0] = Integer.valueOf(mapsnakebeanstrcurij[0]);
				GsnMainGameConstants.gsngamemap[i].gsmsnakebean[j].snmapi[1] = Integer.valueOf(mapsnakebeanstrcurij[1]);
				
				// 两个蛇节的j坐标
				mapsnakebeanstrcurij = getStrByfen(mapsnakebeanstr[2]).split(",");
				GsnMainGameConstants.gsngamemap[i].gsmsnakebean[j].snmapj[0] = Integer.valueOf(mapsnakebeanstrcurij[0]);
				GsnMainGameConstants.gsngamemap[i].gsmsnakebean[j].snmapj[1] = Integer.valueOf(mapsnakebeanstrcurij[1]);
				
				// 蛇节的方向
				GsnMainGameConstants.gsngamemap[i].gsmsnakebean[j].snmapdirection = getStrByfenToInt(mapsnakebeanstr[3]);
				
				// 蛇的地图信息
//				System.out.println(GsnMainGameConstants.gsngamemap[i].gsmsnakebean[j].snmapi[0]+" "+GsnMainGameConstants.gsngamemap[i].gsmsnakebean[j].snmapj[0]);
//				System.out.println(GsnMainGameConstants.gsngamemap[i].gsmsnakebean[j].snmapi[1]+" "+GsnMainGameConstants.gsngamemap[i].gsmsnakebean[j].snmapj[1]);
			}
			// 穿越
			mapcrossnodebean = mapbeanarr[4].split("&&");
			for(int j = 0; j < GsnMainGameConstants.gsngamemap[i].gsminfobean.crossnodecount; j++){
				mapcrossnodestr = mapcrossnodebean[j].split("&");// 分开是第一个和第二个位置
				
				// 第一个
				mapcrossnodestrij = getStrByfen(mapcrossnodestr[0]).split(",");
				// 直接new实体
				GsnMapCrossNodeBean gcn = new GsnMapCrossNodeBean();
				gcn.firstpos[0] = Integer.valueOf(mapcrossnodestrij[0]);
				gcn.firstpos[1] = Integer.valueOf(mapcrossnodestrij[1]);
				
				// 第二个
				mapcrossnodestrij = getStrByfen(mapcrossnodestr[1]).split(",");
				gcn.secondpos[0] = Integer.valueOf(mapcrossnodestrij[0]);
				gcn.secondpos[1] = Integer.valueOf(mapcrossnodestrij[1]);
				
				GsnMainGameConstants.gsngamemap[i].gsmcrossnodebeanlist.add(gcn);
			}
			
			// 地图数据
			// 弄错了行列。
			for(int m = 0; m < 41; m++){
				for(int n = 0; n < 60; n++){
					GsnMainGameConstants.gsngamemap[i].mapdata[m][n] = (byte) (mapbeanarr[5].charAt(60 * m + n) - '0');// 很麻烦
				}
			}
		}
	}
	// 读取排行榜
	
	// 提取信息的公共方法
	public String getStrByfen(String st){// 提取一个字符由：隔开的数据，即：level:1
		return st.substring(st.indexOf(":") + 1);
	}
	public int getStrByfenToInt(String st){//  提取一个字符由：隔开的数据，即：level:1 并转换为int
		return Integer.valueOf(getStrByfen(st));
	}
	// 读取 一个地图 从String读
	
	// 输出 就是在map.txt中添加一段string
	public void outNewMap(GsnMapBean gmb){
		ga.outTxt(gmb.toString());
	}
	
	// 修改的输出
	public void alterMap(GsnMapBean gmb){
		// 1.从原string替换 当前string，然后输出string
		ga.alterText(gmb);
	}
	public void delMap(){
		// 1.从原string替换 当前string，然后输出string
		ga.delMap();
	}
	public void outRank(GsnRankBean s){
		ga.outRank(s);
	}
	// 读取排行榜
	public void readRank(){
		ga.readRank();// 开始读取了地图数据
		// 开始转换
		String txtstr = ga.ranksb.toString();
		if(!txtstr.trim().equals("")){
			String txtarr[] = txtstr.split("人人分割");
			// 得到共多少数据
			int totalCount = txtarr.length;// 最后一个
//			System.out.println(totalCount);
			
			String rankbenarr[];
			GsnMainGameConstants.gsnrankbeanarr = new GsnRankBean[totalCount];
			for(int i = 0; i < GsnMainGameConstants.gsnrankbeanarr.length; i++){
				GsnMainGameConstants.gsnrankbeanarr[i] = new GsnRankBean();
				// 地图信息
				rankbenarr = txtarr[i].split("&");
				GsnMainGameConstants.gsnrankbeanarr[i].setName(getStrByfen(rankbenarr[0]));
				GsnMainGameConstants.gsnrankbeanarr[i].setSocre(getStrByfenToInt(rankbenarr[1]));
				GsnMainGameConstants.gsnrankbeanarr[i].setDate(getStrByfen(rankbenarr[2]));
				
			}
			
		}
	}
	public static void main(String[] args) {
//		new GsnMapReadAndOut().changeMap();
	}
}

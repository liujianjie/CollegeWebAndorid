package com.snake.iomap;

import com.snake.bean.GsnMapBean;
import com.snake.bean.GsnMapCrossNodeBean;
import com.snake.bean.GsnMapSnakeBean;
import com.snake.bean.GsnRankBean;
import com.snake.mgame.GsnMainGameJPanel;
import com.snake.mgameconfig.GsnMainGameConstants;

// ��ͼ������ȡ
public class GsnMapReadAndOut {
	// ����ʵ��io������
	GsnInputAndOut ga;
	// �õ��Ĺؿ������
//	GsnMapBean gsngamemap[];
	
	public GsnMapReadAndOut(){
		ga = new GsnInputAndOut();
	}
//	public void outRank(GsnRankBean gsk){
//		ga.outRank(gsk);
//	}
	// ���¶�ȡ��ͼ
	public void readMapText(){
		ga.readMapTxt();// ��ʼ��ȡ�˵�ͼ����
	}
	// ���ַ�ת��Ϊ��ͼ����
	public void changeMap(){
		String txtstr = ga.sb.toString();
		String txtarr[] = txtstr.split("&�ؿ���ؿ��ָ��&");
		// �õ������ٹؿ�
		int totallevel = txtarr.length;// ���һ��
//		System.out.println(totallevel);
		
		GsnMainGameConstants.gsngamemap = new GsnMapBean[totallevel];
		for(int i = 0; i < GsnMainGameConstants.gsngamemap.length; i++){
			GsnMainGameConstants.gsngamemap[i] = new GsnMapBean();
		}
		
		// ��ÿ���ؿ�������ֵ
		String mapbeanarr[];// ������ �е�ͼ���� ������ �ƶ��ϰ�����
		String mapbeanstr[];// ��ͼ���� ����ֵ
		String st3[];
		
		String mapsnakebean[];// ��ͼ ���ߵĳ�ʼ��Ϣ ���廯һ��bean
		String mapsnakebeanstr[];// ���廯һ��bean������
		String mapsnakebeanstrcurij[];// ���廯�ߵ�i j
		
		// ��Խ
		String mapcrossnodebean[];// ���廯һ��bean
		String mapcrossnodestr[];// ���廯һ��bean������
		String mapcrossnodestrij[];// ���廯�ߵ�i j
		for(int i = 0; i < totallevel; i++){
			mapbeanarr = txtarr[i].split("&�ؿ���Ϣ��ؿ���ͼ���ݷָ��&");// i 
			// ��ͼ��Ϣ
			mapbeanstr = mapbeanarr[0].split("&");
			GsnMainGameConstants.gsngamemap[i].gsminfobean.authorname = getStrByfen(mapbeanstr[0]);
			GsnMainGameConstants.gsngamemap[i].gsminfobean.mapname = getStrByfen(mapbeanstr[1]);
			GsnMainGameConstants.gsngamemap[i].gsminfobean.mappwd = getStrByfen(mapbeanstr[2]);
			GsnMainGameConstants.gsngamemap[i].gsminfobean.creationtime = getStrByfen(mapbeanstr[3]);
			GsnMainGameConstants.gsngamemap[i].gsminfobean.tips = getStrByfen(mapbeanstr[4]);
			GsnMainGameConstants.gsngamemap[i].gsminfobean.barcount = getStrByfenToInt(mapbeanstr[5]);// ����i 
			GsnMainGameConstants.gsngamemap[i].gsminfobean.levelorder = getStrByfenToInt(mapbeanstr[6]);// ����i 
			GsnMainGameConstants.gsngamemap[i].gsminfobean.crossnodecount = getStrByfenToInt(mapbeanstr[7]);// ����i
			
			// �ϰ���
			GsnMainGameConstants.gsngamemap[i].giveSpaceOfBar();// �ռ�
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
			
			// ʳ�����
			GsnMainGameConstants.gsngamemap[i].gsmfoodbean.foodlength = getStrByfenToInt(mapbeanarr[2]);
			
			// ��ͼ���ߵ���Ϣ ���鷳�� �������ߵĳ�ʼ����Ϣ�������ļ���
			mapsnakebean = mapbeanarr[3].split("&&");
//			System.out.println(mapsnakebean.length);
			for(int j = 0; j < mapsnakebean.length; j++){
				mapsnakebeanstr = mapsnakebean[j].split("&");
				GsnMainGameConstants.gsngamemap[i].gsmsnakebean[j].snnode = getStrByfenToInt(mapsnakebeanstr[0]); 
				
				// �����߽ڵ�i����
				mapsnakebeanstrcurij = getStrByfen(mapsnakebeanstr[1]).split(",");
				GsnMainGameConstants.gsngamemap[i].gsmsnakebean[j].snmapi[0] = Integer.valueOf(mapsnakebeanstrcurij[0]);
				GsnMainGameConstants.gsngamemap[i].gsmsnakebean[j].snmapi[1] = Integer.valueOf(mapsnakebeanstrcurij[1]);
				
				// �����߽ڵ�j����
				mapsnakebeanstrcurij = getStrByfen(mapsnakebeanstr[2]).split(",");
				GsnMainGameConstants.gsngamemap[i].gsmsnakebean[j].snmapj[0] = Integer.valueOf(mapsnakebeanstrcurij[0]);
				GsnMainGameConstants.gsngamemap[i].gsmsnakebean[j].snmapj[1] = Integer.valueOf(mapsnakebeanstrcurij[1]);
				
				// �߽ڵķ���
				GsnMainGameConstants.gsngamemap[i].gsmsnakebean[j].snmapdirection = getStrByfenToInt(mapsnakebeanstr[3]);
				
				// �ߵĵ�ͼ��Ϣ
//				System.out.println(GsnMainGameConstants.gsngamemap[i].gsmsnakebean[j].snmapi[0]+" "+GsnMainGameConstants.gsngamemap[i].gsmsnakebean[j].snmapj[0]);
//				System.out.println(GsnMainGameConstants.gsngamemap[i].gsmsnakebean[j].snmapi[1]+" "+GsnMainGameConstants.gsngamemap[i].gsmsnakebean[j].snmapj[1]);
			}
			// ��Խ
			mapcrossnodebean = mapbeanarr[4].split("&&");
			for(int j = 0; j < GsnMainGameConstants.gsngamemap[i].gsminfobean.crossnodecount; j++){
				mapcrossnodestr = mapcrossnodebean[j].split("&");// �ֿ��ǵ�һ���͵ڶ���λ��
				
				// ��һ��
				mapcrossnodestrij = getStrByfen(mapcrossnodestr[0]).split(",");
				// ֱ��newʵ��
				GsnMapCrossNodeBean gcn = new GsnMapCrossNodeBean();
				gcn.firstpos[0] = Integer.valueOf(mapcrossnodestrij[0]);
				gcn.firstpos[1] = Integer.valueOf(mapcrossnodestrij[1]);
				
				// �ڶ���
				mapcrossnodestrij = getStrByfen(mapcrossnodestr[1]).split(",");
				gcn.secondpos[0] = Integer.valueOf(mapcrossnodestrij[0]);
				gcn.secondpos[1] = Integer.valueOf(mapcrossnodestrij[1]);
				
				GsnMainGameConstants.gsngamemap[i].gsmcrossnodebeanlist.add(gcn);
			}
			
			// ��ͼ����
			// Ū�������С�
			for(int m = 0; m < 41; m++){
				for(int n = 0; n < 60; n++){
					GsnMainGameConstants.gsngamemap[i].mapdata[m][n] = (byte) (mapbeanarr[5].charAt(60 * m + n) - '0');// ���鷳
				}
			}
		}
	}
	// ��ȡ���а�
	
	// ��ȡ��Ϣ�Ĺ�������
	public String getStrByfen(String st){// ��ȡһ���ַ��ɣ����������ݣ�����level:1
		return st.substring(st.indexOf(":") + 1);
	}
	public int getStrByfenToInt(String st){//  ��ȡһ���ַ��ɣ����������ݣ�����level:1 ��ת��Ϊint
		return Integer.valueOf(getStrByfen(st));
	}
	// ��ȡ һ����ͼ ��String��
	
	// ��� ������map.txt�����һ��string
	public void outNewMap(GsnMapBean gmb){
		ga.outTxt(gmb.toString());
	}
	
	// �޸ĵ����
	public void alterMap(GsnMapBean gmb){
		// 1.��ԭstring�滻 ��ǰstring��Ȼ�����string
		ga.alterText(gmb);
	}
	public void delMap(){
		// 1.��ԭstring�滻 ��ǰstring��Ȼ�����string
		ga.delMap();
	}
	public void outRank(GsnRankBean s){
		ga.outRank(s);
	}
	// ��ȡ���а�
	public void readRank(){
		ga.readRank();// ��ʼ��ȡ�˵�ͼ����
		// ��ʼת��
		String txtstr = ga.ranksb.toString();
		if(!txtstr.trim().equals("")){
			String txtarr[] = txtstr.split("���˷ָ�");
			// �õ�����������
			int totalCount = txtarr.length;// ���һ��
//			System.out.println(totalCount);
			
			String rankbenarr[];
			GsnMainGameConstants.gsnrankbeanarr = new GsnRankBean[totalCount];
			for(int i = 0; i < GsnMainGameConstants.gsnrankbeanarr.length; i++){
				GsnMainGameConstants.gsnrankbeanarr[i] = new GsnRankBean();
				// ��ͼ��Ϣ
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

package com.snake.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.snake.mgameconfig.GsnMainGameConstants;

// ��ͼ����
public class GsnMapBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GsnMapInFoBean gsminfobean;

	// �ƶ��ϰ�������
	public GsnMapBarrierMoveBean[] gsmbmbean; 

	public GsnMapFoodBean gsmfoodbean;
	
	// �ڵ�ͼ���ߵ���Ϣ
	public GsnMapSnakeBean[] gsmsnakebean;
	
	public byte mapdata[][] = new byte[41][60];//  600 * 410��������Ϸ����
	public List<GsnMapCrossNodeBean> gsmcrossnodebeanlist;
	
	// �޸ĵ�ͼ��ʱ���¡
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
			// ���
			mapdata[m] = gs.mapdata[m].clone(); 
		}
		
		// ��Խ�ڵ�
		gsmcrossnodebeanlist = new ArrayList<GsnMapCrossNodeBean>();
		for(int i = 0; i < gs.gsmcrossnodebeanlist.size(); i++){
			GsnMapCrossNodeBean news = new GsnMapCrossNodeBean(gs.gsmcrossnodebeanlist.get(i));
			if(news != null){// �����ڱ༭��ͼʱ��ȥ���˰�
				gsmcrossnodebeanlist.add(news);
			}
		}
	}
	public GsnMapBean(){
		gsminfobean = new GsnMapInFoBean();
		gsmfoodbean = new GsnMapFoodBean();
		gsmsnakebean = new GsnMapSnakeBean[2];// ��2����
		for(int j = 0; j < gsmsnakebean.length; j++){
			gsmsnakebean[j] = new GsnMapSnakeBean();
		}
//		giveSpace();
		// 
		gsmcrossnodebeanlist = new ArrayList<GsnMapCrossNodeBean>();
		
	}
	// ����ȡ��barcount��õ��ռ�
	public void giveSpaceOfBar(){
		gsmbmbean = new GsnMapBarrierMoveBean[gsminfobean.barcount];
		for(int i = 0; i < gsmbmbean.length; i++){
			gsmbmbean[i] = new GsnMapBarrierMoveBean();
		}
	}
	// �Ҳ���������еĻ���
	@Override
	public String toString() {
		return  gsminfobean 
				+ "\n&�ؿ���Ϣ��ؿ���ͼ���ݷָ��&\n" + BararrToStr()
				+ "\n&�ؿ���Ϣ��ؿ���ͼ���ݷָ��&\n" + gsmfoodbean 
				+ "\n&�ؿ���Ϣ��ؿ���ͼ���ݷָ��&\n" + SnakearrToStr() 
				+ "\n&�ؿ���Ϣ��ؿ���ͼ���ݷָ��&\n" + crossNodeToStr() //��Խ�ڵ�
				+ "\n&�ؿ���Ϣ��ؿ���ͼ���ݷָ��&\n" + mapToStr() + "";
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
	// ��Խ�ڵ�
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
				sb.append((char)(mapdata[m][n] + '0'));// Ҫת��Ϊ�ַ�
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

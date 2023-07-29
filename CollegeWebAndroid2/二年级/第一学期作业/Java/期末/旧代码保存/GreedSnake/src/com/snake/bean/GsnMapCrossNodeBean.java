package com.snake.bean;

public class GsnMapCrossNodeBean {
	public int firstpos[];// 0��i
	public int secondpos[];
	public GsnMapCrossNodeBean(){
		firstpos = new int[2];
		secondpos = new int[2];
	}
	// ��¡
	public GsnMapCrossNodeBean(GsnMapCrossNodeBean g){
		firstpos = g.firstpos.clone();
		secondpos = g.secondpos.clone();
	}
	@Override
	public String toString() {
		return "firstpos:" + MyArrayToStr(firstpos) + "&secondpos:" + MyArrayToStr(secondpos);
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

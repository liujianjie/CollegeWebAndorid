package com.snake.bean;
// 游戏设置的bean 
public class GsnSettingBean {
	public int computercount;// 默认为1

	public GsnSettingBean(){
		computercount = 1;
	}
	@Override
	public String toString() {
		return "computercount=" + computercount;
	}
	public static void main(String[] args) {
		GsnSettingBean s = new GsnSettingBean();
		s.computercount = 2;
		System.out.println(s);
	}
}

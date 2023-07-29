package com.snake.bean;

// 地图障碍物属性 一条障碍物 根据方向和count来组成障碍条
public class GsnMapBarrierMoveBean {
	public int bari;// 左上角位置y
	public int barj;// 左上角位置x
	public int barwidth;// 移动的宽度 x
	public int barheight;// 移动的高度 y
	public int bardir;// 方向 只有上下 和 左右，0是上下，1是左右
	public int barwide;// 移动的格子有多少个 
	public long barspeed;// 是线程 多少s
	@Override
	public String toString() {
		return "bari:" + bari + 
				"&barj:" + barj + 
				"&barwidth:" + barwidth+ 
				"&barheight:"+barheight+
				"&bardir:" + bardir + 
				"&barwide:" + barwide +
				"&barspeed:" + barspeed + "";
	}
	public static void main(String[] args) {
//		System.out.println(new GsnMapBarrierMoveBean());
	}
}
package com.snake.bean;

public class GsnMapFoodBean {
	public int foodlength;// ���ٸ�ʳ��

	@Override
	public String toString() {
		return "foodlength:" + foodlength + "";
	}
	public GsnMapFoodBean(){
		
	}
	public GsnMapFoodBean(GsnMapFoodBean g){
		this.foodlength = g.foodlength;
	}
}

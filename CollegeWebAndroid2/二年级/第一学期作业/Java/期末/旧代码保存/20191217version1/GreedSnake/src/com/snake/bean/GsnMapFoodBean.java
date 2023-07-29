package com.snake.bean;

public class GsnMapFoodBean {
	public int foodlength;// 多少个食物

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

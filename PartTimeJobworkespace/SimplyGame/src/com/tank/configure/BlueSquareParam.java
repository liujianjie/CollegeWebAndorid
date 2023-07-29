package com.tank.configure;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.tank.main.GameMainPanel;

public class BlueSquareParam {
	
	Random rdom = new Random();//随机函数
	
	//高度和宽度
	public static final int WIDTH = 40;
	public static final int HEIGHT = 40;
	
	public int bsquarex; 
	public int bsquarey;
	
	private static List<BlueSquareParam> bluesqlist = new ArrayList<BlueSquareParam>();
	
	public BlueSquareParam(){
		setRandomXY();
	}	
	private void setRandomXY(){
		int retanky = TankParam.tanky;
		int retankx = TankParam.tankx;
		bsquarex = rdom.nextInt(800) + 20;//比x低点
		while(bsquarex %40 != 0){
			bsquarex++;
		}
		
		bsquarey = rdom.nextInt(600) + 20; //比y低点
		while(bsquarey%40 != 0){
			bsquarey++;
		}
//		System.out.println(!(bsquarex <= (retankx - 40)));
		//为了不让出现2x2区域 加上squeare区域 
		//左上角
		if(retankx - 40 < bsquarex   && bsquarex < retankx && retanky - 40 < bsquarey && bsquarey < retanky + 40 ){
			System.out.println("once");
			while(! (bsquarex %40 == 0 && bsquarex <= (retankx - 40)) ){
				bsquarex--;
			}
			System.out.println(bsquarex);
		}
		//右上角
		if(retankx < bsquarex && bsquarex < retankx + 40 && retanky - 40 < bsquarey && bsquarey < retanky + 40){
			System.out.println("twice");
			while(! (bsquarex %40 == 0 && bsquarex >= (retankx + 40)) ){
				bsquarex++;
			}
		}
		//左下角
//		if(retanky < bsquarey && bsquarey < retanky + 40){
//			System.out.println("左下角 或 右下角");
//			while(! (bsquarey %40 == 0 && bsquarey >= (retanky + 40)) ){
//				bsquarey++;
//			}
//		}
		//右下角
//		if(tanky > bsquarey && tanky + 40 <bsquarey){
//			bsquarey++;
//			while(bsquarey %40 != 0){
//				bsquarey++;
//			}
//		}
	}
	public void cleandraw(Graphics g){
		Color c = g.getColor();
		g.setColor(Color.WHITE);
		g.fillRect(bsquarex, bsquarey, WIDTH, HEIGHT);
		g.setColor(c);
	}
	public void draw(Graphics g,int tankx,int tanky){

		Color c = g.getColor();
		g.setColor(Color.BLUE);
		g.fillRect(bsquarex, bsquarey, WIDTH, HEIGHT);
		g.setColor(c);
		
    }
}

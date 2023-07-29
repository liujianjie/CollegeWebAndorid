package com.tank.configure;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class YellowSquareParam {
	public static final int WIDTH = 20;
	public static final int HEIGHT =20;
	
	public static int ysx;
	public static int ysy;
	
	public boolean exist = false;
	
	Random rdom = new Random();//Ëæ»úº¯Êý
	
	public YellowSquareParam(){
	}
	
	public void setRandomXY(){
		ysx = rdom.nextInt(800) + 20;
		while(ysx %20 != 0){
			ysx++;
		}
		
		ysy = rdom.nextInt(600) + 20; 
		while(ysy%20 != 0){
			ysy++;
		}
		
	}
	
	public void cleandraw(Graphics g){
		Color c = g.getColor();
		g.setColor(Color.WHITE);
		g.fillRect(ysx, ysy, WIDTH, HEIGHT);
		g.setColor(c);
		exist = false;
	}
	public void draw(Graphics g){
		if(exist == false){
			setRandomXY();
		}
		Color c = g.getColor();
		g.setColor(Color.YELLOW);
		g.fillRect(ysx, ysy, WIDTH, HEIGHT);
		g.setColor(c);
		exist = true;
    }
}

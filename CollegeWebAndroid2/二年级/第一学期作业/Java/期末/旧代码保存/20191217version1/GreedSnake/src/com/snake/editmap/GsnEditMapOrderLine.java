package com.snake.editmap;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;


// 编辑地图的线条
public class GsnEditMapOrderLine {
	int pos[];// 位置点 0是x，1是y
	
	Image imag1;
	Image imag2;
	// 图片资源
	String imgpath = "editmapimg";// 文件夹
	
	GsnEditMapMainGameAreaJPanel geditmapgamearea;
	public GsnEditMapOrderLine(GsnEditMapMainGameAreaJPanel geditmapgamearea){
		// 加载图片
		imag1 = new ImageIcon(imgpath+"/pospointblues.png").getImage();
		imag2= new ImageIcon(imgpath+"/pospointblueh.png").getImage();
		this.geditmapgamearea = geditmapgamearea;
		
		pos = new int[2];
	}
	public void setPos(int p[]){
		pos = p;
	}
	public void draw(Graphics g){
		// x 的一列， y的一列
		// 先列
		for(int i = 0; i < 41; i++){
			if(i !=  pos[1]){
				g.drawImage(imag1, pos[0] * 10, i * 10, geditmapgamearea);
			}
		}
		// 再行
		for(int i = 0; i < 60; i++){
			if(i !=  pos[0]){
				g.drawImage(imag2, i * 10 , pos[1] * 10, geditmapgamearea);
			}
		}
	}
}

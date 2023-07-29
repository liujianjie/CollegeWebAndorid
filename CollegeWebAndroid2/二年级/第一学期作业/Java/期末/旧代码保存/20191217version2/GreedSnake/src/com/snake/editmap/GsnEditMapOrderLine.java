package com.snake.editmap;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;


// �༭��ͼ������
public class GsnEditMapOrderLine {
	int pos[];// λ�õ� 0��x��1��y
	
	Image imag1;
	Image imag2;
	// ͼƬ��Դ
	String imgpath = "editmapimg";// �ļ���
	
	GsnEditMapMainGameAreaJPanel geditmapgamearea;
	public GsnEditMapOrderLine(GsnEditMapMainGameAreaJPanel geditmapgamearea){
		// ����ͼƬ
		imag1 = new ImageIcon(imgpath+"/pospointblues.png").getImage();
		imag2= new ImageIcon(imgpath+"/pospointblueh.png").getImage();
		this.geditmapgamearea = geditmapgamearea;
		
		pos = new int[2];
	}
	public void setPos(int p[]){
		pos = p;
	}
	public void draw(Graphics g){
		// x ��һ�У� y��һ��
		// ����
		for(int i = 0; i < 41; i++){
			if(i !=  pos[1]){
				g.drawImage(imag1, pos[0] * 10, i * 10, geditmapgamearea);
			}
		}
		// ����
		for(int i = 0; i < 60; i++){
			if(i !=  pos[0]){
				g.drawImage(imag2, i * 10 , pos[1] * 10, geditmapgamearea);
			}
		}
	}
}

package com.tank.configure;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.tank.main.GameMainPanel;

public class BlueSquareParam {
	
	Random rdom = new Random();//�������
	
	//�߶ȺͿ��
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
		bsquarex = rdom.nextInt(800) + 20;//��x�͵�
		while(bsquarex %40 != 0){
			bsquarex++;
		}
		
		bsquarey = rdom.nextInt(600) + 20; //��y�͵�
		while(bsquarey%40 != 0){
			bsquarey++;
		}
//		System.out.println(!(bsquarex <= (retankx - 40)));
		//Ϊ�˲��ó���2x2���� ����squeare���� 
		//���Ͻ�
		if(retankx - 40 < bsquarex   && bsquarex < retankx && retanky - 40 < bsquarey && bsquarey < retanky + 40 ){
			System.out.println("once");
			while(! (bsquarex %40 == 0 && bsquarex <= (retankx - 40)) ){
				bsquarex--;
			}
			System.out.println(bsquarex);
		}
		//���Ͻ�
		if(retankx < bsquarex && bsquarex < retankx + 40 && retanky - 40 < bsquarey && bsquarey < retanky + 40){
			System.out.println("twice");
			while(! (bsquarex %40 == 0 && bsquarex >= (retankx + 40)) ){
				bsquarex++;
			}
		}
		//���½�
//		if(retanky < bsquarey && bsquarey < retanky + 40){
//			System.out.println("���½� �� ���½�");
//			while(! (bsquarey %40 == 0 && bsquarey >= (retanky + 40)) ){
//				bsquarey++;
//			}
//		}
		//���½�
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

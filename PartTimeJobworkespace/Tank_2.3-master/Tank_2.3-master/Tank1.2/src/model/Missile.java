package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import client.TankClient;
import model.Tank.Direction;

public class Missile {

	//����������������ʾ�˶����ٶ�
	private static final int XSPEED = 10;
	private static final int YSPEED = 10;
	
	//�ӵ����ڵ�λ��
	private int x;
	private int y;
	
	//̹�˵ĸ߶ȺͿ��
	public static final int WIDTH = 30;
	public static final int HEIGHT = 30;
	
	//�ӵ������з���
	private Direction dir;
	
	private boolean live = true;
	
	public Missile(int x, int y, Direction dir) {
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
	public void draw(Graphics g){
		Color c = g.getColor();
		g.setColor(Color.YELLOW);
		g.fillOval(x, y, 5, 5);
		g.setColor(c);
		move();
	}

	private void move() {
		if(dir==Direction.L){//L,LU,U,RU,R,RD,D,LD,STOP
			x -= XSPEED;
		}
		else if(dir==Direction.LU){
			x -= XSPEED;
			y -= YSPEED;
		}
		else if(dir==Direction.U){
			y -= YSPEED;
		}
		else if(dir==Direction.RU){
			x += XSPEED;
			y -= YSPEED;
		}
		else if(dir==Direction.R){
			x += XSPEED;
		}
		else if(dir==Direction.RD){
			x += XSPEED;
			y += YSPEED;
		}
		else if(dir==Direction.D){
			y += YSPEED;
		}
		else if(dir==Direction.LD){
			x -= XSPEED;
			y += YSPEED;
		}
		
		//�����ӵ����ڵ�λ��x,y���ж��ӵ��Ƿ񻹴����
		if(x<0||x>TankClient.GAME_WIDTH||y<0||y>TankClient.GAME_HEIGHT){
			live = false;
		}
	}
	public boolean isLive() {	
		return live;
	}
}

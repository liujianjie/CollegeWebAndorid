package com.tank.configure;

import java.awt.Color;
import java.awt.Graphics;

import com.tank.configure.TankParam.Direction;
import com.tank.main.GameMainIterFace;


public class MissileParam {
	 //����������������ʾ�˶����ٶ�
    private static final int XSPEED = 12;
    private static final int YSPEED = 12;
    
    public static final int WIDTH = 6;
	public static final int HEIGHT = 6;

    //�ӵ����ڵ�λ��
	public int misx;
	public int misy;
    
    private boolean live = true;
    
    //�ӵ������з���
    private Direction dir;

    public  MissileParam(int x, int y, Direction dir) {
        this.misx = x;
        this.misy = y;
        this.dir = dir;
    }
    public void draw(Graphics g){
        Color c = g.getColor();
        g.setColor(Color.RED);
        g.fillOval(misx, misy, WIDTH, HEIGHT);
        g.setColor(c);
        move();
    }
    public void cleandraw(Graphics g){
    	Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.fillOval(misx, misy, WIDTH, HEIGHT);
        g.setColor(c);
//        live = false;
    }


    private void move() {
        if(dir == Direction.L){//L,LU,U,RU,R,RD,D,LD,STOP
        	misx -= XSPEED;
        }
        else if(dir == Direction.LU){
        	misx -= XSPEED;
            misy -= YSPEED;
        }
        else if(dir == Direction.U){
        	misy -= YSPEED;
        }
        else if(dir == Direction.RU){
        	misx += XSPEED;
            misy -= YSPEED;
        }
        else if(dir == Direction.R){
        	misx += XSPEED;
        }
        else if(dir == Direction.RD){
        	misx += XSPEED;
            misy += YSPEED;
        }
        else if(dir == Direction.D){
        	misy += YSPEED;
        }
        else if(dir == Direction.LD){
        	misx -= XSPEED;
            misy += YSPEED;
        }
        //�����ӵ����ڵ�λ��x,y���ж��ӵ��Ƿ񻹴����
  		if(misx<0 || misx>GameMainIterFace.GAME_WIDTH || misy<0 || misy>GameMainIterFace.GAME_HEIGHT){
  			live = false;
  		}
    }
    public boolean isLive() {	
		return live;
	}
}

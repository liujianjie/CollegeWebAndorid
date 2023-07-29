package com.tank.configure;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import com.tank.main.GameMainPanel;

public class TankParam {
	public static int tankx;
	public static int tanky;
	private static int e = 1;
	private static int tank_up = 1 ;
	private static int tank_down = 2;
	private static int tank_left = 3;
	private static int tank_right = 4;
	private static boolean ismove = true;
	
	public static int XSPEED = 3;
	public static int YSPEED = 3;
	
	//高度和宽度
	public static final int WIDTH = 20;
	public static final int HEIGHT = 20;
	
	//定义四个布尔类型变量来记录按键的情况,默认状态下为false，表示没有键按下
    private boolean b_L,b_U,b_R,b_D;

    //定义一个枚举类型来表示运行的方向  
    public enum Direction{
        L,LU,U,RU,R,RD,D,LD,STOP
    }
    //定义一个变量来表示坦克要运行的方向，初始状态为STOP
    private Direction dir = Direction.STOP;
    
     //定义一个变量记录坦克当前朝向，为了发射子弹
    private Direction ptDir = Direction.R;//默认为右
	
    GameMainPanel GameTank;
    
	public TankParam(int tankx,int tanky){
		this.tankx = tankx;
		this.tanky = tanky;
		System.out.println(Direction.L);
		System.out.println(Direction.U);
	}
	
	public TankParam(int tankx,int tanky,GameMainPanel gametank){
		this(tankx,tanky);
		GameTank = gametank;
	}
	
	 public void draw(Graphics g){
		 move();//根据键盘按键的结果改变坦克所在的位置
		Color c = g.getColor();
		g.setColor(Color.GREEN);
		g.fillRect(tankx, tanky, WIDTH, HEIGHT);
		g.setColor(c);
//		XSPEED = 0;
//		YSPEED = 0;
//		 }
     }
	 
	//记录键盘的按键情况
     public void keyMonitor(KeyEvent e){
         int key = e.getKeyCode();
//         System.out.println(key);
         switch(key){
         case 32:
             GameTank.getMissiles().add(fire());
             break;
         case KeyEvent.VK_LEFT:
             b_L = true;
             break;
         case KeyEvent.VK_UP:
             b_U = true;
             break;
         case KeyEvent.VK_RIGHT:
             b_R = true;
             break;
         case KeyEvent.VK_DOWN:
             b_D = true;
             break;
         }
         //根据上面的按键情况，确定坦克即将要运行的方向
         moveDirection();
         ismove = true;
         XSPEED = 2;
         YSPEED = 2;
     }

     //键盘按键松下时，也要进行记录
     public void keyReleased(KeyEvent e) {
         int key = e.getKeyCode();
         switch(key){

         case KeyEvent.VK_LEFT:
             b_L = false;
             break;
         case KeyEvent.VK_UP:
             b_U = false;
             break;
         case KeyEvent.VK_RIGHT:
             b_R = false;
             break;
         case KeyEvent.VK_DOWN:
             b_D = false;
             break;
         }
     }

     //根据键盘的按键情况来确定坦克的运行方向
     private void moveDirection() {//L,LU,U,RU,R,RD,D,LD,STOP
         if(b_L && !b_U && !b_R && !b_D){
             dir = Direction.L;
         }
         else if( b_L && b_U && !b_R && !b_D){
             dir = Direction.LU;
         }
         else if(!b_L&&b_U&&!b_R&&!b_D){
             dir = Direction.U;
         }
         else if(!b_L&&b_U&&b_R&&!b_D){
             dir = Direction.RU;
         }
         else if(!b_L&&!b_U&&b_R&&!b_D){
             dir = Direction.R;
         }
         else if(!b_L&&!b_U&&b_R&&b_D){
             dir = Direction.RD;
         }
         else if(!b_L&&!b_U&&!b_R&&b_D){
             dir = Direction.D;
         }
         else if(b_L&&!b_U&&!b_R&&b_D){
             dir = Direction.LD;
         }
         else{//其它所有情况，都是不动
             dir = Direction.STOP;
         }
         //将坦克方向赋值给炮筒方向
         if(dir != Direction.STOP){
             ptDir = dir;
         }
         
     }
	 
	 private void move(){
//		if(directiontank == 1){
//				tanky -= 20;//向上
//		}
//		if(directiontank == 2){
//				tanky += 20;//向下
//		}
//		if(directiontank == 3){
//				tankx -= 20;//向左
//		}
//		if(directiontank == 4){
//				tankx += 20;//向右
//		}
		
		if(dir == Direction.L && tankx > 0){//L,LU,U,RU,R,RD,D,LD,STOP
			tankx -= XSPEED;
        }
        else if(dir==Direction.LU){
        	tankx -= XSPEED;
        	tanky -= YSPEED;
        }
        else if(dir==Direction.U && tanky > 0){
        	tanky -= YSPEED;
        }
        else if(dir==Direction.RU){
        	tankx += XSPEED;
        	tanky -= YSPEED;
        }
        else if(dir==Direction.R && tankx < 880){
        	tankx += XSPEED;
        }
        else if(dir==Direction.RD){
        	tankx += XSPEED;
        	tanky += YSPEED;
        }
        else if(dir==Direction.D && tanky < 680){
        	tanky += YSPEED;
        }
        else if(dir==Direction.LD){
        	tankx -= XSPEED;
        	tanky += YSPEED;
        }
        else if(dir==Direction.STOP){
        	
        }
	 }
	 
	 private MissileParam fire(){
         int x = this.tankx +(this.WIDTH)/2 - (MissileParam.WIDTH)/2;
         int y = this.tanky + (this.HEIGHT)/2 -(MissileParam.HEIGHT)/2;
         MissileParam ms = new MissileParam(x,y,ptDir);
         return ms;
     }
}

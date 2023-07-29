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
	
	//�߶ȺͿ��
	public static final int WIDTH = 20;
	public static final int HEIGHT = 20;
	
	//�����ĸ��������ͱ�������¼���������,Ĭ��״̬��Ϊfalse����ʾû�м�����
    private boolean b_L,b_U,b_R,b_D;

    //����һ��ö����������ʾ���еķ���  
    public enum Direction{
        L,LU,U,RU,R,RD,D,LD,STOP
    }
    //����һ����������ʾ̹��Ҫ���еķ��򣬳�ʼ״̬ΪSTOP
    private Direction dir = Direction.STOP;
    
     //����һ��������¼̹�˵�ǰ����Ϊ�˷����ӵ�
    private Direction ptDir = Direction.R;//Ĭ��Ϊ��
	
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
		 move();//���ݼ��̰����Ľ���ı�̹�����ڵ�λ��
		Color c = g.getColor();
		g.setColor(Color.GREEN);
		g.fillRect(tankx, tanky, WIDTH, HEIGHT);
		g.setColor(c);
//		XSPEED = 0;
//		YSPEED = 0;
//		 }
     }
	 
	//��¼���̵İ������
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
         //��������İ��������ȷ��̹�˼���Ҫ���еķ���
         moveDirection();
         ismove = true;
         XSPEED = 2;
         YSPEED = 2;
     }

     //���̰�������ʱ��ҲҪ���м�¼
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

     //���ݼ��̵İ��������ȷ��̹�˵����з���
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
         else{//����������������ǲ���
             dir = Direction.STOP;
         }
         //��̹�˷���ֵ����Ͳ����
         if(dir != Direction.STOP){
             ptDir = dir;
         }
         
     }
	 
	 private void move(){
//		if(directiontank == 1){
//				tanky -= 20;//����
//		}
//		if(directiontank == 2){
//				tanky += 20;//����
//		}
//		if(directiontank == 3){
//				tankx -= 20;//����
//		}
//		if(directiontank == 4){
//				tankx += 20;//����
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

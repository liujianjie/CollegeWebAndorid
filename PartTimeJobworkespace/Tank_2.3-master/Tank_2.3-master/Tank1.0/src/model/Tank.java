package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import client.TankClient;

	public class Tank {
		//̹�����ڵ�λ������
		private int x;
		private int y;
		
		//̹�˵ĸ߶ȺͿ��
		private static final int WIDTH = 30;
		private static final int HEIGHT = 30;
		
		//����������������ʾ�˶����ٶ�
		private static final int XSPEED = 5;
		private static final int YSPEED = 5;
		
		//�����ĸ��������ͱ�������¼���������,Ĭ��״̬��Ϊfalse����ʾû�м�����
		private boolean b_L,b_U,b_R,b_D;
		
		//����һ��ö����������ʾ���еķ���	
		public enum Direction{
			L,LU,U,RU,R,RD,D,LD,STOP
		}
		//����һ����������ʾ̹��Ҫ���еķ��򣬳�ʼ״̬ΪSTOP
		private Direction dir = Direction.STOP;
		
		//��Ͳ����
		private Direction ptDir = Direction.D;
		
		private TankClient tc;

		public Tank(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public Tank(int x, int y, TankClient tc) {
			this(x,y);
			this.tc = tc;
		}

		public void draw(Graphics g){
			
			Color c = g.getColor();
			g.setColor(Color.RED);
			g.fillOval(x, y, 30, 30);
			g.setColor(c);
			//��һ����Ͳ
			drawGunBarrel(g);
			
			move();//���ݼ��̰����Ľ���ı�̹�����ڵ�λ��
		}
		
		private void drawGunBarrel(Graphics g) {
			int centerX = this.x + this.WIDTH/2;
			int centerY = this.y + this.HEIGHT/2;
			
			if(ptDir==Direction.L){//L,LU,U,RU,R,RD,D,LD,STOP
				g.drawLine(centerX, centerY, x, y + HEIGHT/2);
			}
			else if(dir==Direction.LU){
				g.drawLine(centerX, centerY, x, y );
			}
			else if(dir==Direction.U){
				g.drawLine(centerX, centerY, x+ WIDTH/2, y );
			}
			else if(dir==Direction.RU){
				g.drawLine(centerX, centerY, x + WIDTH, y );
			}
			else if(dir==Direction.R){
				g.drawLine(centerX, centerY, x+ WIDTH, y + HEIGHT/2);
			}
			else if(dir==Direction.RD){
				g.drawLine(centerX, centerY, x+ WIDTH, y + HEIGHT);
			}
			else if(dir==Direction.D){
				g.drawLine(centerX, centerY, x+ WIDTH/2, y + HEIGHT);
			}
			else if(dir==Direction.LD){
				g.drawLine(centerX, centerY, x, y + HEIGHT);
			}
			
		}

		//��¼���̵İ������
		public void keyPressed(KeyEvent e){
			int key=e.getKeyCode();
			//System.out.println(key);
			switch(key){
			case 17:
				tc.setMs(fire());
				break;
			case KeyEvent.VK_LEFT:
				b_L=true;
				break;
			case KeyEvent.VK_UP:
				b_U=true;
				break;
			case KeyEvent.VK_RIGHT:
				b_R=true;
				break;
			case KeyEvent.VK_DOWN:
				b_D=true;
				break;
			}
			//��������İ��������ȷ��̹�˼���Ҫ���еķ���
			moveDirection();
		}
		
		//���̰�������ʱ��ҲҪ���м�¼
		public void keyReleased(KeyEvent e) {
			int key=e.getKeyCode();
			switch(key){
			
			case KeyEvent.VK_LEFT:
				b_L=false;
				break;
			case KeyEvent.VK_UP:
				b_U=false;
				break;
			case KeyEvent.VK_RIGHT:
				b_R=false;
				break;
			case KeyEvent.VK_DOWN:
				b_D=false;
				break;
			}
		}
		
		//���ݼ��̵İ��������ȷ��̹�˵����з���
		private void moveDirection() {//L,LU,U,RU,R,RD,D,LD,STOP
			if(b_L&&!b_U&&!b_R&&!b_D){
				dir = Direction.L;
			}
			else if(b_L&&b_U&&!b_R&&!b_D){
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
			if(dir!=Direction.STOP){
				ptDir = dir;
			}
			
		}
	
		//���������з��򣬵��ǻ�ȱ�پ��������ϸ�ڣ����磺�����ǰ������Ҽ�����Ӧ�ú�����x+=XSPEED;
		private void move(){
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
			else if(dir==Direction.STOP){
				//... nothing
			}
			
		}
		
		public Missile fire(){
			//�����ӵ���λ��,��������Ͳ�ķ�����newһ���ӵ�����
			int x = this.x +(this.WIDTH)/2 - (Missile.WIDTH)/2;
			int y = this.y + (this.HEIGHT)/2 -(Missile.HEIGHT)/2;
			Missile ms = new Missile(x,y,this.ptDir);
			return ms;
		}
	
	}

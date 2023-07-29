package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

	public class Tank {
		//̹�����ڵ�λ������
		private int x;
		private int y;
		
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
		
		public Direction getDir() {
			return dir;
		}

		public void setDir(Direction dir) {
			this.dir = dir;
		}

		public Tank(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	
		public int getX() {
			return x;
		}
	
		public void setX(int x) {
			this.x = x;
		}
	
		public int getY() {
			return y;
		}
	
		public void setY(int y) {
			this.y = y;
		}
		
		public void draw(Graphics g){
			
			Color c = g.getColor();
			g.setColor(Color.RED);
			g.fillOval(x, y, 30, 30);
			g.setColor(c);
			
			move();//���ݼ��̰����Ľ���ı�̹�����ڵ�λ��
		}
		
		//��¼���̵İ������
		public void keyMonitor(KeyEvent e){
			int key=e.getKeyCode();
			switch(key){
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
	
	
	}

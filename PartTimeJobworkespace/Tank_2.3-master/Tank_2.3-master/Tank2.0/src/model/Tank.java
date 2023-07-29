package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.Random;

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
		
		//���һ�����ԣ���ʾ��̹���Ǻû��ǻ�
		private boolean good;
		
		public boolean isGood() {
			return good;
		}
		
		//������ʶ��̹�˶����Ƿ���
		private boolean live =true;
		
		public boolean isLive() {
			return live;
		}

		public void setLive(boolean live) {
			this.live = live;
		}
		//����һ��ö����������ʾ���еķ���	
		public enum Direction{
			L,LU,U,RU,R,RD,D,LD,STOP
		}
		//����һ����������ʾ̹��Ҫ���еķ��򣬳�ʼ״̬ΪSTOP
		private Direction dir = Direction.STOP;
		
		//��Ͳ����
		private Direction ptDir = Direction.D;
		
		private TankClient tc;

		public Tank(int x, int y,boolean good) {
			this.x = x;
			this.y = y;
			this.good = good;
		}
		
		public Tank(int x, int y,boolean good,Direction dir, TankClient tc) {
			this(x,y,good);
			this.dir = dir;
			this.tc = tc;
		}
		//̹��û��step���������һ������
		private Random r = new Random();
		private int step = r.nextInt(7)+3;	
		
		public void draw(Graphics g){
			if(!live){		//�ж�̹���Ƿ��������ˣ��򲻻滭������ֱ�ӷ���		
				return ;
			}
			if(!this.good){
				if(step==0){
					Direction[] dirs =Direction.values();
					int rn = r.nextInt(dirs.length);
					this.dir = dirs[rn];
					step = r.nextInt(7)+3;
				}
			}
			//��ͬ��̹�˻��Ʋ�ͬ����ɫ
			Color c = g.getColor();
			if(good){
				g.setColor(Color.RED);
			}
			else{
				g.setColor(Color.BLUE);
			}
			
			g.fillOval(x, y, WIDTH, HEIGHT);
			g.setColor(c);
			//��һ����Ͳ
			drawGunBarrel(g);
			
			move();//���ݼ��̰����Ľ���ı�̹�����ڵ�λ��
			
			step--;
			
			//�з��ӵ�����
			if(!this.good&&r.nextInt(40)>38){
				this.tc.getMissiles().add(fire());
			}
			
		}
		
		private void drawGunBarrel(Graphics g) {
			int centerX = this.x + this.WIDTH/2;
			int centerY = this.y + this.HEIGHT/2;
			
			if(ptDir==Direction.L){//L,LU,U,RU,R,RD,D,LD,STOP
				g.drawLine(centerX, centerY, x, y + HEIGHT/2);
			}
			else if(ptDir==Direction.LU){
				g.drawLine(centerX, centerY, x, y );
			}
			else if(ptDir==Direction.U){
				g.drawLine(centerX, centerY, x+ WIDTH/2, y );
			}
			else if(ptDir==Direction.RU){
				g.drawLine(centerX, centerY, x + WIDTH, y );
			}
			else if(ptDir==Direction.R){
				g.drawLine(centerX, centerY, x+ WIDTH, y + HEIGHT/2);
			}
			else if(ptDir==Direction.RD){
				g.drawLine(centerX, centerY, x+ WIDTH, y + HEIGHT);
			}
			else if(ptDir==Direction.D){
				g.drawLine(centerX, centerY, x+ WIDTH/2, y + HEIGHT);
			}
			else if(ptDir==Direction.LD){
				g.drawLine(centerX, centerY, x, y + HEIGHT);
			}
			
		}

		//��¼���̵İ������
		public void keyPressed(KeyEvent e){
			int key=e.getKeyCode();
			//System.out.println(key);
			switch(key){
//			case 17://������Ctrlһֱ���£�һֱ�����ӵ�����˽���һ���ܷ���keyReleased��������
//				tc.getMissiles().add(fire());
//				break;
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
			case 17:
				tc.getMissiles().add(fire());
				break;
			case KeyEvent.VK_A:
				produceMainTank();
				break;
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
		
		private void produceMainTank() {
			Tank t=this.tc.getTk();
			if(!t.isLive()){
				int x = r.nextInt(100)+200;
				int y = r.nextInt(150)+300;
				Tank newTank =new Tank(x,y,true,Direction.STOP,this.tc);
				this.tc.setTk(newTank);
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
			
			//����̹��Խ������
			dealTankBorder();		
		}
		/*
		 * �������ܣ�����̹��Խ������
		 * */
		private void dealTankBorder() {
			if(x<0){
				x = 0;
			} 
			else if(x > TankClient.GAME_WIDTH-this.WIDTH){
				x = TankClient.GAME_WIDTH-this.WIDTH ;
			} 
			if(y<10){
				 y = 10;
			}
			else if(y>TankClient.GAME_WIDTH - this.HEIGHT){
				 y = TankClient.GAME_WIDTH - this.HEIGHT;
			}
		}

		public Missile fire(){
			//�����ӵ���λ��,��������Ͳ�ķ�����newһ���ӵ�����
			int x = this.x +(this.WIDTH)/2 - (Missile.WIDTH)/2;
			int y = this.y + (this.HEIGHT)/2 -(Missile.HEIGHT)/2;
			//����̹�˵�����(good)��new��֮��Ӧ���ӵ�����
			Missile ms = new Missile(x,y,this.ptDir,this.good,this.tc);
			return ms;
		}
		/*
		 * �������ܣ��õ�̹������λ�õľ��ο�
		 * */
		public Rectangle getRect(){
			return new Rectangle(x, y, WIDTH, HEIGHT);
		}
	
	}

package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Random;

import client.TankClient;

	public class Tank {
		//坦克所在的位置坐标
		private int x;
		private int y;
		
		//坦克前一个时刻的位置
		private int oldX;
		private int oldY;
		
		//坦克的高度和宽度
		private static final int WIDTH = 30;
		private static final int HEIGHT = 30;
		
		//定义两个常量，表示运动的速度
		private static final int XSPEED = 5;
		private static final int YSPEED = 5;
		
		//定义四个布尔类型变量来记录按键的情况,默认状态下为false，表示没有键按下
		private boolean b_L,b_U,b_R,b_D;
		
		//添加一个属性，表示此坦克是好还是坏
		private boolean good;
		
		public boolean isGood() {
			return good;
		}
		
		//用来标识此坦克对象是否存活
		private boolean live =true;
		
		public boolean isLive() {
			return live;
		}

		public void setLive(boolean live) {
			this.live = live;
		}
		//定义一个枚举类型来表示运行的方向	
		public enum Direction{
			L,LU,U,RU,R,RD,D,LD,STOP
		}
		//定义一个变量来表示坦克要运行的方向，初始状态为STOP
		private Direction dir = Direction.STOP;
		
		//炮筒方向
		private Direction ptDir = Direction.D;
		
		private TankClient tc;

		public Tank(int x, int y,boolean good) {
			//刚初始化时前一个时刻的位置就是当前的位置
			this.oldX = x;
			this.oldY = y;
			this.x = x;
			this.y = y;
			this.good = good;
		}
		
		public Tank(int x, int y,boolean good,Direction dir, TankClient tc) {
			this(x,y,good);
			this.dir = dir;
			this.tc = tc;
		}
		//坦克没走step步，随机换一个方向
		private Random r = new Random();
		private int step = r.nextInt(7)+3;	
		
		public void draw(Graphics g){
			if(!live){		//判断坦克是否存活，如果死了，则不绘画出来，直接返回		
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
			//不同的坦克绘制不同的颜色
			Color c = g.getColor();
			if(good){
				g.setColor(Color.RED);
			}
			else{
				g.setColor(Color.BLUE);
			}
			
			g.fillOval(x, y, WIDTH, HEIGHT);
			g.setColor(c);
			//画一个炮筒
			drawGunBarrel(g);
			
			move();//根据键盘按键的结果改变坦克所在的位置
			
			step--;
			
			//敌方子弹开火
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

		//记录键盘的按键情况
		public void keyPressed(KeyEvent e){
			int key=e.getKeyCode();
			//System.out.println(key);
			switch(key){
//			case 17://避免因Ctrl一直按下，一直发射子弹，因此将这一功能放入keyReleased方法中了
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
			//根据上面的按键情况，确定坦克即将要运行的方向
			moveDirection();
		}
		
		//键盘按键松下时，也要进行记录
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

		//根据键盘的按键情况来确定坦克的运行方向
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
			else{//其它所有情况，都是不动
				dir = Direction.STOP;
			}
			//将坦克方向赋值给炮筒方向
			if(dir!=Direction.STOP){
				ptDir = dir;
			}
			
		}
	
		//上面有运行方向，但是还缺少具体的运行细节，例如：假设是按下了右键，则应该横坐标x+=XSPEED;
		private void move(){
			//在运动前，先将当前位置保存给上一个时刻的位置		
			oldX = x;
			oldY = y;
			
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
			
			//处理坦克越界问题
			dealTankBorder();		
		}
		/*
		 * 函数功能：处理坦克越界问题
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
			//计算子弹的位置,并利用炮筒的方向来new一个子弹对象
			int x = this.x +(this.WIDTH)/2 - (Missile.WIDTH)/2;
			int y = this.y + (this.HEIGHT)/2 -(Missile.HEIGHT)/2;
			//根据坦克的类型(good)来new与之对应的子弹类型
			Missile ms = new Missile(x,y,this.ptDir,this.good,this.tc);
			return ms;
		}
		/*
		 * 函数功能：得到坦克所在位置的矩形框
		 * */
		public Rectangle getRect(){
			return new Rectangle(x, y, WIDTH, HEIGHT);
		}
		
		//坦克撞一个墙	
		public boolean tankHitWall(Wall w){
			if(!this.live){
				return false;
			}
			if(this.getRect().intersects(w.getRect())){
				this.x = oldX;
				this.y = oldY;
				return true;
			}
			else{
				return false;
			}
		}
		
		//坦克撞一系列的墙
		public boolean tankHitWalls(List<Wall> walls){
			for(int i=0;i<walls.size();i++){
				if(tankHitWall(walls.get(i))){
					return true;
				}
			}
			
			return false;
		}
	
	}

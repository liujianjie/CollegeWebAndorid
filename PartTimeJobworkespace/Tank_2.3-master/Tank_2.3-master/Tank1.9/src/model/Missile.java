package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.List;

import model.Tank.Direction;
import client.TankClient;

public class Missile {

	//����������������ʾ�˶����ٶ�
	private static final int XSPEED = 10;
	private static final int YSPEED = 10;
	
	//�ӵ����ڵ�λ��
	private int x;
	private int y;
	
	//̹�˵ĸ߶ȺͿ��
	public static final int WIDTH = 10;
	public static final int HEIGHT = 10;
	
	//�ӵ������з���
	private Direction dir;
	
	private boolean live = true;
	
	private boolean good =true;
	
	//ӵ��һ��TankClient���������
	private TankClient tc;
	public Missile(int x,int y,Direction dir,boolean good,TankClient tc){
		this(x,y,dir);
		this.good = good;
		this.tc = tc;
		
	}
	public Missile(int x, int y, Direction dir) {
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
	public void draw(Graphics g){
		//������ӵ����Ǵ��ģ��򲻽��л�ͼ
		if(!live){
			return ;
		}
		Color c = g.getColor();
		//�����ӵ��ĺû������ò�ͬ����ɫ
		if(this.good){
			g.setColor(Color.RED);
		}
		else{
			g.setColor(Color.BLUE);
		}
		
		g.fillOval(x, y, WIDTH, HEIGHT);
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
	
	public Rectangle getRect(){
		return new Rectangle(x, y, WIDTH, HEIGHT);
	}
	
	public boolean hitTank(Tank t){
		//���жϸ�̹���Ƿ��Ǵ�����Ѿ����ˣ��ӵ��Ͳ�������
		if(!t.isLive()){
			return false;
		}
		if(this.live&&this.good!=t.isGood()&&this.getRect().intersects(t.getRect())){//�ж��Ƿ�����ײ
			//��ײ֮���ӵ��͸�̹�˾�Ӧ�ö�����
			this.live = false;//�ӵ�����
			t.setLive(false);//̹������
			Explode e = new Explode(x,y,tc);
			tc.getExplodes().add(e);
			return true;
		}
		else{
			return false;
		}
	}
	/*
	 * һ���ӵ������̹��
	 * */
	public boolean hitTanks(List<Tank> tanks){
		for(int i=0;i<tanks.size();i++){
			if(hitTank(tanks.get(i))){
				return true;
			}
		}
		return false;
	}
}

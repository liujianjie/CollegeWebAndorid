package client;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import model.Explode;
import model.Missile;
import model.Tank;
/*
 * �˰汾Ϊ���еж�̹�˱����к������ը��Ч��
 * */
public class TankClient extends Frame{
	
	public final static int GAME_WIDTH=600;
	public final static int GAME_HEIGHT=600;
	
	
	private Tank tk=new Tank(50,50,true,this);
	
	
	//������������з�̹��
	private List<Tank> enemyTanks = new ArrayList<Tank>();
	public List<Tank> getEnemyTanks() {
		return enemyTanks;
	}

	/*
	 * Ϊÿ�������е�̹�����һ����ը����
	 * */
	private List<Explode> explodes = new ArrayList<Explode>(); 
	
	public List<Explode> getExplodes() {
		return explodes;
	}

	private List<Missile> missiles = new ArrayList<Missile> ();
	
	public List<Missile> getMissiles() {
		return missiles;
	}

	private Image offScreenImage = null;
	
	public static void main(String[] args) {
		new TankClient().launchFrame();
	}
	
	@Override
	public void update(Graphics g) {
		if (offScreenImage == null) {
			offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
		}
		Graphics goffScreen = offScreenImage.getGraphics();// ���¶���һ�������������Ļ���//
		Color c = goffScreen.getColor();
		goffScreen.setColor(Color.darkGray);
		goffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
		goffScreen.setColor(c);
		paint(goffScreen);
		g.drawImage(offScreenImage, 0, 0, null);
	}

	@Override
	public void paint(Graphics g) {
		//ֱ�ӵ���̹�����draw����
		tk.draw(g);	
		//���з�̹����ʾ����
		for(int i=0;i<enemyTanks.size();i++){
			Tank enemy = enemyTanks.get(i);
			if(!enemy.isLive()){
				enemyTanks.remove(enemy);
			}
			else{
				enemy.draw(g);
			}
			
		}
		
		
		//ը������
		for(int i=0;i<explodes.size();i++){
			Explode e = explodes.get(i);
			if(!e.isLive()){
				explodes.remove(e);
			}
			else{
				e.draw(g);
			}
			
		}
		//���ӵ�
		for(int i=0;i<missiles.size();i++){
			Missile ms = missiles.get(i);			
			//�ж��ӵ��Ƿ񻹴���ڣ�������Ǵ��ģ����Ƴ�
			if(!ms.isLive()){
				missiles.remove(ms);
			}
			else{
				ms.draw(g);
				//ÿ���ӵ���Ҫ��ÿ���з���̹�˽�����ײ���
				for(int j=0;j<enemyTanks.size();j++){
					Tank enemy = enemyTanks.get(j);
					if(enemy.isLive()){
						ms.hitTank(enemy);
					}
				}
				
				
			}
			
		}
	}

	public void launchFrame(){
		
		//��ʼ��10��̹���ڽ�����
		for(int i=0;i<10;i++){
			Tank enemy = new Tank((i+1)*40,50,false,this);
			enemyTanks.add(enemy);
		}
		
		this.setTitle("̹�˴�ս");
		this.setLocation(300, 400);
		this.setSize(GAME_WIDTH, GAME_HEIGHT);
		this.setBackground(Color.GRAY);
		//Ϊ�رմ��������Ӧ
		this.addWindowListener(new WindowAdapter(){

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		});
		//�����Ƿ������û��ı䴰�ڵĴ�С�����������£�������
		this.setResizable(false);
		this.setVisible(true);
		
		new Thread(new MyRepaint()).start();
		this.addKeyListener(new KeyMonitor());
		
		
		
	}
	
	private class MyRepaint implements Runnable{

		@Override
		public void run() {
			while(true){
				//ÿ50ms�ػ�һ��
				repaint();
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	private class KeyMonitor extends KeyAdapter{

		@Override
		public void keyPressed(KeyEvent e) {
			tk.keyPressed(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			tk.keyReleased(e);
		}	
		
	}

}

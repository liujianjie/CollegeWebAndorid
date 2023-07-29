package client;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import model.Tank;

public class TankClient extends Frame{
	
	private final static int GAME_WIDTH=600;
	private final static int GAME_HEIGHT=600;
	
	
	private Tank tk=new Tank(50,50);
	
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
		//ֱ�ӵ���̹����ʥ��draw����
		tk.draw(g);		
	}

	public void launchFrame(){
		
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
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	private class KeyMonitor extends KeyAdapter{

		@Override
		public void keyPressed(KeyEvent e) {
			tk.keyMonitor(e);
		}		
	}

}

package eighteen.four;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFrame;

public class CaozuoThread extends JFrame{
	
	private Thread t;
	private static Color[] co = {Color.BLACK,Color.orange,Color.YELLOW,Color.RED,Color.PINK,Color.LIGHT_GRAY}; 
	private static final Random rand = new Random();
	
	private static Color getcolor(){
		return co[rand.nextInt(co.length)];
	}
	public CaozuoThread(){
		super("Test");
		
		t = new Thread(new Runnable() {
			int x = 30;
			int y = 50;
			public void run() {
				while(true){
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Graphics g = getGraphics();
					g.setColor(getcolor());
					g.drawLine(x, y, 100, y++);
					if(y >= 80){
						y=50;
					}
				}
				
			}
		});
		t.start();
	}

	public static void main(String[] args) {
		ini(new CaozuoThread(),100,100);
	}
	public static void ini(JFrame frame, int width, int height){
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width, height);
		frame.setVisible(true);
	}
}

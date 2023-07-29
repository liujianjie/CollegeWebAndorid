package Work;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class TestMove extends Frame{
	final int N=100;
	int x []= new int[N], y[] =new int[N];
	Random r;
	int X,Y;
	Image img;
	Image img1;
	public TestMove() {
		super("Ì°³ÔÉß");
		setLayout(null);
		x[0]=300;
		y[0]=100;
		x[1]=280;
		y[1]=100;
		r=new Random();
		X=r.nextInt(500)+50;
		Y=r.nextInt(500)+50;
		while(X%20!=0){
			X++;
		}
		while(Y%20!=0){
			Y++;
		}
		img=Toolkit.getDefaultToolkit().getImage("image/26.gif");
		img1=Toolkit.getDefaultToolkit().getImage("image/71.gif");
		this.setBackground(Color.yellow);
		addWindowListener(new win());
		addKeyListener(new key());
		this.setSize(600, 600);
		setVisible(true);
	}
	boolean food=true;
	int node=2;
	int a=4;
	public void paint(Graphics g) {
		
		g.setColor(Color.red);
		if(food){
			//g.drawRect(X, Y, 20,20);
			g.drawImage(img1, X, Y, this);
		}
		for(int i=0;i<node;i++){
			//g.drawRect(x[i],y[i],20,20);
			g.drawImage(img, x[i], y[i], this);
		}
		
		for(int i=node;i>0;i--){
			x[i]=x[i-1];
			y[i]=y[i-1];
		}
		if(a==1){
			y[0] -= 20;
		}else if(a==2){
			y[0]+=20;
		}else if(a==3){
			x[0]-=20;
		}else if(a==4){
			x[0]+=20;
		}
		try {
			//ÐÝÃß100ºÁÃë
			Thread.sleep(200);
		} catch (Exception e) {
		}
		if(x[0]==X&&y[0]==Y){
			node++;
			food=false;
		}
		if(!food){
			X=r.nextInt(500)+50;
			Y=r.nextInt(500)+50;
			while(X%20!=0){
				X++;
			}
			while(Y%20!=0){
				Y++;
			}
			food=true;
		}
		for(int i=3;i<node;i++){
			if(x[0]==x[i]&&y[0]==y[i]){
				JOptionPane.showMessageDialog(null, "gameower");
				System.exit(0);
			}
		}
		if(x[0]<0){
			JOptionPane.showMessageDialog(null, "gameower");
			System.exit(0);
			return;
		}
		if(x[0]>600){
			JOptionPane.showMessageDialog(null, "gameower");
			System.exit(0);
			return;
		}
		if(y[0]<0){
			JOptionPane.showMessageDialog(null, "gameower");
			System.exit(0);
			return;
		}
		if(y[0]>600){
			JOptionPane.showMessageDialog(null, "gameower");
			System.exit(0);
			return;
		}
		//x×ø±ê¼õ10£¬¼´Ïò×óÒÆ¶¯
		repaint();
	}
	
	class key extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode()==38){
				a=1;
			}
			if(e.getKeyCode()==40){
				a=2;
			}
			if(e.getKeyCode()==37){
				a=3;
			}
			if(e.getKeyCode()==39){
				a=4;
			}	
		}
	}
	public static void main(String args[]) {
		new TestMove();
	}
	class win extends WindowAdapter{
		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}
}
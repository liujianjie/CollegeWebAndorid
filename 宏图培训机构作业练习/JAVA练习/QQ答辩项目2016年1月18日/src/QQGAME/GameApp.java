package QQGAME;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

import javax.swing.JLabel;
public class GameApp extends Frame implements MouseListener{
	Vector v=new Vector();	
	JLabel close;
	public GameApp(){
		super("五子棋游戏");
		Frame con=new Frame();
		close=new JLabel();
		close.setBounds(405,0,30,30);
		con.add(close);
		close.addMouseListener(new B());
		this.addMouseListener(this);
		this.setSize(435,465);
	}
	class B extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getSource()==close){
				dispose();
			}
		}
		
	}
	public void paint(Graphics g){
		Toolkit toolkit=Toolkit.getDefaultToolkit();
		Image img1=toolkit.getImage("img/Board.gif");	
		Image imgBlack=toolkit.getImage("img/black.gif");	
		Image imgWhite=toolkit.getImage("img/white.gif");	
		g.drawImage(img1,0,20,this);
		for(int i=0;i<v.size();i++){
			String str=(String)v.get(i);
			String tmp[]=str.split("-");//把字符串分割为字符串数组		
			int a=Integer.parseInt(tmp[0]);
			int b=Integer.parseInt(tmp[1]);						
			int x=b*25+18-12;
			int y=a*25+39-12;
			if(i%2==0)
				g.drawImage(imgBlack,x,y,this);
			else
				g.drawImage(imgWhite,x,y,this);
		}
	}
	public void update(Graphics g){
		this.paint(g);
		
	}
	public void mouseClicked(MouseEvent e) {
		// TODO: Add your code here
		int x=e.getX();
		int y=e.getY();
		int gridy=(x-18)/25+((x-18)%25>12?1:0);
		int gridx=(y-39)/25+((y-39)%25>12?1:0);
		
		System.out.println(gridx+"-"+gridy);
		
		if(!v.contains(gridx+"-"+gridy)){
			v.add(gridx+"-"+gridy); //
		}
		this.repaint();
	}
	public void mousePressed(MouseEvent e) {	}
	public void mouseReleased(MouseEvent e) {	}
	public void mouseEntered(MouseEvent e) {	}
	public void mouseExited(MouseEvent e) {	}
	
	public static void main(String args[]){
		//new GameApp().show();
	}
}
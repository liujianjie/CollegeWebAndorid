package test;

import java.awt.Container;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.Window;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.WindowConstants;

public class T1 extends JFrame{
	
	public T1(){
		super("1");
		Container con = getContentPane();
		JButton b1 = new JButton();
//		b1.addac
		JPopupMenu pop1 = new JPopupMenu();

		JMenuItem mt1 = new JMenuItem();
		JMenu me = new JMenu();
		me.add(mt1);
		pop1.add(me);
		
		addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				if(arg0.isPopupTrigger()){
					pop1.show(arg0.getComponent(), arg0.getX(), arg0.getY());
				}
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		setSize(300,200);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new T1();
	}
}

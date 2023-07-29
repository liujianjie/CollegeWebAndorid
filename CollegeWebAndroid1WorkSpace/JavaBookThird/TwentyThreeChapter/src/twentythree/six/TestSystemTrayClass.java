package twentythree.six;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import twentythree.one.two.TestTablePane;

public class TestSystemTrayClass extends JFrame{
	
	public TestSystemTrayClass(){
		super("系统托盘");
		URL resource = TestTablePane.class.getResource("img1.png");
		ImageIcon ic = new ImageIcon(resource);
		
		Button b1 = new Button("桌面图标");
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(SystemTray.isSupported()){
					System.out.println("支持系统托盘");
					
					PopupMenu popmenu = new PopupMenu();
					MenuItem me1 = new MenuItem("显示");
					MenuItem me2 = new MenuItem("退出");
					
					TrayIcon trayic = new TrayIcon(ic.getImage(),"系统托盘",popmenu);
					SystemTray systemtray = SystemTray.getSystemTray();
					try {
						systemtray.add(trayic);
					} catch (AWTException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					me2.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							System.exit(0);
						}
					});
					
					me1.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							setVisible(true);
						}
					});
					popmenu.add(me1);
					popmenu.add(me2);
					
				}
				setVisible(false);
			}
		});
		
		getContentPane().add(b1, BorderLayout.CENTER);
		setBounds(100, 100, 500 ,375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new TestSystemTrayClass();
	}
}

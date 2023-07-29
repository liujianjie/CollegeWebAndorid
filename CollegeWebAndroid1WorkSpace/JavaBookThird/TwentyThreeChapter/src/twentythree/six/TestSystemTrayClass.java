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
		super("ϵͳ����");
		URL resource = TestTablePane.class.getResource("img1.png");
		ImageIcon ic = new ImageIcon(resource);
		
		Button b1 = new Button("����ͼ��");
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(SystemTray.isSupported()){
					System.out.println("֧��ϵͳ����");
					
					PopupMenu popmenu = new PopupMenu();
					MenuItem me1 = new MenuItem("��ʾ");
					MenuItem me2 = new MenuItem("�˳�");
					
					TrayIcon trayic = new TrayIcon(ic.getImage(),"ϵͳ����",popmenu);
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

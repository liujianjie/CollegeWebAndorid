package client;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class TankClient extends JFrame{

	public static void main(String[] args) {
		new TankClient().launchFrame();
	}
	
	public void launchFrame(){
		
		this.setTitle("̹�˴�ս");
		this.setLocation(300, 400);
		this.setSize(300, 400);
		this.setBackground(Color.RED);
		//this.getContentPane().setBackground(Color.RED);
		this.getContentPane().setVisible(false);
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
	}

}

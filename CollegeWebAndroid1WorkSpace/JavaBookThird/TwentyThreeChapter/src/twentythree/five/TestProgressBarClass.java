package twentythree.five;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JProgressBar;


public class TestProgressBarClass extends JFrame{
	JProgressBar jpr;
	public TestProgressBarClass(){
		super("������");
		
		 jpr = new JProgressBar();
		jpr.setIndeterminate(false);// 1.true��ȷ����������  falseȷ����������
		jpr.setStringPainted(true);// 2.��ʾ������Ϣ
		jpr.setString("������");//  3.����������2��ʾ������Ϣ ����� ��ȷ����������ƥ��
		
		Thread th = new TestThread();
		th.start();
		
		getContentPane().add(jpr, BorderLayout.NORTH);
		setBounds(100, 100, 500 ,375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	class TestThread extends Thread{
		
		int [] val = {10,25,50,60,75,100};
		@Override
		public void run() {
			for(int i = 0; i < val.length; i++){
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				jpr.setString(val[i]+"%"); // 4.һ��ֻ����ʾ��Ϣ
				jpr.setValue(val[i]);	// 5.����ǽ����������ֵ
			}
			jpr.setIndeterminate(false);// ȡ����ȷ��
			jpr.setString("�������");
			jpr.setValue(100);
		}
	}
	
	public static void main(String[] args) {
		new TestProgressBarClass();
	}
}

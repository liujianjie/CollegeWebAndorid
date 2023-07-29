package eighteen.four.three;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class InterruptedSwing extends JFrame{
	private Thread threadA;
	final JProgressBar progressbar = new JProgressBar();
	int count = 0;
	public static void main(String[] args) {
		init(new InterruptedSwing(), 100, 100);
	}
	public InterruptedSwing(){
		super();
		getContentPane().add(progressbar, BorderLayout.NORTH);
		progressbar.setStringPainted(true);
		threadA = new Thread(new Runnable() {
			int count = 0;
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true){
					progressbar.setValue(++count);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						System.out.println("当前线程被打断");
						break;// 中止循环
					}
					
				}
			}
		});
		threadA.start();
		threadA.interrupt();
	}
	
	public static void init(JFrame frame,int width,int height){
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width, height);
		frame.setVisible(true);
	}
}

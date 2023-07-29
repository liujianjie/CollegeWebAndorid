package eighteen.four.two;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class JoinTest extends JFrame{
	private Thread threadA;
	private Thread threadB;
	final JProgressBar progressbar = new JProgressBar();
	final JProgressBar progressbar2 = new JProgressBar();
	int count = 0;
	public static void main(String[] args) {
		init(new JoinTest(), 100, 100);
	}
	public JoinTest(){
		super();
		getContentPane().add(progressbar, BorderLayout.NORTH);
		getContentPane().add(progressbar2, BorderLayout.SOUTH);
		progressbar.setStringPainted(true);
		progressbar2.setStringPainted(true);
		
		threadA = new Thread(new Runnable() {
			int count = 0;
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true){
					progressbar.setValue(++count);
					try {
						Thread.sleep(100);
						threadB.join();
						System.out.println("a:"+count);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}
		});
		threadA.start();
		threadB = new Thread(new Runnable() {
			int count = 0;
			@Override
			public void run() {
				while(true){
					progressbar2.setValue(++count);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("B:"+count);
					if(count == 100){
						break;
					}
				}
			}
		});
		threadB.start();
	}
	
	public static void init(JFrame frame,int width,int height){
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width, height);
		frame.setVisible(true);
	}
}

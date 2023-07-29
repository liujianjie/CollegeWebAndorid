package eighteen.five;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

import eighteen.four.three.InterruptedSwing;

public class PriotityTest extends JFrame{
	private Thread threadA,threadB,threadC,threadD;
	final JProgressBar progressbar1 = new JProgressBar();
	final JProgressBar progressbar2 = new JProgressBar();
	final JProgressBar progressbar3 = new JProgressBar();
	final JProgressBar progressbar4 = new JProgressBar();
	int count = 0;
	public static void main(String[] args) {
		init(new PriotityTest(), 300, 300);
	}
	
	private final class Mythread implements Runnable {// 得弄清final的作用，以及这个方法很不错 写的复用性强
		private final JProgressBar bar;
		int count = 0;
		private Mythread(JProgressBar par){
			this.bar = par;
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true){
				bar.setValue(count+=10);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("当前线程被打断");
					break;// 中止循环
				}
				
			}
		}
	}
	
	public PriotityTest(){
		super();
		getContentPane().setLayout(new FlowLayout());
		getContentPane().add(progressbar1);
		getContentPane().add(progressbar2);
		getContentPane().add(progressbar3);
		getContentPane().add(progressbar4);
		progressbar1.setStringPainted(true);
		progressbar2.setStringPainted(true);
		progressbar3.setStringPainted(true);
		progressbar4.setStringPainted(true);
		threadA = new Thread(new Mythread(progressbar1));
		threadB = new Thread(new Mythread(progressbar2));
		threadC = new Thread(new Mythread(progressbar3));
		threadD = new Thread(new Mythread(progressbar4));
		setprotyS(threadA,"threadA",5);
		setprotyS(threadB,"threadB",5);
		setprotyS(threadC,"threadC",4);
		setprotyS(threadD,"threadD",3);
	}
	private static void setprotyS(Thread t,String name,int pro){
		t.setPriority(pro);
		t.setName(name);
		t.start();
//		t.interrupt();
	}
	public static void init(JFrame frame,int width,int height){
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width, height);
		frame.setVisible(true);
	}
}

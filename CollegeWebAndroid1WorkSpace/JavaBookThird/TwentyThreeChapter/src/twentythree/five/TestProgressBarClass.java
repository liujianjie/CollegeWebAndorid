package twentythree.five;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JProgressBar;


public class TestProgressBarClass extends JFrame{
	JProgressBar jpr;
	public TestProgressBarClass(){
		super("进度条");
		
		 jpr = new JProgressBar();
		jpr.setIndeterminate(false);// 1.true不确定填充滚动条  false确定填充滚动条
		jpr.setStringPainted(true);// 2.显示进度信息
		jpr.setString("升级中");//  3.必须先设置2显示进度信息 最好与 不确定填充滚动条匹配
		
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
				jpr.setString(val[i]+"%"); // 4.一个只是显示信息
				jpr.setValue(val[i]);	// 5.这个是进度条的填充值
			}
			jpr.setIndeterminate(false);// 取消不确定
			jpr.setString("升级完成");
			jpr.setValue(100);
		}
	}
	
	public static void main(String[] args) {
		new TestProgressBarClass();
	}
}

package pack;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 * 测试swing中Timer的使用 一个显示时间的GUI程序
 */
public class TimerTest extends JFrame implements ActionListener {
	// 一个显示时间的JLabel
	private JLabel jlTime = new JLabel();
	private Timer timer, timer2;
//	private JButton jb = new JButton();

	public TimerTest() {
		setTitle("Timer测试");
		Container con = getContentPane();
		con.setLayout(new BorderLayout());
		
		con.add(jlTime, BorderLayout.NORTH);
//		con.add(jb,BorderLayout.SOUTH);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(180, 180);
		
		// 设置Timer定时器，并启动
		timer = new Timer(500, this);// 不是我写的，这个可以调用actionPerformed吧
		timer.start();
//		jb.addActionListener(new A());
//		timer2 = new Timer(500, jb);// 不行 不是这个意思
		setVisible(true);
	}
//	class A implements ActionListener{
//		public void actionPerformed(ActionEvent e) {
//			System.out.println("222");
//
//		}
//	}
	/**
	 * 执行Timer要执行的部分，
	 */
	public void actionPerformed(ActionEvent e) {
		System.out.println("111");
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
		Date date = new Date();
		jlTime.setText(format.format(date));

	}

	public static void main(String[] args) {
		new TimerTest();
	}
}

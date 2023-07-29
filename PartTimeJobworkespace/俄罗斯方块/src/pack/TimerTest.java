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
 * ����swing��Timer��ʹ�� һ����ʾʱ���GUI����
 */
public class TimerTest extends JFrame implements ActionListener {
	// һ����ʾʱ���JLabel
	private JLabel jlTime = new JLabel();
	private Timer timer, timer2;
//	private JButton jb = new JButton();

	public TimerTest() {
		setTitle("Timer����");
		Container con = getContentPane();
		con.setLayout(new BorderLayout());
		
		con.add(jlTime, BorderLayout.NORTH);
//		con.add(jb,BorderLayout.SOUTH);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(180, 180);
		
		// ����Timer��ʱ����������
		timer = new Timer(500, this);// ������д�ģ�������Ե���actionPerformed��
		timer.start();
//		jb.addActionListener(new A());
//		timer2 = new Timer(500, jb);// ���� ���������˼
		setVisible(true);
	}
//	class A implements ActionListener{
//		public void actionPerformed(ActionEvent e) {
//			System.out.println("222");
//
//		}
//	}
	/**
	 * ִ��TimerҪִ�еĲ��֣�
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

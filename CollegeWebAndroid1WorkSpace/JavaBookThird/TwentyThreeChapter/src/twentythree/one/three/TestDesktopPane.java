package twentythree.one.three;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import twentythree.one.two.TestTablePane;

public class TestDesktopPane extends JFrame {
	JDesktopPane destop;
	InternalFrame in1,in2,in3;
	public TestDesktopPane(){
		super("桌面面板 和 内部窗体");
		
//		in1 = new InternalFrame("in1");
//		in2 = new InternalFrame("in2");
//		in3 = new InternalFrame("in3");
		
		destop = new JDesktopPane();
		// 设置内部窗体拖动模式 不行呀 西八
	
		
		getContentPane().add(destop, BorderLayout.CENTER);
		final JLabel backlabel = new JLabel();
		URL resource = TestTablePane.class.getResource("34.jpg");
		ImageIcon ic = new ImageIcon(resource);
		backlabel.setIcon(ic);
		// 设置组件的显示位置和大小
		backlabel.setBounds(0, 0, ic.getIconWidth(), ic.getIconHeight());
		
		// 将标签组件添加到指定索引位置 最底层 哦
		destop.add(backlabel, new Integer(Integer.MIN_VALUE));
		
		//设置拖拽方式 连续重画
		destop.setDragMode(JDesktopPane.LIVE_DRAG_MODE); 
		getContentPane().add(destop, BorderLayout.CENTER);
		
		
		// 内部类 用按钮调出
		JPanel p1 = new JPanel();
		JButton b1 = new JButton("in1");
		JButton b2 = new JButton("in2");
		JButton b3 = new JButton("in3");
		p1.add(b1);p1.add(b2);p1.add(b3);

		b3.addActionListener(new ButtonCreateInframe("in3",in3));
		b2.addActionListener(new ButtonCreateInframe("in2",in2));
		b1.addActionListener(new ButtonCreateInframe("in1",in1));
		
		getContentPane().add(p1, BorderLayout.SOUTH);
		
		setBounds(100, 100, 500 ,375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new TestDesktopPane();
	}
	
	//继承内部类 把初始化信息放在这里
	private class InternalFrame extends JInternalFrame{
		public InternalFrame(String title){
			super(title);
			setResizable(true);
			setClosable(true);
			setIconifiable(true);
			setMaximizable(true);
			// 获得图片的路径
			URL resource = TestTablePane.class.getResource("img1.png");
			ImageIcon ic = new ImageIcon(resource);
			setFrameIcon(ic);
		}
	}

	public class ButtonCreateInframe implements ActionListener{
		InternalFrame inframe;
		String title;
		public ButtonCreateInframe(String title,InternalFrame inframe){
			this.title = title;
			this.inframe = inframe;
		}
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			if(inframe == null || inframe.isClosed()){
				// 获取桌面面板的所有内部窗体 当前桌面面板显示的
				JInternalFrame[] allframes = destop.getAllFrames();
				// 获得桌面面板中拥有内部窗体的数量 每次x位置叠加titleBarhight 这么高  y也跟着叠加，
//				int titleBarhight = 0 * allframes.length;
				int titleBarhight = 30 * allframes.length;
				int x = 10 + titleBarhight, y = x;
				int width = 250, height = 180;
				inframe = new InternalFrame(title);
				// 设置窗体的显示位置及大小
				inframe.setBounds(x, y , width, height);
				inframe.setVisible(true);
				
				destop.add(inframe); // 添加到窗体
				
			}
			try {
				// 选中窗体
				inframe.setSelected(true);// 激活窗口
			} catch (PropertyVetoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	}
}

package twentythree.one;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSplitPane;

public class TestSplitPane extends JFrame{
	/**
	 * 
	 */
	/**
	 * 
	 */
	/**
	 * 
	 */
	/**
	 * 
	 */
	public TestSplitPane(){
		super("分割面板");
		JLabel l1,l2,l3;
		l1 = new JLabel("1");
		l2 = new JLabel("2");
		l3 = new JLabel("3");
		Container con = getContentPane();
		
		final JSplitPane js = new JSplitPane();
		// 分割条左侧的宽度为40像素
		js.setDividerLocation(40);
		// 添加到指定区域
		con.add(js, BorderLayout.CENTER);
		// 左侧添加一个label
		js.setLeftComponent(l1);
		// 创建一个垂直方向的分割面板
		final JSplitPane vsPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		// 分割条上方高度为30px
		vsPane.setDividerLocation(30);
		vsPane.setDividerSize(8);
		vsPane.setOneTouchExpandable(true);// 提供UI小部件
		// 在调整分割条 位置时面板的重绘方式为连续绘制
		vsPane.setContinuousLayout(true);
		js.setRightComponent(vsPane);// 水平面板右边添加垂直面板
		// 在垂直面板上方添加label
		vsPane.setLeftComponent(l2);
		
		vsPane.setRightComponent(l3);
		setBounds(100, 100, 500 ,375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new TestSplitPane();
	}
}

package twentythree.three;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JToolBar;
import javax.swing.border.Border;

public class TestToolClass  extends JFrame{
	public TestToolClass(){
		super("创建弹出式菜单");
		
		// * 必须设置边界布局才有用
		this.setLayout(new BorderLayout());
		
		// 1.Jtoolbar
		final JToolBar toolbar = new JToolBar("工具栏");
		// 2.设置可不可以拖动
		toolbar.setFloatable(true);
		getContentPane().add(toolbar, BorderLayout.NORTH);
		
		JButton b1 = new JButton("新建");
		toolbar.add(b1);
		// 3.添加分割符 默认大小 
		toolbar.addSeparator();
		JButton b2 = new JButton("保存");
		toolbar.add(b2);
		// 3.添加分割符 自己制定 第二个是据上下的距离
		toolbar.addSeparator(new Dimension(20, 0));
		JButton b3 = new JButton("退出");
		toolbar.add(b3);
		
		JButton b4 = new JButton("保存22");
		getContentPane().add(b4, BorderLayout.SOUTH);
		
		setBounds(100, 100, 500 ,375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new TestToolClass();
	}
}

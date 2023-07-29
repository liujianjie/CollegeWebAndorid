package twentythree.two;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class TestMenu extends JFrame{
	public TestMenu(){
		super("测试菜单");
		
		// 1.菜单栏
		JMenuBar menubar = new JMenuBar();
		setJMenuBar(menubar);
		
		// 2.菜单对象
		JMenu menu = new JMenu("菜单");
		menubar.add(menu);
		
		// 3.菜单项对象
		JMenuItem menuitem = new JMenuItem("选项1");
		menu.add(menuitem);
		
		// 4.为菜单项添加监听
		menuitem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JMenuItem menuItem = (JMenuItem) e.getSource();
				System.out.println("您单击的菜单项：" + menuItem.getText());
			}
		});
		
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300, 300);
	}
	public static void main(String[] args) {
		new TestMenu();
	}
}

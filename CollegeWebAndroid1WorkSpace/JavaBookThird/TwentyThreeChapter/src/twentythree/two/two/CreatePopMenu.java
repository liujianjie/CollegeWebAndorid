package twentythree.two.two;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class CreatePopMenu extends JFrame{
	public CreatePopMenu(){
		super("创建弹出式菜单");
		// 创建弹出式菜单对象 菜单栏对象
		final JPopupMenu popupMenu = new JPopupMenu();
		// 2.菜单对象
		JMenu menu = new JMenu("菜单1");
		popupMenu.add(menu);
		JMenu menu2 = new JMenu("菜单2");
		popupMenu.add(menu2);
		
		// 3.菜单项对象
		JMenuItem menuitem = new JMenuItem("选项1");
		menu.add(menuitem);
		
		// 4.为窗体的顶层容器添加鼠标事件监听器
		getContentPane().addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				// 鼠标 释放的位置
				if (e.isPopupTrigger()){
					popupMenu.show(e.getComponent(), e.getX(), e.getY());
					
				}
			}
		});
		
		setBounds(100, 100, 500 ,375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new CreatePopMenu();
	}
}

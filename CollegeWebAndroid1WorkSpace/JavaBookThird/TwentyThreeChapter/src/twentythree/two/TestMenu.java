package twentythree.two;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class TestMenu extends JFrame{
	public TestMenu(){
		super("���Բ˵�");
		
		// 1.�˵���
		JMenuBar menubar = new JMenuBar();
		setJMenuBar(menubar);
		
		// 2.�˵�����
		JMenu menu = new JMenu("�˵�");
		menubar.add(menu);
		
		// 3.�˵������
		JMenuItem menuitem = new JMenuItem("ѡ��1");
		menu.add(menuitem);
		
		// 4.Ϊ�˵�����Ӽ���
		menuitem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JMenuItem menuItem = (JMenuItem) e.getSource();
				System.out.println("�������Ĳ˵��" + menuItem.getText());
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

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
		super("��������ʽ�˵�");
		// ��������ʽ�˵����� �˵�������
		final JPopupMenu popupMenu = new JPopupMenu();
		// 2.�˵�����
		JMenu menu = new JMenu("�˵�1");
		popupMenu.add(menu);
		JMenu menu2 = new JMenu("�˵�2");
		popupMenu.add(menu2);
		
		// 3.�˵������
		JMenuItem menuitem = new JMenuItem("ѡ��1");
		menu.add(menuitem);
		
		// 4.Ϊ����Ķ��������������¼�������
		getContentPane().addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				// ��� �ͷŵ�λ��
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

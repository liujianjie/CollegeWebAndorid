package twentythree.one.two;

import java.awt.BorderLayout;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TestTablePane extends JFrame{
	public TestTablePane(){
		super("ѡ�����");
		final JTabbedPane tab = new JTabbedPane();
		tab.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);// ���ò���
		tab.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent arg0) {
				// TODO Auto-generated method stub
				int selectedIndex = tab.getSelectedIndex();
				// ���ָ��������ѡ���ǩ
				String title = tab.getTitleAt(selectedIndex);
				System.out.println(title);
			}
		});
		getContentPane().add(tab, BorderLayout.CENTER);
		URL resource = TestTablePane.class.getResource("img1.png");
		ImageIcon ic = new ImageIcon(resource);
		final JLabel tableLableA = new JLabel("����ѡ�A");
		tab.addTab("ѡ�A", ic, tableLableA,"����鿴ѡ�A");

		final JLabel tableLableB = new JLabel("����ѡ�B");
		tab.addTab("ѡ�B", ic, tableLableB,"����鿴ѡ�B");
		
		final JLabel tableLableC = new JLabel("����ѡ�C");
		tab.addTab("ѡ�C", ic, tableLableC,"����鿴ѡ�C");
		
		tab.setSelectedIndex(2);//ѡ��
		tab.setEnabledAt(0, false);// ������
		
		setBounds(100, 100, 500 ,375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new TestTablePane();
	}
}

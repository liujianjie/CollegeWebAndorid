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
		super("选项面板");
		final JTabbedPane tab = new JTabbedPane();
		tab.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);// 设置布局
		tab.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent arg0) {
				// TODO Auto-generated method stub
				int selectedIndex = tab.getSelectedIndex();
				// 获得指定索引的选项卡标签
				String title = tab.getTitleAt(selectedIndex);
				System.out.println(title);
			}
		});
		getContentPane().add(tab, BorderLayout.CENTER);
		URL resource = TestTablePane.class.getResource("img1.png");
		ImageIcon ic = new ImageIcon(resource);
		final JLabel tableLableA = new JLabel("内容选项卡A");
		tab.addTab("选项卡A", ic, tableLableA,"点击查看选项卡A");

		final JLabel tableLableB = new JLabel("内容选项卡B");
		tab.addTab("选项卡B", ic, tableLableB,"点击查看选项卡B");
		
		final JLabel tableLableC = new JLabel("内容选项卡C");
		tab.addTab("选项卡C", ic, tableLableC,"点击查看选项卡C");
		
		tab.setSelectedIndex(2);//选中
		tab.setEnabledAt(0, false);// 不可用
		
		setBounds(100, 100, 500 ,375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new TestTablePane();
	}
}

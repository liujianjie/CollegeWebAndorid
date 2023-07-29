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
		super("�ָ����");
		JLabel l1,l2,l3;
		l1 = new JLabel("1");
		l2 = new JLabel("2");
		l3 = new JLabel("3");
		Container con = getContentPane();
		
		final JSplitPane js = new JSplitPane();
		// �ָ������Ŀ��Ϊ40����
		js.setDividerLocation(40);
		// ��ӵ�ָ������
		con.add(js, BorderLayout.CENTER);
		// ������һ��label
		js.setLeftComponent(l1);
		// ����һ����ֱ����ķָ����
		final JSplitPane vsPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		// �ָ����Ϸ��߶�Ϊ30px
		vsPane.setDividerLocation(30);
		vsPane.setDividerSize(8);
		vsPane.setOneTouchExpandable(true);// �ṩUIС����
		// �ڵ����ָ��� λ��ʱ�����ػ淽ʽΪ��������
		vsPane.setContinuousLayout(true);
		js.setRightComponent(vsPane);// ˮƽ����ұ���Ӵ�ֱ���
		// �ڴ�ֱ����Ϸ����label
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

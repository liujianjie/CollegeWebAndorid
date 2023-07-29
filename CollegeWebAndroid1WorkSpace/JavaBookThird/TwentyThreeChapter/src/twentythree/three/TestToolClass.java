package twentythree.three;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JToolBar;
import javax.swing.border.Border;

public class TestToolClass  extends JFrame{
	public TestToolClass(){
		super("��������ʽ�˵�");
		
		// * �������ñ߽粼�ֲ�����
		this.setLayout(new BorderLayout());
		
		// 1.Jtoolbar
		final JToolBar toolbar = new JToolBar("������");
		// 2.���ÿɲ������϶�
		toolbar.setFloatable(true);
		getContentPane().add(toolbar, BorderLayout.NORTH);
		
		JButton b1 = new JButton("�½�");
		toolbar.add(b1);
		// 3.��ӷָ�� Ĭ�ϴ�С 
		toolbar.addSeparator();
		JButton b2 = new JButton("����");
		toolbar.add(b2);
		// 3.��ӷָ�� �Լ��ƶ� �ڶ����Ǿ����µľ���
		toolbar.addSeparator(new Dimension(20, 0));
		JButton b3 = new JButton("�˳�");
		toolbar.add(b3);
		
		JButton b4 = new JButton("����22");
		getContentPane().add(b4, BorderLayout.SOUTH);
		
		setBounds(100, 100, 500 ,375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new TestToolClass();
	}
}

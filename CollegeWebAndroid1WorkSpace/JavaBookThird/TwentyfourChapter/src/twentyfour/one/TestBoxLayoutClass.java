package twentyfour.one;

import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class TestBoxLayoutClass extends JFrame{

	public TestBoxLayoutClass(){
		super("��ʽ����");
		
		// ���忴�飬���ý��� P434
		
		// ����һ��ˮƽ������
		Box topicBox = Box.createHorizontalBox();
		getContentPane().add(topicBox, BorderLayout.NORTH);
		// 2.���һ��5���ؿ��ˮƽ֧��
		topicBox.add(Box.createHorizontalStrut(5));
		JLabel topiclabel = new JLabel("���⣺");
		topicBox.add(topiclabel);
		// Ҳ��ˮƽ֧��
		topicBox.add(Box.createHorizontalStrut(5));
		JTextField tf1 = new JTextField(20);
		topicBox.add(tf1);
		// 3.����һ����ֱ������
		Box box = Box.createVerticalBox();
		getContentPane().add(box,  BorderLayout.CENTER);
		// ** ��ӵ�һ��5px�ߵĴ�ֱ֧��
		box.add(Box.createVerticalStrut(5));
		// 4.ˮƽ����
		Box contentBox = Box.createHorizontalBox();
		// 5.�����齨��ˮƽ����ֵ�����Ҳ����
		
		contentBox.setAlignmentX(1);
		// 
		box.add(contentBox);
		contentBox.add(Box.createHorizontalStrut(5));
		JLabel contentLabel = new JLabel("���ݣ�");// ���� Ӣ�� ð�Ż�Ӱ����
		// 6.���������ˮƽ����ֵ�����Ϸ�����
		contentLabel.setAlignmentY(0);
		contentBox.add(contentLabel);
		contentBox.add(Box.createHorizontalStrut(5));
		JScrollPane scrollpane = new JScrollPane();
		scrollpane.setAlignmentY(0);;
		contentBox.add(scrollpane);
		JTextArea contentTextArea = new JTextArea();
		contentTextArea.setLineWrap(true);
		scrollpane.setViewportView(contentTextArea);
		// 7.���һ��5px�ߵĴ�ֱ֧��
		box.add(Box.createVerticalStrut(5));
		//
		JButton jb1 = new JButton("ȷ��");
		// 8.���������ˮƽ����ֵ ���Ҳ����
//		jb1.setAlignmentX((float) 0.5);
		jb1.setAlignmentX(1);
		box.add(jb1);
		
		
		setBounds(100, 100, 500 ,375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new TestBoxLayoutClass();
	}
}

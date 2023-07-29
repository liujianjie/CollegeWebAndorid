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
		super("箱式布局");
		
		// 具体看书，不好解释 P434
		
		// 创建一个水平箱容器
		Box topicBox = Box.createHorizontalBox();
		getContentPane().add(topicBox, BorderLayout.NORTH);
		// 2.添加一个5像素宽的水平支柱
		topicBox.add(Box.createHorizontalStrut(5));
		JLabel topiclabel = new JLabel("主题：");
		topicBox.add(topiclabel);
		// 也是水平支柱
		topicBox.add(Box.createHorizontalStrut(5));
		JTextField tf1 = new JTextField(20);
		topicBox.add(tf1);
		// 3.创建一个垂直箱容器
		Box box = Box.createVerticalBox();
		getContentPane().add(box,  BorderLayout.CENTER);
		// ** 添加到一个5px高的垂直支柱
		box.add(Box.createVerticalStrut(5));
		// 4.水平容器
		Box contentBox = Box.createHorizontalBox();
		// 5.设置组建的水平调整值，靠右侧对齐
		
		contentBox.setAlignmentX(1);
		// 
		box.add(contentBox);
		contentBox.add(Box.createHorizontalStrut(5));
		JLabel contentLabel = new JLabel("内容：");// 中文 英文 冒号会影响间距
		// 6.创建组件的水平调整值，靠上方对齐
		contentLabel.setAlignmentY(0);
		contentBox.add(contentLabel);
		contentBox.add(Box.createHorizontalStrut(5));
		JScrollPane scrollpane = new JScrollPane();
		scrollpane.setAlignmentY(0);;
		contentBox.add(scrollpane);
		JTextArea contentTextArea = new JTextArea();
		contentTextArea.setLineWrap(true);
		scrollpane.setViewportView(contentTextArea);
		// 7.添加一个5px高的垂直支柱
		box.add(Box.createVerticalStrut(5));
		//
		JButton jb1 = new JButton("确定");
		// 8.设置组件的水平调整值 靠右侧对齐
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

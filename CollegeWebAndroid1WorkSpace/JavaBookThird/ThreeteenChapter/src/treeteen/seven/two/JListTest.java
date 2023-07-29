package treeteen.seven.two;

import java.awt.Container;import java.awt.event.WindowStateListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

public class JListTest extends JFrame{
	public JListTest(){
		Container cp = getContentPane();
		cp.setLayout(null);
		String []con = {"列表1","列表2","列表3","列表4","列表1","列表2","列表3","列表4"};
		JList<String> j1 = new JList<>(con);
		JScrollPane js = new JScrollPane(j1);
		js.setBounds(10, 40, 100, 100);
		cp.add(js);
		
		JPasswordField jp1 = new JPasswordField();
		jp1.setEchoChar('#');
		jp1.setBounds(10,10,100,30);
		cp.add(jp1);
		
		String musicString[] = { "默认", "灌篮高手", "泡泡堂", "eyes on me", "琴箫合奏" };// 为下拉框添加内容
		JComboBox<String[]> cmmusic;
		cmmusic = new JComboBox(musicString);
		cmmusic.setBounds(10, 250, 80, 20);
		cp.add(cmmusic);
		
		
		setSize(300,200);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new JListTest();
	}
}

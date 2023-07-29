package three.one.one;

import java.awt.event.ActionEvent;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class T1 extends JFrame{
	public static void main(String[] args) {
		String s1 = "asdfasdf";
		StringBuffer sb = new StringBuffer();
		sb.reverse();
		new T1().test();
	}
	public void test(){
		JFileChooser jf1 = new JFileChooser();
		jf1.showOpenDialog(getContentPane());
		
	}
	
}

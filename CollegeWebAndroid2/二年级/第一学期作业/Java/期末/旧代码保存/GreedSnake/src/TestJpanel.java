import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.w3c.dom.events.MouseEvent;

public class TestJpanel extends JFrame {
	public TestJpanel(){
		setLayout(null);
		JPanel jp = new JPanel();
		jp.setLayout(null);
		JPanel jp2 = new JPanel();
		jp2.setLayout(null);
		
		JLabel jl1 = new JLabel("1");
		JLabel jl2 = new JLabel("222");
		jp.add(jl1);
		jp2.add(jl2);
		
		jl1.setBounds(0, 0, 30, 30);
		jl2.setBounds(0, 0, 30, 30);
		
		jp.setBounds(10,10,100,30);
		jp2.setBounds(30,40,100,100);
		
		add(jp);
		add(jp2);
//		add(jl1);
//		add(jl2);
		this.setVisible(true);
		this.setSize(new Dimension(300,300));
	}
	public static void main(String[] args) {
		new TestJpanel();
	}
}

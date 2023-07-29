package three.four.six;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import javax.swing.border.Border;

public class TestScrollPanel extends JFrame{
	public TestScrollPanel(){
		super("testScroll");
		JCheckBox jc1 = new JCheckBox("复选框1");
		JCheckBox jc2 = new JCheckBox("复选框2");
		JCheckBox jc3 = new JCheckBox("复选框3");
		
		JTextArea jt = new JTextArea(10,10);
		jt.setLineWrap(true);// 换行
		
		JPanel jl = new JPanel();
		JPanel jl2 = new JPanel();
//		jl.add(jt);
		
		JScrollPane js = new JScrollPane(jt,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		Container con = this.getContentPane();
		con.setLayout(new BorderLayout());
		con.add(jl,BorderLayout.NORTH);
		
		jl.add(js);
	
		con.add(jl2, BorderLayout.SOUTH);
		jl2.add(jc1);
		jl2.add(jc2);
		jl2.add(jc3);
		jc1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jt.append("checkbox被选中");
			}
		});
		
		setSize(400, 400);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
	}
	public static void main(String[] args) {
		new TestScrollPanel();
	}
}

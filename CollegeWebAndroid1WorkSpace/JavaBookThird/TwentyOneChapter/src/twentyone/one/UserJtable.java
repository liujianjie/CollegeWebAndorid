package twentyone.one;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class UserJtable extends JFrame{
	public UserJtable(){
		super("���");
		
		Container con = getContentPane();
		String[][] rowdata = new String[][]{{"����1","����2"},{"����1","����2"}};
		String[] columndata = new String[2];
		for(int i = 0; i < 2; i++){
			columndata[i] = "����"+i;
		}
		JTable jt = new JTable(rowdata, columndata);
		JScrollPane jsp = new JScrollPane(jt);
		con.add(jsp, BorderLayout.CENTER);

		this.setVisible(true);
		this.setSize(300,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public static void main(String[] args) {
		new UserJtable();
	}
	
}

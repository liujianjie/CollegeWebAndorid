package twentythree.four;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class TestFileDialogClass extends JFrame{
	public TestFileDialogClass(){
		super("文件选择器");
		
		JPanel p1 = new JPanel();
		JTextField t1 = new JTextField(10);
		JButton b1 = new JButton("打开选择文件");
		p1.add(t1);p1.add(b1);
		getContentPane().add(p1, BorderLayout.SOUTH);
		
		
		//文件选择
		JFileChooser jfchoose = new JFileChooser();
		jfchoose.setMultiSelectionEnabled(true);
		jfchoose.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
//		jfchoose.setFileFilter();
		
		
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jfchoose.showOpenDialog(getContentPane());
				File file = jfchoose.getSelectedFile();
				t1.setText(file.getName());
			}
		});
		
		setBounds(100, 100, 500 ,375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new TestFileDialogClass();
	}
}

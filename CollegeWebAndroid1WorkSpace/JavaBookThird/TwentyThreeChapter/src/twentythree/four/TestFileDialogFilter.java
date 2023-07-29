package twentythree.four;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class TestFileDialogFilter extends JFrame{
	public TestFileDialogFilter(){
		super("�ļ�������");
	
		JLabel j1 = new JLabel("����ѡ��ͼƬ");
		getContentPane().add(j1, BorderLayout.CENTER);
		// 1.�ļ�ѡ��
		JFileChooser jfchoose = new JFileChooser();
//		jfchoose.setMultiSelectionEnabled(true); ��ѡ ����getSelectionFiles
//		jfchoose.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		FileFilter filefilter = new FileNameExtensionFilter("ֻѡ��ͼ��", "JPG", "GIF", "PNG");
		jfchoose.setFileFilter(filefilter);		
		
		j1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = jfchoose.showOpenDialog(getContentPane());
				// �жϴ��ļ�ѡ�������ǲ��ǰ��˴�
				if(i == JFileChooser.APPROVE_OPTION){
					File file = jfchoose.getSelectedFile();
					j1.setIcon(new ImageIcon(file.getAbsolutePath()));// ��ͼƬ��ʾ��ͼƬ��
				}
			}
		});
		
		setBounds(100, 100, 500 ,375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

public static void main(String[] args) {
	new TestFileDialogFilter();
}
}

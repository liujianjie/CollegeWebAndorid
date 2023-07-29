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
		super("文件过滤器");
	
		JLabel j1 = new JLabel("单击选择图片");
		getContentPane().add(j1, BorderLayout.CENTER);
		// 1.文件选择
		JFileChooser jfchoose = new JFileChooser();
//		jfchoose.setMultiSelectionEnabled(true); 多选 得用getSelectionFiles
//		jfchoose.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		FileFilter filefilter = new FileNameExtensionFilter("只选择图像", "JPG", "GIF", "PNG");
		jfchoose.setFileFilter(filefilter);		
		
		j1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = jfchoose.showOpenDialog(getContentPane());
				// 判断打开文件选择器后是不是按了打开
				if(i == JFileChooser.APPROVE_OPTION){
					File file = jfchoose.getSelectedFile();
					j1.setIcon(new ImageIcon(file.getAbsolutePath()));// 将图片显示在图片上
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

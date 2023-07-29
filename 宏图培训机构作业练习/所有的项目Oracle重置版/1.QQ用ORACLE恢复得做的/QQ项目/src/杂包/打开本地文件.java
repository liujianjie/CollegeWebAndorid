package 杂包;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class 打开本地文件 extends JFrame{
	JLabel kj;
	public 打开本地文件(){
		super();
		Container con=getContentPane();
		con.setLayout(new FlowLayout());
		kj=new JLabel("呵呵");
		con.add(kj);
		kj.addMouseListener(new A());
		setVisible(true);
		setSize(300,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

	}
	public static void main(String[] args) {
		new 打开本地文件();
	}
	class A extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			if (e.getSource() == kj) {
				//String url = "E:/宏图作业练习/html练习/刘建杰html曳舞天下制作2015917答辩项目/首页.html";
				String url = "F:/呵呵/第三次下载html游戏/51CTO下载-守卫游戏/Core/index.html";
				java.net.URI uri = java.net.URI.create(url);
				// 获取当前系统桌面扩展
				java.awt.Desktop dp = java.awt.Desktop.getDesktop();
				// 判断系统桌面是否支持要执行的功能
				if (dp.isSupported(java.awt.Desktop.Action.BROWSE)) {
					try {
						dp.browse(uri);
					} catch (Exception e1) {

					}// 获取系统默认浏览器打开链接
				}
			}
		}
	}
	
}

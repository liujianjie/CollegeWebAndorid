package 推箱子;

import javax.swing.JFrame;

public class Help extends JFrame{
	public Help(){
		super("2015推箱子-帮助");
		setSize(400,500);
		setVisible(true);
		//setLocationRelativeTo(null);不要中心对焦
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//关闭
	}
	
}

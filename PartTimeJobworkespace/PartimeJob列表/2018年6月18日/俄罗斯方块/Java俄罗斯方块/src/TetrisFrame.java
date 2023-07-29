
//Java版简易俄罗斯方块
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class TetrisFrame extends JFrame implements ActionListener {
	static JMenu game = new JMenu("游戏");
	JMenuItem newgame = game.add("新游戏");
	JMenuItem pause = game.add("暂停");
	JMenuItem goon = game.add("继续");
	JMenuItem exit = game.add("退出");
	static JMenu help = new JMenu("帮助");
	JMenuItem about = help.add("关于");
	Tetrisblok a = new Tetrisblok();
	static TetrisMp3 mp3sound;

	public TetrisFrame() {
		mp3sound = new TetrisMp3("背景音乐2.mp3");
		ImageIcon bgimg = new ImageIcon("image/图四.jpg");
		JLabel jpanelbgimg = new JLabel(bgimg);// 将图片放在一个标签中
		jpanelbgimg.setBounds(0, 0, 320, 395);// 左上角x，左上角y，右下角x，右下角y
		a.add(jpanelbgimg);// 添加标签背景图片
		a.setBorder(new EmptyBorder(-5, 0, -5, 0));// 设置面板的边界，让面板没有厚度，不会产生空隙，使背景图片不美观
		addKeyListener(a);
		this.add(a);
		newgame.addActionListener(this); // 新游戏菜单项
		pause.addActionListener(this); // 暂停菜单项
		goon.addActionListener(this); // 继续菜单项
		about.addActionListener(this); // 关于菜单项
		exit.addActionListener(this); // 退出菜单项
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == newgame) // 新游戏菜单项
		{
			a.newGame();
		} else if (e.getSource() == pause) // 暂停菜单项
		{
			a.pauseGame();
		} else if (e.getSource() == goon) // 继续菜单项
		{
			a.continueGame();
		} else if (e.getSource() == about) // 关于菜单项
		{
			DisplayToast("左右键移动，向上键旋转");
			
		} else if (e.getSource() == exit) // 退出菜单项
		{
			System.exit(0);
		}
	}

	public void DisplayToast(String str) {
		JOptionPane.showMessageDialog(null, str, "提示", JOptionPane.ERROR_MESSAGE);
	}

	public static void main(String[] args) {
		TetrisFrame frame = new TetrisFrame();
		JMenuBar menu = new JMenuBar();
		frame.setJMenuBar(menu);
		menu.add(game);
		menu.add(help);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 结束按钮可用
		frame.setSize(320, 395);
		frame.setTitle("俄罗斯方块1.0版");
		// frame.setUndecorated(true);
		frame.setVisible(true);
		frame.setResizable(false);
		// 背景音乐循环播放。 用了第三方包，具体代码我也不清楚，mp3文件使用起来比较麻烦，可以mp3转wav文件，再用audio包下的类循环播放wav文件即可
		// 第三方包 循环播放使用了线程，更随，主程序的消亡而停止
		mp3sound.loop();
	}
}

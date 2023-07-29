package snake;

import java.awt.*;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.*;

//不想蛇节段就不要有repaint（）；清空
public class snake extends JFrame {
	Random r;
	boolean gameover = false;// 退出
	// 蛇
	int N = 500;// 蛇节
	int x[] = new int[N];
	int y[] = new int[N];
	boolean food = false;/* 1表示需要出现新食物,0表示已经存在食物 */
	int direction = 1;/* 方向往右 */
	int node = 2;/* 节数 */
	int foodx, foody;
	int i;
	Image ima;
	Image sheimg;
	int count = 0;
	boolean isgameover;
	public snake() {
		super("aa");
		Container a = getContentPane();
		setLayout(null);
		init();
		// 背景颜色
		a.setBackground(Color.yellow);
		
		r = new Random();// 随机函数
		this.setUndecorated(true);// 无边框
		
			// 监听键值 和窗口值
		addKeyListener(new B());
		// 引入图片
		ima = Toolkit.getDefaultToolkit().getImage("img/white.gif");
		sheimg = Toolkit.getDefaultToolkit().getImage("img/black.gif");
		setSize(640, 480);
		setVisible(true);
		Toolkit tk = Toolkit.getDefaultToolkit();
		int width = (int) tk.getScreenSize().width / 2;
		int height = (int) tk.getScreenSize().height / 2;
		setLocation(width / 2, height / 2);// 居中
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		repaint();// 循环

	}
	// 初始化
	public void init(){
		count = 0;
		node = 2;
		x[0] = 100;
		y[0] = 100;/* 蛇头 */
		x[1] = 120;
		y[1] = 100;
		direction = 1;
		isgameover = false;
		this.requestFocus();
		this.repaint();
	}
	public void gameover(){
		JOptionPane.showMessageDialog(null, "分数："+count*10+",游戏结束");
	}
	public static void main(String dfs[]) {
		new snake();
	}

	public void paint(Graphics g) {
		// TODO 自动生成的方法存根
		super.paint(g);
		if (food == true) {
			g.drawImage(ima, foodx, foody, this);// 一直画食物
		}
		if (food == false) {
			foodx = r.nextInt(600) + 20;
			while (foodx % 20 != 0) {
				foodx++;
			}
			foody = r.nextInt(400) + 40;
			while (foody % 20 != 0) {
				foody++;
			}
			food = true;// 输出食物代码
		}

		// 这是重点
		for (i = node - 1; i > 0; i--) {
			x[i] = x[i - 1];
			y[i] = y[i - 1];// 蛇的坐标赋给下一节
		}

		// snake.x[0]=snake.x[0]+10;蛇的头向前进
		if (direction == 1) {
			x[0] += 20;// 向右
		}
		if (direction == 2) {
			x[0] -= 20;// 向左
		}
		if (direction == 3) {
			y[0] -= 20;// 向上
		}
		if (direction == 4) {
			y[0] += 20;// 向下
		}

		// 画蛇的两节
		for (i = 0; i < node; i++) {
			g.drawImage(sheimg, x[i], y[i], this);
		}

		// 吃食物
		if (x[0] == foodx && y[0] == foody) {
			node += 1;
			food = false;// 以下个食物出现
			count += 1;
		}

		// 延迟
		try {
			Thread.sleep(100);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		// 检测死亡
		if (x[0] < 10) {
			isgameover = true;
		}
		if (x[0] > 630) {
			isgameover = true;
		}
		if (y[0] < 10) {
			isgameover = true;
		}
		if (y[0] > 630) {
			isgameover = true;
		}
		
		if(isgameover){
			gameover();
			init();
		}
		repaint();//循环
	}

	// 键值
	class B extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == 38 && direction != 4) {
				direction = 3;
			}
			if (e.getKeyCode() == 40 && direction != 3) {
				direction = 4;
			}
			if (e.getKeyCode() == 37 && direction != 1) {
				direction = 2;
			}
			if (e.getKeyCode() == 39 && direction != 2) {
				direction = 1;

			}
			if (e.getKeyCode() == 27) {
				dispose();
			}
		}

	}
}

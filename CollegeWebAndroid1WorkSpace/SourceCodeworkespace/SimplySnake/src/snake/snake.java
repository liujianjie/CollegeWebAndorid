package snake;

import java.awt.*;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.*;

//�����߽ڶξͲ�Ҫ��repaint���������
public class snake extends JFrame {
	Random r;
	boolean gameover = false;// �˳�
	// ��
	int N = 500;// �߽�
	int x[] = new int[N];
	int y[] = new int[N];
	boolean food = false;/* 1��ʾ��Ҫ������ʳ��,0��ʾ�Ѿ�����ʳ�� */
	int direction = 1;/* �������� */
	int node = 2;/* ���� */
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
		// ������ɫ
		a.setBackground(Color.yellow);
		
		r = new Random();// �������
		this.setUndecorated(true);// �ޱ߿�
		
			// ������ֵ �ʹ���ֵ
		addKeyListener(new B());
		// ����ͼƬ
		ima = Toolkit.getDefaultToolkit().getImage("img/white.gif");
		sheimg = Toolkit.getDefaultToolkit().getImage("img/black.gif");
		setSize(640, 480);
		setVisible(true);
		Toolkit tk = Toolkit.getDefaultToolkit();
		int width = (int) tk.getScreenSize().width / 2;
		int height = (int) tk.getScreenSize().height / 2;
		setLocation(width / 2, height / 2);// ����
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		repaint();// ѭ��

	}
	// ��ʼ��
	public void init(){
		count = 0;
		node = 2;
		x[0] = 100;
		y[0] = 100;/* ��ͷ */
		x[1] = 120;
		y[1] = 100;
		direction = 1;
		isgameover = false;
		this.requestFocus();
		this.repaint();
	}
	public void gameover(){
		JOptionPane.showMessageDialog(null, "������"+count*10+",��Ϸ����");
	}
	public static void main(String dfs[]) {
		new snake();
	}

	public void paint(Graphics g) {
		// TODO �Զ����ɵķ������
		super.paint(g);
		if (food == true) {
			g.drawImage(ima, foodx, foody, this);// һֱ��ʳ��
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
			food = true;// ���ʳ�����
		}

		// �����ص�
		for (i = node - 1; i > 0; i--) {
			x[i] = x[i - 1];
			y[i] = y[i - 1];// �ߵ����긳����һ��
		}

		// snake.x[0]=snake.x[0]+10;�ߵ�ͷ��ǰ��
		if (direction == 1) {
			x[0] += 20;// ����
		}
		if (direction == 2) {
			x[0] -= 20;// ����
		}
		if (direction == 3) {
			y[0] -= 20;// ����
		}
		if (direction == 4) {
			y[0] += 20;// ����
		}

		// ���ߵ�����
		for (i = 0; i < node; i++) {
			g.drawImage(sheimg, x[i], y[i], this);
		}

		// ��ʳ��
		if (x[0] == foodx && y[0] == foody) {
			node += 1;
			food = false;// ���¸�ʳ�����
			count += 1;
		}

		// �ӳ�
		try {
			Thread.sleep(100);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		// �������
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
		repaint();//ѭ��
	}

	// ��ֵ
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

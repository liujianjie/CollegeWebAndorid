package pack;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
//2018-7-20
//21:00
//xmj
// ����һ������˹������
class Tetrisblok extends JPanel implements KeyListener {	
	
	private int blockType;// blockType ����������	
	private int turnState;// turnState������״̬
	private int score = 0;
	private int x,y;    //��ǰ����λ��
	private int nextblockType=-1,nextturnState=-1;  //��һ�������ͺ�״̬
	private Timer timer;//��ʱ��
	// �洢�Ѿ����µķ��飨1����Χǽ��2��
	int[][] map = new int[12][21];
	// wavsound 
	TetrisWav wavsound;
	// ��ͼƬ ���ʱ��ͼƬ
	Image winimg = Toolkit.getDefaultToolkit().getImage("image/ͼ2.png");
	Image loseimg = Toolkit.getDefaultToolkit().getImage("image/ͼ3.png");
	Image myImage = Toolkit.getDefaultToolkit().getImage("image/block0.gif");
	boolean gameoverbln = false; //�жϳ���loseimg������
	boolean gamewinbln = false; //�жϳ���winimg������
	// �������״ 
	//��һ�������������Z��L��J��I�� �T 6��
	//�ڶ����������Ϊ��ת���κ�ķ������
	private final int shapes[][][] = new int[][][] {
	        // ������I��
			{ { 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
					{ 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0 },
					{ 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
					{ 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0 } },
		    // ��z����
			{ { 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			    	{ 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 },
							{ 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
							{ 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 } },		
			// z����
			{ { 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
					{ 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0 },
					{ 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
					{ 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0 } },
			// J����
			{ { 0, 1, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 },
					{ 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
					{ 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0 },
					{ 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 } },
			// ������
			{ { 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
					{ 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
					{ 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
					{ 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } },
			// L����
			{ { 1, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 },
					{ 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
					{ 1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 },
					{ 0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 } },
			// ������
			{ { 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
					{ 0, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 },
					{ 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
					{ 0, 1, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0 } } };

	// �����·���ķ���
	public void newblock() {
		//û����һ����
		if(nextblockType==-1 && nextturnState==-1){
			blockType = (int) (Math.random() * 1000) % 7;
			turnState = (int) (Math.random() * 1000) % 4;
			nextblockType=(int) (Math.random() * 1000) % 7;
			nextturnState=(int) (Math.random() * 1000) % 4;
		}
		else{//������һ����
			blockType = nextblockType;
			turnState = nextturnState;
			nextblockType=(int) (Math.random() * 1000) % 7;
			nextturnState=(int) (Math.random() * 1000) % 4;
		}
		x = 4;		y = 0;//��Ļ�Ϸ�����
		if (gameover(x, y) == 1) {//��Ϸ���� 
			gameoverbln = true;
			repaint();
			//�����Ч
			wavsound.playWavfile("��Ч4.wav");
			JOptionPane.showMessageDialog(null, "GAME OVER");//��һ��
		
			newmap();
			drawwall();
			score = 0;
			gameoverbln = false; //�ָ�
		}
	}
	
	// ��Ϸ�����ķ���
	public void win(){
		gamewinbln = true;
		//�����Ч
		wavsound.playWavfile("��Ч3.wav");
		repaint();
		int	msg = JOptionPane.showConfirmDialog(null, "YOU WIN!","�Ƿ������" , JOptionPane.OK_CANCEL_OPTION);
		if(msg == 0){//�� ����
			newGame();
		}else{// ������ �˳�
			System.exit(0);
		}
		gamewinbln = false; //�ָ�
	}

	// ��Χǽ
	public void drawwall() {
		int i ,j;
		for (i = 0; i < 12; i++) {
			map[i][20] = 2;
		}
		for (j = 0; j < 21; j++) {
			map[11][j] = 2;
			map[0][j] = 2;
		}
	}

	// ��ʼ����ͼ
	public void newmap() {
		int i ,j;
		for (i = 0; i < 12; i++) {
			for (j = 0; j < 21; j++) {
				map[i][j] = 0;
			}
		}
	}

	// ��ʼ�����췽��
	Tetrisblok() {
		wavsound = new TetrisWav();
		newblock();
		newmap();
		drawwall();
		timer = new Timer(500, new TimerListener());//0.5��
		timer.start();
	}
	// ��ʱ������
	class TimerListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			if (blow(x, y + 1, blockType, turnState) == 1 && !gamewinbln) {//�������� �Լ����õ���ѡ���ʱ����
				y = y + 1; //��ǰ��������
				delline();
			}
			if (blow(x, y + 1, blockType, turnState) == 0 && !gameoverbln) {//���������� Ϊ����Ϸ����ʱ���滭��һ����״���º����һЩbug
				add(x, y, blockType, turnState);
				delline();
				newblock();
			}
			repaint();//��Ļ�ػ�
		}
	}
	public void newGame()//����Ϸ
	{
		score = 0; // ����ӵģ�������� ��ɾ��
		newblock();
		newmap();
		drawwall();
	}
	public void pauseGame()//��ͣ��Ϸ
	{
		timer.stop();
	}
	public void continueGame()//������Ϸ
	{
		timer.start();
	}

	// ��ת��ǰ����ķ���
	public void turn() {
		int tempturnState = turnState;
		turnState = (turnState + 1) % 4;
		if (blow(x, y, blockType, turnState) == 1) {//������ת
		}
		if (blow(x, y, blockType, turnState) == 0) {//��������ת
			turnState = tempturnState;// ����ת�����ָ�Ϊԭ����ֵ
		}
		repaint();
	}


	// ���Ƶķ���
	public void left() {
		if (blow(x - 1, y, blockType, turnState) == 1) {
			x = x - 1;
		}
		;
		repaint();
	}

	// ���Ƶķ���
	public void right() {
		if (blow(x + 1, y, blockType, turnState) == 1) {
			x = x + 1;
		}
		;
		repaint();
	}

	// ����ķ���
	public void down() {
		if (blow(x, y + 1, blockType, turnState) == 1) {
			y = y + 1;
			delline();
		}
		if (blow(x, y + 1, blockType, turnState) == 0) {
			add(x, y, blockType, turnState);
			newblock();
			delline();
		}
		repaint();
	}

	// �Ƿ�Ϸ��ķ���
	public int blow(int x, int y, int blockType, int turnState) {
		for (int a = 0; a < 4; a++) {
			for (int b = 0; b < 4; b++) {
				if (((shapes[blockType][turnState][a * 4 + b] == 1) && (map[x
						+ b + 1][y + a] == 1))
						|| ((shapes[blockType][turnState][a * 4 + b] == 1) && (map[x
								+ b + 1][y + a] == 2))) {
					return 0;
				}
			}
		}
		return 1;
	}

	// ���еķ���
	public void delline() {
		int c = 0;
		for (int b = 0; b < 21; b++) {
			for (int a = 0; a < 12; a++) {
				if (map[a][b] == 1) {
					c = c + 1;
					if (c == 10) {//��������
						score += 10;
						// ���� ��Ч �� wav�ļ� �������Դ�audio���µ��� �����ţ���Ҫʹ���ļ����������ɡ�Ҫ��1
						wavsound.playWavfile("��Ч1.wav");
						for (int d = b; d > 0; d--) {
							for (int e = 0; e < 12; e++) {//���Ϸ���������
								map[e][d] = map[e][d - 1];
							}
						}
						// �жϷ����Ƿ�ﵽ Ҫ��4
						if(score >= 100){
							win();
						}
					}
				}
			}
			c = 0;
		}
	}
	// �ж���Ϸ��������
	public int gameover(int x, int y) {
		if (blow(x, y, blockType, turnState) == 0) {
			return 1;
		}
		return 0;
	}

	// �ѵ�ǰ�������map
	public void add(int x, int y, int blockType, int turnState) {
		int j = 0;
		for (int a = 0; a < 4; a++) {
			for (int b = 0; b < 4; b++) {
				if (shapes[blockType][turnState][j] == 1) {
					map[x + b + 1][y + a] = shapes[blockType][turnState][j];
				}
				j++;
			}
		}
	}

	//paint(Graphics g)����Ļ�ػ��ķ�����
	public void paint(Graphics g) {
		super.paint(g);//���ø����paint()������ʵ�ֳ�ʼ������
		
		Color originalcolor = g.getColor();// ���浱ǰ��ɫ���Ա�ָ�
		switchColorWithtype(g, blockType);
		// ����ǰ���� 
		int i ,j;
		for (j = 0; j < 16; j++) {
			if (shapes[blockType][turnState][j] == 1) {
				g.fillRect((j % 4 + x + 1) * 15, (j / 4 + y) * 15, 15, 15);
			}
		}
		g.setColor(originalcolor);
		// ���Ѿ��̶��ķ����Χǽ
		for (j = 0; j < 21; j++) {
			for (i = 0; i < 12; i++) {
				if (map[i][j] == 1) { //���Ѿ��̶��ķ���
					g.fillRect(i * 15, j * 15, 15, 15);
				}
				if (map[i][j] == 2) {//��Χǽ
					g.drawRect(i * 15, j * 15, 15, 15);
				}
			}
		}
		
		g.drawString("score=" + score, 225, 15);
		g.drawString("��һ������״", 225, 50);
		
		switchColorWithtype(g, nextblockType);
		
		int W=15;
		//�����Ҳ����������һ����
		for (j = 0; j < 16; j++) {
			if (shapes[nextblockType][nextturnState][j] == 1) {
				g.fillRect(225+(j % 4 ) * 15, (j / 4 ) * 15+100, 15, 15);
				if(!gameoverbln){
					g.drawImage(myImage, 225+(j % 4 ) * 15, (j / 4 ) * 15+200, W, W,this);
				}
			}
		}
	
		if (gameoverbln) {//��Ϸ����
			g.drawImage(loseimg, 210, 200,85,85,this);
		}
		if (gamewinbln) {//��Ϸ��ʤ
			g.drawImage(winimg, 210, 200,85,85,this);
		}
		g.setColor(originalcolor);
//		int W=15;
//		Image myImage = Toolkit.getDefaultToolkit().getImage("block0.gif");
//		g.drawImage(myImage, 100, 200, W, W,this);

	}
	
	// Ҫ��3.����blocktype����״������ɫ�������ǹ̶��ģ������Ҫ�漴���� Random swich ѡ�񣬶����� ����blockType�ˣ��ź����ǣ����̶��ķ���û���뵽��ô�����ɫ��ȥ
	public void switchColorWithtype(Graphics g,int Type){
		switch (Type) {
		case 0:
			g.setColor(Color.BLUE);
		break;
		case 1:
			g.setColor(Color.ORANGE);
			break;
		case 2:
			g.setColor(Color.RED);
			break;
		case 3:
			g.setColor(Color.YELLOW);
			break;
		case 4:
			g.setColor(Color.PINK);
			break;
		case 5:
			g.setColor(Color.CYAN);
			break;
		case 6:
			g.setColor(Color.GREEN);
			break;

		default:
			break;
		}
	}

	// ���̼���
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_DOWN:
			down();
			break;
		case KeyEvent.VK_UP:
			turn();
			break;
		case KeyEvent.VK_RIGHT:
			right();
			break;
		case KeyEvent.VK_LEFT:
			left();
			break;
		}
	}

	// ����
	public void keyReleased(KeyEvent e) {
	}

	// ����
	public void keyTyped(KeyEvent e) {
	}


}

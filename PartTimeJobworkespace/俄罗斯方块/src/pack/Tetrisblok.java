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
// 创建一个俄罗斯方块类
class Tetrisblok extends JPanel implements KeyListener {	
	
	private int blockType;// blockType 代表方块类型	
	private int turnState;// turnState代表方块状态
	private int score = 0;
	private int x,y;    //当前方块位置
	private int nextblockType=-1,nextturnState=-1;  //下一方块类型和状态
	private Timer timer;//定时器
	// 存储已经放下的方块（1）及围墙（2）
	int[][] map = new int[12][21];
	// wavsound 
	TetrisWav wavsound;
	// 改图片 输的时候图片
	Image winimg = Toolkit.getDefaultToolkit().getImage("image/图2.png");
	Image loseimg = Toolkit.getDefaultToolkit().getImage("image/图3.png");
	Image myImage = Toolkit.getDefaultToolkit().getImage("image/block0.gif");
	boolean gameoverbln = false; //判断出现loseimg的条件
	boolean gamewinbln = false; //判断出现winimg的条件
	// 方块的形状 
	//第一组代表方块类型有Z、L、J、I、 田、T 6种
	//第二组第三四组为旋转几次后的方块矩阵
	private final int shapes[][][] = new int[][][] {
	        // 长条形I形
			{ { 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
					{ 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0 },
					{ 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
					{ 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0 } },
		    // 倒z字形
			{ { 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			    	{ 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 },
							{ 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
							{ 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 } },		
			// z字形
			{ { 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
					{ 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0 },
					{ 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
					{ 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0 } },
			// J字形
			{ { 0, 1, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 },
					{ 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
					{ 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0 },
					{ 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 } },
			// 田字形
			{ { 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
					{ 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
					{ 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
					{ 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } },
			// L字形
			{ { 1, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 },
					{ 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
					{ 1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 },
					{ 0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 } },
			// ⊥字形
			{ { 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
					{ 0, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 },
					{ 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
					{ 0, 1, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0 } } };

	// 生成新方块的方法
	public void newblock() {
		//没有下一方块
		if(nextblockType==-1 && nextturnState==-1){
			blockType = (int) (Math.random() * 1000) % 7;
			turnState = (int) (Math.random() * 1000) % 4;
			nextblockType=(int) (Math.random() * 1000) % 7;
			nextturnState=(int) (Math.random() * 1000) % 4;
		}
		else{//已有下一方块
			blockType = nextblockType;
			turnState = nextturnState;
			nextblockType=(int) (Math.random() * 1000) % 7;
			nextturnState=(int) (Math.random() * 1000) % 4;
		}
		x = 4;		y = 0;//屏幕上方中央
		if (gameover(x, y) == 1) {//游戏结束 
			gameoverbln = true;
			repaint();
			//响出音效
			wavsound.playWavfile("音效4.wav");
			JOptionPane.showMessageDialog(null, "GAME OVER");//弹一次
		
			newmap();
			drawwall();
			score = 0;
			gameoverbln = false; //恢复
		}
	}
	
	// 游戏结束的方法
	public void win(){
		gamewinbln = true;
		//响出音效
		wavsound.playWavfile("音效3.wav");
		repaint();
		int	msg = JOptionPane.showConfirmDialog(null, "YOU WIN!","是否继续？" , JOptionPane.OK_CANCEL_OPTION);
		if(msg == 0){//是 继续
			newGame();
		}else{// 不继续 退出
			System.exit(0);
		}
		gamewinbln = false; //恢复
	}

	// 画围墙
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

	// 初始化地图
	public void newmap() {
		int i ,j;
		for (i = 0; i < 12; i++) {
			for (j = 0; j < 21; j++) {
				map[i][j] = 0;
			}
		}
	}

	// 初始化构造方法
	Tetrisblok() {
		wavsound = new TetrisWav();
		newblock();
		newmap();
		drawwall();
		timer = new Timer(500, new TimerListener());//0.5秒
		timer.start();
	}
	// 定时器监听
	class TimerListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			if (blow(x, y + 1, blockType, turnState) == 1 && !gamewinbln) {//可以下落 以及不让弹出选择框时下落
				y = y + 1; //当前方块下移
				delline();
			}
			if (blow(x, y + 1, blockType, turnState) == 0 && !gameoverbln) {//不可以下落 为了游戏结束时不绘画下一个形状以致后面的一些bug
				add(x, y, blockType, turnState);
				delline();
				newblock();
			}
			repaint();//屏幕重画
		}
	}
	public void newGame()//新游戏
	{
		score = 0; // 另外加的，如果不对 请删除
		newblock();
		newmap();
		drawwall();
	}
	public void pauseGame()//暂停游戏
	{
		timer.stop();
	}
	public void continueGame()//继续游戏
	{
		timer.start();
	}

	// 旋转当前方块的方法
	public void turn() {
		int tempturnState = turnState;
		turnState = (turnState + 1) % 4;
		if (blow(x, y, blockType, turnState) == 1) {//可以旋转
		}
		if (blow(x, y, blockType, turnState) == 0) {//不可以旋转
			turnState = tempturnState;// 将旋转次数恢复为原来的值
		}
		repaint();
	}


	// 左移的方法
	public void left() {
		if (blow(x - 1, y, blockType, turnState) == 1) {
			x = x - 1;
		}
		;
		repaint();
	}

	// 右移的方法
	public void right() {
		if (blow(x + 1, y, blockType, turnState) == 1) {
			x = x + 1;
		}
		;
		repaint();
	}

	// 下落的方法
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

	// 是否合法的方法
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

	// 消行的方法
	public void delline() {
		int c = 0;
		for (int b = 0; b < 21; b++) {
			for (int a = 0; a < 12; a++) {
				if (map[a][b] == 1) {
					c = c + 1;
					if (c == 10) {//该行满行
						score += 10;
						// 调用 音效 。 wav文件 可以用自带audio包下的类 来播放，需要使用文件输入流即可。要求1
						wavsound.playWavfile("音效1.wav");
						for (int d = b; d > 0; d--) {
							for (int e = 0; e < 12; e++) {//则上方方块下移
								map[e][d] = map[e][d - 1];
							}
						}
						// 判断分数是否达到 要求4
						if(score >= 100){
							win();
						}
					}
				}
			}
			c = 0;
		}
	}
	// 判断游戏结束方法
	public int gameover(int x, int y) {
		if (blow(x, y, blockType, turnState) == 0) {
			return 1;
		}
		return 0;
	}

	// 把当前方块添加map
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

	//paint(Graphics g)是屏幕重画的方法。
	public void paint(Graphics g) {
		super.paint(g);//调用父类的paint()方法，实现初始化清屏
		
		Color originalcolor = g.getColor();// 保存当前颜色，以便恢复
		switchColorWithtype(g, blockType);
		// 画当前方块 
		int i ,j;
		for (j = 0; j < 16; j++) {
			if (shapes[blockType][turnState][j] == 1) {
				g.fillRect((j % 4 + x + 1) * 15, (j / 4 + y) * 15, 15, 15);
			}
		}
		g.setColor(originalcolor);
		// 画已经固定的方块和围墙
		for (j = 0; j < 21; j++) {
			for (i = 0; i < 12; i++) {
				if (map[i][j] == 1) { //画已经固定的方块
					g.fillRect(i * 15, j * 15, 15, 15);
				}
				if (map[i][j] == 2) {//画围墙
					g.drawRect(i * 15, j * 15, 15, 15);
				}
			}
		}
		
		g.drawString("score=" + score, 225, 15);
		g.drawString("下一方块形状", 225, 50);
		
		switchColorWithtype(g, nextblockType);
		
		int W=15;
		//窗口右侧区域绘制下一方块
		for (j = 0; j < 16; j++) {
			if (shapes[nextblockType][nextturnState][j] == 1) {
				g.fillRect(225+(j % 4 ) * 15, (j / 4 ) * 15+100, 15, 15);
				if(!gameoverbln){
					g.drawImage(myImage, 225+(j % 4 ) * 15, (j / 4 ) * 15+200, W, W,this);
				}
			}
		}
	
		if (gameoverbln) {//游戏结束
			g.drawImage(loseimg, 210, 200,85,85,this);
		}
		if (gamewinbln) {//游戏获胜
			g.drawImage(winimg, 210, 200,85,85,this);
		}
		g.setColor(originalcolor);
//		int W=15;
//		Image myImage = Toolkit.getDefaultToolkit().getImage("block0.gif");
//		g.drawImage(myImage, 100, 200, W, W,this);

	}
	
	// 要求3.根据blocktype的形状更改颜色，但是是固定的，如果需要随即给个 Random swich 选择，而不是 根据blockType了，遗憾的是，画固定的方块没有想到怎么添加颜色上去
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

	// 键盘监听
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

	// 无用
	public void keyReleased(KeyEvent e) {
	}

	// 无用
	public void keyTyped(KeyEvent e) {
	}


}

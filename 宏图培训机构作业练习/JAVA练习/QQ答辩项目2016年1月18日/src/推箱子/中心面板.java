package 推箱子;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Stack;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import QQ数据库信息.QQGAME;
import 接口.QQuserInterface;
import 方法实现接口.QQuserimp;

public class 中心面板  extends JPanel{
	int hua=1;
	int up=1;
	int down=2;
	int left=3;
	int right=4;
	int direction=down;//默认向下
	
	int ren=5;//定位人的位置
	int reni,renj;//人当前位置
	int qian1i,qian1j,qian2i,qian2j;//人前一格前两格位置
	
	//草地 箱子代表的值
	int caodi=2;
	int xiangzi=3;
	int mudidi=4;
	int hong=9;
	int yuanshimap[][];
	QQuserInterface qservice=new QQuserimp();//关卡数
	int level;
	int map[][];//获取地图大小
	//步骤
	Stack<step> steps=new Stack<step>();
	
	JLabel l1;
	//引入图片
	Image img[]={new ImageIcon("img1/.gif").getImage(),//0
			new ImageIcon("img1/1.gif").getImage(),//1
			new ImageIcon("img1/2.jpg").getImage(),//2
			new ImageIcon("img1/9.jpg").getImage(),//3
			new ImageIcon("img1/4a.GIF").getImage(),//4
			new ImageIcon("img1/5.gif").getImage(),//5
			new ImageIcon("img1/6.gif").getImage(),//6
			new ImageIcon("img1/7.gif").getImage(),//7
			new ImageIcon("img1/8.gif").getImage(),//8
			new ImageIcon("img1/9a.GIF").getImage(),//9
			new ImageIcon("img1/aaaa.jpg").getImage()};//10
	//构造函数
	public 中心面板(QQGAME qqgame){
		level=qservice.seltxzgk(qqgame.getQqnum());	
		System.out.println(level);
		this.initGame();
		this.addKeyListener(new B());//授权给键盘事件
		this.addMouseListener(new C());//授权给鼠标事件 
		
	}
	public void setText(){
		l1.setText("LEVEL:"+level);
	}
	//请求焦点继承鼠标事件
	class C extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO 自动生成的方法存根
			中心面板.this.requestFocus();
			hua=2;
			中心面板.this.repaint();
		}
		
	}
	//继承键值
	class B extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO 自动生成的方法存根
			if(e.getKeyCode()==e.VK_UP){
				  direction=up;
			  }
			  if(e.getKeyCode()==e.VK_DOWN){
				  direction=down;
			  }
			  if(e.getKeyCode()==e.VK_LEFT){
				  direction=left;
			  }
			  if(e.getKeyCode()==e.VK_RIGHT){
				  direction=right;
			  }
			  
			gethanglie();//获取行列
			move();
			中心面板.this.repaint();//重新绘画
			//过关
			boolean bin=iswin();
			if(bin){
				JOptionPane.showMessageDialog(null, "恭喜过关！");
				if(level<=11){
					steps.clear();//清空步骤 防止悔一步返回
					setText();//过关等级加
					level+=1;//加一
					initGame();//游戏初始化
					中心面板.this.repaint();
				}else{
					JOptionPane.showMessageDialog(null, "恭喜通关！");
					
					return;
				}
			}
		}
		
	}
	//定义步骤
	class step{
		private int map_data[][]=new int[20][20];
		private int fangxiang;
		public int[][] getMap_data() {
			return map_data;
		}
		public void setMap_data(int[][] map_data) {
			this.map_data = map_data;
		}
		public int getFangxiang() {
			return fangxiang;
		}
		public void setFangxiang(int fangxiang) {
			this.fangxiang = fangxiang;
		}
	
	}
	//主要调用方法
	public void huiyibu(){
		if(steps.size()<=0){
			JOptionPane.showMessageDialog(null, "没有步骤可以返回了!");
			return;
		}
		step s=steps.pop();//从堆栈中取出步骤输出
		this.map=s.getMap_data();
		this.direction=s.getFangxiang();//一次一次输出 
		this.repaint();//重新绘制
		
	}
	//判断是否通关
	public boolean iswin(){
		for(int i=0;i<20;i++){
			for(int j=0;j<20;j++){
				if(map[i][j]==xiangzi){//如果有一个黄色箱子
					return false;
				}
			}
		}
		return true;
		
	}
	//记录步骤方法
	public void JLstep(){
		int d[][]=new int[20][20];
		step s=new step();
		for(int i=0;i<20;i++){
			for(int j=0;j<20;j++){
				d[i][j]=map[i][j];
				s.setMap_data(d);//记录地图数据
			}
		}
		s.setFangxiang(this.direction);//记录方向
		steps.push(s);//把得到的步骤压栈
		
	}
	//判断能否可以走
	public void move(){
		//如果前一格是草地或目的地
		if(map[qian1i][qian1j]==caodi||map[qian1i][qian1j]==mudidi){
			JLstep();
			int yuanshi=getyuanshi(reni,renj);//接收
			map[reni][renj]=yuanshi;//人展的位置为原来的物体 草货目的地
			map[qian1i][qian1j]=ren;//前一格变为人
		}
		//如果钱一个是箱子货红色箱子
		if(map[qian1i][qian1j]==xiangzi||map[qian1i][qian1j]==hong){
			if(map[qian2i][qian2j]==caodi){//再判断第二个是否为草地
				JLstep();
				int yuanshi=getyuanshi(reni,renj);
				map[reni][renj]=yuanshi;//人展的位置为原来的物体 草货目的地
				map[qian1i][qian1j]=ren;//前一格为人
				map[qian2i][qian2j]=xiangzi;//qian两格为箱子
			}
			else if(map[qian2i][qian2j]==mudidi){//如果第二格为目的地
				JLstep();
				int yuanshi=getyuanshi(reni,renj);
				map[reni][renj]=yuanshi;//人展的位置为原来的物体 草货目的地
				map[qian1i][qian1j]=ren;//前一格为人
				map[qian2i][qian2j]=hong;//qian两格为红箱子
				
			}
			
			
		}
		
	}
	public int getyuanshi(int i,int j){
		//从原始地图中获取值
		int value=yuanshimap[i][j];
		//只有人和箱子才能变为草地
		if(value==ren||value==xiangzi){
			value=caodi;
		}
		//红箱子变为目的地
		if(value==hong){
			value=mudidi;
		}
		return value;//返回值
	}
	public void gethanglie(){
		for(int i=0;i<20;i++){
			for(int j=0;j<20;j++){
				if(map[i][j]==5){
					reni=i;
					renj=j;//获取人的位置行和列
				}	
			}
		}
		if(direction==up){//获取人移动的位置行和列
			qian1i=reni-1;
			qian1j=renj;
			qian2i=reni-2;
			qian2j=renj;
		}else if(direction==down){
			qian1i=reni+1;
			qian1j=renj;
			qian2i=reni+2;
			qian2j=renj;
		}else if(direction==left){
			qian1i=reni;
			qian1j=renj-1;
			qian2i=reni;
			qian2j=renj-2;
		}else if(direction==right){
			qian1i=reni;
			qian1j=renj+1;
			qian2i=reni;
			qian2j=renj+2;
		}
	}
	//游戏开始具体实现方法
	public void initGame(){
		this.direction=down;//默认向下 解决悔一步和过关的面向问题
		map=DiTu.getMap(level);//引入地图值
		yuanshimap=DiTu.getMap(level);//获取当前位置
	}
	
	//根据要求改变关卡地图信息
	public void setlevel(int level){
		this.level=level;//记录传过来的关卡
		initGame();//获取地图信息
		this.repaint();//重新绘画
		steps.clear();//清空步骤防止选关后返回上一关
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO 自动生成的方法存根
		super.paint(g);
		if(hua==2){
		for(int i=0;i<20;i++){
			for(int j=0;j<20;j++){
				int zhi=map[i][j];//赋值
				int top=i*30;
				int left1=j*30;
				if(zhi==ren){
					if(direction==up){
						g.drawImage(img[8],left1,top,this);
					}else if(direction==down){
						g.drawImage(img[5],left1,top,this);
					}else if(direction==left){
						g.drawImage(img[6],left1,top,this);
					}else if(direction==right){
						g.drawImage(img[7],left1,top,this);
					}
				}else{
				g.drawImage(img[zhi],left1,top,this);}
				 
			}
			
		}
		//让面板获取焦点
		//中心面板.this.requestFocus();//让绘制玩图就获取焦点
	}
	}
}

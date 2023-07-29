package QQGAME;
import java.awt.*;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.*;

import QQ数据库信息.QQgame;
import 接口.QQuserInterface;
import 方法实现接口.QQuserimp;
//不想蛇节段就不要有repaint（）；清空
//唯一的缺点就是 载入进度需重启程序
public class Test而已  extends JFrame{
	Random r;
	boolean gameover=false;//退出
	boolean caidan=false;//弹出菜单
	//蛇
	int N=500;//蛇节
	int x[]=new int[N];
	int y[]=new int[N];
	boolean  food=false;/*1表示需要出现新食物,0表示已经存在食物*/
	int   direction=1;/*方向往右*/
	int 	foodx,foody;
	int i;
	int node=2;
	Image ima;
	Image ima1;
	Image ima2;
	JPopupMenu pop;//弹出式菜单
	JMenuItem itt1,itt2,itt3,itt4;
	QQgame game;
	QQuserInterface qseriver=new QQuserimp();
	boolean zai=false;
	public Test而已(QQgame qqusergame,boolean zai){//是否载入蛇节
		super("贪吃蛇");
//		System.out.println(qqusergame.getQqname());
//		System.out.println(qqusergame.getQqnum());
		x[0]=100;y[0]=100;/*蛇头开始位置*/
		x[1]=120;y[1]=100;
		this.game = qqusergame;//这里是因为在 tuichu fenshu 这3个文件共享
		//这里是重点
		if(zai){
			this.game=qseriver.shenode(qqusergame.getQqnum());//tmd终于搞出来了蛇节//不过每次都查数据库有点过了，应该在上一级查好，这里这是更新保存的进度 恩！！！
			this.zai=zai;//判断要不要加上历史蛇节
			node=game.getShenode();
	
			//这里也来吧 给蛇头位置
			x[0]=game.getShetoux0();y[0]=game.getShetouy0();/*蛇头*/
			x[1]=game.getShetoux1();y[1]=game.getShetouy1();
			
			//把direction的值也改变
			direction=game.getDirection();
			System.out.println(game.getDirection());
		}
		Container a=getContentPane();
		setLayout(null);
		//背景颜色
		a.setBackground(Color.yellow);
		
		r=new Random();//随机函数
		this.setUndecorated(true);//无边框
		//食物
		//0-639
		foodx=r.nextInt(600)+20;
		//生成的坐标需要是10 的倍数(为了让蛇跟食物在一条线上)
		while(foodx%20!=0){
			foodx++;
		}
		foody=r.nextInt(400)+40;
		while(foody%20!=0){
			foody++;
		}//先要有食物
		//給食物坐标
		if(zai){
			foodx=game.getFoodx();
			foody=game.getFoody();
			food=true;
		}
		
		//监听键值 和窗口值
		addKeyListener(new B());
		//引入图片
		ima=Toolkit.getDefaultToolkit().getImage("img/121927760470B85A521856A8B42D13C7DB5CD07714.jpg");
		ima1=Toolkit.getDefaultToolkit().getImage("img/black.gif");
		ima2=Toolkit.getDefaultToolkit().getImage("img/1.png");
		setIconImage(ima2);//窗口图片

		//弹出框
		pop=new JPopupMenu();
		itt1=new JMenuItem("保存进度");//我在线上
		itt2=new JMenuItem("载入进度");
		pop.add(itt1);
		pop.addSeparator();
		pop.add(itt2);
		pop.addSeparator();
		
		pop.addKeyListener(new B());
		setSize(840,680);
		setVisible(true);
		setLocationRelativeTo(null);//居中
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	public void paint(Graphics g) {
	// TODO 自动生成的方法存根
		super.paint(g);//这个应该是调用上一级 并重新画 若不写，则不会刷新每一帧 而会停留下来
		if(food==true){
			//g.drawRect(foodx,foody,10,10);
			g.drawImage(ima,foodx,foody, this);//一直画食物
		}
		
		if(food==false){
			foodx=r.nextInt(600)+20;
			while(foodx%20!=0){
				foodx++;
			}
			foody=r.nextInt(400)+40;
			while(foody%20!=0){
				foody++;
			}
			food=true;//输出食物代码
		}
		for(i=node-1;i>0;i--){
			x[i]=x[i-1];
			y[i]=y[i-1];//蛇的坐标赋给下一节
		}
		
		//snake.x[0]=snake.x[0]+10;蛇的头向前进
		if(direction==1){
				x[0]+=20;//向右
		}
		if(direction==2){
				x[0]-=20;//向左
		}
		if(direction==3){
				y[0]-=20;//向上
		}
		if(direction==4){
				y[0]+=20;//向下
		}
		
		//画蛇的两节//必须要有颜色
		for(i=0;i<node;i++){
			//g.drawRect(x[i],y[i],10,10);
			g.drawImage(ima1,x[i],y[i], this);
		}
		
		//吃食物
		if(x[0]==foodx&&y[0]==foody){
			node+=1;
			food=false;//以下个食物出现
		}
		
		//延迟
		try{
			Thread.sleep(100);
		}catch(Exception e){
			
		}
		if(x[0]<0){
		//	JOptionPane.showMessageDialog(null, "gameower");
			dispose();
			new fenshu(this);
		}
		if(x[0]>840){
		//JOptionPane.showMessageDialog(null, "gameower");
			dispose();
			new fenshu(this);
		}
		if(y[0]<0){
		//	JOptionPane.showMessageDialog(null, "gameower");
			dispose();
			new fenshu(this);
		}
		if(y[0]>680){
		//	JOptionPane.showMessageDialog(null, "gameower");
			dispose();
			new fenshu(this);
		}
		// repaint();//循环
		if(caidan){
			new tuichu(this);
			dispose();
		}
		repaint();//2018年4月9日 现在才知道，要放在这里，才是重新绘画 与super（paint）； 相辅相成，一个刷新，一个重新绘画
	}
	//键值
	class B extends KeyAdapter{
		  public void keyPressed(KeyEvent e) {
			  if(e.getKeyCode()==38){
				  direction=3;
				  
			  }
			  if(e.getKeyCode()==40){
				  direction=4;
				  
			  }
			  if(e.getKeyCode()==37){
				  direction=2;
				  
			  }
			  if(e.getKeyCode()==39){
				  direction=1;
				  
			  }
			  if(e.getKeyCode()==27){
				  caidan=true;
				  
			  }
		  }
		
	}
}

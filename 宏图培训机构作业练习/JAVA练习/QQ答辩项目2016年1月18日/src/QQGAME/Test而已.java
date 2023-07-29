package QQGAME;
import java.awt.*;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.*;

import QQ数据库信息.QQGAME;
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
	QQGAME game;
	QQuserInterface qseriver=new QQuserimp();
	boolean zai=false;
	public Test而已(QQGAME game,boolean zai){//是否载入蛇节
		super("aa");
		System.out.println(game.getQqname());
		System.out.println(game.getQqnum());
		this.game=game;
		if(zai){
			this.zai=zai;//判断要不要加上历史蛇节
			//这里是重点
			QQGAME ab=qseriver.shenode(game.getQqname(), game);//tmd终于搞出来了蛇节
			//System.out.println(ab.getShenode());
			node=ab.getShenode();
		}
		Container a=getContentPane();
		setLayout(null);
		//背景颜色
		a.setBackground(Color.yellow);
		x[0]=100;y[0]=100;/*蛇头*/
		x[1]=120;y[1]=100;
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
		//监听键值 和窗口值
		addKeyListener(new B());
		//引入图片
		ima=Toolkit.getDefaultToolkit().getImage("img/121927760470B85A521856A8B42D13C7DB5CD07714.jpg");
		ima1=Toolkit.getDefaultToolkit().getImage("img/black.gif");
		ima2=Toolkit.getDefaultToolkit().getImage("img/1.png");
		setIconImage(ima2);//窗口图片
	//	repaint();//循环
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public static  void main(String dfs[]){
//		QQGAME qqh=new QQGAME();
//		qqh.setQqname("小小");//只是为了运行
//		new Test而已(qqh,false);//不载入蛇节
		
	}
	public void paint(Graphics g) {
	// TODO 自动生成的方法存根
	super.paint(g);

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
			new fenshu(this,zai);
		}
		if(x[0]>840){
		//JOptionPane.showMessageDialog(null, "gameower");
			dispose();
//			System.exit(0);
			new fenshu(this,zai);
		}
		if(y[0]<0){
		//	JOptionPane.showMessageDialog(null, "gameower");
			dispose();
		//	System.exit(0);
			new fenshu(this,zai);
		}
		if(y[0]>680){
		//	JOptionPane.showMessageDialog(null, "gameower");
			dispose();
		//	System.exit(0);
			new fenshu(this,zai);
		}
		// repaint();//循环
		if(caidan){
			new tuichu(this,game);
			dispose();
		}
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

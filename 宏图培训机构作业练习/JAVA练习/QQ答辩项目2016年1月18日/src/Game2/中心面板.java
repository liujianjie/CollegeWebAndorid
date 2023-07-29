package Game2;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



// 道具问题 解决   还有 1.判断死亡 2.原地炸弹 3.道具加成 4.双人。。。。。 
/*
	1.判断死亡  炸弹火焰与人的坐标相同死亡
	2.原地炸弹 五
	3.道具加成 如果是道具1 就多放几个炸弹 道具2就多些火焰范围（解决）
	4.双人 不知道能不能实现 用线程 唉


*/
public class 中心面板  extends JPanel{	
	int hua=1;
	int up=1;
	int down=2;
	int left=3;
	int right=4;
	int upp;
	int direction=down;//默认向下
	//改变
	int zhadan;//判断华炸弹图片
	int jiazhadan;//判断画加炸弹图片
	int zha=9;
	int zhasi,zhasj,zhaxi,zhaxj,zhazi,zhazj,zhayi,zhayj;//火焰旁边的坐标
	int zhasi2,zhasj2,zhaxi2,zhaxj2,zhazi2,zhazj2,zhayi2,zhayj2;//捡道具火焰威力
	int zhasi3,zhasj3,zhaxi3,zhaxj3,zhazi3,zhazj3,zhayi3,zhayj3;//捡道具火焰威力2
	int baozha=4;
	int huoyan=4;//火焰图片
	boolean bao2=false;//判断爆完后画
	boolean bao=false;//判断能不能爆后 画
	boolean baowan=false;//判断能不能爆
	boolean baowan11=false;//判断能不能爆
	boolean baowan2=false;//判断爆完
	boolean baowan3=false;//火焰余波
	boolean baowan4=false;//箱子变为草地
	int zhai,zhaj;//获取炸弹位置
	boolean yige=false;//只允许一个炸弹
	boolean jiayige=false;//允许加一个炸弹
	boolean daoju1=false;//道具啊1
	boolean daoju2=false;//道具啊2
	boolean daoju3=false;//道具啊3
	boolean daoju4=false;//道具啊4
	boolean daoju11=false;//范围扩大的判断
	boolean daoju22=false;//火焰范围扩大的判断
	boolean daoju33=false;//火焰范围扩大的判断
	boolean daoju44=false;//火焰范围扩大的判断
	boolean daoju111=false;//范围扩大的判断
	boolean daoju222=false;//火焰范围扩大的判断
	boolean daoju333=false;//火焰范围扩大的判断
	boolean daoju444=false;//火焰范围扩大的判断
	int daojutu1=10;//画道具图1
	int daojutu2=11;//画道具图2
	boolean jiadaoju1=false;//是否加到道具1
	boolean jiadaoju11=false;//是否加到道具1加1
	boolean jiadaoju2=false;//是否加到道具2
	int i=0;//加强
	int yuanshi111,yuanshi222,yuanshi333,yuanshi444;//为了子类能使用
	
	int ren=5;//定位人的位置
	int reni,renj;//人当前位置
	int qian1i,qian1j;
	
	//草地 箱子代表的值
	int caodi=2;
	int xiangzi=3;
	int mudidi=4;
	int hong=9;
	int yuanshimap[][];
	
	int level=12;
	int map[][];//获取地图大小
	
	JLabel l1;
	//引入图片
	Image img[]={new ImageIcon("img2/.gif").getImage(),//0背景
			new ImageIcon("img2/1.gif").getImage(),//1房子
			new ImageIcon("img2/2.jpg").getImage(),//2草地
			new ImageIcon("img2/3.gif").getImage(),//3箱子
			new ImageIcon("img2/火焰.png").getImage(),//4火焰
			new ImageIcon("img2/5.gif").getImage(),//5人
			new ImageIcon("img2/6.gif").getImage(),//6
			new ImageIcon("img2/7.gif").getImage(),//7
			new ImageIcon("img2/8.gif").getImage(),//8
			new ImageIcon("img2/炸弹.png").getImage()//9炸弹
			,new ImageIcon("img2/道具1.png").getImage(),//道具1 10
			new ImageIcon("img2/道具2.png").getImage()};//道具2 11
	//构造函数
	public 中心面板(){
		this.initGame();
		this.addKeyListener(new B());//授权给键盘事件
		this.addMouseListener(new C());//授权给鼠标事件 
		D a=new D();//线程
		a.start();
		
	}
	public void setText(){
		l1.setText("LEVEL:"+(level+1));
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
			if(e.getKeyCode()==38){
				  //System.out.println("上");
				  direction=up;
			  }
			  if(e.getKeyCode()==40){
				 // System.out.println("下");
				  direction=down;
			  }
			  if(e.getKeyCode()==37){
				 // System.out.println("左");
				  direction=left;
			  }
			  if(e.getKeyCode()==39){
				  //System.out.println("右");
				  direction=right;
			  }
			  if(e.getKeyCode()==32){//炸弹
				  if(yige==false){//一个炸弹
					  direction=upp;
			  			yige=true;
				  }
				  //捡到加炸弹道具后加一个炸弹
				  if(jiadaoju2){
					 if(jiayige==false){
						direction=upp;
						jiayige=true;
					}
				  }
			  }
			  
			gethanglie();//获取行列
			中心面板.this.repaint();//重新绘画
			move();
		}	
	}
	public int getyuanshi1(int i,int j){
		//从地图中获取值 改变
		//int value=map[i][j];
		//if(value==hong||value==4){//炸弹和火焰变为草地
		//	value=caodi;
		//}
		//加了的炸弹。。。。。
		int value=map[i][j];
		if(jiayige){//
			if(jiazhadan==7){//如果是炸弹就改变
				value=hong;
				jiazhadan=6;
				bao2=true;//可以爆炸了
				System.out.println("dfsfsd");
			}
		}
		return value;//返回值
	}
	//判断能否可以走
	public void move(){
		//如果前一格是草地
		if(map[qian1i][qian1j]==caodi){
			int yuanshi=getyuanshi(reni,renj);//接收
			map[reni][renj]=yuanshi;//人展的位置为原来的物体 草还有炸弹
			map[qian1i][qian1j]=ren;//前一格变为人	
		}
		
		//如果前一格是道具1
		if(map[qian1i][qian1j]==daojutu1){
			int yuanshi=getyuanshi(reni,renj);//接收
			map[reni][renj]=yuanshi;//人展的位置为原来的物体 草还有炸弹
			map[qian1i][qian1j]=ren;//前一格变为人	
			
			//这么说人就加了道具了那么久判断了
			//道具1为火焰增强
			jiadaoju1=true;
			i++;
			if(i==2){
				jiadaoju11=true;//再加强
			}
		}
		//如果前一格是道具2
		if(map[qian1i][qian1j]==daojutu2){
			int yuanshi=getyuanshi(reni,renj);//接收
			map[reni][renj]=yuanshi;//人展的位置为原来的物体 草还有炸弹
			map[qian1i][qian1j]=ren;//前一格变为人	
			
			//这么说人就加了道具了那么久判断了
			jiadaoju2=true;//道具2为多放炸弹
			
		}

	}

	public int getyuanshi(int i,int j){
		//从地图中获取值 改变
		int value=map[i][j];
		//只有人才能变为草地
		if(value==ren){
			value=caodi;
		}
		//炸弹。。。。。
		if(yige){//一开始只能一个炸弹
		if(zhadan==7){//如果是炸弹就改变
			value=hong;
			zhadan=6;
			bao2=true;//可以爆炸了
			
		}
		}
		
		//如果是道具图1
		if(value==daojutu1){
			value=caodi;//返回草地
		}//如果是道具图2
		if(value==daojutu2){
			value=caodi;//返回草地
		}
		return value;//返回值
		
		//炸弹爆炸用一格30*30的火焰来填补草地 草地变成火焰图片(变成几个草地要) 火焰后变回草地
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
		for(int i=0;i<20;i++){
			for(int j=0;j<20;j++){
				if(map[i][j]==9){
					zhai=i;
					zhaj=j;//获取炸弹的位置行和列
				}	
			}
		}
		if(direction==up){//获取人移动的位置行和列
			qian1i=reni-1;
			qian1j=renj;
		}else if(direction==down){
			qian1i=reni+1;
			qian1j=renj;
		}else if(direction==left){
			qian1i=reni;
			qian1j=renj-1;
		}else if(direction==right){
			qian1i=reni;
			qian1j=renj+1;
		}
		zhasi=zhai+1;//上
		zhasj=zhaj;
		zhaxi=zhai-1;//下
		zhaxj=zhaj;
		zhazi=zhai;//左
		zhazj=zhaj-1;
		zhayi=zhai;
		zhayj=zhaj+1;//右
		zhasi2=zhai+2;//上
		zhasj2=zhaj;
		zhaxi2=zhai-2;//下
		zhaxj2=zhaj;
		zhazi2=zhai;//左
		zhazj2=zhaj-2;
		zhayi2=zhai;
		zhayj2=zhaj+2;//右
		zhasi3=zhai+3;//上
		zhasj3=zhaj;
		zhaxi3=zhai-3;//下
		zhaxj3=zhaj;
		zhazi3=zhai;//左
		zhazj3=zhaj-3;
		zhayi3=zhai;
		zhayj3=zhaj+3;//右
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
	}
	
	//实现炸弹爆炸要延迟 所以线程要有个
	class D extends Thread{
		@Override
		public void run() {
			//爆炸
			while(true){//一直运动
				if(bao2){
					//System.out.println("gyhgkjh ");
					
					try{//开始
						Thread.sleep(2000);//要爆炸
					}catch(Exception e){
						e.printStackTrace();
					}
					move2();

					bao=true;//爆炸画图片
					bao2=false;//下次不进来了
					repaint();//重画
					try{//结束位草地
						Thread.sleep(200);//已经爆炸了 画草地图片
					}catch(Exception e){
						e.printStackTrace();
					}
					baowan=true;
					baowan11=true;
					baowan3=true;
					repaint();//重画 去掉火焰
					baowan3=false;
					move();
				}
			}	
		}
		//炸弹爆炸的范围
		public void move2(){//四个范围
			if(map[zhasi][zhasj]==caodi){//不用｜｜或是因为要判断道具啊
				map[zhasi][zhasj]=4;
				//捡了道具威力后
				if(jiadaoju1){
					if(map[zhasi2][zhasj2]==caodi){
						map[zhasi2][zhasj2]=4;
						//捡了道具威力后加1
						/*if(jiadaoju11){
							if(map[zhasi3][zhasj3]==caodi){
								map[zhasi3][zhasj3]=4;
								
							}else if(map[zhasi3][zhasj3]==xiangzi){
								map[zhasi3][zhasj3]=4;
								daoju111=true;//可以变为道具 箱子。。。
							}
						}*/
					}else if(map[zhasi2][zhasj2]==xiangzi){
						map[zhasi2][zhasj2]=4;
						daoju11=true;//可以变为道具 箱子。。。
					}
				}
				
			}else if(map[zhasi][zhasj]==xiangzi){
				map[zhasi][zhasj]=4;
				daoju1=true;//可以变为道具 箱子。。。
			}
			//炸弹炸道具为草地 不过先变为火焰 在位草地
			if(map[zhasi][zhasj]==daojutu1||map[zhasi][zhasj]==daojutu2){
				map[zhasi][zhasj]=4;
				
			}
			//炸弹2炸道具为草地 不过先变为火焰 在位草地
			if(map[zhasi2][zhasj2]==daojutu1||map[zhasi2][zhasj2]==daojutu2){
				map[zhasi2][zhasj2]=4;
				
			}
				//if(map[zhasi][zhasj]==map[qian1i][qian1j]){
					//JOptionPane.showMessageDialog(null, "失败");
				//}
			if(map[zhaxi][zhaxj]==caodi){
				map[zhaxi][zhaxj]=4;
				//捡了道具威力后
				if(jiadaoju1){
					if(map[zhaxi2][zhaxj2]==caodi){
						map[zhaxi2][zhaxj2]=4;
						//捡了道具2威力后
						/*if(jiadaoju11){
							if(map[zhaxi3][zhaxj3]==caodi){
								map[zhaxi3][zhaxj3]=4;
							}else if(map[zhaxi3][zhaxj3]==xiangzi){
								map[zhaxi3][zhaxj3]=4;
								daoju222=true;//可以变为道具 箱子。。。
							}
						}*/
					}else if(map[zhaxi2][zhaxj2]==xiangzi){
						map[zhaxi2][zhaxj2]=4;
						daoju22=true;//可以变为道具 箱子。。。
					}
				}
				
			}else if(map[zhaxi][zhaxj]==xiangzi){
				map[zhaxi][zhaxj]=4;
				daoju2=true;//可以变为道具 箱子。。。
			}
			//炸弹炸道具为草地 不过先变为火焰 在位草地
			if(map[zhaxi][zhaxj]==daojutu1||map[zhaxi][zhaxj]==daojutu2){
				map[zhaxi][zhaxj]=4;
				
			}
			
			//炸弹炸道具为草地 不过先变为火焰 在位草地
			if(map[zhaxi2][zhaxj2]==daojutu1||map[zhaxi2][zhaxj2]==daojutu2){
				map[zhaxi2][zhaxj2]=4;
				
			}

				//if(map[zhaxi][zhaxj]==map[qian1i][qian1j]){
					//JOptionPane.showMessageDialog(null, "失败");
				//}
			if(map[zhazi][zhazj]==caodi){
				map[zhazi][zhazj]=4;
				//捡了道具威力后
				if(jiadaoju1){
					if(map[zhazi2][zhazj2]==caodi){
						map[zhazi2][zhazj2]=4;
						//捡了道具2威力后
						/*if(jiadaoju11){
							if(map[zhazi3][zhazj3]==caodi){
								map[zhazi3][zhazj3]=4;
							}else if(map[zhazi3][zhazj3]==xiangzi){
								map[zhazi3][zhazj3]=4;
								daoju333=true;//可以变为道具 箱子。。。
							}
						}*/
					}else if(map[zhazi2][zhazj2]==xiangzi){
						map[zhazi2][zhazj2]=4;
						daoju33=true;//可以变为道具 箱子。。。
					}
				}
				
			}else if(map[zhazi][zhazj]==xiangzi){
				map[zhazi][zhazj]=4;
				daoju3=true;//可以变为道具 箱子。。。
			}
			//炸弹炸道具为草地 不过先变为火焰 在位草地
			if(map[zhazi][zhazj]==daojutu1||map[zhazi][zhazj]==daojutu2){
				map[zhazi][zhazj]=4;
				
			}
			
			//炸弹炸道具为草地 不过先变为火焰 在位草地
			if(map[zhazi2][zhazj2]==daojutu1||map[zhazi2][zhazj2]==daojutu2){
				map[zhazi2][zhazj2]=4;
				
			}
				//if(map[zhazi][zhazj]==map[qian1i][qian1j]){
					//JOptionPane.showMessageDialog(null, "失败");
				//}
			if(map[zhayi][zhayj]==caodi){
				map[zhayi][zhayj]=4;
				//捡了道具威力后
				if(jiadaoju1){
					if(map[zhayi2][zhayj2]==caodi){
						map[zhayi2][zhayj2]=4;
						//捡了道具2威力后
						/*if(jiadaoju11){
							if(map[zhayi3][zhayj3]==caodi){
								map[zhayi3][zhayj3]=4;
							}else if(map[zhayi3][zhayj3]==xiangzi){
								map[zhayi3][zhayj3]=4;
								daoju444=true;//可以变为道具 箱子。。。
							}
						}*/
					}else if(map[zhayi2][zhayj2]==xiangzi){
						map[zhayi2][zhayj2]=4;
						daoju44=true;//可以变为道具 箱子。。。
					}
				}
				
			}else if(map[zhayi][zhayj]==xiangzi){
				map[zhayi][zhayj]=4;
				daoju4=true;//可以变为道具 箱子。。。
			}
			//炸弹炸道具为草地 不过先变为火焰 在位草地
			if(map[zhayi][zhayj]==daojutu1||map[zhayi][zhayj]==daojutu2){
				map[zhayi][zhayj]=4;
				
			}
			
			//炸弹炸道具为草地 不过先变为火焰 在位草地
			if(map[zhayi2][zhayj2]==daojutu1||map[zhayi2][zhayj2]==daojutu2){
				map[zhayi2][zhayj2]=4;
				
			}
				//if(map[zhayi][zhayj]==map[qian1i][qian1j]){
				//	JOptionPane.showMessageDialog(null, "失败");//我也不知道为什么 要+1 -1 反正凑成了。。。。
			//	}
		}
		//道具方法
		public int daoju(){
			int a=new Random().nextInt(5);
			if(a==1){
				a=caodi;//草地
			}
			else if(a==0){
				a=daojutu2;//道具2
			}else if(a==3){
				a=caodi;//草地
			}
			else if(a==2){
				a=daojutu1;//道具1
			}else if(a==4){
				a=caodi;//草地
			}
			
			return a;
		}
		//判断能否可以走
		public void move(){//这里箱子变为道具和变为草地
			if(baowan){
				int yuanshi=getyuanshi(zhai,zhaj);//接收
				map[zhai][zhaj]=yuanshi;//炸弹的位置为原来的物体 草
				//火焰范围
				int yuanshi1=getyuanshi(zhasi,zhasj);//接收
				if(daoju1){
					int a=daoju();//随机数
					map[zhasi][zhasj]=a;//箱子的位置为道具了 
				}else{
					map[zhasi][zhasj]=yuanshi1;//火焰的位置为原来的物体 草
					
				}
				
				int yuanshi2=getyuanshi(zhaxi,zhaxj);//接收
				if(daoju2){
					int a=daoju();
					map[zhaxi][zhaxj]=a;//箱子的位置为道具了 
				}else{
					map[zhaxi][zhaxj]=yuanshi2;//火焰的位置为原来的物体如果是草就变为 草 
					
				}
				
				int yuanshi3=getyuanshi(zhazi,zhazj);//接收
				if(daoju3){
					int a=daoju();
					map[zhazi][zhazj]=a;//箱子的位置为道具了 
				}else{
					map[zhazi][zhazj]=yuanshi3;//火焰的位置为原来的物体如果是草就变为 草 
					
				}

				int yuanshi4=getyuanshi(zhayi,zhayj);//接收
				if(daoju4){
					int a=daoju();
					map[zhayi][zhayj]=a;//箱子的位置为道具了 
				}else{
					map[zhayi][zhayj]=yuanshi4;//火焰的位置为原来的物体如果是草就变为 草 
					
				}
				//火焰范围增加范围后的
				int yuanshi11=getyuanshi(zhasi2,zhasj2);//接收
				if(daoju11){
					int a=daoju();//随机数
					map[zhasi2][zhasj2]=a;//箱子的位置为道具了 
				}else{
					map[zhasi2][zhasj2]=yuanshi11;//火焰的位置为原来的物体 草
					
				}
				int yuanshi22=getyuanshi(zhaxi2,zhaxj2);//接收
				if(daoju22){
					int a=daoju();
					map[zhaxi2][zhaxj2]=a;//箱子的位置为道具了 
				}else{
					map[zhaxi2][zhaxj2]=yuanshi22;//火焰的位置为原来的物体如果是草就变为 草 
					
				}
				int yuanshi33=getyuanshi(zhazi2,zhazj2);//接收
				if(daoju33){
					int a=daoju();
					map[zhazi2][zhazj2]=a;//箱子的位置为道具了 
				}else{
					map[zhazi2][zhazj2]=yuanshi33;//火焰的位置为原来的物体如果是草就变为 草 
					
				}
				int yuanshi44=getyuanshi(zhayi2,zhayj2);//接收
				if(daoju44){
					int a=daoju();
					map[zhayi2][zhayj2]=a;//箱子的位置为道具了 
				}else{
					map[zhayi2][zhayj2]=yuanshi44;//火焰的位置为原来的物体如果是草就变为 草 
					
				}
				}
				daoju1=false;
				daoju2=false;
				daoju3=false;
				daoju4=false;
				daoju11=false;
				daoju22=false;
				daoju33=false;
				daoju44=false;
				daoju111=false;
				daoju222=false;
				daoju333=false;
				daoju444=false;
				baowan=false;
				baowan4=true;
			}
		public int getyuanshi(int i,int j){
			//从地图中获取值 改变
			int value=map[i][j];
			if(value==hong||value==4){//炸弹和火焰变为草地
				value=caodi;
				
			}
			return value;//返回值
		}
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
					}else if(direction==upp){
							g.drawImage(img[9],left1,top,this);//炸弹
							zhadan=7;//让value获取为炸弹图片
							jiazhadan=7;//让value获取加道具炸弹图片
					}
				}else{
					g.drawImage(img[zhi],left1,top,this);
				}
				if(zhi==zha){//炸弹位置
					if(bao){
						g.drawImage(img[4],left1,top,this);//炸弹爆炸为火焰图片
						yige=false;//一个炸弹
						jiayige=false;//j加一个炸弹
					}
					bao=false;
				}
				if(zhi==4){//火焰位置 
					if(baowan3){
						g.drawImage(img[2],left1,top,this);//画草地覆盖火焰
						
						//System.out.println("dsfdsfds");
					}
					//baowan3=false;
				}
				
			}
		}
		
	}
	}
}

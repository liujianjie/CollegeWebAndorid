package QQGAME;
import java.awt.*;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.*;

import QQ���ݿ���Ϣ.QQgame;
import �ӿ�.QQuserInterface;
import ����ʵ�ֽӿ�.QQuserimp;
//�����߽ڶξͲ�Ҫ��repaint���������
//Ψһ��ȱ����� �����������������
public class Test����  extends JFrame{
	Random r;
	boolean gameover=false;//�˳�
	boolean caidan=false;//�����˵�
	//��
	int N=500;//�߽�
	int x[]=new int[N];
	int y[]=new int[N];
	boolean  food=false;/*1��ʾ��Ҫ������ʳ��,0��ʾ�Ѿ�����ʳ��*/
	int   direction=1;/*��������*/
	int 	foodx,foody;
	int i;
	int node=2;
	Image ima;
	Image ima1;
	Image ima2;
	JPopupMenu pop;//����ʽ�˵�
	JMenuItem itt1,itt2,itt3,itt4;
	QQgame game;
	QQuserInterface qseriver=new QQuserimp();
	boolean zai=false;
	public Test����(QQgame qqusergame,boolean zai){//�Ƿ������߽�
		super("̰����");
//		System.out.println(qqusergame.getQqname());
//		System.out.println(qqusergame.getQqnum());
		x[0]=100;y[0]=100;/*��ͷ��ʼλ��*/
		x[1]=120;y[1]=100;
		this.game = qqusergame;//��������Ϊ�� tuichu fenshu ��3���ļ�����
		//�������ص�
		if(zai){
			this.game=qseriver.shenode(qqusergame.getQqnum());//tmd���ڸ�������߽�//����ÿ�ζ������ݿ��е���ˣ�Ӧ������һ����ã��������Ǹ��±���Ľ��� ��������
			this.zai=zai;//�ж�Ҫ��Ҫ������ʷ�߽�
			node=game.getShenode();
	
			//����Ҳ���� ����ͷλ��
			x[0]=game.getShetoux0();y[0]=game.getShetouy0();/*��ͷ*/
			x[1]=game.getShetoux1();y[1]=game.getShetouy1();
			
			//��direction��ֵҲ�ı�
			direction=game.getDirection();
			System.out.println(game.getDirection());
		}
		Container a=getContentPane();
		setLayout(null);
		//������ɫ
		a.setBackground(Color.yellow);
		
		r=new Random();//�������
		this.setUndecorated(true);//�ޱ߿�
		//ʳ��
		//0-639
		foodx=r.nextInt(600)+20;
		//���ɵ�������Ҫ��10 �ı���(Ϊ�����߸�ʳ����һ������)
		while(foodx%20!=0){
			foodx++;
		}
		foody=r.nextInt(400)+40;
		while(foody%20!=0){
			foody++;
		}//��Ҫ��ʳ��
		//�oʳ������
		if(zai){
			foodx=game.getFoodx();
			foody=game.getFoody();
			food=true;
		}
		
		//������ֵ �ʹ���ֵ
		addKeyListener(new B());
		//����ͼƬ
		ima=Toolkit.getDefaultToolkit().getImage("img/121927760470B85A521856A8B42D13C7DB5CD07714.jpg");
		ima1=Toolkit.getDefaultToolkit().getImage("img/black.gif");
		ima2=Toolkit.getDefaultToolkit().getImage("img/1.png");
		setIconImage(ima2);//����ͼƬ

		//������
		pop=new JPopupMenu();
		itt1=new JMenuItem("�������");//��������
		itt2=new JMenuItem("�������");
		pop.add(itt1);
		pop.addSeparator();
		pop.add(itt2);
		pop.addSeparator();
		
		pop.addKeyListener(new B());
		setSize(840,680);
		setVisible(true);
		setLocationRelativeTo(null);//����
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	public void paint(Graphics g) {
	// TODO �Զ����ɵķ������
		super.paint(g);//���Ӧ���ǵ�����һ�� �����»� ����д���򲻻�ˢ��ÿһ֡ ����ͣ������
		if(food==true){
			//g.drawRect(foodx,foody,10,10);
			g.drawImage(ima,foodx,foody, this);//һֱ��ʳ��
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
			food=true;//���ʳ�����
		}
		for(i=node-1;i>0;i--){
			x[i]=x[i-1];
			y[i]=y[i-1];//�ߵ����긳����һ��
		}
		
		//snake.x[0]=snake.x[0]+10;�ߵ�ͷ��ǰ��
		if(direction==1){
				x[0]+=20;//����
		}
		if(direction==2){
				x[0]-=20;//����
		}
		if(direction==3){
				y[0]-=20;//����
		}
		if(direction==4){
				y[0]+=20;//����
		}
		
		//���ߵ�����//����Ҫ����ɫ
		for(i=0;i<node;i++){
			//g.drawRect(x[i],y[i],10,10);
			g.drawImage(ima1,x[i],y[i], this);
		}
		
		//��ʳ��
		if(x[0]==foodx&&y[0]==foody){
			node+=1;
			food=false;//���¸�ʳ�����
		}
		
		//�ӳ�
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
		// repaint();//ѭ��
		if(caidan){
			new tuichu(this);
			dispose();
		}
		repaint();//2018��4��9�� ���ڲ�֪����Ҫ��������������»滭 ��super��paint���� �ศ��ɣ�һ��ˢ�£�һ�����»滭
	}
	//��ֵ
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
